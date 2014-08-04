package de.uka.ipd.sdq.scheduler.processes;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface IWaitingProcess {

    public ISchedulableProcess getProcess();

    public long getNumRequested();

}
