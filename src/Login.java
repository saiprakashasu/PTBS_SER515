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
        this.usertype=-1;   // 0 for buyer and 1 for seller
        try {
            Scanner sc1=new Scanner(System.in);
            //Getting username and password from users
            System.out.println("Enter username");
            this.username=sc1.next();
            System.out.println("Enter password");
            this.password=sc1.next();
            ////Reading file contents
            File sellerInfo = new File("src\\textfiles\\SellerInfo.txt");
            File buyerInfo = new File("src\\textfiles\\BuyerInfo.txt");
            FileReader frb = new FileReader(buyerInfo);
            FileReader frs = new FileReader(sellerInfo);
            BufferedReader BRB = new BufferedReader(frb);
            BufferedReader BRS = new BufferedReader(frs);

            String line;  //Contains each line content from the file

            //Block of code checks if the credentials are correct and finds the type of user
            while((line=BRB.readLine())!=null)
            {
                String[] lineContent = line.split(":"); //Splitting the content based on the delimited
                if((lineContent[0].equals(username)) && (lineContent[1].equals(password)))
                {
                    System.out.println("Buyer logged in");
                    this.usertype=0;
                    System.out.println("type:"+this.usertype);
                    break;
                }

            }
            while((line=BRS.readLine())!=null)
            {
                String[] lineContent = line.split(":"); //Splitting the content based on the delimited
                if((lineContent[0].equals(username)) && (lineContent[1].equals(password)))
                {
                    System.out.println("Seller logged in");
                    this.usertype=1;
                    System.out.println("type:"+this.usertype);
                    break;
                }
            }

            frb.close();
            frs.close();
            BRB.close();
            BRS.close();

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
