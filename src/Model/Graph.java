package Model;

import javafx.scene.layout.Pane;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Graph {

    ArrayList<Arrow> arrows=new ArrayList<Arrow>();
    ArrayList<Place> places=new ArrayList<Place>();
    ArrayList<Transition>transitions=new ArrayList<Transition>();
    private  Pane pane;


    public void addPlace(Place place){
        places.add(place);
        place.getPosition().connect(this);
    }
    public void addTransition(Transition transition){
        transitions.add(transition);
        transition.getPosition().connect(this);
    }

    public void addArrow(Arrow arrow){
        arrows.add(arrow);
    }

    public void deleteShape(Shape shape){
        places.remove(shape);
    }


    public void paint(Pane pane){
        this.pane=pane;

        for (Arrow arrow:arrows) {

            arrow.paint(pane);

        }
        for (Place place:places){
            place.paint(pane);
        }
        for(Transition transition:transitions){
            transition.paint(pane);
        }
    }

    public void refrech(){

        for (Arrow arrow:arrows) {

            arrow.relocate(pane);

        }
        /*
        for (Place place:places){
            place.paint(pane);
        }
        for(Transition transition:transitions){
            transition.paint(pane);
        }
        */

    }






    public ArrayList<Arrow> getArrows() {
        return arrows;
    }

    public void setArrows(ArrayList<Arrow> arrows) {
        this.arrows = arrows;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }


    public void deleteArrow(Arrow arrow){
        arrows.remove(arrow);

    }
}
