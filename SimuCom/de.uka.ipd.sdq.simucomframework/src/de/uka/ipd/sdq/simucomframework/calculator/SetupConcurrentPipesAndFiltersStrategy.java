package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

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

	private SimuComModel model;
	
	public SetupConcurrentPipesAndFiltersStrategy(SimuComModel model) {
		this.model = model;
	}
	
	@Override
	public void setupDataSink(Calculator calculator, MetaDataInit metaData) {
		// Initialize recorder and Pipes-and-Filters-Manger
		Recorder recorder = new RawRecorder(createWriteStrategy());
		final PipesAndFiltersManager pipeManager = new PipesAndFiltersManager(
				recorder);
		pipeManager.initialize(metaData);
		
		// start thread
		final ProcessPipeData processPipeData = new ProcessPipeData(pipeManager);
		new Thread(processPipeData).start();
		
		calculator.addCalculatorListener(new ICalculatorListener() {
			@Override
			public void calculated(Vector<Measure<?, ? extends Quantity>> resultTuple) {
				processPipeData.enqueue(new PipeData(resultTuple));
			}
		});

	}

	private IRawWriteStrategy createWriteStrategy() {
		try {
			String writeStrategyClass = RecorderExtensionHelper
					.getWriteStrategyClassNameForName(model.getConfig()
							.getRecorderName());
			return (IRawWriteStrategy) Class.forName(writeStrategyClass).newInstance(); 
		} catch (CoreException e) {
			// TODO Handle exception
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		@Override
		public void run() {
			while(keepRunning) {
				try {
					pipeManager.processData(pipeQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
