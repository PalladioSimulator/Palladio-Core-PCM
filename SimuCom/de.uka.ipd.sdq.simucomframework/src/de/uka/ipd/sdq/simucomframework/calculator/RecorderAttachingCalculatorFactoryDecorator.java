package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.probeframework.ProbeFrameworkContext;
import org.palladiosimulator.probeframework.calculator.Calculator;
import org.palladiosimulator.probeframework.calculator.ICalculatorFactory;
import org.palladiosimulator.probeframework.probes.Probe;
import org.palladiosimulator.recorderspec.AbstractRecorderConfiguration;
import org.palladiosimulator.recorderspec.Recorder;
import org.palladiosimulator.recorderspec.launch.IRecorderConfiguration;
import org.palladiosimulator.recorderspec.launch.RecorderExtensionHelper;

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

    public RecorderAttachingCalculatorFactoryDecorator(final ICalculatorFactory decoratedCalculatorFactory, final SimuComConfig configuration) {
        super();

        this.decoratedCalculatorFactory = decoratedCalculatorFactory;
        this.experimentRunName = "Run " + new Date();
        this.configuration = configuration;
    }

    /**
     * @param calculatorName
     * @param probes
     * @return
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#buildResponseTimeCalculator(java.lang.String, java.util.List)
     */
    @Override
    public Calculator buildResponseTimeCalculator(final String calculatorName, final List<Probe> probes) {
        return setupRecorder("Response time of "+calculatorName,decoratedCalculatorFactory.buildResponseTimeCalculator(calculatorName, probes));
    }

    /**
     * @param calculatorName
     * @param probes
     * @return
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#buildDemandBasedWaitingTimeCalculator(java.lang.String, java.util.List)
     */
    @Override
    public Calculator buildDemandBasedWaitingTimeCalculator(final String calculatorName, final List<Probe> probes) {
        return setupRecorder("Demand at "+calculatorName,decoratedCalculatorFactory.buildDemandBasedWaitingTimeCalculator(calculatorName, probes));
    }

    /**
     * @param calculatorName
     * @param probes
     * @return
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#buildWaitingTimeCalculator(java.lang.String, java.util.List)
     */
    @Override
    public Calculator buildWaitingTimeCalculator(final String calculatorName, final List<Probe> probes) {
        return setupRecorder("Waiting time at "+calculatorName,decoratedCalculatorFactory.buildWaitingTimeCalculator(calculatorName, probes));
    }

    /**
     * @param calculatorName
     * @param probes
     * @return
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#buildHoldTimeCalculator(java.lang.String, java.util.List)
     */
    @Override
    public Calculator buildHoldTimeCalculator(final String calculatorName, final List<Probe> probes) {
        return setupRecorder("Hold time at "+calculatorName,decoratedCalculatorFactory.buildHoldTimeCalculator(calculatorName, probes));
    }

    /**
     * @param calculatorName
     * @param probe
     * @return
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#buildStateCalculator(java.lang.String, org.palladiosimulator.probeframework.probes.Probe)
     */
    @Override
    public Calculator buildStateCalculator(final String calculatorName, final Probe probe) {
        return setupRecorder("State of "+calculatorName,decoratedCalculatorFactory.buildStateCalculator(calculatorName, probe));
    }

    /**
     * @param calculatorName
     * @param probe
     * @return
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#buildOverallUtilizationCalculator(java.lang.String, org.palladiosimulator.probeframework.probes.Probe)
     */
    @Override
    public Calculator buildOverallUtilizationCalculator(final String calculatorName, final Probe probe) {
        return setupRecorder("Utilisation of "+calculatorName,decoratedCalculatorFactory.buildOverallUtilizationCalculator(calculatorName, probe));
    }

    /**
     * @param calculatorName
     * @param probe
     * @return
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#buildDemandCalculator(java.lang.String, org.palladiosimulator.probeframework.probes.Probe)
     */
    @Override
    public Calculator buildDemandCalculator(final String calculatorName, final Probe probe) {
        return setupRecorder("Demand at "+calculatorName,decoratedCalculatorFactory.buildDemandCalculator(calculatorName, probe));
    }

    /**
     * @param calculatorName
     * @param probe
     * @return
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#buildExecutionResultCalculator(java.lang.String, org.palladiosimulator.probeframework.probes.Probe)
     */
    @Override
    public Calculator buildExecutionResultCalculator(final String calculatorName, final Probe probe) {
        return setupRecorder(calculatorName,decoratedCalculatorFactory.buildExecutionResultCalculator(calculatorName, probe));
    }
    
    @Override
    public Calculator buildIdentityCalculator(String calculatorName, Probe probe) {
        return setupRecorder(calculatorName, decoratedCalculatorFactory.buildIdentityCalculator(calculatorName, probe));
    }

    /**
     * @param probeFrameworkContext
     * @see org.palladiosimulator.probeframework.calculator.ICalculatorFactory#setProbeFrameworkContext(org.palladiosimulator.probeframework.ProbeFrameworkContext)
     */
    @Override
    public void setProbeFrameworkContext(final ProbeFrameworkContext probeFrameworkContext) {
        decoratedCalculatorFactory.setProbeFrameworkContext(probeFrameworkContext);
    }

    /**
     * @param calculator
     * @return
     */
    private Calculator setupRecorder(
            final String calculatorName,
            final Calculator calculator) {
        final Map<String, Object> recorderConfigurationMap = new HashMap<String,Object>();
        recorderConfigurationMap.put(AbstractRecorderConfiguration.RECORDER_ACCEPTED_METRIC, calculator.getMetricDesciption());
        recorderConfigurationMap.put(AbstractRecorderConfiguration.MEASURED_ELEMENT_DESCRIPTION, calculatorName);

        final Recorder recorder = RecorderExtensionHelper.instantiateWriteStrategyForRecorder(this.configuration.getRecorderName());
        final IRecorderConfiguration recorderConfiguration = this.configuration.
                getRecorderConfigurationFactory().createRecorderConfiguration(recorderConfigurationMap);
        recorder.initialize(recorderConfiguration);
        // register recorder at calculator
        calculator.addObserver(recorder);

        return calculator;
    }

}
