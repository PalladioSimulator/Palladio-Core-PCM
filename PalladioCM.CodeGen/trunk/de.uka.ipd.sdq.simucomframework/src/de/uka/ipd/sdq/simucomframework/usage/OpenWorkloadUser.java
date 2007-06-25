package de.uka.ipd.sdq.simucomframework.usage;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class OpenWorkloadUser extends SimProcess implements IUser {

	private IScenarioRunner scenarioRunner;
	private static Logger logger = 
		Logger.getLogger(OpenWorkloadUser.class.getName());

	public OpenWorkloadUser(Model owner, String name, IScenarioRunner scenarioRunner) {
		super(owner, name, false);
		this.scenarioRunner = scenarioRunner;
	}

	@Override
	public void lifeCycle() {
		try {
			logger.debug(this.getName()+" started! I'm alive!!!");
			scenarioRunner(this);
			logger.debug(this.getName()+" done! I'm dying!!!");
		} catch (SimFinishedException ex) {
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			this.getModel().getExperiment().stop();
			e.printStackTrace(pw);
			((SimuComModel)getModel()).setStatus(SimuComStatus.ERROR,
					e.getMessage()+"\n"+sw.toString());
		}
	}

	public void scenarioRunner(SimProcess thread) {
		this.scenarioRunner.scenarioRunner(thread);
	}

	public void startUserLife() {
		this.activate(SimTime.NOW);
	}
}
