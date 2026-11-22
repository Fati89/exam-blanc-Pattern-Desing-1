package benakka.adapter;

import benakka.model.Agent;
import benakka.model.Container;

import java.util.List;

public class HdmiAdapter implements Hdmi{
    Vga vga;

    public void setVga(Vga vga) {
        this.vga = vga;
    }

    @Override
    public void afficher() {
        System.out.println("adaptaion a affichage hdmi");
        Container container = Container.getInstance();
        List<Agent> agents = container.getAgents().values().stream().toList();
        vga.afficherAgents(agents);
    }
}
