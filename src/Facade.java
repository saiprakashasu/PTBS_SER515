import org.w3c.dom.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Facade {

	private int UserType;
	String menutype;

	String username;
	String password;

	private Product theSelectProduct;

	private int nProductCategory;

	private classProductList theProductList;

	private Person person;

	ArrayList<String> meatProductName=new ArrayList<>();
	ArrayList<String> produceProductName=new ArrayList<>();

	public void login() throws IOException {
		System.out.println("....Facade  pattern....");
		Login l = new Login();

		String loginInput="1";
		while(loginInput.equals("1")){
			UserType = l.loginFunction();
			this.username = l.username;
			if(UserType==0 || UserType==1){
				createUser(UserType);  //Initiating buyer or seller
				createProductList();
			}

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

	//Initiating buyer or seller
	public void createUser(int usertype) {
		if(this.UserType==0) {
			person = new Buyer(); //creating a buyer object
			person.CreateProductMenu(); //Reads the ProductInfo.txt file and populates them in 2 arrays based on their category
		}
		else if(this.UserType==1) {
			person = new Seller(); //creating a buyer object
			person.CreateProductMenu(); //Reads the ProductInfo.txt file and populates them in 2 arrays based on their category
		}
		meatProductName = person.meatProductName;
		produceProductName = person.produceProductName;
	}

	public void createProductList() throws IOException {
		ProductIterator pi = new ProductIterator();
		String option;
		Scanner sc3 = new Scanner(System.in);
		if(UserType==0) {
			option="1";
			while(option.equals("1")){
				System.out.println("Menu:  Press 1 for your purchase history and Press 2 to Buy a product");
				Scanner sc2 = new Scanner(System.in);
				this.menutype = sc2.next();
				//Reading UserProduct.txt and displaying purchase history of a buyer
				if (menutype.equals("1")) {
					System.out.println(this.username + " has purchased: ");
					NodeVisitor nv = new NodeVisitor();
					nv.vistProduct(this.username);
				}
				//Writing in case of purchase
				else if (menutype.equals("2")) {
					System.out.println("Press 1 to buy meat products and Press 2 to buy produce products");
					String in = sc2.next();
					if(in.equals("1")){
						System.out.println("....Factory Method....");
						System.out.println("Meat Products");
						pi.productIterate(meatProductName);
					}
					else if(in.equals("2")){
						System.out.println("....Factory Method....");
						System.out.println("Produce Products");
						pi.productIterate(produceProductName);
					}
					else{
						System.out.println("Wrong input");
						break;
					}

					System.out.println("Press the number against the product to buy them");
					Integer buyProductIndex = Integer.parseInt(sc2.next());
					String buyProduct;
					if(in.equals("1")){
						buyProduct = meatProductName.get(buyProductIndex-1);
					}
					else{
						buyProduct = produceProductName.get(buyProductIndex-1);
					}
					ReminderVistor rv = new ReminderVistor();
					String productContent = this.username + ":" + buyProduct;
					NodeVisitor nv = new NodeVisitor();
					nv.writeProduct(this.username,productContent);
					System.out.println(buyProduct+" purchased");


				}
				else {
					System.out.println("Wrong Input");
				}
				System.out.println("Do want to see the menu again? Press 1 for Yes and 2 for No");
				option = sc3.next();
				System.out.println("option entered is "+option);
			}

		}
		else{
			option="1";
			while(option.equals("1")){
				System.out.println("Menu: Press 1 for your stock list, press 2 to add to stocks");
				Scanner sc2 = new Scanner(System.in);
				this.menutype = sc2.next();
				//Reading UserProduct.txt and displaying stocks of a seller
				if (menutype.equals("1")) {
					System.out.println(this.username + " seller has stocks: ");
					NodeVisitor nv = new NodeVisitor();
					nv.vistProduct(this.username);
				}
				//Writing addStock in UserProduct.txt
				else if (menutype.equals("2")) {
					System.out.println("How many different items you can to add?");
					Scanner sc5 = new Scanner(System.in);
					int count = Integer.parseInt(sc5.next());
					for (int i = 0; i < count; i++) {
						int z=i+1;
						System.out.println("Enter the item "+ z);
						String addProduct = sc5.next();
						String productContent = this.username + ":" + addProduct;
						NodeVisitor nv = new NodeVisitor();
						nv.writeProduct(this.username,productContent);
						System.out.println(productContent+" Added");
					}
				}
				else {
					System.out.println("wrong input");
				}
				System.out.println("Do want to see the menu again? Press 1 for Yes and any other key for No");
				option = sc3.next();
				System.out.println("option entered is "+option);
			}
		}
	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}


}
