package de.uka.ipd.sdq.simucomframework.usage;

import org.palladiosimulator.commons.emfutils.EMFLoadHelper;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Factory to create closed workload users
 * 
 * @author Steffen Becker, Sebastian Lehrig
 */
public abstract class ClosedWorkloadUserFactory extends AbstractWorkloadUserFactory implements IUserFactory {

    private final String thinkTime;

    public ClosedWorkloadUserFactory(final SimuComModel model, final String thinkTimeSpec, final String usageScenarioURI) {
        this(model, thinkTimeSpec, (UsageScenario) EMFLoadHelper.loadAndResolveEObject(usageScenarioURI));
    }

    public ClosedWorkloadUserFactory(final SimuComModel model, final String thinkTimeSpec,
            final UsageScenario usageScenario) {
        super(model, usageScenario);

        this.thinkTime = thinkTimeSpec;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.usage.IUserFactory#createUser()
     */
    @Override
    public IUser createUser() {
        final IScenarioRunner scenarioRunner = this.createScenarioRunner();
        return new ClosedWorkloadUser(model, "ClosedUser", scenarioRunner, thinkTime, usageStartStopProbes);
    }

    /**
     * Template method filled by the generator. Returns the users behaviour.
     * 
     * @return The behaviour of the users created by this factory
     */
    public abstract IScenarioRunner createScenarioRunner();

}
