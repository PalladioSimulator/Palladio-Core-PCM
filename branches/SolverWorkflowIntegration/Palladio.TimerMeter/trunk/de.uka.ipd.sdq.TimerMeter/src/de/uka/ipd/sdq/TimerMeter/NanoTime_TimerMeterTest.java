package de.uka.ipd.sdq.TimerMeter;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import de.uka.ipd.sdq.TimerMeter.utils.StatisticalDescription;
import de.uka.ipd.sdq.TimerMeter.utils.TimerCharacterisation;

public class NanoTime_TimerMeterTest {
	
	public NanoTime_TimerMeterTest() {
		super();
		tm = new NanoTime_TimerMeter();
	}

	NanoTime_TimerMeter tm;
	public static void main(String[] args){
		NanoTime_TimerMeterTest tmt = new NanoTime_TimerMeterTest();
		System.out.println("[TimerMeterTester] 1st testing of reflection: "+tmt.testReflection(1)+"\n\n\n");
		System.out.println("[TimerMeterTester] 2nd testing of reflection: "+new NanoTime_TimerMeterTest().testReflection2(40));
		tmt.test();
	}
	
	public long timersimple(){
		return System.currentTimeMillis();
	}

	/**
	 * @param timerMeterMeasurements
	 */
	private void initialiseValues(long[][] timerMeterMeasurements) {
		timerMeterMeasurements[0][0] = 100;
		timerMeterMeasurements[0][1] = 120;
		timerMeterMeasurements[0][2] = 140;
		timerMeterMeasurements[0][3] = 160;
		timerMeterMeasurements[0][4] = 170;
		timerMeterMeasurements[0][5] = 190;
		
		timerMeterMeasurements[1][0] = 210;
		timerMeterMeasurements[1][1] = 230;
		timerMeterMeasurements[1][2] = 250;
		timerMeterMeasurements[1][3] = 230;
		timerMeterMeasurements[1][4] = 210;
		timerMeterMeasurements[1][5] = 190;
		
		timerMeterMeasurements[2][0] = 170;
		timerMeterMeasurements[2][1] = 160;
		timerMeterMeasurements[2][2] = 140;
		timerMeterMeasurements[2][3] = 120;
		timerMeterMeasurements[2][4] = 100;
		timerMeterMeasurements[2][5] = 120;
		
		timerMeterMeasurements[3][0] = 140;
		timerMeterMeasurements[3][1] = 160;
		timerMeterMeasurements[3][2] = 170;
		timerMeterMeasurements[3][3] = 210;
		timerMeterMeasurements[3][4] = 230;
		timerMeterMeasurements[3][5] = 170;
		
		timerMeterMeasurements[4][0] = 160;
		timerMeterMeasurements[4][1] = 140;
		timerMeterMeasurements[4][2] = 160;
		timerMeterMeasurements[4][3] = 170;
		timerMeterMeasurements[4][4] = 230;
		timerMeterMeasurements[4][5] = 170;
	}

	private void test() {
		NanoTime_TimerMeter tm = new NanoTime_TimerMeter();
		
		long[][] timerMeterMeasurements = new long[5][6];
		initialiseValues(timerMeterMeasurements);

		TimerCharacterisation tc = tm.computeTimerCharacterization(timerMeterMeasurements, true);
		System.out.println("Obtained TC: "+tc+"\n");

		System.out.println("All measurements' characterisation compared: "
				+testAllMeasurementsCharacterisation(tc)+"\n");
		System.out.println("All measurements' histogram compared: "
				+testAllMeasurementsHistogram(tc)+"\n");
		System.out.println("All processes' characterisations compared: "
				+testProcessCharacterisations(tc)+"\n"); 
		System.out.println("Histograms by value compared: "
				+testHistogramElementsByValue(tc)+"\n");
		System.out.println("Histograms by value compared: "
				+testHistogramElementsByProcess(tc)+"\n"); 
	}

	/**
	 * @param tc
	 */
	private boolean testAllMeasurementsCharacterisation(TimerCharacterisation tc) {
		System.out.println("Obtained AllMeasurementsCharacterisation: "+tc.getAllMeasurementsCharacterisation());
		StatisticalDescription sds_allMeasurements = new StatisticalDescription();
		sds_allMeasurements.setMax(250L);
		sds_allMeasurements.setMean((double) 5120/(double) 30);
		sds_allMeasurements.setMedian(170);
		sds_allMeasurements.setMin(100);
		sds_allMeasurements.setStandardDeviation(-1); //TODO
		sds_allMeasurements.setVariance(-1); //TODO
		return sds_allMeasurements.equals(tc.getAllMeasurementsCharacterisation());
	}

