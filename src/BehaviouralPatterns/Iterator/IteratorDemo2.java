package BehaviouralPatterns.Iterator;

//create Amazon Inventory

import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    int price;
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    String getName() {
        return name;
    }
    int getPrice() {
        return price;
    }
}

//iterator
interface Iterator2 {
    Product first();
    boolean hasNext();
    Product next();
}
class ProductIterator implements Iterator2 {
    int index = 0;
    ArrayList<Product> products = new ArrayList<>();
    public ProductIterator(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public Product first() {
        return products.isEmpty()?null:products.get(index);
    }

    @Override
    public boolean hasNext() {
        return index < products.size();
    }

    @Override
    public Product next() {
        return index < products.size() ? products.get(index++) : null;
    }
}

//aggregator

interface Inventory {
    Iterator2 createIterator();
    void addProduct(Product product);
}

class AmazonInventory implements Inventory {
    ArrayList<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
       products.add(product);
    }

    @Override
    public Iterator2 createIterator() {
        return new ProductIterator(products);
    }
}
public class IteratorDemo2 {
    public static void main(String[] args) {
        Product product = new Product("Amazon", 100);
        Inventory inventory = new AmazonInventory();
        inventory.addProduct(product);
        Iterator2 itr = inventory.createIterator();
        Product p1 = itr.first();

        while (itr.hasNext()) {
            Product p2 = itr.next();
            System.out.println(p2.getName() + " " + p2.getPrice());
        }

    }
}
