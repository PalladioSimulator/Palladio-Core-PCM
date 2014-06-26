package de.uka.ipd.sdq.experimentautomation.application.measurement;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;
import de.uka.ipd.sdq.simulation.ISimulationListener;

public interface IResponseMeasurement extends ISimulationListener {

    public void prepareBookkeeping(ExperimentBookkeeping bookeeping, String[] factorNames);
    
}
