package book_code;


import java.util.Scanner;

public class accounts {

Scanner input = new Scanner(System.in);

account theAccounts[] = new account[50];
connection cc = new connection();

//books book;


public static int count = 0;


public void showAllAccou(){
    connection cc = new connection();
    System.out.println("Account Name\t\tReg Number");
     cc.show_accounts();
    }


public void checkOutBook(books book){
   // int accountIndex =this.isAccount();

  //  if (accountIndex!=-1){
        System.out.println("checking out");

        book.showAllBooks();
        book b = book.checkOutBook();
        System.out.println("checking out");
        if (b!= null){
        System.out.println("Book is not Available.");
    }
        System.out.println("Checked out.");
}


public void checkInBook(books bk){
	
 //int accountIndex = this.isAccount();
   /// if (accountIndex != -1){
       System.out.println("checking in");
       bk.showAllBooks();
	   book q = bk.checkInBook();
	   if (q== null)
       System.out.println("Checked in.");
		  
	  
		   
}
}

/*
public int isAccount(){
    
    System.out.println("Enter Reg Number:");
    int regNum = input.nextInt();
    int chkacc=cc.checkAcc(regNum);
    if(chkacc!=-1) {
            return chkacc;}
    return -1;

}*/
