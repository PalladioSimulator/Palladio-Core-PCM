package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import org.rosuda.JRI.REXP;

import de.uka.ipd.sdq.sensorframework.entities.Sensor;

public class SummaryReportItem extends StatisticsReportItem {

	public SummaryReportItem(String sensorName, Sensor sensor){
		super("","Summary of Sensor " +  sensor.getSensorName() );
		rCommands = outlierRemovalCommands(sensorName, sensorName+"_");
		rCommands = "summary(" + sensorName + "_ )"; 
	}
	
	@Override
	public String getResult() {
		StringBuilder result = new StringBuilder();
		result.append("<br/> <pre> <code>");
		result.append("   Min. 1st Qu.  Median    Mean 3rd Qu.    Max.");
		result.append("<br/>");
		if (statisticalValue.rtype == REXP.REALSXP){
			double[] da = statisticalValue.asDoubleArray();
			for (int i=0; i<6; i++){
				String value = "" + ((double) Math.round(da[i] * 10.0)) / 10.0;
				int fill = 8 - value.length();
				for (int j = 0; j < fill; j++){
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
