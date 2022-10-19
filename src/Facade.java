import java.util.ArrayList;
import java.util.Scanner;

public class Facade {

	private int UserType;

	private Product theSelectProduct;

	private int nProductCategory;

	private classProductList theProductList;

	private Person thePerson;

	ArrayList<String> meatProductName=new ArrayList<>();
	ArrayList<String> produceProductName=new ArrayList<>();

	public void login() {
		Login l = new Login();
		int usertype=-1;
		String loginInput="1";
		while(loginInput.equals("1")){
			usertype = l.loginFunction();
			System.out.println("Press 1 to login again. Press anything else to terminate program");
			Scanner sc1=new Scanner(System.in);
			loginInput=sc1.next();

		}
		if(usertype==0){
			//Create user for buyer
		}
		else if(usertype==1){
			//create user for seller
		}


	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProuctList() {

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

}
