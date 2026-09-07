import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
        BankAcount account = new BankAcount("John Doe", 500);
        account.printAccountInfo();

        account.deposit(200);
        account.printAccountInfo();

        account.withdraw(100);
        account.printAccountInfo();

        account.withdraw(700);
        account.printAccountInfo();

        account.withdraw(50);
        account.printAccountInfo();
    }
}
