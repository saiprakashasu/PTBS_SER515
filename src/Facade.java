import java.util.ArrayList;

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
		int usertype = l.loginFunction();
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
