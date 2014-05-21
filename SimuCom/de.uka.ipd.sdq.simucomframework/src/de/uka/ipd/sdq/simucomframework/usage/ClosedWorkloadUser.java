package de.uka.ipd.sdq.simucomframework.usage;

import java.util.List;

import org.apache.log4j.Logger;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.probeframework.probes.Probe;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * A closed workload user is a user which performs the typical closed workload
 * cycle: execute, think, execute, ...
 * 
 * @author Steffen Becker, Sebastian Lehrig
 */
public class ClosedWorkloadUser extends SimuComSimProcess implements IUser {

    private static Logger logger = Logger.getLogger(ClosedWorkloadUser.class
            .getName());

    private final IScenarioRunner scenarioRunner;
    private final String thinkTime;

    // private static int USERCOUNT = 0;
    private int runCount = 0;

    private final List<Probe> usageStartStopProbes;

    /**
     * Constructor of the closed workload user
     * 
     * @param owner
     *            The model this user belongs to
     * @param name
     *            The users name
     * @param scenarioRunner
     *            The scenario runner determining the users behaviour
     * @param thinkTimeSpec
     *            A stoex which determines the users think time
     * @param usageStartStopProbes
     */
    public ClosedWorkloadUser(final SimuComModel owner, final String name,
            final IScenarioRunner scenarioRunner, final String thinkTimeSpec,
            final List<Probe> usageStartStopProbes) {
        super(owner, name);
        this.scenarioRunner = scenarioRunner;
        this.thinkTime = thinkTimeSpec;
        this.usageStartStopProbes = usageStartStopProbes;
    }

    protected long sessionId;

    /*
     * (non-Javadoc)
     * 
     * @see desmoj.core.simulator.SimProcess#lifeCycle()
     */
    @Override
    protected void internalLifeCycle() {

        // Repeat usage scenario runs as long as simulation is running:
        while (getModel().getSimulationControl().isRunning()) {
            // update session id
            updateNewSessionID();

            try {
                if (getModel().getConfiguration().getSimulateFailures()) {
                    this.getModel().getFailureStatistics().increaseRunCount();
                    if (getModel().getConfiguration().isDebug()) {
                        this.getModel().getFailureStatistics().printRunCount(logger, getModel().getSimulationControl().getCurrentSimulationTime());
                    }
                }
                // TODO: Fix me and provide a new solution
                //blackboardGarbageCollector.enterRegion(getRequestContext()
                //		.rootContext());
                scenarioRunner(this);
                if (getModel().getConfiguration().getSimulateFailures()) {
                    this.getModel().getFailureStatistics().recordSuccess();
                }
            } catch (final FailureException exception) {
                if (getModel().getConfiguration().getSimulateFailures()) {
                    this.getModel().getFailureStatistics().increaseUnhandledFailureCounter(
                            exception.getFailureType(),
                            currentSessionId);
                }
            } finally {
                // Increase measurements counter manually as usage scenario run
                // is not finished:
                this.getModel().increaseMainMeasurementsCount();

                //TODO: Fixme and provide a new solution
                //blackboardGarbageCollector.leaveRegion(getRequestContext()
                //		.rootContext());
                runCount++;
            }
        }

        // Mark user as finished:
        // USERCOUNT--;

        // Print failure statistics after last user is finished:
        // if (USERCOUNT == 0) {
        // if (this.getModel().getConfig().getSimulateFailures()) {
        // FailureStatistics.getInstance().printFailureStatistics(LOGGER);
        // }
        // }
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
        final double thinkTime = Context.evaluateStatic(this.thinkTime,
                Double.class, null);
        this.hold(thinkTime);
        ((TriggeredProbe)this.usageStartStopProbes.get(0)).takeMeasurement(getRequestContext());
        this.scenarioRunner.scenarioRunner(thread);
        ((TriggeredProbe)this.usageStartStopProbes.get(1)).takeMeasurement(getRequestContext());
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.usage.IUser#startUserLife()
     */
    @Override
    public void startUserLife() {
        if(logger.isDebugEnabled()) {
            logger.debug(this.getName() + " started! I'm alive!!!");
        }
        // USERCOUNT++;
        this.scheduleAt(0);
    }

    /**
     * {@inheritDoc}
     * <p>
     * A closed workload user runs through his lifecycle several times in
     * series. Each time the same {@link SimuComSimProcess} is used. In order to be
     * able to distinguish between the different runs, the request context id
     * gets concatenated with the run count. The run counts represents how often
     * the lifecycle has been executed. Thus the returned ID is unique for each
     * run through the lifecycle.
     */
    @Override
    public RequestContext getRequestContext() {
        return super.getRequestContext().append("." + runCount);
    }

}
