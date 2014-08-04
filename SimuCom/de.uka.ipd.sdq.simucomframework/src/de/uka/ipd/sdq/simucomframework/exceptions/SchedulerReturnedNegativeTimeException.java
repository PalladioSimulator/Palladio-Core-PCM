package de.uka.ipd.sdq.simucomframework.exceptions;

public class SchedulerReturnedNegativeTimeException extends RuntimeException {

    /**
	 * 
	 */
    private static final long serialVersionUID = -3047357222647201956L;

    public SchedulerReturnedNegativeTimeException() {
        super(
                "The scheduling alogrithm violated the constraint that the time for the next event to happen has to be positive all the time! Please file a bugreport at the PCM homepage!");
    }
}
