package jdbc_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create_table_from_user_jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		Statement st1=con.createStatement();
		String query2=String.format("create table emp5(eno int,ename varchar(12),esal int)");
		int result=st1.executeUpdate(query2);
		System.out.println("created successfully");
		con.close();
	}

}
