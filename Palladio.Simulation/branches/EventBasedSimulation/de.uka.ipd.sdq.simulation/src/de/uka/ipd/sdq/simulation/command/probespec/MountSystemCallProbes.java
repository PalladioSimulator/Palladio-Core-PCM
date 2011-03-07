package de.uka.ipd.sdq.simulation.command.probespec;

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
import de.uka.ipd.sdq.simulation.command.usage.FindEntryLevelSystemCallsOfScenario;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;

public class MountSystemCallProbes implements IPCMCommand<Void> {

    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (UsageScenario s : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            List<EntryLevelSystemCall> calls = executor.execute(new FindEntryLevelSystemCallsOfScenario(s));
            for (final EntryLevelSystemCall c : calls) {
                UsageBehaviorTraversal.addTraversalListener(c, new IUsageTraversalListener() {

                    @Override
                    public void before(AbstractUserAction action, User u) {
                        // Take current time
                        ProbeSpecContext.instance().getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(ProbeSpecContext.instance()
                                        .getProbeStrategyRegistry().getProbeStrategy(ProbeType.CURRENT_TIME, null)
                                        .takeSample(c.getId(), u.getModel().getSimulationControl()), u
                                        .getRequestContext(), c.getId(), ProbeSpecContext.instance().obtainProbeSetId(
                                        c.getId() + "_start")));
                    }

                    @Override
                    public void after(AbstractUserAction action, User u) {
                        ProbeSpecContext.instance().getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(ProbeSpecContext.instance()
                                        .getProbeStrategyRegistry().getProbeStrategy(ProbeType.CURRENT_TIME, null)
                                        .takeSample(c.getId(), u.getModel().getSimulationControl()), u
                                        .getRequestContext(), c.getId(), ProbeSpecContext.instance().obtainProbeSetId(
                                        c.getId() + "_end")));
                    }
                });
            }
        }
        return null;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
