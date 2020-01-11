package model;

public class Products {
	private String Code;
	private String Description;
	private double price;
	
	
	public Products() {
		this.Code="";
		this.Description="";
		this.price=0;
	}


	public Products(String code, String description, double price) {
		super();
		Code = code;
		Description = description;
		this.price = price;
	}
	
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
