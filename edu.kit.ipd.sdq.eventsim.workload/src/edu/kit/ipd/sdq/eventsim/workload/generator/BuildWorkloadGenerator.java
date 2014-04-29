package edu.kit.ipd.sdq.eventsim.workload.generator;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.Workload;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.UnexpectedModelStructureException;
import edu.kit.ipd.sdq.eventsim.workload.EventSimWorkloadModel;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * This command creates and returns a list of all {@link IWorkloadGenerator}s for a PCM usage model.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildWorkloadGenerator implements IPCMCommand<List<IWorkloadGenerator>> {

    private final EventSimWorkloadModel model;

    /**
     * Constructs a new command that creates all workload generators.
     * 
     * @param model
     *            the simulation model
     */
    public BuildWorkloadGenerator(final EventSimWorkloadModel model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<IWorkloadGenerator> execute(final IPCMModel pcm, final ICommandExecutor<IPCMModel> executor) {
        final List<IWorkloadGenerator> workloads = new ArrayList<IWorkloadGenerator>();
        for (final UsageScenario u : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            final Workload w = u.getWorkload_UsageScenario();
            if (UsagemodelPackage.eINSTANCE.getOpenWorkload().isInstance(w)) {
                workloads.add(new OpenWorkloadGenerator(this.model, (OpenWorkload) w));
            } else if (UsagemodelPackage.eINSTANCE.getClosedWorkload().isInstance(w)) {
                workloads.add(new ClosedWorkloadGenerator(this.model, (ClosedWorkload) w));
            } else {
                throw new UnexpectedModelStructureException("Found a workload which is neither an OpenWorkload nor a ClosedWorkload.");
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
