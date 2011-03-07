package de.uka.ipd.sdq.simulation.context;

import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class UsageContext extends Context {

    private static final long serialVersionUID = 8182771740093037331L;

    public UsageContext(EventSimModel model, TraversalState<?> state) {
        super(model, state);
        this.stack.createAndPushNewStackFrame();
        // TODO Auto-generated constructor stub
    }

}
