package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.edp2.models.ExperimentData.MetricSetDescription;

import de.uka.ipd.sdq.pipesandfilters.framework.IMetaDataInitFactory;
import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory;
import de.uka.ipd.sdq.probespec.framework.probes.Probe;
import de.uka.ipd.sdq.reliability.core.FailureStatistics;
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

    private final IMetaDataInitFactory metaDataInitFactory;

    /**
     * Strategy interface for initialising data sinks, i.e., pipe and filter chains with a recorder
     * at their end
     */
    private final ISetupDataSinkStrategy dataSinkSetupStrategy;

    private final ICalculatorFactory decoratedCalculatorFactory;

    public RecorderAttachingCalculatorFactoryDecorator(final ICalculatorFactory decoratedCalculatorFactory, final SimuComConfig configuration) {
        super();

        this.decoratedCalculatorFactory = decoratedCalculatorFactory;
        this.experimentRunName = "Run " + new Date();
        this.configuration = configuration;
        this.metaDataInitFactory = RecorderExtensionHelper.instantiateMetaDataInitFactoryForRecorder(configuration.getRecorderName());
        this.dataSinkSetupStrategy = new SetupRecorderStrategy(this.configuration.getRecorderName());
    }

    /**
     * @param calculatorName
     * @param probes
     * @return
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#buildResponseTimeCalculator(java.lang.String, java.util.List)
     */
    @Override
    public Calculator buildResponseTimeCalculator(final String calculatorName, final List<Probe> probes) {
        return setupRecorder(decoratedCalculatorFactory.buildResponseTimeCalculator(calculatorName, probes));
    }

    /**
     * @param calculatorName
     * @param probes
     * @return
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#buildDemandBasedWaitingTimeCalculator(java.lang.String, java.util.List)
     */
    @Override
    public Calculator buildDemandBasedWaitingTimeCalculator(final String calculatorName, final List<Probe> probes) {
        return setupRecorder(decoratedCalculatorFactory.buildDemandBasedWaitingTimeCalculator(calculatorName, probes));
    }

    /**
     * @param calculatorName
     * @param probes
     * @return
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#buildWaitingTimeCalculator(java.lang.String, java.util.List)
     */
    @Override
    public Calculator buildWaitingTimeCalculator(final String calculatorName, final List<Probe> probes) {
        return setupRecorder(decoratedCalculatorFactory.buildWaitingTimeCalculator(calculatorName, probes));
    }

    /**
     * @param calculatorName
     * @param probes
     * @return
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#buildHoldTimeCalculator(java.lang.String, java.util.List)
     */
    @Override
    public Calculator buildHoldTimeCalculator(final String calculatorName, final List<Probe> probes) {
        return setupRecorder(decoratedCalculatorFactory.buildHoldTimeCalculator(calculatorName, probes));
    }

    /**
     * @param calculatorName
     * @param probe
     * @return
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#buildStateCalculator(java.lang.String, de.uka.ipd.sdq.probespec.framework.probes.Probe)
     */
    @Override
    public Calculator buildStateCalculator(final String calculatorName, final Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildStateCalculator(calculatorName, probe));
    }

    /**
     * @param calculatorName
     * @param probe
     * @return
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#buildOverallUtilizationCalculator(java.lang.String, de.uka.ipd.sdq.probespec.framework.probes.Probe)
     */
    @Override
    public Calculator buildOverallUtilizationCalculator(final String calculatorName, final Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildOverallUtilizationCalculator(calculatorName, probe));
    }

    /**
     * @param calculatorName
     * @param probe
     * @return
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#buildDemandCalculator(java.lang.String, de.uka.ipd.sdq.probespec.framework.probes.Probe)
     */
    @Override
    public Calculator buildDemandCalculator(final String calculatorName, final Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildDemandCalculator(calculatorName, probe));
    }

    /**
     * @param calculatorName
     * @param probe
     * @return
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#buildExecutionResultCalculator(java.lang.String, de.uka.ipd.sdq.probespec.framework.probes.Probe)
     */
    @Override
    public Calculator buildExecutionResultCalculator(final String calculatorName, final Probe probe) {
        return setupRecorder(decoratedCalculatorFactory.buildExecutionResultCalculator(calculatorName, probe),FailureStatistics.getInstance().getExecutionResultTypes());
    }

    /**
     * @param probeSpecContext
     * @see de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory#setProbeSpecContext(de.uka.ipd.sdq.probespec.framework.ProbeSpecContext)
     */
    @Override
    public void setProbeSpecContext(final ProbeSpecContext probeSpecContext) {
        decoratedCalculatorFactory.setProbeSpecContext(probeSpecContext);
    }

    /**
     * @param failureStatistics
     * @param calculator
     * @return
     */
    private Calculator setupRecorder(
            final Calculator calculator,
            final Map<Integer, String> failureStatistics) {

        final MetaDataInit metaData = this.metaDataInitFactory.createMetaDataInit(
                (MetricSetDescription) calculator.getMetricDesciption(),
                this.configuration.getRecorderConfig(),
                this.configuration.getNameExperimentRun(),
                this.experimentRunName,
                null,  // TODO: Provide model element ID!
                failureStatistics
                );
        dataSinkSetupStrategy.setupDataSink(calculator, metaData);

        return calculator;
    }

    private Calculator setupRecorder(
            final Calculator calculator
            ) {
        return setupRecorder(calculator, Collections.<Integer, String> emptyMap());
    }

}
