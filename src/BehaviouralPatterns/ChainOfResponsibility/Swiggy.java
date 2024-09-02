package BehaviouralPatterns.ChainOfResponsibility;

abstract class OrderHandler {
    OrderHandler nextOrderHandler;
    OrderHandler(OrderHandler nextOrderHandler){
        this.nextOrderHandler = nextOrderHandler;
    }
    public abstract void processOrder(String order);
}

class OrderValidationHandler extends OrderHandler {
    OrderValidationHandler(OrderHandler nextOrderHandler){
        super(nextOrderHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Order is Validating");
        if(nextOrderHandler != null){
            nextOrderHandler.processOrder(order);
        }
    }
}

class paymentProcessHandler extends OrderHandler {
    paymentProcessHandler(OrderHandler nextOrderHandler){
        super(nextOrderHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Payment is proceeding");
        if(nextOrderHandler != null){
            nextOrderHandler.processOrder(order);
        }
    }
}

class prepareOrderHandler extends OrderHandler {
    prepareOrderHandler(OrderHandler nextOrderHandler){
        super(nextOrderHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Order is preparing");
        if(nextOrderHandler != null){
            nextOrderHandler.processOrder(order);
        }
    }
}

public class Swiggy {
    public static void main(String[] args) {
        OrderHandler nextOrderHandler = new OrderValidationHandler(new paymentProcessHandler(new prepareOrderHandler(null)));
        nextOrderHandler.processOrder("pizza");
    }
}
