package de.uka.ipd.sdq.probespec.framework;

import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.probespec.framework.calculator.CalculatorRegistry;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory;
import de.uka.ipd.sdq.probespec.framework.concurrency.ThreadManager;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategyRegistry;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSetIDGenerator;

public class ProbeSpecContext {
	
	private IProbeStrategyRegistry probeStrategyRegistry;
	
	private ICalculatorFactory calculatorFactory;
	
	private ISampleBlackboard sampleBlackboard;
	
	private ThreadManager threadManager;
	
	private ProbeSetIDGenerator probeSetIdGenerator;
	
	private IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector;
	
	private CalculatorRegistry calculatorRegistry;
	
	private Registry<PipesAndFiltersManager> pipeManagerRegisty;
	
	private boolean initialised;
	
	public ProbeSpecContext() {
		threadManager = new ThreadManager();
		probeSetIdGenerator = new ProbeSetIDGenerator();
		calculatorRegistry = new CalculatorRegistry();
		pipeManagerRegisty = new Registry<PipesAndFiltersManager>();
	}
	
	public void initialise(ISampleBlackboard blackboard,
            IProbeStrategyRegistry probeStrategyRegistry,
            ICalculatorFactory calculatorFactory) {
        this.sampleBlackboard = blackboard;
        this.probeStrategyRegistry = probeStrategyRegistry;
        this.calculatorFactory = calculatorFactory;
        this.initialised = true;
	}
	
	public Integer obtainProbeSetId(String probeSetId) {
		return probeSetIdGenerator.obtainId(probeSetId);
	}
	
	public String obtainOriginalProbeSetId(Integer probeSetId) {
		return probeSetIdGenerator.obtainOriginalId(probeSetId);
	}

	public IProbeStrategyRegistry getProbeStrategyRegistry() {
	    throwExceptionIfNotInitialised();
		return probeStrategyRegistry;
	}

	public void setProbeStrategyRegistry(
			IProbeStrategyRegistry probeStrategyRegistry) {
		this.probeStrategyRegistry = probeStrategyRegistry;
	}

	public ICalculatorFactory getCalculatorFactory() {
	    throwExceptionIfNotInitialised();
		return calculatorFactory;
	}

	public void setCalculatorFactory(ICalculatorFactory calculatorFactory) {
		this.calculatorFactory = calculatorFactory;
	}

	public ISampleBlackboard getSampleBlackboard() {
	    throwExceptionIfNotInitialised();
		return sampleBlackboard;
	}

	public void setSampleBlackboard(ISampleBlackboard sampleBlackboard) {
		this.sampleBlackboard = sampleBlackboard;
	}

	public IRegionBasedGarbageCollector<RequestContext> getBlackboardGarbageCollector() {
		return blackboardGarbageCollector;
	}

	public void setBlackboardGarbageCollector(
			IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector) {
		this.blackboardGarbageCollector = blackboardGarbageCollector;
	}

	public ThreadManager getThreadManager() {
		return threadManager;
	}
	
	public CalculatorRegistry getCalculatorRegistry() {
		return calculatorRegistry;
	}
	
	public Registry<PipesAndFiltersManager> getPipeManagerRegisty() {
	    throwExceptionIfNotInitialised();
		return pipeManagerRegisty;
	}

	public void finish() {
	    throwExceptionIfNotInitialised();
	    
		// stop registered threads
		getThreadManager().stopThreads();
		
		// flush pipes
		for(PipesAndFiltersManager p : pipeManagerRegisty) {
			p.flush();
		}
	}
	
    private void throwExceptionIfNotInitialised() {
        if (!initialised) {
            throw new RuntimeException("Initialise the ProbeSpecification context before using it.");
        }
    }
	
}
