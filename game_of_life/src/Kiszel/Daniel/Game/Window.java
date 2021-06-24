package Kiszel.Daniel.Game;

import Kiszel.Daniel.Shapes.ListCubes;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window implements MouseListener  {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width, height;
    public boolean clicked;
    public Window(String ti, int wi, int he){
        this.title = ti;
        this.width = wi;
        this.height = he;
        createDisplay();
    }
    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        canvas.addMouseListener(this);

        frame.add(canvas);

        frame.pack();
    }
    public Canvas getCanvas(){
        return canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public boolean isClicked() {
        return clicked;
    }
}
