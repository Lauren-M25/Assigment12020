/********************************************************************
 * Programmer: Lauren M
 * Class:  CS40S
 *
 * Assignment: A1
 *
 * Description: cell object for assignment 1: minesweeper
 ***********************************************************************/

// import libraries as needed here

public class Cell {
    //*** Class Variables ***
    
        int adjbombs = 0; // the number of bombs adjacent to this cell
        char Bstatus = 'X'; // whether or not this cell contains a bomb (b for yes, x for no)
        char OFstatus = 'c'; // whether or not this cell has been opened (o for opened, c for closed, f for flagged)
    
    //*** Instance Variables ***
    
    //*** Constructors ***
    
    /*****************************************
    * Description: constructs a cell of the minesweeper game
    * 
    * Interface:
    * ****************************************/
    
    public Cell(){
        this.OFstatus = 'c'; // default cell is closed
        this.Bstatus = 'X'; // default cell does not contain a bomb
        this.adjbombs = 0; // default cell has no adjacent bombs
    }
    
    //*** Getters ***
    
    /*****************************************
    * Description: get the number of adjacent bombs
    * 
    * Interface:
    * 
    * Return: adjbombs: int, the number of adjacent bombs
    * ****************************************/
    
    public int getadjbombs(){
        return this.adjbombs;
    }
    
    /*****************************************
    * Description: get the bomb status of the cell
    * 
    * Interface:
    * 
    * Return: Bstatus: char, whether or not the cell contains a bomb
    * ****************************************/
    
    public char getbombstatus(){
        return this.Bstatus;
    }
    
    /*****************************************
    * Description: get the opened status of the cell
    * 
    * Interface:
    * 
    * Return: Ostatus: char, whether or not the cell is opened
    * ****************************************/
    
    public char getOFstatus(){
        return this.OFstatus;
    }
    
    //*** Setters ***
    
    /*****************************************
    * Description: open the cell
    * 
    * Interface: 
    * ****************************************/
    
    public void open(){
        this.OFstatus = 'o'; // open the cell by setting the opened status to 'o'
    }
    
    /*****************************************
    * Description: flag the cell
    * 
    * Interface: 
    * ****************************************/
    
    public void flag(){
        this.OFstatus = 'f'; // flag the cell by setting the status to 'f'
    }
    
    /*****************************************
    * Description: place a bomb in the cell
    * 
    * Interface: 
    * ****************************************/
    
    public void placebomb(){
        this.Bstatus = 'B'; // place a bomb in the cell by setting the bomb status to 'B'
    }
    
    /*****************************************
    * Description: set the hint (number of adjacent bombs)
    * 
    * Interface: 
    * ****************************************/
    
    public void setadjbombs(int hint){
        this.adjbombs = hint; // set the number of adjbombs to the calculated hint
    }
    
} // end of public class
