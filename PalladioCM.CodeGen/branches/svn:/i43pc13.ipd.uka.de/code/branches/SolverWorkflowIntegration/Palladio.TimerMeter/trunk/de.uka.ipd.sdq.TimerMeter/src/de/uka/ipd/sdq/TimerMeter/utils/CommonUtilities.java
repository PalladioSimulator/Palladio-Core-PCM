package de.uka.ipd.sdq.TimerMeter.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import JSci.maths.statistics.NormalDistribution;

/** This class collects common utilities (math, stats, plotting etc.) needed by
 * <code>AbstractTimerMeter</code>. 
 * @author Michael Kuperberg
 * @version 0.9
 */
public class CommonUtilities {
	
	/**
	 * As we do not use a logging framework to minimize dependencies, 
	 * this field simplifies coding using <code>System.err</code> :-)
	 */
	private static PrintStream e = System.err;

	/**
	 * The logger instance (log4j) as a supplement to <code>e</code> and <code>o</code>.
	 */
	private static Logger logger;
	
	/**
	 * As we do not use a logging framework to minimize dependencies, 
	 * this field simplifies coding using <code>System.out</code> :-)
	 */
	private static PrintStream o = System.out;

//	public static void main(String args[]){
//		CommonUtilities cu = new CommonUtilities();
//		System.out.println(cu.computeCharacteristics(new Double[]{2d,4d,2d,3d,5d}, true));
//	}

	private static CommonUtilities singleton;
	
	/**
	 * This method adds two <code>Map</code>s, weighted by the specified factors. 
	 * It assumes that the two <code>Map</code>s have the same keys; otherwise, 
	 * it returns <code>null</code> and prints a warning. The input parameters
	 * are not altered.   
	 * @param factor1 The weighting of the first summand.
	 * @param summand1 The first summand.
	 * @param factor2 The weighting of the second summand.
	 * @param summand2 The second summand.
	 * @return the (partial) result of the addition, 
	 * or <code>null</code> if the keys of the maps do not match.
	 */
	public static Map<Integer,Double> addSameKeyedMaps(
			int factor1, 
			Map<Integer,Double> summand1, 
			int factor2, 
			Map<Integer,Double> summand2){
		TreeSet<Integer> summand1Keyset = new TreeSet<Integer>(summand1.keySet());
		TreeSet<Integer> summand2Keyset = new TreeSet<Integer>(summand2.keySet());
		if(!summand1Keyset.equals(summand2Keyset)){
			o.println("KeyedMaps have different/incompatible keysets! Aborting addition, returning null");
			return null;
		}
		Map<Integer,Double> resMap = new HashMap<Integer, Double>();
		try{
			List<Integer> dstKeysList = Arrays.asList(summand2.keySet().toArray(new Integer[0]));
			List<Double> srcValuesList = Arrays.asList(summand1.values().toArray(new Double[0]));
			List<Double> dstValuesList = Arrays.asList(summand2.values().toArray(new Double[0]));
			for(int i=0;i<srcValuesList.size();i++){
				resMap.put(dstKeysList.get(i), new Double(factor1*srcValuesList.get(i)+factor2*dstValuesList.get(i)));
			}
		}catch (Exception err) {
			err.printStackTrace();
			e.println("Addition failed despite key check; returning partial result");
		}
		return resMap;
	}
	
	/**
	 * This method adds two <code>Map</code>s. 
	 * It assumes that the two <code>Map</code>s have the same keys; otherwise, 
	 * it returns <code>null</code> and prints a warning. The input parameters
	 * are not altered.   
	 * @param summand1 The first summand.
	 * @param summand2 The second summand.
	 * @return the (partial) result of the addition, 
	 * or <code>null</code> if the keys of the maps do not match.
	 */
	public static Map<Integer,Double> addSameKeyedMaps(
			Map<Integer,Double> summand1, 
			Map<Integer,Double> summand2){
		return addSameKeyedMaps(1, summand1, 1, summand2);
	}

