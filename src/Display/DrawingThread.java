package Display;

import java.awt.*;

public class DrawingThread  extends  Threads{

    int pixelSize = 20;

    public void run(Graphics graph) {
        for (int i = 0; i < Display.WIDHT; i+= 10) {
            for (int j = 0; j < Display.HEIGHT; j+=10) {
                if(Display.screen[i][j] == 1){
                    graph.setColor(Color.green);
                    graph.fillRect(i,j,i+10,j+10);

                }else {
                    graph.setColor(Color.black);
                    graph.fillRect(i,j,i+10,j+10);
                }

            }
        }
    }

    public synchronized void start(Graphics graph) {
        for (int i = 0; i < Display.WIDHT; i+= 10) {
            for (int j = 0; j < Display.HEIGHT; j+=10) {
                if(Display.screen[i][j] == 1){
                    graph.setColor(Color.green);
                    graph.fillRect(i,j,i+pixelSize,j+pixelSize);

                }else {
                    graph.setColor(Color.black);
                    graph.fillRect(i,j,i+pixelSize,j+pixelSize);
                }

            }
        }
    }
}
