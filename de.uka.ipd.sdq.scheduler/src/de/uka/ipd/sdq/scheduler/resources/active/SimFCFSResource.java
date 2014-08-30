package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;
import java.util.Map.Entry;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

public class SimFCFSResource extends AbstractActiveResource {

    private class ProcessingFinishedEvent extends AbstractSimEventDelegator<ISchedulableProcess> {

        public ProcessingFinishedEvent(final SchedulerModel model) {
            super(model, ProcessingFinishedEvent.class.getName());
        }

        @Override
        public void eventRoutine(final ISchedulableProcess process) {
            final ISchedulableProcess first = process;
            toNow();
            assert MathTools.equalsDouble(0, running_processes.get(first)) : "Remaining demand ("
                    + running_processes.get(first) + ") not zero!";
            running_processes.remove(first);
            processQ.remove(first);
            fireStateChange(processQ.size(), 0);
            fireDemandCompleted(first);
            LoggingWrapper.log("Demand of Process " + first + " finished.");
            scheduleNextEvent();
            first.activate();
        }

    }

    private final ProcessingFinishedEvent processingFinished;
    private final Deque<ISchedulableProcess> processQ = new ArrayDeque<ISchedulableProcess>();
    private final Hashtable<ISchedulableProcess, Double> running_processes = new Hashtable<ISchedulableProcess, Double>();
    private double last_time;

    public SimFCFSResource(final SchedulerModel model, final String name, final String id, final long capacity) {
        super(model, capacity, name, id);
        processingFinished = new ProcessingFinishedEvent(model);
    }

    public void scheduleNextEvent() {
        final ISchedulableProcess first = processQ.peek();
        processingFinished.removeEvent();
        if (first != null) {
            final double time = running_processes.get(first);
            processingFinished.schedule(first, time);
        }
    }

    private void toNow() {
        final double now = getModel().getSimulationControl().getCurrentSimulationTime();
        final double passed_time = now - last_time;
        if (MathTools.less(0, passed_time)) {
            final ISchedulableProcess first = processQ.peek();
            if (first != null) {
                double demand = running_processes.get(first);
                demand -= passed_time;

                // avoid trouble caused by rounding issues
                demand = MathTools.equalsDouble(demand, 0) ? 0.0 : demand;

                assert demand >= 0 : "Remaining demand (" + demand + ") smaller than zero!";

                running_processes.put(first, demand);
            }
        }
        last_time = now;

    }

    @Override
    public void start() {
    }

    @Override
    protected void dequeue(final ISchedulableProcess process) {
    }

    @Override
    protected void doProcessing(final ISchedulableProcess process, final int resourceServiceID, final double demand) {
        toNow();
        LoggingWrapper.log("FCFS: " + process + " demands " + demand);
        running_processes.put(process, demand);
        processQ.add(process);
        fireStateChange(processQ.size(), 0);
        scheduleNextEvent();
        process.passivate();
    }

    @Override
    public double getRemainingDemand(final ISchedulableProcess process) {
        if (!running_processes.contains(process)) {
            return 0.0;
        }
        toNow();
        return running_processes.get(process);
    }

    @Override
    public void updateDemand(final ISchedulableProcess process, final double demand) {
        for (final Entry<ISchedulableProcess, Double> e : running_processes.entrySet()) {
            if (e.getKey().equals(process)) {
                e.setValue(demand);
                break;
            }
        }
        scheduleNextEvent();
    }

    @Override
    protected void enqueue(final ISchedulableProcess process) {
    }

    @Override
    public void stop() {
        // TODO: why are these fields not empty when the simulation stops, although
        // AbstractActiveResource.cleanProcesses()
        // is being called? This should be investigated, and the following cleanup should not be
        // necessary.
        // (this problem has been encountered for a linking resource)
        processQ.clear();
        running_processes.clear();
    }

    @Override
    public void registerProcess(final ISchedulableProcess process) {
    }

    @Override
    public int getQueueLengthFor(final SchedulerEntity schedulerEntity, final int coreID) {
        return this.processQ.size();
    }
}