	/**
	 * TODO move back to AbstractTimerMeter and rename to show this method's specific nature
	 * 
	 * Sketch of work for threshold==2 ("entry" := one element of 
	 * <code>allMeasurementsHistogram</code>): 
	 * if a cluster with 3 elements (i.e. x, x+1, x+2) appears: 
	 * re-visit existing clusters and break them into one-entry-per-cluster 
	 * (or, simpler: discard existing clusters and re-traverse 
	 * <code>allMeasurementsHistogram</code> with a threshold of <1).
	 * 
	 * The return of this method should be postprocessed by another method
	 * that computes the accuracy as greatest common divisor of cluster 
	 * distances. However, this is tricky, as some two-classes clusters may 
	 * not have any values from one class, e.g. [(100,101), (200,201), (300), (400,401)],
	 * or some classes may have been skipped altogether... 
	 * Just work with "+-1" cluster distances (this does not work with "2" or 
	 * other small accuracies)? Or should we "fill" non-existing classes?
	 * In fact, we cannot guarantee that all classes are present...
	 * 
	 * For future work: can we make any statements about the "Nachkommastelle" 
	 * from the frequencies of the classes?
	 * 
	 * @param allMeasurementsHistogram
	 * @param clusterFormationThresholdDistance the maximum distance (incl.) 
	 * from the leftmost [smalles] element of the current cluster 
	 * so that the considered <code>allMeasurementsHistogram</code> entry 
	 * can still be added to the current cluster.
	 * @return
	 */
	public static List<MeasurementGroupsCluster> clusterTimerValuesFromHistogram(
			SortedMap<Long, Integer> allMeasurementsHistogram,
			int clusterFormationThresholdDistance) {
		if(clusterFormationThresholdDistance!=2){
			logger.error("Cluster formation threshold distance must be 2; exiting prematurely.");
			return null;
		}
		if(allMeasurementsHistogram==null){
			logger.error("Cannot cluster a null histogram, returning null");
			return null;
		}
		if(allMeasurementsHistogram.isEmpty()){
			logger.error("Cannot cluster an empty histogram, returning null");
			return null;
		}
		List<MeasurementGroupsCluster> clusterList = new ArrayList<MeasurementGroupsCluster>();
		Iterator<Long> keyIter = allMeasurementsHistogram.keySet().iterator();
//		boolean lastClusterNotYetAdded
		
		Long lastKey = keyIter.next();
		Integer lastValue = allMeasurementsHistogram.get(lastKey);
		Long currClusterLeftBound = lastKey;
		MeasurementGroupsCluster currCluster = new MeasurementGroupsCluster(new TreeMap<Long, Integer>());
		currCluster.addData(lastKey, lastValue);
		int numberOfClassesInCurrentCluster=1;
		
		Long currKey;
		Integer currValue;
		boolean clusterHaveTwoOrLessClasses=true;
		while(keyIter.hasNext() && clusterHaveTwoOrLessClasses){
			currKey = keyIter.next();
			currValue = allMeasurementsHistogram.get(currKey);
			if(currClusterLeftBound+clusterFormationThresholdDistance>=currKey){
				if(numberOfClassesInCurrentCluster==2){
					clusterHaveTwoOrLessClasses=false; //equal to leaving the loop
					logger.debug("a further class (key="+currKey+") about " +
							"to be added to a cluster with already 2 classes : "+
							currCluster);
				}else{
					currCluster.addData(currKey, currValue);
					numberOfClassesInCurrentCluster++;
				}
			}else{
				clusterList.add(currCluster);
				currCluster = new MeasurementGroupsCluster(new TreeMap<Long, Integer>());
				currClusterLeftBound = currKey;
				currCluster.addData(currKey, currValue);
				numberOfClassesInCurrentCluster = 1;
			}
		}
		clusterList.add(currCluster);//last cluster is always dangling...

		
		if(!clusterHaveTwoOrLessClasses){
			clusterList = new ArrayList<MeasurementGroupsCluster>();
			for (Iterator<Long> iterator = allMeasurementsHistogram.keySet().iterator(); iterator.hasNext();) {
				currKey = iterator.next();
				currValue = allMeasurementsHistogram.get(currKey);
				clusterList.add(new MeasurementGroupsCluster(currKey,currValue));
			}
		}
		
		return clusterList;
	}
	
	/**
	 * See description of returned value. TODO make sure the values are sorted indeed.
	 * @param quartiledSortedMeasurements
	 * @return a <code>Map</code> with the smallest cluster element as the key
	 *         and the number of cluster elements as value
	 */
	public static Map<Long, Integer> clusterValues(
			List<Long> quartiledSortedMeasurements, 
			int threshold) {
		System.out.println("Classifying measurements with clusterFormationThresholdDistance "+threshold);
		// TODO: insert assert statements to ensure that 
		// list of measurements is not empty
		Map<Long, Integer> classification = new TreeMap<Long, Integer>();
		Long currKey;
		Long currMeasurement;
		int currClusterSize = 1;
		Iterator<Long> iter = quartiledSortedMeasurements.iterator();
		currMeasurement = iter.next();
		currKey = currMeasurement;

		while(iter.hasNext()) {// makes lazy updates; does not constuct
									// actual clusters or analyses them
			currMeasurement = iter.next();
			if (currMeasurement < currKey + threshold) {// list sorted
														// ascendingly - to be
														// tested!
//				o.println("DEBUG: meas="+currMeasurement+", cluster="+currKey+"-> same cluster");
				currClusterSize++;
			} else {// methodReturnAtMeasurementStart a new cluster
//				o.println("DEBUG: meas="+currMeasurement+", cluster="+currKey+"-> new cluster");
				classification.put(currKey, currClusterSize);
				currKey = currMeasurement;
				currClusterSize = 1;
			}
		}
		classification.put(currKey, currClusterSize);
		// TODO: add cluster output [later] 
		// (though it can be reconstructedfrom cluster sizes)
//		o.println("DEBUG: "+classification.size());
		return classification;
	}
	
