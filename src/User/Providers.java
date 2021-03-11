package User;




public interface Providers{
	
	
	public void createNewUser(User user, String name, String num, String email, String password, String address, String date);
	public void getUserDetailsByAccountNo();
	public double calculateBill();
	public void allUserDetails();
//	public void setStartMeterReading();
//	public void setEndMeterReading();
//	public void getStartMeterReading();
//	public void getEndMeterReading();
	public void login();
	public void removeuser();
	public void createNewUser();


}
