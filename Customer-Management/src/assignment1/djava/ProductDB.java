/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.djava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Abhi
 */
public class ProductDB {
    private String fileName;
    List<Product> list;
    
    public ProductDB(){
        this.setFileName("products.txt");
        this.setList(new ArrayList<Product>());
    }
    
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
    
    public void Add(Product product){
        list.add(product);
    }
    
    public Product Find(int id){
       Product p = null;
       for(int i=0; i<list.size(); i++){
           if(list.get(i).getId()==id){
               p= list.get(i);
               break;
           }
       }
       return p;
    }
    
    public int Find(Product p){
        int pos=0;
        for(int i=0; i<list.size(); i++){
           if(list.get(i).getId()==p.getId()){
               pos=i;
               break;
           }
       }
       return pos;
    }
    
    public void Save(){
        try{
                java.io.File file = new java.io.File("products.txt");
                java.io.PrintWriter output = new java.io.PrintWriter(file);
                output.println(this.list);
                output.close();
                }
                catch(IOException io){
                    System.out.println(io.getMessage());
                }
    }
    
    public void Load() throws FileNotFoundException{
        Scanner s = new Scanner(new File("products.txt"));
        list.clear();
        while (s.hasNext()){
            System.out.println(s.next());
        }
        s.close();
        }
    
}
