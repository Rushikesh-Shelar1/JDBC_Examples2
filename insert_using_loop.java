package jdbc_projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;

public class insert_using_loop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("enter the id");
		int id=Integer.parseInt(br.readLine());
		System.out.println("enter the name");
		String name1=br.readLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		Statement st1=con.createStatement();
		String query1=String.format("insert into emp3 value(%d,'%s')",id,name1);
		int result=st1.executeUpdate(query1);
		if (result>0) 
            System.out.println("successfully inserted"); 

        else
            System.out.println("unsucessful insertion "); 

        
		con.close(); 
        System.out.println("do you want to continue to insert the data [yes/no]");
        String ch=br.readLine();
        if(ch.equalsIgnoreCase("NO"))
        	break;
        	
		}
		
		
	}

}
