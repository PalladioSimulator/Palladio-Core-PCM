package de.uka.ipd.sdq.sensorframework.entities.dao;

/**
 * Classes implementing this interface bundle the access to data access objects 
 * of one type (e.g. file data sources, memory datasources), i.e. one family 
 * (as describes in the AbstractFactory patterns). 
 * An IDAOFactory has five data access objects enclosed: <code>ExperimentDAO</code>, 
 * <code>StateDAO/code>, <code>MeasurementDAO/code>, <code>ExperimentRunDAO/code> 
 * and <code>SensorDAO/code>, and initialises them all on one type of access, 
 * i.e. file or memory.
 *   
 * @author ?
 * @documentedBy: Anne
 *
 */
public interface IDAOFactory {
	String getName();

	String getDescription();
	
	long getID();
	
	void finalizeAndClose();

	/** Returns the <code>Experiment</code> data access object or creates a new one, 
	 * if none was there before. Actually, this is rather a get method that might
	 * lazily create the <code>ExperimentDAO</code> when you first access it.*/
	de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO createExperimentDAO();

	/** Returns the <code>State</code> data access object or creates a new one, 
	 * if none was there before. Actually, this is rather a get method that might 
	 * lazily create the <code>StateDAO</code> when you first access it.*/
	de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO createStateDAO();

	/** Returns the <code>Measurement</code> data access object or creates a new one, 
	 * if none was there before. Actually, this is rather a get method that might 
	 * lazily create the <code>MeasurementDAO</code> when you first access it.*/
	de.uka.ipd.sdq.sensorframework.entities.dao.IMeasurementDAO createMeasurementDAO();

	/** Returns the <code>ExperimentRun</code> data access object or creates a new one, 
	 * if none was there before. Actually, this is rather a get method that might 
	 * lazily create the <code>ExperimentRunDAO</code> when you first access it.*/
	de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentRunDAO createExperimentRunDAO();

	/** Returns the <code>Sensor</code> data access object or creates a new one, 
	 * if none was there before. Actually, this is rather a get method that might 
	 * lazily create the <code>SensorDAO</code> when you first access it.*/
	de.uka.ipd.sdq.sensorframework.entities.dao.ISensorDAO createSensorDAO();

	void setID(long l);

	String getPersistendInfo();

	void reload();

	void store();

}
