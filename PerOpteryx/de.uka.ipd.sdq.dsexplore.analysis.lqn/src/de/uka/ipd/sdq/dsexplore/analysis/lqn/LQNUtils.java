package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
import LqnCore.OutputResultType;
import LqnCore.TaskType;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;

/**
 * Provides utility methods which are useful when working with LQN.
 * 
 * @author pmerkle
 * 
 */
public class LQNUtils {

	/**
	 * Converts the given String in LQN specific scientific format (e.g.
	 * 1.0E-003) to the corresponding double value.
	 * 
	 * @param toConvert
	 * @return
	 * @throws AnalysisFailedException
	 */
	public static double convertStringToDouble(String toConvert) throws ParseException {
		double ret;

		toConvert = toConvert.replaceAll("e", "E");
		toConvert = toConvert.replaceAll("\\+", "");
		DecimalFormat format = new DecimalFormat("0.0E000",
				DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		ret = format.parse(toConvert).doubleValue();

		return ret;
	}
	
	public static double getResponseTimeOfSubActivities(TaskType task) throws ParseException {
		// We add all result service times of the usage scenario to compute
		// the response time
		// TODO: check whether this works correctly if the usage scenario
		// contains branches
		double time = 0;
		EList<ActivityDefType> activities = task.getTaskActivities()
				.getActivity();
		for (ActivityDefType activity : activities) {
			EList<OutputResultType> results = activity.getResultActivity();
			for (OutputResultType outputResultType : results) {

				time += LQNUtils
						.convertStringToDouble((String) outputResultType
								.getServiceTime());
			}

		}
		return time;
	}
	
	
}
