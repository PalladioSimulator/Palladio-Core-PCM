package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import org.jfree.data.xy.XYSeries;

/**
 * Exports XYSeries of JFree (aka JFreeChart) origin.
 * 
 * @author unknown
 * 
 */
public interface ISeriesExporter {

	XYSeries getSeries();

}