	/**
	 * TODO test me
	 * See description of returned value.
	 * @param quartiledSortedMeasurements
	 * @return a <code>Map</code> with the smallest cluster element as the key
	 *         and the number of cluster elements as value
	 */
	public static Map<Long, Integer> clusterValues(
			long[] values, 
			int threshold) {
		System.out.println("Classifying measurements with clusterFormationThresholdDistance "+threshold);
		// TODO: insert assert statements to ensure that 
		// list of measurements is not empty
		SortedMap<Long, Integer> classification = new TreeMap<Long, Integer>();
		Long currKey = values[0];
		int currClusterSize = 1;
		for(int i=0; i<values.length; i++) {// makes lazy updates; does not constuct
									// actual clusters or analyses them
			
			if (values[i] < currKey + threshold) {// list sorted
														// ascendingly - to be
														// tested!
//				o.println("DEBUG: meas="+currMeasurement+", cluster="+currKey+"-> same cluster");
				currClusterSize++;
			} else {// methodReturnAtMeasurementStart a new cluster
//				o.println("DEBUG: meas="+currMeasurement+", cluster="+currKey+"-> new cluster");
				classification.put(currKey, currClusterSize);
				currKey = values[i];
				currClusterSize = 1;
			}
		}
		classification.put(currKey, currClusterSize);
		// TODO: add cluster output [later] 
		// (though it can be reconstructedfrom cluster sizes)
//		o.println("DEBUG: "+classification.size());
		return classification;
	}
	
	/**
	 * TODO document me please
	 * TODO replace through greatest-common-divisor scheme (or add it testwise...)
	 * @param clusters
	 * @return
	 */
	public static long computeAccuracyFromClusters(List<MeasurementGroupsCluster> clusters, boolean verbose) {
		Iterator<MeasurementGroupsCluster> iter = clusters.iterator();
		MeasurementGroupsCluster second = iter.next();//TODO check if there
		MeasurementGroupsCluster first;
		long accuracyFromTwoGroupedClusters = Long.MAX_VALUE;
		long accuracyAnyClusters = Long.MAX_VALUE;
		long firstLeftBound = 0L;
		long secondLeftBound = 0L;
		int firstNumberOfClasses;
		int secondNumberOfClasses;
		long boundDistance; 
		int clusterIndex=0;
		while(iter.hasNext()){
			first = second;
			second = iter.next();
			firstLeftBound = first.getClusterValueMinimum();
			secondLeftBound = second.getClusterValueMinimum();
			firstNumberOfClasses = first.getClassesNumberInCluster();
			secondNumberOfClasses = second.getClassesNumberInCluster();
			boundDistance = secondLeftBound-firstLeftBound;
			if(firstNumberOfClasses==2 && secondNumberOfClasses==2){
				if(boundDistance<accuracyFromTwoGroupedClusters){
					if(verbose) logger.debug("Distance "+boundDistance+" is smaller " +
							"than the current accuracy from two-grouped " +
							"clusters ("+accuracyFromTwoGroupedClusters+")");
					accuracyFromTwoGroupedClusters = boundDistance;
				}else{
					if(verbose) logger.debug("Distance "+boundDistance+" is not smaller " +
							"than the current accuracy from two-grouped " +
							"clusters ("+accuracyFromTwoGroupedClusters+")");
				}
			}else{
				if(verbose) logger.debug("Clusters with " +
						"index "+clusterIndex+"(in-cluster min: "+firstLeftBound+") and " +
						"index "+(clusterIndex+1)+"(in-cluster min: "+secondLeftBound+") " +
						"do not both have 2 innerclasses.");
			}
			if(boundDistance<accuracyAnyClusters){
				if(verbose) logger.debug("Distance "+boundDistance+" is smaller " +
						"than the current accuracy from " +
						"any clusters ("+accuracyAnyClusters+")");
				accuracyAnyClusters = boundDistance;
			}else{
				if(verbose) logger.debug("Distance "+boundDistance+" is not smaller " +
						"than the current accuracy from " +
						"any clusters ("+accuracyAnyClusters+")");
			}
			clusterIndex++;
		}
		if(verbose) logger.debug("At the end: accuracy from two-classed clusters: " +
				accuracyFromTwoGroupedClusters+", accuracy from " +
				"all clusters: "+accuracyAnyClusters+".");
		if(((accuracyAnyClusters-accuracyFromTwoGroupedClusters)*(accuracyAnyClusters-accuracyFromTwoGroupedClusters))<=1){
			//TODO document
			return accuracyFromTwoGroupedClusters;
		}else{
			//TODO document
			return accuracyAnyClusters;
		}
	}
	
