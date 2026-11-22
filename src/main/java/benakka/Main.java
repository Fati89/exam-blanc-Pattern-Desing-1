package benakka;

import benakka.enums.TypeTransaction;
import benakka.model.Agent;
import benakka.model.Transaction;

import java.util.Date;

public class Main {
    static void main() {
        Agent agent1 = new Agent("kiro");
        Agent agent2 = new Agent("claude");

        agent1.subscribe(agent2);
        agent2.subscribe(agent1);

        agent1.addTrasaction(new Transaction("#1k", new Date(), 3000, TypeTransaction.ACHAT));
        agent2.addTrasaction(new Transaction("#1c", new Date(), 50000, TypeTransaction.VENTE));
    }
}
