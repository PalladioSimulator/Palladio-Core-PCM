package org.palladiosimulator.protocom.framework.usage;

import org.palladiosimulator.protocom.framework.utils.RunProperties;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;

/**
 * Abstract class for running closed workload users.
 * 
 * This class represents a single user.
 * 
 * @author Steffen, martens
 *
 */
public abstract class AbstractClosedScenarioThread extends AbstractScenarioThread {

    protected final Runnable usageScenario;

    public AbstractClosedScenarioThread(Experiment exp, ExperimentRun expRun, String scenarioName,
            RunProperties runProps) {
        super(exp, expRun, scenarioName, runProps);

        this.usageScenario = getScenarioRunner(runProps);
    }

    @Override
    protected void runAndMeasureUsageScenarioIteration() {
        long start = System.nanoTime();
        usageScenario.run();
        takeScenarioMeasurement(start);
    }

}