	/**
	 * TODO test me
	 * no quartile cutting is done
	 * @param measurements
	 * @param logValues
	 * @return
	 * @deprecated because unneeded (?)
	 * TODO test me
	 */
	@SuppressWarnings("nls")
	public static StatisticalDescription computeCharacteristics(
			Double[] measurements, 
			boolean logValues){
		StatisticalDescription statDesc = new StatisticalDescription();
		Double[] sortedValues = measurements.clone();
		Arrays.sort(sortedValues);
		
		if(sortedValues.length%2==0){
			int index = sortedValues.length/2;
			statDesc.setMedian(0.5*(sortedValues[index-1]+sortedValues[index]));
		}else{
			statDesc.setMedian(sortedValues[sortedValues.length/2]);
		}
		
		Double sum = 0D;
		Double mean = 0D;
		Double sumOfSquaredDistances = 0D;
		int numberOfMeasurements = sortedValues.length;
		
		for (int i = 0; i < numberOfMeasurements; i++) {
			if(logValues){
				System.out.print("Measurement "+(i+1)+" (out of "+numberOfMeasurements+"):"+
						sortedValues[i]+", ");
			}
			sum+=sortedValues[i];
		}
		if(logValues){
			System.out.println(" DONE: sum is "+sum);
		}
		mean=sum/numberOfMeasurements;
		statDesc.setMean(mean);
		
		for (int i = 0; i < numberOfMeasurements; i++) {
			if(logValues){
				System.out.print("difference: "+(sortedValues[i]-mean)+", ");
			}
			sumOfSquaredDistances += Math.pow((sortedValues[i]-mean),2);
			if(logValues) {
				System.out.print("sum of squared distances is now "+sumOfSquaredDistances+",");
			}
		}
		if(logValues) {
			System.out.println(" DONE: sumOfSquaredDistances is "+sumOfSquaredDistances);
		}
		statDesc.setVariance(sumOfSquaredDistances/numberOfMeasurements);
		return statDesc;
		
//		Double[] characteristics = new Double[]{(sumOfSquaredDistances/numberOfMeasurements),mean};
//		return characteristics;
	}
	
	/**
	 * @param measurements
	 * @param logValues
	 * @return
	 * @deprecated because replace by computeCHaracteristics_detailed
	 * TODO test me
	 */
	public static StatisticalDescription computeCharacteristics(
			long[] measurements, 
			boolean logValues){
		Double[] retArray = new Double[measurements.length];
		for(int i=0;i<measurements.length;i++){
			retArray[i] = (double) measurements[i];
		}
		return computeCharacteristics(retArray, logValues);
	}
	
	/**
	 * @param measurements
	 * @param logValues
	 * @return
	 * @deprecated because unneeded (?)
	 * TODO test me
	 */
	public static StatisticalDescription computeCharacteristics(
			Long[] measurements, 
			boolean logValues){
		Double[] retArray = new Double[measurements.length];
		for(int i=0;i<measurements.length;i++){
			retArray[i] = measurements[i].doubleValue();
		}
		return computeCharacteristics(retArray, logValues);
	}
	
	/**
	 * @param measurements
	 * @param logValues
	 * @return
	 * TODO test me
	 * TODO set all fields!
	 */
	public static StatisticalDescription computeCharacteristics_detailed(
			long[] measurements, 
			boolean logValues){
		StatisticalDescription ret = new StatisticalDescription();
		long[] sortedValues = measurements.clone();//TODO document cloning
		Arrays.sort(sortedValues);
		
		ret.setMax(sortedValues[sortedValues.length-1]);
		
		Double sum = 0D;
		Double mean = 0D;
		int numberOfMeasurements = sortedValues.length;
		for (int i = 0; i < numberOfMeasurements; i++) {
			if(logValues){
				logger.debug("Measurement "+(i+1)+" " +
						"(out of "+numberOfMeasurements+"):"+
						sortedValues[i]+", ");
			}
			sum+=sortedValues[i];
		}
		if(logValues){
			System.out.println(" DONE: sum is "+sum);
		}
		mean=sum/numberOfMeasurements;
		ret.setMean(mean);

		if(sortedValues.length%2==0){//TODO test me
			int index = sortedValues.length/2;
			ret.setMedian((sortedValues[index-1]+sortedValues[index])/2);
			ret.setMedian_real_element(sortedValues[index-1]);
		}else{
			ret.setMedian(sortedValues[sortedValues.length/2]);
			ret.setMedian_real_element(sortedValues[sortedValues.length/2]);
		}
		
		ret.setMin(sortedValues[0]);

		Double sumOfSquaredDistances = 0D;
		for (int i = 0; i < numberOfMeasurements; i++) {
			if(logValues){
				logger.debug("difference: "+(sortedValues[i]-mean)+", ");
			}
			sumOfSquaredDistances += Math.pow((sortedValues[i]-mean),2);
			if(logValues) {
				logger.debug("sum of squared distances is now "+sumOfSquaredDistances+",");
			}
		}
		if(logValues) {
			logger.info(" DONE: sumOfSquaredDistances is "+sumOfSquaredDistances);
		}
		ret.setVariance(sumOfSquaredDistances/numberOfMeasurements);
		ret.setStandardDeviation(Math.pow(ret.getVariance(),0.5));
		return ret;
	}
	
	/**
	 * TODO test me!
	 * Computes a simple sorted histogram from <code>measurements</code> 
	 * @param measurements the input
	 * @return the resulting histogram
	 */
	public static SortedMap<Long, Integer> computeHistogram(long[] measurements) {
		SortedMap<Long, Integer> histogram = new TreeMap<Long, Integer>();
		int l = measurements.length;
		Integer currValue;
		Long currKey;
		for(int i=0; i<l; i++){
			currKey = new Long(measurements[i]);
			try{
				currValue = histogram.get(measurements[i]);
				currValue = new Integer(currValue+1);
				histogram.put(currKey,currValue);
			}catch (Exception e) {
				histogram.put(currKey,1);
			}
		}
		return histogram;
	}
	
