package benakka.strategy;

import benakka.enums.TypeTransaction;
import benakka.event.AddTransactionEvent;
import benakka.model.Agent;
import benakka.model.Container;
import benakka.model.Transaction;

public class ScoringStrategy implements Strategy{
    @Override
    public void update(AddTransactionEvent addTransactionEvent) {
        Container container = Container.getInstance();
        String name = addTransactionEvent.name();
        Transaction transaction = addTransactionEvent.transaction();
        Agent agent = container.searchAgent(name);
        double newMontant = (transaction.getType().equals(TypeTransaction.ACHAT)) ? agent.getSolde()-transaction.getMontant() : agent.getSolde()+transaction.getMontant();
        agent.setSolde(newMontant);
        System.out.println("Solde  de "+name+" = "+newMontant);
    }
}
