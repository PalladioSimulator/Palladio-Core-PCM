package de.uka.ipd.sdq.experimentautomation.application.tooladapter;

import java.io.File;

import com.jprofiler.api.agent.Controller;

import de.uka.ipd.sdq.simulation.ISimulationListener;

public class JProfilerSimulationListener implements ISimulationListener {

    @Override
    public void simulationStart() {
        File resultFile = new File("W:\\results\\start" + System.currentTimeMillis() + ".jps");
        Controller.saveSnapshot(resultFile);
    }

    @Override
    public void simulationStop() {
        File resultFile = new File("W:\\results\\stop" + System.currentTimeMillis() + ".jps");
        Controller.saveSnapshot(resultFile);
    }

}
