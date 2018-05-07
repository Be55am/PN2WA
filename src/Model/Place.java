package Model;

import Controller.PlaceController;
import View.PlaceView;
import View.Position;
import javafx.scene.layout.Pane;

/**
 * its a class for the places
 */
public class Place extends Shape{

    private PlaceView view;




    public Place(Position position,String name) {
        super(position);
        view=new PlaceView(position,name);

        PlaceController controller=new PlaceController(this);


    }

    public PlaceView getView() {
        return view;
    }


    public void paint(Pane pane){
        view.drow(pane);
    }


}
