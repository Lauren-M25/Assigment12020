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
    
    GameGrid gameGrid;
    
    public MinesweeperGUI(){
        initializeComp();
    }
    
    private void initializeComp(){
        header = new javax.swing.JLabel("Minesweeper");
        header.setPreferredSize(new Dimension(400, 400));
        gridDimensionsLabel = new javax.swing.JLabel("Please select your grid dimensions:");
        winLoseMessage = new javax.swing.JLabel("You Win");
        winLoseMessage2 = new javax.swing.JLabel("Congradulations!");
        
        startGame = new javax.swing.JButton();
        playAgain = new javax.swing.JButton();
        
        String[] dimensionsOptions = {"5 x 5", "6 x 6", "7 x 7", "8 x 8", "9 x 9", "10 x 10"};
        JComboBox<String> dimensionsChoice = new JComboBox(dimensionsOptions);
        
        frame = new javax.swing.JFrame("Mine Sweeper");
        frame.setPreferredSize(new Dimension (600, 600));
        this.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension (600, 600));
        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addComponent(header)
        .addComponent(gridDimensionsLabel)
        .addComponent(winLoseMessage)
        .addComponent(dimensionsChoice)
        .addComponent(startGame));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
        .addComponent(header)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addComponent(gridDimensionsLabel)
        .addComponent(winLoseMessage))
        .addComponent(dimensionsChoice)
        .addComponent(startGame));
        
        winLoseMessage.setVisible(false);
        
        startGame.setText("Start Game");
        startGame.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                startGameActionPerformed(evt, panel);
            }
        });
    
        playAgain.setText("Play Again");
        playAgain.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                playAgainActionPerformed(evt);
            }
        });
        
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    private void startGameActionPerformed(java.awt.event.ActionEvent evt, JPanel panel){
        JButton[][] cells = new JButton[(dimensionsChoice.getSelectedIndex() + 5)][(dimensionsChoice.getSelectedIndex() + 5)];
        gameGrid = new GameGrid((dimensionsChoice.getSelectedIndex() + 5));
        for(int i = 0; i < (dimensionsChoice.getSelectedIndex() + 5); i++){
            for(int j = 0; j < (dimensionsChoice.getSelectedIndex() + 5); j++){
                int x = i;
                int y = j;
                cells[i][j].addMouseListener(new MouseAdapter(){
                    public void mouseReleased(MouseEvent e){
                        Point p = e.getPoint();
                        if(cells[x][y].contains(p)){
                            if(e.isMetaDown()){
                                cellRClicked(evt, cells[x][y], x, y);
                            } else {
                                cellLClicked(evt, cells[x][y], x, y);
                            }
                        }
                    }
                });
            }
        }

        panel.setLayout(new GridLayout((dimensionsChoice.getSelectedIndex() + 5), (dimensionsChoice.getSelectedIndex() + 5)));
        
        for(int i = 0; i < (dimensionsChoice.getSelectedIndex() + 5); i++){
            for(int j = 0; j < (dimensionsChoice.getSelectedIndex() + 5); j++){
                panel.add(cells[i][j]);
            }
        }
        
        frame.add(panel);
    }
    
    private void playAgainActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    
    private void cellRClicked(java.awt.event.ActionEvent evt, JButton cellButton, int x, int y){
        if(gameGrid.getBstatus(x,y) == 'B'){
            cellButton.setText("B");
            lose();
        } else {
            gameGrid.open(x,y);
            cellButton.setText(String.valueOf(gameGrid.getHint(x,y)));
        }
    }
    
    private void cellLClicked(java.awt.event.ActionEvent evt, JButton cellButton, int x, int y){
        gameGrid.flag(x,y);
        cellButton.setText("F");
    }
    
    private void lose(){
        
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
     private javax.swing.JComboBox dimensionsChoice;
}
