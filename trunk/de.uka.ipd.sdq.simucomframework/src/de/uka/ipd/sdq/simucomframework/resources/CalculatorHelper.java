package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.HoldTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.WaitingTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.DiscardInvalidMeasurementsBlackboardDecorator;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimulationControlDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;

/**
 * Offers static methods to setup different types of calculators for resources
 * like {@link AbstractScheduledResource} and {@link IPassiveResource}.
 * 
 * @author Philipp Merkle
 * 
 */
public class CalculatorHelper {

//	/**
//	 * Sets up a {@link DemandBasedWaitingTimeCalculator} for the specified
//	 * resource. Also a {@link IScheduledResourceListener} will be registered at
//	 * the resource which gets notified of events that are relevant for
//	 * calculating the waiting time. When such an event arrives, an appropriate
//	 * {@link ProbeSample} will be taken and published at the
//	 * {@link SampleBlackboard}.
//	 * 
//	 * @param r
//	 *            the resource
//	 */
//	public static void setupWaitingTimeCalculator(
//			final AbstractScheduledResource r) {
//
//		// build waiting time calculator
//		final Integer startWaitingProbeSetId = ProbeSpecContext.instance()
//				.obtainProbeSetId("startWaitingSchedRes_" + r.getDescription());
//		final Integer stopProcessingProbeSetId = ProbeSpecContext.instance()
//				.obtainProbeSetId(
//						"stopProcessingSchedRes_" + r.getDescription());
//		ProbeSpecContext.instance().getCalculatorFactory().buildDemandBasedWaitingTimeCalculator(
//				r.getDescription(), startWaitingProbeSetId,
//				stopProcessingProbeSetId);
//
//		r.addScheduledResourceListener(new IScheduledResourceListener() {
//			@SuppressWarnings("unchecked")
//			@Override
//			public void jobArrived(JobAndDemandStruct job) {
//				// take current time
//				ProbeSample currentTimeSample = takeCurrentTimeSample(job);
//
//				// take demanded time
//				ProbeSample demandedTimeSample = takeDemandedTimeSample(r, job);
//
//				// TODO Check whether the context is unique so that there is at
//				// most one job per SimProcess
//				RequestContext context = ((SimProcess) job.getJobParent())
//						.getRequestContext()
//						.append("_" + job.getCreationTime());
//
//				// build ProbeSetSample and publish it on the blackboard
//				ProbeSpecContext.instance().getSampleBlackboard()
//						.addSample(
//								ProbeSpecUtils.buildProbeSetSample(
//										currentTimeSample, demandedTimeSample,
//										context, "", startWaitingProbeSetId));
//			}
//
//			@SuppressWarnings("unchecked")
//			@Override
//			public void jobDone(JobAndDemandStruct job) {
//				// take current time
//				ProbeSample currentTimeSample = takeCurrentTimeSample(job);
//
//				// take demanded time
//				ProbeSample demandedTimeSample = takeDemandedTimeSample(r, job);
//
//				// TODO Check whether the context is unique so that there is at
//				// most one job per SimProcess
//				RequestContext context = ((SimProcess) job.getJobParent())
//						.getRequestContext()
//						.append("_" + job.getCreationTime());
//
//				// build ProbeSetSample and publish it on the blackboard
//				ProbeSpecContext.instance().getSampleBlackboard()
//						.addSample(
//								ProbeSpecUtils.buildProbeSetSample(
//										currentTimeSample, demandedTimeSample,
//										context, "", stopProcessingProbeSetId));
//			}
//		});
//
//	}
//
	/**
	 * Sets up a {@link WaitingTimeCalculator} for the specified resource. Also
	 * a {@link IPassiveResourceSensor} will be registered at the resource which
	 * gets notified of events that are relevant for calculating the waiting
	 * time. When such an event arrives, an appropriate {@link ProbeSample} will
	 * be taken and published at the {@link ISampleBlackboard}.
	 * 
	 * @param r
	 *            the resource
	 */
	public static void setupWaitingTimeCalculator(final IPassiveResource resource, final ISimulationControlDelegate simControl) {
		// build waiting time calculator
		final Integer startWaitingProbeSetId = ProbeSpecContext.instance()
				.obtainProbeSetId("startWaitingPsvRes_" + resource.getId());
		final Integer stopWaitingProbeSetId = ProbeSpecContext.instance()
				.obtainProbeSetId("stopWaitingPsvRes_" + resource.getId());
		ProbeSpecContext.instance().getCalculatorFactory().buildWaitingTimeCalculator(
				"Passive Resource "+resource.getName()+ " "+resource.getId(), startWaitingProbeSetId, stopWaitingProbeSetId);
		
		resource.addObserver(new IPassiveResourceSensor() {
			
			@Override
			public void request(ISchedulableProcess process, int num) {
				// take current time
				ProbeSample currentTimeSample = takeCurrentTimeSample(simControl);
				
				// build ProbeSetSample and publish it on the blackboard
				ProbeSpecContext.instance().getSampleBlackboard()
						.addSample(
								ProbeSpecUtils.buildProbeSetSample(
										currentTimeSample,
										((SimProcess)process).getRequestContext(),
										"", startWaitingProbeSetId));
			}
			
			@Override
			public void acquire(ISchedulableProcess process, int num) {
				// take current time
				ProbeSample currentTimeSample = takeCurrentTimeSample(simControl);

				// build ProbeSetSample and publish it on the blackboard
				ProbeSpecContext.instance().getSampleBlackboard()
						.addSample(
								ProbeSpecUtils.buildProbeSetSample(
										currentTimeSample,
										((SimProcess)process).getRequestContext(),
										"", stopWaitingProbeSetId));
				
			}
			
			@Override
			public void release(ISchedulableProcess process, int num) {
				// nothing to do here
				
			}
			
		});
		
	}
	
