package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import org.jfree.data.xy.XYSeries;

public class XYSeriesPrinter {
	public static String xySeriesToString(XYSeries series){
		StringBuffer sb = new StringBuffer();
		if(series.getKey()!=null){
			sb.append("{"+series.getKey()+", ");
		}else{
			sb.append("{"+"<no key of XYSeries>, ");
		}
		if(series.getDescription()!=null){
			sb.append(series.getDescription()+": ");
		}else{
			sb.append("<no description of XYSeries>: ");
		}
		if(series.getItems()!=null){
			sb.append(/*Collections.*/series.getItems().toString());
		}else{
			
		}
		sb.append("}");
		return sb.toString();
	}
	
	public static void main(String[] args){
		XYSeries series = new XYSeries("TestSeries");
		series.add(1, 2);
		series.add(3, 4);
		String toString = xySeriesToString(series);
		System.out.println(series);//shows that toString is not defined for xySeries...
		System.out.println(toString);
	}
}
