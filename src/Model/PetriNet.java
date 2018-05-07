package Model;

import java.util.ArrayList;

public class PetriNet {


    private int pre[][];
    private int post[][];
    private int c[][];

    private Marking marking=new Marking();

    private String placesNames [];
    private String transitionsNames [];
    private String events[];
    private String name;

    public PetriNet(int placeNbr,int transitionNbr,String name){
        this.name=name;
        this.pre=new int [placeNbr][transitionNbr];
        this.post=new int [placeNbr][transitionNbr];
        this.placesNames=new String[placeNbr];
        this.transitionsNames=new String[transitionNbr];
        this.events=new String[transitionNbr];

    }

    /**
     * this methode name the place in the matrix
     * @param name
     * @param pos
     */
    public void placesNaming(String name,int pos){
        placesNames[pos]=name;

    }
    public void transitionsNaming(String name,int pos){
        transitionsNames[pos]=name;

    }

    /**
     * this methode put the event in the correspandant collumn in the transition place
     * @param transitionName
     * @param eventName
     */
    public void setEventsByNames(String transitionName,String eventName){
        for(int i=0;i<transitionsNames.length;i++){
            if(transitionName.equals(transitionsNames[i])){
                this.events[i]=eventName;
            }
        }
    }

    //todo when you adding a table that doesnt have the same length gonna crate a problem
    public void setEvents(String []events){
        System.out.println("warning by lee :using the method setEvents(String []) is risky !");
        this.events=events;
    }
    public void setPre(int[][] pre) {

        for(int i=0;i<pre.length;i++){
            for(int j=0;j<pre[0].length;j++){
                if(pre[i][j]<0){
                    System.out.println("Error :numbers in the matrix should be positive by lee");

                }
            }
        }

        this.pre = pre;
    }
    public void setPost(int[][] post) {
        for(int i=0;i<post.length;i++){
            for(int j=0;j<post[0].length;j++){
                if(post[i][j]<0){
                    System.out.println("Error :numbers in the matrix should be positive by lee");

                }
            }
        }
        this.post = post;
    }
    public void setMarking(Object [] marking){
        if(this.placesNames.length==marking.length){
            this.marking.setMarking(marking);
        }
        else
            System.out.println("error the marking matrix isn't the same length with the places nbr !\n");

    }
    public Marking getMarking(){
        return this.marking;
    }
    public String[] getMarkingS(){
        String[] res=new String[marking.getLength()];
        for (int i=0;i<marking.getLength();i++) {
            res[i]= String.valueOf(marking.getMarking().indexOf(i));
        }
        return res;
    }
    public void setPlacesNames(String[] placesNames) {
        this.placesNames = placesNames;
    }
    public void setTransitionsNames(String[] transitionsNames) {
        this.transitionsNames = transitionsNames;
    }
    /**
     * return the associated transitions
     * @param event
     * @return
     */
    public ArrayList<String> getAssociatedTransitions(String event){
        ArrayList<String> result=new ArrayList();
        for(int i=0;i<events.length;i++){
            if(event.equals(events[i])){
                result.add(transitionsNames[i]);
            }
        }
        return result;
    }
    public int[][] cCalc(){
        c=new int[pre.length][pre[0].length];
        for(int i=0;i<pre.length;i++){
            for(int j=0;j<pre[0].length;j++){
                c[i][j]=post[i][j]-pre[i][j];
            }
        }
        return c;
    }
    /**
     * return a list of Marking
     * @param m
     * @return
     */
    public ArrayList<Marking> getEnabledTransitions(Marking m){

        ArrayList enabledTrans=new ArrayList();
        //calculating the sum


        int some=0;
        for(int i=0;i<c.length;i++ ) {
            Marking res=new Marking();
            for (int j = 0; j < c[0].length; j++) {

               if((m.getMarking().get(i)) instanceof wMarking) {


                   res.addMarking("W");
               }
               else {

                   some = (Integer) m.getMarking().get(j) + c[i][j];
                   res.addMarking(some);
               }

            }

            // verefiying if all the marks are positive and adding the transition to the list
            boolean neg=false;
            for (Object o:res.getMarking()) {
                if(o instanceof String){

                    // in case the marking is already a w
                    // todo i dont know what to do here

                }else{
                    int t=(int)o;
                    if(t<0){
                        neg=true;
                    }
                }
            }

            if(!neg) {
                String name=transitionsNames[i];
                res.setName(name);
                enabledTrans.add(res);
            }

        }

        return enabledTrans;


    }
    /**
     * return a list of enabled events of this marking in this net
     * @param m
     * @return
     */
    public ArrayList getEventHavingEnabledT(Marking m){
        this.getEnabledTransitions(m);
        ArrayList events=new ArrayList();
        ArrayList enabledTransitions=this.getEnabledTransitions(m);

        Marking ma=null;
        for(int i=0;i<enabledTransitions.size();i++){
            ma=(Marking) enabledTransitions.get(i);
            String transition=ma.getName();
            String e="";
            for(int j=0;j<transitionsNames.length;j++){
                if(transitionsNames[j].equals(transition)){
                    e=this.events[j];
                }
            }
            if(!events.contains(e)){
                events.add(e);
            }
        }
        return events;
    }
    public int[][] getPre() {
        return pre;
    }
//    public Marking executeEvent(Marking m,String e){
//        boolean en=false;
//        ArrayList enabledTransitions=this.getEnabledTransitionsForE(e,m);
//
//        //totally enabled
//       if(this.getAssociatedTransitions(e).size()==enabledTransitions.size()){
//
//       }
//
//    }

