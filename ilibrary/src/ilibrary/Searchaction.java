package ilibrary;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;


public class Searchaction extends ActionSupport{
	private Author author=new Author();
	private List<Book> booklst;
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public List<Book> getBooklst() {
		return booklst;
	}
	public void setBooklst(List<Book> booklst) {
		this.booklst = booklst;
	}
	public String search_as_author(){
		Service t=new Service();
		List<Book> lsttemp;
		System.out.println(author.getName());
		lsttemp=t.get_book_as_author(author.getName());
		setBooklst(lsttemp);
		for(int i=0;i<booklst.size();i++)
			System.out.println(booklst.get(i).getTitle());
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		
		return SUCCESS;
	}
}
