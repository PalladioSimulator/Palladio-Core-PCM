package de.uka.ipd.sdq.simulation.command.usage;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.exceptions.concrete.UnexpectedModelStructureException;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class FindStopOfScenario implements IPCMCommand<Stop> {

    private ScenarioBehaviour behaviour;

    public FindStopOfScenario(UsageScenario scenario) {
        this(scenario.getScenarioBehaviour_UsageScenario());
    }

    public FindStopOfScenario(ScenarioBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public Stop execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (AbstractUserAction a : behaviour.getActions_ScenarioBehaviour()) {
            if (UsagemodelPackage.eINSTANCE.getStop().isInstance(a)) {
                return (Stop) a;
            }
        }
        // this should not happen, as an OCL constraint ensures exactly one stop action
        throw new UnexpectedModelStructureException("Could not find a stop action in "
                + PCMEntityHelper.toString(behaviour));
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
