package edu.kit.ipd.sdq.eventsim.workload.command.usage;

import java.util.List;

import org.palladiosimulator.pcm.usagemodel.UsageScenario;

import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

public class FindUsageScenarios implements IPCMCommand<List<UsageScenario>> {

	@Override
	public List<UsageScenario> execute(IPCMModel model, ICommandExecutor<IPCMModel> executor) {
		return model.getUsageModel().getUsageScenario_UsageModel();
	}

	@Override
	public boolean cachable() {
		return false;
	}

}
