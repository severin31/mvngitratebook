package fr.sev.mvnratebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.sev.mvnratebook.domain.Author;

public class AuthorDAO {

	String url = "jdbc:mysql://localhost/rateyourbooks?autoReconnect=true&useSSL=false";
	String login = "root";
	String passwd = "";
	Connection cn =null;
	Statement st =null;
	
	public void createAuthor(Author author) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO `authors` (`name`, `firstname`, `firstLanguage`, `birthyear`) " + "VALUES ('"
					+ author.getName() + "', '" 
					+ author.getFirstname() + "', '" 
					+ author.getFirstLanguage() + "', " 
					+ author.getBirthYear() + ")";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// : gestion erreur
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public ArrayList<Author> getListOfAllAuthors()	{
		ArrayList<Author> authors = new ArrayList<Author>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT id, name, firstname, birthyear FROM authors";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String firstName = rs.getString("firstName");
				int birthYear = rs.getInt("birthyear");
				authors.add(new Author(id, name, firstName, birthYear));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
  		} catch (ClassNotFoundException e) {
  			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authors;
		
		
		
		
		
		
		
		
	}

	public Author getAuthorById(int id) {
		Author author = new Author();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT `id`, `name`, `firstname`, `firstlanguage`, `birthyear` "
					+ "FROM `authors` WHERE `id` = " + id + ";";
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			author.setId(rs.getInt("id"));
			author.setName(rs.getString("name"));
			author.setFirstname(rs.getString("firstname"));
			author.setFirstLanguage(rs.getString("firstlanguage"));
			author.setBirthYear(rs.getInt("birthyear"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return author;
	}

	public void deleteAuthor(Author author) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			ps = cn.prepareStatement("DELETE FROM authors WHERE id = ?");
			ps.setInt(1, author.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} finally {
			try {
				ps.close();
				cn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
}