    public ArrayList getEnabledTransitionsForE(String event,Marking m){
        ArrayList<Marking> enabledTransitions=this.getEnabledTransitions(m);
        ArrayList<String> enabledAtE=this.getAssociatedTransitions(event);
        ArrayList<String> res=new ArrayList<>();
        for (int i=0;i<enabledTransitions.size();i++){
            String transition=enabledTransitions.get(i).getName();
            if(enabledAtE.contains(transition)){
                res.add(transition);
            }

        }
        return res;
    }
    /**
     * this methode combine the execution of multiple transitions in one time and if there
     * is a w mark it will leave it as it is.
     * @param transitions
     * @param m
     * @return
     */
    public Marking executeTransitions(ArrayList<String> transitions,Marking m){

        // verifing if the event is partially enabled or not


        int[] combinedC=new int[m.getMarking().size()];
        Marking result=new Marking();

        //selecting the transitions we wanna execute and then we calculate the some of the C
        for(int x=0;x<combinedC.length;x++) {
            combinedC[x]=0;
            for (int i = 0; i < transitions.size(); i++) {
                int k=0;
                boolean b=true;
                while (k<transitionsNames.length&b){
                    if(transitionsNames[k].equals(transitions.get(i))){
                        combinedC[x]+=c[k][x];
                        b=false;
                    }
                    k++;
                }

            }
        }

        // we calculate the result of the execution
        for(int i=0;i<combinedC.length;i++){
            if(m.getMarking().get(i) instanceof Integer){
                int res=(Integer) m.getMarking().get(i)+combinedC[i];
                result.addMarking(res);
            }else{
                result.addMarking("w");
            }
        }


        return result;




    }

    /**
     * return the String that describes the petri net with post and pre matrix
     * @return
     */
    public String toString(){
        String result="name: "+this.name+"\n";
        result+="pre :\n";
        for(int i=0;i<this.placesNames.length;i++){
            result+="   "+this.placesNames[i]+"";
        }
        result+="\n";
       for(int i=0;i<this.transitionsNames.length;i++){
           result+=this.transitionsNames[i]+"";
           if(this.events[i]=="")
               result+="   ";
           else
               result+=":"+this.events[i]+" ";
           for(int j=0;j<placesNames.length;j++){
               result+=this.pre[i][j]+"   ";
           }
           result+="\n";
       }

        result+="\n";

        result+="post :\n";
        for(int i=0;i<this.placesNames.length;i++){
            result+="   "+this.placesNames[i]+"";
        }
        result+="\n";
        for(int i=0;i<this.transitionsNames.length;i++){
            result+=this.transitionsNames[i]+"";
            if(this.events[i]=="")
                result+="   ";
            else
                result+=":"+this.events[i]+" ";
            for(int j=0;j<placesNames.length;j++){
                result+=this.post[i][j]+"   ";
            }
            result+="\n";

        }
        result+="initial marking :\n";
        try{

            for(int i=0;i<this.marking.getLength();i++){
                result+="   "+this.marking.getMarking().get(i) ;
            }
        }catch (Exception e){
            System.out.println("not initialized !");
        }

        result+="\n";

        return result;
    }
}
