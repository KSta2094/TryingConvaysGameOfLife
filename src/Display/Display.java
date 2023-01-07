package Display;

import Game.Cheack;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Display extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public Thread thread;

    public static JFrame frame = new JFrame();
    public static String title ="Convays_Game_Of_Life ";
    public static final int WIDHT = 1000;
    public static final int HEIGHT = 1000;
    public static boolean running = false;
    public static int frames = 0;
    public static  int FPS = 0;
    private Random random = new Random();
    public static int[][] screen = new int[WIDHT][HEIGHT];
    public Graphics graph;

   public static Threads threads = new Threads();
   public static DrawingThread drawingThread = new DrawingThread();

    Cheack cheack = new Cheack();
    public Display(){

        for (int i = 0; i < WIDHT; i++) {
            for (int j = 0; j < WIDHT; j++) {
                screen[i][j] =  0;//random.nextInt(2);
            }
        }




    }


    public synchronized void start() {
        running = true;
        this.thread = new Thread(this,"Display");

        this.thread.start();

    }

    public synchronized void stop() {

        running = false;
        try {
            this.thread.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }



    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / FPS;
        double delta  = 0;




        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta --;

                render();

                frames++;
            }


            if (System.currentTimeMillis() - timer >1000 ) {
                timer += 1000;
                frame.setTitle(title+" || Frames : :" + frames);
                frames = 0;
            }

        }
        stop();

    }





    public void update() {

        if(!threads.isAlive()){
            Display.threads.start();
        }

        for (int i = 0; i < 1000; i++) {
            screen[random.nextInt(WIDHT)][random.nextInt(HEIGHT)] = 1;

        }

    }


    private void render() {



        BufferStrategy bs =  this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        graph = bs.getDrawGraphics();
        graph.setColor(Color.darkGray );


       drawingThread.run(graph);




        graph.dispose();
        bs.show();
        frame.show();

    }





}