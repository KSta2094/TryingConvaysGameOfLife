package Display;

import Game.Cheack;

import static Display.Display.*;

public class Threads extends Thread {
    Cheack cheack = new Cheack();

    @Override
    public void run() {


    cheack.cheackNeigbords(screen);


}

    @Override
    public synchronized void start() {
        cheack.cheackNeigbords(screen);
    }
}
