//package edu.kit.ipd.sdq.eventsim.resources.probespec.commands;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.palladiosimulator.probeframework.calculator.Calculator;
//
//import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
//import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
//import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
//import edu.kit.ipd.sdq.eventsim.resources.SchedulingPolicy;
//import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
//import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
//
///**
// * This command creates and returns a list of {@link Calculator}s. The following calculators are
// * created:
// * <ul>
// * <li>a {@link DemandCalculator} for each resource. If the resource has more than one instance, a
// * demand calculator is created for each instance.</li>
// * <li>a {@link StateCalculator} for each resource. If the resource has more than one instance, a
// * state calculator is created for each instance.</li>
// * </ul>
// * 
// * @author Philipp Merkle
// * 
// */
//public class BuildActiveResourceCalculators implements IPCMCommand<List<Calculator>> {
//
//    private AbstractEventSimModel model;
////    private SimulatedResourceEnvironment environment;
//    private SimActiveResource resource;
//
//    /**
//     * Constructs a new command that creates calculators for resources contained in the specified
//     * resource environment.
//     * 
//     * @param environment
//     *            the resource environment
//     */
//    public BuildActiveResourceCalculators(AbstractEventSimModel model, SimActiveResource resource) {
//        this.model = model;
//        this.resource = resource;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<Calculator> execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
//    	ProbeSpecContext probeSpecContext = this.model.getSimulationMiddleware().getProbeSpecContext();
//    	
////    	// collect all active resources
////        Set<SimActiveResource> resources = model.execute(new CollectActiveResources(environment));
//
//        // build calculators for each active resource
//        List<Calculator> calculators = new ArrayList<Calculator>();
//        
//            calculators.add(setupDemandCalculator(probeSpecContext, resource));
//
//            // setup utilization calculators depending on their scheduling strategy and number
//            // of cores
//            SchedulingPolicy strategy = resource.getSchedulingStrategy();
//            if (strategy.equals(SchedulingPolicy.PROCESSOR_SHARING)) {
//                if (resource.getNumberOfInstances() == 1) {
//                    calculators.addAll(setupResourceStateCalculator(probeSpecContext, resource));
//                } else {
//                    calculators.add(setupOverallUtilisationCalculator(probeSpecContext, resource));
//                }
//            } else if (strategy.equals(SchedulingPolicy.DELAY) || strategy.equals(SchedulingPolicy.FCFS)) {
//                assert (resource.getNumberOfInstances() == 1) : "DELAY and FCFS resources are expected to "
//                        + "have exactly one core";
//                calculators.addAll(setupResourceStateCalculator(probeSpecContext, resource));
////            } else if (strategy.equals(SchedulingPolicy.EXACT)) {
////                calculators.add(setupOverallUtilisationCalculator(this.model.getProbeSpecContext(), r));
//            } else {
//                throw new RuntimeException("Could not setup utilization calculator at resource " + resource.getDescription()
//                        + " as it is unknown how to handle the scheduling strategy " + strategy.name() + ".");
//            }
//        
//        return calculators;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public boolean cachable() {
//        return false;
//    }
//
//    /**
//     * Returns the probe set ID for the demand probe of the specified resource.
//     * 
//     * @param resource
//     *            the resource
//     * @return the probe set ID
//     */
//    public static Integer getDemandedTimeProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource) {
//        return probeSpecContext.obtainProbeSetId("demand_" + resource.getName() + "_" + resource.getId());
//    }
//
//    /**
//     * Returns the probe set ID for the state probe of the specified resource instance.
//     * 
//     * @param resource
//     *            the resource
//     * @param instance
//     *            the instance of the resource
//     * @return the probe set ID
//     */
//    public static Integer getStateProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource, int instance) {
//        return probeSpecContext.obtainProbeSetId("state_" + getInstanceDescription(resource, instance));
//    }
//
//    public static Integer getOverallUtilisationProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource) {
//        return probeSpecContext.obtainProbeSetId("overallUtilization_" + resource.getDescription());
//    }
//
//    /**
//     * Creates and returns a {@link DemandCalculator} for the specified resource
//     * 
//     * @param resource
//     *            the resource
//     * @return the created calculator
//     */
//    private DemandCalculator setupDemandCalculator(ProbeSpecContext probeSpecContext, final SimActiveResource resource) {
//        final Integer probeSetId = getDemandedTimeProbeSetId(probeSpecContext, resource);
//        DemandCalculator calculator = probeSpecContext.getCalculatorFactory().buildDemandCalculator(
//                resource.getDescription(), probeSetId);
//        return calculator;
//    }
//
//    /**
//     * Creates and returns a {@link StateCalculator} for each instance of the specified resource.
//     * 
//     * @param resource
//     *            the resource
//     * @return the list of created calculators
//     */
//    private List<StateCalculator> setupResourceStateCalculator(ProbeSpecContext probeSpecContext,
//            SimActiveResource resource) {
//        List<StateCalculator> calculators = new ArrayList<StateCalculator>();
//        for (int instance = 0; instance < resource.getNumberOfInstances(); instance++) {
//            final Integer probeSetID = getStateProbeSetId(probeSpecContext, resource, instance);
//            calculators.add(probeSpecContext.getCalculatorFactory().buildStateCalculator(
//                    getInstanceDescription(resource, instance), probeSetID));
//        }
//        return calculators;
//    }
//
//    private StateCalculator setupOverallUtilisationCalculator(ProbeSpecContext probeSpecContext,
//            SimActiveResource resource) {
//        final Integer stateProbeSetID = getOverallUtilisationProbeSetId(probeSpecContext, resource);
//        return probeSpecContext.getCalculatorFactory().buildOverallUtilizationCalculator(resource.getDescription(),
//                stateProbeSetID);
//    }
//
//    /**
//     * Returns a textual description of the specified resource instance.
//     * 
//     * @param resource
//     *            the resource
//     * @param instance
//     *            the instance of the resource
//     * @return the resource instance's description
//     */
//    private static String getInstanceDescription(SimActiveResource resource, int instance) {
//        String description = resource.getDescription();
//        if (resource.getNumberOfInstances() > 1) {
//            description = "Core " + (instance + 1) + " " + description;
//        }
//        return description;
//    }
//
//}
