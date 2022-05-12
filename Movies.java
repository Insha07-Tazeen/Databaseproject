package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Movies {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3380500\\Movies.db";
		try {
			Connection connection=DriverManager.getConnection(jdbcUrl);
			String sql="SELECT * FROM movies";
			
			Statement statement = connection.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next()) {
				String m_name=result.getString("m_name");
				String Actor=result.getString("Actor");
				String Actress=result.getString("Actress");
				String Director=result.getString("Director");
				String Year_of_release=result.getString("Year_of_release");
				
				System.out.println(m_name+ " | " +Actor+ " | " +Actress+ " | "+Director+ " | "+Year_of_release);
			}
		} catch (SQLException e)
		{
			System.out.println("Error connecting to SQLite database");
			e.printStackTrace();
		}
		

	}

}
