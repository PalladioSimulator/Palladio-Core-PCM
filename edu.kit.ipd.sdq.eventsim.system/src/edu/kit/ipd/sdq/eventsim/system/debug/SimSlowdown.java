package edu.kit.ipd.sdq.eventsim.system.debug;

import org.palladiosimulator.pcm.seff.AbstractAction;

import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

public class SimSlowdown implements ISeffTraversalListener {

    private static final int SLEEP_TIME = 5000;

    private String id;
    private boolean active;

    public SimSlowdown(String id) {
        this.id = id;
    }

    @Override
    public void before(AbstractAction action, Request entity, RequestState state) {
        if (!active) {
            if (action.getId().equals(id)) {
                active = true;
            }
        } else {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void after(AbstractAction action, Request entity, RequestState state) {
        if (active) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (action.getId().equals(this.id)) {
                active = false;
            }
        }

    }

    public static void install(String id, SeffInterpreterConfiguration interpreterConfig) {
        interpreterConfig.addTraversalListener(new SimSlowdown(id));
    }

}
