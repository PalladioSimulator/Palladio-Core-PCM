package de.uka.ipd.sdq.simulation.resources;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simulation.context.Context;

public interface IContextAwareSchedulableProcess extends ISchedulableProcess {

    public Context getContext();

}
