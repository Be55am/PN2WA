package Model;

import java.util.ArrayList;


public class IMCG {

    private String name;
    private ArrayList<NodeIMCG> nodes=new ArrayList<NodeIMCG>();
    private ArrayList<ConnectionIMCG> links=new ArrayList<>();

    public IMCG(String name){
        this.name=name;
    }

    public void addNode(NodeIMCG newNode){
        this.nodes.add(newNode);
    }
    public void addConnection(ConnectionIMCG connection){
        this.links.add(connection);
    }
    public ArrayList<NodeIMCG> getNodes(){
        return this.nodes;
    }

    public NodeIMCG getNodeTaggedNew(){
        for (NodeIMCG node:nodes) {
            if(node.isNew())
                return node;
        }
        System.out.println("Error no nodes tagged new found something wrong  !");
        return null;
    }

    /**
     * verify the existence of new nodes in the graph
     * @return
     */
    public boolean isthereNewNodes(){
        for (NodeIMCG node:nodes) {
            if(node.isNew())
                return true;
        }
        return false;
    }

    public String toString(){
        String result="the IMCG tree : \n";
        result +="<Tree:"+this.name+">\n";
        for (NodeIMCG node:nodes) {

            result+="   "+node.toString();
            
        }
        for (ConnectionIMCG connection:links) {
            result+="   "+connection.toString();
        }


        result+="</Tree>";
        return result;
    }

    public boolean isThisNodeExist(NodeIMCG node){
        for (NodeIMCG oldNode:nodes ) {
            if(oldNode.isEqual(node)){
                return true;
            }
        }
        return false;
    }
    //todo complete this method
    public NodeIMCG getQbar(NodeIMCG qPrim,NodeIMCG q2prim,ArrayList<String> newTransitions){
        for (ConnectionIMCG connection:links) {
           ArrayList<String>oldTransition= connection.getTransitions();
           if(oldTransition.equals(newTransitions)){

           }

        }
    return null;
    }

}
