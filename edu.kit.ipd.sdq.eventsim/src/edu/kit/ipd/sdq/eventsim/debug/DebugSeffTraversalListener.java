package edu.kit.ipd.sdq.eventsim.debug;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This listener prints a debug message whenever an {@link AbstractAction} is about to be traversed
 * or when an action has been traversed completely. Call {@code install()} to activate this
 * listener.
 * <p>
 * Notice: This listener does only apply to actions contained in a RD-SEFF.
 * 
 * @author Philipp Merkle
 * 
 */
public class DebugSeffTraversalListener implements ISeffTraversalListener {

    private static final Logger logger = Logger.getLogger(DebugSeffTraversalListener.class);
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void after(final AbstractAction action, final Request who, RequestState state) {
    	if(logger.isDebugEnabled())
    		logger.debug("AFTER " + PCMEntityHelper.toString(action) + "(Request: " + who + ")");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void before(final AbstractAction action, final Request who, RequestState state) {
    	if(logger.isDebugEnabled())
    		logger.debug("BEFORE " + PCMEntityHelper.toString(action) + "(Request: " + who + ")");
    }

    /**
     * Installs a {@link DebugSeffTraversalListener} at {@link SeffBehaviourInterpreter}.
     */
    public static void install(SeffInterpreterConfiguration interpreterConfiguration) {
        interpreterConfiguration.addTraversalListener(new DebugSeffTraversalListener());
    }

}
