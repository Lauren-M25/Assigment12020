/********************************************************************
 * Programmer: Lauren M
 * Class: CS40S
 *
 * Assignment: A1
 *
 * Description: game grid object for assignment 1: minesweeper
 ***********************************************************************/

// import libraries as needed here

public class GameGrid {
    //*** Class Variables ***
    
       Cell[][] cells = null;
       int dimensions = 0;
    
    //*** Instance Variables ***
    
    //*** Constructors ***
    
    /*****************************************
    * Description: the grid of cells for the minesweeper game
    * 
    * Interface:
    * ****************************************/
    
    public GameGrid(int dimensions){
        Cell[][] cells = new Cell[dimensions][dimensions];
        this.dimensions = dimensions;
    }
    
    //*** Getters ***
    
    /*****************************************
    * Description: get the dimensions of the cell
    * 
    * Interface:
    * 
    * Return: dimensions: int, the number of rows and columns in the grid
    * ****************************************/
    
    public int getdimensions(){
        return this.dimensions;
    }
    
    /*****************************************
    * Description: get the number of adjacent bombs from a cell
    * 
    * Interface:
    * 
    * Return: adjbombs: int, the number of adjacent bombs
    * ****************************************/
    
    public int getadjB(int x, int y){
        return this.cells[x][y].getadjbombs();
    }
    
    /*****************************************
    * Description: get the bomb status of the cell
    * 
    * Interface:
    * 
    * Return: Bstatus: char, whether or not the cell contains a bomb
    * ****************************************/
    
    public char getBstatus(int x, int y){
        return this.cells[x][y].getbombstatus();
    }
    
    /*****************************************
    * Description: get the opened status of the cell
    * 
    * Interface:
    * 
    * Return: Ostatus: char, whether or not the cell is opened
    * ****************************************/
    
    public char getOstatus(int x, int y){
        return this.cells[x][y].getopenedstatus();
    }
    
    /*****************************************
    * Description: get the opened status of the cell
    * 
    * Interface:
    * 
    * Return: Ostatus: char, whether or not the cell is opened
    * ****************************************/
    
    public int getHint(int x, int y){
        int hint = 0;
        
        
        if(x > 0 && y > 0 && x < this.dimensions - 1 && y < this.dimensions - 1){
            for(int i = x - 1; i < x + 1; i++){
                for(int k = y - 1; k < y + 1; k++){
                    if(cells[i][k].getbombstatus() == 'b'){
                    hint++;
                    } else {
                    // there is no bomb int the adjacent cell
                    } // end bomb or no bomb
                } // end row
            } // end adjacent
        } else {
        
            int a = 0;
            int b = 0;
        
            if(x == 0){
                a = x;
            } else {
                a = x-1;
            }
        
            if(y == 0){
                b = y;
            } else {
                b = y-1;
            }
        
            for(int i = a; i < a+1; x++){
                for(int k = b; k < b+1; y++){
                    if(cells[i][k].getbombstatus() == 'b'){
                        hint++;
                    } else {
                        // there is no bomb int the adjacent cell
                    } // end bomb or no bomb
                }
            }
        }
        
        
        if(x > 0){
            if(cells[x-1][y].getbombstatus() == 'b'){
                hint ++;
            }
        }
        
        if(x > 0 && y < this.dimensions){
            if(cells[x-1][y+1].getbombstatus() == 'b'){
                hint ++;
            }
        }
        
        if(y > 0){
            if(cells[x][y-1].getbombstatus() == 'b'){
                hint ++;
            }
        }
        
        if(y < this.dimensions){
            if(cells[x][y+1].getbombstatus() == 'b'){
                hint ++;
            }
        }
        
        if(x < this.dimensions && y > 0){
            if(cells[x+1][y-1].getbombstatus() == 'b'){
                hint ++;
            }
        }
        
        if(x < this.dimensions){
            if(cells[x+1][y].getbombstatus() == 'b'){
                hint ++;
            }
        }
        
        if(x < this.dimensions && y < this.dimensions){
            if(cells[x+1][y+1].getbombstatus() == 'b'){
                hint ++;
            }
        }
        
        return hint;
    }
    
    //*** Setters ***
    
    /*****************************************
    * Description: open a cell
    * 
    * Interface:
    * ****************************************/
    
    public void opencell(int x, int y){
        this.cells[x][y].open(); // open the cell by setting the opened status to 'o'
    }
    
} // end of public class
