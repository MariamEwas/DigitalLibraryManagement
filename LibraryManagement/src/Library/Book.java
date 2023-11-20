package Library;


public class Book {
	private String title;
	private int numberOfUnits;
	private String Author;
	private int numpages;
	private String publication;
	boolean isAvailable;
	public Book(String title2,  String author2, int num_pages2 , String publication2) {
		title=title2;
		Author = author2;
		numpages=num_pages2;
		publication = publication2;
		numberOfUnits = 1;
	}
	public void showInfo() {
		System.out.println( "Title : "+ title +" | Author : "+Author + " | Number Of Pages : "
				+numpages +" | Publication : "+publication);
		
	}
	// cat 1    cat2    cat3
	// book1   book
	// book2
	// book3
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	public void setAuthor(String pb) {
		Author=pb;
	}
	public String getAuthor() {
		return Author;
	}
	public void setPublication(String pb) {
		publication=pb;
	}
	public String getPublication() {
		return publication;
	}
	public void setNumpages(int num) {
		numpages=num;
	}
	public int getNumpages() {
		return numpages;
	}
	
}
