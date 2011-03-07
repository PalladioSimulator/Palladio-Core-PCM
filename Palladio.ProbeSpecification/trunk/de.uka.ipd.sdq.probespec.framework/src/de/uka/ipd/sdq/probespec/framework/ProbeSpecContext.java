package de.uka.ipd.sdq.probespec.framework;

import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.probespec.framework.calculator.CalculatorRegistry;
import de.uka.ipd.sdq.probespec.framework.calculator.ICalculatorFactory;
import de.uka.ipd.sdq.probespec.framework.concurrency.ThreadManager;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.IRegionBasedGarbageCollector;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategyRegistry;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSetIDGenerator;

public class ProbeSpecContext {

	private static ProbeSpecContext instance = new ProbeSpecContext();
	
	private IProbeStrategyRegistry probeStrategyRegistry;
	
	private ICalculatorFactory calculatorFactory;
	
	private ISampleBlackboard sampleBlackboard;
	
	private ThreadManager threadManager;
	
	private ProbeSetIDGenerator probeSetIdGenerator;
	
	private IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector;
	
	private CalculatorRegistry calculatorRegistry;
	
	private Registry<PipesAndFiltersManager> pipeManagerRegisty;
	
	private ProbeSpecContext() {
		threadManager = new ThreadManager();
		probeSetIdGenerator = new ProbeSetIDGenerator();
		calculatorRegistry = new CalculatorRegistry();
		pipeManagerRegisty = new Registry<PipesAndFiltersManager>();
		
		configure(null, null, null, null);
	}
	
	public void configure(
			ISampleBlackboard sampleBlackboard,
			IRegionBasedGarbageCollector<RequestContext> blackboardGarbageCollector,
			IProbeStrategyRegistry probeStrategyRegistry,
			ICalculatorFactory calculatorFactory) {
		setSampleBlackboard(sampleBlackboard);
		setBlackboardGarbageCollector(blackboardGarbageCollector);
		setProbeStrategyRegistry(probeStrategyRegistry);
		setCalculatorFactory(calculatorFactory);
	}
	
	public static ProbeSpecContext instance() {
		return instance;
	}
	
	public static void clean() {
		ProbeSpecContext.instance = new ProbeSpecContext();
		// TODO realise "real" clean
//		probeSetIdGenerator = new ProbeSetIDGenerator();
//		calculatorRegistry = new CalculatorRegistry();
//		pipeManagerRegisty = new Registry<PipesAndFiltersManager>();
	}
	
	public Integer obtainProbeSetId(String probeSetId) {
		return probeSetIdGenerator.obtainId(probeSetId);
	}
	
	public String obtainOriginalProbeSetId(Integer probeSetId) {
		return probeSetIdGenerator.obtainOriginalId(probeSetId);
	}

	public IProbeStrategyRegistry getProbeStrategyRegistry() {
		return probeStrategyRegistry;
	}

	public void setProbeStrategyRegistry(
			IProbeStrategyRegistry probeStrategyRegistry) {
		this.probeStrategyRegistry = probeStrategyRegistry;
	}

	public ICalculatorFactory getCalculatorFactory() {
		return calculatorFactory;
	}

	public void setCalculatorFactory(ICalculatorFactory calculatorFactory) {
		this.calculatorFactory = calculatorFactory;
	}

	public ISampleBlackboard getSampleBlackboard() {
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
		return pipeManagerRegisty;
	}

	public void finish() {
		// stop registered threads
		getThreadManager().stopThreads();
		
		// flush pipes
		for(PipesAndFiltersManager p : pipeManagerRegisty) {
			p.flush();
		}
		
	}
	
}
