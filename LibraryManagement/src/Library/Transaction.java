package Library;

import java.util.Date;

public class Transaction {
	private DateClass BorrowDate;
	private int Trans_id;
	private DateClass IssueDate;
	private DateClass ReturnDate;
	private double FineAmount;
	private int user_id;
	private String booktitle;
	static int ID = 1;
	public Transaction(DateClass b,DateClass i,DateClass r,int user_id,String bookt){
		this.user_id=user_id;
		BorrowDate=b;
		IssueDate =i;
		ReturnDate=r;
		setFineAmount(0);
		setBooktitle(bookt);
		Trans_id = ID++;
	}
	public void showInfo() {
		System.out.println("Transaction ID : "+Trans_id);
		System.out.println("Borrow Date : "+BorrowDate);
		System.out.println("Issue Date : "+IssueDate);
		System.out.println("Return Date : "+ReturnDate);
		System.out.println("User : "+user_id);
	}
	public double getFineAmount() {
		return FineAmount;
	}
	public void setFineAmount(double fineAmount) {
		FineAmount = fineAmount;
	}
	public int getUserid() {
		return user_id;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public DateClass getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(DateClass d) {
		ReturnDate = d;
	}
	public DateClass getBorrowDate() {
		return BorrowDate;
	}
	public void setBorrowDate(DateClass d) {
		BorrowDate = d;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	
	
}
