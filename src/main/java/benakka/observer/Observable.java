package benakka.observer;

import benakka.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
    List<Observer> observers = new ArrayList<>();
    void notifyObserver(Transaction transaction);
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
}
