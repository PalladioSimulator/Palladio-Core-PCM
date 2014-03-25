package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.Hashtable;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

public class SimDelayResource extends AbstractActiveResource {

    // Contains all running processes on the resource (key: process ID)
    private final Hashtable<String,ISchedulableProcess> running_processes = new Hashtable<String, ISchedulableProcess>();

    public SimDelayResource(final SchedulerModel model, final String name, final String id) {
        super(model, -1l, name, id);
    }


    @Override
    public void start() {
        running_processes.clear();
    }

    private class DelayEvent extends AbstractSimEventDelegator<ISchedulableProcess> {

        public DelayEvent(final SchedulerModel model) {
            super(model, "DelayEvent");
        }

        @Override
        public void eventRoutine(final ISchedulableProcess process) {
            dequeue(process);
        }

    }

    @Override
    protected void dequeue(final ISchedulableProcess process) {
        if (!running_processes.containsKey(process.getId())) {
            return;
        }
        running_processes.remove(process.getId());
        fireStateChange(running_processes.size(), 0);
        fireDemandCompleted(process);
        process.activate();
    }

    @Override
    protected void doProcessing(final ISchedulableProcess process, final int resourceServiceId, final double demand) {
        LoggingWrapper.log("Delay: " + process + " demands " + demand);
        if (!running_processes.containsKey(process.getId())) {
            enqueue(process);
        }
        new DelayEvent(getModel()).schedule(process, demand);
        process.passivate();
    }

    @Override
    public double getRemainingDemand(final ISchedulableProcess process) {
        throw new UnsupportedOperationException("getRemainingDemand() not yet supported!");
    }

    @Override
    public void updateDemand(final ISchedulableProcess process, final double demand) {
        throw new UnsupportedOperationException("updateDemand() not yet supported!");
    }

    @Override
    protected void enqueue(final ISchedulableProcess process) {
        running_processes.put(process.getId(), process);
        fireStateChange(running_processes.size(), 0);
    }


    @Override
    public void stop() {
        running_processes.clear();
    }

    @Override
    public void registerProcess(final ISchedulableProcess process) {

    }


    @Override
    public int getQueueLengthFor(final SchedulerEntity schedulerEntity, final int coreID) {
        return running_processes.size();
    }


}
