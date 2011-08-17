/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Comparator;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

/**
 * @author Michael Kuperberg
 *
 */
public class MeasurementsComparator implements Comparator<Measurement> {

	@Override
	public int compare(Measurement arg0, Measurement arg1) {
		if(arg0.getEventTime() < arg1.getEventTime()){
			return -1;
		}else if(arg0.getEventTime() > arg1.getEventTime()){
			return 1;
		}else{
			return(
					new Long(arg0.getMeasurementID()).compareTo(
							new Long(arg1.getMeasurementID())));
		}
	}

}
