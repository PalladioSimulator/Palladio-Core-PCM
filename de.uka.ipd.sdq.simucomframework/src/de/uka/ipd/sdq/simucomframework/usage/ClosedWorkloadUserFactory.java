package de.uka.ipd.sdq.simucomframework.usage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;

/**
 * Factory to create closed workload users
 * 
 * @author Steffen Becker
 * 
 */
public abstract class ClosedWorkloadUserFactory implements IUserFactory {

    private final String thinkTime;
    private final SimuComModel model;
    private final List<TakeCurrentSimulationTimeProbe> usageStartStopProbes;


    public ClosedWorkloadUserFactory(final SimuComModel model, final String thinkTimeSpec) {
        this.thinkTime = thinkTimeSpec;
        this.model = model;
        this.usageStartStopProbes = Collections.unmodifiableList(Arrays.asList(
                new TakeCurrentSimulationTimeProbe(model.getSimulationControl()),
                new TakeCurrentSimulationTimeProbe(model.getSimulationControl())));
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.usage.IUserFactory#createUser()
     */
    @Override
    public IUser createUser(final String usageScenarioId) {
        final IScenarioRunner scenarioRunner = this.createScenarioRunner();
        return new ClosedWorkloadUser(model, "ClosedUser", scenarioRunner,
                thinkTime, usageScenarioId, usageStartStopProbes);
    }

    /**
     * Template method filled by the generator. Returns the users behaviour.
     * 
     * @return The behaviour of the users created by this factory
     */
    public abstract IScenarioRunner createScenarioRunner();

}
