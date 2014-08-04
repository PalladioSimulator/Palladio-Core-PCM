package de.uka.ipd.sdq.scheduler.resources.active.special;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.NullEntity;

/**
 * This class is for testing purposes only. It is used for the MASCOTS paper case study.
 * 
 * @author hauck
 *
 */
public class SimProcessorSharingResourceLinuxO1 extends AbstractActiveResource {

    private static final Logger LOGGER = Logger.getLogger(SimProcessorSharingResourceLinuxO1.class);

    private class DoLoadBalancingEvent extends AbstractSimEventDelegator<NullEntity> {

        public DoLoadBalancingEvent(final SchedulerModel model) {
            super(model, SimProcessorSharingResourceLinuxO1.class.getName());
        }

        @Override
        public void eventRoutine(final NullEntity who) {
            // LOGGER.info(simulator.time() + ": Trying load balancing...");
            final int coreToBalanceTo = getCoreWithShortestQueue();
            final int coreToBalanceFrom = getCoreWithLongestQueue();
            if ((running_processesPerCore.get(coreToBalanceFrom).size() - running_processesPerCore.get(coreToBalanceTo)
                    .size()) > 1) {
                // We have two cores that have a running queue length difference greater than 1. Do
                // load balancing.

                // select a random process from the sender core
                final Hashtable<ISchedulableProcess, Double> runningProcesses = running_processesPerCore
                        .get(coreToBalanceFrom);
                final ISchedulableProcess[] processes = runningProcesses.keySet().toArray(new ISchedulableProcess[] {});

                // move random process from sender core to idle core
                final Random random = new Random();
                final ISchedulableProcess processToBalance = processes[random.nextInt(processes.length)];
                final double simTime = getModel().getSimulationControl().getCurrentSimulationTime();
                if (LOGGER.isEnabledFor(Level.INFO)) {
                    LOGGER.info(simTime + ": Balancing process: " + processToBalance.getId() + " from core "
                            + coreToBalanceFrom + " to " + coreToBalanceTo);
                }
                final Double processValue = runningProcesses.get(processToBalance);
                runningProcesses.remove(processToBalance);
                putProcessOnCore(processToBalance, processValue, coreToBalanceTo);

            } else {
                // LOGGER.info(simulator.time() + ": No load balancing needed.");
            }

        }

    }

    private class ProcessingFinishedEvent extends AbstractSimEventDelegator<ISchedulableProcess> {

        public ProcessingFinishedEvent(final SchedulerModel model) {
            super(model, ProcessingFinishedEvent.class.getName());
        }

        @Override
        public void eventRoutine(final ISchedulableProcess process) {
            final ISchedulableProcess last = process;
            toNow();
            // NEW
            final int core = getCoreOfARunningProcess(last);
            running_processesPerCore.get(core).remove(last);
            // running_processes.remove(last);
            // TODO: now, we have to check, if we have to perform load
            // balancing.
            // And probably re-calculate times?

            // suggestion:
            if (running_processesPerCore.get(core).size() == 0) {
                final int coreToBalanceFrom = getCoreWithLongestQueue();
                if (running_processesPerCore.get(coreToBalanceFrom).size() <= 1) {
                    // all cores are idle or have no contention
                } else {
                    // Try load balancing one time unit from now
                    final DoLoadBalancingEvent event = new DoLoadBalancingEvent(
                            SimProcessorSharingResourceLinuxO1.this.getModel());
                    final double simTime = getModel().getSimulationControl().getCurrentSimulationTime();
                    event.schedule(IEntity.NULL, simTime + 1);
                }
            }
            // LOGGER.info(simulator.time() + ": " + last.getId() + " finished");
            // LoggingWrapper.log(last + " finished.");
            scheduleNextEvent();
            last.activate();
        }

    }

    private final ProcessingFinishedEvent processingFinished = new ProcessingFinishedEvent(null);
    private final ArrayList<Hashtable<ISchedulableProcess, Double>> running_processesPerCore = new ArrayList<Hashtable<ISchedulableProcess, Double>>();
    // private Hashtable<ISchedulableProcess,Double> running_processes = new
    // Hashtable<ISchedulableProcess, Double>();
    private double last_time;
    private long coreToUseForInitialLoadBalancing = 0;

