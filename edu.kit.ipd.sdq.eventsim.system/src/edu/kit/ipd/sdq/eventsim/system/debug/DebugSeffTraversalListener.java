package edu.kit.ipd.sdq.eventsim.system.debug;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This listener prints a debug message whenever an {@link AbstractAction} is about to be traversed or when an action
 * has been traversed completely.
 * <p>
 * Use the {@code install} method to activate this listener.
 * <p>
 * Notice: This listener does only apply to actions contained in a RD-SEFF.
 * 
 * @author Philipp Merkle
 * 
 */
public class DebugSeffTraversalListener implements ISeffTraversalListener {

	private static final Logger logger = Logger.getLogger(DebugSeffTraversalListener.class);

	private DebugSeffTraversalListener() {
		// private constructor to prevent instantiation by clients
	}

	/**
	 * Installs a {@link DebugSeffTraversalListener} at {@link SeffBehaviourInterpreter}.
	 */
	public static void install(SeffInterpreterConfiguration interpreterConfiguration) {
		interpreterConfiguration.addTraversalListener(new DebugSeffTraversalListener());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void before(final AbstractAction action, final Request who, RequestState state) {
		String simulationTimePrefix = simulationTimeString(who.getModel());
		logger.debug(simulationTimePrefix + "BEFORE " + PCMEntityHelper.toString(action) + "(Request: " + who + ")");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void after(final AbstractAction action, final Request who, RequestState state) {
		String simulationTimePrefix = simulationTimeString(who.getModel());
		logger.debug(simulationTimePrefix + "AFTER " + PCMEntityHelper.toString(action) + "(Request: " + who + ")");
	}

	private String simulationTimeString(ISimulationModel model) {
		double simTime = model.getSimulationControl().getCurrentSimulationTime();
		return "[t=" + simTime + "] ";
	}

}
