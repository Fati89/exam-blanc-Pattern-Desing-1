package benakka.model;

import benakka.event.AddTransactionEvent;
import benakka.observer.Observable;
import benakka.observer.Observer;
import benakka.strategy.DefaultStrategy;
import benakka.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Observable, Observer {
    private String name;
    private double solde=0;
    private String history="";

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    Strategy strategy = new DefaultStrategy();
    private List<Transaction> transactions = new ArrayList<>();

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistory() {
        return history;
    }


    public Agent(String name){
        this.name = name;
    }

    public void addTrasaction(Transaction transaction){
        transactions.add(transaction);
        notifyObserver(transaction);
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getSolde() {
        return this.solde;
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
        strategy.update(addTransactionEvent);
    }
}