	/**
	 * Sets up a {@link HoldTimeCalculator} for the specified resource. Also
	 * a {@link IPassiveResourceSensor} will be registered at the resource which
	 * gets notified of events that are relevant for calculating the hold
	 * time. When such an event arrives, an appropriate {@link ProbeSample} will
	 * be taken and published at the {@link ISampleBlackboard}.
	 * 
	 * @param r
	 *            the resource
	 */
	public static void setupHoldTimeCalculator(final IPassiveResource resource, final ISimulationControlDelegate simControl) {
		// build hold time calculator
		final Integer startHoldProbeSetId = ProbeSpecContext.instance()
				.obtainProbeSetId("startHoldPsvRes_" + resource.getId());
		final Integer stopHoldProbeSetId = ProbeSpecContext.instance()
				.obtainProbeSetId("stopHoldPsvRes_" + resource.getId());
		ProbeSpecContext.instance().getCalculatorFactory().buildHoldTimeCalculator(
				"Passive Resource "+resource.getName()+ " "+resource.getId(), startHoldProbeSetId, stopHoldProbeSetId);
		
		resource.addObserver(new IPassiveResourceSensor() {
			
			@Override
			public void request(ISchedulableProcess process, int num) {
				// nothing to do here
			}
			
			@Override
			public void acquire(ISchedulableProcess process, int num) {
				// take current time
				ProbeSample currentTimeSample = takeCurrentTimeSample(simControl);
				
				// build ProbeSetSample and publish it on the blackboard
				ProbeSpecContext.instance().getSampleBlackboard()
						.addSample(
								ProbeSpecUtils.buildProbeSetSample(
										currentTimeSample,
										((SimProcess)process).getRequestContext(),
										"", startHoldProbeSetId));
			}
			
			@Override
			public void release(ISchedulableProcess process, int num) {
				// take current time
				ProbeSample currentTimeSample = takeCurrentTimeSample(simControl);

				// build ProbeSetSample and publish it on the blackboard
				ProbeSpecContext.instance().getSampleBlackboard()
						.addSample(
								ProbeSpecUtils.buildProbeSetSample(
										currentTimeSample,
										((SimProcess)process).getRequestContext(),
										"", stopHoldProbeSetId));
			}
		});
	}

