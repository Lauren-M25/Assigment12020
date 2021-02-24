/********************************************************************
 * Programmer: Lauren M
 * Class: CS40S
 *
 * Assignment: A1
 *
 * Description: game grid object for assignment 1: minesweeper
 ***********************************************************************/

import java.util.*;
public class GameGrid {
    //*** Class Variables ***
    
       Cell[][] cells = null;
       int dimensions = 0;
    
    //*** Instance Variables ***
    
    Random ran = new Random();
    
    //*** Constants ***
    
    final double Bpercentmultiplier = 0.16; // the multiplier to have 16 percent of cells have bombs
    
    //*** Constructors ***
    
    /*****************************************
    * Description: the grid of cells for the minesweeper game
    * 
    * Interface:
    * ****************************************/
    
    public GameGrid(int dimensions){
        Cell[][] cells = new Cell[dimensions][dimensions];
        this.dimensions = dimensions;
        int numberofbombs = (int)Bpercentmultiplier * this.dimensions * this.dimensions;
        
        for(int i = 0; i < numberofbombs; i++){
            cells[ran.nextInt(this.dimensions)][ran.nextInt(this.dimensions)].placebomb();
        }
        
        for(int j = 0; j < this.dimensions - 1; j++){
            for(int k = 0; k < this.dimensions - 1; k++){
                cells[j][k].setadjbombs(calculateHint(j,k));
            } // end row
        } // end calculate hints for the table
    }
    
    //*** Getters ***
    
    /*****************************************
    * Description: get the dimensions of the cell
    * 
    * Interface:
    * 
    * Return: dimensions: int, the number of rows and columns in the grid
    * ****************************************/
    
    public Cell getcell(int x, int y){
        return this.cells[x][y];
    }
    
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
    
    public int getHint(int x, int y){
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
    * Description: get the status of the cell (opened, flagged, or closed)
    * 
    * Interface:
    * 
    * Return: OFstatus: char, the status of the cell (o, f, c)
    * ****************************************/
    
    public char getOFstatus(int x, int y){
        return this.cells[x][y].getOFstatus();
    }
    
    /*****************************************
    * Description: get the opened status of the cell
    * 
    * Interface:
    * 
    * Return: Ostatus: char, whether or not the cell is opened
    * ****************************************/
    
    private int calculateHint(int x, int y){
        int hint = 0; // the counter of adjacent bombs
        
        if(x > 0 && y > 0 && x < this.dimensions - 1 && y < this.dimensions - 1){
            for(int i = x - 1; i < x + 1; i++){
                for(int k = y - 1; k < y + 1; k++){
                    if(cells[i][k].getbombstatus() == 'b'){
                    hint++;
                    } else {
                    // there is no bomb int the adjacent cell
                    } // end bomb or no bomb
                }
            } // end count adjacent bombs
        } else { // end center cell
            
            if(x == this.dimensions - 1 || x == 0 && y == x || y == 0 || y == this.dimensions - 1){
                int a = 0; //declare index range variables
                int b = 0; //declare index range variables
        
                if(x == 0){
                    a = x;
                } else {
                    a = x-1;
                } // end top or bottom corner
        
                if(y == 0){
                    b = y;
                } else {
                    b = y-1;
                } // end left or right corner
        
                for(int i = a; i < a+1; i++){
                    for(int k = b; k < b+1; k++){
                        if(cells[i][k].getbombstatus() == 'b'){
                            hint++;
                        } else {
                            // there is no bomb int the adjacent cell
                        } // end bomb or no bomb
                    }
                } // end count adjacent bombs
            } else { // end corner cell
                
                int a = 0; //declare index range variables
                int b = 0; //declare index range variables
                int c = 0; //declare index range variables
                int d = 0; //declare index range variables
                
                if(x == 0){
                    a = x-1;
                    b = x;
                    c = y-1;
                    d = y+1;
                } else { // end top edge
                    if(x == this.dimensions - 1){
                        a = x;
                        b = x+1;
                        c = y-1;
                        d = y+1;
                    } else { // end bottom edge
                        if(y == 0){
                            a = x-1;
                            b = x+1;
                            c = y-1;
                            d = y;
                        } else { // end left edge
                            a = x-1;
                            b = x+1;
                            c = y;
                            d = y+1;
                        } // end right edge
                    }
                } // end which edge for index range variables
                
                for(int i = a; i < b; i++){
                    for(int k = c; k < d; k++){
                        if(cells[i][k].getbombstatus() == 'b'){
                            hint++;
                        } else {
                            // there is no bomb int the adjacent cell
                        } // end bomb or no bomb
                    }
                } // end count adjacent bombs
            } // end edge cell
        }
        
        return hint;
    }
    
    //*** Setters ***
    
    /*****************************************
    * Description: open a cell
    * 
    * Interface:
    * ****************************************/
    
    public void open(int x, int y){
        this.cells[x][y].open(); // open the cell by setting the status to 'o'
        if(getHint(x,y) == 0){
            openAdj(x,y);
        }
    }
    
    /*****************************************
    * Description: open adjacent cells
    * 
    * Interface:
    * ****************************************/
    
    public void openAdj(int x, int y){
        if(x > 0 && y > 0 && x < this.dimensions - 1 && y < this.dimensions - 1){
            for(int i = x - 1; i < x + 1; i++){
                for(int k = y - 1; k < y + 1; k++){
                    if(i == x && k == y){
                    
                    } else {
                        open(i,k);
                    } // open the cell
                } // end row
            } // end adjacent
        } else { // end center cell
            
            if(x == this.dimensions - 1 || x == 0 && y == x || y == 0 || y == this.dimensions - 1){
                int a = 0; //declare index range variables
                int b = 0; //declare index range variables
        
                if(x == 0){
                    a = x;
                } else {
                    a = x-1;
                } // end top or bottom corner
        
                if(y == 0){
                    b = y;
                } else {
                    b = y-1;
                } // end left or right corner
        
                for(int i = a; i < a+1; i++){
                    for(int k = b; k < b+1; k++){
                        if(i == x && k == y){
                    
                        } else {
                            open(i,k);
                        } // open cell
                    }
                } // end adjacent
            } else { // end corner cell
                
                int a = 0; //declare index range variables
                int b = 0; //declare index range variables
                int c = 0; //declare index range variables
                int d = 0; //declare index range variables
                
                if(x == 0){
                    a = x-1;
                    b = x;
                    c = y-1;
                    d = y+1;
                } else { // end top edge
                    if(x == this.dimensions - 1){
                        a = x;
                        b = x+1;
                        c = y-1;
                        d = y+1;
                    } else { // end bottom edge
                        if(y == 0){
                            a = x-1;
                            b = x+1;
                            c = y-1;
                            d = y;
                        } else { // end left edge
                            a = x-1;
                            b = x+1;
                            c = y;
                            d = y+1;
                        } // end right edge
                    }
                } // end which edge for index range variables
                
                for(int i = a; i < b; i++){
                    for(int k = c; k < d; k++){
                        if(i == x && k == y){
                            
                        } else {
                            open(i,k);
                        } // open cell
                    }
                } // end adjacent
            } // end edge cell
        }
    }
    
    /*****************************************
    * Description: flag a cell
    * 
    * Interface:
    * ****************************************/
    
    public void flag(int x, int y){
        this.cells[x][y].flag(); // flag the cell by setting the status to 'f'
    }
    
} // end of public class
