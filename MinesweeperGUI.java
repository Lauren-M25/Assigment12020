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
        gridDimensionsLabel = new javax.swing.JLabel("Please select your grid dimensions:");
        winLoseMessage = new javax.swing.JLabel();
        winLoseMessage2 = new javax.swing.JLabel();
        
        startGame = new javax.swing.JButton();
        playAgain = new javax.swing.JButton();
        
        String[] dimensionsOptions = {"5 x 5", "6 x 6", "7 x 7", "8 x 8", "9 x 9", "10 x 10"};
        dimensionsList = new javax.swing.JList(dimensionsOptions);
        
        startGame.setText("Start Game");
        startGame.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                startGameActionPerformed(evt);
            }
        });
    
        playAgain.setText("Play Again");
        playAgain.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                playAgainActionPerformed(evt);
            }
        });
        
        frame = new javax.swing.JFrame("Mine Sweeper");
        
        dimensionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    private void startGameActionPerformed(java.awt.event.ActionEvent evt){
        JButton[][] cells = new JButton[dimensionsList.getSelectedIndex()][dimensionsList.getSelectedIndex()];
        for(int i = 0; i < dimensionsList.getSelectedIndex(); i++){
            for(int j = 0; j < dimensionsList.getSelectedIndex(); j++){
                cells[i][j].addActionListener(new java.awt.event.ActionListener(){
                    public void actionPerformed(java.awt.event.ActionEvent evt){
                        cellActionPerformed(evt);
                    }
                });
            }
        }
        GameGrid gameGrid = new GameGrid(dimensionsList.getSelectedIndex());
    }
    
    private void playAgainActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    
    private void cellActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    
    public static void main (String args[]){
        
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new MinesweeperGUI();
            }
        });
        
    }
    
     private javax.swing.JFrame frame;
     private javax.swing.JLabel header;
     private javax.swing.JLabel gridDimensionsLabel;
     private javax.swing.JLabel winLoseMessage;
     private javax.swing.JLabel winLoseMessage2;
     private javax.swing.JButton startGame;
     private javax.swing.JButton playAgain;
     private javax.swing.JList dimensionsList;
}