	/**
	 * Sets up a {@link DemandCalculator} for the specified resource. Also a
	 * {@link IDemandListener} will be registered at the resource
	 * which gets notified of events that are relevant for calculating the
	 * demanded time. When such an event arrives, an appropriate
	 * {@link ProbeSample} will be taken and published at the
	 * {@link ISampleBlackboard}.
	 * 
	 * @param r
	 *            the resource
	 */
	public static void setupDemandCalculator(final AbstractScheduledResource r) {
		// build demand calculator
		final Integer demandedTimeProbeSetId = ProbeSpecContext.instance()
				.obtainProbeSetId("demandedTimeSchedRes_" + r.getDescription());
		ProbeSpecContext.instance().getCalculatorFactory().buildDemandCalculator(
				r.getDescription(), demandedTimeProbeSetId);

		r.addDemandListener(new IDemandListener() {
			
			@Override
			public void demand(double demand) {
				// take current time
				ProbeSample currentTimeSample = takeCurrentTimeSample(r);
				
				// take demanded time
				ProbeSample demandedTimeSample = takeDemandedTimeSample(r, demand);

				// TODO Check whether the context is unique so that there is at
				// most one job per SimProcess
//				RequestContext context = ((SimProcess) job.getJobParent())
//						.getRequestContext()
//						.append("_" + job.getCreationTime());

				// build ProbeSetSample and publish it on the blackboard
				RequestContext context = new RequestContext("");
				ProbeSpecContext.instance().getSampleBlackboard()
						.addSample(
								ProbeSpecUtils.buildProbeSetSample(
										currentTimeSample, demandedTimeSample,
										context, "", demandedTimeProbeSetId));
			}
		});
	}

	/**
	 * Sets up a {@link StateCalculator} for the specified resource. Also a
	 * {@link IStateListener} will be registered at the resource which gets
	 * notified of events that are relevant for calculating the state. When such
	 * an event arrives, an appropriate {@link ProbeSample} will be taken and
	 * published at the {@link ISampleBlackboard}.
	 * 
	 * @param r
	 *            the resource
	 */
	public static void setupStateCalculator(final AbstractScheduledResource r) {
		// setup a calculator for each instance
		for (int instance = 0; instance < r.getNumberOfInstances(); instance++) { 
			String instanceDescription = r.getDescription();
			if (r.getNumberOfInstances() > 1) {
				instanceDescription = "Core " + (instance + 1) + " "
						+ instanceDescription;
			}
			
			// build state calculator
			final Integer stateProbeSetID = ProbeSpecContext.instance()
					.obtainProbeSetId("state_" + instanceDescription);
			ProbeSpecContext.instance().getCalculatorFactory().buildStateCalculator(
					instanceDescription, stateProbeSetID);
	
			r.addStateListener(new IStateListener() {
				@SuppressWarnings("unchecked")
				@Override
				public void stateChanged(int state, int instanceId) {
					// take current time
					ProbeSample currentTimeSample = takeCurrentTimeSample(r);
	
					// take state
					ProbeSample stateSample = takeStateProbe(state);
	
					// build ProbeSetSample and publish it on the blackboard
					// TODO maybe null instead of empty string is better here
					RequestContext context = new RequestContext("");
					ProbeSpecContext.instance().getSampleBlackboard()
							.addSample(
									ProbeSpecUtils.buildProbeSetSample(
											currentTimeSample, stateSample,
											context, "", stateProbeSetID));
				}
			}, instance);
		}
	}
	
	public static void setupOverallUtilizationCalculator(final AbstractScheduledResource r) {					
			// build state calculator
			final Integer stateProbeSetID = ProbeSpecContext.instance()
					.obtainProbeSetId("overallUtilization_" + r.getDescription());
			ProbeSpecContext.instance().getCalculatorFactory().buildOverallUtilizationCalculator(
					r.getDescription(), stateProbeSetID);
	
			r.addOverallUtilizationListener(new IOverallUtilizationListener() {
				
				@Override
				public void utilizationChanged(double resourceDemand, double totalTime) {
					// FIXME This is a hack that allows to add samples to the blackboard even when 
					// the simulation has stopped.
					if(!(ProbeSpecContext.instance().getSampleBlackboard() instanceof 
							DiscardInvalidMeasurementsBlackboardDecorator)) {
						return;
					}
					DiscardInvalidMeasurementsBlackboardDecorator blackboard = (DiscardInvalidMeasurementsBlackboardDecorator)ProbeSpecContext.instance().getSampleBlackboard();
										
					// build ProbeSetSamples and publish them on the blackboard
					// TODO maybe null instead of empty string is better here
					RequestContext context = new RequestContext("");
					blackboard.addSampleAfterSimulationEnd(
									ProbeSpecUtils.buildProbeSetSample(
											takeTimeSample(0.0), takeStateProbe(1),
											context, "", stateProbeSetID));
					blackboard.addSampleAfterSimulationEnd(
									ProbeSpecUtils.buildProbeSetSample(
											takeTimeSample(resourceDemand), takeStateProbe(0),
											context, "", stateProbeSetID));
					blackboard.addSampleAfterSimulationEnd(
									ProbeSpecUtils.buildProbeSetSample(
											takeTimeSample(totalTime), takeStateProbe(1),
											context, "", stateProbeSetID));
				}
			});
	}

