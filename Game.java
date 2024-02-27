import java.util.ArrayList;
import java.util.Random;

public class Game{
    private int[][] gameBoard; // adding an integer 2D array
    private Random r = new Random();
    // making a new instance
    public Game(){
        //initializing gameboard as a 4*4 integers array
        gameBoard = new int[4][4];
    }
    //printing out 4*4 array
    public void printArray(){
        for(int[] x: gameBoard){
            System.out.format("%6d%6d%6d%6d%n",x[0],x[1],x[2],x[3]);
        }
        System.out.format("%sn", gameBoard);
    }
    
    // adding method to add number in empty spaces
    
    //ArrayList<type> 
    //therefore here emptyspaceX and emptyspaceY are ArrayList of Type Integer
    public void addNewNumbers(){
        ArrayList<Integer> emptySpacesX = new ArrayList<Integer>();
        ArrayList<Integer> emptySpacesY = new ArrayList<Integer>();
        for (int x = 0 ; x < 4; x++){
            for(int y = 0; y < 4; y++){
                //finds out empty space and 
                //add new no. until there is empty space 
                if(gameBoard[x][y] == 0){
                    emptySpacesX.add(x);
                    emptySpacesY.add(y);
                }
            }
        }
        //randomly choose a position 
        //then randomly choose wheather to put 1 or 2 in that position

        int choice = r.nextInt(emptySpacesX.size());
        int numberChooser = r.nextInt(10); // value 0-9
        int newNumber = 1;
        if(numberChooser == 0){
            newNumber = 2;
        }
        //placing the choosen no. on gameBoard
        int X = emptySpacesX.get(choice);
        int Y = emptySpacesY.get(choice);
        gameBoard[X][Y] = newNumber;
    }
    public void pushUp(){
        System.out.println("Pushing up.....");
        //adding boolean value for already combined no.s
        boolean[] alreadyCombined = {false,false,false,false};
        for(int y = 0; y < 4; y++){
            for(int x = 1; x < 4;x ++){
                if(gameBoard[x][y] !=0){  
                    int value = gameBoard[x][y];
                    int X = x - 1 ;
                    while ((X>=0) && (gameBoard[X][y] ==0)){
                        X--;
                    }
                    if (X==-1){
                        gameBoard[0][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if(gameBoard[X][y] != value){
                        gameBoard[X+1][y] = value;
                        gameBoard[x][y] = 0;
                }
                    else{
                        if(alreadyCombined[X] == true){
                            gameBoard[X+1][y] = value;
                        gameBoard[x][y] = 0;
                        }
                        else { 
                            gameBoard[X][y] *= 2;
                        alreadyCombined[X] = true;
                        gameBoard[x][y] = 0;
                        }
                    }
                }
            }
        }
    }
    public void pushDown(){
        System.out.println("Pushing down.....");
        //To interupt function when two values already combined
        boolean[] alreadyCombined = {false,false,false,false};
        for(int y = 0; y < 4; y++){
            for(int x = 2; x > -1;x --){
                if(gameBoard[x][y] !=0){  
                    int value = gameBoard[x][y];
                    int X = x + 1;
                    while ((X <=3) && (gameBoard[X][y] ==0)){
                        X++;
                    }
                    if (X == 4){
                        gameBoard[3][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if(gameBoard[X][y] != value){
                        gameBoard[X - 1][y] = value;
                        gameBoard[x][y] = 0;
                }
                    else{
                         if(alreadyCombined[X] == true){
                            gameBoard[X-1][y] = value;
                        gameBoard[x][y] = 0;
                        }
                        else { 
                            gameBoard[X][y] *= 2;
                        alreadyCombined[X] = true;
                        gameBoard[x][y] = 0;
                        }
                    }
                }
            }
        }
    }
     public void pushLeft(){
        System.out.println("Pushing Left.....");
        //To interupt function when two values already combined
        boolean[] alreadyCombined = {false,false,false,false};
        for(int x = 0; x < 4; x++){
            for(int y = 1; y < 4;y ++){
                if(gameBoard[x][y] !=0){  
                    int value = gameBoard[x][y];
                    int Y = y - 1;
                    while ((Y >=0) && (gameBoard[x][Y] ==0)){
                        y--;
                    }
                    if (Y == -1){
                        gameBoard[x][0] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if(gameBoard[x][Y] != value){
                        gameBoard[x][Y + 1] = value;
                        gameBoard[x][y] = 0;
                }
                    else{
                         if(alreadyCombined[Y] == true){
                            gameBoard[x][Y + 1] = value; //new value
                        gameBoard[x][y] = 0;
                        }
                        else { 
                            gameBoard[x][Y] *= 2;
                        alreadyCombined[Y] = true;
                        gameBoard[x][y] = 0; // empty the old position
                        }
                    }
                }
            }
        }
    } 
     public void pushRight(){
        System.out.println("Pushing right.....");
        //To interupt function when two values already combined
        boolean[] alreadyCombined = {false,false,false,false};
        for(int x = 0; x < 4; x++){
            for(int y = 2; y > -1; y --){
                if(gameBoard[x][y] !=0){  
                    int value = gameBoard[x][y];
                    int Y = y + 1;
                    while ((Y < 3) && (gameBoard[x][Y] ==0)){
                        y--;
                    }
                    if (Y == 4){
                        gameBoard[x][3] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if(gameBoard[x][Y] != value){
                        gameBoard[x][Y - 1] = value;
                        gameBoard[x][y] = 0;
                }
                    else{
                         if(alreadyCombined[Y] == true){
                            gameBoard[x][Y - 1] = value; //new value
                        gameBoard[x][y] = 0;
                        }
                        else { 
                            gameBoard[x][Y] *= 2;
                        alreadyCombined[Y] = true;
                        gameBoard[x][y] = 0; // empty the old position
                        }
                    }
                }
            }
        }
    } 
}