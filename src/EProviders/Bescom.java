package EProviders;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.RandomStringUtils;
import User.Providers;
import User.User;

public class Bescom implements Providers{
	static Scanner sc = new Scanner(System.in);
	private String name;
	private String contact_num;
	private String ContactPerson;
	private double basePrice;
	private double pricePerUnit;
	private double finalPrice;
	private static List<User> userdatabase = new LinkedList<User>();
	
	public Bescom() {
		this.basePrice = 45.0;
		this.pricePerUnit = 1.20;
	}
	
	public double getBasePrice() {
		return basePrice;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = getBasePrice()+getPricePerUnit()*30;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_num() {
		return contact_num;
	}
	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
 
	
	
	public void createNewUser(User user, String name, String num, String email, String password, String address, String date)
	{
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone_number(num);
		user.setUsername(name.substring(0, 4)+RandomStringUtils.randomAlphanumeric(4));
		user.setAddress(address);
		user.setActivationDate(date);
		user.setAccount_number(RandomStringUtils.randomAlphanumeric(6));
		System.out.println(user.getUsername() +" : "+password);
		userdatabase.add(user);

		
	}
	
	public void UserLogin(User user, String username, String Pass)
	{
		if(username.equals(user.getUsername())&&Pass.equals(user.getPassword()))
		{
			System.out.println("Login Success !!!");
		}
		else if(!username.equals(user.getUsername()))
		{
			System.out.println("Login Failed !!! Wrong Username");
		}
		else if(!Pass.equals(user.getPassword()))
		{
			System.out.println("Login Failed !!! Wrong Password");
		}
	}
	
	private void getUserDetails(User user)
	{
		System.out.println("Account Number : "+user.getAccount_number());
		
		System.out.println("Activation Date : "+user.getActivationDate());

		System.out.println("Name : "+user.getName());

		System.out.println("UserName : "+user.getUsername());

		System.out.println("Email : "+user.getEmail());

		System.out.println("Phone Number : "+user.getPhone_number());
		
		System.out.println("Address : "+user.getAddress());
		
		System.out.println("Bill : "+calculateBill());

	
	}
	
	public double calculateBill()
	{
		return getBasePrice()+getPricePerUnit()*30;
	}
	

	public void removeuser() {
		System.out.println("Available Account numbers are : ");
		for(User usr : userdatabase)
		{
				System.out.println(usr.getAccount_number());
		}
		System.out.println("Enter Account number to close :");
		String account_number=sc.nextLine();
		for(User usr : userdatabase)
		{
			if(usr.getAccount_number().equals(account_number))
			{
				userdatabase.remove(usr);
			}
		}
		
	}
	public void getUserDetailsByAccountNo() {
		System.out.println("Available Account numbers are : ");
		for(User usr : userdatabase)
		{
				System.out.println(usr.getAccount_number());
		}
		System.out.println("Enter Account number to search :");
		String account_number=sc.nextLine();
		for(User usr : userdatabase)
		{
			if(usr.getAccount_number().equals(account_number))
			{
				this.getUserDetails(usr);
			}
		}
	}
	
	public void allUserDetails()
	{
		
		System.out.println("| Account Number | Username | Name      | Email        | Conatact No | Address |");
		for(User usr : userdatabase)
		{
			System.out.println("| "+usr.getAccount_number()+"         | "+usr.getUsername()+" | "+usr.getName()+" | "+usr.getEmail()+" | "+usr.getPhone_number()+" | "+usr.getAddress()+" |");

		}
	}

	public void login() {
		
		boolean flag = false;
		do
		{
			System.out.println("Enter username : ");
			String uname = sc.nextLine();
			System.out.println("Enter username : ");
			String pass = sc.nextLine();
		for(User usr : userdatabase)
		{
			if(uname.equals(usr.getUsername())&&pass.equals(usr.getPassword()))
			{
				System.out.println("Login Success !!");
				flag=true;
				break;
				
			}
			else if(!uname.equals(usr.getUsername()))
			{
				if(uname.equalsIgnoreCase(usr.getUsername()))
				{
					System.out.println("Wrong Username.. Enter Again");
					break;
				}
				else
				{
					System.out.println("Username does not exist !!");
					break;
				}
				
			}
			else if(!pass.equals(usr.getPassword()))
			{
				System.out.println("Wrong Password");
				break;
			}
		}
		}while(flag==false);
		
		
	}
	
	public void createNewUser() {
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		if (!name.matches("^[a-zA-Z]*$")) {
			System.out.println("Name can not contain digits: ");
			name = sc.nextLine();
		}
		System.out.println("Enter Contact Number : ");
		String num = sc.nextLine();
		if (!num.matches("[0-9]+")) {
			System.out.println("Contact Number can not contain letters, please enter again: ");
			num = sc.nextLine();
		}
		System.out.println("Enter Email : ");
		String email = sc.nextLine();
		System.out.println("Enter Password : ");
		String pass = sc.nextLine();
		System.out.println("Enter City : ");
		String city = sc.nextLine();
		System.out.println("enter date of activation in dd-mm-yyyy : ");
		String date = sc.nextLine();
		this.createNewUser(new User(), name, num, email, pass, city, date);

	}

	


}