	public static void setupStateCalculator(final IPassiveResource resource, final ISimulationControlDelegate simControl) {
		// build state calculator
		final Integer stateProbeSetID = ProbeSpecContext.instance()
				.obtainProbeSetId("state_" + resource.getName()+ " "+resource.getId());
		ProbeSpecContext.instance().getCalculatorFactory().buildStateCalculator("Passive Resource "+resource.getName()+" "+resource.getId(),
				stateProbeSetID);

		resource.addObserver(new IPassiveResourceSensor() {
			
			@Override
			public void request(ISchedulableProcess process, int num) {
				// nothing to do here
			}
			
			@Override
			public void release(ISchedulableProcess process, int num) {
				measureState();
			}
			
			@Override
			public void acquire(ISchedulableProcess process, int num) {
				measureState();
			}

			@SuppressWarnings("unchecked")
			private void measureState() {
				// take current time
				ProbeSample currentTimeSample = takeCurrentTimeSample(simControl);

				// take state
				ProbeSample stateSample = takeStateProbe(resource);

				// build ProbeSetSample and publish it on the blackboard
				// TODO maybe null instead of empty string is better here
				RequestContext context = new RequestContext("");
				ProbeSpecContext.instance().getSampleBlackboard()
						.addSample(
								ProbeSpecUtils.buildProbeSetSample(
										currentTimeSample, stateSample,
										context, "", stateProbeSetID));
			}

		});
	}

	@SuppressWarnings("unchecked")
	private static ProbeSample takeCurrentTimeSample(SimProcess thread) {
		IProbeStrategy probeStrategy = ProbeSpecContext.instance()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.CURRENT_TIME, null);
		ProbeSample currentTimeSample = probeStrategy.takeSample(
				"TODO: probeId",
				// TODO add probeID as soon as a ProbeSpec model is used
				thread.getModel().getSimulationControl());
		return currentTimeSample;
	}

	@SuppressWarnings("unchecked")
	private static ProbeSample takeCurrentTimeSample(ISimulationControlDelegate simControl) {
		IProbeStrategy probeStrategy = ProbeSpecContext.instance()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.CURRENT_TIME, null);
		ProbeSample currentTimeSample = probeStrategy.takeSample(
				"TODO: probeId",
				// TODO add probeID as soon as a ProbeSpec model is used
				simControl);
		return currentTimeSample;
	}

	@SuppressWarnings("unchecked")
	private static ProbeSample takeCurrentTimeSample(
			final AbstractScheduledResource r) {
		IProbeStrategy probeStrategy = ProbeSpecContext.instance()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.CURRENT_TIME, null);
		ProbeSample currentTimeSample = probeStrategy.takeSample(
				"TODO: probeId", r.getModel().getSimulationControl());
		return currentTimeSample;
	}
	
	@SuppressWarnings("unchecked")
	private static ProbeSample takeTimeSample(Double time) {
		IProbeStrategy probeStrategy = ProbeSpecContext.instance()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.CURRENT_TIME, null);
		ProbeSample currentTimeSample = probeStrategy.takeSample(
				"TODO: probeId", time);
		return currentTimeSample;
	}

	@SuppressWarnings("unchecked")
	private static ProbeSample takeDemandedTimeSample(
			AbstractScheduledResource r, Double demand) {
		IProbeStrategy probeStrategy = ProbeSpecContext.instance()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.RESOURCE_DEMAND, AbstractScheduledResource.class);
		ProbeSample demandedTimeSample = probeStrategy.takeSample(
				"TODO: probeId",
				// TODO add probeID as soon as a ProbeSpec model is used
				demand);
		return demandedTimeSample;
	}

	@SuppressWarnings("unchecked")
	private static ProbeSample takeStateProbe(int state) {
		IProbeStrategy probeStrategy = ProbeSpecContext.instance()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.RESOURCE_STATE, AbstractScheduledResource.class);
		ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", state);
		return stateSample;
	}

	@SuppressWarnings("unchecked")
	private static ProbeSample takeStateProbe(final IPassiveResource r) {
		IProbeStrategy probeStrategy = ProbeSpecContext.instance()
				.getProbeStrategyRegistry().getProbeStrategy(
						ProbeType.RESOURCE_STATE, IPassiveResource.class);
		ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", r);
		return stateSample;
	}

}
