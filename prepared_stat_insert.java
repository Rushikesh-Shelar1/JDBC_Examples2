package jdbc_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class prepared_stat_insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
			String query="insert into emp4 value(?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			while(true) {
				System.out.println("enter the id");
				int id=sc.nextInt();
				System.out.println("enter the name");
				String name1=sc.next();
				System.out.println("enter the salary");
				int salary=sc.nextInt();
	
		pst.setInt(1,id);
		pst.setString(2,name1);
		pst.setInt(3,salary);
		int result=pst.executeUpdate();
		System.out.println(result);
		if (result>0) 
            System.out.println("successfully inserted"); 

        else
            System.out.println("unsucessful insertion "); 

        
		 
        System.out.println("do you want to continue to insert the data [yes/no]");
        String ch=sc.next();
        if(ch.equalsIgnoreCase("NO"))
        	break;
		}
		con.close();
	}

}
