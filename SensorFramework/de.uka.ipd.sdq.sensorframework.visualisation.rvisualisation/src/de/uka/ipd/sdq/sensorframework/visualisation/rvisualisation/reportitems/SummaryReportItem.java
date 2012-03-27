package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import java.text.DecimalFormat;

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
		
		result.append("<br/> <table border='1' cellspacing='3'><tr align='center'>");
		result.append("<th>Min.</th><th> 1st Quart.</th><th>Median</th><th>Mean</th><th>3rd Quart.</th><th>Max.</th></tr>");
		result.append("</tr><tr align='center'>");
		
		if (returnedValue.rtype == REXP.REALSXP) {
			double[] doubleArray = returnedValue.asDoubleArray();
			DecimalFormat df= new DecimalFormat();
			for (int measureNumber = 0; measureNumber < 6; measureNumber++) {
				// fix the number of used decimals using different formatters
				df.applyPattern("###.0");
				if (Math.abs(doubleArray[measureNumber])< 0.2) df.applyPattern("#0.0#E0#");
				if (Math.abs(doubleArray[measureNumber])>999) df.applyPattern("#0.0#E0#");
				df.format(doubleArray[measureNumber]);
				result.append("<td>"+df.format(doubleArray[measureNumber])+"</td>");
			}
			result.append("</tr></table>");
			return result.toString();
		}
		
		return "N/A";
	}
	
}
