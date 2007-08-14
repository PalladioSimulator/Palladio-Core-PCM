package de.uka.ipd.sdq.sensorframework.entities.dao;

public interface IDAOFactory {
	String getName();

	String getDescription();
	
	long getID();
	
	void finalizeAndClose();

	de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO createExperimentDAO();

	de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO createStateDAO();

	de.uka.ipd.sdq.sensorframework.entities.dao.IMeasurementDAO createMeasurementDAO();

	de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentRunDAO createExperimentRunDAO();

	de.uka.ipd.sdq.sensorframework.entities.dao.ISensorDAO createSensorDAO();

	void setID(long l);

	String getPersistendInfo();

}
