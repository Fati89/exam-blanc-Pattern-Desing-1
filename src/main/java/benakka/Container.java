package benakka;

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
        agents.put(Agent.nom, Agent);
    }

}
