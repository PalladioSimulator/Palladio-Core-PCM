package de.uka.ipd.sdq.sensorfactory.entities.dao;

public interface IDAOFactory {
	String getName();

	String getDescription();
	
	long getID();
	
	void finalizeAndClose();

	de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentDAO createExperimentDAO();

	de.uka.ipd.sdq.sensorfactory.entities.dao.IStateDAO createStateDAO();

	de.uka.ipd.sdq.sensorfactory.entities.dao.IMeasurementDAO createMeasurementDAO();

	de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentRunDAO createExperimentRunDAO();

	de.uka.ipd.sdq.sensorfactory.entities.dao.ISensorDAO createSensorDAO();

	void setID(int i);

	String getPersistendInfo();

}