	@SuppressWarnings("unused")
	private static MeasurementResults computeStatisticsOfMeasurements(
			List<Long> filteredMeasurements) {
		return computeStatisticsOfMeasurements(filteredMeasurements,
				Double.NaN, false);
	}
	
//	/**TODOC
//	 * @param path
//	 * @return
//	 */
//	public static boolean deleteTree(File path) {
//		logger.debug("deleteTree started");
//		boolean totalSuccess=true;
//		boolean partialSuccess = true;
//		for (File file : path.listFiles()) {
//			if (file.isDirectory()){
//				partialSuccess = deleteTree(file);
//				if(!partialSuccess){
//					totalSuccess=false;
//				}
//			}
//			partialSuccess = file.delete();
//			if(!partialSuccess){
//				totalSuccess=false;
//			}
//		}
//		partialSuccess = path.delete();
//		if(!partialSuccess){
//			totalSuccess=false;
//		}
//		return totalSuccess;
//	}
	
	private static MeasurementResults computeStatisticsOfMeasurements(
				List<Long> filteredMeasurementsAfterAscendingSorting,
				Double suggestedMean, 
				boolean meanIsCorrect) {
			int i = 0;
			boolean noOverflow = true;
			long value = 0L;
			long runningSum = 0L;
			double mean = 0D;
			@SuppressWarnings("unused")
			Long median = 0L;
			List<Long> consideredMeasurements = new ArrayList<Long>();
			List<Long> ignoredMeasurements = new ArrayList<Long>();
			@SuppressWarnings("unused")
			// TODO
			List<Long> skippedMeasurements = new ArrayList<Long>();
			o.println("size of parameter of compute statistics: "
					+ filteredMeasurementsAfterAscendingSorting.size());
	
			if (!meanIsCorrect) {
				while (i < filteredMeasurementsAfterAscendingSorting.size()
						&& noOverflow) {
					value = filteredMeasurementsAfterAscendingSorting.get(i);
					if (value <= 0) {
						o.println("Time measurement smaller than 0: skipped!");
						ignoredMeasurements.add(value);
					} else {
						if (runningSum + value < runningSum) {// overflow (since
																// value>0)
							o.println("Overflow happens when adding " + value
									+ " to " + runningSum + ", aborting after "
									+ (i + 1)
									+ " measurements and computing the result");
							noOverflow = false;
							// TODO adapt skippedMeasurements
						} else {
							runningSum += value;
							consideredMeasurements.add(value);
						}
					}
					i++;
				}
				mean = runningSum / consideredMeasurements.size();
			} else {
				mean = suggestedMean.doubleValue();
			}
	
			median = filteredMeasurementsAfterAscendingSorting
					.get(filteredMeasurementsAfterAscendingSorting.size() / 2);// TODO
																				// test
	
			long runningSumForSDComputation = 0L;
			for (Iterator<Long> iter = consideredMeasurements.iterator(); iter
					.hasNext();) {
				runningSumForSDComputation += Math.pow((iter.next() - mean), 2);
			}
			double SD = runningSumForSDComputation / consideredMeasurements.size();
			SD = Math.pow(SD, 0.5);
	
			return null;//new MeasurementResults_fromAdditivity(median, mean, SD,
	//				consideredMeasurements.size());
		}
	
	/** 
	 * Cuts the upper and lower quartiles from a <code>double</code> array, i.e.
	 * approximately 25% of its lower and 25% of its upper elements. 
	 * @param originalArray the unsorted, unquartiled input
	 * @return the sorted (!), quartiled input
	 */
	public static Double[] cutQuartilesFromDoubleArray(Double[] originalArray) {
		logger.debug("cutQuartilesFromDoubleArray started");
		Double[] currArray = originalArray.clone();
		Arrays.sort(currArray); 
		int lowerIndex = originalArray.length/4;//including
		int upperIndex = 3*lowerIndex; //excluding
		int cutResultsSize = upperIndex-lowerIndex;
		Double[] resultsAfterCuttingQuartiles = new Double[cutResultsSize];
		for(int i=0;i<cutResultsSize;i++){
			resultsAfterCuttingQuartiles[i] = originalArray[i+lowerIndex];
		}
		return resultsAfterCuttingQuartiles;
	}
	
	/**
	 * Cuts the upper and lower quartiles from a <code>long</code> array, i.e.
	 * approximately 25% of its lower and 25% of its upper elements. 
	 * @param originalArray the unsorted, unquartiled input
	 * @return the sorted (!), quartiled input
	 */
	public static long[] cutQuartilesFromLongArrayAndSortResult(long[] originalArray) {
		logger.debug("cutQuartilesFromLongArray started");
		long[] currArray = originalArray.clone();
		Arrays.sort(currArray);
		int lowerIndex = currArray.length/4;//including
		int upperIndex = 3*lowerIndex; //excluding
		int cutResultsSize = upperIndex-lowerIndex;
		long[] resultsAfterCuttingQuartiles = new long[cutResultsSize];
		for(int i=0;i<cutResultsSize;i++){
			resultsAfterCuttingQuartiles[i] = currArray[i+lowerIndex];
		}
		return resultsAfterCuttingQuartiles;
	}
	
