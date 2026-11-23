package benakka;

import benakka.adapter.HdmiAdapter;
import benakka.adapter.HdmiImpl;
import benakka.adapter.Vga;
import benakka.adapter.VgaImpl;
import benakka.aspects.SecurityContext;
import benakka.enums.TypeTransaction;
import benakka.model.Agent;
import benakka.model.Container;
import benakka.model.Director;
import benakka.model.Transaction;
import benakka.strategy.HistotyStrategy;
import benakka.strategy.ScoringStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@ComponentScan(value = {"benakka"})
public class Main {
    static void main() {

        SecurityContext.authenticate("root","1234", new String[]{"ADMIN"});
        //ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Main.class);
        //Agent kiro=applicationContext.getBean(Agent.class);

        Agent kiro = new Agent("kiro");
        Agent claude = new Agent("claude");

        kiro.subscribe(claude);
        claude.subscribe(kiro);
        claude.setStrategy(new ScoringStrategy());

        Transaction transaction1 = Director.transactionBuilder()
                .id("#1k")
                .date(new Date())
                .montant(3000)
                .type(TypeTransaction.VENTE)
                .build();

        kiro.addTrasaction(transaction1);
        claude.addTrasaction(new Transaction("#1c", new Date(), 50000, TypeTransaction.VENTE));

        kiro.setStrategy(new HistotyStrategy());

        kiro.addTrasaction(new Transaction("#2k", new Date(), 2000, TypeTransaction.ACHAT));
        claude.addTrasaction(new Transaction("#2c", new Date(), 10000, TypeTransaction.ACHAT));


        Container container = Container.getInstance();
        Vga vga = new VgaImpl();
        HdmiAdapter hdmiAdapter = new HdmiAdapter();
        hdmiAdapter.setVga(vga);
        container.setHdmi(hdmiAdapter);
        container.afficher();

        System.out.println("\nMax transaction for kiro : "+kiro.getMaxTransaction());
    }
}
