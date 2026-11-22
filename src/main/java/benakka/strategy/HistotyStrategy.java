package benakka.strategy;

import benakka.event.AddTransactionEvent;
import benakka.model.Agent;
import benakka.model.Container;
import benakka.model.Transaction;

public class HistotyStrategy implements Strategy{
    @Override
    public void update(AddTransactionEvent addTransactionEvent) {
        Container container = Container.getInstance();
        String name = addTransactionEvent.name();
        Transaction transaction = addTransactionEvent.transaction();
        Agent agent = container.searchAgent(name);
        agent.setHistory(agent.getHistory()+transaction.getType()+" "+transaction.getMontant()+"\n");
        System.out.println("Historique de "+name+" : "+agent.getHistory());
    }
}
