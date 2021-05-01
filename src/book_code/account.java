package book_code;



import java.util.Scanner;  

public class account {

String accountName;
int regNum;

book borrowedBooks[] = new book[3];
public int booksCount = 0;

Scanner input = new Scanner(System.in);

public account(){

    System.out.println("Enter Account Name:");
    this.accountName= input.nextLine();
    

    System.out.println("Enter Reg Number:");
    this.regNum = input.nextInt();

}
}

