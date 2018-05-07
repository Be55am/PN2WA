package Model;

import java.util.ArrayList;

public  class Transformator {


    public static IMCG generateIMCG(PetriNet net){

        // initiating some variables
        ArrayList<Place> unboundedPlaces=new ArrayList<>();
        ArrayList<NodeIMCG> newNodes=new ArrayList<>();

        //the initial marking made into the first node .
        NodeIMCG firstNode=new NodeIMCG(net.getMarking());
        firstNode.setNewTag(true);
        firstNode.setName("M0");

        //adding the first node to the tree
        IMCG tree=new IMCG("result");
        tree.addNode(firstNode);


        while (tree.isthereNewNodes()){
            NodeIMCG node=tree.getNodeTaggedNew();
            node.setNewTag(false);

            //for all the events that have enabled marking
            for(int i=0;i<net.getEventHavingEnabledT(node.getMarking()).size();i++){
                String enabledEvent=(String)net.getEventHavingEnabledT(node.getMarking()).get(i);

                ArrayList<String> listExecutedTransitions=net.getAssociatedTransitions(enabledEvent);

                //the new generated marking
                Marking nextMark=net.executeTransitions( listExecutedTransitions,node.getMarking());

                NodeIMCG newNode=new NodeIMCG(nextMark);

                //newNode.setName("M"+i);


                //cheking if the new node is new
                if(tree.isThisNodeExist(newNode)){
                    //the node isnt new

                    newNode.setNewTag(false);
                }else{
                    //the node is new


                    newNode.setNewTag(true);
                    tree.addNode(newNode);
                    newNodes.add(newNode);

                }


                //adding the connection to the tree
                ConnectionIMCG newConnection=new ConnectionIMCG(node,newNode,listExecutedTransitions);
                tree.addConnection(newConnection);


            }
                //2.2.2






        }





        return tree;
    }

    public static boolean duplicationCheck(NodeIMCG node,IMCG graph){
        node.setNewTag(true);
      for(int i=0;i<graph.getNodes().size();i++){
          NodeIMCG n=(NodeIMCG)graph.getNodes().get(i);
          if(node.isEqual(n)){
              node.setNewTag(false);
          }

      }

        return node.isNew();
    }






}
