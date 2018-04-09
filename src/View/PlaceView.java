package View;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PlaceView extends Group implements ShapeView{

    Circle circle;
  // Rectangle circle;
    Label label;
    Text text;

    public PlaceView(Position position,String name){
        circle=new Circle(position.getPositionX(),position.getPositionY(),20);

       circle.setBlendMode(BlendMode.BLUE);
        circle.setOpacity(54);
        circle.setStroke(Color.BLACK);
         text=new Text(position.getPositionX()-15,position.getPositionY()+30,name);
        // circle.setFill(null);

        getChildren().addAll(circle,text);

    }

    @Override
    public void drow(Pane pane) {



        pane.getChildren().add(this);

    }
}
