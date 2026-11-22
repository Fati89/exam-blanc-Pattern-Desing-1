package benakka.model;

import java.util.HashMap;

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
    public void addAgent(Agent agent){
        agents.put(agent.getName(), agent);
    }
    public void removeAgent(Agent agent){
        agents.remove(agent.getName());
    }
    public Agent searchAgent(String nom){
        return agents.get(nom);
    }

}