    public SimProcessorSharingResourceLinuxO1(final SchedulerModel model, final String name, final String id,
            final Long numberOfCores) {
        super(model, numberOfCores, name, id);
        for (long j = 0; j < numberOfCores; j++) {
            running_processesPerCore.add(new Hashtable<ISchedulableProcess, Double>());
        }
    }

    public void scheduleNextEvent() {
        /**
         * New: look in all queues, i.e. in all nested running_processes hashtables, which process
         * is to be scheduled next.
         */
        ISchedulableProcess shortest = null;
        Double shortestTime = 0.0;
        for (final Hashtable<ISchedulableProcess, Double> running_processes : running_processesPerCore) {
            for (final ISchedulableProcess process : running_processes.keySet()) {
                // LOGGER.info("Time: " + simulator.time() + ", looking for shortest time: " +
                // process.getId() + " time: " + running_processes.get(process) + ", speed: " +
                // getSpeed(process));
                if (shortest == null || shortestTime > running_processes.get(process) * getSpeed(process)) {
                    shortest = process;
                    shortestTime = running_processes.get(process) * getSpeed(process);
                    // LOGGER.info("Shortest: " + shortest.getId() + ", shortest time: " +
                    // shortestTime);
                }
            }
        }

        processingFinished.removeEvent();
        if (shortest != null) {
            // New: calculate time for process
            double time = shortestTime;// * getSpeed(shortest);
            // double time = running_processes.get(shortest) * getSpeed();
            // LOGGER.info("Time: " + simulator.time() + ", scheduling event at " + time);
            if (!MathTools.less(0, time)) {
                time = 0.0;
            }
            processingFinished.schedule(shortest, time);
        }
    }

    private int getCoreOfARunningProcess(final ISchedulableProcess process) {
        for (int i = 0; i < running_processesPerCore.size(); i++) {
            final Hashtable<ISchedulableProcess, Double> running_processes = running_processesPerCore.get(i);
            if (running_processes.containsKey(process)) {
                return i;
            }
        }
        LoggingWrapper.LOGGER.warn("Core of process not found. Returning core 0.");
        return 0;
    }

    private int getCoreWithLongestQueue() {
        int coreWithLongestQueue = 0;
        int queueSize = 0;
        for (int i = 0; i < running_processesPerCore.size(); i++) {
            if (running_processesPerCore.get(i).size() > queueSize) {
                queueSize = running_processesPerCore.get(i).size();
                coreWithLongestQueue = i;
            }
        }
        return coreWithLongestQueue;
    }

    private int getCoreWithShortestQueue() {
        int coreWithShortestQueue = -1;
        int queueSize = 0;
        for (int i = 0; i < running_processesPerCore.size(); i++) {
            if (coreWithShortestQueue == -1) {
                queueSize = running_processesPerCore.get(i).size();
                coreWithShortestQueue = i;
            } else {
                if (running_processesPerCore.get(i).size() < queueSize) {
                    queueSize = running_processesPerCore.get(i).size();
                    coreWithShortestQueue = i;
                }
            }
        }
        return coreWithShortestQueue;
    }

    private void toNow() {
        final double now = getModel().getSimulationControl().getCurrentSimulationTime();
        final double passed_time = now - last_time;
        // LOGGER.info("toNow: " + now + " - " + last_time + " = " +
        // passed_time);
        if (MathTools.less(0, passed_time)) {
            // passed_time /= getSpeed();
            // NEW
            for (final Hashtable<ISchedulableProcess, Double> running_processes : running_processesPerCore) {
                for (final Entry<ISchedulableProcess, Double> e : running_processes.entrySet()) {
                    final double processPassedTime = passed_time / getSpeed(e.getKey());
                    final double rem = e.getValue() - processPassedTime;
                    // LOGGER.info("toNow " + e.getKey().getId() + ": " +
                    // e.getValue() + " - " + processPassedTime + " = " + rem);
                    e.setValue(rem);
                }
            }
        }
        last_time = now;
    }

    @Override
    public double getRemainingDemand(final ISchedulableProcess process) {
        boolean hasDemand = false;
        for (final Hashtable<ISchedulableProcess, Double> running_processes : running_processesPerCore) {
            if (running_processes.containsKey(process)) {
                hasDemand = true;
                break;
            }
        }
        if (hasDemand == false) {
            return 0.0;
        }
        toNow();
        for (final Hashtable<ISchedulableProcess, Double> running_processes : running_processesPerCore) {
            if (!running_processes.contains(process)) {
                return running_processes.get(process);
            }
        }
        // Should not be reached.
        return 0.0;
    }

