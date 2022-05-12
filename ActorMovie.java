package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ActorMovie {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
	
		
		
		String jdbcUrl = "jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3380500\\Movies.db";
		try {
			
			
			
			Connection connection = DriverManager.getConnection(jdbcUrl);
			System.out.println("Enter Actor name");
			String act=sc.next();
			String sql = "SELECT m_name FROM movies where Actor=? ";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,act);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				String m_name = result.getString("m_name");
				//String Actor = result.getString("Actor");
				//String Actress = result.getString("actress");
				//String Director = result.getString("Director");
				//String Year_of_release = result.getString("Year_of_release"+"");
				
				System.out.println("Movie Name="+m_name );
				System.out.println();
				
				
				
				
				
			}
			
		} catch (SQLException e) {
			System.out.println("error connecting to SQLite database ");
			e.printStackTrace();
		}
		
		sc.close();

	}



	}


