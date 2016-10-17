package ilibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


///////////////////////////////////////////
public class Service{
	private static Connection con;
	public void linkdb() throws SQLException{
		String driver = "com.mysql.jdbc.Driver";
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		//System.getenv("MYSQL_HOST_S"); Îª´Ó¿â£¬Ö»¶Á
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		try {
		    Class.forName(driver).newInstance();
		    con = DriverManager.getConnection(dbUrl, username, password);

		} catch (Exception e) {e.printStackTrace();}
	}
	public void closelink() throws SQLException
	{
		con.close();
	}
	public List<Book> get_book_as_author(String author_name)
	{
		List<Book> lst=new ArrayList<Book>();
		try{
			linkdb();
			Statement sm=con.createStatement();
			ResultSet res=null;
			System.out.println("select * from author where Name="+"'"+author_name+"'"+";");
			res=sm.executeQuery("select * from author where Name="+"'"+author_name+"'"+";");
			int aut_id=0;
			if(res.next())
			{
				aut_id=res.getInt("AuthorID");
			}
			System.out.println("select * from book where AuthorID="+aut_id+";");
			res=sm.executeQuery("select * from book where AuthorID="+aut_id+";");
			while(res.next())
			{
				Book newbook=new Book();
				newbook.setISBN(res.getString("ISBN"));
				newbook.setTitle(res.getString("Title"));
				newbook.setAuthorID(res.getInt("AuthorID"));
				newbook.setPublisher(res.getString("Publisher"));
				newbook.setPublishDate(res.getString("PublishDate"));
				newbook.setPrice(res.getDouble("Price"));
				lst.add(newbook);
			}
		}catch(SQLException e){e.printStackTrace();};
		try{
			closelink();
		}catch(SQLException e){e.printStackTrace();};
		return lst;
	}
	public Book get_book_as_ISBN(String ISBN)
	{
		Book newbook=new Book();
		try{
			linkdb();
			Statement sm=con.createStatement();
			ResultSet res=null;
			System.out.println("select * from book where ISBN="+"'"+ISBN+"'"+";");
			res=sm.executeQuery("select * from book where ISBN="+"'"+ISBN+"'"+";");
			while(res.next())
			{
				newbook.setISBN(res.getString("ISBN"));
				newbook.setTitle(res.getString("Title"));
				newbook.setAuthorID(res.getInt("AuthorID"));
				newbook.setPublisher(res.getString("Publisher"));
				newbook.setPublishDate(res.getString("PublishDate"));
				newbook.setPrice(res.getDouble("Price"));
			}
		}catch(SQLException e){e.printStackTrace();};
		try{
			closelink();
		}catch(SQLException e){e.printStackTrace();};
		return newbook;
	}
	public Author get_author(Book viewbook)
	{
		Author aur=new Author();
		try{
			linkdb();
			Statement sm=con.createStatement();
			ResultSet res=null;
			System.out.println("select * from author where AuthorID="+"'"+viewbook.getAuthorID()+"'"+";");
			res=sm.executeQuery("select * from author where AuthorID="+"'"+viewbook.getAuthorID()+"'"+";");
			if(res.next()){
				aur.setAuthorID(res.getString("AuthorID"));
				aur.setName(res.getString("Name"));
				aur.setNation(res.getString("Nation"));
				aur.setOld(res.getString("Old"));
			}
			closelink();
		}catch(SQLException e){e.printStackTrace();};
		return aur;
	}
	public void deletebook(String ISBN)
	{
		try
		{
			linkdb();
			Statement sm=con.createStatement();
			sm.executeUpdate("delete from book where ISBN="+"'"+ISBN+"'"+";");
			System.out.println("delete from book where ISBN="+"'"+ISBN+"'"+";");
			closelink();
		}catch(SQLException e){e.printStackTrace();};
	}
}