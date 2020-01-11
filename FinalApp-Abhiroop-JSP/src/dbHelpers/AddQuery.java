package dbHelpers;
import java.sql.*;

import model.Products;

public class AddQuery {
	
	public Connection connection;
	public ResultSet results;
	
	public AddQuery() {
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
	
	public int doAdd(String code,String description,double price) throws SQLException {
		Statement st= connection.createStatement();
		
		Products product=new Products();
		product.setCode(code);
		product.setDescription(description);
		product.setPrice(price);

		String sql = "insert into products (Code,Description,Price) values ('"+product.getCode()+"','"+product.getDescription()+"','"+product.getPrice()+"')";
		int res = st.executeUpdate(sql);
		
		return res;
	}
	
}
