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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Abhi
 */
public class CustomerGUI extends JPanel{
    private JLabel lblCustomerID;
    public static JTextField txtCustomerID;
    private JLabel lblCustomerName;
    private JTextField txtCustomerName;
    private JLabel lblCustomerPhone;
    private JTextField txtCustomerPhone;
    private JLabel lblCustomerEmail;
    private JTextField txtCustomerEmail;
    private JLabel lblCustomerPostal;
    private JTextField txtCustomerPostal;
    private JButton butAdd;
    private JButton butModify;
    private int dialogButton = JOptionPane.YES_NO_OPTION;
    private CustomerDB cust_db;

    
    public CustomerGUI(){
        //create all the components
        
        lblCustomerID = new JLabel("Customer ID");
        txtCustomerID = new JTextField(20);
        lblCustomerName = new JLabel("Customer Name");
        txtCustomerName = new JTextField(20);
        lblCustomerPhone = new JLabel("Customer Phone");
        txtCustomerPhone = new JTextField(20);
        lblCustomerEmail = new JLabel("Customer Email");
        txtCustomerEmail = new JTextField(20);
        lblCustomerPostal = new JLabel("Customer Postal");
        txtCustomerPostal = new JTextField(20);
        butAdd= new JButton("Add");
        butModify= new JButton("Modify");
        cust_db=new CustomerDB();
        
        
        //set the layout
        this.setLayout(new GridLayout(6,2));
        this.add(lblCustomerID);
        this.add(txtCustomerID);
        this.add(lblCustomerName);
        this.add(txtCustomerName);
        this.add(lblCustomerPhone);
        this.add(txtCustomerPhone);
        this.add(lblCustomerEmail);
        this.add(txtCustomerEmail); 
        this.add(lblCustomerPostal);
        this.add(txtCustomerPostal); 
        this.add(butAdd);
        this.add(butModify);
        
        butAdd.addActionListener(new EventHandler());
        butModify.addActionListener(new EventHandler());
}
    private static List<String> errorList = new ArrayList<String>(5);
    
    public boolean validateFields(){
        boolean bool=true;
        
        if(txtCustomerID.getText().equals("")){
          String s_error="CustomerId";
          errorList.add(s_error);
          bool=false;  
        }
        if(txtCustomerName.getText().equals("")){
          String s_error="CustomerName";
          errorList.add(s_error);
          bool=false;  
        }
        if(txtCustomerPhone.getText().equals("")){
          String s_error="CustomerPhone";
          errorList.add(s_error);
          bool=false;  
        }
        if(txtCustomerEmail.getText().equals("")){
          String s_error="CustomerEmail";
          errorList.add(s_error);
          bool=false;  
        }
        if(txtCustomerPostal.getText().equals("")){
          String s_error="CustomerPostalCode";
          errorList.add(s_error);
          bool=false;  
        }
        
        return bool;
    }
    
     private class EventHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if (ae.getSource() == butAdd){
                if(validateFields()){
                
                String textID = txtCustomerID.getText();
                int cus_id = Integer.parseInt(textID);
                String textName = txtCustomerName.getText();
                String textPhone = txtCustomerPhone.getText();
                String textEmail = txtCustomerEmail.getText();
                String textPostal=txtCustomerPostal.getText();
                
                
                Customer check=null;
                
                try{
                cust_db.Load();
                check=cust_db.Find(cus_id);
                }
                catch(IOException io){
                    System.out.println("Customer File not Found!!");
                }
                
                if(check==null){
                    try{
                    DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("customers.txt",true));
                    outputStream.writeUTF(textID);
                    outputStream.writeUTF(textName);
                    outputStream.writeUTF(textPhone);
                    outputStream.writeUTF(textEmail);
                    outputStream.writeUTF(textPostal);
                    JOptionPane.showMessageDialog(null, "Product Record Added");
                    outputStream.close();
                }
                    catch(IOException io){
                        System.out.println("");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Customer Already Exists!!");
                }      
}else{
                String message="";
                for(int i=0; i<errorList.size(); i++)
                message=message+errorList.get(i)+", ";
                
                message="Please enter "+message;
                JOptionPane.showMessageDialog(null, message);
                errorList.clear();
            }
            }
            if (ae.getSource() == butModify){
                
                if(validateFields()){
                    
                String textID = txtCustomerID.getText();
                int cus_id = Integer.parseInt(textID);
                String textName = txtCustomerName.getText();
                String textPhone = txtCustomerPhone.getText();
                int phone = Integer.parseInt(textPhone);
                String textEmail = txtCustomerEmail.getText();
                String textPostal=txtCustomerPostal.getText();
                    
                try{
                    cust_db.Load();
                    Customer check=null;
                    check=cust_db.Find(cus_id);
                    
                    if(check==null)
                    JOptionPane.showMessageDialog(null, "Customer Not found!!");
                    
                    else{
                        int pos=cust_db.Find(check);
                        cust_db.getList().get(pos).setId(cus_id);
                        cust_db.getList().get(pos).setName(textName);
                        cust_db.getList().get(pos).setPhone(phone);
                        cust_db.getList().get(pos).setEmail(textEmail);
                        cust_db.getList().get(pos).setPostal_code(textPostal);
                        
                        cust_db.Save();
                        JOptionPane.showMessageDialog(null, "Customer Record Modified!");
                    }
                }
                catch(IOException io){
                    System.out.println("File not Found!!");
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
}
