package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.apache.log4j.Logger;

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

	public SetupPipesAndFiltersStrategy(final SimuComModel model) {
	    this.model = model;
	}

    public PipesAndFiltersManager setupDataSink(Calculator calculator, MetaDataInit metaData) {
        // obtain write strategy from selected recorder extension
        IRawWriteStrategy writeStrategy = RecorderExtensionHelper.instantiateWriteStrategyForRecorder(
                model.getConfiguration().getRecorderName());
        
		Recorder recorder = new RawRecorder(writeStrategy);
		final PipesAndFiltersManager pipeManager = new PipesAndFiltersManager(recorder);
		pipeManager.initialize(metaData);

		calculator.addCalculatorListener(createCalculatorListener(pipeManager));

		return pipeManager;
	}

    /** Create the calculator listener used to receive calculator events. The returned calculator listener
     * has to hand over received data to its pipe and filter structure.
     * 
     * @param pipeManager
     * @return
     */
    protected ICalculatorListener createCalculatorListener(final PipesAndFiltersManager pipeManager) {
        return new ICalculatorListener() {

			public void calculated(List<Measure<?, ? extends Quantity>> resultTuple) {
				pipeManager.processData(new PipeData(resultTuple));
			}
		};
    }

}
