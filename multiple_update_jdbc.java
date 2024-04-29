package jdbc_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class multiple_update_jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		Statement st1=con.createStatement();
		System.out.println("enter the increment salary");
		int increment=sc.nextInt();
		System.out.println("enter the limit..");
		int limit=sc.nextInt();
		String query2=String.format("update emp4 set salary=salary+%d where salary<%d",increment,limit);
		int result=st1.executeUpdate(query2);
		if (result>0) 
            System.out.println("successfully updated"); 

        else
            System.out.println("unsucessful update "); 

        
		con.close(); 
	}

}
