package Library;

import java.util.ArrayList;

public class Category {
	private String Cat_name;
	int Cat_id;
	private ArrayList<Book> books ;
	
	public Category(String cat) {
		Cat_name=cat;
		books = new ArrayList<>();
	}

	public void showBooks() {
		for (Book b: books)
		{
			b.showInfo();
		}
	}

	public String getCat_name() {
		return Cat_name;
	}

	public void setCat_name(String cat_name) {
		Cat_name = cat_name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	
	
}
