package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.probeframework.calculator.Calculator;
import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.probeframework.probes.Probe;
import org.palladiosimulator.recorderframework.IRecorder;
import org.palladiosimulator.recorderframework.config.AbstractRecorderConfiguration;
import org.palladiosimulator.recorderframework.launch.IRecorderConfiguration;
import org.palladiosimulator.recorderframework.launch.RecorderExtensionHelper;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * Factory class to create @see {@link Calculator}s used in a SimuCom simulation run.
 * 
 * @author Steffen Becker, Philipp Merkle, Sebastian Lehrig
 */
public class RecorderAttachingCalculatorFactoryDecorator implements ICalculatorFactory {
    /**
     * SimuCom model which is simulated
     */
    private final SimuComConfig configuration;

    /**
     * Cached name of the experiment run's name
     */
    private final String experimentRunName;

    private final ICalculatorFactory decoratedCalculatorFactory;

    /** Default EMF factory for measuring points. */
    private final MeasuringpointFactory measuringpointFactory = MeasuringpointFactory.eINSTANCE;

    public RecorderAttachingCalculatorFactoryDecorator(final ICalculatorFactory decoratedCalculatorFactory,
            final SimuComConfig configuration) {
        super();

        this.decoratedCalculatorFactory = decoratedCalculatorFactory;
        this.experimentRunName = "Run " + new Date();
        this.configuration = configuration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildResponseTimeCalculator(final MeasuringPoint measuringPoint, final List<Probe> probes) {
        return setupRecorder(decoratedCalculatorFactory.buildResponseTimeCalculator(measuringPoint, probes));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildDemandBasedWaitingTimeCalculator(final MeasuringPoint measuringPoint,
            final List<Probe> probes) {
        return setupRecorder(decoratedCalculatorFactory.buildDemandBasedWaitingTimeCalculator(measuringPoint, probes));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildWaitingTimeCalculator(final MeasuringPoint measuringPoint, final List<Probe> probes) {
        return setupRecorder(decoratedCalculatorFactory.buildWaitingTimeCalculator(measuringPoint, probes));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildHoldingTimeCalculator(final MeasuringPoint measuringPoint, final List<Probe> probes) {
        return setupRecorder(decoratedCalculatorFactory.buildHoldingTimeCalculator(measuringPoint, probes));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildStateOfActiveResourceCalculator(final MeasuringPoint measuringPoint, final Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildStateOfActiveResourceCalculator(measuringPoint, probe));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildOverallStateOfActiveResourceCalculator(final MeasuringPoint measuringPoint, final Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildOverallStateOfActiveResourceCalculator(measuringPoint,
                probe));
    }

    @Override
    public Calculator buildStateOfPassiveResourceCalculator(MeasuringPoint measuringPoint, Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildStateOfPassiveResourceCalculator(measuringPoint, probe));
    }

    @Override
    public Calculator buildOverallStateOfPassiveResourceCalculator(MeasuringPoint measuringPoint, Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildOverallStateOfPassiveResourceCalculator(measuringPoint,
                probe));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildResourceDemandCalculator(final MeasuringPoint measuringPoint, final Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildResourceDemandCalculator(measuringPoint, probe));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildExecutionResultCalculator(final MeasuringPoint measuringPoint, final Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildExecutionResultCalculator(measuringPoint, probe));
    }

    private Calculator setupRecorder(final Calculator calculator) {
        final Map<String, Object> recorderConfigurationMap = new HashMap<String, Object>();
        recorderConfigurationMap.put(AbstractRecorderConfiguration.RECORDER_ACCEPTED_METRIC,
                calculator.getMetricDesciption());
        recorderConfigurationMap.put(AbstractRecorderConfiguration.MEASURING_POINT, calculator.getMeasuringPoint());

        final IRecorder recorder = RecorderExtensionHelper.instantiateRecorderImplementationForRecorder(this.configuration
                .getRecorderName());
        final IRecorderConfiguration recorderConfiguration = this.configuration.getRecorderConfigurationFactory()
                .createRecorderConfiguration(recorderConfigurationMap);
        recorder.initialize(recorderConfiguration);
        // register recorder at calculator
        calculator.addObserver(recorder);

        return calculator;
    }
}
