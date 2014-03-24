package de.uka.ipd.sdq.simucomframework.calculator;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.Recorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;

public class SetupRecorderStrategy implements ISetupDataSinkStrategy {

    private final String recorderName;

    public SetupRecorderStrategy(final String recorderName) {
        super();
        this.recorderName = recorderName;
    }

    @Override
    public Recorder setupDataSink(final Calculator calculator, final MetaDataInit metaData) {
        // obtain write strategy from selected recorder extension
        final Recorder recorder = RecorderExtensionHelper.instantiateWriteStrategyForRecorder(
                this.recorderName);
        recorder.initialize(metaData);

        // register recorder at calculator
        calculator.registerMeasurementSourceListener(recorder);

        return recorder;
    }
}
