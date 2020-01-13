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
import javax.swing.*;

/**
 *
 * @author Abhi
 */
public class IOFrame extends JInternalFrame{
    private JPanel IOGUI;
    private JLabel lblHeading;
    private JMenuBar mbMenu;
    private JMenu mOptions;
    private JMenuItem miLoad;
    private JMenuItem miSave;
    private JMenuItem miExit;
    
    public IOFrame(JPanel studentIOPanel){
        miLoad = new JMenuItem("Load");
        miSave = new JMenuItem("Save");
        miExit = new JMenuItem("Exit");
        
        mOptions = new JMenu("Options");
        
        mOptions.add(miLoad);
        mOptions.add(miSave);
        mOptions.add(miExit);
        
        mbMenu= new JMenuBar();
        
        mbMenu.add(mOptions);
        
        lblHeading= new JLabel("Add New Product");
        
        KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        miSave.setAccelerator(keyStrokeToSave);
        
        KeyStroke keyStrokeToLoad = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        miLoad.setAccelerator(keyStrokeToLoad);
        
        KeyStroke keyStrokeToExit = KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK);
        miExit.setAccelerator(keyStrokeToExit);
        
        
        this.setLayout(new BorderLayout());
        this.add(lblHeading,BorderLayout.NORTH);
        this.add(new ProductGUI(),BorderLayout.CENTER);
       
    
        this.setSize(400,200);
        this.setJMenuBar(mbMenu);
        this.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
        IOGUI = studentIOPanel;
        this.add(IOGUI);
        this.setSize(500,200);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setClosable(true);
        this.setResizable(true);
    }
    
    private class EventHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           if(ae.getSource()==miSave){
               ProductGUI.prod_db.Save();
               JOptionPane.showMessageDialog(null, "Record saved to file");
           }
           if(ae.getSource()==miLoad)
               try{
               ProductGUI.prod_db.Load();
               }
           catch(FileNotFoundException io){
               System.out.println("error");
           }
           if(ae.getSource()==miExit)
              System.exit(0);
        }
  }
}
    
