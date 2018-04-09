package View;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class TransitionView extends javafx.scene.Group implements ShapeView{

    Position position;
    Rectangle rectangle ;
    Text text;

    public TransitionView(Position position,String name){
        super();
        this.position=position;
        rectangle=new Rectangle(position.getPositionX(),position.getPositionY(),35,20);
        rectangle.setStroke(Color.CHARTREUSE);
        rectangle.setFill(Color.WHITE);
        rectangle.setArcHeight(15);
        rectangle.setArcWidth(15);
        text=new Text(position.getPositionX()+10,position.getPositionY()+35,name);

      getChildren().addAll(rectangle,text);

    }

    @Override
    public void drow(Pane pane) {

        pane.getChildren().addAll(this);

    }
}
