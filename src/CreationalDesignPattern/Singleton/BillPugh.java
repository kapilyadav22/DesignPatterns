package CreationalDesignPattern.Singleton;

public class BillPugh {
    // Private constructor to prevent instantiation
    private BillPugh() {
        System.out.println("Instance of Singleton Using BillPugh");
    }
    // Static inner class that holds the instance
    private static class SingletonHelper {
        private static final BillPugh INSTANCE = new BillPugh();
    }

    // Public method to get the instance
    public static BillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }
}