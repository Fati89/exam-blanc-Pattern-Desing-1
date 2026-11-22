package benakka.adapter;

import benakka.model.Agent;

import java.util.List;

public class VgaImpl implements Vga {
    @Override
    public void afficherAgents(List<Agent> agents) {
        System.out.println("Affichage vga");
        for(Agent a:agents){
            System.out.println("VGA : "+a.toString());
        }
    }
}
