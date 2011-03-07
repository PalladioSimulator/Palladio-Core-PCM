package de.uka.ipd.sdq.simulation.debug;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.listener.ISeffTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.rdseff.SeffTraversal;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class DebugSeffTraversalListener implements ISeffTraversalListener {

    private static final Logger logger = Logger.getLogger(DebugSeffTraversalListener.class);

    @Override
    public void after(final AbstractAction action, final Request who) {
        logger.debug("AFTER " + PCMEntityHelper.toString(action));
    }

    @Override
    public void before(final AbstractAction action, final Request who) {
        logger.debug("BEFORE " + PCMEntityHelper.toString(action));
    }

    public static void install() {
        SeffTraversal.addTraversalListener(new DebugSeffTraversalListener());
    }

}
