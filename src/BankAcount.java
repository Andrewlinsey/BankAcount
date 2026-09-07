public class BankAcount {
    String m_name;
    int m_balance;

    public BankAcount(String name, int balance) {
        if(balance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to $0.");
            balance = 0;
        }
        m_name = name;
        m_balance = balance;
    }

    public void deposit(int amount) {

        if (amount < 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        m_balance += amount;
    }

    public void withdraw(int amount) {
        if(amount < 0) {
            System.out.println("Withdrawal amount must be positive");
            return;
        }
        
        if((m_balance - amount) < 0) {
            System.out.println("Insufficient funds");
            return;
        }
        else if((m_balance - amount) < 100) {
            System.out.println("Warning: Your balance is below $100");
        }
        m_balance -= amount;
    }

    public int getBankBalance() {
        return m_balance;
    }

    public void printAccountInfo() {
        System.out.println("Account Name: " + m_name);
        System.out.println("Account Balance: $" + m_balance);
    }
}
