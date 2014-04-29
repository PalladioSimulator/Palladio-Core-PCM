package edu.kit.ipd.sdq.eventsim.workload;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simulation.ISimulationListener;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.command.parameter.InstallSystemCallParameterHandling;
import edu.kit.ipd.sdq.eventsim.workload.debug.DebugUsageTraversalListener;
import edu.kit.ipd.sdq.eventsim.workload.events.ResumeUsageTraversalEvent;
import edu.kit.ipd.sdq.eventsim.workload.generator.BuildWorkloadGenerator;
import edu.kit.ipd.sdq.eventsim.workload.generator.IWorkloadGenerator;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageInterpreterConfiguration;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.event.IEventHandler;
import edu.kit.ipd.sdq.simcomp.event.system.SystemRequestProcessed;
import edu.kit.ipd.sdq.simcomp.middleware.probespec.CalculatorFactory;
import edu.kit.ipd.sdq.simcomp.middleware.probespec.SimCompGarbageCollector;
import edu.kit.ipd.sdq.simcomp.middleware.probespec.EventSimProbeStrategyRegistry;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.MaxMeasurementsStopCondition;

/**
 * The simulation model. This is the central class of an EventSim simulation
 * run. Before the simulation starts, it initialises the simulation in the
 * {@code init()} method. During the simulation, it provides information about
 * the PCM model that is to be simulated, the simulation configuration and the
 * simulation status. Finally, it cleans up after a simulation run in the
 * {finalise()} method.
 * <p>
 * Instances are created by using the static {@code create} method that builds
 * the simulation model in accordance with a specified simulation configuration.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 */
public class EventSimWorkloadModel extends AbstractEventSimModel {

	public EventSimWorkloadModel(ISimulationMiddleware middleware) {
		super(middleware);
	}

	private static final Logger logger = Logger.getLogger(EventSimWorkloadModel.class);

	private long mainMeasurementsCount;

	private UsageBehaviourInterpreter usageInterpreter;

	/**
	 * This method prepares the EventSim workload simulator and creates the
	 * initial events to start the workload generation.
	 */
	@Override
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

		// setup handling for PCM parameter characterisations
		this.execute(new InstallSystemCallParameterHandling(this.usageInterpreter.getConfiguration()));

		// initialise the Probe Specification
		//this.initialiseProbeSpecification();
		
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

		// notify registered listeners that the simulation is about to start...
		this.notifyStartListeners();

		// ...and start the simulation by generating the workload
		final List<IWorkloadGenerator> workloadGenerators = this.execute(new BuildWorkloadGenerator(this));
		for (final IWorkloadGenerator d : workloadGenerators) {
			d.processWorkload();
		}
	}

	/**
	 * Initialises the Probe Specification by building the
	 * {@link ProbeSpecContext}, setting up the calculators and mounting the
	 * probes.
	 */
	private void initialiseProbeSpecification() {

		// initialise ProbeSpecification context
		probeSpecContext.initialise(blackboard, new EventSimProbeStrategyRegistry(), new CalculatorFactory(this));

		// install a garbage collector which keeps track of the samples stored
		// on the blackboard and
		// removes samples when they become obsolete
		IRegionBasedGarbageCollector<RequestContext> garbageCollector = new SimCompGarbageCollector(blackboard);
		probeSpecContext.setBlackboardGarbageCollector(garbageCollector);

		/*
		 * // build calculators this.execute(new
		 * BuildResponseTimeCalculators(this)); this.execute(new
		 * BuildActiveResourceCalculators(this, this.resourceEnvironment));
		 * this.execute(new BuildPassiveResourceCalculators(this,
		 * this.passiveResourceRegistry));
		 * 
		 * // mount probes this.execute(new
		 * MountUsageScenarioProbes(this.usageInterpreter.getConfiguration()));
		 * this.execute(new
		 * MountSystemCallProbes(this.usageInterpreter.getConfiguration()));
		 * this.execute(new
		 * MountExternalCallProbes(this.seffInterpreter.getConfiguration()));
		 * this.execute(new MountActiveResourceProbes(this,
		 * this.resourceEnvironment)); this.execute(new
		 * MountPassiveResourceProbes(this, this.passiveResourceRegistry));
		 */
	}

	/**
	 * {@inheritDoc}
	 */
	public void finalise() {
		// notify observers that the simulation is finished (below we just clean
		// up...)
		this.notifyStopListeners();

		// notify active entities that the simulation is finished (and
		// therefore, also their
		// existence in the simulated system)
		for (EventSimEntity entity : activeEntitiesList) {
			assert entity.getState().equals(EventSimEntity.EntityState.ENTERED_SYSTEM) : "Found an entity in the " + "list of active entities which is in the state " + entity.getState() + ", and therefore can not be an active entity.";
			entity.notifyLeftSystem();
		}
		assert activeEntitiesList.isEmpty() : "There are some entities left in the list of active entities, though " + "each of them was asked to leave the system.";

		// notify active resources about the simulation stop
		deactivateResources();

		// clean up
		if (logger.isDebugEnabled()) {
			logger.debug("Cleaning up...");
		}
		EventSimEntity.resetIdGenerator();
		probeSpecContext.finish();
		AbstractActiveResource.cleanProcesses();

		if (logger.isEnabledFor(Level.INFO))
			logger.info("Simulation took " + getSimulationControl().getCurrentSimulationTime() + " simulation seconds");

		// TODO
		// traceRecorder.print();
		// ((CountingPCMModelCommandExecutor)executor).printStatistics();
	}

	/**
	 * Notifies all active resources that the simulation run has stopped.
	 */
	private void deactivateResources() {
		for (SimulatedResourceContainer c : this.resourceEnvironment.getResourceContainers()) {
			for (SimActiveResource r : c.getResources()) {
				r.deactivateResource();
			}
		}
	}

	/**
	 * Increases the number of measurements, which has been taken, by one.
	 * <p>
	 * Notice that one measurements refers to one {@link User} that has
	 * completely traversed the simulated system.
	 */
	public void increaseMainMeasurementsCount() {
		this.mainMeasurementsCount++;
	}

	/**
	 * Returns the number of measurements, which has been taken.
	 * <p>
	 * Notice that one measurements refers to one {@link User} that has
	 * completely traversed the simulated system.
	 * 
	 * @return the current number of measurements
	 */
	public long getMainMeasurementsCount() {
		return this.mainMeasurementsCount;
	}

	public UsageBehaviourInterpreter getUsageInterpreter() {
		return usageInterpreter;
	}

	/**
	 * Notfies all simulation observers that the simulation is about to start
	 */
	private void notifyStartListeners() {
		for (final ISimulationListener l : this.getEventSimConfig().getListeners()) {
			l.simulationStart();
		}
	}

	/**
	 * Notfies all simulation observers that the simulation has stopped
	 */
	private void notifyStopListeners() {
		for (final ISimulationListener l : this.getEventSimConfig().getListeners()) {
			l.simulationStop();
		}
	}

}
