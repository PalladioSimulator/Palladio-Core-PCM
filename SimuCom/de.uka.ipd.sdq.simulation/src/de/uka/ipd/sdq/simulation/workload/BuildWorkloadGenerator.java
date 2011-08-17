package de.uka.ipd.sdq.simulation.workload;

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
import de.uka.ipd.sdq.simulation.exceptions.unchecked.UnexpectedModelStructureException;

/**
 * This command creates and returns a list of all {@link IWorkloadGenerator}s for a PCM usage model.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildWorkloadGenerator implements IPCMCommand<List<IWorkloadGenerator>> {

    private final EventSimModel model;

    /**
     * Constructs a new command that creates all workload generators.
     * 
     * @param model
     *            the simulation model
     */
    public BuildWorkloadGenerator(final EventSimModel model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<IWorkloadGenerator> execute(final PCMModel pcm, final ICommandExecutor<PCMModel> executor) {
        final List<IWorkloadGenerator> workloads = new ArrayList<IWorkloadGenerator>();
        for (final UsageScenario u : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            final Workload w = u.getWorkload_UsageScenario();
            if (UsagemodelPackage.eINSTANCE.getOpenWorkload().isInstance(w)) {
                workloads.add(new OpenWorkloadGenerator(this.model, (OpenWorkload) w));
            } else if (UsagemodelPackage.eINSTANCE.getClosedWorkload().isInstance(w)) {
                workloads.add(new ClosedWorkloadGenerator(this.model, (ClosedWorkload) w));
            } else {
                throw new UnexpectedModelStructureException(
                        "Found a workload which is neither an OpenWorkload nor a ClosedWorkload.");
            }
        }
        return workloads;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
