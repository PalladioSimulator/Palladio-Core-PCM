package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorListener;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

class SetupConcurrentPipesAndFiltersStrategy extends SetupPipesAndFiltersStrategy implements ISetupDataSinkStrategy {

	public SetupConcurrentPipesAndFiltersStrategy(SimuComModel model) {
		super(model);
	}

	/* (non-Javadoc)
     * @see de.uka.ipd.sdq.simucomframework.calculator.SetupPipesAndFiltersStrategy#createCalculatorListener(de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager)
     */
    @Override
    protected ICalculatorListener createCalculatorListener(PipesAndFiltersManager pipeManager) {
        // start thread
        final ProcessPipeData processPipeData = new ProcessPipeData(pipeManager);
        new Thread(processPipeData).start();

        return new ICalculatorListener() {
            public void calculated(Vector<Measure<?, ? extends Quantity>> resultTuple) {
                processPipeData.enqueue(new PipeData(resultTuple));
            }
        };
    }

	private class ProcessPipeData implements Runnable {
	    
	    private final Logger logger = Logger.getLogger(ProcessPipeData.class);

		private final LinkedBlockingQueue<PipeData> pipeQueue;

		private volatile boolean keepRunning = true;

		private final PipesAndFiltersManager pipeManager;

		public ProcessPipeData(PipesAndFiltersManager pipeManager) {
		    super();
		    
			this.pipeManager = pipeManager;
			pipeQueue = new LinkedBlockingQueue<PipeData>();
		}

		public void run() {
			while(keepRunning) {
				try {
					pipeManager.processData(pipeQueue.take());
				} catch (InterruptedException e) {
					if(logger.isEnabledFor(Level.ERROR))
						logger.error("Could not process data in the pipe.", e);
				}
			}
		}

		public void stop() {
			keepRunning = false;
		}

		public void enqueue(PipeData data) {
			try {
				pipeQueue.put(data);
			} catch (InterruptedException e) {
				if(logger.isEnabledFor(Level.ERROR))
					logger.error("Could not enqueue data in pipe.", e);
			}
		}

	}
}
