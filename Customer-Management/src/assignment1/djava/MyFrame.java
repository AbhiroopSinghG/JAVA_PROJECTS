/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.djava;

import java.awt.BorderLayout;
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
public class MyFrame extends JFrame {
    
    private JLabel lblHeading;
    private JMenuBar mbMenu;
    private JMenu mOptions;
    private JMenuItem miLoad;
    private JMenuItem miSave;
    private JMenuItem miExit;
    private JMenuItem menuItemProduct;
    private JMenuItem menuItemCustomer;
    private JMenu menu;
    private JMenuBar mBar;
    private JDesktopPane desktop;
    
    private void initializeComponent(){
        menuItemProduct=new JMenuItem("Manage Products");
        menuItemCustomer=new JMenuItem("Manage Customers");
        menu=new JMenu("Options");
        menu.add(menuItemProduct);
        menu.add(menuItemCustomer);
        mBar=new JMenuBar();
        mBar.add(menu);
        this.setJMenuBar(mBar);
        desktop=new JDesktopPane();
        this.add(desktop);
    }
    
    public MyFrame(){
        
        this.initializeComponent();
        this.setSize(800,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Customer & Product Management");
        this.menuItemProduct.addActionListener(e->showInputProductGUI());
        this.menuItemCustomer.addActionListener(e->showInputCustomerGUI());
}
    
    public void showInputProductGUI(){
        ProductGUI sgui=new ProductGUI();
        JInternalFrame jaj=new IOFrame(sgui);
        jaj.setTitle("Product Management");
        this.desktop.add(jaj);
    }
    
    public void showInputCustomerGUI(){
        CustomerGUI cgui=new CustomerGUI();
        JInternalFrame jaj=new CustomerIOGUI(cgui);
        jaj.setTitle("Customer Management");
        this.desktop.add(jaj);
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
