package edu.kit.ipd.sdq.eventsim.workload.probespec.commands;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
import edu.kit.ipd.sdq.eventsim.workload.command.usage.FindActionInUsageBehaviour;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.listener.IUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageInterpreterConfiguration;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

/**
 * This command registers a {@link ITraversalListener} at the start and at the stop action of a
 * {@link UsageScenario}. The listeners take a {@link ProbeType#CURRENT_TIME} sample in order to
 * enable the calculation of the usage scenario's response time.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 */
public class MountUsageScenarioProbes implements IPCMCommand<Void> {

    private final UsageInterpreterConfiguration interpreterConfig;
	private ISimulationMiddleware middleware;
    
    public MountUsageScenarioProbes(UsageInterpreterConfiguration interpreterConfig, ISimulationMiddleware middleware) {
        this.interpreterConfig = interpreterConfig;
        this.middleware = middleware;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
        for (UsageScenario s : pcm.getUsageModel().getUsageScenario_UsageModel()) {
            ScenarioBehaviour behaviour = s.getScenarioBehaviour_UsageScenario();
            final Start start = executor.execute(new FindActionInUsageBehaviour<Start>(behaviour, Start.class));
            final Stop stop = executor.execute(new FindActionInUsageBehaviour<Stop>(behaviour, Stop.class));

            // add a traversal listener to the usage scenario's start action
            this.interpreterConfig.addTraversalListener(start, new IUsageTraversalListener() {

                @Override
                public void before(AbstractUserAction action, User u, UserState state) {
                    // take current time sample
                    ProbeSpecContext probeSpecContext = middleware.getProbeSpecContext();
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
            this.interpreterConfig.addTraversalListener(stop, new IUsageTraversalListener() {

                @Override
                public void after(AbstractUserAction action, User u, UserState state) {
                    // take current time sample
                    ProbeSpecContext probeSpecContext = middleware.getProbeSpecContext();
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
