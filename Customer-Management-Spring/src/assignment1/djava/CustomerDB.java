/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.djava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abhi
 */
public class CustomerDB {
     private String fileName;
    List<Customer> list;
    
    public CustomerDB(){
        this.setFileName("customers.txt");
        this.setList(new ArrayList<Customer>());
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }
    
    public void Add(Customer customer){
        list.add(customer);
    }
    
     public Customer Find(int id){
       Customer c = null;
       for(int i=0; i<this.list.size(); i++){
           if(this.list.get(i).getId()==id){
               c= this.list.get(i);
               break;
           }
       }
       return c;
    }
     
    public int Find(Customer c){
        int pos=0;
        for(int i=0; i<list.size(); i++){
           if(list.get(i).getId()==c.getId()){
               pos=i;
               break;
           }
       }
       return pos;
    }
     
    public void Save(){
        try{
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("customers.txt"));       
   
       for(int i=0; i<this.getList().size();i++){
            outputStream.writeUTF(Integer.toString(this.getList().get(i).getId()));
            outputStream.writeUTF(this.getList().get(i).getName());
            outputStream.writeUTF(Integer.toString(this.getList().get(i).getPhone()));
            outputStream.writeUTF(this.getList().get(i).getEmail());
            outputStream.writeUTF(this.getList().get(i).getPostal_code());
        }  
        outputStream.close();
    }
    catch(IOException io){
          System.out.println("File not found!!");
        }
    }
    
    public List<Customer> Load() throws FileNotFoundException, IOException{
        try{
         this.list.clear();
         DataInputStream inputStream = new DataInputStream(new FileInputStream("customers.txt"));
         while(inputStream.available()>0){
            Customer cust=new Customer();
            int num=Integer.parseInt(inputStream.readUTF());
            cust.setId(num);
            cust.setName(inputStream.readUTF());
            num=Integer.parseInt(inputStream.readUTF());
            cust.setPhone(num);
            cust.setEmail(inputStream.readUTF());
            cust.setPostal_code(inputStream.readUTF());
            this.getList().add(cust);
         }
         inputStream.close();
        }
        catch(IOException ex){
            System.out.println("");
        }
        return this.getList();
    }
}
