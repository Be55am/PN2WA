package sample;

import Model.*;
import View.Position;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

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

        //------------------------

        //the cration of the object place
        Place shape1=new Place(new Position(100,100),"P1");
        Place shape2=new Place(new Position(200,200),"P2");

        //the creation of the object transition
        Transition t1=new Transition(new Position(300,300),"T1");

        //the arrows or the lines that connects shapes
        Arrow arrow= new Arrow(shape1,t1);
        Arrow arrow2= new Arrow(t1,shape2);


        Graph graph=new Graph();
        graph.addArrow(arrow);
        graph.addArrow(arrow2);
        graph.addPlace(shape1);
        graph.addPlace(shape2);
        graph.addTransition(t1);
        graph.paint(pane);


        //-----------------------
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
