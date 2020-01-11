package dbHelpers;
import java.sql.*;

import model.Products;

public class DeleteQuery {
	
	public Connection connection;
	public ResultSet results;
	
	public DeleteQuery() {
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
	
	public int doDelete(int code) throws SQLException {
		Statement st= connection.createStatement();
		

		String sql = "delete from products where code="+code;
		int res = st.executeUpdate(sql);
		
		return res;
	}
	
}
