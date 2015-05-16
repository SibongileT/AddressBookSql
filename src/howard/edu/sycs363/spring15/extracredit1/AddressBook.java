package howard.edu.sycs363.spring15.extracredit1;
///methods sorting deleting

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.sql.PreparedStatement;
import java.util.Properties;

	 
public class AddressBook {
	
//	private static final String AddressList = null;

	File myAddressBook;
	
    /**
     * The treeMap will automatically sort by an integer rather than a hashmap(the integer used will be a zip code)
     */
    //private List<Person> contact = new ArrayList<Person>(); // Change from original map to List due to errors found while trying to implement through database
   private Map<Integer,String>MyBookZip = new TreeMap<Integer,String>();
   private Map<String,String>MyBookLast = new TreeMap<String,String>();
   private final String username = "root";
   private final String password = " ";
   private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
    private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
   private final String dbName = "addressbook";
   private final String url = "jdbc:mysql://localhost/addressbook";
   
   public AddressBook() throws IOException 
   {
       MyBookZip = new TreeMap<Integer,String>();
       MyBookLast = new TreeMap<String,String>();
    	 myAddressBook = new File("Address.txt");
   	 
   	 if(!myAddressBook.createNewFile() && !myAddressBook.isFile())
   	 {
   		 myAddressBook.createNewFile();// Allow user to create a new file to add information .032..23333
   	 }
   	 try(BufferedReader buffer = new BufferedReader(new FileReader("Address.txt")))
   	 {
   		 String myline;
   		 while((myline = buffer.readLine()) != null && !myline.isEmpty())
   		 {
   			 String[] mydata = myline.split(" ");
   			 String fName = mydata[0];
   			 String lName = mydata[1];
   			 String Phone_No = mydata[2];
   			 String Address = mydata[3];
   			 String city = mydata[4];
   			 String state = mydata[5];
   			 Integer zip = Integer.parseInt(mydata[6]);
   			 
   			 String entry = fName + " "+ lName+ " "+ Phone_No + " " + Address + " " + city + " " + state + " " + String.valueOf(zip);
   			 this.MyBookZip.put(zip, entry);
   			 this.MyBookLast.put(lName,entry);
   		 }
   		 }
   		 catch(IOException myerror)
   		 {
   			 myerror.printStackTrace();
   		 }
   	
   }
   /**
    * 
    * @param Myfile
    * @throws IOException
    */
   public AddressBook(String Myfile) throws IOException
   {
   	 myAddressBook = new File(Myfile);
   	 if(!myAddressBook.createNewFile() && !myAddressBook.isFile())
   	 {
   		 myAddressBook.createNewFile();// Allow user to create a new file to add information .032..23333
   	 }
   	 try(BufferedReader buffer = new BufferedReader(new FileReader(Myfile)))
   	 {
   		 String myline;
   		 while((myline = buffer.readLine()) != null && !myline.isEmpty())
   		 {
   			 String[] mydata = myline.split(" ");
   			 String fName = mydata[0];
   			 String lName = mydata[1];
   			 String Phone_No = mydata[2];
   			 String Address = mydata[3];
   			 String city = mydata[4];
   			 String state = mydata[5];
   			 Integer zip = Integer.parseInt(mydata[6]);
   			 
   			 String entry = fName + " "+ lName+ " "+ Phone_No + " " + Address + " " + city + " " + state + " " + String.valueOf(zip);
   			 this.MyBookZip.put(zip, entry);
   			 this.MyBookLast.put(lName,entry);
   		 }
   		 }
   		 catch(IOException myerror)
   		 {
   			 myerror.printStackTrace();
   		 }
   	 
   	 }
   	 
   
   

/**Add a contact that's passed in as a parameter.
 * 
 * @param contact
 */
public void addorchangeContact(Person contact) {
	
	
	String P_of_contact =  contact.getfName() + ", " + contact.getlName() + ", " +  contact.getNumber() + ", "+ contact.getAddress() + ", " + contact.getCity() + ", " +
			  contact.getState() + ", " + contact.getZip();
this.MyBookZip.put(contact.getZip(),P_of_contact); // adds a contact either based on Zip or Last name
this.MyBookLast.put(contact.getlName(),P_of_contact);
}

/**
 * @parum contact- used to delete a contact in treeMap
 */
public void deleteContact(Person contact)
{
	if ( MyBookLast.containsKey(contact.getlName()))
	{
	  this.MyBookLast.remove(contact.getlName(),contact);
	}
	else if (MyBookZip.containsKey(contact.getZip()))
	{
		this.MyBookZip.remove(contact.getZip(),contact);
	}
	else 
	{
		System.out.println("This Person does not exsist in your AddressBook");
	}
}

/**
 * sorts the addressBook based on Zipcode and Last Name
 * @param mySort
 */
public void PrintAddressBook(int mySort)
{
	//Person contact;
	if (mySort == 1)
	{
	for (int zip : MyBookZip.keySet() )
	{
	 String [] mycontact = MyBookZip.get(zip).split(", "); 
	 String Fname = mycontact[0];
	 String Lname = mycontact[1];
	 String Phone_No = mycontact[2];
	 String Address = mycontact[3];
	 String city = mycontact[4];
	 String state = mycontact[5];
	 int myzip = Integer.parseInt(mycontact[6]);
	 System.out.println(Fname);
	 System.out.println(" ");
	 System.out.println(Lname);
	 System.out.println(" ");
	 System.out.println(Phone_No);
	 System.out.println(" ");
	 System.out.println(Address);
	 System.out.println(" ");
	 System.out.println(city);
	 System.out.println(" ");
	 System.out.println(state);
	 System.out.println(" ");
	 System.out.println(myzip);
	 System.out.println("/n");
	}
	}
	if( mySort == 0)
	{
		for (String lName : MyBookLast.keySet() )
    	{
    	 String [] mycontact = MyBookLast.get(lName).split(" "); 
    	 String Fname = mycontact[0];
    	 String Lname = mycontact[1];
    	 String Phone_No = mycontact[2];
    	 String Address = mycontact[3];
    	 String city = mycontact[4];
    	 String state = mycontact[5];
    	 int myzip = Integer.parseInt(mycontact[6]);
    	 System.out.println(Fname);
    	 System.out.println(" ");
    	 System.out.println(Lname);
    	 System.out.println(" ");
    	 System.out.println(Phone_No);
    	 System.out.println(" ");
    	 System.out.println(Address);
    	 System.out.println(" ");
    	 System.out.println(city);
    	 System.out.println(" ");
    	 System.out.println(state);
    	 System.out.println(" ");
    	 System.out.println(myzip);
    	 System.out.println("/n");
    	}
		
	}
		}
 /**
  * Connect to the Database
  * @return
  * @throws SQLException
  */
	
