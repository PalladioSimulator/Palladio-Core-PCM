package de.uka.ipd.sdq.simulation.debug;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.interpreter.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.interpreter.state.UserState;
import de.uka.ipd.sdq.simulation.interpreter.usage.UsageBehaviourInterpreter;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

/**
 * This listener prints a debug message whenever an {@link AbstractUserAction} is about to be
 * traversed or when an action has been traversed completely. Call {@code install()} to activate
 * this listener.
 * <p>
 * Notice: This listener does only apply to actions contained in a usage scenario.
 * 
 * @author Philipp Merkle
 * 
 */
public class DebugUsageTraversalListener implements IUsageTraversalListener {

    private static final Logger logger = Logger.getLogger(DebugUsageTraversalListener.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void after(final AbstractUserAction action, final User who, UserState state) {
        logger.debug("AFTER " + PCMEntityHelper.toString(action) + "(User: " + who + ")");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void before(final AbstractUserAction action, final User who, UserState state) {
        logger.debug("BEFORE " + PCMEntityHelper.toString(action) + "(User: " + who + ")");
    }

    /**
     * Installs a {@link DebugUsageTraversalListener} at {@link UsageBehaviourInterpreter}.
     */
    public static void install() {
        UsageBehaviourInterpreter.addTraversalListener(new DebugUsageTraversalListener());
    }

}
