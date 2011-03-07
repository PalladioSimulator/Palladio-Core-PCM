package de.uka.ipd.sdq.simulation.probespec;

import java.util.Vector;

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
import de.uka.ipd.sdq.simucomframework.calculator.ISetupDataSinkStrategy;
import de.uka.ipd.sdq.simulation.EventSimModel;

public class SetupPipesAndFiltersStrategy implements ISetupDataSinkStrategy {

	private EventSimModel model;
	
	public SetupPipesAndFiltersStrategy(EventSimModel model) {
		this.model = model;
	}
	
	@Override
	public PipesAndFiltersManager setupDataSink(Calculator calculator, MetaDataInit metaData) {
		// Initialize recorder and Pipes-and-Filters-Manger
		Recorder recorder = new RawRecorder(createWriteStrategy());
		final PipesAndFiltersManager pipeManager = new PipesAndFiltersManager(
				recorder);
		pipeManager.initialize(metaData);
		
		calculator.addCalculatorListener(new ICalculatorListener() {
			
			@Override
			public void calculated(Vector<Measure<?, ? extends Quantity>> resultTuple) {
				pipeManager.processData(new PipeData(resultTuple));
			}
		});

		return pipeManager;
	}

	private IRawWriteStrategy createWriteStrategy() {
		try {
			String writeStrategyClass = RecorderExtensionHelper
					.getWriteStrategyClassNameForName(model.getConfiguration()
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
	
}
