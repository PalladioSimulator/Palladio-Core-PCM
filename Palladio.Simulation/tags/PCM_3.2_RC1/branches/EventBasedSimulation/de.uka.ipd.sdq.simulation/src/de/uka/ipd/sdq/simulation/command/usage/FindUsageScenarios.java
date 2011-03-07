package de.uka.ipd.sdq.simulation.command.usage;

import java.util.List;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;

public class FindUsageScenarios implements IPCMCommand<List<UsageScenario>> {

    @Override
    public List<UsageScenario> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        return pcm.getUsageModel().getUsageScenario_UsageModel();
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
