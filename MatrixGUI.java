/********************************************************************
 * Programmer:  Amy Mann
 * Class:  CS40S
 *
 * Assignment: Assignment 0.5
 * Program Name:  Matrix GUI
 *
 * Description: matrix math GUI
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

public class MatrixGUI extends javax.swing.JFrame {
    
    ArrayList<Table> tables = new ArrayList();
    MatrixMath math;        // pointer to new MatrixMath object
    Table matrix1;
    Table matrix2;
    private DefaultListModel listModel = new DefaultListModel();
    
    String nl = System.lineSeparator(); // universal new line character
    public static final Color AMY = new Color(221, 236, 239); // look I created my own colour!!
    public static final Color BELLA = new Color(184, 185, 187); // this one is named after my dog
    public static final Color LOLA = new Color(188, 70, 118); // this one is named after my grandmother
    public static final Color SARAH = new Color(135, 170, 174); // this one is named after my sister
    public static final Color MARCH = new Color(191, 217, 218); // this one is named after my favourite month
    
    public MatrixGUI() {
        initComponents();
    }

    private void initComponents() {
        listLabel = new javax.swing.JLabel();
        rowLabel = new javax.swing.JLabel("rows:");
        columnLabel = new javax.swing.JLabel("columns:");
        table1Label = new javax.swing.JLabel("table 1:");
        table2Label = new javax.swing.JLabel("table 2:");
        listScroller = new javax.swing.JScrollPane();
        tablesList = new javax.swing.JList();
        table1DetailTxt = new javax.swing.JTextArea();
        table2DetailTxt = new javax.swing.JTextArea();
        calculationDetailTxt = new javax.swing.JTextArea();
        
        matrixProductButton = new javax.swing.JButton();
        scalarProductButton = new javax.swing.JButton();
        sumButton = new javax.swing.JButton();
        transposeButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        
        SpinnerModel rowSpinnerModel = new SpinnerNumberModel(1, //initial value
         1, //min
         10, //max
         1);//step
         SpinnerModel columnSpinnerModel = new SpinnerNumberModel(1, 1,10,1);
        rowSpinner = new javax.swing.JSpinner(rowSpinnerModel);
        columnSpinner = new javax.swing.JSpinner(columnSpinnerModel);
       
        matrixProductButton.setText("matrix product");
        matrixProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matrixProductBtnActionPerformed(evt);
            }
        });

        sumButton.setText("sum");
        sumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumBtnActionPerformed(evt);
            }
        });

        scalarProductButton.setText("scalar product");
        scalarProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scalarProductBtnActionPerformed(evt);
            }
        });

        transposeButton.setText("transpose");
        transposeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transposeBtnActionPerformed(evt);
            }
        });
        
        generateButton.setText("generate table");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });
        
        selectButton.setText("select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBtnActionPerformed(evt);
            }
        });
        
        removeButton.setText("delete table");
        removeButton.setVisible(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        
        clearButton.setText("clear tables");
        clearButton.setVisible(false);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        
        
        listLabel.setText("Tables:");

        tablesList.setModel(listModel);
        tablesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listScroller.setViewportView(tablesList);
        
        mainFrame = new javax.swing.JFrame("Matrix Calculator");
        mainFrame.setLayout(new GridLayout(2,1));

        headerLabel = new javax.swing.JLabel("",javax.swing.JLabel.CENTER );
        statusLabel = new javax.swing.JLabel("",javax.swing.JLabel.CENTER); 
        statusLabel.setSize(350,100);
        statusLabel.setText("You have no tables. Press generate to generate a new table.");
        tableStatusPanel = new javax.swing.JPanel();
        tableStatusPanel.setBackground(SARAH);
        tableStatusPanel.add(statusLabel);
        table1DetailTxt.setVisible(false);
        table2DetailTxt.setVisible(false);
        table1Label.setVisible(false);
        table2Label.setVisible(false);
        table1DetailTxt.setBackground(SARAH);
        table2DetailTxt.setBackground(SARAH);
        //GroupLayout tableStatusPanelLayout = new javax.swing.GroupLayout(tableStatusPanel);
        //tableStatusPanelLayout.setHorizontalGroup(tableStatusPanelLayout.createSequentialGroup()
        //    .addComponent(table1Label)
        //    .addComponent(table2Label)
        //    .addGroup(tableStatusPanelLayout.createSequentialGroup()
        //    .addComponent(table1DetailTxt)
        //    .addComponent(table2DetailTxt))); 
        //tableStatusPanelLayout.setVerticalGroup(tableStatusPanelLayout.createParallelGroup()
        //    .addComponent(table1Label)
        //    .addComponent(table2Label)
        //    .addComponent(table1DetailTxt)
        //    .addComponent(table2DetailTxt));
        tableStatusPanel.add(table1Label);
        tableStatusPanel.add(table2Label);
        tableStatusPanel.add(table1DetailTxt);
        tableStatusPanel.add(table2DetailTxt);
        //tableStatusPanel.setLayout(tableStatusPanelLayout);
        
        controlPanel = new javax.swing.JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setSize(new Dimension(600, 500));
        controlPanel.setBackground(MARCH);

        headerLabel.setText("Matrix Calculator");      
        
        JPanel calculationsPanel = new JPanel();
        calculationsPanel.setBackground(LOLA);
        calculationsPanel.add(calculationDetailTxt);
        calculationDetailTxt.setBackground(LOLA);
        calculationDetailTxt.setVisible(false);
        
        JPanel panel = new JPanel();
        panel.setBackground(AMY);
        panel.setPreferredSize(new Dimension(500, 400));
        panel.setMaximumSize(panel.getPreferredSize()); 
        panel.setMinimumSize(panel.getPreferredSize());
        GroupLayout layout = new javax.swing.GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
            .addComponent(headerLabel)
            .addComponent(generateButton)
            .addComponent(removeButton)
            .addComponent(rowLabel)
            .addComponent(columnLabel)
            .addComponent(rowSpinner)
            .addComponent(columnSpinner)
            .addComponent(selectButton)
            .addComponent(clearButton)
            .addGroup(layout.createParallelGroup(
          GroupLayout.Alignment.LEADING)
            .addComponent(scalarProductButton)
            .addComponent(sumButton)
            .addComponent(transposeButton)
            .addComponent(matrixProductButton))); 
   
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(headerLabel)
            .addComponent(generateButton)
            .addComponent(removeButton)
            .addComponent(matrixProductButton)
            .addComponent(scalarProductButton)
            .addComponent(sumButton)
            .addComponent(selectButton)
            .addComponent(transposeButton)
            .addComponent(rowLabel)
            .addComponent(rowSpinner)
            .addComponent(columnLabel)
            .addComponent(columnSpinner)
            .addComponent(clearButton));
        
        scalarProductButton.setVisible(false);
        matrixProductButton.setVisible(false);
        sumButton.setVisible(false);
        transposeButton.setVisible(false);
        selectButton.setVisible(false);
        
        mainFrame.add(controlPanel);
        mainFrame.add(tableStatusPanel);
        mainFrame.add(listScroller);
        mainFrame.add(calculationsPanel);
        mainFrame.setBackground(BELLA);
            
        panel.setLayout(layout);        
        controlPanel.add(panel);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true); 

    }// </editor-fold>//GEN-END:initComponents

    private void matrixProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        if(matrix1 != null && matrix2 != null){
        math = new MatrixMath(matrix1, matrix2);
        calculationDetailTxt.setText("Matrix product is: " + nl + math.product().toString());
        calculationDetailTxt.setVisible(true);
    } else{
        calculationDetailTxt.setText("Error: Please select two tables to perform matrix multiplication");
    }
    }//GEN-LAST:event_createBtnActionPerformed
    private void sumBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        math = new MatrixMath(matrix1, matrix2);
        calculationDetailTxt.setText("Sum is: " + nl + math.sum().toString());
        calculationDetailTxt.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed
    private void scalarProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        math = new MatrixMath(matrix1, matrix2);
        calculationDetailTxt.setText("Product of table 1 and the first number of table 2 is: " + nl + math.product(matrix1, matrix2.getElement(1,1)).toString());
        calculationDetailTxt.setVisible(true);
    }//GEN-LAST:event_deleteBtnActionPerformed
    private void transposeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getBtnActionPerformed
     math = new MatrixMath(matrix1, matrix2);
     calculationDetailTxt.setText("Transposing table 1: " + nl + math.transpose(matrix1).toString() + "Transposing table 2: "+ nl + math.transpose(matrix2).toString());
     calculationDetailTxt.setVisible(true);
    }//GEN-LAST:event_getBtnActionPerformed
    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getBtnActionPerformed
     //System.out.println("generating tables...");   
       int[][] t1 = new int[10][10];    // creates table

       Table table = null;            // pointer to table object
       
       Random rd = new Random();       // pointer to new Random object   
     
       // generates random table
       for(int i = 0; i < (int)rowSpinner.getValue(); i++){
            for(int k = 0; k < (int)columnSpinner.getValue(); k ++){
                   t1[i][k] = rd.nextInt(10);
                } // end for int k = 0
        } // end for int i = 0 
        table = new Table(t1, (int)rowSpinner.getValue(), (int)columnSpinner.getValue());   // creates table object
        
        tables.add(table);
        listModel.addElement(table);

        if(tables.size() == 1){
        statusLabel.setText("Select two tables to perform operations.");
        removeButton.setVisible(true);
        selectButton.setVisible(true);
    }
    }//GEN-LAST:event_getBtnActionPerformed
    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getBtnActionPerformed
        int n = tablesList.getSelectedIndex(); 
        try{   
            if(matrix1 != null){
            matrix2 = tables.get(n);
            table2Label.setVisible(true);
            table2DetailTxt.setText(tables.get(n).toString());
            table2DetailTxt.setVisible(true);
            statusLabel.setVisible(false);
            scalarProductButton.setVisible(true);
            matrixProductButton.setVisible(true);
            sumButton.setVisible(true);
            transposeButton.setVisible(true);
            selectButton.setVisible(false);
            } // end if
                else{
            matrix1 = tables.get(n);
            table1Label.setVisible(true);
            table1DetailTxt.setText(tables.get(n).toString());
            table1DetailTxt.setVisible(true);
            clearButton.setVisible(true);
        } // end else
        } // end try
        catch(ArrayIndexOutOfBoundsException e){
            statusLabel.setText("Error: Please select a table.");
        }
    }//end selectBtnActionPerformed
    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getBtnActionPerformed
           int n = tablesList.getSelectedIndex();
           try{
        listModel.remove(n);
        tables.remove(n);
        } // end try
        catch(ArrayIndexOutOfBoundsException e){
           statusLabel.setText("Please select a table to delete."); 
        } // end catch array out of bounds
        
    }// end removeBtnActionPerformed
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {
            matrix1 = null;
            matrix2 = null;
            table1DetailTxt.setVisible(false);
            table2DetailTxt.setVisible(false);
            statusLabel.setVisible(true);
            scalarProductButton.setVisible(false);
            matrixProductButton.setVisible(false);
            sumButton.setVisible(false);
            transposeButton.setVisible(false);
            selectButton.setVisible(true);
    }// end clearBtnActionPerformed
    public static void main(String args[]) {
        
              try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatrixGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrixGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrixGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrixGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {

           public void run() {
                new MatrixGUI();
            }
        }); 
   
    } // end main
    // Variables declaration
    private javax.swing.JFrame mainFrame;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel rowLabel;
    private javax.swing.JLabel columnLabel;
    private javax.swing.JLabel table1Label;
    private javax.swing.JLabel table2Label;
    private javax.swing.JTextArea table1DetailTxt;
    private javax.swing.JTextArea table2DetailTxt;
    private javax.swing.JTextArea calculationDetailTxt;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel tableStatusPanel;
    private javax.swing.JList tablesList;
    private javax.swing.JScrollPane listScroller;
    private javax.swing.JLabel listLabel;
    
    private javax.swing.JButton matrixProductButton;
    private javax.swing.JButton scalarProductButton;
    private javax.swing.JButton sumButton;
    private javax.swing.JButton transposeButton;
    private javax.swing.JButton generateButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton clearButton;

    
    private javax.swing.JSpinner rowSpinner;     // the number of rows in the table
    private javax.swing.JSpinner columnSpinner;  // the number of columns in the table
    // End of variables declaration
}  //end MatrixGUI Class
