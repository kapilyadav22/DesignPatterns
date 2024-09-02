package CreationalDesignPattern.Singleton;

class SingletonClass {
    private static SingletonClass instance;
    private void SingletonClass() {
        System.out.println("Instance of Singleton");
    }
    public static  SingletonClass getInstance() {
        if(instance == null) {
            synchronized(SingletonClass.class){
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
