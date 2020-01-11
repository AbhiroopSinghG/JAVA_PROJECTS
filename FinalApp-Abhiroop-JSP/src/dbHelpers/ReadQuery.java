package dbHelpers;
import java.sql.*;

import model.Products;

public class ReadQuery {
	
	public Connection connection;
	public ResultSet results;
	
	public ReadQuery() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String username="root";
		  String password="12345";
		  String url ="jdbc:mysql://localhost:3306/finalexam" ;
		  try {
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void doRead() {
		try {
			String query="Select * from products";
			PreparedStatement ps= connection.prepareStatement(query);
			this.results=ps.executeQuery();
		}catch(SQLException ex) {}
	}
	
	public String getHTMLTable() throws SQLException {
		String table="";
		table+="<table border=1>";
		table+="<form method='Get'>";
		
		while(this.results.next()) {
			
			Products product=new Products();
			product.setCode(this.results.getString("Code"));
			product.setDescription(this.results.getString("Description"));
			product.setPrice(this.results.getDouble("Price"));
			
			table+="<tr>";
			table+="<td>";
			table+=product.getCode();
			table+="</td>";
			table+="<td>";
			table+=product.getDescription();
			table+="</td>";
			table+="<td>";
			table+=product.getPrice();
			table+="</td>";
			table+="<td>";
			table+="<button type='submit' name='Delete' formaction='Delete' value="+product.getCode()+">Delete</button>";
			table+="</td>";
			table+="</tr>";
		}
		table+="<form>";
		table+="</table>";
		return table;
		
	}
}
