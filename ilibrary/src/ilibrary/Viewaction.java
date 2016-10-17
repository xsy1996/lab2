package ilibrary;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


public class Viewaction extends ActionSupport{
	public Book getViewbook() {
		return viewbook;
	}

	public void setViewbook(Book viewbook) {
		this.viewbook = viewbook;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Viewaction(Book viewbook, Author author) {
		super();
		this.viewbook = viewbook;
		this.author = author;
	}

	public Viewaction() {}

	private Book viewbook;
	private Author author=new Author();
	
	public String view_detail(){
		Service t=new Service();
		Book tbook=t.get_book_as_ISBN(viewbook.getISBN());
		setViewbook(tbook);
		Author aur=t.get_author(viewbook);
		setAuthor(aur);
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		
		return SUCCESS;
	}
}