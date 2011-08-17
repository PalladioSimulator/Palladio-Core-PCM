package de.uka.ipd.sdq.simulation.probespec.commands;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceEnvironment;

/**
 * This command creates and returns a list of {@link Calculator}s. The following calculators are
 * created:
 * <ul>
 * <li>a {@link DemandCalculator} for each resource. If the resource has more than one instance, a
 * demand calculator is created for each instance.</li>
 * <li>a {@link StateCalculator} for each resource. If the resource has more than one instance, a
 * state calculator is created for each instance.</li>
 * </ul>
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildActiveResourceCalculators implements IPCMCommand<List<Calculator>> {

    private SimulatedResourceEnvironment environment;

    /**
     * Constructs a new command that creates calculators for resources contained in the specified
     * resource environment.
     * 
     * @param environment
     *            the resource environment
     */
    public BuildActiveResourceCalculators(SimulatedResourceEnvironment environment) {
        this.environment = environment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Calculator> execute(PCMModel model, ICommandExecutor<PCMModel> executor) {
        List<Calculator> calculators = new ArrayList<Calculator>();
        for (SimulatedResourceContainer c : environment.getResourceContainers()) {
            for (SimActiveResource r : c.getResources()) {
                calculators.add(setupDemandCalculator(r));

                // setup utilization calculators depending on their scheduling strategy and number
                // of cores
                SchedulingPolicy strategy = r.getSchedulingStrategy();
                if (strategy.equals(SchedulingPolicy.PROCESSOR_SHARING)) {
                    if (r.getNumberOfInstances() == 1) {
                        calculators.addAll(setupResourceStateCalculator(r));
                    } else {
                        calculators.add(setupOverallUtilisationCalculator(r));
                    }
                } else if (strategy.equals(SchedulingPolicy.DELAY) || strategy.equals(SchedulingPolicy.FCFS)) {
                    assert (r.getNumberOfInstances() == 1) : "DELAY and FCFS resources are expected to "
                            + "have exactly one core";
                    calculators.addAll(setupResourceStateCalculator(r));
                } else if (strategy.equals(SchedulingPolicy.EXACT)) {
                    calculators.add(setupOverallUtilisationCalculator(r));
                } else {
                    throw new RuntimeException("Could not setup utilization calculator at resource "
                            + r.getDescription() + " as it is unknown how to handle the scheduling strategy "
                            + strategy.name() + ".");
                }
            }
        }
        return calculators;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Returns the probe set ID for the demand probe of the specified resource.
     * 
     * @param resource
     *            the resource
     * @return the probe set ID
     */
    public static Integer getDemandedTimeProbeSetId(SimActiveResource resource) {
        return ProbeSpecContext.instance().obtainProbeSetId("demand_" + resource.getName() + "_" + resource.getId());
    }

    /**
     * Returns the probe set ID for the state probe of the specified resource instance.
     * 
     * @param resource
     *            the resource
     * @param instance
     *            the instance of the resource
     * @return the probe set ID
     */
    public static Integer getStateProbeSetId(SimActiveResource resource, int instance) {
        return ProbeSpecContext.instance().obtainProbeSetId("state_" + getInstanceDescription(resource, instance));
    }

    public static Integer getOverallUtilisationProbeSetId(SimActiveResource resource) {
        return ProbeSpecContext.instance().obtainProbeSetId("overallUtilization_" + resource.getDescription());
    }

    /**
     * Creates and returns a {@link DemandCalculator} for the specified resource
     * 
     * @param resource
     *            the resource
     * @return the created calculator
     */
    private DemandCalculator setupDemandCalculator(final SimActiveResource resource) {
        final Integer probeSetId = getDemandedTimeProbeSetId(resource);
        DemandCalculator calculator = ProbeSpecContext.instance().getCalculatorFactory().buildDemandCalculator(
                resource.getDescription(), probeSetId);
        return calculator;
    }

    /**
     * Creates and returns a {@link StateCalculator} for each instance of the specified resource.
     * 
     * @param resource
     *            the resource
     * @return the list of created calculators
     */
    private List<StateCalculator> setupResourceStateCalculator(SimActiveResource resource) {
        List<StateCalculator> calculators = new ArrayList<StateCalculator>();
        for (int instance = 0; instance < resource.getNumberOfInstances(); instance++) {
            final Integer probeSetID = getStateProbeSetId(resource, instance);
            calculators.add(ProbeSpecContext.instance().getCalculatorFactory().buildStateCalculator(
                    getInstanceDescription(resource, instance), probeSetID));
        }
        return calculators;
    }

    private StateCalculator setupOverallUtilisationCalculator(SimActiveResource resource) {
        final Integer stateProbeSetID = getOverallUtilisationProbeSetId(resource);
        return ProbeSpecContext.instance().getCalculatorFactory().buildOverallUtilizationCalculator(
                resource.getDescription(), stateProbeSetID);
    }

    /**
     * Returns a textual description of the specified resource instance.
     * 
     * @param resource
     *            the resource
     * @param instance
     *            the instance of the resource
     * @return the resource instance's description
     */
    private static String getInstanceDescription(SimActiveResource resource, int instance) {
        String description = resource.getDescription();
        if (resource.getNumberOfInstances() > 1) {
            description = "Core " + (instance + 1) + " " + description;
        }
        return description;
    }

}
