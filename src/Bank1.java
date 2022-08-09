
import java.util.Scanner;
class Application{
    Scanner sc = new Scanner(System.in);
    String AccNo;
    long Tot_amount;
    String AccHolder;
    public void newAccount() { //method to open new account
        System.out.println("Account number Please");
        AccNo = sc.next();
        System.out.println("Account Name Please");
        String AccHolder = sc.next();
        System.out.println("Account Balance");
        long Tot_amount = sc.nextLong();
    }
    public void accDet(){  //method to print account Details
        System.out.println("Account Holder Name:"+AccHolder);
        System.out.println("Account Number:"+AccNo);
        System.out.println("Current Amount:"+Tot_amount);

    }
    public void deposit(){ //method to print deposit details
        System.out.println("Amount you want to deposit:");
        int dep_amount=sc.nextInt();
        Tot_amount=Tot_amount+dep_amount;
    }
    public void withdrawl(){ //method to print withdraw details
        System.out.println("Amount to Withdraw");
        long Withd_amt = sc.nextInt();
        if (Tot_amount >= Withd_amt) {
            Tot_amount = Tot_amount - Withd_amt;
            System.out.println("Remaining Amount:" + Tot_amount);
        } else {
            System.out.println("Entered amount is too high");
        }
    }
    boolean find(String Acc_No){
        if(AccNo.equals(Acc_No)){
            accDet();
            return(true);
        }
        return(false);
    }}
public class Bank1{  //main class
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Total Account Holders");
        int n=sc.nextInt();
        Application AC[]=new Application[n];
        for(int i=0;i<AC.length;i++){
            AC[i]=new Application();
            AC[i].newAccount();
        }
        int x;
        do{
            System.out.println("Bank Transactions");
            System.out.println("1.Display all account details\n" +
                    "\n" +
                    "Search by account number\n" +
                    "\n" +
                    " Deposit the amount\n" +
                    "\n" +
                    " Withdraw the amount\n" +
                    "\n" +
                    "·Exit");
            x=sc.nextInt();
            switch (x){ //initializing Switch statement
                case 1:
                    for (int i=0;i< AC.length;i++){
                        AC[i].accDet();
                    }
                    break;
                case 2:
                    System.out.println("Enter Account_no:");
                    String Acc_no=sc.next();
                    boolean found=false;
                    for (int i=0;i<AC.length;i++){
                        found=AC[i].find(Acc_no);
                        if(found){
                            AC[i].deposit();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Invalid Account");
                    }
                    break;
                case 3:
                    System.out.println("Account number Please");
                    Acc_no=sc.next();
                    found=false;
                    for(int i=0;i<AC.length;i++){
                        found=AC[i].find(Acc_no);
                        if(found){
                            AC[i].withdrawl();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Invalid Account");
                    }
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
            }
        }
        while(x!=4);

    }}

