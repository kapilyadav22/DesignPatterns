package BehaviouralPatterns.ObserverPattern;

import java.util.ArrayList;

interface Observers {
     void sendNotification(String notification);
}

class EmailObserver implements Observers {

    @Override
    public void sendNotification(String notification) {
        System.out.println("Hi Email : " + notification);
    }
}

class SMSObserver implements Observers {

    @Override
    public void sendNotification(String notification) {
        System.out.println("Hi SMS : " +  notification);
    }
}


interface Subject{
    ArrayList<Observers> observers = new ArrayList<Observers>();
     void registerObserver(Observers observer);
     void removeObserver(Observers observer);
     void notifyObservers();
}

class SubjectImpl implements Subject{

    @Override
    public void registerObserver(Observers observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observers observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observers observer : observers) {
            observer.sendNotification("Observers");
        }
    }
}



public class ObserverDemo {
    public static void main(String[] args) {
        Observers observer = new EmailObserver();
        Observers observer1 = new SMSObserver();
        Subject subject = new SubjectImpl();
        subject.registerObserver(observer);
        subject.registerObserver(observer1);
        subject.notifyObservers();
    }
}
