package jdbc_projects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class callable_demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		CallableStatement cs=con.prepareCall("{call insert_data1(?,?,?)}");
		while(true) {
		System.out.println("enter the id");
		int id=sc.nextInt();
		cs.setInt(1,id);
		
		System.out.println("enter the name");
		String name1=sc.next();
		cs.setString(2, name1);
		
		System.out.println("enter the salary");
		int salary=sc.nextInt();
		cs.setInt(3,salary);
		
		cs.execute();
		System.out.println("do you want to continue to insert the data [yes/no]");
        String ch=sc.next();
        if(ch.equalsIgnoreCase("NO"))
        	break;
		
		}
		con.close();
		
	}

}
