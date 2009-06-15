package de.uka.ipd.sdq.dsexplore.analysis.lqnsolver;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

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
	
}
