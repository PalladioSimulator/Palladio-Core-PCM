package de.uka.ipd.sdq.simulation.probespec.commands;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.command.usage.FindActionInUsageBehaviour;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.listener.ITraversalListener;
import de.uka.ipd.sdq.simulation.traversal.listener.IUsageTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.state.UserState;
import de.uka.ipd.sdq.simulation.traversal.usage.UsageBehaviourInterpreter;

/**
 * This command registers a {@link ITraversalListener} at the start and at the stop action of a
 * {@link UsageScenario}. The listeners take a {@link ProbeType#CURRENT_TIME} sample in order to
 * enable the calculation of the usage scenario's response time.
 * 
 * @author Philipp Merkle
 * 
 */
public class MountUsageScenarioProbes implements IPCMCommand<Void> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (UsageScenario s : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            ScenarioBehaviour behaviour = s.getScenarioBehaviour_UsageScenario();
            final Start start = executor.execute(new FindActionInUsageBehaviour<Start>(behaviour, Start.class));
            final Stop stop = executor.execute(new FindActionInUsageBehaviour<Stop>(behaviour, Stop.class));

            // add a traversal listener to the usage scenario's start action
            UsageBehaviourInterpreter.addTraversalListener(start, new IUsageTraversalListener() {

                @Override
                public void before(AbstractUserAction action, User u, UserState state) {
                    // take current time sample
                    ProbeSpecContext probeSpecContext = u.getModel().getProbeSpecContext();
                    probeSpecContext.getSampleBlackboard().addSample(
                            ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                    .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(start.getId(),
                                            u.getModel().getSimulationControl()), u.getRequestContext(), start.getId(),
                                    probeSpecContext.obtainProbeSetId(start.getScenarioBehaviour_AbstractUserAction()
                                            .getUsageScenario_SenarioBehaviour().getId()
                                            + "_start")));
                }

                @Override
                public void after(AbstractUserAction action, User u, UserState state) {
                    // nothing to do
                }

            });

            // add a traversal listener to the usage scenario's stop action
            UsageBehaviourInterpreter.addTraversalListener(stop, new IUsageTraversalListener() {

                @Override
                public void after(AbstractUserAction action, User u, UserState state) {
                    // take current time sample
                    ProbeSpecContext probeSpecContext = u.getModel().getProbeSpecContext();
                    probeSpecContext.getSampleBlackboard().addSample(
                            ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                    .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(start.getId(),
                                            u.getModel().getSimulationControl()), u.getRequestContext(), start.getId(),
                                    probeSpecContext.obtainProbeSetId(start.getScenarioBehaviour_AbstractUserAction()
                                            .getUsageScenario_SenarioBehaviour().getId()
                                            + "_end")));
                }

                @Override
                public void before(AbstractUserAction action, User who, UserState state) {
                    // nothing to do
                }

            });
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
