package jdbc_projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update_using_loop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("enter the id to which you want to update the name");
		int id=Integer.parseInt(br.readLine());
		System.out.println("enter the name to update");
		String name1=br.readLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		Statement st1=con.createStatement();
		String query2=String.format("update emp3 set name='%s'where id=%d",name1,id);
		int result=st1.executeUpdate(query2);
		if (result>0) 
            System.out.println("successfully updated"); 

        else
            System.out.println("unsucessful update "); 

        
		con.close(); 
        System.out.println("do you want to continue to update the data [yes/no]");
        String ch=br.readLine();
        if(ch.equalsIgnoreCase("NO"))
        	break;
        	
		}
		

	}

}
