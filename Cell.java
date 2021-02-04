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
        char Bstatus = 'x'; // whether or not this cell contains a bomb (b for yes, x for no)
        char Ostatus = 'c'; // whether or not this cell has been opened (o for opened, c for closed)
    
    //*** Instance Variables ***
    
    //*** Constructors ***
    
    /*****************************************
    * Description: a cell of the minesweeper game
    * 
    * Interface:
    * ****************************************/
    
    public Cell(){
        
        this.Ostatus = 'c'; // default cell is closed
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
    
    public char getopenedstatus(){
        return this.Ostatus;
    }
    
    //*** Setters ***
    
    /*****************************************
    * Description: open the cell
    * 
    * Interface: 
    * ****************************************/
    
    public void open(){
        this.Ostatus = 'o'; // open the cell by setting the opened status to 'o'
    }
    
} // end of public class