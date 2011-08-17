package de.uka.ipd.sdq.pcm.pcm2taskmodel.transformation;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.pcm2taskmodel.runconfig.PCM2TaskModelWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcm.taskmodel.TaskList;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelFactory;
import de.uka.ipd.sdq.pcm.taskmodel.impl.taskmodelFactoryImpl;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.transformations.EMFHelper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.Pcm2LqnStrategy;

public class Pcm2TaskmodelStrategy implements SolverStrategy {
	
	TaskList taskModel = null;
	
	private static Logger logger = Logger.getLogger(Pcm2TaskmodelStrategy.class
			.getName());

	public Pcm2TaskmodelStrategy(PCM2TaskModelWorkflowRunConfiguration config, PCMInstance pcmInstance) {
		taskModel = taskmodelFactory.eINSTANCE.createTaskList();
	}

	@Override
	public void loadTransformedModel(String fileName) {
	}

	@Override
	public void solve() {
		logger.warn("No solution available for task model");

	}

	@Override
	public void storeTransformedModel(String fileName) {
		EMFHelper.saveToXMIFile(taskModel, fileName);
	}

	@Override
	public void transform(PCMInstance pcmInstance) {
		
		Pcm2TaskmodelUsagemodelSwitch usageModelSwitch = new Pcm2TaskmodelUsagemodelSwitch(taskModel, new ContextWrapper(pcmInstance));
		
		usageModelSwitch.doSwitch(pcmInstance.getUsageModel());

	}

}
