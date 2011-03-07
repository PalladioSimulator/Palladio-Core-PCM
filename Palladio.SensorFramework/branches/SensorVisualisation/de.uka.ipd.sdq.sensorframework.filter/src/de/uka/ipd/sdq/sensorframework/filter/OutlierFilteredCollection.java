package de.uka.ipd.sdq.sensorframework.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

/**
 * Removes the top outliers of a collection of measurements. 
 * Works only for TimeSpanMeasurements, where the time span durations are used for outlier identification. 
 * The configuration parameter is the share of outliers, i.e. it must be between 0 and 1.  
 * @author Steffen Becker or Roman Andrej or Ihssane el-Oudhigiri
 * documented by Michael Kuperberg
 *
 */
public class OutlierFilteredCollection extends AbstractMeasurementsCollection {

	/** The configurations parameter.
	 * the share of the outliers (i.e. must be >0 and <=1). 
	 */
	private double parameter=0.0D;

	/** The logger used by this class. */
	private static Logger logger = 
		Logger.getLogger(OutlierFilteredCollection.class.getName());
	
	/**
	 * Initializes a new OutlierFilteredCollection with the given measurements and filter parameter.
	 * 
	 * @param originalMeasurements
	 *            The associated measurements.
	 * @param parameter The associated parameter
	 */
	public OutlierFilteredCollection(
			Collection<Measurement> originalMeasurements, double parameter) {
		super(originalMeasurements);
		//int cmpShareParameter = Double.compare(parameter,0);
		if(parameter<0){
			logger.error("Filter parameter less then 0: parameter left at default value of "+this.parameter);
		}else if(parameter>1){
			logger.error("Filter parameter larger then 1: parameter left at default value of "+this.parameter);
		}else if(Double.compare(Double.NaN, parameter)==0){
			logger.error("Filter parameter is NaN: parameter left at default value of "+this.parameter);
		}else{
			this.parameter = parameter;//TODO check this for plausibility!
		}
		//TODO call applyFilter right here, given that a collection is already passed? 
		//or "lazy filtering" means delay?
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void applyFilter(Collection<Measurement> filteredItemsList) {
		int outlierNumber = 0;
		outlierNumber = (int) (parameter * originalMeasurements.size());//TODO check that this is the right kind of rounding...
		ArrayList<TimeSpanMeasurement> sortedMeasurements;
		sortedMeasurements = (ArrayList<TimeSpanMeasurement>) new ArrayList<TimeSpanMeasurement>();
		for (Iterator<?> it = originalMeasurements.iterator(); it.hasNext();/*nothing*/){
			sortedMeasurements.add((TimeSpanMeasurement) it.next());
		}
		Collections.sort(sortedMeasurements,
				new Comparator<TimeSpanMeasurement>() {//extract this comparator? 

					public int compare(TimeSpanMeasurement o1,
							TimeSpanMeasurement o2) {
						return Double.compare(o1.getTimeSpan(), o2
								.getTimeSpan());
					}

				});
		for (int i = sortedMeasurements.size() - 1; 
				i >= sortedMeasurements.size()- outlierNumber; 
				i--) {
			filteredItemsList.add(sortedMeasurements.get(i));
		}
	}
}
