package de.uka.ipd.sdq.TimerMeter.utils.deprecated;

import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.TimerMeter.utils.CommonUtilities;
import de.uka.ipd.sdq.TimerMeter.utils.MeasurementResults;

public class OverheadCalculator_Loop {
	
	private static final PrintStream o = System.out;

	public static void main(String args[]){
		OverheadCalculator_Loop oc = new OverheadCalculator_Loop();
		
		int nrOfIterations = 10000;
		List<Long> results = oc.measureSimpleOverhead(2000, nrOfIterations);
		Collections.sort(results);
		o.println("Median of pure iterating loops: "+results.get(results.size()/2));
		if(1==1){
			return;
		}
		
		o.println("Naive (w/o warmup, 1*):    "+(-1*(System.nanoTime()-System.nanoTime()))+"\n");

		o.println("Explanation of params:     measurements/chainings[/loops]/cutQuartiles\n");
		o.println("Mean simple 400/0/t:       "+oc.calculateSimpleOverheadMean(400, 0, true));
		o.println("Median simple 400/0/t:     "+oc.calculateSimpleOverheadMedian(400, 0, true));
		o.println("Mean simple 800/0/t:       "+oc.calculateSimpleOverheadMean(800, 0, true));
		o.println("Median simple 800/0/t:     "+oc.calculateSimpleOverheadMedian(800, 0, true));
		o.println("Mean simple 400/200/t:     "+oc.calculateSimpleOverheadMean(400, 200, true));
		o.println("Median simple 400/200/t:   "+oc.calculateSimpleOverheadMedian(400, 200, true));
		
		o.println("Mean simple 400/0/f:       "+oc.calculateSimpleOverheadMean(400, 0, false));
		o.println("Median simple 400/0/f:     "+oc.calculateSimpleOverheadMedian(400, 0, false));
		o.println("Mean simple 800/0/f:       "+oc.calculateSimpleOverheadMean(800, 0, false));
		o.println("Median simple 800/0/f:     "+oc.calculateSimpleOverheadMedian(800, 0, false));
		o.println("Mean simple 400/200/f:     "+oc.calculateSimpleOverheadMean(400, 200, false));
		o.println("Median simple 400/200/f:   "+oc.calculateSimpleOverheadMedian(400, 200, false));
		
		o.println("Mean loop 400/200/200/t:   "+oc.calculateLoopOverheadMean(400, 200, 200, true));
		o.println("Median loop 400/200/200/t: "+oc.calculateLoopOverheadMedian(400, 200, 200, true));
		
	}
	private ThreadMXBean bean;
	
	//	private static final int DEFAULT_NUMBER_OF_CHAININGS = 100;
//
//	private static final int DEFAULT_NUMBER_OF_LOOPS = 200;
//
//	private static final int DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP = 400;
	CommonUtilities cUtils = CommonUtilities.getInstance();
	
	public OverheadCalculator_Loop(){

	}
	
	public double calculateLoopOverheadMean(int nrOfMeasurements, int nrOfChainings, int nrOfLoops, boolean cutQuartiles){
//		int nrOfChainings = DEFAULT_NUMBER_OF_CHAININGS;
//		int nrOfLoops = DEFAULT_NUMBER_OF_LOOPS;
		List<Long> l = this.measureLoopOverhead(nrOfMeasurements, nrOfLoops, nrOfChainings);
		if(cutQuartiles){
			return this.getCleanedMeasResultsFromMeasurements(l).computeMeasurementMeanExpensively_Long();
		}else {
			return this.getUncleanedMeasResultsFromMeasurements(l).computeMeasurementMeanExpensively_Long();
		}
	}
	
	@SuppressWarnings("deprecation")
	public long calculateLoopOverheadMedian(int nrOfMeasurements, int nrOfChainings, int nrOfLoops, boolean cutQuartiles){
//		int nrOfChainings = DEFAULT_NUMBER_OF_CHAININGS;
//		int nrOfLoops = DEFAULT_NUMBER_OF_LOOPS;
		List<Long> l = this.measureLoopOverhead(nrOfMeasurements, nrOfLoops, nrOfChainings);
		if(cutQuartiles){
			return this.getCleanedMeasResultsFromMeasurements(l).getMeasurementMedian_Long();
		}else {
			return this.getUncleanedMeasResultsFromMeasurements(l).getMeasurementMedian_Long();
		}
	}
	
//	public long calculateLooplessOverhead(int times){
//		long startTime=System.nanoTime();
//		for(int i=0; i<times; i++){}
//		long endTime=System.nanoTime();
//		return endTime-startTime;	
//	}

