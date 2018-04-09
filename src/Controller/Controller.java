package Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;
import java.security.PublicKey;

public class Controller {
    @FXML
    Button placeButton=new Button(),transitionButton,arrowButton;

    public Controller(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("View\\sample.fxml"));
        loader.setRoot(this);
        loader.setController(this);
     

        placeButton.setOnMouseDragged(event -> {
            System.out.println("dragging...");
        });
    }

    public void test(){
        System.out.println("hifdfidjf");
    }


}
