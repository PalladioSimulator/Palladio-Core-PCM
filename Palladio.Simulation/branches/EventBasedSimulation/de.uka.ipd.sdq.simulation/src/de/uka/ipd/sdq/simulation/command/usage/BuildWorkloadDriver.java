package de.uka.ipd.sdq.simulation.command.usage;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.Workload;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.exceptions.concrete.UnexpectedModelStructureException;
import de.uka.ipd.sdq.simulation.workload.ClosedWorkloadDriver;
import de.uka.ipd.sdq.simulation.workload.IWorkloadDriver;
import de.uka.ipd.sdq.simulation.workload.OpenWorkloadDriver;

public class BuildWorkloadDriver implements IPCMCommand<List<IWorkloadDriver>> {

    private EventSimModel model;

    public BuildWorkloadDriver(EventSimModel model) {
        this.model = model;
    }

    @Override
    public List<IWorkloadDriver> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        List<IWorkloadDriver> workloads = new ArrayList<IWorkloadDriver>();
        for (UsageScenario u : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            Workload w = u.getWorkload_UsageScenario();
            if (UsagemodelPackage.eINSTANCE.getOpenWorkload().isInstance(w)) {
                workloads.add(new OpenWorkloadDriver(model, (OpenWorkload) w));
            } else if (UsagemodelPackage.eINSTANCE.getClosedWorkload().isInstance(w)) {
                workloads.add(new ClosedWorkloadDriver(model, (ClosedWorkload) w));
            } else {
                throw new UnexpectedModelStructureException(
                        "Found a workload which is neither an OpenWorkload nor a ClosedWorkload.");
            }
        }
        return workloads;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
