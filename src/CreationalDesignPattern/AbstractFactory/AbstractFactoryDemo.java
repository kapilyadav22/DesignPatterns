package CreationalDesignPattern.AbstractFactory;//sofa, table and chair are products
//Ancient, Modern, and Luxury Sofa are Creators

import java.util.Map;
import java.util.TreeMap;

//product interfaces
interface iSofa {
    void getSofa();
}

interface iTable {
    void getTable();
}

interface iChair {
    void getChair();
}

//concreate products
class modernSofa implements iSofa {
    public void getSofa() {
        System.out.println("Modern Sofa");
    }
}

class ancientSofa implements iSofa {
    public void getSofa() {
        System.out.println("Ancient Sofa");
    }
}

class luxurySofa implements iSofa {
    public void getSofa() {
        System.out.println("Luxury Sofa");
    }
}

class ancientChair implements iChair {
    public void getChair() {
        System.out.println("Ancient Chair");
    }
}

class luxuryChair implements iChair {
    public void getChair() {
        System.out.println("Luxury Chair");
    }
}

class modernChair implements iChair {
    public void getChair() {
        System.out.println("Modern Chair");
    }
}

class ancientTable implements iTable {
    public void getTable() {
        System.out.println("Ancient Table");
    }
}

class luxuryTable implements iTable {
    public void getTable() {
        System.out.println("Luxury Table");
    }
}

class modernTable implements iTable {
    public void getTable() {
        System.out.println("Modern Table");
    }
}


//creator interface
interface AbstractFurtinureFactory {
    iSofa createSofa();

    iChair createChair();

    iTable createTable();

//     static CreationalDesignPattern.AbstractFactory.AbstractFurtinureFactory createFurtinureFactory(String furnitureTye) throws Exception {
//       switch (furnitureTye) {
//           case "Luxury": return new CreationalDesignPattern.AbstractFactory.LuxuryFactory();
//           case "Modern" : return new CreationalDesignPattern.AbstractFactory.ModernFactory();
//           case "Ancient" : return new CreationalDesignPattern.AbstractFactory.AncientFactory();
//           default: throw new NullPointerException();
//       }
//     }
}

//another way of creatingFactory
class FurnitureFactoryProvider {
    private static final Map<String, AbstractFurtinureFactory> FACTORIES = new TreeMap<>();

    static {
        FACTORIES.put("Luxury", new LuxuryFactory());
        FACTORIES.put("Modern", new ModernFactory());
        FACTORIES.put("Ancient", new AncientFactory());
    }

    public static AbstractFurtinureFactory getFurnitureFactory(String furnitureType) throws Exception {
        AbstractFurtinureFactory factory = FACTORIES.get(furnitureType);
        if(factory == null) {
            throw new NullPointerException();
        }
        return factory;
    }
}

//concreate interfaces
class AncientFactory implements AbstractFurtinureFactory {
    @Override
    public iSofa createSofa() {
        return new ancientSofa();
    }

    @Override
    public iChair createChair() {
        return new ancientChair();
    }

    @Override
    public iTable createTable() {
        return new ancientTable();
    }
}

class ModernFactory implements AbstractFurtinureFactory {

    @Override
    public iSofa createSofa() {
        return new modernSofa();
    }

    @Override
    public iChair createChair() {
        return new modernChair();
    }

    @Override
    public iTable createTable() {
        return new modernTable();
    }
}

class LuxuryFactory implements AbstractFurtinureFactory {

    @Override
    public iSofa createSofa() {
        return new luxurySofa();
    }

    @Override
    public iChair createChair() {
        return new luxuryChair();
    }

    @Override
    public iTable createTable() {
        return new luxuryTable();
    }
}

class Client {
    iSofa sofa;
    iTable table;
    iChair chair;

    public Client(AbstractFurtinureFactory factory) {
        sofa = factory.createSofa();
        table = factory.createTable();
        chair = factory.createChair();
    }

    public void getConcreateProducts() {
        sofa.getSofa();
        table.getTable();
        chair.getChair();
    }
}

public class AbstractFactoryDemo {
    //CreationalDesignPattern.AbstractFactory.AbstractFactoryDemo is like main
    public static void main(String[] args) {
        //CreationalDesignPattern.AbstractFactory.AbstractFurtinureFactory modernfactory = new CreationalDesignPattern.AbstractFactory.ModernFactory();
        //     CreationalDesignPattern.AbstractFactory.Client client = new CreationalDesignPattern.AbstractFactory.Client(modernfactory);
        //     client.getConcreateProducts();

//        try{
//            CreationalDesignPattern.AbstractFactory.AbstractFurtinureFactory furnitureFactory = CreationalDesignPattern.AbstractFactory.AbstractFurtinureFactory.createFurtinureFactory("Modern");
//            CreationalDesignPattern.AbstractFactory.Client client = new CreationalDesignPattern.AbstractFactory.Client(furnitureFactory);
//            client.getConcreateProducts();
//        } catch (Exception e){
//            System.out.println("Exception in furniturefactory " + e.getMessage());
//        }

        try {
            AbstractFurtinureFactory factory = FurnitureFactoryProvider.getFurnitureFactory("Lauxury");
            Client client = new Client(factory);
            client.getConcreateProducts();
        } catch (Exception e) {
            System.out.println("Exception in factory: " + e.getMessage());
        }
    }
}


