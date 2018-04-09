package Model;


import View.ArrowView;
import View.Position;
import javafx.scene.layout.Pane;

import java.awt.*;

public class Arrow {

   private Shape startingShape,endingShape;
   private ArrowView arrowView;
   Position start,end;

    public Arrow(Shape startingShape,Shape endingShape){
        setStartingShape(startingShape);
        setEndingShape(endingShape);
        start=startingShape.getPosition();
        end=endingShape.getPosition();
        this.arrowView=new ArrowView(start.getPositionX(),start.getPositionY(),end.getPositionX(),end.getPositionY());


    }

    public Shape getStartingShape() {
        return startingShape;
    }

    public void setStartingShape(Shape startingShape) {
        this.startingShape = startingShape;
    }

    public Shape getEndingShape() {
        return endingShape;
    }

    public void setEndingShape(Shape endingShape) {
        this.endingShape = endingShape;
    }

    public void paint(Pane pane){
        pane.getChildren().add(arrowView);

    }
    public void relocate(Pane pane){

        pane.getChildren().remove(arrowView);
        arrowView=new ArrowView(start.getPositionX()+20,start.getPositionY()+20,end.getPositionX()+20,end.getPositionY()+20);
        pane.getChildren().add(arrowView);
    }
}
