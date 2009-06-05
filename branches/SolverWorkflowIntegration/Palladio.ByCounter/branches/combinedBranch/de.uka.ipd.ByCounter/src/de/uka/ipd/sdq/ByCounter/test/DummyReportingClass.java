package de.uka.ipd.sdq.ByCounter.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import de.uka.ipd.sdq.ByCounter.execution.CountingArtefactInformation;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;

/**
 * This class is not meant for standard ByCounter instrumentation - 
 * instead, it supplies its own "artificial" counts for testing...
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
class DummyReportingClass {
	/**TODO
	 * @param args
	 */
	public static void main(String[] args){
    	DummyReportingClass drc = new DummyReportingClass();
    	drc.test();
    }
    
    /**
	 * see http://en.wikipedia.org/wiki/Data_log
	 */
	private Logger log;
    
	/**
	 * TODO
	 */
	CountingResultCollector myCollector;

	/** 
     * TODO
     */
    public DummyReportingClass(){
		log = Logger.getLogger(this.getClass().getCanonicalName());
		PropertyConfigurator.configure("log4j.properties");
        this.myCollector = CountingResultCollector.getInstance();
    }
    
    /**TODO
     * @param collector
     */
    public DummyReportingClass(CountingResultCollector collector){
		this();
        this.myCollector = collector;
    }
    
    /**TODO
     * @param prm
     * @return
     */
    public double anotherPseudoInstrumentedMethod(double prm){
        log.debug("input prm: "+prm);
        long start = System.nanoTime();
        double ret = Math.sqrt(prm);
        int[] opcodeCounts = new int[200];
        opcodeCounts[2]=3;
        opcodeCounts[3]=4;
//        int[] methodCallCounts = new int[1];
//        methodCallCounts[0]=2;
//        String[] calledMethods = new String[1];
//        calledMethods[0] ="de.uka.ipd.sdq.ByCounter.execution.anotherPseudoInstrumentedMethod"; 
		 
        myCollector.protocolCountInt(
        		start, 
        		"de.uka.ipd.sdq.ByCounter.execution.anotherPseudoInstrumentedMethod", 
        		opcodeCounts, 
                new int[0]/*methodCallCounts*/, //is null permissible?
        		null/*calledMethods*/, //TODO permissible?
        		null/*newArrayCounts*/, //TODO permissible?
        		null/*newArrayTypeOrDim*/, //TODO permissible?
        		null/*newArrayDescr*/); //TODO permissible?
        log.debug("returning: "+ret);
        return ret;
    }

	/**TODO
	 * @param prm
	 * @return
	 */
	public double pseudoInstrumentedMethod(double prm){
        log.debug("input prm: "+prm);
        long start = System.nanoTime();
        double value = prm*prm;
        value = value*value;
        double ret = anotherPseudoInstrumentedMethod(value);
        ret = anotherPseudoInstrumentedMethod(ret);
        if(ret==value){
//        	log.debug("really equals...");
        }else{
        	log.debug("compared primitive double numbers are not \"=-equal\", " +
        			"squared difference of "+prm+" and "+ret+": "+
        			(prm-ret)*(prm-ret));
        }
        int[] opcodeCounts = new int[200];
        opcodeCounts[0]=1;
        opcodeCounts[1]=2;
        int[] methodCallCounts = new int[1];
        methodCallCounts[0]=2;
        String[] calledMethods = new String[1];
        calledMethods[0] ="de.uka.ipd.sdq.ByCounter.execution.anotherPseudoInstrumentedMethod"; 
		 
        myCollector.protocolCountInt(
        		start, 
        		"de.uka.ipd.sdq.ByCounter.execution.pseudoInstrumentedMethod", 
        		opcodeCounts, 
        		methodCallCounts, 
        		calledMethods, 
        		null/*newArrayCounts*/, //TODO permissible?
        		null/*newArrayTypeOrDim*/, //TODO permissible? 
        		null/*newArrayDescr*/); //TODO permissible?
        log.debug("returning: "+ret);
        return ret;
    }

    /**
     * TODO
     */
    private void test() {
		this.pseudoInstrumentedMethod(10.0D);
		
		@SuppressWarnings("unused")
		List<CountingArtefactInformation> artefactsCallee;
		List<CountingArtefactInformation> artefactsCaller;
		
		Collection<CountingArtefactInformation> artefacts;
		CountingArtefactInformation countingArtefact; 
		artefacts = this.myCollector.getCountingInformationsByBeginning().values();
		for (Iterator<CountingArtefactInformation> iterator = artefacts.iterator(); 
				iterator.hasNext();
				) {
			countingArtefact = iterator.next();
			log.debug(countingArtefact);
		}
		
//		this.myCollector.getCountingInformationsByMethodname();
		Collection<CountingResult> results;
		CountingResult countingResult; 
		results = this.myCollector.getCountingResults().values();
		log.debug("listing all available counting results");
		for (Iterator<CountingResult> iterator = results.iterator(); 
				iterator.hasNext();
				) {
			countingResult = iterator.next();
			log.debug(countingResult);
		}
		

    	artefactsCaller = this.myCollector.getCountingArtefactsByName("de.uka.ipd.sdq.ByCounter.execution.pseudoInstrumentedMethod");
//    	log.debug("Size of caller artefacts list: "+artefactsCaller.size());
//    	log.debug("First caller artefacts in list: "+artefactsCaller.get(0));
//
		artefactsCallee = this.myCollector.getCountingArtefactsByName("de.uka.ipd.sdq.ByCounter.execution.anotherPseudoInstrumentedMethod");
//    	log.debug("Size of callee artefacts list: "+artefactsCallee.size());
//    	log.debug("First callee artefacts in list: "+artefactsCallee.get(0));
//		
//		CountingResult callerCounts = this.myCollector.getCounts(artefactsCaller.get(0));
//    	log.debug("First caller counting result in list: "+callerCounts);
//
//    	CountingResult calleeCounts = this.myCollector.getCounts(artefactsCallee.get(0));
//    	log.debug("First callee counting result in list: "+calleeCounts);
		System.out.println("================================================================");
		System.out.println("================================================================");
		System.out.println("================================================================");
		CountingResult callerCounts_evaluated; 
		long callerTime = artefactsCaller.get(0).getInvocationReceivedTime();
//    	log.debug("First caller artefacts time: "+callerTime);
		callerCounts_evaluated = this.myCollector.getCounts_evaluateCallingTree(callerTime);
		log.debug("First caller counting result in list, fully evaluated: "+callerCounts_evaluated);
	}
}
