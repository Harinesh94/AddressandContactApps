package com.hari.sample;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone ph = new Phone();
		int option = 0;
		do {
		 ph.showMenu();
		 Scanner sc = new Scanner(System.in);
		 option = sc.nextInt();
		 switch(option) {
		 	case 1:
		 		ph.addContact();
		 		break;
		 	case 2:
		 		ph.modifyandUpdate();
		 		break;
		 	case 3 :
		 		ph.deleteContact();
		 		break;
		 	case 4 :
		 		ph.viewContact();
		 		break;
		 	case 5 :
		 		System.out.println("Thanks for using our sevice...");
		 		break;
		 	default:
		 		System.out.println("Invalid Option!Please Retry after Sometime..");
		 }
		}while(option != 5);
	}

}
