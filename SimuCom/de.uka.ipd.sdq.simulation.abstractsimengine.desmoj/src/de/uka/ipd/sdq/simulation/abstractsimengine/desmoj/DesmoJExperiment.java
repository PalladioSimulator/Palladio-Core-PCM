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

    private Experiment experiment;
    
    private DesmoJModel desmojModel;

    public DesmoJExperiment(DesmoJModel model) {
        super(model);
        
        this.desmojModel = model;
        this.experiment = new Experiment(model.getConfiguration().getNameExperimentRun(),
        		TimeUnit.NANOSECONDS, 
        		TimeUnit.SECONDS, 
        		new SingleUnitTimeFormatter(TimeUnit.SECONDS, TimeUnit.NANOSECONDS, 9, false));
        this.desmojModel.connectToExperiment(experiment);
        this.experiment.setShowProgressBar(false);
    }

    public double getCurrentSimulationTime() {
        return experiment.getSimClock().getTime().getTimeAsDouble();
    }

    public Experiment getExperiment() {
        return this.experiment;
    }

//    @Override
//    public void scheduleEvent(final IEvent event, final double delay) {
//        new ExternalEvent(desmojModel, "StopEvent", false) {
//            @Override
//            public void eventRoutine() {
//                event.run();
//            }
//        }.schedule(new TimeSpan(delay));
//    }

    @Override
    public void startSimulator() {
    	//this.experiment.getSimClock().addObserver(this.timeProgressObserver);
        this.experiment.stop(new ModelCondition(this.desmojModel,"Stop Cond Check",false) {
			
			@Override
			public boolean check() {
				boolean stop = checkStopConditions();
				if (stop){
					stop();
				}
				return stop; 
			}
		});
        this.experiment.start();
    }

    @Override
    public void stopSimulator() {
        // TODO in Desmo-J, "stopped" experiments can be proceeded. Check, if it is here necessary
        // to abort the experiment instead.
        this.experiment.stop();
        //this.experiment.getSimClock().deleteObserver(this.timeProgressObserver);
    }

}
