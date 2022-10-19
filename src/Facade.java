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

		String loginInput="1";
		while(loginInput.equals("1")){
			UserType = l.loginFunction();

			if(UserType==0 || UserType==1) createUser(UserType);

			System.out.println("Press 1 to login again. Press anything else to terminate program");
			Scanner sc1=new Scanner(System.in);
			loginInput=sc1.next();

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

	public void createUser(int usertype) {
		if(this.UserType==0) {
			thePerson = new Buyer();
			thePerson.CreateProductMenu();
		}
		else if(this.UserType==1) {
			thePerson = new Seller();
			thePerson.CreateProductMenu();
		}
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
