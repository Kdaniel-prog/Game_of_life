package Kiszel.Daniel.Shapes;

import java.awt.*;


public  class Cubes {

    private boolean isLive = false;
    private boolean isSign = false;
    private int startWidth;
    private int startHeight;
    private int width;
    private int height;
    protected Rectangle bounds;



    private int neighbors;

    public Cubes(int startWidth,int startHeight, int width, int height){
        this.startWidth = startWidth;
        this.startHeight = startHeight;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(startWidth, startHeight, width, height);

    }

    public void drawCube(Graphics g){
        if(isLive){
            g.setColor(Color.white);
        }else{
            g.setColor(Color.black);
        }
        g.fillRect(this.startWidth,this.startHeight,this.width,this.height);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public String toString(){
        return "Width: "+startWidth +"\nHeigth: "+startHeight;
    }

    public int getStartWidth() {
        return this.startWidth;
    }

    public void setStartWidth(int startWidth) {
        this.startWidth = startWidth;
    }

    public int getStartHeight() {
        return this.startHeight;
    }

    public void setStartHeight(int startHeight) {
        this.startHeight = startHeight;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return this.height;
    }

    public void setHeigth(int heigth) {
        this.height = heigth;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }
    public int getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(int neighbors) {
        this.neighbors = neighbors;
    }
}
