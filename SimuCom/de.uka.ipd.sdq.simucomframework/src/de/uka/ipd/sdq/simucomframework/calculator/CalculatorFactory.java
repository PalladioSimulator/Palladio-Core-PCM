package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Date;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.SensorFrameworkMetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkConfig;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandBasedWaitingTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ExecutionResultCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.HoldTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory;
import de.uka.ipd.sdq.probespec.framework.calculator.ResponseTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.WaitingTimeCalculator;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * TODO: This class still depends on SensorFramework. Try to remove the
 * SensorFramework dependency.
 * 
 * @author Philipp Merkle
 * 
 */
public class CalculatorFactory implements ICalculatorFactory {

	private SimuComModel model;

	private String experimentRunName;
	
	private ISetupDataSinkStrategy dataSink;
	
	public CalculatorFactory(SimuComModel model, ISetupDataSinkStrategy dataSink) {
		experimentRunName = "Run " + new Date();
		this.model = model;
		this.dataSink = dataSink;
	}

	public Calculator buildResponseTimeCalculator(String calculatorName,
			Integer startProbeSetID, Integer endProbeSetID) {
		// Initialize calculator
        Calculator calculator = new ResponseTimeCalculator(model.getProbeSpecContext(), startProbeSetID, endProbeSetID);

		// Initialize metadata
		MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator
				.getMeasurementMetrics(), (SensorFrameworkConfig) model
				.getConfiguration().getRecorderConfig());
		metaData.setExperimentName(model.getConfiguration().getNameExperimentRun());
		metaData.setExperimentRunName(experimentRunName);
		metaData.setMeasurementName("Response Time of " + calculatorName);
		metaData.setMetricName("Response Time"); // TODO Hard coded value!

		PipesAndFiltersManager pipeManager = dataSink.setupDataSink(calculator, metaData);
		this.model.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);
		return calculator;
	}

	public WaitingTimeCalculator buildDemandBasedWaitingTimeCalculator(String calculatorName,
			Integer startWaitingProbeSetID, Integer stopProcessingProbeSetID) {
		// Initialize calculator
        WaitingTimeCalculator calculator = new DemandBasedWaitingTimeCalculator(model.getProbeSpecContext(),
                startWaitingProbeSetID, stopProcessingProbeSetID);

		// Initialize metadata
		MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator
				.getMeasurementMetrics(), (SensorFrameworkConfig) model
				.getConfiguration().getRecorderConfig());
		metaData.setExperimentName(model.getConfiguration().getNameExperimentRun());
		metaData.setExperimentRunName(experimentRunName);		
		metaData.setMeasurementName(model.getConfiguration().getNameExperimentRun() + ": Wait time at " + calculatorName);
		metaData.setMetricName("Waiting Time"); // TODO Hard coded value!

		PipesAndFiltersManager pipeManager = dataSink.setupDataSink(calculator, metaData);
		this.model.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);
		
		return calculator;
	}
	
	public WaitingTimeCalculator buildWaitingTimeCalculator(String calculatorName,
			Integer startWaitingProbeSetID, Integer stopWaitingProbeSetID) {
		// Initialize calculator
        WaitingTimeCalculator calculator = new WaitingTimeCalculator(model.getProbeSpecContext(), startWaitingProbeSetID,
                stopWaitingProbeSetID);

		// Initialize metadata
		MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator
				.getMeasurementMetrics(), (SensorFrameworkConfig) model
				.getConfig().getRecorderConfig());
		metaData.setExperimentName(model.getConfiguration().getNameExperimentRun());
		metaData.setExperimentRunName(experimentRunName);		
		metaData.setMeasurementName("Wait time at " + calculatorName);
		metaData.setMetricName("Waiting Time"); // TODO Hard coded value!

		PipesAndFiltersManager pipeManager = dataSink.setupDataSink(calculator, metaData);
		this.model.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);
		
		return calculator;
	}
	
	public HoldTimeCalculator buildHoldTimeCalculator(String calculatorName,
			Integer startHoldProbeSetID, Integer stopHoldProbeSetID) {
		// Initialize calculator
        HoldTimeCalculator calculator = new HoldTimeCalculator(model.getProbeSpecContext(), startHoldProbeSetID,
                stopHoldProbeSetID);

		// Initialize metadata
		MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator
				.getMeasurementMetrics(), (SensorFrameworkConfig) model
				.getConfiguration().getRecorderConfig());
		metaData.setExperimentName(model.getConfiguration().getNameExperimentRun());
		metaData.setExperimentRunName(experimentRunName);		
		metaData.setMeasurementName("Hold time at " + calculatorName);
		metaData.setMetricName("Hold Time"); // TODO Hard coded value!

		PipesAndFiltersManager pipeManager = dataSink.setupDataSink(calculator, metaData);
		this.model.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);
		
		return calculator;
	}
	
	public StateCalculator buildStateCalculator(String calculatorName, Integer probeSetId) {
		// Initialize calculator
        StateCalculator calculator = new StateCalculator(model.getProbeSpecContext(), probeSetId);

		// Initialize metadata
		MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator
				.getMeasurementMetrics(), (SensorFrameworkConfig) model
				.getConfiguration().getRecorderConfig());
		metaData.setExperimentName(model.getConfiguration().getNameExperimentRun());
		metaData.setExperimentRunName(experimentRunName);		
		metaData.setMeasurementName("Utilisation of " + calculatorName);
		metaData.setMetricName("Utilisation"); // TODO Hard coded value!

		PipesAndFiltersManager pipeManager = dataSink.setupDataSink(calculator, metaData);
		this.model.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);
		
		return calculator;
	}
	
	public DemandCalculator buildDemandCalculator(String calculatorName,
			Integer probeSetID) {
		// Initialize calculator
        DemandCalculator calculator = new DemandCalculator(model.getProbeSpecContext(), probeSetID);

		// Initialize metadata
		MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator
				.getMeasurementMetrics(), (SensorFrameworkConfig) model
				.getConfiguration().getRecorderConfig());
		metaData.setExperimentName(model.getConfiguration().getNameExperimentRun());
		metaData.setExperimentRunName(experimentRunName);		
		metaData.setMeasurementName("Demanded time at " + calculatorName);
		metaData.setMetricName("Demanded Time"); // TODO Hard coded value!

		PipesAndFiltersManager pipeManager = dataSink.setupDataSink(calculator, metaData);
		this.model.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);
		
		return calculator;
	}

	@Override
	public StateCalculator buildOverallUtilizationCalculator(
			String calculatorName, Integer probeSetId) {
		// Initialize calculator
        StateCalculator calculator = new StateCalculator(model.getProbeSpecContext(), probeSetId);

		// Initialize metadata
		MetaDataInit metaData = new SensorFrameworkMetaDataInit(calculator
				.getMeasurementMetrics(), (SensorFrameworkConfig) model
				.getConfiguration().getRecorderConfig());
		metaData.setExperimentName(model.getConfiguration().getNameExperimentRun());
		metaData.setExperimentRunName(experimentRunName);		
		metaData.setMeasurementName("Overall Utilisation of " + calculatorName);
		metaData.setMetricName("Overall Utilisation"); // TODO Hard coded value!

		PipesAndFiltersManager pipeManager = dataSink.setupDataSink(calculator, metaData);
		this.model.getProbeSpecContext().getPipeManagerRegisty().register(pipeManager);
		
		return calculator;
	}

    @Override
    public ExecutionResultCalculator buildExecutionResultCalculator(String calculatorName, Integer probeSetID) {
        // TODO Auto-generated method stub
        return null;
    }
	
}
