package de.uka.ipd.sdq.simucomframework.calculator;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import de.uka.ipd.sdq.pipesandfilters.framework.IMetaDataInitFactory;
import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.RecorderExtensionHelper;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandBasedWaitingTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ExecutionResultCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.HoldTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory;
import de.uka.ipd.sdq.probespec.framework.calculator.ResponseTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.WaitingTimeCalculator;
import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Factory class to create @see {@link Calculator}s used in a SimuCom simulation run.
 * 
 * @author Philipp Merkle, Sebastian Lehrig
 */
public class CalculatorFactory implements ICalculatorFactory {    
    /**
     * SimuCom model which is simulated
     */
    private final SimuComModel model;

    /**
     * Cached name of the experiment run's name
     */
    private final String experimentRunName;
    
    private IMetaDataInitFactory metaDataInitFactory;

    /**
     * Strategy interface for initialising data sinks, i.e., pipe and filter chains with a recorder
     * at their end
     */
    private final ISetupDataSinkStrategy dataSinkSetupStrategy;

    public CalculatorFactory(SimuComModel model, ISetupDataSinkStrategy dataSink) {
        super();

        this.experimentRunName = "Run " + new Date();
        this.model = model;
        this.dataSinkSetupStrategy = dataSink;
    }

	/**
	 * @param failureStatistics 
	 * @param calculator
	 * @return
	 */
	private Calculator createMetaDataInitHelper(
			final Calculator calculator,             
			final String metricName,
			final String measurementName, Map<Integer, String> failureStatistics) {
		
		// TODO should be done earlier? Redundant?
		calculator.getMetricDescriptions().setName(metricName);
		calculator.getMetricDescriptions().setTextualDescription(measurementName);
		
		MetaDataInit metaData = getMetaDataInitFactory().createMetaDataInit(
				calculator.getMetricDescriptions(),
        		this.model.getConfiguration().getRecorderConfig(),        		
        		this.model.getConfiguration().getNameExperimentRun(),
        		this.experimentRunName,
        		null,  // TODO: Provide model element ID!
        		failureStatistics
        	);
		dataSinkSetupStrategy.setupDataSink(calculator, metaData);
        
        return calculator;
	}

	private Calculator createMetaDataInitHelper(
			final Calculator calculator,             
			final String metricName,
			final String measurementName
			) {
		return createMetaDataInitHelper(calculator, metricName, measurementName, Collections.<Integer, String> emptyMap());		
	}

	@Override
	public Calculator buildResponseTimeCalculator(String calculatorName, Integer startProbeSetID, Integer endProbeSetID) {
        return createMetaDataInitHelper(
        		new ResponseTimeCalculator(model.getProbeSpecContext(), startProbeSetID, endProbeSetID),
        		"Response Time", // TODO Hard coded value!
        		"Response Time of " + calculatorName);
    }
	
    @Override
	public Calculator buildDemandBasedWaitingTimeCalculator(String calculatorName,
            Integer startWaitingProbeSetID, Integer stopProcessingProbeSetID) {

        return createMetaDataInitHelper(
        		new DemandBasedWaitingTimeCalculator(model.getProbeSpecContext(),
                        startWaitingProbeSetID, stopProcessingProbeSetID),
        		"Waiting Time", // TODO Hard coded value!
        		model.getConfiguration().getNameExperimentRun() + ": Wait time at " + calculatorName
        	);
    }

    @Override
	public Calculator buildWaitingTimeCalculator(String calculatorName, Integer startWaitingProbeSetID,
            Integer stopWaitingProbeSetID) {
        return createMetaDataInitHelper(
        		new WaitingTimeCalculator(model.getProbeSpecContext(),
                        startWaitingProbeSetID, stopWaitingProbeSetID), 
        		"Waiting Time",
        		"Wait time at " + calculatorName
        		);
    }

    @Override
	public Calculator buildHoldTimeCalculator(String calculatorName, Integer startHoldProbeSetID,
            Integer stopHoldProbeSetID) {
        return createMetaDataInitHelper(
        		new HoldTimeCalculator(model.getProbeSpecContext(), startHoldProbeSetID,
                        stopHoldProbeSetID), 
        		"Hold Time",
        		"Hold time at " + calculatorName);
    }

    @Override
	public Calculator buildStateCalculator(String calculatorName, Integer probeSetId) {
        return createMetaDataInitHelper(
        		new StateCalculator(model.getProbeSpecContext(), probeSetId), 
        		"Utilisation",
        		"Utilisation of " + calculatorName);
    }

    @Override
	public Calculator buildDemandCalculator(String calculatorName, Integer probeSetID) {
        return createMetaDataInitHelper(
        		new DemandCalculator(model.getProbeSpecContext(), probeSetID),
        		"Demanded Time",
        		"Demanded time at " + calculatorName);
    }

    @Override
    public Calculator buildOverallUtilizationCalculator(String calculatorName, Integer probeSetId) {
       return createMetaDataInitHelper(
    		   new StateCalculator(model.getProbeSpecContext(), probeSetId),
        		"Overall Utilisation",
        		"Overall Utilisation of " + calculatorName);
    }

    @Override
    public Calculator buildExecutionResultCalculator(String calculatorName, Integer probeSetId) {
        return createMetaDataInitHelper(
        		new ExecutionResultCalculator(model.getProbeSpecContext(), probeSetId),
        		"Execution Time",
        		"Execution result of " + calculatorName,
        		FailureStatistics.getInstance().getExecutionResultTypes());
    }

    private IMetaDataInitFactory getMetaDataInitFactory() {
        if(metaDataInitFactory == null) {
            String recorderName = model.getConfiguration().getRecorderName();
            metaDataInitFactory = RecorderExtensionHelper.instantiateMetaDataInitFactoryForRecorder(recorderName);
        }
        return metaDataInitFactory;
    }
  

}
