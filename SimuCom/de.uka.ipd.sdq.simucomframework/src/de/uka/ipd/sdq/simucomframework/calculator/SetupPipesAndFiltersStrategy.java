package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.apache.log4j.Level;
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

public class SetupPipesAndFiltersStrategy implements ISetupDataSinkStrategy {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(SetupPipesAndFiltersStrategy.class);

	private SimuComModel model;

	public SetupPipesAndFiltersStrategy(SimuComModel model) {
		this.model = model;
	}

	public PipesAndFiltersManager setupDataSink(Calculator calculator, MetaDataInit metaData) {
		// Initialize recorder and Pipes-and-Filters-Manger
		Recorder recorder = new RawRecorder(createWriteStrategy());
		final PipesAndFiltersManager pipeManager = new PipesAndFiltersManager(
				recorder);
		pipeManager.initialize(metaData);

		calculator.addCalculatorListener(new ICalculatorListener() {

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
			if(logger.isEnabledFor(Level.ERROR))
				logger.error("Could not create write strategy.", e);
		} catch (InstantiationException e) {
			if(logger.isEnabledFor(Level.ERROR))
				logger.error("Could not create write strategy.", e);
		} catch (IllegalAccessException e) {
			if(logger.isEnabledFor(Level.ERROR))
				logger.error("Could not create write strategy.", e);
		} catch (ClassNotFoundException e) {
			if(logger.isEnabledFor(Level.ERROR))
				logger.error("Could not create write strategy.", e);
		}
		return null;
	}

}
