package com.hari.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phone {

	public List<Contact> contactList;
	public String fName;
	public String lName;
	public long phoneNo;
	public String emailId;
	
	
	
	
	public Phone() {
		super();
		this.contactList = new ArrayList<>();
	}

	public void showMenu() {
		System.out.println("-----------------------");
		System.out.println("Welcome to Phone Book..");
		System.out.println("Choose the Below option to save/update/delete the contacts");
		System.out.println("1.Add the Contact Details");
		System.out.println("2.Modify/update the Contact Details");
		System.out.println("3.Delete the Contact Details");
		System.out.println("4.View the Contact Details");
		System.out.println("5.Exit the Phone Book");
		System.out.println("------------------------");
	}
	
	public void addContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the FisrtName");
		String firstName = sc.nextLine();
		System.out.println("Enter the LastName");
		String lastName = sc.nextLine();
		System.out.println("Enter the Phone Number");
		long phoneNo = sc.nextLong();
		System.out.println("Enter the Email Id");
		String emailId = sc.next();		
		Contact con = new Contact(firstName, lastName, phoneNo, emailId);		
		contactList.add(con);		
	}
	
	public void modifyandUpdate() {
		Scanner mu = new Scanner(System.in);
		System.out.println("Select the option to update");
		System.out.println("A.FirstName");
		System.out.println("B.LastName");
		System.out.println("C.PhoneNo");
		System.out.println("D.EmailID");
		String opt = mu.next();
		if(opt.equals("A")){
			System.out.println("Enter the old FisrtName");
			fName = mu.next();
			System.out.println("Enter the new FisrtName");
			String firstName = mu.next();
			contactList.stream()
			.filter(p -> (p.getFirstName().equals(fName)))
			.forEach(con -> { 
				con.setFirstName(firstName);
			});
			System.out.println("FirstName updated successfully");
		}else if(opt.equals("B")) {
			System.out.println("Enter the old LastName");
			lName  = mu.next();
			System.out.println("Enter the New LastName");
			String lastName = mu.next();
			contactList.stream()
			.filter(p -> (p.getLastName().equals(lName)))
			.forEach(con -> { 
				con.setLastName(lastName);
			});
			System.out.println("LastName updated successfully");
		}else if(opt.equals("C")) {
			System.out.println("Enter the old PhoneNo");
			phoneNo = mu.nextLong();
			System.out.println("Enter the new PhoneNo");
			long phno = mu.nextLong();
			contactList.stream()
			.filter(p -> (p.getPhoneNo() == (phoneNo)))
			.forEach(con -> { 
				con.setPhoneNo(phno);
			});
			System.out.println("Phone No updated successfully");
		}else if(opt.equals("D")) {	
			System.out.println("Enter the old emailId");
			emailId = mu.nextLine();
			System.out.println("Enter the new emailId");
			String emId = mu.nextLine();
			contactList.stream()
			.filter(p -> (p.getEmailId().equals(emailId)))
			.forEach(con -> { 
				con.setEmailId(emId);
			});
			System.out.println("Email Id Updated Successfully");
		}else {	
			System.out.println("Invalid Option");
		}
	}
	
	public void deleteContact() {
		if (this.contactList.size() > 0) {
			Scanner mu = new Scanner(System.in);
			System.out.println("Enter the FisrtName to delete the Contact");
			fName = mu.nextLine();
			boolean exists = contactList.stream().anyMatch(p -> p.getFirstName().equals(fName));
			if (exists) {
				contactList.removeIf(p -> p.getFirstName().equals(fName));
				System.out.println("Contact Deleted successfully");
			} else {
				System.out.println("No Contact Found with this details provided");
			}
		} else {
			System.out.println("No Contact Found");

		}
	}
	
	public void viewContact() {
		if(this.contactList.size() > 0) {
			this.contactList.stream().forEach(con -> {
				System.out.println("FirstName : " + con.getFirstName());
				System.out.println("LastName : " + con.getLastName());
				System.out.println("PhoneNo : " + con.getPhoneNo());
				System.out.println("EmailId : " + con.getEmailId());
				System.out.println("------------------------------------");
			});
		}else {
			System.out.println("No Contact Found");
		}
	}
}
