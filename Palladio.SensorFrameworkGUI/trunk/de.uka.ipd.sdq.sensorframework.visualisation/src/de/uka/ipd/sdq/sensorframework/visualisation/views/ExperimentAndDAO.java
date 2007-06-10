package de.uka.ipd.sdq.sensorframework.visualisation.views;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

public class ExperimentAndDAO {
	private IDAOFactory datasource;
	private Experiment experiment;
	public ExperimentAndDAO(IDAOFactory datasource, Experiment experiment) {
		super();
		this.datasource = datasource;
		this.experiment = experiment;
	}
	public IDAOFactory getDatasource() {
		return datasource;
	}
	public Experiment getExperiment() {
		return experiment;
	}
}
