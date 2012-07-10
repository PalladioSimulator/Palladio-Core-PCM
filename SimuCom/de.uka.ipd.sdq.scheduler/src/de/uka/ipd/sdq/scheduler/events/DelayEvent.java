package de.uka.ipd.sdq.scheduler.events;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

public class DelayEvent extends AbstractSimEventDelegator<ISchedulableProcess> {
	
	public DelayEvent(SchedulerModel model) {
		super(model, "DelayEvent");
	}

    @Override
    public void eventRoutine(ISchedulableProcess process) {
        process.activate();
    }

}
