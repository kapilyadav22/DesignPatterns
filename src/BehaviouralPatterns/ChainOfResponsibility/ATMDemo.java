package BehaviouralPatterns.ChainOfResponsibility;

// Singleton Pattern for ATM
class ATM {
    private static ATM instance;
    private BankAccount currentAccount;
    private TransactionFactory transactionFactory;

    private ATM() {
        transactionFactory = new TransactionFactory();
    }

    public static ATM getInstance() {
        if (instance == null) {
            instance = new ATM();
        }
        return instance;
    }

    public void insertCard(BankAccount account) {
        this.currentAccount = account;
    }

    public void removeCard() {
        this.currentAccount = null;
    }

    public boolean executeTransaction(String transactionType, double amount) {
        if (currentAccount == null) {
            System.out.println("No card inserted.");
            return false;
        }

        Transaction transaction = transactionFactory.createTransaction(transactionType);
        return transaction.execute(currentAccount, amount);
    }
}

// Factory Pattern for Transactions
class TransactionFactory {
    public Transaction createTransaction(String transactionType) {
        switch (transactionType.toLowerCase()) {
            case "withdraw":
                return new WithdrawTransaction();
            case "deposit":
                return new DepositTransaction();
            case "balance":
                return new BalanceInquiryTransaction();
            default:
                throw new IllegalArgumentException("Invalid transaction type");
        }
    }
}

// Strategy Pattern for different Transaction types
interface Transaction {
    boolean execute(BankAccount account, double amount);
}

class WithdrawTransaction implements Transaction {
    @Override
    public boolean execute(BankAccount account, double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}

class DepositTransaction implements Transaction {
    @Override
    public boolean execute(BankAccount account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited: $" + amount);
        return true;
    }
}

class BalanceInquiryTransaction implements Transaction {
    @Override
    public boolean execute(BankAccount account, double amount) {
        System.out.println("Current balance: $" + account.getBalance());
        return true;
    }
}

// Simple BankAccount class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Main class for demonstration
public class ATMDemo {
    public static void main(String[] args) {
        ATM atm = ATM.getInstance();
        BankAccount account = new BankAccount(1000);

        atm.insertCard(account);

        atm.executeTransaction("balance", 0);
        atm.executeTransaction("withdraw", 500);
        atm.executeTransaction("balance", 0);
        atm.executeTransaction("deposit", 200);
        atm.executeTransaction("balance", 0);

        atm.removeCard();
    }
}
