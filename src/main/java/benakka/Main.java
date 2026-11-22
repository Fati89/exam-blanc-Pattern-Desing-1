package benakka;

import benakka.enums.TypeTransaction;
import benakka.model.Agent;
import benakka.model.Container;
import benakka.model.Transaction;
import benakka.strategy.HistotyStrategy;
import benakka.strategy.ScoringStrategy;

import java.util.Date;

public class Main {
    static void main() {

        Agent kiro = new Agent("kiro");
        Agent claude = new Agent("claude");

        Container container = Container.getInstance();
        container.addAgent(kiro);
        container.addAgent(claude);

        kiro.subscribe(claude);
        claude.subscribe(kiro);
        claude.setStrategy(new ScoringStrategy());

        kiro.addTrasaction(new Transaction("#1k", new Date(), 3000, TypeTransaction.VENTE));
        claude.addTrasaction(new Transaction("#1c", new Date(), 50000, TypeTransaction.VENTE));

        kiro.setStrategy(new HistotyStrategy());

        kiro.addTrasaction(new Transaction("#2k", new Date(), 2000, TypeTransaction.ACHAT));
        claude.addTrasaction(new Transaction("#2c", new Date(), 10000, TypeTransaction.ACHAT));
    }
}
