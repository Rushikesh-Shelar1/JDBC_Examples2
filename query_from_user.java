package jdbc_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class query_from_user {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		while(true) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		Statement st1=con.createStatement();
		System.out.println("enter the query ");
		Scanner sc = new Scanner(System.in);
		String query=sc.nextLine();
		boolean flag=st1.execute(query);
		if(flag==true) {
		ResultSet rs= st1.getResultSet();
		while(rs.next()) {

			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
		}
		else {
			int result=st1.getUpdateCount();
			System.out.println(result);
		
			}
		con.close();
		System.out.println("do you want to continue to insert the data [yes/no]");
        String ch=sc.nextLine();
        if(ch.equalsIgnoreCase("NO"))
        	break;
		}

	}

}
