package benakka.observer;

import benakka.event.AddTransactionEvent;

public interface Observer {
    void update(AddTransactionEvent addTransactionEvent);
}
