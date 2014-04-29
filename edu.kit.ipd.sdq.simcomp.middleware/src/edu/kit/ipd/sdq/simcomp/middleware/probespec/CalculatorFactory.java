package edu.kit.ipd.sdq.simcomp.middleware.probespec;

import java.util.Date;
import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.IRawWriteStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.IWriteStrategy;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.RawRecorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.Recorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.SensorFrameworkMetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkConfig;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandBasedWaitingTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ExecutionResultCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.HoldTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorListener;
import de.uka.ipd.sdq.probespec.framework.calculator.ResponseTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.WaitingTimeCalculator;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.SimulationConfiguration;

/**
 * This factory provides methods to build several types of {@link Calculator}s and to set up the
 * associated pipes-and-filters chain. The calculators built are connected to this chain that
 * ensures that measurements of the calculators are propagated towards a data sink, that finally
 * persists the calculator results.
 * 
 * @author Philipp Merkle
 * 
 */
public class CalculatorFactory implements ICalculatorFactory {

	private ISimulationMiddleware middleware;
    private String experimentRunName;

    /**
     * Constructs a new factory that builds several types of calculators. The built calculators are
     * registered with the specified blackboard, from where they receive their input data. After
     * calculation, the calculators send the results to the specified data sink.
     * 
     * @param middleware The simulation middleware
     */
    public CalculatorFactory(ISimulationMiddleware middleware) {
        this.middleware = middleware;
        this.experimentRunName = "Run " + new Date();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculator buildResponseTimeCalculator(String calculatorName, Integer startProbeSetID, Integer endProbeSetID) {
        // Initialize calculator
        Calculator calculator = new ResponseTimeCalculator(middleware.getProbeSpecContext(), startProbeSetID, endProbeSetID);

        // Initialize metadata
        SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
        MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator.getMeasurementMetrics(), (SensorFrameworkConfig) config.getRecorderConfig());
        metaData.setExperimentName(config.getNameExperimentRun());
        metaData.setExperimentRunName(experimentRunName);
        metaData.setMeasurementName("Response Time of " + calculatorName);
        metaData.setMetricName("Response Time");

        // set up the pipes-and-filters chain
        PipesAndFiltersManager pipeManager = setupFilterChain(metaData, calculator);
        middleware.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);

        return calculator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WaitingTimeCalculator buildDemandBasedWaitingTimeCalculator(String calculatorName, Integer startWaitingProbeSetID, Integer stopProcessingProbeSetID) {
        // Initialize calculator
        WaitingTimeCalculator calculator = new DemandBasedWaitingTimeCalculator(middleware.getProbeSpecContext(), startWaitingProbeSetID, stopProcessingProbeSetID);

        // Initialize metadata
        SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
        MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator.getMeasurementMetrics(), (SensorFrameworkConfig) config.getRecorderConfig());
        metaData.setExperimentName(config.getNameExperimentRun());
        metaData.setExperimentRunName(experimentRunName);
        metaData.setMeasurementName(config.getNameExperimentRun() + ": Wait time at " + calculatorName);
        metaData.setMetricName("Waiting Time");

