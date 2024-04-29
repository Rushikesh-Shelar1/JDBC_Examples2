package jdbc_projects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class callable_fetch_and_display_salary {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		CallableStatement cs=con.prepareCall("{call fetch_data3(?,?,?)}");
		while(true) {
		System.out.println("enter the id to fetch name and salary");
		int id=sc.nextInt();
		cs.setInt(1,id);
		
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.registerOutParameter(3,Types.INTEGER);
		
		cs.execute();
		System.out.println("name:= "+cs.getString(2)+" salary:= "+cs.getInt(3));
		
		System.out.println("do you want to continue to insert the data [yes/no]");
        String ch=sc.next();
        if(ch.equalsIgnoreCase("NO"))
        	break;
		
		}
		con.close();

	}

}
