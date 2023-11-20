package Modules;

import java.util.Scanner;

import Library.Book;
import Library.Category;
import Library.TheLibrary;
import Library.Transaction;

public class Admin {
	private String email;
	private String password;
	
	public Admin(String e, String pass)
	{
		setEmail(e);
		setPassword(pass);
	}
	
	public void addNewUser()

	{
		Scanner sc=new Scanner(System.in);
		String name,email,mobile;
		String f,m,l;
		System.out.println("Please Enter First Name : ");
		f=sc.next();
		System.out.println("Please Enter Middle Name : ");
		m=sc.next();
		System.out.println("Please Enter Last Name : ");
		l=sc.next();
		name=f+" "+m+" "+l;
		System.out.println("Please Enter Email : ");
		email = sc.next();
		System.out.println("Enter Mobile Number :");
		mobile=sc.next();
		System.out.println("Please Enter Age : ");
		int age =sc.nextInt();
		boolean flag=true;
		for (Users u : TheLibrary.users)
		{
			if (u.getEmail().equals(email))
			{
				flag=false;
				break;
			}
		}
		if (flag)
		{
			Users u = new Users(name,email,mobile,age);
			TheLibrary.users.add(u);
		}
		else 
		{
			System.out.println("A User With A Same Email exists ..");
		}
	}
	
	public void addNewBook()
	{
		Scanner sc =new Scanner(System.in);
		String title;
		String Author;
		int num_pages;
		String publication;
		String cat;
		
		System.out.println("Title : " );title=sc.nextLine(); //System.out.println();
		System.out.println("Author : " );Author=sc.nextLine(); //System.out.println();
		System.out.println("number of pages : " );num_pages=sc.nextInt(); //System.out.println();
		System.out.println("Category : " );cat=sc.next(); //System.out.println();
		System.out.println("publication : " );publication=sc.next(); //System.out.println();
		title=title.toLowerCase();
		Author=Author.toLowerCase();
		//Book newbook = new Book(title,Author,num_pages,publication);
		boolean f1=true;
		for (Category c : TheLibrary.cats)
		{
			if (c.getCat_name().equals(cat))
			{
				f1=false;
				boolean f = true;
				Book req = null;
				
				for (Book b: c.getBooks()){
					if (b.getTitle().equals(title)){ 
						f = false;
						req=b;
					}
				}
				if (f)
					c.getBooks().add(new Book(title,Author,num_pages,publication));
				else 
					req.setNumberOfUnits(req.getNumberOfUnits() + 1);
			}
		}
		
		if (f1)
		{
			Category newcat = new Category(cat);
			newcat.getBooks().add(new Book(title,Author,num_pages,publication));
			TheLibrary.cats.add(newcat);
		}
		
	}
	//1 -> Add a new Book
			//2 -> Update a Book
			//3 -> delete a book 
			//4 -> Add a New User
			//5 -> Modify Information about a user
			//6 -> delete a user
			//7 -> Add a new Admin
	public void deleteBook(){
		System.out.println("Title of The Book You want to delete : ");
		Scanner scanner = new Scanner(System.in);
		String t = scanner.next();
		t =t.toLowerCase();
		
		for (Category c : TheLibrary.cats)
		{
			for (Book b : c.getBooks())
			{
			 	if (b.getTitle().equals(t))
					b.setNumberOfUnits(b.getNumberOfUnits()-1);
				if (b.getNumberOfUnits() == 0)
					b = null;
				c.getBooks().remove(b);
			}
		}
		
	}
	
	public void deleteUser(){
		System.out.println("Email of The User You want to delete : ");
		Scanner scanner = new Scanner(System.in);
		String t = scanner.next();
		t =t.toLowerCase();
		
		for (Users u : TheLibrary.users)
		{
			if (u.getEmail().equals(t))
			{
				TheLibrary.users.remove(u);
				break;
			}
		}
	}
	
	public void addAdmin(){
		System.out.println("Add An Email : ");
		Scanner scanner = new Scanner(System.in);
		String email = scanner.next();
		System.out.println("Add a Password : ");
		String pass= scanner.next();
		for (Admin a : TheLibrary.admins)
		{
			if (a.getEmail().equals(email))
			{
				System.out.println("An Admin with the same Email exists ..");
				return;
			}
		}
		Admin newadmin = new Admin (email,pass);
		TheLibrary.admins.add(newadmin);
	}
	
	
	public void UpdateBook(){
		Scanner scanner = new Scanner (System.in);
		System.out.println("Write the Title of the book You want to update ");
		String chosen = scanner.nextLine();
		chosen = chosen.toLowerCase();
		Book mybook = null;
		for (Category c :TheLibrary.cats)
		{
			for (Book b : c.getBooks())
			{
				if (b.getTitle().equals(chosen)){
					mybook = b;
					break;
				}
			}
		}
		if (mybook == null)
		{
			System.out.println("No Such A Book ");
			return;
		}
		
		System.out.println("Choose What You want to update : ");
		System.out.println("1 -> Title");
		System.out.println("2 -> Publication");
		System.out.println("3 -> Author");
		System.out.println("4 -> number of pages");
		int choose = scanner.nextInt();
		switch(choose)
		{
		case 1 : 
			System.out.println ("New Title : ");
			String title=scanner.nextLine();
			mybook.setTitle(title);
			break;
		case 2 : 
			System.out.println("New Publication : ");
			String pb = scanner.nextLine();
			mybook.setPublication(pb);
			break;
			
		case 3 : 
			System.out.println ("New Author : ");
			String author=scanner.nextLine();
			mybook.setAuthor(author);
			break;
		case 4 : 
			System.out.println ("New Number Of Pages : ");
			int num=scanner.nextInt();
			mybook.setNumpages(num);
			break;
		default:System.out.println("Add A valid Number ");
		}
		
		
	}
	
	public void ModifyUser(){
		Scanner scanner = new Scanner (System.in);
		System.out.println("Write Email of the User You want to modify them information ");
		String chosen = scanner.next();
		Users myuser = null;
		for (Users  u:TheLibrary.users)
		{
			if (u.getEmail().equals(chosen)){
				myuser = u;
				break;
			}			
		}
		if (myuser == null)
		{
			System.out.println("No Such A User ");
			return;
		}
		
		System.out.println("Choose What You want to update : ");
		System.out.println("1 -> Name");
		System.out.println("2 -> Age");
		System.out.println("3 -> Email");
		System.out.println("4 -> mobile number ");
		int choose = scanner.nextInt();
		switch(choose)
		{
		case 1 : 
			System.out.println ("New Name : ");
			String name=scanner.nextLine();
			myuser.setName(name);
			break;
		case 2 : 
			System.out.println("New Age : ");
			int age = scanner.nextInt();
			myuser.setAge(age);
			break;
			
		case 3 : 
			System.out.println ("New Email : ");
			String mail=scanner.next();
			myuser.setEmail(mail);
			break;
		case 4 : 
			System.out.println ("New Number Of Pages : ");
			String num=scanner.next();
			myuser.setMobileNumber(num);
			break;
		default:System.out.println("Add A valid Number ");
		}
		
		
		
	}
	
	public void showUsers()
	{
		for (Users u : TheLibrary.users)
		{
			u.ShowInfo();
		}
	}
	

	public void showTransactions(){
		for (Transaction t : TheLibrary.trans)
		{
			t.showInfo();
		}
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
