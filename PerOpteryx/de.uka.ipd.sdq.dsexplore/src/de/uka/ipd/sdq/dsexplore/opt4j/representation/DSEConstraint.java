package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.apache.log4j.Logger;
import org.opt4j.core.Objective;
import org.opt4j.core.Value;

public class DSEConstraint {
	
	private Value<Double> lowerLimit;
	private Value<Double> upperLimit;
	private Objective objective;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	
	public DSEConstraint(Value<Double> lowerLimit, Value<Double> upperLimit,
			Objective objective) {
		super();
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.objective = objective;
	}
	
	public boolean isValid(Value<Double> value){
		if ((lowerLimit == null || lowerLimit.compareTo((Value<Double>) value)<=0)
				&&
			(upperLimit == null || upperLimit.compareTo((Value<Double>) value)>=0)){
			return true;
		} else {
			logger.info("Objective "+objective.getName()+" does not fulfill the requirements with a value of "+value.toString());
			return false;
		}
	}

}
