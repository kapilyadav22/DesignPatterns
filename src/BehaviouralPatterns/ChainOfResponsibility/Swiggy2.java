package BehaviouralPatterns.ChainOfResponsibility;


//create separate handler calls
interface OrderHandler2 {
     void processOrder(String order);
     void setNextHandler(OrderHandler2 nextHandler);
}

class OrderValidationHandler2 implements OrderHandler2 {
    OrderHandler2 nextOrderHandler;

    @Override
    public void setNextHandler(OrderHandler2 nextHandler) {
            nextOrderHandler = nextHandler;
    }
    @Override
    public void processOrder(String order) {
        System.out.println("Order is Validating");
        if(nextOrderHandler != null){
            nextOrderHandler.processOrder(order);
        }
    }
}

class paymentProcessHandler2 implements OrderHandler2 {
    OrderHandler2 nextOrderHandler;

    @Override
    public void processOrder(String order) {
        System.out.println("Payment is proceeding");
        if(nextOrderHandler != null){
            nextOrderHandler.processOrder(order);
        }
    }

    @Override
    public void setNextHandler(OrderHandler2 nextHandler) {
        nextOrderHandler = nextHandler;
    }
}

class prepareOrderHandler2 implements OrderHandler2 {
    OrderHandler2 nextOrderHandler;

    @Override
    public void setNextHandler(OrderHandler2 nextHandler) {
        nextOrderHandler = nextHandler;
    }
    @Override
    public void processOrder(String order) {
        System.out.println("Order is preparing");
        if(nextOrderHandler != null){
            nextOrderHandler.processOrder(order);
        }
    }
}

public class Swiggy2 {
    public static void main(String[] args) {
        OrderHandler2 orderValidationHandler2 = new OrderValidationHandler2();
        OrderHandler2 paymentProcessHandler2 = new paymentProcessHandler2();
        OrderHandler2 prepareOrderHandler2 = new prepareOrderHandler2();

        orderValidationHandler2.setNextHandler(paymentProcessHandler2);
        paymentProcessHandler2.setNextHandler(prepareOrderHandler2);

        //2 next handlers, payment and preparing order
        orderValidationHandler2.processOrder("burger");
        System.out.println("---------------------------------------------");
        //only 1 next handler
        paymentProcessHandler2.processOrder("burger");
        System.out.println("---------------------------------------------");
        //no next handler of Preparing Order
        prepareOrderHandler2.processOrder("pizza");
    }
}
