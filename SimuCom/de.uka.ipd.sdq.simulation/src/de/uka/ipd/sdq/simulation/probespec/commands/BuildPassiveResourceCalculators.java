package de.uka.ipd.sdq.simulation.probespec.commands;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.HoldTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.WaitingTimeCalculator;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.entities.SimPassiveResource;
import de.uka.ipd.sdq.simulation.staticstructure.PassiveResourceRegistry;

public class BuildPassiveResourceCalculators implements IPCMCommand<List<Calculator>> {

    private PassiveResourceRegistry registry;

    public BuildPassiveResourceCalculators(PassiveResourceRegistry registry) {
        this.registry = registry;
    }

    @Override
    public List<Calculator> execute(PCMModel model, ICommandExecutor<PCMModel> executor) {
        List<Calculator> calculators = new ArrayList<Calculator>();
        for (SimPassiveResource r : registry.getPassiveResources()) {
            calculators.add(setupStateCalculator(r));
            calculators.add(setupWaitingTimeCalculator(r));
            calculators.add(setupHoldTimeCalculator(r));
        }
        return calculators;
    }

    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Returns the probe set ID for the state probe of the specified resource instance.
     * 
     * @param resource
     *            the resource
     * @return the probe set ID
     */
    public static Integer getStateProbeSetId(SimPassiveResource resource) {
        return ProbeSpecContext.instance().obtainProbeSetId(
                "state_" + resource.getResourceName() + " " + resource.getResourceId());
    }

    public static Integer getStartWaitingProbeSetId(SimPassiveResource resource) {
        return ProbeSpecContext.instance().obtainProbeSetId("startWaiting_" + resource.getResourceId());
    }

    public static Integer getStopWaitingProbeSetId(SimPassiveResource resource) {
        return ProbeSpecContext.instance().obtainProbeSetId("stopWaiting_" + resource.getResourceId());
    }

    public static Integer getStartHoldTimeProbeSetId(SimPassiveResource resource) {
        return ProbeSpecContext.instance().obtainProbeSetId("startHold" + resource.getResourceId());
    }

    public static Integer getStopHoldTimeProbeSetId(SimPassiveResource resource) {
        return ProbeSpecContext.instance().obtainProbeSetId("stopHold" + resource.getResourceId());
    }

    private StateCalculator setupStateCalculator(SimPassiveResource resource) {
        final Integer stateProbeSetID = getStateProbeSetId(resource);
        return ProbeSpecContext.instance().getCalculatorFactory().buildStateCalculator(
                "Passive Resource " + resource.getResourceName() + " " + resource.getResourceId(), stateProbeSetID);
    }

    private WaitingTimeCalculator setupWaitingTimeCalculator(SimPassiveResource resource) {
        final Integer startWaitingProbeSetId = getStartWaitingProbeSetId(resource);
        final Integer stopWaitingProbeSetId = getStopWaitingProbeSetId(resource);
        return ProbeSpecContext.instance().getCalculatorFactory().buildWaitingTimeCalculator(
                "Passive Resource " + resource.getResourceName() + " " + resource.getResourceId(),
                startWaitingProbeSetId, stopWaitingProbeSetId);
    }

    private HoldTimeCalculator setupHoldTimeCalculator(SimPassiveResource resource) {
        final Integer startHoldProbeSetId = getStartHoldTimeProbeSetId(resource);
        final Integer stopHoldProbeSetId = getStopHoldTimeProbeSetId(resource);
        return ProbeSpecContext.instance().getCalculatorFactory().buildHoldTimeCalculator(
                "Passive Resource " + resource.getResourceName() + " " + resource.getResourceId(), startHoldProbeSetId,
                stopHoldProbeSetId);
    }
    
}
