package Model;

import View.Position;

/**
 * the mother class for the objects Place and Transition
 */
public class Shape {
    private Position position;




    public Shape(Position position){
        this.position=position;
    }




    public Position getPosition() {
        return position;
    }



    public void setPosition(Position position) {
        this.position= position;

    }


}