    @Override
    public void updateDemand(final ISchedulableProcess process, final double demand) {
        for (final Hashtable<ISchedulableProcess, Double> running_processes : running_processesPerCore) {
            for (final Entry<ISchedulableProcess, Double> e : running_processes.entrySet()) {
                if (e.getKey().equals(process)) {
                    e.setValue(demand);
                    break;
                }
            }
        }
        scheduleNextEvent();
    }

    // New: calculate speed for a process.
    private double getSpeed(final ISchedulableProcess process) {
        final int core = getCoreOfARunningProcess(process);
        final double speed = running_processesPerCore.get(core).size();
        // double speed = (double)running_processes.size() /
        // (double)getCapacity();

        // comparison here is unnecessary, speed cannot be lower than 1. Keep it
        // anyway.
        return speed < 1.0 ? 1.0 : speed;
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
        LoggingWrapper.log("PS: " + process + " demands " + demand);
        // LOGGER.info("PS: " + process.getId() + " demands " + demand);

        final long coreToPutOn = getLastCoreProcessWasRunningOn(process);
        if (coreToPutOn == -1) {
            // This is a new process which has issued demand for the first time.
            // Same as parent: always use core 0. Check if load balancing has to be done afterwards.
            // If there are tasks running on core 0, use a random core.
            coreToUseForInitialLoadBalancing = 0l;
            if (running_processesPerCore.get((int) coreToUseForInitialLoadBalancing).size() > 0) {
                coreToUseForInitialLoadBalancing = nextLong(new Random(), getCapacity());
            }
            putProcessOnCore(process, demand, coreToUseForInitialLoadBalancing);
            // running_processes.put(process, demand);
            final int coreToBalanceFrom = getCoreWithLongestQueue();
            if (running_processesPerCore.get(coreToBalanceFrom).size() <= 1) {
                // all cores are idle or have no contention
            } else {
                // Try load balancing one time unit from now
                final DoLoadBalancingEvent event = new DoLoadBalancingEvent(getModel());
                final double simTime = getModel().getSimulationControl().getCurrentSimulationTime();
                event.schedule(IEntity.NULL, simTime + 1);
            }
        } else {
            putProcessOnCore(process, demand, coreToPutOn);
            // running_processesPerCore.get(coreToPutOn).put(process, demand);
        }

        // I don't know if this is right here.
        // I call toNow() again to update all processes (some processes might
        // now share the core with the new process)
        toNow();
        scheduleNextEvent();
        process.passivate();
    }

    /**
     * @see http://stackoverflow.com/questions/2546078/java-random-long-number-in-0-x-n-range
     */
    private long nextLong(final Random rng, final long n) {
        // error checking and 2^x checking removed for simplicity.
        long bits, val;
        do {
            bits = (rng.nextLong() << 1) >>> 1;
            val = bits % n;
        } while (bits - val + (n - 1) < 0L);
        return val;
    }

    @Override
    protected void enqueue(final ISchedulableProcess process) {
    }

    @Override
    public void stop() {

    }

    @Override
    public void registerProcess(final ISchedulableProcess process) {
    }

    @Override
    public int getQueueLengthFor(final SchedulerEntity schedulerEntity, final int coreID) {
        return this.running_processesPerCore.get(coreID).size();
    }

    private final Hashtable<ISchedulableProcess, Long> all_processes = new Hashtable<ISchedulableProcess, Long>();

    /**
     * return -1 if a process was not running before, i.e. is a new process.
     * 
     * @param process
     * @return
     */
    private long getLastCoreProcessWasRunningOn(final ISchedulableProcess process) {
        if (all_processes.containsKey(process)) {
            return all_processes.get(process);
        }
        return -1;
    }

    private void putProcessOnCore(final ISchedulableProcess process, final double demand, final long core) {
        if (all_processes.containsKey(process)) {
            all_processes.remove(process);
        }
        all_processes.put(process, core);
        // LOGGER.info(simulator.time() + ": Putting " + process.getId() + " with demand " + demand
        // + " on core " + core);
        running_processesPerCore.get((int) core).put(process, demand);
    }

}
