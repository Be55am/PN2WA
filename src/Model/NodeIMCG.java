package Model;

public class NodeIMCG {

    private String name=null;
    private int placesNbr;
    private Marking marking;
    private boolean isNew=false;

    public NodeIMCG(Marking marking){
        this.placesNbr=marking.getLength();
        this.marking=marking;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public boolean isEqual(NodeIMCG node){
        if(this.placesNbr==node.placesNbr){
            for(int i=0;i<placesNbr;i++){
                if(!this.marking.getMarking().get(i).equals(node.marking.getMarking().get(i))){
                    return false;
                }

            }
            return true;
        }
        else
            return false;
    }

    public void setPlacesNbr(int placesNbr) {
        this.placesNbr = placesNbr;

    }

    public void setMarking(Marking marking) {
        this.marking = marking;
    }
    public Marking getMarking(){
        return marking;
    }

    public boolean isNew(){
        return isNew;
    }

    /**
     * true if it is new else false
     * @param tag
     */
    public void setNewTag(boolean tag){
        this.isNew=tag;
    }

    public boolean haslowerMarking(NodeIMCG node2){
        return this.marking.lowerMarking(node2.marking.getMarking());
    }



    public String toString(){
        String result="";
        result+="<Node:"+this.getName()+" marking :[";
        for ( int i=0;i<this.getMarking().getMarking().size();i++) {
            String m=String.valueOf(this.getMarking().getMarking().get(i));
            result+=m+" ";
        }
        result+="]>\n";
        return result;
    }


}
