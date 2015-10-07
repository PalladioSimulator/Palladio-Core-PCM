//package edu.kit.ipd.sdq.eventsim.workload.probespec.commands;
//
//import java.util.SortedMap;
//import java.util.TreeMap;
//
//import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
//import org.palladiosimulator.pcm.usagemodel.Start;
//import org.palladiosimulator.pcm.usagemodel.Stop;
//import org.palladiosimulator.pcm.usagemodel.UsageScenario;
//
//import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
//import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
//import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
//import edu.kit.ipd.sdq.eventsim.workload.command.usage.FindActionInUsageBehaviour;
//import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageInterpreterConfiguration;
//import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
//import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
//import edu.kit.ipd.sdq.simcomp.persistence.Measurement;
//import edu.kit.ipd.sdq.simcomp.persistence.factory.CalculatorBuilder;
//
///**
// * This command registers a {@link ITraversalListener} at the start and at the stop action of a {@link UsageScenario}.
// * The listeners take a {@link ProbeType#CURRENT_TIME} sample in order to enable the calculation of the usage scenario's
// * response time.
// * 
// * @author Philipp Merkle
// * @author Christoph Föhrdes
// * 
// */
//public class MountUsageScenarioProbes implements IPCMCommand<Void> {
//
//	private final UsageInterpreterConfiguration interpreterConfig;
//	private ISimulationMiddleware middleware;
//
//	private final SortedMap<String, Measurement> mm;
//
//	public MountUsageScenarioProbes(UsageInterpreterConfiguration interpreterConfig, ISimulationMiddleware middleware) {
//		mm = new TreeMap<String, Measurement>();
//		this.interpreterConfig = interpreterConfig;
//		this.middleware = middleware;
//	}
//
//	// private String makeKey(Measurement m) {
//	// return m.getWhere() + ":" + m.getWho().getId();
//	// }
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public Void execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
//		for (UsageScenario s : pcm.getUsageModel().getUsageScenario_UsageModel()) {
//			ScenarioBehaviour behaviour = s.getScenarioBehaviour_UsageScenario();
//			final Start start = executor.execute(new FindActionInUsageBehaviour<Start>(behaviour, Start.class));
//			final Stop stop = executor.execute(new FindActionInUsageBehaviour<Stop>(behaviour, Stop.class));
//
//			// //////////////////
//			UsageProbeFactory f = new UsageProbeFactory(interpreterConfig);
//			CalculatorBuilder.createBinary(new ResponseTimeCalculatorUsage()).from(f.probeFor(start, "before"))
//					.to(f.probeFor(stop, "after"));
//			// //////////////////
//		}
//
//		// this command is not supposed to return a value
//		return null;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public boolean cachable() {
//		return false;
//	}
//
//}
