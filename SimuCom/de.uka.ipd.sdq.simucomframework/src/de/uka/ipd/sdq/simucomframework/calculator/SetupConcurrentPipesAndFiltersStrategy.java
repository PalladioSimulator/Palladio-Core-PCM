package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.IRawWriteStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.RawRecorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.Recorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorListener;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SetupConcurrentPipesAndFiltersStrategy implements ISetupDataSinkStrategy {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(SetupConcurrentPipesAndFiltersStrategy.class);

	private SimuComModel model;

	public SetupConcurrentPipesAndFiltersStrategy(SimuComModel model) {
		this.model = model;
	}

	public PipesAndFiltersManager setupDataSink(Calculator calculator, MetaDataInit metaData) {
		// Initialize recorder and Pipes-and-Filters-Manger
		Recorder recorder = new RawRecorder(createWriteStrategy());
		final PipesAndFiltersManager pipeManager = new PipesAndFiltersManager(
				recorder);
		pipeManager.initialize(metaData);

		// start thread
		final ProcessPipeData processPipeData = new ProcessPipeData(pipeManager);
		new Thread(processPipeData).start();

		calculator.addCalculatorListener(new ICalculatorListener() {
			public void calculated(Vector<Measure<?, ? extends Quantity>> resultTuple) {
				processPipeData.enqueue(new PipeData(resultTuple));
			}
		});

		return pipeManager;
	}

	private IRawWriteStrategy createWriteStrategy() {
		try {
			String writeStrategyClass = RecorderExtensionHelper
					.getWriteStrategyClassNameForName(model.getConfig()
							.getRecorderName());
			return (IRawWriteStrategy) Class.forName(writeStrategyClass).newInstance();
		} catch (CoreException e) {
			logger.error("Error occured during write strategy creation.", e);
		} catch (InstantiationException e) {
			logger.error("Error occured during write strategy creation.", e);
		} catch (IllegalAccessException e) {
			logger.error("Error occured during write strategy creation.", e);
		} catch (ClassNotFoundException e) {
			logger.error("Error occured during write strategy creation.", e);
		}
		return null;
	}

	private class ProcessPipeData implements Runnable {

		private LinkedBlockingQueue<PipeData> pipeQueue;

		private boolean keepRunning = true;

		private PipesAndFiltersManager pipeManager;

		public ProcessPipeData(PipesAndFiltersManager pipeManager) {
			this.pipeManager = pipeManager;
			pipeQueue = new LinkedBlockingQueue<PipeData>();
		}

		public void run() {
			while(keepRunning) {
				try {
					pipeManager.processData(pipeQueue.take());
				} catch (InterruptedException e) {
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
				logger.error("Could not enqueue data in pipe.", e);
			}
		}

	}
}
