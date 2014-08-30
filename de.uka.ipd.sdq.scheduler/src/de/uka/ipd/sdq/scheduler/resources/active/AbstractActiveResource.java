package de.uka.ipd.sdq.scheduler.resources.active;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;

public abstract class AbstractActiveResource extends AbstractSimResource implements IActiveResource {

    private static Map<ISchedulableProcess, AbstractActiveResource> currentResourceTable = new ConcurrentHashMap<ISchedulableProcess, AbstractActiveResource>();

    private final List<IActiveResourceStateSensor> observers;

    public AbstractActiveResource(SchedulerModel model, long capacity, String name, String id) {
        super(model, capacity, name, id);
        observers = new ArrayList<IActiveResourceStateSensor>();
    }

    @Override
    public final void process(ISchedulableProcess process, int resourceServiceID,
            Map<String, Serializable> parameterMap, double demand) {
        if (!getModel().getSimulationControl().isRunning()) {
            // Do nothing, but allows calling process to complete
            return;
        }

        AbstractActiveResource last = getLastResource(process);
        if (!this.equals(last)) {
            if (last != null) {
                last.dequeue(process);
            }
            this.enqueue(process);
            setLastResource(process, this);
        }
        if (parameterMap != null && parameterMap.isEmpty()) {
            doProcessing(process, resourceServiceID, demand);
        } else {
            doProcessing(process, resourceServiceID, parameterMap, demand);
        }
    }

    protected abstract void doProcessing(ISchedulableProcess process, int resourceServiceID, double demand);

    protected void doProcessing(ISchedulableProcess process, int resourceServiceID,
            Map<String, Serializable> parameterMap, double demand) {
        throw new RuntimeException(
                "doProcessing has to be overwritten to allow additional Parameters for active Resources");
    }

    protected abstract void enqueue(ISchedulableProcess process);

    protected abstract void dequeue(ISchedulableProcess process);

    private static AbstractActiveResource getLastResource(ISchedulableProcess process) {
        return currentResourceTable.get(process);
    }

    private static void setLastResource(ISchedulableProcess process, AbstractActiveResource resource) {
        if (!currentResourceTable.containsKey(process)) {
            process.addTerminatedObserver(resource);
        }
        currentResourceTable.put(process, resource);
    }

    public static void cleanProcesses() {
        // Activate all waiting processes to yield process completion
        // Synchronization with process() avoids that processes are added after
        // the activation.
        for (ISchedulableProcess process : currentResourceTable.keySet()) {
            if (!process.isFinished()) {
                // TODO: to avoid exceptions at the end of the simulation,
                // these are being caught here. Maybe something can be fixed
                // in the simulation so that the exception does not occur here.
                try {
                    process.activate();
                } catch (IllegalStateException e) {

                }
            }
        }

        // assert that all threads have been terminated.
        assert currentResourceTable.size() == 0;
    }

    @Override
    public void notifyTerminated(ISchedulableProcess simProcess) {
        currentResourceTable.remove(simProcess);
    }

    @Override
    public void addObserver(IActiveResourceStateSensor observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IActiveResourceStateSensor observer) {
        this.observers.remove(observer);
    }

    protected void fireStateChange(long state, int instanceId) {
        for (IActiveResourceStateSensor l : observers) {
            l.update(state, instanceId);
        }
    }

    protected void fireDemandCompleted(ISchedulableProcess simProcess) {
        for (IActiveResourceStateSensor l : observers) {
            l.demandCompleted(simProcess);
        }
    }

}
