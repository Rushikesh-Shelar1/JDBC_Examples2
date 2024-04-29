package jdbc_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class prepared_stat_delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		String query="delete from emp4 where id=?";
		PreparedStatement pst=con.prepareStatement(query);
		while(true) {
			System.out.println("enter the id that you want to delete");
			int id=sc.nextInt();
			
	pst.setInt(1,id);
	int result=pst.executeUpdate();
	System.out.println(result);
	if (result>0) 
        System.out.println("successfully deleted"); 

    else
        System.out.println("unsucessful deleted "); 

    
	 
    System.out.println("do you want to continue to insert the data [yes/no]");
    String ch=sc.next();
    if(ch.equalsIgnoreCase("NO"))
    	break;
	}
	con.close();

	}

}