	//	public double calculateSimpleOverhead(){
//		return calculateSimpleOverheadMean(DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP, true);
//	}
//		
//	public double calculateSimpleOverhead(boolean cutQuartiles){
//		return calculateSimpleOverheadMean(DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP, cutQuartiles);
//	}
//	
//	public double calculateSimpleOverhead(int nrOfMeasurements){
//		return calculateSimpleOverheadMean(nrOfMeasurements, true);
//	}
//	
//	public double calculateSimpleOverhead(int nrOfMeasurements, boolean cutQuartiles){
//		return calculateSimpleOverheadMean(nrOfMeasurements, cutQuartiles);
//	}
//	
	public double calculateSimpleOverheadMean(int nrOfMeasurements, int nrOfChainings, boolean cutQuartiles){
//		int nrOfChainings = DEFAULT_NUMBER_OF_CHAININGS;
		List<Long> l = this.measureSimpleOverhead(nrOfMeasurements, nrOfChainings);
		if(cutQuartiles){
			return this.getCleanedMeasResultsFromMeasurements(l).computeMeasurementMeanExpensively_Long();
		}else {
			return this.getUncleanedMeasResultsFromMeasurements(l).computeMeasurementMeanExpensively_Long();
		}
	}
	
	//	public long calculateSimpleOverheadMedian(){
//		return calculateSimpleOverheadMedian(DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP, true);
//	}
//	
//	public long calculateSimpleOverheadMedian(boolean cutQuartiles){
//		return calculateSimpleOverheadMedian(DEFAULT_NUMBER_OF_MEASUREMENTS_PER_STEP, cutQuartiles);
//	}
//	
//	public long calculateSimpleOverheadMedian(int nrOfMeasurements){
//		return calculateSimpleOverheadMedian(nrOfMeasurements, true);
//	}
//	
	@SuppressWarnings("deprecation")
	public long calculateSimpleOverheadMedian(int nrOfMeasurements, int nrOfChainings, boolean cutQuartiles){
//		int nrOfChainings = DEFAULT_NUMBER_OF_CHAININGS;
		List<Long> l = this.measureSimpleOverhead(nrOfMeasurements, nrOfChainings);
		if(cutQuartiles){
			return this.getCleanedMeasResultsFromMeasurements(l).getMeasurementMedian_Long();
		}else {
			return this.getUncleanedMeasResultsFromMeasurements(l).getMeasurementMedian_Long();
		}
	}
		
//	@SuppressWarnings("deprecation")
//	public long getAverageDurationOfTimeMeasurement(int nrOfMeasurements, boolean cutQuartiles){
//		return cUtils.getAverageDurationOfTimeMeasurement(nrOfMeasurements, cutQuartiles);
//	}
//	
	private MeasurementResults getCleanedMeasResultsFromMeasurements(List<Long> meas){
		List<Long> cleaned = CommonUtilities.filterAndSortMeasurements(meas, true);
		MeasurementResults mr = new MeasurementResults();
		for (Iterator<Long> iter = cleaned.iterator(); iter.hasNext();) {
			mr.addMeasurement(iter.next());
		}
		return mr;
	}
	
	@SuppressWarnings("deprecation")
	public long getMedianDurationOfTimeMeasurement(int nrOfMeasurements){
		return CommonUtilities.measureMedianNanotimeInvocationCost(nrOfMeasurements);
	}
	
	private MeasurementResults getUncleanedMeasResultsFromMeasurements(List<Long> meas){
		List<Long> uncleaned = CommonUtilities.filterAndSortMeasurements(meas, false);
		MeasurementResults mr = new MeasurementResults();
		for (Iterator<Long> iter = uncleaned.iterator(); iter.hasNext();) {
			mr.addMeasurement(iter.next());
		}
		return mr;
	}
	
