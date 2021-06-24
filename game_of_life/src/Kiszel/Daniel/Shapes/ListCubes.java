package Kiszel.Daniel.Shapes;

import java.awt.*;
import java.util.ArrayList;
import java.awt.MouseInfo;



public class ListCubes  {
    ArrayList<Cubes>[][] myList = new ArrayList[80][160];
    private double mouseY,mouseX;
    private int neighbours;
    private boolean click = false;

    public void myCubes(){
        for (int y = 5, i = 0; y < 800; y += 10, i++) {
            for (int x = 5, j = 0; x < 1600; x += 10, j++) {
                myList[i][j] = new ArrayList<Cubes>();
                myList[i][j].add(new Cubes(x, y, 9, 9));
            }
        }
        /**
         * madár#1
         */
        getMyCubes(10,40).setLive(true);
        getMyCubes(10,41).setLive(true);
        getMyCubes(11,39).setLive(true);
        getMyCubes(11,43).setLive(true);
        getMyCubes(12,44).setLive(true);
        getMyCubes(12,38).setLive(true);
        getMyCubes(13,38).setLive(true);
        getMyCubes(14,38).setLive(true);
        getMyCubes(15,39).setLive(true);
        getMyCubes(16,40).setLive(true);
        getMyCubes(16,41).setLive(true);
        getMyCubes(15,43).setLive(true);
        getMyCubes(14,44).setLive(true);
        getMyCubes(13,44).setLive(true);
        getMyCubes(13,45).setLive(true);
        getMyCubes(13,42).setLive(true);
        /**
         * madár 2
         */
        getMyCubes(12,48).setLive(true);
        getMyCubes(11,48).setLive(true);
        getMyCubes(10,48).setLive(true);
        getMyCubes(12,49).setLive(true);
        getMyCubes(11,49).setLive(true);
        getMyCubes(10,49).setLive(true);
        getMyCubes(13,50).setLive(true);
        getMyCubes(9,50).setLive(true);

        getMyCubes(9,52).setLive(true);
        getMyCubes(8,52).setLive(true);
        getMyCubes(13,52).setLive(true);
        getMyCubes(14,52).setLive(true);



        /**
        kocka 1#
         */
        getMyCubes(12,29).setLive(true);
        getMyCubes(13,29).setLive(true);
        getMyCubes(12,28).setLive(true);
        getMyCubes(13,28).setLive(true);
        /**
         * kocka 2#
         */
        getMyCubes(10,62).setLive(true);
        getMyCubes(11,62).setLive(true);
        getMyCubes(10,63).setLive(true);
        getMyCubes(11,63).setLive(true);
    }
    public Cubes getMyCubes(int y,int x){
        return myList[y][x].get(0);

    }


    public void mouseMove(){
         mouseX = MouseInfo.getPointerInfo().getLocation().getX()-160;
         mouseY = MouseInfo.getPointerInfo().getLocation().getY()-140;


    }
    public void boundsCheck(){
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 160; j++) {
                if (getMyCubes(i, j).getBounds().contains(mouseX,  mouseY ) && click ) {
                    getMyCubes(i, j).setLive(true);
                    getMyCubes(i,j).setNeighbors(neighbours(i,j));
                    getMyCubes(i,j).setSign(false);

                }

            }
        }
    }


    public  void render(Graphics g) {
        for(int i = 0; i < 80; i++){
            for(int j = 0; j < 160; j++){
                getMyCubes(i,j).drawCube(g);
            }
        }
    }
    public int neighbours(int a,int b){
        neighbours = 0;
        for(int y = a-1; y < a+2; y++) {
            for (int x = b-1; x < b+2; x++) {
                if(a == y && b == x){
                    continue;
                }
                if(getMyCubes(y,x).isLive()){
                    neighbours += 1;
                }
            }
        }
        return neighbours;
    }

    public void count_neighbours(){
        for(int y = 1; y < 77; y++){
            for(int x = 1; x < 157; x++){
                    getMyCubes(y,x).setNeighbors(neighbours(y,x));
                }
            }
        }


    public void rules_1_sign(){
        for(int y = 0; y < 77; y++){
            for(int x = 0; x < 157; x++){
                if(getMyCubes(y,x).getNeighbors() < 2 || getMyCubes(y,x).getNeighbors() > 3){
                    getMyCubes(y,x).setSign(true);
                }
                if(getMyCubes(y,x).getNeighbors() == 3 ){
                    getMyCubes(y,x).setLive(true);

                }
            }
        }
    }
    public void rules_2_born(){
        for(int y = 0; y < 77; y++){
            for(int x = 0; x < 157; x++){
                if(getMyCubes(y,x).getNeighbors() == 3 ){
                    getMyCubes(y,x).setLive(true);
                    getMyCubes(y,x).setSign(false);

                }
            }
        }
    }
    public void rules_3_signed_kill(){
        for(int y = 0; y < 77; y++) {
            for (int x = 0; x < 157; x++) {
                if(getMyCubes(y,x).isSign()){
                    getMyCubes(y,x).setLive(false);
                }
            }
        }
    }

    public void nextGeneration() {
        count_neighbours();
        rules_1_sign();
        rules_2_born();

        rules_3_signed_kill();
    }

    public void update() {
        mouseMove();
        boundsCheck();

    }

    public void setClick(boolean click) {
        this.click = click;
    }
    public boolean isClick() {
        return click;
    }


}
