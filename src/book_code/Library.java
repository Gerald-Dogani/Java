package book_code;

import java.util.Scanner;
public class Library {
connection conn = new connection(); 
public Library(){
      
    Scanner input = new Scanner(System.in);

    System.out.println("********************Welcome to the Gerald Library!********************");
    System.out.println("              Please Select From The Following Options:               ");
    System.out.println("**********************************************************************");
    books ob = new books();
    accounts obAccount = new accounts();
 
    int choice;
    int searchChoice;

    do{

        ob.dispMenu();
        choice = input.nextInt();

        switch(choice){

            case 1:
                book b = new book();
                ob.addBook(b);
                
                break;

            case 2:
                ob.upgradeBookQty();
                break;

            case 3:
                System.out.println("Enter 1 to Search with Serial No.");
                System.out.println("Enter 2 to Search with Author Name(Full Name).");
                searchChoice = input.nextInt();
                
                switch(searchChoice){

                    case 1:
                        ob.searchBySno();
                        break;
                    case 2:
                        ob.searchByAuthorName();

                }
                break;

            case 4:
                ob.showAllBooks();
                break;
            case 5:
                account s = new account();
                conn.addAcc(s);
               
                break;
            case 6:
                obAccount.showAllAccou();
                break;
            case 7:
                obAccount.checkOutBook(ob);
                break;
            case 8:
                obAccount.checkInBook(ob);
                break;
            default:
                System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 8.");

        }

    }
    while (choice!=0);

}

}