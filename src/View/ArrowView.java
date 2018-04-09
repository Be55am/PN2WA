package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author kn
 */
public class ArrowView extends Path{
    private static final double defaultArrowHeadSize = 5.0;
    private double startX,startY,endX,endY;

    private static final double RADIUS=15;


    public ArrowView(double startX, double startY, double endX, double endY, double arrowHeadSize){
        super();

        //the added code
        this.startX=startX;
        this.startY=startY;
        this.endX=endX;
        this.endY=endY;

        strokeProperty().bind(fillProperty());
        setFill(Color.BLACK);

        //Line
        getElements().add(new MoveTo(startX, startY));
        getElements().add(new LineTo(endX, endY));

        //ArrowHead
        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        //point1
        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        //point2
        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;

        getElements().add(new LineTo(x1, y1));
        getElements().add(new LineTo(x2, y2));
        getElements().add(new LineTo(endX, endY));

       // initialize();
    }

    public ArrowView(double startX, double startY, double endX, double endY){
        this(startX, startY, endX, endY, defaultArrowHeadSize);
    }


//todo this methode suppose to fix the problem of the arc but it fucks things up
    private void initialize() {
        double angle = Math.atan2(endY - startY, endX - startX) * 180 / 3.14;

        double height = endY - startY;
        double width = endX - startX;
        double length = Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));

        double subtractWidth = RADIUS * width / length;
        double subtractHeight = RADIUS * height / length;

        setRotate(angle );
        setTranslateX(startX);
        setTranslateY(startY);
        setTranslateX(endX - subtractWidth);
        setTranslateY(endY - subtractHeight);
    }


}