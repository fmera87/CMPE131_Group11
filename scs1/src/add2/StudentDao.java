package add2;

/*
@author: Divyang Soni
@date : 10/18/2017
@ This class is having database related methods for login application
*/
import java.sql.*;

public class StudentDao {

	public static boolean save(String username, String sid) {//name section
		boolean isRecordInserted = false;
		try {
			//defining database driver to use
			Class.forName("com.mysql.jdbc.Driver");
			
			//getting connection from the mysql database
			//jdbc:mysql://localhost:3306 is database url
			//login is database name
			//root : username
			//root: password
			//syntex : databaseurl/databasename, username , password
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/friends", "root", "root");
			
			

			//prepared statement is used for secure access
			// ? used for data to put in query
			// actual query to execute is
			// select * from users where username = name and password = pass
			PreparedStatement oPrStmt = con
					.prepareStatement("INSERT INTO friends (username,sid) VALUES(?,?)");// ? represents some parameter to include
																							
			oPrStmt.setString(1, username);// parameter index start from 1 //name
			oPrStmt.setString(2, sid);//section
			int nInsertedRecords = oPrStmt.executeUpdate(); // executing the query and getting the updated/inserted row counts from databse
			
			if(nInsertedRecords>0){ // check that the data is inserted successfully or not
				isRecordInserted = true;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return isRecordInserted;
	}
}