	/**
	 * TODO
	 * 
	 * @param measurements
	 * @return
	 */
	public static List<Long> filterAndSortMeasurements(List<Long> measurements,
			boolean cutQuartiles) {
		if (measurements == null) {
			o.println("Cannot filter measurement from a null list");
			return null;
		} else if (measurements.size() < 4) {
			o.println("Cannot filter measurement from a list with less than"
					+ "four (4) elements.");
			return null;
		}
		List<Long> deepCopy = new ArrayList<Long>();
		for (Iterator<Long> iter = measurements.iterator(); iter.hasNext();) {
			deepCopy.add(iter.next());
		}
		Collections.sort(deepCopy);
		int size = measurements.size();

		int fromIndex = 0;
		int toIndex = measurements.size();
		if (cutQuartiles) {
			fromIndex = size / 4;
			toIndex = (fromIndex * 3); // NOT subtracting 1, because the
										// toIndex is non-inclusive (cf.
										// JavaDocs)
//			o.println("Filtering restricts returned array to [" + fromIndex
//					+ "," + toIndex + ")");
			return deepCopy.subList(fromIndex, toIndex);
		} else {
			return deepCopy;
		}
	}

	/** 
	 * This method formats the given list of <code>Double</code> arrays as 
	 * a string (it returns "<null>" if the list is null and "<empty>" if it
	 * is empty. The method is not optimised for performance (yet). It is not
	 * thread-safe, and does not alter the input parameter.
	 * @param result the input list of <code>Double</code> arrays
	 * @return representation of the input as <code>String</code>
	 */
	public static String formatListOfDoubleTuplesAsString(List<Double[]> result) {
		StringBuffer sb = new StringBuffer();
		if(result==null){
			sb.append("<null>");
		}else if(result.size()==0){
			sb.append("<empty>");
		}else{
			sb.append("[");
			for(int i=0;i<result.size();i++){//TODO replace with an iterator
				sb.append(Arrays.toString(result.get(i))+" , ");
			}
			sb.append("]");
		}
		return sb.toString();
	}

	/**
	 * Public constructor of the instance
	 */
	public static CommonUtilities getInstance(){
		if(singleton!=null){
			return singleton;
		}else{
			singleton = new CommonUtilities();
			return singleton;
		}
	}
	
	static{	
		logger = Logger.getLogger("CommonUtilities");
		BasicConfigurator.configure();
	}

	public static long getMeanOfUnsortedList(List<Long> list){
		long runningSum = 0L;
		for (Iterator<Long> iter = list.iterator(); iter.hasNext();) {
			runningSum+=iter.next();
		}
		return runningSum/list.size();
	}

	public static long getMedianOfUnsortedList(List<Long> list){
		List<Long> sorted = filterAndSortMeasurements(list, false);
		return sorted.get(sorted.size()/2);
	}

	/**
	 * Measure average invocation duration of <code>java.lang.System.nanoTime()</code>
	 * using a simplicistic approach that computes the average of 
	 * <code>nrOfMeasurements</code> measurements. Does not measure minimum,
	 * median, maximum, or standard deviation. See proper AbstractTimerMeter classes 
	 * for better results.
	 * @param nrOfMeasurements number if times the measurement is repeated.
	 * @deprecated because too simplistic and returning a very simple result
	 * @return the computed average invocation cost of <code>nanoTime()</code>
	 * TODO merge with measureMedianNanotimeInvocationCost?
	 */
	public static long measureAverageNanotimeInvocationCost(int nrOfMeasurements) {
		long start=0L;
		long finish=0L;
		long retValue=0L;
		for(int i=0;i<nrOfMeasurements;i++){
			start = System.nanoTime();
			finish = System.nanoTime();
			retValue += (finish-start);
		}
		return retValue/nrOfMeasurements;
	}

	/** 
	 * Oversimplistic implementation of median invocation cost of 
	 * <code>java.lang.System.nanoTime()</code>. Only for study purposes.
	 * @param nrOfMeasurements number of measurements
	 * @return median of <code>nrOfMeasurements</code> measurements, each 
	 * one performed by a method call (!)
	 * @deprecated because oversimplisitic; included here for study purposed - 
	 * not for real use! Use proper AbstractTimerMeter classes instead.
	 * TODO merge with measureAverageNanotimeInvocationCost?
	 */
	public static long measureMedianNanotimeInvocationCost(
			int nrOfMeasurements){
		logger.debug("getMedianDurationOfTimeMeasurement(int) started");
		long[] measurements = new long[nrOfMeasurements];
		for(int i=0; i<nrOfMeasurements; i++){
			measurements[i] = measureAverageNanotimeInvocationCost(1);
		}
		logger.debug("Measurements: "+Arrays.toString(measurements));
		Arrays.sort(measurements);
		logger.debug("Smallest measurement: "+measurements[0]+", " +
				"largest measurement: "+measurements[measurements.length-1]);
		return measurements[measurements.length/2];
	}

