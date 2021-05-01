package book_code;

import java.util.Scanner;

public class Log{
	public String username;
	public String password;
	
	public Log() {
	
	Scanner input1 = new Scanner(System.in);
    System.out.println("Enter Username : ");
    username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.println("Enter Password : ");
    password = input2.next();
	}
 public static void main(String[] args){ 
            
	 connection conn = new connection(); 

	 boolean on = true ;
	  
	 while (on) {
		 
	 	 Log l = new Log();
	 	conn.login(l);
	 	
	 	System.out.println("Do you want to continue? 1/2");
	 	Scanner s = new Scanner(System.in); 	
	 	if( s.nextInt() ==2 ) {
	 		on = false;
	 	 System.out.println("Good buy" );}
	 	}
}
}

