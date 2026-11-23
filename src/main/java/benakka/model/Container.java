package benakka.model;

import benakka.adapter.Hdmi;
import benakka.adapter.Vga;
import benakka.aspects.Log;

import java.util.HashMap;
import java.util.List;

public class Container {
    // ------------------ SINGLOTTON -------------------------
    private static final Container container;
    static {
        container=new Container();
    }
    private Container() {}
    public static Container getInstance(){
        return container;
    }
    // ------------------ SINGLOTTON -------------------------

    HashMap<String, Agent> agents = new HashMap<>();
    Hdmi hdmi;

    public void setHdmi(Hdmi hdmi) {
        this.hdmi = hdmi;
    }

    public void addAgent(Agent agent){
        agents.put(agent.getName(), agent);
    }
    public void removeAgent(Agent agent){
        agents.remove(agent.getName());
    }
    public Agent searchAgent(String nom){
        return agents.get(nom);
    }

    public HashMap<String, Agent> getAgents() {
        return agents;
    }

    public void afficher(){
        hdmi.afficher();
    }

}
