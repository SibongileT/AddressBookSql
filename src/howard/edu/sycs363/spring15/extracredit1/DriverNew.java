package howard.edu.sycs363.spring15.extracredit1;

import java.io.IOException;

public class DriverNew {
	public static void main(String[] args) throws IOException  {

		AddressBook blackbook;
		Person friend1;
		Person friend2;
		Person friend3;
		Person friend4;
		friend1 = new Person ("Alcia" , "Tale", "347-298-0945", "346,Hilton,Street", "Brookyln", "NY", 11683);
		friend2 = new Person("Pricillia", "Johnson", "718-890-8795", "233,Norway,Avenue", "Washington","DC", 11234);
		friend3 = new Person ("Timothy","Howard","404-565-9878","45,Clinton,Street","Arlington","Virginia",59022);
		friend4 = new Person("Darrell", "Jones","354-964-1239","23,Sherman,Avenue", "Washington","D.C",20001);
		blackbook = new AddressBook();
		blackbook.addorchangeContact(friend1);
		blackbook.addorchangeContact(friend2);
		blackbook.addorchangeContact(friend3);
		blackbook.addorchangeContact(friend4);
		System.out.println("print the sorted Address book, sorted by zip code");
		blackbook.PrintAddressBook(1);
		blackbook.deleteContact(friend1);
		System.out.println("Print the sorte AddressBook, sorted by contact's last name");
	    blackbook.PrintAddressBook(0);
		System.out.println("Insert BlackBook into SQL Database");
		blackbook.InsertContact();
		System.out.println("Search for contact, Tale, by last name");
		String lName = friend1.getlName();
		System.out.println("Update Tales Information");
		blackbook.DatabaseQuery(lName);
		friend1.SetNumber("347-298-0945");
		blackbook.UpdateAddressBook(lName, friend1);

}

}