	public Connection ConnectToDatabase() throws SQLException {
		Connection connect = null;
		Properties connectionProp = new Properties();
		connectionProp.put("username",this.username);
		connectionProp.put("password",this.password);
		
		connect = DriverManager.getConnection(this.url,connectionProp);
		return connect;
	}
	

/**
 * Execute an update on the database
 * @param connection
 * @param query
 * @return
 * @throws SQLException
 */
	
	public boolean ExecUpdate(Connection connection, String query) throws SQLException {
	    Statement statement = null;
	    try {
	        statement = connection.createStatement();
	        statement.executeUpdate(query); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// Check for exception throw
	        if (statement != null) 
	        { statement.close();
	        }
	        }
	        
	    }
	

	/**
	 * 
	 */
	public void InsertContact() {
		int ContactNum = 1;
		
		Connection connection = null;
		try {
			connection = this.ConnectToDatabase();// Makes sure that the database is connected
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Connection Unsuccessful");
			e.printStackTrace();
			return;
		}
		
		//Insert record into table
		for(Integer key : MyBookZip.keySet()) {
			String[] mycontacts = MyBookZip.get(key).split(", ");
			String fname = mycontacts[0];
			String lname = mycontacts[1];
			String address = mycontacts[2];
			String city = mycontacts[3];
			String state = mycontacts[4];
			Integer zip = Integer.parseInt(mycontacts[5]);
			String phone = mycontacts[6];
			try {
				String insertData = "INSERT INTO contacts VALUES ('"+fname+ 
								    " ,"+lname+"','"
						+address+"','"+city
						+"','"+state+"','"
						+zip+"','"
						+phone+"')";
				
				this.ExecUpdate(connection, insertData);
				System.out.println("Added Contact number " +ContactNum + " to table");
				ContactNum++;
			} catch (SQLException e) {
				System.out.println("Unsucessful Insertion of Data");
				e.printStackTrace();
				return;			
			}
		}
	}
	/**
	 * Run a query on the database based on the Last Name
	 */
	public void DatabaseQuery(String LastSearch) {
		Connection connection = null;
		try {
			connection = this.ConnectToDatabase();
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Connection Unsucessful`");
			e.printStackTrace();
			return;
		}
		
		try{
			String Stringquery =  "SELECT * FROM contacts WHERE LAST='"+LastSearch;
			Statement statement = connection.createStatement();
            ResultSet result;
            result = statement.executeQuery(Stringquery);
            while(result.next()) {
            	String fname = result.getString("FIRST");
            	String lname = result.getString("LAST");
            	String address = result.getString("ADDRESS");
            	String city = result.getString("CITY");
            	String state = result.getString("STATE");
            	String zip = result.getString("ZIP");
            	String phone = result.getString("phone");
            	System.out.println("Contacts:");
				System.out.println(fname + " "+ lname);
				System.out.println(address);
				System.out.println(city + ", " + state + " " + zip);
				System.out.println(phone);
            }
		} catch(SQLException e) {
			System.out.println("No one exsist with that LastName");
			e.printStackTrace();
			return;			
		}
	}
	/**
	 * Update the AddressBook based on Last Name
	 */
	public void UpdateAddressBook(String LastName, Person newContact) {
		// Make sure that the addressbook is connected to the Database
		Connection connection = null;
		try {
			connection = this.ConnectToDatabase();
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Connection Unsucessful");
			e.printStackTrace();
			return;
		}
		
		// Update whats in the database
		try { 
			String ContactlName= newContact.getlName();
			String newZip = Integer.toString(newContact.getZip());
			String updateString = "UPDATE contacts SET FIRST = ?, LAST = ? ADDRESS= ?, CITY = ?, "
					+ "STATE = ?, ZIP = ?, PHONE = ?" + " WHERE LAST = ?";
			PreparedStatement prepared = connection.prepareStatement(updateString);
			prepared.setString(2, ContactlName);
			prepared.setString(3, newContact.getAddress());
			prepared.setString(4, newContact.getCity());
			prepared.setString(5, newContact.getState());
			prepared.setString(6, newZip);
			prepared.setString(7, newContact.getNumber());
			prepared.setString(8, ContactlName);
			prepared.executeUpdate();
		} catch (SQLException e) {
			System.out.println("AddressBook could not be updated");
			e.printStackTrace();
			return;
		}
	}
	}
	
