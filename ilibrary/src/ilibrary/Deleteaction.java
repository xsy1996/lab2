package ilibrary;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Deleteaction extends ActionSupport{
	Book delbook=new Book();

	public Deleteaction(){};
	
	public Deleteaction(Book delbook) {
		super();
		this.delbook = delbook;
	}

	public Book getDelbook() {
		return delbook;
	}

	public void setDelbook(Book delbook) {
		this.delbook = delbook;
	}
	
	public String del()
	{
		Service t=new Service();
		t.deletebook(delbook.getISBN());
		return SUCCESS;
	}
}
