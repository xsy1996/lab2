package ilibrary;

public class Author {
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getOld() {
		return Old;
	}
	public void setOld(String old) {
		Old = old;
	}
	public String getNation() {
		return Nation;
	}
	public void setNation(String nation) {
		Nation = nation;
	}
	public Author(String name, String authorID, String old, String nation) {
		super();
		Name = name;
		AuthorID = authorID;
		Old = old;
		Nation = nation;
	}
	public Author(){}
	private String Name;
	private String AuthorID;
	private String Old;
	private String Nation;
}
