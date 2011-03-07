package de.uka.ipd.sdq.simulation.command.probespec;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.command.usage.FindStartOfScenario;
import de.uka.ipd.sdq.simulation.command.usage.FindStopOfScenario;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviorTraversal;

public class MountUsageScenarioProbes implements IPCMCommand<Void> {

    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (UsageScenario s : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            final Start start = executor.execute(new FindStartOfScenario(s));
            final Stop stop = executor.execute(new FindStopOfScenario(s));
            UsageBehaviorTraversal.addTraversalListener(start, new IUsageTraversalListener() {

                @Override
                public void before(AbstractUserAction action, User u) {
                    // Take current time
                    ProbeSpecContext.instance().getSampleBlackboard().addSample(
                            ProbeSpecUtils.buildProbeSetSample(ProbeSpecContext.instance().getProbeStrategyRegistry()
                                    .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(start.getId(),
                                            u.getModel().getSimulationControl()), u.getRequestContext(), start.getId(),
                                    ProbeSpecContext.instance().obtainProbeSetId(
                                            start.getScenarioBehaviour_AbstractUserAction()
                                                    .getUsageScenario_SenarioBehaviour().getId()
                                                    + "_start")));
                }

                @Override
                public void after(AbstractUserAction action, User u) {
                    // nothing to do
                }
            });
            UsageBehaviorTraversal.addTraversalListener(stop, new IUsageTraversalListener() {

                @Override
                public void after(AbstractUserAction action, User u) {
                    // Take current time
                    ProbeSpecContext.instance().getSampleBlackboard().addSample(
                            ProbeSpecUtils.buildProbeSetSample(ProbeSpecContext.instance().getProbeStrategyRegistry()
                                    .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(start.getId(),
                                            u.getModel().getSimulationControl()), u.getRequestContext(), start.getId(),
                                    ProbeSpecContext.instance().obtainProbeSetId(
                                            start.getScenarioBehaviour_AbstractUserAction()
                                                    .getUsageScenario_SenarioBehaviour().getId()
                                                    + "_end")));
                }

                @Override
                public void before(AbstractUserAction action, User who) {
                    // nothing to do

                }
            });
        }
        return null;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
