package Model;

import java.util.ArrayList;

public class Marking {

    private String name;
    private ArrayList markingList;

    public String getName() {
        return name;
    }

    /**
     * if this marking contains W returns true
     * @return
     */
    public boolean isWmarking(){
        for (Object o:markingList) {
            if(o instanceof wMarking){
                return true;
            }
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Marking(ArrayList marking) {
        this.markingList = marking;
    }
    public Marking(){
        markingList=new ArrayList();
    }

    public void addMarking(Object m){
        this.markingList.add(m);
    }

    public int getLength(){
        return markingList.size();
    }

    public ArrayList getMarking() {
        return markingList;
    }

    public void setMarking(ArrayList marking) {
        this.markingList = marking;
    }

    public void setMarking(Object[] mark){
        for (Object x:mark) {
            this.markingList.add(x);
        }
    }

    public boolean lowerMarking(ArrayList mark2){
        for(int i=0;i<this.markingList.size();i++){
            if(markingList.get(i) instanceof wMarking){
                if(mark2.get(i) instanceof wMarking){
                    // the tow places have a w marking

                    wMarking mp1=(wMarking) markingList.get(i);
                    wMarking mp2=(wMarking) mark2.get(i);
                    if(mp1.getK()<mp2.getK()){

                    }else if(mp1.getK()==mp2.getK()){
                        if(mp1.getR()<mp2.getR()){

                        }else
                            return false;
                    }else
                        return false;
                }
                else{
                    // the first marking with a w number
                    return false;
                }
            }else{
                if(mark2.get(i) instanceof wMarking ){
                    //the second marking with a w number
                }
                else {
                    // none of the places have a w number
                    int mp1=(int) markingList.get(i);
                    int mp2=(int) mark2.get(i);
                    if(mp1>mp2){
                        return false;
                    }
                }
            }

        }
        return true;
    }


//    public boolean isunbounded(){
//        for (Object m:marking) {
//            if(m.getClass().toString()=="String"){
//
//            }
//        }
//    }


}
