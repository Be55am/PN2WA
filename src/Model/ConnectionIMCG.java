package Model;

import java.util.ArrayList;

public class ConnectionIMCG {

    private NodeIMCG startNode;
    private NodeIMCG endNode;
    //the transition executed that resulted this connection.
    private ArrayList<String> transitions;

    public ConnectionIMCG(NodeIMCG startNode,NodeIMCG endNode,ArrayList<String> transitions){
        setStartNode(startNode);
        setEndNode(endNode);
        setTransitions(transitions);

    }

    public void setStartNode(NodeIMCG startNode) {
        this.startNode = startNode;
    }

    public void setEndNode(NodeIMCG endNode) {
        this.endNode = endNode;
    }
    public void setTransitions(ArrayList transitions){
        this.transitions=transitions;
    }
    public ArrayList<String> getTransitions(){
        return transitions;
    }

    public NodeIMCG getStartNode() {
        return startNode;
    }

    public NodeIMCG getEndNode() {
        return endNode;
    }

    public String toString(){
        String result="<link:[";
        Marking startMark=startNode.getMarking();
        for(int i=0;i<startMark.getMarking().size();i++){
            String m=String.valueOf(startMark.getMarking().get(i));
            result+=m+" ";
        }

        result+="]-->[";



        for(int i=0;i<endNode.getMarking().getMarking().size();i++) {

            result+=String.valueOf(endNode.getMarking().getMarking().get(i))+" ";
        }

        result+="] transitions:{";
        for (String t:transitions) {
            result+=t+" ";
        }
        result+="} >\n";

        return result;

    }


}
