package BehaviouralPatterns.Template;

abstract class OrderProcessingTemplate {
    public final void processOrder(){
        validateOrder();
        prepareOrder();
        assignDeliveryPartner();
        TrackDelivery();
    }
    public abstract void validateOrder();
    public abstract void prepareOrder();
    public abstract void assignDeliveryPartner();
    public abstract void TrackDelivery();
}


class LocalOrderprocessing extends OrderProcessingTemplate {
    @Override
    public void validateOrder(){
        System.out.println("Validating Local order...");
    }
    @Override
    public void prepareOrder(){
        System.out.println("Preparing Local  order...");
    }
    @Override
    public void assignDeliveryPartner(){
        System.out.println("Assigning Local delivery partner");
    }
    @Override
    public void TrackDelivery(){
        System.out.println("Tracking Local delivery");
    }
}

class InternationOrderprocessing extends OrderProcessingTemplate {
    @Override
    public void validateOrder(){
        System.out.println("Validating International order...");
    }
    @Override
    public void prepareOrder(){
        System.out.println("Preparing International order...");
    }
    @Override
    public void assignDeliveryPartner(){
        System.out.println("Assigning International delivery partner");
    }
    @Override
    public void TrackDelivery(){
        System.out.println("Tracking delivery");
    }
}

public class TemplateDemo {
    public static void main(String[] args) {
        OrderProcessingTemplate template = new LocalOrderprocessing();
        template.processOrder();
        OrderProcessingTemplate template2 = new InternationOrderprocessing();
        template2.processOrder();
    }
}
