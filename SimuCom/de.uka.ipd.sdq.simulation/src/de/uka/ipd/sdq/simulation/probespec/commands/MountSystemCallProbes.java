package de.uka.ipd.sdq.simulation.probespec.commands;

import java.util.List;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.command.usage.FindSystemCallsOfScenario;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.listener.ITraversalListener;
import de.uka.ipd.sdq.simulation.traversal.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;

/**
 * This command registers a {@link ITraversalListener} before and after each
 * {@link EntryLevelSystemCall}. The listeners take a {@link ProbeType#CURRENT_TIME} sample before
 * and after a call in order to enable the calculation of the call's response time.
 * 
 * @author Philipp Merkle
 * 
 */
public class MountSystemCallProbes implements IPCMCommand<Void> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (UsageScenario s : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            List<EntryLevelSystemCall> calls = executor.execute(new FindSystemCallsOfScenario(s));
            for (final EntryLevelSystemCall c : calls) {
                UsageBehaviorTraversal.addTraversalListener(c, new IUsageTraversalListener() {

                    @Override
                    public void before(AbstractUserAction action, User u, TraversalState<AbstractUserAction> state) {
                        // take current time sample
                        ProbeSpecContext probeSpecContext = u.getModel().getProbeSpecContext();
                        probeSpecContext.getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(c.getId(),
                                                u.getModel().getSimulationControl()), u.getRequestContext(), c.getId(),
                                        probeSpecContext.obtainProbeSetId(c.getId() + "_start")));
                    }

                    @Override
                    public void after(AbstractUserAction action, User u, TraversalState<AbstractUserAction> state) {
                        // take current time sample
                        ProbeSpecContext probeSpecContext = u.getModel().getProbeSpecContext();
                        probeSpecContext.getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(c.getId(),
                                                u.getModel().getSimulationControl()), u.getRequestContext(), c.getId(),
                                        probeSpecContext.obtainProbeSetId(c.getId() + "_end")));
                    }
                });
            }
        }

        // this command is not supposed to return a value
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
