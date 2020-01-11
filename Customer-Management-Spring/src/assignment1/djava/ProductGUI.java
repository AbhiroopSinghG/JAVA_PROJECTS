/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.djava;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


/**
 *
 * @author Abhi
 */
public class ProductGUI extends JPanel{
  
    private JLabel lblProductID;
    private JTextField txtProductID;
    private JLabel lblProductName;
    private JTextField txtProductName;
    private JLabel lblProductPrice;
    private JTextField txtProductPrice;
    private JLabel lblProductQuantity;
    private JTextField txtProductQuantity;
    private JButton butAdd;
    private JButton butFind;
    private int dialogButton = JOptionPane.YES_NO_OPTION;

    
    public ProductGUI(){
        //create all the components
        
        lblProductID = new JLabel("Product ID");
        txtProductID = new JTextField(20);
        lblProductName = new JLabel("Product Name");
        txtProductName = new JTextField(20);
        lblProductPrice = new JLabel("Product Price");
        txtProductPrice = new JTextField(20);
        lblProductQuantity = new JLabel("Product Quantity");
        txtProductQuantity = new JTextField(20);
        butAdd= new JButton("Add");
        butFind= new JButton("Find");
        
        
        //set the layout
        this.setLayout(new GridLayout(5,2));
        this.add(lblProductID);
        this.add(txtProductID);
        this.add(lblProductName);
        this.add(txtProductName);
        this.add(lblProductPrice);
        this.add(txtProductPrice);
        this.add(lblProductQuantity);
        this.add(txtProductQuantity); 
        this.add(butAdd);
        this.add(butFind);
        
        
       butAdd.addActionListener(new EventHandler());
       butFind.addActionListener(new EventHandler());
       
    }
    
    
    static ProductDB prod_db=new ProductDB();
    private static List<String> errorList = new ArrayList<String>(5);
    
    public boolean validateFields(){
        boolean bool=true;
        
        
        if(txtProductID.getText().equals("")){
          String s_error="ProductId";
          errorList.add(s_error);
          bool=false;  
        }
        
        if(txtProductName.getText().equals("")){
          String s_error="ProductName";
          errorList.add(s_error);
          bool=false;  
        }
        
        if(txtProductPrice.getText().equals("")){
          String s_error="ProductPrice";
          errorList.add(s_error);
          bool=false;  
        }
        
        if(txtProductQuantity.getText().equals("")){
          String s_error="ProductQuantity";
          errorList.add(s_error);
          bool=false;  
        }
        
        return bool;
    }
    
    private class EventHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        if (ae.getSource()==butFind){
             
             if(txtProductID.getText().equals(""))
             {
                 JOptionPane.showMessageDialog(null, "Please enter a product id!!");
             }
  
             else{
             Product check;
             String text = txtProductID.getText();
             int pro_id = Integer.parseInt(text);
             check=prod_db.Find(pro_id);
             
             if(check==null){
                 JOptionPane.showMessageDialog(null, "Product not found!!");
                 return;
             }
             
             else{
                 String id=Integer.toString(check.getId());
                 txtProductID.setText(id);
                 
                 String quantity=Integer.toString(check.getQuantity());
                 txtProductQuantity.setText(quantity);
                 
                 String price=Double.toString(check.getPrice());
                 txtProductPrice.setText(price);
               
                 txtProductName.setText(check.getName());
                 JOptionPane.showMessageDialog(null, "Product found!");
             }
            }
         }
            
            if (validateFields()){
                
            
            if (ae.getSource() == butAdd){
                Product p=new Product();
                
                String text = txtProductID.getText();
                int pro_id = Integer.parseInt(text);
                p.setId(pro_id);
                
                text = txtProductName.getText();
                p.setName(text);
                
                text = txtProductPrice.getText();
                double pro_price = Double.parseDouble(text);
                p.setPrice(pro_price);
                
                text = txtProductQuantity.getText();
                int pro_quantity = Integer.parseInt(text);
                p.setQuantity(pro_quantity);
                
                Product check;
                check=prod_db.Find(pro_id);
                
                if(check==null){
                    prod_db.Add(p);
                    JOptionPane.showMessageDialog(null, "Product Record Added");
                }
                
                else{
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to modify the item?", "Product with same ID already exists!", dialogButton);
                    if(dialogResult == 0) {
                    int pos=prod_db.Find(check);
                    
                    text = txtProductName.getText();
                    prod_db.getList().get(pos).setName(text);
                    txtProductName.setText("");
                
                    text = txtProductPrice.getText();
                    pro_price = Double.parseDouble(text);
                    prod_db.getList().get(pos).setPrice(pro_price);
                    txtProductPrice.setText("");
                
                    text = txtProductQuantity.getText();
                    pro_quantity = Integer.parseInt(text);
                    prod_db.list.get(pos).setQuantity(pro_quantity);
                    txtProductQuantity.setText("");
                    
                    txtProductID.setText("");
                    
                     JOptionPane.showMessageDialog(null, "Product Record Modified");
                    } else {
                    System.out.println("No");
                    } 
                }
            }
            }
            
            else{
                String message="";
                for(int i=0; i<errorList.size(); i++)
                message=message+errorList.get(i)+", ";
                
                message="Please enter "+message;
                JOptionPane.showMessageDialog(null, message);
                errorList.clear();
            }   
    
        }
        
    }
    
}