	/**
	 * @param tc
	 */
	private boolean testAllMeasurementsHistogram(TimerCharacterisation tc) {
		System.out.println("Obtained AllMeasurementsHistogram: "+tc.getAllMeasurementsHistogram());
		SortedMap<Long, Integer> sds_allMeasurementsHistogram = new TreeMap<Long, Integer>();
		sds_allMeasurementsHistogram.put(100L, 2);
		sds_allMeasurementsHistogram.put(120L, 3);
		sds_allMeasurementsHistogram.put(140L, 4);
		sds_allMeasurementsHistogram.put(160L, 5);
		sds_allMeasurementsHistogram.put(170L, 6);
		sds_allMeasurementsHistogram.put(190L, 2);
		sds_allMeasurementsHistogram.put(210L, 3);
		sds_allMeasurementsHistogram.put(230L, 4);
		sds_allMeasurementsHistogram.put(250L, 1);
		return sds_allMeasurementsHistogram.equals(tc.getAllMeasurementsHistogram());
	}

	/**
	 * @param tc
	 */
	private boolean testHistogramElementsByProcess(TimerCharacterisation tc) {
		System.out.println("Obtained HistogramElementsByProcess: "+tc.getHistogramElementsByProcess());
		SortedMap<Integer, SortedMap<Long,Integer>> sds_histogramElementByProcess = new TreeMap<Integer, SortedMap<Long,Integer>>();
		SortedMap<Long, Integer> innerMap0 = new TreeMap<Long, Integer>();
		innerMap0.put(100L,1); innerMap0.put(120L,1); innerMap0.put(140L,1); innerMap0.put(160L,1); innerMap0.put(170L,1); innerMap0.put(190L,1); 
		SortedMap<Long, Integer> innerMap1 = new TreeMap<Long, Integer>();
		innerMap1.put(190L,1); innerMap1.put(210L,2); innerMap1.put(230L,2); innerMap1.put(250L,1); 
		SortedMap<Long, Integer> innerMap2 = new TreeMap<Long, Integer>();
		innerMap2.put(100L,1); innerMap2.put(120L,2); innerMap2.put(140L,1); innerMap2.put(160L,1); innerMap2.put(170L,1); 
		SortedMap<Long, Integer> innerMap3 = new TreeMap<Long, Integer>();
		innerMap3.put(140L,1); innerMap3.put(160L,1); innerMap3.put(170L,2); innerMap3.put(210L,1); innerMap3.put(230L,1); 
		SortedMap<Long, Integer> innerMap4 = new TreeMap<Long, Integer>();
		innerMap4.put(140L,1); innerMap4.put(160L,2); innerMap4.put(170L,2); innerMap4.put(230L,1); 
		sds_histogramElementByProcess.put(0, innerMap0); 
		sds_histogramElementByProcess.put(1, innerMap1); 
		sds_histogramElementByProcess.put(2, innerMap2); 
		sds_histogramElementByProcess.put(3, innerMap3); 
		sds_histogramElementByProcess.put(4, innerMap4);
		return sds_histogramElementByProcess.equals(tc.getHistogramElementsByProcess());
	}

	/**
	 * @param tc
	 */
	private boolean testHistogramElementsByValue(TimerCharacterisation tc) {
		System.out.println("Obtained HistogramElementsByValue: "+tc.getHistogramElementsByValue());
		SortedMap<Long, SortedMap<Integer,Integer>> sds_histogramElementByValue = new TreeMap<Long, SortedMap<Integer,Integer>>();
		SortedMap<Integer, Integer> innerMapA = new TreeMap<Integer, Integer>(); //for value of 100
		innerMapA.put(0,1); innerMapA.put(2,1); 
		SortedMap<Integer, Integer> innerMapB = new TreeMap<Integer, Integer>(); //for value of 120
		innerMapB.put(0,1); innerMapB.put(2,2); 
		SortedMap<Integer, Integer> innerMapC = new TreeMap<Integer, Integer>(); //for value of 140
		innerMapC.put(0,1); innerMapC.put(2,1); innerMapC.put(3,1); innerMapC.put(4,1); 
		SortedMap<Integer, Integer> innerMapD = new TreeMap<Integer, Integer>(); //for value of 160
		innerMapD.put(0,1); innerMapD.put(2,1); innerMapD.put(3,1); innerMapD.put(4,2); 
		SortedMap<Integer, Integer> innerMapE = new TreeMap<Integer, Integer>(); //for value of 170
		innerMapE.put(0,1); innerMapE.put(2,1); innerMapE.put(3,2); innerMapE.put(4,2);  
		SortedMap<Integer, Integer> innerMapF = new TreeMap<Integer, Integer>(); //for value of 190
		innerMapF.put(0,1); innerMapF.put(1,1); 
		SortedMap<Integer, Integer> innerMapG = new TreeMap<Integer, Integer>(); //for value of 210
		innerMapG.put(1,2); innerMapG.put(3,1); 
		SortedMap<Integer, Integer> innerMapH = new TreeMap<Integer, Integer>(); //for value of 230
		innerMapH.put(1,2); innerMapH.put(3,1); innerMapH.put(4,1); 
		SortedMap<Integer, Integer> innerMapI = new TreeMap<Integer, Integer>(); //for value of 250
		innerMapI.put(1,1); 
		sds_histogramElementByValue.put(100L, innerMapA);
		sds_histogramElementByValue.put(120L, innerMapB);
		sds_histogramElementByValue.put(140L, innerMapC);
		sds_histogramElementByValue.put(160L, innerMapD);
		sds_histogramElementByValue.put(170L, innerMapE);
		sds_histogramElementByValue.put(190L, innerMapF);
		sds_histogramElementByValue.put(210L, innerMapG);
		sds_histogramElementByValue.put(230L, innerMapH);
		sds_histogramElementByValue.put(250L, innerMapI);
		return sds_histogramElementByValue.equals(tc.getHistogramElementsByValue());
	}