	/**
	 * Plot of the measurement data using JFreeChart.
	 * @param sortedMeasurements
	 * @param timerMethodName
	 * @deprecated because an import is missing
	 */
	public static void plotHistogram(
			List<Long> sortedMeasurements, 
			String timerMethodName) {
		if (sortedMeasurements == null || sortedMeasurements.size() == 0) {
			o.println("Histogramm: no measurements");
			return;
		}
		TreeMap<Long, Integer> output = new TreeMap<Long, Integer>();
		long current = sortedMeasurements.get(0);
		int count = 1;
		for(int i = 0; i < sortedMeasurements.size(); i++) {
			if(sortedMeasurements.get(i) == current) {
				count++;
			} else {
				output.put(current, count);
				current = sortedMeasurements.get(i);
				count = 1;
			}
		}
		o.println("Histogram:");
		o.println(output);

		int MINIMUM_COUNT = 50;	// minimum number of occurences for the number to be drawn
		DefaultCategoryDataset hist = new DefaultCategoryDataset();
//		HistogramDataset hist = new HistogramDataset();
//		hist.setType(HistogramType.FREQUENCY);
		for(long key : output.keySet()) {
			if(key > 400 && key < 500 && output.get(key) >= MINIMUM_COUNT) {
				hist.addValue((Number)output.get(key), "", key);
			}
		}
//		hist.addSeries(key, new double[]{output.get(key)}, output.size()/3);

		writeMapToCSV(output, "timerhist_" + timerMethodName + "_out.csv");

        JFreeChart chart = ChartFactory.createBarChart(
                "Histogram for " + timerMethodName, 
                "Time", 
                "Count", 
                hist, 
                PlotOrientation.VERTICAL, 
                false, 
                false, 
                false
            );
        // no space between bars:
        chart.getCategoryPlot().getDomainAxis().setCategoryMargin(0);
        chart.getCategoryPlot().getDomainAxis().setLowerMargin(0);
        chart.getCategoryPlot().getDomainAxis().setUpperMargin(0);
        ((BarRenderer)chart.getCategoryPlot().getRenderer()).setMaximumBarWidth(0.01);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
			    public void run() {
//			        new JFreeChartHistogram(chartPanel).start();//TODO --> Martin
			    }
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Evaluates the number of values in a class using JScience package, 
	 * assuming normal distribution (?!).
	 * @param classification The classification as in computeClassification.
	 * TODO Martin: check whether 'clean' statistics are used
	 * TODO use in my program
	 * TODO test m
	 * @deprecated until the validity of the normal-distribution assumption is checked 
	 */
	public static void printStatisticsForStepWidth(Map<Long, Integer> classification) {
		Long[] classificationKeys = 
			classification.keySet().toArray(new Long[classification.keySet().size()]);
		double[] stepWidths = new double[(classificationKeys.length)]; 
		for(int i = 0; i < classificationKeys.length; i ++) {
			o.print("Entries in cluster with key " + classificationKeys[i] + ": ");
			o.print(classification.get(classificationKeys[i]) + ";\t");
			stepWidths[i] = classification.get(classificationKeys[i]);
			// new line after 3 widths
			if(i%3 == 2) {
				o.println();
			}
		}
		o.println();
		
		NormalDistribution distr = new NormalDistribution(stepWidths);
		o.println("Mean of _all_ step widths: " + distr.getMean());
		o.println("Variance of _all_ step widths: " + distr.getVariance());
	}

	/**
	 * @param source
	 * @param destination
	 */
	public static void rearrangeMeasurementsByValue(
			
	SortedMap<Integer, SortedMap<Long, Integer>> source, SortedMap<Long, SortedMap<Integer, Integer>> destination
			) {
		Integer currInputKey;
		SortedMap<Long, Integer> currInputValue;
		Long currInputValue_currInternalKey;
		Integer currInputValue_currInternalValue;
		SortedMap<Integer, Integer> currOutputValue;
		Iterator<Integer> currOuterIterator = source.keySet().iterator();
		Iterator<Long> currInnerIterator;
		int processIndex=0;
		for (; currOuterIterator.hasNext();) {//iterate over histogram elements by process
			//process' index
			currInputKey = currOuterIterator.next(); 
			//process' histogram
			currInputValue = source.get(currInputKey); 
			//iterator over current process' histogram KEYS (i.e. diff values)
			currInnerIterator = currInputValue.keySet().iterator(); 
			for( ; currInnerIterator.hasNext(); ){
				//timer diff VALUE for the current process
				currInputValue_currInternalKey = currInnerIterator.next(); 
				//timer diff COUNT for the current process
				currInputValue_currInternalValue = currInputValue.get(currInputValue_currInternalKey); 
				try{
					//1. trying to get a histogram entry for this diff
					currOutputValue = destination.get(currInputValue_currInternalKey);
					//1a. OK, such a map exists
					currOutputValue.put(currInputKey, currInputValue_currInternalValue); 
	//					currValue = new Integer(currValue+1);
	//					histogram.put(currKey,currValue);
				}catch (Exception e) {
					//1b.1 such a map does not exists, create it
					currOutputValue = new TreeMap<Integer, Integer>();
					//1b.2 add <process_index, count_for_this_long_value_for_this_process> to the map
					currOutputValue.put(currInputKey, currInputValue_currInternalValue); //TODO check if this is effective
					//1b.3 add the "inner map" to the "outer map" 
					destination.put(currInputValue_currInternalKey, currOutputValue);
				}
			}
			processIndex++;
		}
	//		o.println("Input "+timerMeterMeasurements);
	}

	/**
	 * Save the <code>results</code> into a JPG chart file with <code>title</code>,
	 * x-axis "iteration", y-axis "duration", and computes the file name using
	 * System.currentTimeMillis(). Chart x-size is 500 and y-size is 300.
	 * @param data that is saved as chart
	 * @param title of the chart
	 * @return the canonical (unique, absolute) file name 
	 * under which the resulting chart has been saved.
	 */
	public static String saveResultsAsChart(long[] data, String title) {
		logger.debug("saveResultsAsChart started");
		XYSeries series = new XYSeries("Duration");
		for(int i=0;i<data.length;i++)
		{
			series.add(i, data[i]);
		}
		XYDataset xyDataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart
	         (title,
	                 "iteration",
	                 "duration",
	                 xyDataset,
	                 PlotOrientation.VERTICAL,
	                 false,
	                 true,
	                 true);
		File chartFile = new File("Chart_"+System.currentTimeMillis()+".jpg");
		try {
			ChartUtilities.saveChartAsJPEG(chartFile, chart, 500, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return chartFile.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Could not obtain the canonical path of the " +
					"created chart file; returning null");
			return null;
		}
	}

	/**
	 * Quick hack to write CSV files.
	 * @param dataToWrite data to write
	 * @param filename file name to write to (not being checked for 
	 * overwriting, creation etc. - may throw exceptions).
	 * @return the number of lines written into the CSV file.
	 */
	public static int writeMapToCSV(
			TreeMap<Long, Integer> dataToWrite,
			String filename) {
		logger.debug("Writing a map to CSV file, filename: "+filename+", data: "+dataToWrite);
		int writtenLines = 0;
		if(dataToWrite==null){
			logger.error("No elements in output to write; aborting.");
			return writtenLines;
		}
		FileOutputStream os = null;
		try {
			o.println("Writing " + filename);
			os = new FileOutputStream(new File(filename));
			for(long key : dataToWrite.keySet()) {
				String line = key + ", " + dataToWrite.get(key) + "\n";
				os.write(line.getBytes());
				writtenLines++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return writtenLines;
	}
//	/** Can be optimized ;-)
//	 * @deprecated
//	 * @param nrOfMeasurements
//	 * @param cutQuartiles
//	 * @return
//	 */
//	public static long getAverageDurationOfTimeMeasurement(int nrOfMeasurements, boolean cutQuartiles){
//		logger.debug("getDurationOfNothing(int,boolean) started");
//		long retValue = 0l;
//		long[] measurements = new long[nrOfMeasurements];
//		for(int i=0; i<nrOfMeasurements; i++){
//			measurements[i] = measureAverageNanotimeInvocationCost(nrOfMeasurements);
//		}
//		logger.debug("Measurements: "+Arrays.toString(measurements));
//		long[] measurementsForAnalysis = measurements.clone();
//		Arrays.sort(measurementsForAnalysis);
//		logger.debug("Smallest measurement: "+measurementsForAnalysis[0]+", " +
//				"largest measurement: "+measurementsForAnalysis[measurementsForAnalysis.length-1]);
//		long[] consideredMeasurments; 
//		if(cutQuartiles){
//			consideredMeasurments = this.cutQuartilesFromLongArrayAndSortResult(measurements);
//		}else{
//			consideredMeasurments = measurements;
//		}
//		logger.debug("Considered measurements: "+Arrays.toString(consideredMeasurments));
//		for(int i=0;i<consideredMeasurments.length;i++){
//			retValue += consideredMeasurments[i];
//		}
//		retValue /= consideredMeasurments.length;
//		return retValue;
//	}
//	
//	private static final int ITERATIONS_TO_MEASURE_SMALLEST_TIME_STEP = 1000;
//	/**TODOC
//	 * @return 0d as of now 
//	 * @deprecated*/
//	@SuppressWarnings({ "dep-ann" })
//	public Double getDurationOfNothing() {
//		logger.debug("getDurationOfNothing(BenchmarkExecutor) started");
//		List<java.lang.Double> durations = new Vector<Double>();
//		long before = 0L;
//		long after = 0L;
//		for(int i=0;i<CommonUtilities.ITERATIONS_TO_MEASURE_SMALLEST_TIME_STEP;i++){
//			before = System.nanoTime();
//			after = System.nanoTime();
//			if(after>=before){
////				logger.debug("iteration "+i+" after-before: "+(after-before));
//				durations.add(new Double(after-before));
//			}else{
////				logger.fatal("JRE has nonconsistent nanoTime behaviour:" +
////						" a later measurement yields smaller ns value");
//			}
////			System.gc();
////			try {
////				Thread.sleep(1000);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//		}
////		Double[] res = null;//TODO bmexec.computeCharacteristics(durations.toArray(new Double[0]),false);
////		logger.debug("Mean duration of nothing: "+res[1]+" (SD: "+Math.pow(res[0],0.5)+")");
//		return null;//res[1];
//	}

	private CommonUtilities(){
//		BasicConfigurator.configure();
	}
	
	
}
