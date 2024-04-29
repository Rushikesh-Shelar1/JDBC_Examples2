package jdbc_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class prepareed_sat_multiple_update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		String query="select name,salary from emp4 where salary<? order by salary desc";
		PreparedStatement pst=con.prepareStatement(query);
		System.out.println("enter the limit..");
		int limit=sc.nextInt();
		pst.setInt(1,limit);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {

			//System.out.print(" emp Id: "+rs.getInt(1));
			System.out.print(" emp name: "+rs.getString(1));
			System.out.print(" --emp salary: "+rs.getInt(2));
			System.out.println(" ");
		}

		con.close();
	}

}
