package benakka.model;

import benakka.event.AddTransactionEvent;
import benakka.observer.Observable;
import benakka.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Observable, Observer {
    private String name;
    private List<Transaction> transactions = new ArrayList<>();

    public Agent(String name){
        this.name = name;
    }

    public void addTrasaction(Transaction transaction){
        transactions.add(transaction);
        notifyObserver(transaction);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void notifyObserver(Transaction transaction) {
        for(Observer o:observers){
            if (o instanceof Agent agent && agent.getName().equals(this.name)) continue;
            o.update(new AddTransactionEvent(this.name, transaction));
        }
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void update(AddTransactionEvent addTransactionEvent) {
        String name = addTransactionEvent.name();
        Transaction transaction = addTransactionEvent.transaction();
        System.out.println("Name: "+name+" --- Transaction: "+transaction.toString());
    }
}
