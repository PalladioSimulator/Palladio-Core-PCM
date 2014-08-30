package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface IDemandListener {

    public void demand(double demand);

    public void demandCompleted(ISchedulableProcess simProcess);

}
