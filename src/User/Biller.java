package User;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import EProviders.Bescom;

public class Biller {
	static Scanner sc = new Scanner(System.in);
	static Providers bescom = new Bescom();

	static List<Providers> providerDatabase = new LinkedList<Providers>();

	public static void main(String[] args) {
		int ch = 0;

		do {
			
			System.out.println("Available choices : ");
			System.out.println("1. Creade User");
			System.out.println("2. Login");
			System.out.println("3. Get All users");
			System.out.println("4. Get user info by account number");
			System.out.println("5. Remove User");
			System.out.println("6. Exit");
			System.out.println("Enter your choice : (1-5)");
			ch = sc.nextInt();
			
			
			switch (ch) {

			case 1:
				bescom.createNewUser();
				break;
			case 2:
				bescom.login();
				break;
			case 3:
				bescom.allUserDetails();
				break;
			case 4:
				bescom.getUserDetailsByAccountNo();
				break;
			case 5:
				bescom.removeuser();
				break;
			case 6:
				System.exit(0);
				 break;
				 
			default : System.out.print("Wrong Choice.....\n");
			 break;

			}

		} while (ch!=6);
		providerDatabase.add(bescom);

	}

}
