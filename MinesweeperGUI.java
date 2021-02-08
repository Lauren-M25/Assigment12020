/********************************************************************
 * Programmer: Lauren M
 * Class: CS40S
 *
 * Assignment: A1
 *
 * Description: GUI for assignment 1: minesweeper
 ***********************************************************************/
import java.util.Random;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JList;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.DefaultListModel;
import javax.swing.event.*;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.*;
 
public class MinesweeperGUI extends javax.swing.JFrame{

    public MinesweeperGUI(){
        initializeComp();
    }
    
    private void initializeComp(){
        header = new javax.swing.JLabel("Minesweeper");
        gridDimensionsLabel = new javax.swing.JLabel("Grid Dimensions");
        winLoseMessage = new javax.swing.JLabel();
        winLoseMessage2 = new javax.swing.JLabel();
        
        startGame = new javax.swing.JButton();
        playAgain = new javax.swing.JButton();
        
        Frame frame = new Frame();
        Choice gridDimensionsChoice = new Choice();
        gridDimensionsChoice.add("5 x 5");
        gridDimensionsChoice.add("6 x 6");
        gridDimensionsChoice.add("7 x 7");
        gridDimensionsChoice.add("8 x 8");
        gridDimensionsChoice.add("9 x 9");
        gridDimensionsChoice.add("10 x 10");
        frame.add(gridDimensionsChoice);
        
        
        
    }
     private javax.swing.JLabel header;
     private javax.swing.JLabel gridDimensionsLabel;
     private javax.swing.JLabel winLoseMessage;
     private javax.swing.JLabel winLoseMessage2;
     private javax.swing.JButton startGame;
     private javax.swing.JButton playAgain;
}
