package de.uka.ipd.sdq.simulation.debug;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class DebugUsageTraversalListener implements IUsageTraversalListener {

    private static final Logger logger = Logger.getLogger(DebugUsageTraversalListener.class);

    @Override
    public void after(final AbstractUserAction action, final User who) {
        logger.debug("AFTER " + PCMEntityHelper.toString(action));
    }

    @Override
    public void before(final AbstractUserAction action, final User who) {
        logger.debug("BEFORE " + PCMEntityHelper.toString(action));
    }

    public static void install() {
        UsageBehaviorTraversal.addTraversalListener(new DebugUsageTraversalListener());
    }

}
