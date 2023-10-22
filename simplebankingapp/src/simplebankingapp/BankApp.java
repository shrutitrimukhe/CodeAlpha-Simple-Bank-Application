package simplebankingapp;
import java.util.*;
public class BankApp {

	String acc_no,name;
    long balance;
    
    Scanner sc = new Scanner(System.in);  
     
    public void openAccount() {  
        System.out.print("Enter Account Number: ");  
        acc_no = sc.next();  
        System.out.print("Enter Name: ");  
        name = sc.next();  
        System.out.print("Enter Balance: ");  
        balance = sc.nextLong();  
    } 

    public void showBalance() {  
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + acc_no);  
        System.out.println("Balance: " + balance);  
    } 

    public void deposit() {  
        long amount;  
        System.out.println("Enter the amount you want to deposit: ");  
        amount = sc.nextLong();  
        balance = balance + amount;  
        System.out.println("Balance after deopsit: " + balance); 
    }  

    public void withdrawal() {  
        long amount;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amount = sc.nextLong();  
        if (balance >= amount) {  
            balance = balance - amount;  
            System.out.println("Balance after withdrawal: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amount + "\tTransaction failed...!!" );  
        }  
    }
    public boolean search(String a_no) {  
        if (acc_no.equals(a_no)) {  
            return (true);  
        }  
        return (false);  
    }  

    public static void main(String[] args) {
        System.out.print("Number of customers you want to input: ");  
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();  
        BankApp a[] = new BankApp[n];  
        for (int i = 0; i < a.length; i++) { 
            a[i]=new BankApp(); 
            a[i].openAccount();  
        } 
        int choice;
        do{
            System.out.println("\n   # Banking System Application #   \n");  
            System.out.println("1. Check Bank Balance \n2. Deposit the Amount \n3. Withdraw the Amount \n4. Exit \n");  
            System.out.println("Enter your choice: ");  
            choice=s.nextInt();
            switch (choice) {  
                case 1: 
                System.out.print("Enter Account no. : "); 
                boolean found=false;
                String num =s.next();
                for (int i = 0; i < a.length; i++) {
                    found=a[i].search(num);
                        if(found){
                        System.out.println("Your Account balance is: "+a[i].balance);
                        break;
                    }
                }
                if (!found) {  
                    System.out.println("Failed! Account doesn't exist..!!");  
                } 
                break;

                case 2:
                System.out.println("Enter Account Number : ");
                num = s.next();  
                found = false;  
                for (int i = 0; i < a.length; i++) {  
                    found = a[i].search(num);  
                    if (found) {  
                        a[i].deposit();  
                        break;  
                    }  
                }  
                if (!found) {  
                    System.out.println("Failed! Account doesn't exist..!!");  
                } 
                break;

                case 3:  
                System.out.print("Enter Account Number : ");  
                num = s.next();  
                found = false;  
                for (int i = 0; i < a.length; i++) {  
                    found = a[i].search(num);  
                    if (found) {  
                        a[i].withdrawal();  
                        break;  
                    }  
                }  
                if (!found) {  
                    System.out.println("Failed! Account doesn't exist..!!");  
                } 
                break;
                    
                case 4:
                System.out.println("See you soon!!");  
                break;  
            }
        }
    while(choice!=4);
    s.close();
    }
}
