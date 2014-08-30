package de.uka.ipd.sdq.simulation.abstractsimengine.desmoj;

import java.util.concurrent.TimeUnit;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractExperiment;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.ModelCondition;
import desmoj.core.simulator.SingleUnitTimeFormatter;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class DesmoJExperiment extends AbstractExperiment {

    private final Experiment experiment;

    private final DesmoJModel desmojModel;

    public DesmoJExperiment(final DesmoJModel model) {
        super(model);

        this.desmojModel = model;
        this.experiment = new Experiment(model.getConfiguration().getNameExperimentRun(), TimeUnit.NANOSECONDS,
                TimeUnit.SECONDS, new SingleUnitTimeFormatter(TimeUnit.SECONDS, TimeUnit.NANOSECONDS, 9, false));
        this.desmojModel.connectToExperiment(experiment);
        this.experiment.setShowProgressBar(false);
    }

    @Override
    public double getCurrentSimulationTime() {
        return experiment.getSimClock().getTime().getTimeAsDouble();
    }

    public Experiment getExperiment() {
        return this.experiment;
    }

    @Override
    public void startSimulator() {
        this.experiment.stop(new ModelCondition(this.desmojModel, "Stop Cond Check", false) {

            @Override
            public boolean check() {
                return checkStopConditions();
            }
        });
        this.experiment.start();
        // This line ensures cleanup as Desmo-J does not call stop on its own as it seems...
        super.stop();
    }

    @Override
    public void stopSimulator() {
        // TODO in Desmo-J, "stopped" experiments can be proceeded. Check, if it is here necessary
        // to abort the experiment instead.
        this.experiment.stop();
        // this.experiment.getSimClock().deleteObserver(this.timeProgressObserver);
    }

}
