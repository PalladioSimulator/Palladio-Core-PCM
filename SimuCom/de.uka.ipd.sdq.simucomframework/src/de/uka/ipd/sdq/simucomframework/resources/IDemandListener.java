package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface IDemandListener {

    public void demand(final double demand);

    public void demandCompleted(final ISchedulableProcess simProcess);

}
