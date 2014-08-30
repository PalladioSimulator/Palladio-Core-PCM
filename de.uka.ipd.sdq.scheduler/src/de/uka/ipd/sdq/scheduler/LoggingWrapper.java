package de.uka.ipd.sdq.scheduler;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggingWrapper {

    public static final Logger LOGGER = Logger.getLogger("Scheduler");

    public static void activate() {
        LOGGER.setLevel(Level.ALL);
    }

    public static void deactivate() {
        LOGGER.setLevel(Level.OFF);
    }

    public static void log(String string) {
        // LOGGER.info(MathTools.round(SchedulingFactory.getUsedSimulator().time(), 0.01) + " " +
        // string);
    }

    static {
        activate();
    }

}
