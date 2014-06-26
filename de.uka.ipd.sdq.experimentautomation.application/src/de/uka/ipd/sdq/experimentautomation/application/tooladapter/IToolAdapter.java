package de.uka.ipd.sdq.experimentautomation.application.tooladapter;

import java.util.List;

import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.simulation.ISimulationListener;

public interface IToolAdapter {

    public void runExperiment(String experimentName, PCMModelFiles model, ToolConfiguration configuration,
            List<StopCondition> stopConditions, ISimulationListener listener) throws Exception;

}
