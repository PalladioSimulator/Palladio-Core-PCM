package de.uka.ipd.sdq.experimentautomation.application.measurement;

import java.util.List;

import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;

public class SimulationDurationSimulationListener implements IResponseMeasurement {

    private ExperimentBookkeeping bookkeeping;
    
    private List<Long> variationValues;
    
    private long startTime;

    public SimulationDurationSimulationListener(ExperimentBookkeeping bookkeeping, List<Long> variationValues,
            URI variationFolderUri) {
        this.bookkeeping = bookkeeping;
        this.variationValues = variationValues;
    }

    @Override
    public void simulationStart() {
        System.gc();
        startTime = System.nanoTime();
    }

    @Override
    public void simulationStop() {
        // trigger garbage collection
        System.gc();
    	
        long stopTime = System.nanoTime();
        long duration = stopTime - startTime;

        String[] factorLevels = new String[variationValues.size()];
        for (int i = 0; i < variationValues.size(); i++) {
            factorLevels[i] = variationValues.get(i).toString();
        }
        bookkeeping.addResult(new String[] { new Long(duration).toString() }, factorLevels);
    }

    @Override
    public void prepareBookkeeping(ExperimentBookkeeping bookeeping, String[] factorNames) {
        bookkeeping.prepareResultFile(new String[] { "RuntimeNano" }, factorNames);
    }

}
