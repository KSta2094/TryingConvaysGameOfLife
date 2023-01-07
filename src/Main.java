import Display.Display;
import Game.Cheack;

import javax.swing.*;
import java.awt.*;
import Display.Threads;

public class Main  {



    public static  void main(String[] args) throws AWTException {


      Display display = new Display();
        Threads threads = new Threads();



        display.frame.setTitle(display.title);
        display.frame.add(display);
        Display.FPS = 60;
        display.frame.setSize(Display.WIDHT,Display.HEIGHT);
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Display.frame.getContentPane().setBackground(Color.darkGray);
        display.frame.setResizable(true);


        display.frame.setVisible(true);
        Display.threads.start();

        display.start();



    }
}