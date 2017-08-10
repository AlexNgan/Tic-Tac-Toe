import java.util.Scanner; 

//Author: Alex
//This is the main class for the tic-tac-toe game. Requires Game.java as well.
/* 
 *  Running this creates a new 3x3 tile game, where all the tiles are set to a dash.
 *  The player, represented as an 'X', marks tiles by inputting coordinates, which
 *  correspond to a tile. After the player moves, the CPU makes a move, writing
 *  'O' in one of the empty tiles.
 */

public class GameTest{
  public static void main(String[] args){
    System.out.println("To play, enter the coordinates of the tile in which you want to place an 'X'. (1,1) is the center tile.");
    
    Scanner scan = new Scanner(System.in);
    Game ticTac = new Game();  //Creates new game.
    ticTac.displayGame();
    System.out.println("");
    
    while(ticTac.isDone() == false && ticTac.isTie() == false){
      System.out.print("Enter an x-value. Range: 0 to 2.");
      int x = scan.nextInt();
      System.out.print("Enter a y-value. Range: 0 to 2.");
      int y = scan.nextInt();
      
      ticTac.run(x,y);
      ticTac.displayGame();
      System.out.println("");
    }
    scan.close();
  }
}
