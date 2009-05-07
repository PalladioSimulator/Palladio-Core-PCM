package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import org.rosuda.JRI.REXP;

/**Summarizes the values stored in a R variable by displaying
 * some statistical measures.
 * These measures are Minimum, 1st Quartile, Median, Mean, 
 * 3rd Quartile, Maximum.
 * @author groenda
 */
public class SummaryReportItem extends RCommandRReportItem {

	/**Initialized a new report item that summarizes the
	 * values stored in a R variable.
	 * @param rVariableName Name of the R variable in which the data is stored.
	 * @param displayName Name displayed when referring to the variable.
	 */
	public SummaryReportItem(final String rVariableName, 
			final String displayName) {
		super("summary(" + rVariableName + ")", 
				"Summary of Sensor " +  displayName);
	}
	
	/** {@inheritDoc}
	 */
	@Override
	public String getText() {
		StringBuilder result = new StringBuilder();
		
		result.append("<br/> <pre> <code>");
		result.append("   Min. 1st Qu.  Median    Mean 3rd Qu.    Max.");
		result.append("<br/>");
		
		if (returnedValue.rtype == REXP.REALSXP) {
			double[] doubleArray = returnedValue.asDoubleArray();
			for (int measureNumber = 0; measureNumber < 6; measureNumber++) {
				// Round to first number after colon
				String value = "" 
					+ ((double) Math.round(doubleArray[measureNumber] * 10.0)) / 10.0;
				int fill = 8 - value.length();
				for (int j = 0; j < fill; j++) {
					result.append(' ');
				}
				result.append(value);
			}
			result.append("</code> </pre>");
			return result.toString();
		}
		
		return "N/A";
	}
	
}
