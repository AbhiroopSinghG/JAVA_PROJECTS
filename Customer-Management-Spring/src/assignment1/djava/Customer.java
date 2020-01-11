/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.djava;

/**
 *
 * @author Abhi
 */
public class Customer {
    private int id;
    private String name;
    private int phone;
    private String Email;
    private String postal_code;
    
    public Customer(){
        
    }
    
    public Customer(int id,String name, int phone, String Email, String pcode){
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setEmail(Email);
        this.setPostal_code(pcode);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + " Name: " + name + " Phone: " + phone + " Email: " + Email + " Postal Code: " + postal_code+"\n";
    }
    
    
}
