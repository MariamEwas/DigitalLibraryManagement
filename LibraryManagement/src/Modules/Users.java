package Modules;
import Library.DateClass;

import java.time.LocalDate;
import java.util.Scanner;

import Library.Book;
import Library.Category;
import Library.TheLibrary;
import Library.Transaction;
public class Users {
	private String name;
	private int age;
    static int ID = 1;
	private String email;
	private String mobileNumber;
	private int user_id ;
	public Users(String name,String email,String mobilenumber,int age)
	{
		this.age=age;
		this.name =name;
		this.email=email;
		this.mobileNumber = mobilenumber;
		user_id = ID++ ;
	}
	
	public void ShowInfo() {
		System.out.println("User ID : "+user_id+" | Name : "+ name +" | Email : "+email +" | Age : "+age
				+" | Mobile Number : "+mobileNumber);
	}
	public void SearchForBook()
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Title of the book you want to search for :");
		String title = sc.nextLine();
		title=title.toLowerCase();
		
		for (Category c: TheLibrary.cats){
			
			for (Book b : c.getBooks())
			{
				if (b.getTitle().equals(title))
				{
					System.out.println("Found");
					b.showInfo();
					return;
				}
			}
		}
		System.out.println("Not Found ");
	}
	public void MakeTransaction()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter The Title of The Book You want to borrow ");
		String title =sc.nextLine();
		title =title.toLowerCase();
		Book req =null;
		for (Category c: TheLibrary.cats){
			
			for (Book b : c.getBooks())
			{
				if (b.getTitle().equals(title))
				{
					if (b.getNumberOfUnits()>0){
						req=b;	
						req.setNumberOfUnits(req.getNumberOfUnits()-1);
					}
						break;
				}
			}
		}
		if (req == null)
			System.out.println("Not Found ");
		else 
		{
			DateClass start , end  ;
			LocalDate currentDate = LocalDate.now();
			DateClass curr= new DateClass(currentDate.getDayOfMonth(),currentDate.getMonthValue(),currentDate.getYear());
			int m,y,d;
			System.out.println("Enter The Date You Want to borrow the book : ");
			System.out.print("Year:");y=sc.nextInt();
			System.out.print("Month:");m=sc.nextInt();
			System.out.print("Day:");d=sc.nextInt();
			start = new DateClass(d,m,y);
			end = new DateClass(d+50,m,y);
			System.out.println("You must return the book before ("+end+") Or This will be Fine ! ");
			Transaction tran = new Transaction(start,curr,end, this.user_id,title);
			TheLibrary.trans.add(tran);
		}
	}
	
	
	public void ReturnABook() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Title of the book you will return");
		String title= sc.nextLine();
		title =title.toLowerCase();
		boolean flag=false;
		Transaction tem=null;
		for (Transaction t : TheLibrary.trans)
		{
			if (t.getUserid() == getUser_id() && t.getBooktitle().equals(title))
			{
				tem=t;
				flag=true;
				break;
			}
		}
		if (flag)
		{
			for (Category c: TheLibrary.cats){
				
				for (Book b : c.getBooks())
				{
					if (b.getTitle().equals(title))
					{
						b.setNumberOfUnits(b.getNumberOfUnits()+1);
						break;
					}
				}
			}
	        LocalDate currentDate = LocalDate.now();
			DateClass curr= new DateClass(currentDate.getDayOfMonth(),currentDate.getMonthValue(),currentDate.getYear());
			if (curr.compareTo(tem.getReturnDate())>0){
			double duration = curr.getDaysBetween(tem.getReturnDate());
			double fine =duration * 1.5;
			if (fine <= 0)
				return;
			System.out.println("Pay Fine for being late !");
			System.out.println("Duration : "+(int)(duration)
								+" days .\nFine Amount : "+fine + "$ (1.5$ for each day)");
			}
		}
		else 
		{
			System.out.println("This User didn't borrow this book .");
		}
		
		
	}

	public void sendquery() {
		System.out.println("Write Your Query : ");
		String q = new Scanner (System.in).nextLine();
	}
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
	
}
