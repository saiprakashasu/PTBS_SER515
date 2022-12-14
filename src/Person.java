import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Person {
	public Person(){
		System.out.println("...Bridge Pattern...");
	}
	ArrayList<String> meatProductName=new ArrayList<>();
	ArrayList<String> produceProductName=new ArrayList<>();
	private ProductMenu theProductMenu;

	private ProductMenu productMenu;

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	//Reads the ProductInfo.txt file and populates them in 2 arrays based on their category
	public void CreateProductMenu() {
		File products=new File("src\\textfiles\\ProductInfo.txt");
		System.out.println("Creating Product Menu");
		try {
			FileReader pdts = new FileReader(products);
			BufferedReader buffer = new BufferedReader(pdts);
			String line;
			while ((line = buffer.readLine()) != null) {  //line stored in string

				String[] content = line.split(":");
				if(content[0].equals("Meat")){
					this.meatProductName.add(content[1]);  // meatProductName populated with beef,pork, mutton
					System.out.println("added "+content[1]+" in meat product list");
				}
				else if(content[0].equals("Produce")){
					this.produceProductName.add(content[1]);  // produceProductName populated with tomato, onion
					System.out.println("added "+content[1]+" in produce product list");
				}
			}
			pdts.close();
			buffer.close();
		}
		catch(Exception e){e.printStackTrace();}
	}

}
