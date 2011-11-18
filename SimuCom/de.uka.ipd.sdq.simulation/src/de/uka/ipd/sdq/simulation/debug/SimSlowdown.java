package de.uka.ipd.sdq.simulation.debug;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.interpreter.listener.ISeffTraversalListener;
import de.uka.ipd.sdq.simulation.interpreter.seff.SeffBehaviourInterpreter;
import de.uka.ipd.sdq.simulation.interpreter.state.RequestState;

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

    public static void install(String id) {
        SeffBehaviourInterpreter.addTraversalListener(new SimSlowdown(id));
    }

}
