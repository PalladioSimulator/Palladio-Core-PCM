package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**Abstract class for R reports.
 * The interface of this class is used by the viewers to access the reports.
 * @author groenda
 */
public abstract class RReport {

	/**Identifier for subsets of data elements that belong to a single
	 * time series element.
	 * @see TimeSeries
	 * @author groenda
	 */
	public enum TimeseriesData {
		/** The timespan value of the time series data point. */
		TIMESPAN,
		/** The eventtime value of the time series data point. */
		EVENTTIME,
		/** Both, the timespan and eventtime, of the time series data point. */
		BOTH
	}
	
	/**Template method for subclasses to implement. Subclasses can create
	 * IReportItems from the given <code>SensorAndMeasurements</code>. They 
	 * can use the <code>storeMeasurementsInRVector(SensorAndMeasurements, int)
	 * </code> to transfer data to R.
	 * 
	 * @param measurements List of the measurements for a sensor.
	 * @param rConnection connection to the R engine.
	 * @return List of Items.
	 */
	public abstract ArrayList<IReportItem> prepareReportItems(
			Collection<SensorAndMeasurements> measurements, 
			RConnection rConnection);
	
}
