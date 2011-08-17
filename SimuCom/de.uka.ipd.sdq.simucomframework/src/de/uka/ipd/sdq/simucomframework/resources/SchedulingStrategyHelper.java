package de.uka.ipd.sdq.simucomframework.resources;

/**
 * Provides helper methods for {@link SchedulingStrategy}. 
 * 
 * @author pmerkle
 *
 */
public class SchedulingStrategyHelper {

	/**
	 * Returns whether the passed <code>strategy</code> is intended to be used
	 * with EXACT schedulers or ABSTRACT schedulers.
	 * 
	 * @param strategy
	 * @return true, if the strategy is for EXACT schedulers; false, if the the
	 *         strategy is for ABSTRACT schedulers.
	 */
	public static boolean isExactSchedulingStrategy(SchedulingStrategy strategy) {
		switch (strategy) {
		case DELAY:
		case FCFS:
		case PROCESSOR_SHARING:
		case GINPEX_DISK:
			return false;
		case LINUX_2_6_CFS:
		case LINUX_2_6_O1:
		case SPECIAL_LINUXO1:
		case SPECIAL_WINDOWS:
		case WINDOWS_7:
		case WINDOWS_SERVER_2003:
		case WINDOWS_VISTA:
		case WINDOWS_XP:
			return true;
		default:
			throw new IllegalArgumentException(
					"It could not be determinded whether the strategy "
							+ strategy.name() + " is EXACT or ABSTRACT.");
		}
	}

}
