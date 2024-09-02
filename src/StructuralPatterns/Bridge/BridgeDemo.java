package StructuralPatterns.Bridge;

interface NavigationImpl{
    void navigateTo();
}

class googleMaps  implements NavigationImpl{
    public void navigateTo(){
        System.out.println("Google Maps");
    }
}

class appleMaps  implements NavigationImpl{
    public void navigateTo(){
        System.out.println("Apple Maps");
    }
}

abstract class NavigationSystem {
    NavigationImpl  navigationImpl;
    abstract void navigate();
    void setNavigationSystem(NavigationImpl navigationImpl){
        this.navigationImpl = navigationImpl;
    }
}


class UberEats extends NavigationSystem{
    String Destination;
    UberEats(String Destination){
        this.Destination = Destination;
    }

    @Override
    void navigate() {
        System.out.println("Navigating to " + Destination);
    }
}

class UberRides extends NavigationSystem{
    String Destination;
    UberRides(String Destination){
        this.Destination = Destination;
    }
    @Override
    void navigate() {
        System.out.println("Navigating to " + Destination);
    }
}

public class BridgeDemo {
    public static void main(String[] args) {

        NavigationSystem navigationSystem = new UberEats("Delhi");
        navigationSystem.navigate();
        NavigationSystem navigationSystem2 = new UberRides("Jaipur");
        navigationSystem2.navigate();
    }

}
