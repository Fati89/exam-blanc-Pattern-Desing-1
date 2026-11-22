package benakka.adapter;

import benakka.model.Agent;
import benakka.model.Container;

public class HdmiImpl implements Hdmi {
    @Override
    public void afficher() {
        System.out.println("affichage hdmi");
        Container container = Container.getInstance();
        for (Agent a:container.getAgents().values()){
            System.out.println(a.toString());
        }
    }
}
