package edu.kit.ipd.sdq.eventsim.workload;

import java.util.List;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.IStateExchangeService;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.StateExchangeService;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.workload.debug.DebugUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.events.ResumeUsageTraversalEvent;
import edu.kit.ipd.sdq.eventsim.workload.generator.BuildWorkloadGenerator;
import edu.kit.ipd.sdq.eventsim.workload.generator.IWorkloadGenerator;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.workload.probespec.commands.BuildUsageResponseTimeCalculators;
import edu.kit.ipd.sdq.eventsim.workload.probespec.commands.MountSystemCallProbes;
import edu.kit.ipd.sdq.eventsim.workload.probespec.commands.MountUsageScenarioProbes;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.events.IEventHandler;
import edu.kit.ipd.sdq.simcomp.system.events.SystemRequestProcessed;

/**
 * The EventSim workload simulation model. This is the central class of the workload simulation.
 * 
 * run. Before the simulation starts, it initialises the simulation in the
 * {@code init()} method. During the simulation, it provides information about
 * the PCM model that is to be simulated, the simulation configuration and the
 * simulation status. Finally, it cleans up after a simulation run in the
 * {finalise()} method.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 */
public class EventSimWorkloadModel extends AbstractEventSimModel {

	private static final Logger logger = Logger.getLogger(EventSimWorkloadModel.class);
	
	private UsageBehaviourInterpreter usageInterpreter;

	public EventSimWorkloadModel(ISimulationMiddleware middleware) {
		super(middleware);
	}

	/**
	 * This method prepares the EventSim workload simulator and creates the
	 * initial events to start the workload generation.
	 */
	public void init() {

		// initialise behaviour interpreters
		usageInterpreter = new UsageBehaviourInterpreter(new UsageInterpreterConfiguration());

		// initialise probfunction factory and random generator
		IProbabilityFunctionFactory probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();
		probFunctionFactory.setRandomGenerator(this.getEventSimConfig().getRandomGenerator());
		StoExCache.initialiseStoExCache(probFunctionFactory);

		// install debug traversal listeners, if debugging is enabled
		if (logger.isDebugEnabled()) {
			DebugUsageTraversalListener.install(this.usageInterpreter.getConfiguration());
		}

		this.initProbeSpecification();

		this.registerEventHandler();

		this.registerStateExchangeService();

		// ...and start the simulation by generating the workload
		final List<IWorkloadGenerator> workloadGenerators = this.execute(new BuildWorkloadGenerator(this));
		for (final IWorkloadGenerator d : workloadGenerators) {
			d.processWorkload();
		}
	}

	/**
	 * Registers the Palladio Specific EventSim state exchange service
	 */
	private void registerStateExchangeService() {
		BundleContext bundleContext = Activator.getContext();
		bundleContext.registerService(IStateExchangeService.class, new StateExchangeService(), null);
	}

	/**
	 * Register event handler to react on specific simulation events.
	 */
	private void registerEventHandler() {

		// setup system processed request event listener
		this.getSimulationMiddleware().registerEventHandler(SystemRequestProcessed.EVENT_ID, new IEventHandler<SystemRequestProcessed>() {

			@Override
			public void handle(SystemRequestProcessed simulationEvent) {
				// resume usage traversal after system finished processing
				IRequest request = simulationEvent.getRequest();
				User user = (User) request.getUser();

                new ResumeUsageTraversalEvent(EventSimWorkloadModel.this, user.getUserState()).schedule((User) request.getUser(), 0);
			}

		});

	}

	/**
	 * Initializes the Probe Specification by setting up the calculators and mounting the probes.
	 */
	private void initProbeSpecification() {

		// build calculators
		this.execute(new BuildUsageResponseTimeCalculators(this));

		// mount probes
		this.execute(new MountUsageScenarioProbes(this.usageInterpreter.getConfiguration(), this.getSimulationMiddleware()));
		this.execute(new MountSystemCallProbes(this.usageInterpreter.getConfiguration(), this.getSimulationMiddleware()));
	}

	@Override
	public void finalise() {
		super.finalise();

		EventSimEntity.resetIdGenerator();
	}

	/**
	 * Gives access to the usage behavior interpreter
	 * 
	 * @return A usage behavior interpreter
	 */
	public UsageBehaviourInterpreter getUsageInterpreter() {
		return usageInterpreter;
	}

}
