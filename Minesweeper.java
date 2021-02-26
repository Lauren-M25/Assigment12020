/********************************************************************
 * Programmer: Lauren M
 * Class: CS40S
 *
 * Assignment: A1
 *
 * Description: a minesweeper game
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 //import java.text.DecimalFormat;
 import java.io.*;

public class Minesweeper {  // begin class
    
    public static void main(String[] args)throws IOException {  // begin main
    
    // ********* declaration of constants **********
    
    // ********** declaration of variables **********

        String strin;       // string data input from keyboard
        String strout;      // processed info string to be output
        String bannerOut;       // string to print banner to message dialogs

        String prompt;      // prompt for use in input dialogs

        String delim = "[ ]+"; // delimiter string for splitting input string
        String[] tokens;                        // string array for gathering input
        
        String tabSpace = "      "; // six spaces
        String nl = System.lineSeparator(); // new line character for file writing
        
        int dimensions = 0; // the dimensions of the game grid
        JFrame frame = new JFrame(); // frame for printing grid and win or lose message
        
    // ***** create objects *******
    
        //ConsoleReader console = new ConsoleReader(System.in);
        //DecimalFormat df1 = new DecimalFormat("##.###");
        
        //BufferedReader fin = new BufferedReader(new FileReader("demo1Data.txt"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));
        
    // ********** Print output Banner **********

        System.out.println("*******************************************");
        System.out.println("Name: Lauren M");
        System.out.println("Class: CS40S");
        System.out.println("Assignment: A1");
        System.out.println("*******************************************");

        bannerOut = "*******************************************" + nl;
        bannerOut += "Name: Lauren M" + nl;
        bannerOut += "Class: CS40S" + nl;
        bannerOut += "Assignment: A1" + nl;
        bannerOut += "*******************************************" + nl + nl;
        
        fout.print(bannerOut);
        
    // ************************ get input **********************
    
        prompt = "Welcome to Mine Sweeper! \n";
        prompt += "Please enter your desired grid dimensions (5 x 5 - 10 x 10)";

        strin = JOptionPane.showInputDialog(bannerOut + prompt); // get the game grid dimensions
        
        tokens = strin.split(delim);
        
        dimensions = Integer.parseInt(tokens[0]);
        
        GameGrid gameGrid = new GameGrid(dimensions); // create game grid // error in calculateHint method in constructor

    // ************************ processing ***************************
        
        int cellsopened = 0; // declare control variables
        boolean bombhit = false; // declare control variables
    
        while(cellsopened < (gameGrid.getdimensions() * gameGrid.getdimensions()) || bombhit == true){
    
        prompt = "To make a move, enter the row number (starting at 1) and the column number of the cell you wish to open or flag. /nl";
        prompt += "example: x,y";

        strin = JOptionPane.showInputDialog(bannerOut + prompt); // get the cell indexes
        
        delim = "[,]+";
        
        tokens = strin.split(delim);
        
        int cellX = Integer.parseInt(tokens[0]); // the x index of the cell
        int cellY = Integer.parseInt(tokens[1]); // the y index of the cell
        
        prompt = "You have selected cell " + strin + ". Enter O to open, or F to flag.";

        strin = JOptionPane.showInputDialog(bannerOut + prompt); // get flag or open
        
        if(strin == "O"){
            bombhit = gameGrid.open(cellX, cellY); // open the cell // if a bomb is hit, the open method will return a true boolean
        } else {
            gameGrid.flag(cellX, cellY); // flag the cell
        }
        
        JOptionPane.showMessageDialog(frame, gameGrid.printGrid()); // print the grid
    } // end game

    // ************************ print output ****************************
    
    if(bombhit == true){
        prompt = "You hit a bomb! \n";
        prompt += "GAME OVER";
    } // end lose message
    else {
        prompt = "Congradulations! \n";
        prompt += "YOU WIN";
    } // end win message
    
    JOptionPane.showMessageDialog(frame, bannerOut + prompt); // print win or lose message
    
    // ******** closing message *********
        
        System.out.println("end of processing.");
        fout.println("end of processing");
        
    // ***** close streams *****
        
        //fin.close();                // close input buffer stream
        fout.close();               // close output stream
        
    }  // end main
}  // end class
