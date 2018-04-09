package Controller;

import Model.Graph;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Pane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintingPaneControl implements MouseMotionListener,MouseListener {
    private Pane pane;
    private Graph graph=new Graph();


    public PaintingPaneControl(Pane pane){

        this.pane=pane;

    }

    @Override
    public void mouseDragged(MouseEvent e) {


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
