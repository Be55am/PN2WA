package Controller;

import Model.Place;
import View.PlaceView;
import View.Position;

public class PlaceController {
    private Place place;
    private PlaceView view;

    public PlaceController(Place place){
        this.place=place;
        this.view=place.getView();


        view.setOnMouseDragged(event ->{
            view.relocate(event.getSceneX()-20,event.getSceneY()-90);

            Position p=place.getPosition();
            p.setPositionX(event.getSceneX()-20);
            p.setPositionY(event.getSceneY()-90);

            place.setPosition(p);


        } );


        view.setOnMouseReleased(event -> {
            Position p=place.getPosition();
            p.setPositionX(event.getSceneX()-20);
            p.setPositionY(event.getSceneY()-90);

            place.setPosition(p);


            view.relocate(p.getPositionX(),p.getPositionY());
        });
    }



}
