package Game;

import Display.Display;

public class Cheack {

    public  void  cheackNeigbords(int[][] screen){

        int num =0;

        for (int i = 0; i < Display.WIDHT; i++) {
            for (int j = 0; j < Display.HEIGHT; j++) {
                
              //trys to get the amount of live cells in a 9x9 grid
                    try{
                    num += screen[i-1][j-1];
                    
                }catch (Exception e){
                        
                    }
                    try{
                        num += screen[i][j-1];

                    }catch (Exception e){

                    }
                try{
                    num += screen[i+1][j-1];

                }catch (Exception e){

                }
                try{
                    num += screen[i-1][j];

                }catch (Exception e){

                }
                try{
                    num += screen[i][j];

                }catch (Exception e){

                }
                try{
                    num += screen[i+1][j];

                }catch (Exception e){

                }
                try{
                    num += screen[i-1][j+1];

                }catch (Exception e){

                }
                try{
                    num += screen[i][j+1];

                }catch (Exception e){

                }
                try{
                    num += screen[i+1][j+1];

                }catch (Exception e){

                }
                //if therer are 3 alive cells the middle one becomes alive
                if(screen[i][j] == 0 && num >= 3){
                    screen[i][j] = 1;
                }// if
                else if (screen[i][j] == 0 && num < 3)
                {
                    screen[i][j ] = 0;
                }
                else if (screen[i][j] ==1 && num < 3) {
                    screen[i][j] = 0;
                }
                else if(screen[i][j] == 1 && num > 5 ){
                    screen[i][j] = 0;
                }
                else {
                 screen[i][j] = 1;
                }
                num = 0;
            }
    }
        
        
        

}
}