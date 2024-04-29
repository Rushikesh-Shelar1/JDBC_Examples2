package jdbc_projects;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","tiger");
		Statement st=con.createStatement();
		//String query= "insert into emp3 value(4,'kapil')";
		int id=13;
		String name="Ram";
		String query1=String.format("insert into emp3 value(%d,'%s')",id,name);
		//String query2=String.format("update emp3 set name='piyush'where id=%d",id);
		//String query="update emp3 set name='ramesh' where id=4";
		//String query="delete from emp3 where id=4";
		//int result=st.executeUpdate(query2);
		//System.out.println(result);
		String query3= "select * from emp3";
		ResultSet rs= st.executeQuery(query3);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		con.close();

	}

}
