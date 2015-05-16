package howard.edu.sycs363.spring15.extracredit1;

public class Person {

 	private String F_name; // Stores name of Contact
 	private String L_name;//Stores last name of contact
 	private String Address;
 	private String city;
    private String state;  // Stores age of Contact
    private String phonenumber; // Stores phone number of contact
    private int zip;  // Stores birthday in an int

    /** Creates Person object based on the papameter of person
     * 
     * @param FN
     * @param LN
     * @param P
     * @param CT
     * @param ST
     * @param AD
     * @param zi[
     */
    
    public Person(String FN,String LN, String P,String CT,String ST, String AD,int zip) 
    {
		F_name = FN;
		L_name=LN;
		Address=AD;
		city= CT;
		state= ST;
		phonenumber = P;
		zip = zip ;
    }
    
	public void SetfName(String fName){
		this.F_name = fName;
	}
	public void SetlName(String lName){
		this.L_name = lName;
	}
	
	/**
	 * Set/Update address for Person object
	 * @param address
	 */
	public void SetAddress(String address) {
		this.Address = address;
	}
	/**
	 * Set/Update city for Person object
	 * @param city
	 */
	public void SetCity(String city) {
		this.city = city;
	}
	
	/**
	 * able to update contact state
	 * @param state
	 */
	public void SetState(String state) {
		this.state = state;
	}
	/**
	 * able to update a persons zip code
	 * @param zip
	 */
	public void SetZip(int zip) {
		this.zip = zip;
	}
	/**
	 * Able to update contact phone
	 * @param number
	 */
	public void SetNumber(String Number) {
		phonenumber = Number;
	}
   
	/** Change Information of A contact
	 * 
	 * @param newnum
	 */
    public void changeNumber(String newnum) {
		phonenumber = newnum;
    }
    public void changeAddress(String new_AD)
    {
    	Address= new_AD;
    }
    
    public void changeCity(String new_city)
    {
         city = new_city;
    }
    public void changeState(String new_State)
    {
    	state = new_State;
    }
    public void changeZip(int new_zip)
    {
    	zip = new_zip;
    }
   

    
    // Returns the name of a Contact
    public String getfName() 	{
		return F_name;
    }
    public String getlName(){
    	return L_name;
    }

    public String getAddress(){
    	return Address;
    }
    public String getCity(){
    	return city;
    }
    public String getState(){
    	return state;
    }
    public int getZip(){
    	return zip;
    }
    public String getNumber() {
			return phonenumber;
    }
    public void printPerson() {
		System.out.print("Name: " + F_name+ L_name + " Address: " + Address + city + state + zip + " Phone Number: " + phonenumber);
		
    }
    /*public int hashcode()
    {
    	return zip;
    }*/

}
//Hash code differentiate between people

