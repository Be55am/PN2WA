package sample;

import Controller.Controller;
import Model.*;
import View.Position;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * the main class of the project every thing starts here
 *
 */
public class Main extends Application {

    Pane pane;
    @Override

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene=new Scene(root,700,550);
        primaryStage.setScene(scene);
        pane=(Pane) scene.lookup("#mainPanel");

        Graph graph=new Graph();

        //Controller controller=new Controller(graph);

        //------------------------

        //the cration of the object place
        Place shape1=new Place(new Position(100,100),"P1");
        Place shape2=new Place(new Position(200,200),"P2");

        //the creation of the object transition
        Transition t1=new Transition(new Position(300,300),"T1");

        //the arrows or the lines that connects shapes
        Arrow arrow= new Arrow(shape1,t1);
        Arrow arrow2= new Arrow(t1,shape2);

        //ADDING elements to the graph

        graph.addArrow(arrow);
        graph.addArrow(arrow2);
        graph.addPlace(shape1);
        graph.addPlace(shape2);
        graph.addTransition(t1);

        //adding the graph to the pane
        graph.paint(pane);


        //-----------------------
        primaryStage.show();



    }


    public static void main(String[] args) {
       // launch(args);
        PetriNet petri =new PetriNet(2,2,"petri");
        int pre[][]={{1,0,0},{1,1,0}};
        int post[][]={{0,1,0},{0,0,1}};
        String[] placesNames={"p1","p2","p3"};
        String[] transitionsNames={"t1","t2"};
        String[] events={"a","b"};
        Object[] marking={2,1,0};
        petri.setPlacesNames(placesNames);
        petri.setTransitionsNames(transitionsNames);
        petri.setEvents(events);
        petri.setMarking(marking);
        petri.setPre(pre);
        petri.setPost(post);
        petri.cCalc();

        System.out.println( petri.toString());

        IMCG tree=Transformator.generateIMCG(petri);

        System.out.println( tree.toString());


//        Marking m=new Marking();
//        m.addMarking(2);
//        m.addMarking(1);
//        m.addMarking(0);
//        ArrayList test=petri.getEnabledTransitions(m);
//        for(int d=0;d<test.size();d++){
//            Marking md=(Marking) test.get(d);
//            System.out.println("transitions: "+md.getName()+"\n");
//        }











    }
}