	/**
	 * @param tc
	 */
	private boolean testProcessCharacterisations(TimerCharacterisation tc) {
		System.out.println("Obtained ProcessCharacterisations: "+tc.getProcessCharacterisations());
		List<StatisticalDescription> stats = new ArrayList<StatisticalDescription>();
		StatisticalDescription struct0 = new StatisticalDescription();
		struct0.setMax(190L); 
		struct0.setMean((double) 880/(double) 6);
		struct0.setMedian(150L);//TODO test
		struct0.setMin(100L);
		struct0.setStandardDeviation(-1); //TODO
		struct0.setVariance(-1); //TODO
		
		StatisticalDescription struct1 = new StatisticalDescription();
		struct1.setMax(250L); 
		struct1.setMean((double) 1320/(double) 6);
		struct1.setMedian(220L);//TODO test
		struct1.setMin(190L);
		struct1.setStandardDeviation(-1); //TODO
		struct1.setVariance(-1); //TODO
		
		StatisticalDescription struct2 = new StatisticalDescription();
		struct2.setMax(170L); 
		struct2.setMean((double) 810/(double) 6);
		struct2.setMedian(130L);//TODO test
		struct2.setMin(100L);
		struct2.setStandardDeviation(-1); //TODO
		struct2.setVariance(-1); //TODO

		StatisticalDescription struct3 = new StatisticalDescription();
		struct3.setMax(230L); 
		struct2.setMean((double) 1080/(double) 6);
		struct3.setMedian(170L);//TODO test
		struct3.setMin(140L);
		struct3.setStandardDeviation(-1); //TODO
		struct3.setVariance(-1); //TODO

		StatisticalDescription struct4 = new StatisticalDescription();
		struct4.setMax(230L); 
		struct4.setMean((double) 1030/(double) 6);
		struct4.setMedian(165L);//TODO test
		struct4.setMin(140L);
		struct4.setStandardDeviation(-1); //TODO
		struct4.setVariance(-1); //TODO
		stats.add(struct0); 
		stats.add(struct1); 
		stats.add(struct2); 
		stats.add(struct3); 
		stats.add(struct4);
		return stats.equals(tc.getProcessCharacterisations());
	}

	private boolean testReflection2(int stepWidth){
		tm.timerClassName = "de.uka.ipd.sdq.TimerMeter.NanoTime_TimerMeterTest";
		tm.timerMethodIsStatic = false;
		tm.timerMethodName = "timersimple";
		tm.timerMethodUnit = "ns";
		tm.initialiseInvokableTimerMethod();
		return testReflection(stepWidth);
	}
		
	private boolean testReflection(int stepWidth){
		tm.parseArguments(new String[]{
				new String(""+30000) /*numberOfWarmupTimerInvocations*/,
				new String(""+20)    /*numberOfProcessRepetitions*/,
				new String(""+400)   /*numberOfMeasurements*/,
				new String(""+stepWidth)     /*iterationIncreaseStepWidth*/,
				new String(""+1000)   /*numberOfIterationIncreaseSteps*/,
				new String(""+2)    /*clusterFormationThresholdDistance*/,
		});
		if(!tm.initialiseInvokableTimerMethod()){
			System.err.println("Could not initialise invokable timer method");
			return false;
		}else{
			System.out.println("Could successfully initialise invokable timer method");
		}
		if(tm.getInvokableTimerMethod()!=null){
			try{
				long[][] resultsFromReflection = tm.obtainMeasurementsUsingReflection();
				TimerCharacterisation tc = tm.computeTimerCharacterization(resultsFromReflection, false);
				System.out.println(tc.getAllMeasurementsHistogram());
				System.out.println(tc);
				System.out.println("Reflection succeeded");
				return true;
			}catch (Exception e) {
				System.err.println("Reflection-oriented test failed at some point");
				e.printStackTrace();
				return false;
			}
		}else{
			System.err.println("Invokable timer method is null");
			return false;
		}
	}
}
