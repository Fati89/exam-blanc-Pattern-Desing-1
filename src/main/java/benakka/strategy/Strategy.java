package benakka.strategy;

import benakka.event.AddTransactionEvent;
import benakka.model.Transaction;

public interface Strategy {
    void update(AddTransactionEvent addTransactionEvent);
}
