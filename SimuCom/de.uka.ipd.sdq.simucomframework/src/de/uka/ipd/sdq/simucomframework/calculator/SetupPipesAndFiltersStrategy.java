package de.uka.ipd.sdq.simucomframework.calculator;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.Recorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SetupPipesAndFiltersStrategy implements ISetupDataSinkStrategy {

    /** Logger for this class. */
	private static final Logger logger = Logger.getLogger(SetupPipesAndFiltersStrategy.class);

	private final SimuComModel model;

	public SetupPipesAndFiltersStrategy(final SimuComModel model) {
	    this.model = model;
	}

    @Override
	public Recorder setupDataSink(Calculator calculator, MetaDataInit metaData) {
        // obtain write strategy from selected recorder extension
    	// TODO that's an evil cast. Make the used extension point better fitting for recorders...
        final Recorder recorder = (Recorder) RecorderExtensionHelper.instantiateWriteStrategyForRecorder(
                model.getConfiguration().getRecorderName());
        recorder.initialize(metaData);
        
        // register recorder at calculator
		calculator.registerCalculatorListener(recorder);
		
		return recorder;
	}
}
