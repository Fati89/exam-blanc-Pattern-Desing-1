package benakka.event;

import benakka.model.Transaction;

public record AddTransactionEvent(String name, Transaction transaction) {
}
