package Model;

import Controller.TransitionController;
import View.Position;
import View.TransitionView;
import javafx.scene.layout.Pane;

public class Transition extends Shape {
    TransitionView trasitionView;

    /**
     * this class generate the transitions
     * @param position
     * @param name
     */
    public Transition(Position position,String name) {
        super(position);
        trasitionView=new TransitionView(position,name);

        TransitionController controller=new TransitionController(this);
    }

    /**
     * paint the transition view object in the given pane
     * @param pane
     */
    public void paint(Pane pane){
        trasitionView.drow(pane);
    }

    /**
     *
     * @return the view of this transition
     */
    public TransitionView getTrasitionView() {
        return trasitionView;
    }
}
