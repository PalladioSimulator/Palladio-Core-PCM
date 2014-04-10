package de.uka.ipd.sdq.simucomframework.usage;

import java.util.List;

import org.palladiosimulator.probespec.framework.probes.Probe;
import org.palladiosimulator.probespec.framework.probes.TriggeredProbe;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Base class for open workload users. Open workload users begin their life,
 * execute their behaviour once, and then they die
 * 
 * @author Steffen Becker
 * 
 */
public class OpenWorkloadUser extends SimuComSimProcess implements IUser {

    private final IScenarioRunner scenarioRunner;
    private final String usageScenarioId;
    private final List<Probe> usageStartStopProbes;

    public OpenWorkloadUser(
            final SimuComModel owner,
            final String name,
            final IScenarioRunner scenarioRunner,
            final String usageScenarioId,
            final List<Probe> usageStartStopProbes) {
        super(owner, name);
        this.scenarioRunner = scenarioRunner;
        this.usageScenarioId = usageScenarioId;
        this.usageStartStopProbes = usageStartStopProbes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see desmoj.core.simulator.SimProcess#lifeCycle()
     */
    @Override
    protected void internalLifeCycle() {
        if(logger.isDebugEnabled()) {
            logger.debug(getName() + " started! I'm alive!!!");
        }
        // update session id
        updateNewSessionID();
        try {
            //TODO: Fixme and provide a new solution
            //blackboardGarbageCollector.enterRegion(getRequestContext()
            //		.rootContext());
            ((TriggeredProbe)usageStartStopProbes.get(0)).takeMeasurement(getRequestContext());
            scenarioRunner(this);
            ((TriggeredProbe)usageStartStopProbes.get(1)).takeMeasurement(getRequestContext());
            if (getModel().getConfiguration().getSimulateFailures()) {
                getModel().getFailureStatistics().recordSuccess();
            }
        } catch (final FailureException exception) {
            if (getModel().getConfiguration().getSimulateFailures()) {
                getModel().getFailureStatistics().increaseUnhandledFailureCounter(
                        exception.getFailureType(), currentSessionId);
            }
        } finally {
            // Increase measurements counter manually as usage scenario run is
            // not finished:
            getModel().increaseMainMeasurementsCount();

            //TODO: Fixme and provide a new solution
            //blackboardGarbageCollector.leaveRegion(getRequestContext()
            //		.rootContext());
        }
        if(logger.isDebugEnabled()) {
            logger.debug(getName() + " done! I'm dying!!!");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner#scenarioRunner(
     * desmoj.core.simulator.SimProcess)
     */
    @Override
    public void scenarioRunner(final SimuComSimProcess thread) {
        this.scenarioRunner.scenarioRunner(thread);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.usage.IUser#startUserLife()
     */
    @Override
    public void startUserLife() {
        this.scheduleAt(0);
    }

}