        // set up the pipes-and-filters chain
        PipesAndFiltersManager pipeManager = setupFilterChain(metaData, calculator);
        middleware.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);

        return calculator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WaitingTimeCalculator buildWaitingTimeCalculator(String calculatorName, Integer startWaitingProbeSetID, Integer stopWaitingProbeSetID) {
        // Initialize calculator
        WaitingTimeCalculator calculator = new WaitingTimeCalculator(middleware.getProbeSpecContext(), startWaitingProbeSetID, stopWaitingProbeSetID);

        // Initialize metadata
        SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
        MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator.getMeasurementMetrics(), (SensorFrameworkConfig) config.getRecorderConfig());
        metaData.setExperimentName(config.getNameExperimentRun());
        metaData.setExperimentRunName(experimentRunName);
        metaData.setMeasurementName("Wait time at " + calculatorName);
        metaData.setMetricName("Waiting Time");

        // set up the pipes-and-filters chain
        PipesAndFiltersManager pipeManager = setupFilterChain(metaData, calculator);
        middleware.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);

        return calculator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HoldTimeCalculator buildHoldTimeCalculator(String calculatorName, Integer startHoldProbeSetID, Integer stopHoldProbeSetID) {
        // Initialize calculator
        HoldTimeCalculator calculator = new HoldTimeCalculator(middleware.getProbeSpecContext(), startHoldProbeSetID, stopHoldProbeSetID);

        // Initialize metadata
        SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
        MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator.getMeasurementMetrics(), (SensorFrameworkConfig) config.getRecorderConfig());
        metaData.setExperimentName(config.getNameExperimentRun());
        metaData.setExperimentRunName(experimentRunName);
        metaData.setMeasurementName("Hold time at " + calculatorName);
        metaData.setMetricName("Hold Time");

        // set up the pipes-and-filters chain
        PipesAndFiltersManager pipeManager = setupFilterChain(metaData, calculator);
        middleware.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);

        return calculator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StateCalculator buildStateCalculator(String calculatorName, Integer probeSetId) {
        // Initialize calculator
        StateCalculator calculator = new StateCalculator(middleware.getProbeSpecContext(), probeSetId);

        // Initialize metadata
        SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
        MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator.getMeasurementMetrics(), (SensorFrameworkConfig) config.getRecorderConfig());
        metaData.setExperimentName(config.getNameExperimentRun());
        metaData.setExperimentRunName(experimentRunName);
        metaData.setMeasurementName("Utilisation of " + calculatorName);
        metaData.setMetricName("Utilisation");

        // set up the pipes-and-filters chain
        PipesAndFiltersManager pipeManager = setupFilterChain(metaData, calculator);
        middleware.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);

        return calculator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DemandCalculator buildDemandCalculator(String calculatorName, Integer probeSetID) {
        // Initialize calculator
        DemandCalculator calculator = new DemandCalculator(middleware.getProbeSpecContext(), probeSetID);

        // Initialize metadata
        SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
        MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator.getMeasurementMetrics(), (SensorFrameworkConfig) config.getRecorderConfig());
        metaData.setExperimentName(config.getNameExperimentRun());
        metaData.setExperimentRunName(experimentRunName);
        metaData.setMeasurementName("Demanded time at " + calculatorName);
        metaData.setMetricName("Demanded Time");

        // set up the pipes-and-filters chain
        PipesAndFiltersManager pipeManager = setupFilterChain(metaData, calculator);
        middleware.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);

        return calculator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StateCalculator buildOverallUtilizationCalculator(String calculatorName, Integer probeSetId) {
        // Initialize calculator
        StateCalculator calculator = new StateCalculator(middleware.getProbeSpecContext(), probeSetId);

        // Initialize metadata
        SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
        MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator.getMeasurementMetrics(), (SensorFrameworkConfig) config.getRecorderConfig());
        metaData.setExperimentName(config.getNameExperimentRun());
        metaData.setExperimentRunName(experimentRunName);
        metaData.setMeasurementName("Overall Utilisation of " + calculatorName);
        metaData.setMetricName("Overall Utilisation");

        // set up the pipes-and-filters chain
        PipesAndFiltersManager pipeManager = setupFilterChain(metaData, calculator);
        middleware.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);

        return calculator;
    }

    /**
     * Sets up a pipes-and-filters chain with the specified initialisation metadata. Whenever the
     * specified calculator produces a result, it is passed to the filter chain.
     * 
     * @param metaData
     *            the metadata that is used to initialise the filter chain
     * @param calculator
     *            the calculator whose results are passed to the filter chain
     * 
     * @return the manager for the created filter chain
     */
    private PipesAndFiltersManager setupFilterChain(MetaDataInit metaData, Calculator calculator) {
        // Initialize recorder and Pipes-and-Filters-Manger
        Recorder recorder = new RawRecorder(createWriteStrategy());
        final PipesAndFiltersManager pipeManager = new PipesAndFiltersManager(recorder);
        pipeManager.initialize(metaData);

        calculator.addCalculatorListener(new ICalculatorListener() {

            @Override
            public void calculated(Vector<Measure<?, ? extends Quantity>> resultTuple) {
                pipeManager.processData(new PipeData(resultTuple));
            }

        });

        return pipeManager;
    }

    /**
     * Creates an {@link IWriteStrategy} for the selected persistence framework (e.g.
     * SensorFramework). The selection is stored in the simulation configuration.
     * 
     * @return the created write strategy
     */
    private IRawWriteStrategy createWriteStrategy() {
        try {
        	SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
            String recorderName = config.getRecorderName();
            String className = RecorderExtensionHelper.getWriteStrategyClassNameForName(recorderName);
            return (IRawWriteStrategy) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ExecutionResultCalculator buildExecutionResultCalculator(String calculatorName, Integer probeSetID) {
    	// TODO provide implementation
        throw new RuntimeException("The method buildExecutionResultCalculator is not yet implemented.");
    }

}
