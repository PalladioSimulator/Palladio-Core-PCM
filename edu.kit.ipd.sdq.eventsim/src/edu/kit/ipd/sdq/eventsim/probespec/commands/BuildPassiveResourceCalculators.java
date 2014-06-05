package edu.kit.ipd.sdq.eventsim.probespec.commands;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.HoldTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.WaitingTimeCalculator;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.staticstructure.PassiveResourceRegistry;

public class BuildPassiveResourceCalculators implements IPCMCommand<List<Calculator>> {

    private EventSimModel model;
    private PassiveResourceRegistry registry;

    public BuildPassiveResourceCalculators(EventSimModel model, PassiveResourceRegistry registry) {
        this.registry = registry;
        this.model = model;
    }

    @Override
    public List<Calculator> execute(PCMModel model, ICommandExecutor<PCMModel> executor) {
        List<Calculator> calculators = new ArrayList<Calculator>();
        for (SimPassiveResource r : registry.getPassiveResources()) {
            calculators.add(setupStateCalculator(this.model.getProbeSpecContext(), r));
            calculators.add(setupWaitingTimeCalculator(this.model.getProbeSpecContext(), r));
            calculators.add(setupHoldTimeCalculator(this.model.getProbeSpecContext(), r));
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
    public static Integer getStateProbeSetId(ProbeSpecContext probeSpecContext, SimPassiveResource resource) {
        return probeSpecContext.obtainProbeSetId(
                "state_" + resource.getResourceName() + " " + resource.getResourceId());
    }

    public static Integer getStartWaitingProbeSetId(ProbeSpecContext probeSpecContext, SimPassiveResource resource) {
        return probeSpecContext.obtainProbeSetId("startWaiting_" + resource.getResourceId());
    }

    public static Integer getStopWaitingProbeSetId(ProbeSpecContext probeSpecContext, SimPassiveResource resource) {
        return probeSpecContext.obtainProbeSetId("stopWaiting_" + resource.getResourceId());
    }

    public static Integer getStartHoldTimeProbeSetId(ProbeSpecContext probeSpecContext, SimPassiveResource resource) {
        return probeSpecContext.obtainProbeSetId("startHold" + resource.getResourceId());
    }

    public static Integer getStopHoldTimeProbeSetId(ProbeSpecContext probeSpecContext, SimPassiveResource resource) {
        return probeSpecContext.obtainProbeSetId("stopHold" + resource.getResourceId());
    }

    private StateCalculator setupStateCalculator(ProbeSpecContext probeSpecContext, SimPassiveResource resource) {
        final Integer stateProbeSetID = getStateProbeSetId(probeSpecContext, resource);
        return probeSpecContext.getCalculatorFactory().buildStateCalculator(
                "Passive Resource " + resource.getResourceName() + " " + resource.getResourceId(), stateProbeSetID);
    }

    private WaitingTimeCalculator setupWaitingTimeCalculator(ProbeSpecContext probeSpecContext, SimPassiveResource resource) {
        final Integer startWaitingProbeSetId = getStartWaitingProbeSetId(probeSpecContext, resource);
        final Integer stopWaitingProbeSetId = getStopWaitingProbeSetId(probeSpecContext, resource);
        return probeSpecContext.getCalculatorFactory().buildWaitingTimeCalculator(
                "Passive Resource " + resource.getResourceName() + " " + resource.getResourceId(),
                startWaitingProbeSetId, stopWaitingProbeSetId);
    }

    private HoldTimeCalculator setupHoldTimeCalculator(ProbeSpecContext probeSpecContext, SimPassiveResource resource) {
        final Integer startHoldProbeSetId = getStartHoldTimeProbeSetId(probeSpecContext, resource);
        final Integer stopHoldProbeSetId = getStopHoldTimeProbeSetId(probeSpecContext, resource);
        return probeSpecContext.getCalculatorFactory().buildHoldTimeCalculator(
                "Passive Resource " + resource.getResourceName() + " " + resource.getResourceId(), startHoldProbeSetId,
                stopHoldProbeSetId);
    }
    
}
