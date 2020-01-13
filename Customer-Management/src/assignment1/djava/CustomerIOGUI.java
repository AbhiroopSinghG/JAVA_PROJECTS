/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.djava;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
/**
 *
 * @author Abhi
 */
public class CustomerIOGUI extends JInternalFrame {
     private JPanel IOGUI;
     private JLabel lblHeading;
    private JMenuBar mbMenu;
    private JMenu mOptions;
    private JMenuItem miFind;
    private JMenuItem miDisplay;
    private JMenuItem miExit;
    private JTextArea txtOutput;
    CustomerDB cdb;
     public CustomerIOGUI(JPanel customerIOPanel){
        txtOutput=new JTextArea();
        cdb=new CustomerDB();
        
        miFind = new JMenuItem("Find");
        miDisplay = new JMenuItem("Display");
        miExit = new JMenuItem("Exit");
        
        mOptions = new JMenu("Options");
        
        mOptions.add(miFind);
        mOptions.add(miDisplay);
        mOptions.add(miExit);
        
        mbMenu= new JMenuBar();
        
        mbMenu.add(mOptions);
        
        lblHeading= new JLabel("Customer Management Menu");
        
        KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
        miDisplay.setAccelerator(keyStrokeToSave);
        
        KeyStroke keyStrokeToLoad = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        miFind.setAccelerator(keyStrokeToLoad);
        
        KeyStroke keyStrokeToExit = KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK);
        miExit.setAccelerator(keyStrokeToExit);
    
        this.setLayout(new BorderLayout());
        this.add(lblHeading,BorderLayout.NORTH);
        this.add(new ProductGUI(),BorderLayout.CENTER);
        this.add(txtOutput,BorderLayout.SOUTH);
       
        this.setJMenuBar(mbMenu);
    
        this.setSize(600,300);
        this.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
        IOGUI = customerIOPanel;
        this.add(IOGUI);
        this.setSize(600,300);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setClosable(true);
        this.setResizable(true);
        
        miFind.addActionListener(new EventHandler());
        miDisplay.addActionListener(new EventHandler());
        miExit.addActionListener(new EventHandler());
}
     private class EventHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           if(ae.getSource()==miFind){
               try{
               cdb.Load();
               if(CustomerGUI.txtCustomerID.getText().equals(""))
                  JOptionPane.showMessageDialog(null, "Enter the Customer ID!");
               else
               {
                   Customer c=new Customer();
                   c=cdb.Find(Integer.parseInt(CustomerGUI.txtCustomerID.getText()));
                   if(c==null)
                        JOptionPane.showMessageDialog(null, "Customer ID not found!");
                   else{
                   txtOutput.setText(c.toString());
                   JOptionPane.showMessageDialog(null, "Customer found!");
                   }
               }
               }
               catch(IOException io){
                   System.out.println("File not Found");
               }
               
           }
           if(ae.getSource()==miDisplay){
               try{
               cdb.Load();
               txtOutput.setText(cdb.list.toString());
               }
               catch(IOException io){
                   System.out.println("File not Found");
               }
           }
           if(ae.getSource()==miExit){
               System.exit(0);
           }
        }
}
}
