package book_code;

import java.sql.*;




public class connection {
    Connection con;
    Statement st;
    ResultSet set; 
 

public connection() {
	
    try {

        String db ="jdbc:ucanaccess://accounts.mdb";
        con = DriverManager.getConnection(db);
        st = con.createStatement();
       
    }
    catch(SQLException e){
               System.out.println(e.toString());
    }    
}

public void connect() {
  
        try{
            String f ="CREATE TABLE Account( ID INTEGER CONSTRAINT ID PRIMARY KEY , Account_name CHAR(50), Reg_number CHAR (50))";
            String s = "CREATE TABLE all_books(ID INTEGER CONSTRAINT ID PRIMARY KEY, s_no INTEGER, NameofBook CHAR (50), Author CHAR (50),Available_qty  INTEGER, Total_qty INTEGER);";
            st.executeQuery(f);
          
            st.executeQuery(s);
            
            System.out.println("Table is created");
        
        }
    catch(SQLException e){
               System.out.println("Table exist");
    } 
}
public void login(Log l) {
	try {
			 String user = l.username;
		     String pass = l.password;
			 set=st.executeQuery("select Username,Password from admin where Username='"+user+"' and Password='"+pass+"';");
		     int count = 0;
		     while(set.next()){
     	        count = count + 1;
    		    }
    	     if (count == 1){
		    	System.out.println("Access Granted! Welcome!");
		    	connect();
		    	new Library();
		    	}
			 else if (count > 1){
			        
			        System.out.println("Access denied(duplicated account)");
			    }
			 else
			    {
			    	System.out.println("Access denied(wrong data)");
			      
			    }
		 }
   
	 catch(SQLException e) {
		 System.out.println("Make sure if your Ms Acces DB is in the right way");
	 } 
	} 
	

public void addAcc(account s){
    try{
            String nm = s.accountName;
            int rg = s.regNum;
           
           
            st.executeUpdate("INSERT INTO Accounts " +
                    "( Account_name, Reg_number)" +
                      "VALUES('"+nm.toString()+"','"+rg+"')");
            
            }
            catch(SQLException e){
            	 System.out.println("Account of Reg Num " + s.regNum + " is Already Registered.");
            } 
    
}

public void show_accounts(){
    try{
             String nm ;
             int rg ;
           
            set =st.executeQuery("SELECT * " +
                    "FROM Accounts");
            while (set.next()) {
              nm = set.getString("Account_name");
              rg = set.getInt("Reg_number");
              
              System.out.println(nm + "\t\t\t\t" + rg);
}
            }
            catch(SQLException e){
               System.out.println("full");
            } 
 
}

public int addBooks(book b){
    
	
	try{
            int reg = b.sNo;
            String name = b.bookName;
            String author = b.authorName;
            int av_qty = b.bookQty ;
            int t_qty = b.bookQtyCopy;
           
           
            st.executeUpdate("INSERT INTO all_books " +
                    "(s_no, NameofBook, Author,Available_qty, Total_qty)" +
                      "VALUES('"+reg+"','"+name.toString()+"','"+author.toString()+"','"+av_qty+"','"+t_qty+"')");
            
            }
            catch(SQLException e){
               System.out.println("Could not add the book");
                return -1;
            } 
  return 1;
}
public void show_Books(){
    try{
            int reg ;
            String name ; 
            String author ;
            int av_qty ;
            int t_qty ;
           
            set =st.executeQuery("SELECT * " +
                    "FROM all_books");
            while (set.next()) {
              reg = set.getInt("s_no");
              name = set.getString("NameofBook");
              author = set.getString("Author");
              av_qty = set.getInt("Available_qty");
              t_qty = set.getInt("Total_qty");
              System.out.println(reg + "\t\t" + name + "\t\t" + author + "\t\t" + av_qty + "\t\t" + t_qty );
}
            }
            catch(SQLException e){
               System.out.println("full");
            } 
 
}

public void searchbyauthn(String authorName) { 
	int reg ;
    String name ; 
    String author ;
    int av_qty ;
    int t_qty ;
	try {
		
		set =st.executeQuery("SELECT * " +
                "FROM all_books " +
				"WHERE Author='"+authorName+"'");
		
		
		while (set.next()) {
			
            reg = set.getInt("s_no");
            name = set.getString("NameofBook");
            author = set.getString("Author");
            av_qty = set.getInt("Available_qty");
            t_qty = set.getInt("Total_qty");
            
		    System.out.println(reg + "\t\t" + name + "\t\t" + author + "\t\t" + av_qty + "\t\t" + t_qty );
		    }
		
		}
	
	catch (SQLException e){
        System.out.println("can not find");
        }
	
}
public void searchbysNo(int sNo) { 
	int reg ;
    String name ; 
    String author ;
    int av_qty ;
    int t_qty ;
	try {
		set =st.executeQuery("SELECT * " +
                "FROM all_books " +
				"WHERE s_No='"+sNo+"'");
		
while (set.next()) {
			
            reg = set.getInt("s_no");
            name = set.getString("NameofBook");
            author = set.getString("Author");
            av_qty = set.getInt("Available_qty");
            t_qty = set.getInt("Total_qty");
            
		    System.out.println(reg + "\t\t" + name + "\t\t" + author + "\t\t" + av_qty + "\t\t" + t_qty );
		    }
		
}
	catch (SQLException e){
        System.out.println("can not find");
        }
}

public int checkAcc(int regNum) {
	
	int regn=regNum;
	try{
		
       set =st.executeQuery("SELECT * " +
               "FROM Accounts"+
    		   "WHERE Reg_number ="+regn);
       
       while (set.next()) {
    	   regn=set.getInt("Reg_number");
       }

       }
       catch(SQLException e){
    	   System.out.println("Account is Unavailable");
          return -1;
       } 

	return regn;
}
public void upgradebookqty(int sNo , int addingQty){
    try{
    	int av_qty ;
        int t_qty ;
        set =st.executeQuery("SELECT * " +
                "FROM all_books " +
				"WHERE s_No='"+sNo+"'");
        
        while (set.next()) {
        av_qty = set.getInt("Available_qty");
        t_qty = set.getInt("Total_qty");
       av_qty=av_qty+addingQty;
       t_qty=t_qty+addingQty;
           st.executeUpdate("UPDATE all_books " +
                    "SET Available_qty ='"+av_qty+"',Total_qty ='" + t_qty +"'"+
                      "WHERE s_no = '"+sNo+"'");
        }
            }
            catch(SQLException e){
               System.out.println("Can not find the book");
            } 
    
}
public int isavailable() {
	try {
		
	int sno;
	set=st.executeQuery("SELECT * " +
            "FROM all_books " +
			"WHERE Total_qty >0 and Total_qty>0 ");
	 while (set.next()) {
		 sno=set.getInt("s_No");
		 return sno;
	 }
}
	catch(SQLException e){
        System.out.println("Book is Unavailable");
    
        }
	 return 1;
}

public void check_out(int sNo) {
try {
	int aqty;
	  set =st.executeQuery("SELECT * " +
              "FROM all_books " +
				"WHERE s_No='"+sNo+"'AND Available_qty > 0 ");
	  while (set.next()) { 
		  aqty=set.getInt("Available_qty")-1;
	st.executeUpdate("UPDATE all_books " +
            "SET Available_qty ='"+aqty+"'"+
              "WHERE s_no = '"+sNo+"'"); 
	}
}
catch(SQLException ex) {
	System.out.println("can not");
}
}

public void check_in(int sNo) {
try {
	int aqty;
	int tqty;
	try {
	
	  set =st.executeQuery("SELECT * " +
              "FROM all_books " +
				"WHERE s_No='"+sNo+"'");
}
	catch(SQLException ex) {
		System.out.println("can not find available category for this book");
	}
	  
	  while (set.next()) { 
		  aqty=set.getInt("Available_qty")+1; 
		  tqty=set.getInt("Total_qty");
		  try {
			  st.executeUpdate("UPDATE all_books " +
            "SET Available_qty ='"+aqty+"'"+ 
            "WHERE s_No='"+sNo+"' AND Available_qty <'"+ tqty+"' "); 

		  }
		  catch(SQLException ex) {
			  System.out.println("can not because is full");  
		  }
		}
}
catch(SQLException ex) {
	System.out.println("can not");
}
}}