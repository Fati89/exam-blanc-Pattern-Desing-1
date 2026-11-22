package benakka.strategy;

import benakka.event.AddTransactionEvent;
import benakka.model.Transaction;

public class DefaultStrategy implements Strategy{
    @Override
    public void update(AddTransactionEvent addTransactionEvent) {
        String name = addTransactionEvent.name();
        Transaction transaction = addTransactionEvent.transaction();
        System.out.println("Name: "+name+" --- Transaction: "+transaction.toString());
    }
}
