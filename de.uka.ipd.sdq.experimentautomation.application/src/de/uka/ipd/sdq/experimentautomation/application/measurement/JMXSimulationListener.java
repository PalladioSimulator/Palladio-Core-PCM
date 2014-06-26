package de.uka.ipd.sdq.experimentautomation.application.measurement;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;

public class JMXSimulationListener implements IResponseMeasurement {

    private ExperimentBookkeeping bookkeeping;
    private List<Long> variationValues;
    private URI variationFolderUri;
    private int pollingPeriod;

    private Timer timer;
    private ThreadMonitor threadMonitor;

    public JMXSimulationListener(ExperimentBookkeeping bookkeeping, List<Long> variationValues, URI variationFolderUri, int pollingPeriod) {
        this.bookkeeping = bookkeeping;
        this.variationValues = variationValues;
        this.variationFolderUri = variationFolderUri;
        this.pollingPeriod = pollingPeriod;
        
        this.timer = new Timer();
        this.threadMonitor = new ThreadMonitor();
    }

    @Override
    public void prepareBookkeeping(ExperimentBookkeeping bookeeping, String[] factorNames) {
        bookkeeping.prepareResultFile(new String[] { "InitialThreads", "MeanThreads", "MaxThreads", "InitialMemory", "MeanMemory", "MaxMemory", "SampleCount" }, factorNames);
    }

    @Override
    public void simulationStart() {
        System.gc();
        threadMonitor.resetStatistics();
        timer.scheduleAtFixedRate(threadMonitor, 50, this.pollingPeriod);
    }

    @Override
    public void simulationStop() {
        threadMonitor.cancel();
        
        String initialThreads = Integer.toString(threadMonitor.getInitialThreadCount());
        String maxThreads = Integer.toString(threadMonitor.getMaxThreadCount());
        String meanThreads = Integer.toString(threadMonitor.getMeanThreadCount());
        
        String initialMemory = Long.toString(threadMonitor.getInitialMemory());
        String maxMemory = Long.toString(threadMonitor.getMaxMemory());
        String meanMemory = Double.toString(threadMonitor.getMeanMemory());
        
        String sampleCount = Integer.toString(threadMonitor.getSampleCount());
        
        String[] factorLevels = new String[variationValues.size()];
        for (int i = 0; i < variationValues.size(); i++) {
            factorLevels[i] = variationValues.get(i).toString();
        }
        bookkeeping.addResult(new String[] { initialThreads, meanThreads, maxThreads, initialMemory, meanMemory, maxMemory, sampleCount}, factorLevels);
    }

    private class ThreadMonitor extends TimerTask {

        private ThreadMXBean threadBean;
        private int initialThreads;
        private int maxThreads;
        private long sumThreads;
        private int countThreads;
        
        private MemoryMXBean memoryBean;
        private long initialMemory;
        private long maxMemory;
        private Mean meanMemory;

        public ThreadMonitor() {
            this.threadBean = ManagementFactory.getThreadMXBean();
            this.memoryBean = ManagementFactory.getMemoryMXBean();
            this.meanMemory  = new Mean();
        }

        @Override
        public void run() {
            // Threads
            int threads = this.threadBean.getThreadCount();
            if (threads > maxThreads)
                maxThreads = threads;
            sumThreads += threads;
            countThreads++;
            
            // Memory
            long memory = this.memoryBean.getHeapMemoryUsage().getUsed();
            if(memory > maxMemory)
                maxMemory = memory;
            meanMemory.increment(memory);
        }

        public void resetStatistics() {
            maxThreads = 0;
            sumThreads = 0;
            countThreads = 0;
            initialThreads = this.threadBean.getThreadCount();
            
            maxMemory = 0;
            meanMemory.clear();
            initialMemory = this.memoryBean.getHeapMemoryUsage().getUsed();
        }

        public int getMeanThreadCount() {
            return (int) (sumThreads / countThreads);
        }

        public int getMaxThreadCount() {
            return maxThreads;
        }

        public int getInitialThreadCount() {
            return initialThreads;
        }

        public int getSampleCount() {
            return countThreads;
        }

        public long getInitialMemory() {
            return initialMemory;
        }

        public long getMaxMemory() {
            return maxMemory;
        }

        public double getMeanMemory() {
            return meanMemory.getResult();
        }
        
    }

}
