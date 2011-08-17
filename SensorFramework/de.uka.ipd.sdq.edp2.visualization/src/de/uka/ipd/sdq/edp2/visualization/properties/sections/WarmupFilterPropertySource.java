package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import de.uka.ipd.sdq.edp2.visualization.filter.WarmupFilter;

/**
 * @author Dominik Ernst
 *
 */
public class WarmupFilterPropertySource {

	long droppedValuesAbs;
	double droppedValuesPercentage;
	
	public WarmupFilterPropertySource(WarmupFilter filter){
		this.droppedValuesAbs = filter.getDroppedValues();
		this.droppedValuesPercentage = filter.getDroppedValuesPercentage();
	}

	
	
}
