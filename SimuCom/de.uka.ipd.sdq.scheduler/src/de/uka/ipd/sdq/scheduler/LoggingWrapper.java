package de.uka.ipd.sdq.scheduler;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggingWrapper {

    public static Logger logger = Logger.getLogger("Scheduler");

    public static void activate() {
        logger.setLevel(Level.ALL);
    }

    public static void deactivate() {
        logger.setLevel(Level.OFF);
    }

    public static void log(String string) {
        // logger.info(MathTools.round(SchedulingFactory.getUsedSimulator().time(), 0.01) + " " +
        // string);
    }

    static {
        activate();
    }

}
