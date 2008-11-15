/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;

/**
 * @author Snowball
 *
 */
public class DesmoJModel extends Model {

	private SimuComModel myModel;
	private Experiment experiment;

	public DesmoJModel(SimuComModel model) {
		super(null, model.getConfig().getNameExperimentRun(), false, false);
		this.myModel = model;
		this.experiment = new Experiment(this.getName());
		this.connectToExperiment(experiment);
		experiment.setShowProgressBar(false);
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.Model#description()
	 */
	@Override
	public String description() {
		return this.getName();
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.Model#doInitialSchedules()
	 */
	@Override
	public void doInitialSchedules() {
		myModel.doInitialSchedules();
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.Model#init()
	 */
	@Override
	public void init() {
		//Nothing to do here
	}
	
	public Experiment getExperiment(){
		return experiment;
	}

}
