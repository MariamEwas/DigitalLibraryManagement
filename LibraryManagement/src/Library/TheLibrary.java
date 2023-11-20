package Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Modules.Admin;
import Modules.Users;

public class TheLibrary {
	Scanner sc =new Scanner (System.in);

	public static ArrayList<Category> cats;
	public static ArrayList<Transaction> trans;
	public static ArrayList<Users> users;
	public static ArrayList<Admin> admins; 
	
	public static void showTheLibrary(){
		for (Category cat : cats)
		{
			System.out.println("Category "+cat.getCat_name());
			cat.showBooks();
		}
	}
	
	public static void main(String []args)
	{
		Scanner in=new Scanner(System.in);
		users = new ArrayList<>();
		admins = new ArrayList<>();
		trans= new ArrayList<>();
		cats= new ArrayList<>();
		
		Admin Default= new Admin("d","1");
		admins.add(Default);
		boolean go= true;
		while(go){
		System.out.println("Enter 1 to Sign In As A User");
		System.out.println("Enter 2 to Sign In As An Admin ");
		System.out.println("Enter 3 to Exit the system");

		int choose1 = in.nextInt();
		while ( choose1 != 1 && choose1 !=2 && choose1 !=3)
		{
			System.out.println("Enter 1 to Sign In As An Admin");
			System.out.println("Enter 2 to Sign In As A User ");
			 choose1 = in.nextInt();
		}
		if (choose1 == 1 )
		{
			System.out.println("Email : ");String email=in.next();
			Users currentuser = null;
			for (Users u : users)
			{
				if (u.getEmail().equals(email))
				{
					currentuser = u;
					break;
				}
			}
			if (currentuser == null) System.out.println("There is no such email .");
			else 
			{
				currentuser.ShowInfo();
				boolean Continue = true;
				while(Continue){
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Please Add a number : ");
					System.out.println("1 -> Search for a specific book ");
					System.out.println("2 -> Make A transaction");
					System.out.println("3 -> Return A book");
					System.out.println("4 -> show all books"); 
					System.out.println("5 -> show all categories");
					System.out.println("6 -> show all books in a Category");
					System.out.println("7 -> to Send A Query ");
					System.out.println("8 -> TO EXIT ");
					int choose2 =in.nextInt();
					switch(choose2)
					{
					case 1: currentuser.SearchForBook(); break;
					case 2:	currentuser.MakeTransaction(); break;
					case 3: currentuser.ReturnABook();break;
					case 4: showTheLibrary();break;
					case 5: showCategories();break;
					case 6: 
						String name;
						name = in.next();
						name=name.toLowerCase();
						boolean exist = false;
						for (Category cat : cats){
							if (cat.getCat_name().equals(name)){
								exist =true;
								cat.showBooks();
								break;
							}
						}
						if (!exist) System.out.println("This Category is not in The Library " );
						break;
					
					case 7: currentuser.sendquery();break;
					case 8: Continue =false; break;
					default : System.out.println("Enter a Valid Number ");
					}
					
				}
			}
		}
		else if (choose1 ==2){
			System.out.println("Email : ");String email=in.next();
			System.out.println("Password : ");String pass=in.next();
			Admin currentadmin = null;
			for (Admin u : admins)
			{
				if (u.getEmail().equals(email) && u.getPassword().equals(pass))
				{
					currentadmin = u;
					break;
				}
			}
			if (currentadmin == null) System.out.println("email or password is wrong .");
			
			else{
			boolean Continue = true;
			while (Continue) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1 -> Add a new Book");
				System.out.println("2 -> Update a Book");
				System.out.println("3 -> delete a book"); 
				System.out.println("4 -> Add a New User");
				System.out.println("5 -> Modify Information about a user");
				System.out.println("6 -> delete a user");
				System.out.println("7 -> Add a new Admin");
				System.out.println("8 -> To show Transactions ");
				System.out.println("9 -> To show Users");
				System.out.println("10 -> To Exit");
				int choose2 = in.nextInt();
				switch(choose2)
				{
				
					case 1 :  currentadmin.addNewBook(); break;
					case 2 :  currentadmin.UpdateBook(); break;
					case 3 :  currentadmin.deleteBook();break;
					case 4 :  currentadmin.addNewUser();break;
					case 5 :  currentadmin.ModifyUser(); break;
					case 6 :  currentadmin.deleteUser();break;
					case 7 :  currentadmin.addAdmin();break;
					case 8 :  currentadmin.showTransactions();break;
					case 9 :  currentadmin.showUsers();break;
					case 10 : Continue = false;break;
					default : System.out.println("Please Add a Valid Number");
				}
				
			}
			}
		}
		else 
			go=false;
		}
		System.out.println("Thank You and good bye ! ");
			
	}

	public static void showCategories() {
		for (Category c: cats)
		{
			System.out.println(c.getCat_name());
		}
		
	}
}
