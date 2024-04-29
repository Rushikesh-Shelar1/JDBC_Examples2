package jdbc_projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class delete_using_loop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
		System.out.println("enter the id that you want to delete");
		int id=Integer.parseInt(br.readLine());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		Statement st=con.createStatement();
		String query=String.format("delete from emp3 where id=%d",id);
		int result=st.executeUpdate(query);
		if (result>0) 
            System.out.println("successfully deleted"); 

        else
            System.out.println("unsucessful deleted "); 

        
		con.close(); 
        System.out.println("do you want to continue to delete the data [yes/no]");
        String ch=br.readLine();
        if(ch.equalsIgnoreCase("NO"))
        	break;
		
		}

	}

}
