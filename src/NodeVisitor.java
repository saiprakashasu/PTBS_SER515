import java.io.*;

public class NodeVisitor {

	//Reading UserProduct.txt and displaying purchase history of a buyer or stocks of a seller
	public void vistProduct(String username) {
		try {
			//System.out.println("Iterator pattern");
			File res = new File("src\\textFiles\\UserProduct.txt");
			FileReader pName = new FileReader(res);
			BufferedReader buffername = new BufferedReader(pName);
			String line;
			int temp=0;
			while ((line = buffername.readLine()) != null) {  //line stored in string
				String[] x = line.split(":");
				if (x[0].equals(username)) {
					System.out.println(x[1]+" ");
					temp++;
				}
			}
			buffername.close();
			//System.out.println("outside while loop");
			if(temp==0){
				System.out.println("Nothing");
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	//Writing in case of purchase or addStock in UserProduct.txt
	public void writeProduct(String username,String productContent){
		try{
			File f = new File("src\\textFiles\\UserProduct.txt");
			FileWriter fw = new FileWriter(f,true);
			BufferedWriter b = new BufferedWriter(fw);
			//String x = "a";
			//String y="b";
			String[] x = productContent.split(":");
			b.write("\n"+x[0]+":"+x[1]);
			b.close();
			System.out.println(productContent+" Added");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void visitTrading(Trading trading) {

	}

	public void visitFacade(Facade facade) {

	}

}