	/**Just for reference purposes
	 * @deprecated
	 * @return
	 */
	public double measureCurrentThreadCPUTimeChaining(){
		bean = ManagementFactory.getThreadMXBean();
		bean.getCurrentThreadCpuTime();
		return 0D;
	}
	
	private List<Long> measureLoopOverhead(
			int nrOfMeasurements, 
			int nrOfLoops, 
			int nrOfChainings){
		List<Long> results = new ArrayList<Long>();
		long time1 = 0L;
		long time2 = 0L;
		if(nrOfChainings<=1){//TODO consider other cases
			results = measureSimpleOverhead(nrOfMeasurements, nrOfLoops);
		}else{
			for (int m = 0; m < nrOfMeasurements; m++) {
				System.gc();
				time1 = System.nanoTime();
				for(int c = 0; c < nrOfChainings; c++) {
					for(int l = 0; l<nrOfLoops; l++){
						//
					}
				}
				time2 = System.nanoTime();
				results.add(time2-time1);
			}
		}
		return results;
	}
	
//	private List<Long> measureNestedLoopOverhead(
//			int nrOfMeasurements, 
//			int nrOfLoops, 
//			int nrOfChainings){
//		List<Long> results = new ArrayList<Long>();
//		long time1 = 0L;
//		long time2 = 0L;
//		if(nrOfChainings<=1){//TODO consider other cases
//			results = measureSimpleOverhead(nrOfMeasurements, nrOfLoops);
//		}else{
//			for (int m = 0; m < nrOfMeasurements; m++) {
//				System.gc();
//				time1 = System.nanoTime();
//				for(int c = 0; c < nrOfChainings; c++) {
//					for(int l = 0; l<nrOfLoops; l++){
//						//
//					}
//				}
//				time2 = System.nanoTime();
//				results.add(time2-time1);
//			}
//		}
//		return results;
//	}
	
