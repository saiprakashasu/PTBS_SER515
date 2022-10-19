import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    String username;
    String password;
    int usertype;
    public int loginFunction()
    {
        this.usertype=-1;
        System.out.println("Implementing Facade Design pattern");
        try {
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter username");
            this.username=sc1.next();
            System.out.println("Enter password");
            this.password=sc1.next();
            //Initializing File objects
            File sellerInfo = new File("src\\textfiles\\SellerInfo.txt");
            File buyerInfo = new File("src\\textfiles\\BuyerInfo.txt");

            FileReader buyer = new FileReader(buyerInfo);
            FileReader seller = new FileReader(sellerInfo);
            //For reading lines
            BufferedReader BRB = new BufferedReader(buyer);
            BufferedReader BRS = new BufferedReader(seller);
            String line;

            //Checking if the credentials are correct and finding the type of user
            while((line=BRB.readLine())!=null)
            {

                String[] lineContent = line.split(":");
                if((lineContent[0].equals(username)) && (lineContent[1].equals(password)))
                {
                    System.out.println("matched Buyer");
                    this.usertype=0;
                    System.out.println("type:"+this.usertype);
                    break;
                }

            }
            while((line=BRS.readLine())!=null)
            {

                String[] lineContent = line.split(":");
                if((lineContent[0].equals(username)) && (lineContent[1].equals(password)))
                {
                    System.out.println("matched Seller");
                    this.usertype=1;
                    System.out.println("type:"+this.usertype);
                    break;
                }
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        if(this.usertype==-1){
            System.out.println("Wrong Credentials");
        }

        return this.usertype;

    }
}
