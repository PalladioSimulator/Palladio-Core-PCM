package de.uka.ipd.sdq.simucomframework.usage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;

/**
 * A factory for creating open workload users
 * 
 * @author Steffen Becker
 * 
 */
public abstract class OpenWorkloadUserFactory implements IUserFactory {

    private final SimuComModel model;
    private final List<TakeCurrentSimulationTimeProbe> usageStartStopProbes;

    public OpenWorkloadUserFactory(final SimuComModel model) {
        super();

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
        return new OpenWorkloadUser(model, "OpenUser", scenarioRunner,
                usageScenarioId, usageStartStopProbes);
    }

    /**
     * Template method filled in by the generator. Returns an object
     * representing the user behaviour needed for the new users.
     * 
     * @return The behaviour of the users created by this factory
     */
    public abstract IScenarioRunner createScenarioRunner();

}
