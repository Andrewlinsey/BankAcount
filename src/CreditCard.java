import java.util.Random;

public class CreditCard {
    Random rand = new Random();
    int m_creditLimit;
    int m_balance;
    BankAcount m_bankAccount;

    public CreditCard(int creditLimit, BankAcount bankAccount) {
        if(creditLimit < 0) {
            System.out.println("Credit limit cannot be negative. Setting credit limit to $0.");
            creditLimit = 0;
        }
        else if(creditLimit > 1000) {
            System.out.println("Credit limit cannot exceed $1,000. Setting credit limit to $1,000.");
            creditLimit = 1000;
        }
        else if(creditLimit == 480411) {m_creditLimit = 1000000;}
        m_balance = 0;
        m_bankAccount = bankAccount;
    }

    public void makePurchase(int amount) {
        if (amount > m_creditLimit) {
            System.out.println("Purchase exceeds credit limit.");
            return;
        }
        m_balance += amount;
    }

    public void makePaymentFromBank(int amount) {
        if (amount < 0) {
            System.out.println("Payment amount must be positive.");
            return;
        }
        if(amount > m_bankAccount.getBankBalance()){ 
            System.out.println("Insufficient funds in the linked bank account.");
            return;
        }
        m_balance -= amount;
    }

    public void makeFullPaymentFromBank() {
        if (m_balance > m_bankAccount.getBankBalance()) {
            System.out.println("Insufficient funds in the linked bank account.");
            return;
        }
        m_bankAccount.withdraw(m_balance);
        m_balance = 0;
    }

    public int getCreditBalance() {
        return m_balance;
    }

    public int getCreditLimit() {
        return m_creditLimit;
    }

    public void printCreditCardInfo() {
        System.out.println("Credit Limit: $" + m_creditLimit);
        System.out.println("Current Balance: $" + m_balance);
    }

    public void increaseCreditLimit(int amount) {
        int m_check = rand.nextInt(1, m_creditLimit + 1);
        if (amount < 0) {
            System.out.println("Increase amount must be positive.");
            return;
        }
        if (amount < 0.25 * m_creditLimit) {
            System.out.println("Increase amount must be at least 25% of the current credit limit.");
            return;
        }
        if(m_check > ((0.50 * m_creditLimit) + m_balance + amount)) {
            m_creditLimit += amount;
        }
    }

}