package de.uka.ipd.sdq.edp2;

/**
 * Interface for the access to any meta data in EDP2.
 * @author groenda
 */
public interface MetaDao extends Edp2Dao {
	
    /**
	 * Returns the factory for measurement DAOs in order to get access to the measurements. 
	 * @return The measurements DAO factory.
	 */
	public MeasurementsDaoFactory getMeasurementsDaoFactory();
	
}
