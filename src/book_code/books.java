package book_code;

import java.util.Scanner;
;
public class books {


Scanner input = new Scanner(System.in);
connection conn = new connection(); 

public void addBook(book b){
	
	int addb =conn.addBooks(b);
	if(addb==1)
	System.out.println("Book " + b.bookName + "\t\t" + b.authorName + "\t\t is added to library");
	else 
		System.out.println(" this Book  lready Exists.");
}

public void searchBySno(){

    System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

    int sNo;
    System.out.println("Enter Serial No of Book:");
    sNo = input.nextInt();
    
    System.out.println("S.No\t\tName\t\t\t\t\t\tAuthor\t\t\t\tAvailable Qty\t\t\tTotal Qty");
    conn.searchbysNo(sNo);
    
}

public void searchByAuthorName(){
	
    System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
    
    System.out.println("Enter Author Name:");
    String authorName = input.nextLine();
    System.out.println("S.No\t\tName\t\t\t\tAuthor\t\t\t\tAvailable Qty\t\tTotal Qty");
    conn.searchbyauthn(authorName);
}


public void showAllBooks(){
     connection co = new connection();
    
    System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    co.show_Books();
}

public void upgradeBookQty(){

    System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
    System.out.println("Enter Serial No of Book");
    int sNo = input.nextInt();

            System.out.println("Enter No of Books to be Added:");
            int addingQty = input.nextInt();
            conn.upgradebookqty(sNo,addingQty );
            return;
}


public void dispMenu(){

    System.out.println("----------------------------------------------------------------------------------------------------------");
    System.out.println("Enter 0 to Exit Application.");
    System.out.println("Enter 1 to Add new Book.");
    System.out.println("Enter 2 to Upgrade Quantity of a Book.");
    System.out.println("Enter 3 to Search a Book.");
    System.out.println("Enter 4 to Show All Books.");
    System.out.println("Enter 5 to Register user_Account.");
    System.out.println("Enter 6 to Show All Registered Account.");
    System.out.println("Enter 7 to Check Out Book. ");
    System.out.println("Enter 8 to Check In Book");
    System.out.println("----------------------------------------------------------------------------------------------------------");

}

public int isAvailable(int sNo){

    //returns the index number if available

         int book_verify=conn.isavailable();
         
        
            if(book_verify==sNo){
            	if(book_verify==-1) {
            		System.out.println("Book is Unavailable");
            return -1;
            }
            	} 
           // else {
            //	System.out.println("No Book of Serial Number " + " Available in Library.");
               // return -1; }            
return sNo;
}

public book checkOutBook(){

    System.out.println("Enter Serial No of Book to be Checked Out.");
    int sNo = input.nextInt();

    int bookIndex =isAvailable(sNo);
   
    if (bookIndex==-1){
    	 System.out.println("Books of Serial No not Found");
    }
    conn.check_out(sNo);
    return null;

}

public book checkInBook(){

	System.out.println("Enter Serial Number of Book to be Checked In:");
	 int sNo = input.nextInt();
	 int bookIndex =isAvailable(sNo);
	   
	    if (bookIndex!=-1){
	    	conn.check_in(sNo);
	    }
	    return null;
    }

 }