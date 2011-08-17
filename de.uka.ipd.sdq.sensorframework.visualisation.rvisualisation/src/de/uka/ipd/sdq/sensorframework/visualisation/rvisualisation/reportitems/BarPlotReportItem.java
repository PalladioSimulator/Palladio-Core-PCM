package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * This class plots its inputs as a BarChart.
 * @author toms
 *
 */
public class BarPlotReportItem extends AbstractPlotReportItem {

	/*
	 * Key = Label 
	 * Value = Occurrences
	 */
	HashMap<String, Integer> values = new HashMap<String, Integer>();

	public BarPlotReportItem(String title) {
		super(title);
	}

	@Override
	protected String generatePlotCommand() {
		Set<String> labels = getValues().keySet();
		Collection<Integer> occurrences = getValues().values();
		String rCommand="barplot(c(";
		for (int value : occurrences) {
			rCommand += value + ",";
		}
		rCommand = rCommand.substring(0, rCommand.length()-1);
		rCommand += ") , names.arg=c(";
		for (int i = 0; i<labels.size();i++) {
			rCommand += "\"" + (i+1) + "\""  +",";
		}
		rCommand = rCommand.substring(0, rCommand.length()-1);
		rCommand += ")";			
		rCommand += ", plot=TRUE) \n";
		return rCommand;
	}

	public HashMap<String, Integer> getValues() {
		return values;
	}

	public void setValues(HashMap<String, Integer> values) {
		this.values = values;
	}

}
