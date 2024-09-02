package BehaviouralPatterns.Iterator;

//class Book

import java.util.Arrays;
import java.util.List;

class Book {
    String title;
    String author;
    int price;
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    String getTitle(){
        return title;
    }
    String getAuthor(){
        return author;
    }
    int getPrice(){
        return price;
    }
}

//create an aggregator interface
interface Aggregator {
    Iterator createIterator();
}

//create the BookAggregator class
class BookAggregator implements Aggregator {
    List<Book> books;
    BookAggregator(List<Book> books){
        this.books = books;
    }
    @Override
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}

//create interface iterator
interface Iterator {
    boolean hasNext();
    Book next();
}

//create concrete BookIterator
class BookIterator implements Iterator {
    List<Book> books;
    int index = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index<books.size();
    }

    @Override
    public Book next() {
        return books.get(index++);
    }
}

public class IteratorDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "Kapil Doe", 45);
        Book book2 = new Book("Cpp Programming", "Rahul Doe", 35);
        Book book3 = new Book("C Programming", "Binod Doe", 25);
        Book book4 = new Book("Python Programming", "SachivJee Doe", 15);

        Aggregator aggregator = new BookAggregator(Arrays.asList(book1,book2,book3,book4));
        Iterator itr = aggregator.createIterator();

        while(itr.hasNext()){
            Book book = itr.next();
            System.out.println("Book title is :" + book.getTitle() + "book price is :  "+ book.getPrice());
        }

    }
}


/*
create a product
create an aggregator interface( collection like set, map, etc, where product will be stored) : it should have createIterator method
create an aggregator class : it will take products from user and create an iterator
create an iterator interface : hasnext, next should be there
create and iterator class : implement hasnext, next, and create constructor to pass values from aggregator to iterator while creating
... iterator from aggregator (createaggregator)
 */