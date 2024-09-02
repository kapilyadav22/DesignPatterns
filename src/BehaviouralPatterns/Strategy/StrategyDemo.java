package BehaviouralPatterns.Strategy;

//interface -
interface PaymentStrategy {
    void processPayment(double amount);
}

class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Via Credit Card "+ amount);
    }
}

class DebitCardStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Via Debit Card "+ amount);
    }
}

class UPIStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Via UPI "+ amount);
    }
}

//Context - in which we will choose our strategy
class PaymentProcessor {
    PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void processPayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.processPayment(amount);
        } else {
            System.err.println("Payment strategy not set.");
        }
    }
}


public class StrategyDemo {
    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        PaymentStrategy paymentStrategy = new CreditCardStrategy();
        PaymentStrategy paymentStrategy1 = new DebitCardStrategy();
        PaymentStrategy paymentStrategy2 = new UPIStrategy();
        paymentProcessor.setPaymentStrategy(paymentStrategy);
        paymentProcessor.processPayment(10);


    }
}
