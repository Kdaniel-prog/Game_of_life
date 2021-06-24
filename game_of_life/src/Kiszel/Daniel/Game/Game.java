package Kiszel.Daniel.Game;
import Kiszel.Daniel.Shapes.ListCubes;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Window display;
    private ListCubes listCubes = new ListCubes();

    private int width, height;
    private ListCubes myCubes;
    public String title;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height){
        this.width = width;
        this. height = height;
        this.title = title;
    }
    private void nextGeneration(){
        listCubes.nextGeneration();
    }
    private void init() {
        display = new Window(title, width, height);
        listCubes = new ListCubes();
        listCubes.myCubes();
    }
    private void update() {

        listCubes.update();
        if(display.isClicked()){
            listCubes.setClick(true);
        }else{
            listCubes.setClick(false);
        }

    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);
        g.setColor(Color.black);
        g.fillRect(0,0,width,height);
        listCubes.render(g);

        bs.show();
        g.dispose();
    }
    public void run() {
            init();
            int fps = 60;
            double timePerUpdate = 1000000000 / fps;
            double delta = 0,deltab = 0;
            long now;
            long lastTime = System.nanoTime();

            while (running) {
                now = System.nanoTime();
                delta += (now - lastTime) / timePerUpdate;
                deltab += (now - lastTime) / timePerUpdate;
                lastTime = now;
                if (delta >= 1) {
                    update();
                    render();
                    delta = 0;
                }
                if(deltab>=5){
                    nextGeneration();
                    deltab = 0;
                }
            }
    }

    public synchronized void start(){

        if(running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

}
