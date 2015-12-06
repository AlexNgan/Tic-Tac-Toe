//Author: Gloria Ngan
/*
 *  This class contains the constructor for the game, the method which displays the game,
 *  all the logic to determine if the game has been won, and the logic that allows the
 *  CPU to make a turn.
 */ 

public class Game{
  //3 rows, 3 columns.
  public String[][] game = new String[3][3];
  private String player = " X ";
  private String CPU = " O ";
  
  //Game constructor.
  public Game(){
    //Grid only filled with dashes.
    for(int x = 0; x < game.length; x++){
      for(int y = 0; y < game[0].length; y++){
        game[x][y] = " - ";
      }
    }
  }
  
  //Prints out the grid, with Xs and Os.
  public void displayGame(){
    for(int x = 0; x < game.length; x++){   
      //Formats columns.
      //if(x > 0 && x < 3){
      //System.out.println("");
      //System.out.println("-----------");
      //}
      
      for(int y = 0; y < game[0].length; y++){   
        //Formats row.
        if(y > 0 && y < 3)
          System.out.print("|");
        else
          System.out.println("");
        
        System.out.print(game[x][y]);  //Prints out each tile.
      }
    }
  }
  
  //Runs game, accepting user input. CPU takes turn.
  public void run(int x, int y){
    int i;
    int j;
    //Only allows selection if the space is blank.
    if(!game[x][y].equals(player) && !game[x][y].equals(CPU)){
      game[x][y] = " X ";
    }else{
      System.out.println("Sorry that space is taken.");  //Error message.
    }
    
    //CPU move.
    while(true){
      i = -1;
      j = -1;
      i = ((int)(3 * Math.random()));
      j = ((int)(3 * Math.random()));
      if(!game[i][j].equals(player) && !game[i][j].equals(CPU)){
        game[i][j] = " O ";
        break;
      }
    }
  }
  
  //Detects if there are 3 X's or O's in a row.
  public boolean isDone(){
    
    //Case 1: Horizontal.
    //Player win.
    //First row filled.
    if(game[0][0].equals(player) && game[0][1].equals(player) && game[0][2].equals(player)){
      System.out.println("You won!");
      return true;
    }
    //Second row filled.
    else if(game[1][0].equals(player) && game[1][1].equals(player) && game[1][2].equals(player)){
      System.out.println("You won!");
      return true;
    }
    
    //Third row filled.
    if(game[2][0].equals(player) && game[2][1].equals(player) && game[2][2].equals(player)){
      System.out.println("You won!");
      return true;
    }
    
    //CPU win.
    //First row filled.
    else if(game[0][0].equals(CPU) && game[0][1].equals(CPU) && game[0][2].equals(CPU)){
      System.out.println("You lost!");
      return true;
    }
    //Second row filled.
    else if(game[1][0].equals(CPU) && game[1][1].equals(CPU) && game[1][2].equals(CPU)){
      System.out.println("You lost!");
      return true;
    }
    //Third row filled.
    else if(game[2][0].equals(CPU) && game[2][1].equals(CPU) && game[2][2].equals(CPU)){
      System.out.println("You lost!");
      return true;
    }
    
    //Case 2: Diagonal (can be starting from top or bottom corner).
    //Player win.
    else if(game[0][0].equals(player) && game[1][1].equals(player) && game[2][2].equals(player)){
      System.out.println("You won!");
      return true;
    }else if(game[2][0].equals(player) && game[1][1].equals(player) && game[0][2].equals(player)){
      System.out.println("You won!");
      return true;
    }
    //CPU win.
    else if(game[0][0].equals(CPU) && game[1][1].equals(CPU) && game[2][2].equals(CPU)){
      System.out.println("You lost!");
      return true;
    }else if(game[2][0].equals(CPU) && game[1][1].equals(CPU) && game[0][2].equals(CPU)){
      System.out.println("You lost!");
      return true;
    }
    
    //Case 3: Vertical.
    //Player win.
    //First column filled.
    else if(game[0][0].equals(player) && game[1][0].equals(player) && game[2][0].equals(player)){
      System.out.println("You win!");
      return true;
    }
    //Second column filled.
    else if(game[0][1].equals(player) && game[1][1].equals(player) && game[2][1].equals(player)){
      System.out.println("You win!");
      return true;
    }
    //Third colum filled.
    else if(game[0][2].equals(player) && game[1][2].equals(player) && game[2][2].equals(player)){
      System.out.println("You win!");
      return true;
    }
    //CPU win.
    //First column filled.
    else if(game[0][0].equals(CPU) && game[1][0].equals(CPU) && game[2][0].equals(CPU)){
      System.out.println("You lose!");
      return true;
    }
    //Second column filled.
    else if(game[0][1].equals(CPU) && game[1][1].equals(CPU) && game[2][1].equals(CPU)){
      System.out.println("You lose!");
      return true;
    }
    //Third column filled.
    else if(game[0][2].equals(CPU) && game[1][2].equals(CPU) && game[2][2].equals(CPU)){
      System.out.println("You lose!");
      return true;
    }
    return false;
  }
}
