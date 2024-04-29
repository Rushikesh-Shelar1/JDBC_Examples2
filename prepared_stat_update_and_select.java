package jdbc_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class prepared_stat_update_and_select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		String query="update emp4 set salary=(salary+salary*0.5) where salary<=?";
		PreparedStatement pst=con.prepareStatement(query);

		System.out.println("enter the limit of salary that you want to update");
		int sal=sc.nextInt();
		
		pst.setInt(1,sal);
		int result=pst.executeUpdate();
		
		System.out.println(result);
		if (result>0) 
	        System.out.println("successfully updated"); 

	    else
	        System.out.println("unsucessful updated "); 
		String query1="select * from emp4 order by salary desc";
		
		PreparedStatement pst1=con.prepareStatement(query1);
		ResultSet rs=pst1.executeQuery();
		while(rs.next()) {

			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
		
		con.close();
		
	}

}
