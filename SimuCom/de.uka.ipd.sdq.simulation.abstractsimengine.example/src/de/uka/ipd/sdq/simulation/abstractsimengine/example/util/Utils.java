package de.uka.ipd.sdq.simulation.abstractsimengine.example.util;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;

public class Utils {

    private static Logger logger = Logger.getLogger(Utils.class);

    public static void log(AbstractSimEntityDelegator entity, String msg) {
        StringBuilder s = new StringBuilder();
        s.append("[" + entity.getName() + "] ");
        s.append("(t=" + entity.getModel().getSimulationControl().getCurrentSimulationTime() + ") ");
        s.append(msg);
        logger.info(s.toString());
    }

}
