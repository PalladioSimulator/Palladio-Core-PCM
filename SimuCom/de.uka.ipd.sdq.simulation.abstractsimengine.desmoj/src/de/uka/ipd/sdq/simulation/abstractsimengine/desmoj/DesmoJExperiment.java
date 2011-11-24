package de.uka.ipd.sdq.simulation.abstractsimengine.desmoj;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractExperiment;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.ExternalEvent;
import desmoj.core.simulator.TimeSpan;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class DesmoJExperiment extends AbstractExperiment {

    private Experiment experiment;
    
    private DesmoJModel desmojModel;

    public DesmoJExperiment(DesmoJModel model) {
        super(model);
        
        this.desmojModel = model;
        this.experiment = new Experiment(model.getConfiguration().getNameExperimentRun());
        this.desmojModel.connectToExperiment(experiment);
        this.experiment.setShowProgressBar(false);
        
        this.scheduleEvent(this.CHECK_EVENT, 1);
    }

    public double getCurrentSimulationTime() {
        return experiment.getSimClock().getTime().getTimeAsDouble();
    }

    public Experiment getExperiment() {
        return this.experiment;
    }

    @Override
    public void scheduleEvent(final IEvent event, final double delay) {
        new ExternalEvent(desmojModel, "StopEvent", false) {
            @Override
            public void eventRoutine() {
                event.run();
            }
        }.schedule(new TimeSpan(delay));
    }

    @Override
    public void startSimulator() {
        this.experiment.start();
    }

    @Override
    public void stopSimulator() {
        // TODO in Desmo-J, "stopped" experiments can be proceeded. Check, if it is here necessary
        // to abort the experiment instead.
        this.experiment.stop();
    }

}