	/**
	 * @param nrOfMeasurements
	 * @param nrOfChainings
	 * @return
	 */
	private List<Long> measureSimpleOverhead(
			int nrOfMeasurements, 
			int nrOfChainings){
		List<Long> results = new ArrayList<Long>();
		long time1 = 0L;
		long time2 = 0L;
		if(nrOfChainings<=1){
			for (int m = 0; m < nrOfMeasurements; m++) {
				System.gc();
				time1 = System.nanoTime();
				time2 = System.nanoTime();
				results.add(time2-time1);
			}
		}else{
			for (int m = 0; m < nrOfMeasurements; m++) {
				System.gc();
				time1 = System.nanoTime();
				for(int c = 0; c < nrOfChainings; c++) {
					//
				}
				time2 = System.nanoTime();
				results.add(time2-time1);
			}
		}
		return results;
	}
	
	
	
//	public double measureMeanOfDurationOfNothing(int measurementsToComputeDurationOfNothing,
//			boolean doManualGC, int msToSleepAfterGC){
//		List<Long> measurements = new ArrayList<Long>();
//		MeasurementResults_fromAdditivity preliminaryMeasurementResults = null;
////		APICallsAdditivity helper = new APICallsAdditivity();
//		long runningSum = 0L;
//		int i=0; 
//		List<Long> filteredMeasurements = new ArrayList<Long>();
//		JFreeChart chart = null;
//		boolean noOverflow = true;
//		int numberOfWarmupTimerInvocations = 3000; 
//		long methodReturnAtMeasurementStart = 0L;
//		long methodReturnAtMeasurementFinish = 0L;
//		long methodReturnDifference = 0L;
////		int nrOfSuccessfulAdditions;
//		
//		@SuppressWarnings("unused")
//		long publicDummy = 0L;
//		
//		for(int w=0; w<numberOfWarmupTimerInvocations; w++){
//			publicDummy = System.nanoTime();
//		}
//		o.println("Warmup finished");
//		
//		while(i<measurementsToComputeDurationOfNothing && noOverflow){
////			if(doManualGC){
////				System.gc();
//////				Thread.sleep()
////				if(msToSleepAfterGC>0){
////					try {
////						Thread.sleep(msToSleepAfterGC);
////					} catch (InterruptedException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////				}
////			}
//			methodReturnAtMeasurementStart=System.nanoTime();
//			methodReturnAtMeasurementFinish=System.nanoTime();
//			methodReturnDifference = methodReturnAtMeasurementFinish-methodReturnAtMeasurementStart;
//			if(methodReturnDifference<0){
//				o.println("Difference of time measurements smaller than 0!");
//			}else{
//				if(runningSum+methodReturnDifference<runningSum){
//					o.println("Overflow happens when adding "+methodReturnDifference+" to "+
//							runningSum+", aborting after "+(i+1)+
//							" measurements and computing the result");
//					noOverflow = false;
////					nrOfSuccessfulAdditions = i;//TODO redundant, da List-Länge entsprechend
//				}else{
//					measurements.add(methodReturnDifference);
//					runningSum+=methodReturnDifference;
//				}
//			}
//			i++;
//		}
//		
//		o.println("Measurements finished");
//		
////		preliminaryMeasurementResults = computeStatisticsOfMeasurements(measurements);
//		System.out.println(preliminaryMeasurementResults);
//		o.println("Preliminary analysis finished");
//		
//		List<List<Long>> helper2 = new ArrayList<List<Long>>();
//		helper2.add(measurements);
////		chart = visualizeMeasurements(helper2);
//		new CustomJFreeChartVisualizer2().c_writeIntoFile("./pics/"+System.currentTimeMillis()+"_BEFORE.png", 1280, 1024, chart);
//		o.println("First chart finished");
//		
////		filteredMeasurements = this.filterAndSortMeasurements(measurements, true /*cut quartiles*/);
//		helper2 = new ArrayList<List<Long>>();
//		helper2.add(filteredMeasurements);
////		chart = visualizeMeasurements(helper2);
//		new CustomJFreeChartVisualizer2().c_writeIntoFile("./pics/"+System.currentTimeMillis()+"_AFTER.png", 1280, 1024, chart);
//		o.println("Second chart finished");
//
//		MeasurementResults_fromAdditivity finalMeasurementResults = null;
////		finalMeasurementResults = computeStatisticsOfMeasurements(filteredMeasurements);
//		System.out.println(finalMeasurementResults);
//		o.println("after-cleaning analysis finished");
//		
//		helper2 = new ArrayList<List<Long>>();
//		helper2.add(measurements);
//		helper2.add(filteredMeasurements);
////		chart = visualizeMeasurements(helper2);
//		new CustomJFreeChartVisualizer2().c_writeIntoFile("./pics/"+System.currentTimeMillis()+"_TOGETHER.png", 1280, 1024, chart);
//		o.println("Third chart finished");
//
//		return preliminaryMeasurementResults.computeMeasurementMeanExpensively();
//	}
//	
//	public void testToAndFromIndexes(int lowerBound, int currentUpperLoopSizeBound){
//		if(lowerBound<4){
//			o.println("Lower bound less than four is not allowed, aborting");
//			return;
//		}else if(currentUpperLoopSizeBound>1000){
//			o.println("Upper bound greater than four is not allowed, aborting");
//			return;
//		}else if(currentUpperLoopSizeBound<lowerBound){
//			o.println("Upper bound may not be smaller than lower bound, aborting");
//			return;
//		}else{
//			for(int i=lowerBound;i<currentUpperLoopSizeBound;i++){
//				o.print(i+": "+i/4+","+((3*(i/4))-1)+" ");
//				if(i%10==9){
//					o.println("");
//				}
//			}
//			o.println("END");
//		}
//	}
	
	//	private List<Long> measureNestedLoopOverhead(
	//			int nrOfMeasurements, 
	//			int nrOfLoops, 
	//			int nrOfChainings){
	//		List<Long> results = new ArrayList<Long>();
	//		long time1 = 0L;
	//		long time2 = 0L;
	//		if(nrOfChainings<=1){//TODO consider other cases
	//			results = measureSimpleOverhead(nrOfMeasurements, nrOfLoops);
	//		}else{
	//			for (int m = 0; m < nrOfMeasurements; m++) {
	//				System.gc();
	//				time1 = System.nanoTime();
	//				for(int c = 0; c < nrOfChainings; c++) {
	//					for(int l = 0; l<nrOfLoops; l++){
	//						//
	//					}
	//				}
	//				time2 = System.nanoTime();
	//				results.add(time2-time1);
	//			}
	//		}
	//		return results;
	//	}
		

}
