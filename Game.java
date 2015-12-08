//Author: Gloria Ngan
/*
 *  This class contains the constructor for the game, the method which displays the game,
 *  all the logic to determine if the game has been won, and the logic that allows the
 *  CPU to make a turn.
 */ 

public class Game{
  public String[][] game = new String[3][3];  //3 rows, 3 columns.
  private String player = " X ";
  private String CPU = " O ";
  private int p, q;
  
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
    int i, j;
    //Only allows selection if the space is blank.
    if(!game[x][y].equals(player) && !game[x][y].equals(CPU)){
      game[x][y] = " X ";
    }else{
      System.out.println("Sorry that space is taken.");  //Error message.
    }
  }
  
  /*  
   *  Determines the CPU's move; simulated AI.
   *  The CPU looks for scenarios in which the player is about
   *  to win and attempts to prevent this. Post-win scenario is
   *  defined as a situation in which there are two X's in a
   *  rox, column, or diagonal. The CPU will place an 'O' in 
   *  the remaining spot, blocking the player.
   * 
   */
  public void CPUmove(){
    //Runs thru the rows.
    for(int i = 0; i < game.length; i++){
      //Run thru columns.
      for(int j = 0; j < game[0].length; j++){
        //Scenario 1: Two X's in column.
        if(j == 0){
          if(game[i][j].equals(player) && game[i][j+1].equals(player)){      //Case: X | X | -
            //If the next tile is blank.
            if(!game[i][j+2].equals(player) && !game[i][j+2].equals(CPU)){
              game[i][j+2] = CPU;
              return;
            }
          }
        }else if(j == 1){                                                    //Case: X | - | X 
          if(game[i][j-1].equals(player) && game[i][j+1].equals(player)){
            if(!game[i][j].equals(player) && !game[i][j].equals(CPU)){
              game[i][j] = CPU;
              return;
            }
          }
        }else if(j == 2){
          if(game[i][j].equals(player) && game[i][j-1].equals(player)){      //Case: - | X | X
            //If the first tile is blank.
            if(!game[i][j-1].equals(player) && !game[i][j-1].equals(CPU)){
              game[i][j-1] = CPU;
              return;
            }
          }
        }
        
        //Scenario 2: Two X's in a row.
        if(i == 0){                                                          //Case: | X |
          if(game[i][j].equals(player) && game[i+1][j].equals(player)){      //      | X |
            if(!game[i+2][j].equals(player) && !game[i+2][j].equals(CPU)){   //      | - |
              game[i+2][j] = CPU;
              return;
            }
          }
        }else if(i == 1){                                                    //Case: | X |
          if(game[i-1][j].equals(player) && game[i+1][j].equals(player)){    //      | - |
            if(!game[i][j].equals(player) && !game[i][j].equals(CPU)){       //      | X |
              game[i][j] = CPU;
              return;
            }
          }
        }else if(i == 2){                                                    //Case: | - |
          if(game[i][j].equals(player) && game[i-1][j].equals(player)){      //      | X |
            if(!game[i-2][j].equals(player) && !game[i-2][j].equals(CPU)){   //      | X |
              game[i-2][j] = CPU;
              return;
            }
          }
        }
        
        //Scenario 3: Two X's in diagonal.
        if(game[1][1].equals(player)){
          if(game[2][0].equals(player)){
            if(!game[0][2].equals(player) && !game[0][2].equals(CPU)){       //Case: - | - | -
              game[0][2] = CPU;                                              //      - | X | -
              return;                                                        //      X | - | -
            }
          }else if(game[0][2].equals(player)){
            if(!game[2][0].equals(player) && !game[2][0].equals(CPU)){       //Case: - | - | X
              game[2][0] = CPU;                                              //      - | X | -
              return;                                                        //      - | - | -
            }                                                             
          }else if(game[0][0].equals(player)){
            if(!game[2][2].equals(player) && !game[2][2].equals(CPU)){       //Case: X | - | -
              game[2][2] = CPU;                                              //      - | X | -
              return;                                                        //      - | - | -
            }                                                             
          }else if(game[2][2].equals(player)){
            if(!game[0][0].equals(player) && !game[0][0].equals(CPU)){       //Case: - | - | -
              game[0][0] = CPU;                                              //      - | X | -
              return;                                                        //      - | - | X
            }                                                             
          }
        }      
      }
    }
    //If none of the situations above apply.
    while(true){
      p = -1;
      q = -1;
      p = ((int)(3 * Math.random()));
      q = ((int)(3 * Math.random()));
      if(!game[p][q].equals(player) && !game[p][q].equals(CPU)){  //Robot moves randomly.
        game[p][q] = CPU;
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
    else if(game[2][0].equals(player) && game[2][1].equals(player) && game[2][2].equals(player)){
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
    //Third column filled.
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
