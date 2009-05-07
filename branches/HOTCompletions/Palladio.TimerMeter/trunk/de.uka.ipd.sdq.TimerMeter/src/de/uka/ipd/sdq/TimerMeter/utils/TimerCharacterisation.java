package de.uka.ipd.sdq.TimerMeter.utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

import org.apache.log4j.Logger;

/**
 * @author Michael Kuperberg
 * Invocation cost statistics and accuracy (resolution) still missing.
 * TODO implement defined "distilled results only" behaviour
 * @version 0.9
 */
public class TimerCharacterisation implements Serializable/*, Comparable<TimerCharacterisation>*/{

	private Object platformCharacterisation; //TODO - sollte von Vasili kommen
	
	private static final long serialVersionUID = 1L;
	private long accuracy;
	private double externallyDeterminedTimerFrequency;
	private double externallyDeterminedTimerInvocationCost;
	private boolean frequencyOfTimerSpecifiedExternally;
	private StatisticalDescription invocationCost;
	private boolean invocationCostOfTimerSpecifiedExternally;
	private Logger logger;
	private StatisticalDescription processed_allMeasurementsCharacterisation;
	private SortedMap<Long, Integer> processed_allMeasurementsHistogram;
	private List<MeasurementGroupsCluster> processed_clusters;
	private SortedMap<Integer, SortedMap<Long, Integer>> processed_histogramElementsByProcess;
	private SortedMap<Long, SortedMap<Integer, Integer>> processed_histogramElementsByValue;
	private List<StatisticalDescription> processed_processCharacterisations;
	private long[][] raw_allInitialMeasurements; //TODO make transient? or shift to a MeasurementResults instance?
	private long[] raw_allMeasurementsAppendedAndSorted; //TODO make transient? or shift to a MeasurementResults instance?
	
	public TimerCharacterisation(){
		logger = Logger.getLogger(this.getClass().getCanonicalName());
	}
	
	public StatisticalDescription computeClusterWidthCharacteristicsAcrossProcesses(long clusterValue){
		logger.debug("Starting computeClusterWidthCharacteristicsAcrossProcesses");
		if(this.processed_histogramElementsByValue!=null){
			SortedMap<Integer,Integer> map = this.processed_histogramElementsByValue.get(clusterValue);
			Iterator<Integer> iterator = map.values().iterator();//note: iterating over values!
			long[] mapValuesAsLongArray = new long[map.size()];
			int arrayIndex = 0; 
			for (; iterator.hasNext();) {
				mapValuesAsLongArray[arrayIndex] = iterator.next().longValue();
				arrayIndex++;
			}
			return CommonUtilities.computeCharacteristics_detailed(mapValuesAsLongArray, false);
		}else{
			logger.error("processed_histogramElementsByValue is null; " +
					"returning null from computeClusterWidthCharacteristicsAcrossProcesses");
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 */
	@Override
	public boolean equals(Object obj) {//TODO document
		if(!(obj instanceof TimerCharacterisation)){
			return false;
		}else{
			TimerCharacterisation o = (TimerCharacterisation) obj;
			return Arrays.deepEquals(this.raw_allInitialMeasurements, o.raw_allInitialMeasurements);
//			if(this.allInitialMeasurements.length==o.allInitialMeasurements.length
//				&& this.allInitialMeasurements[0].length==o.allInitialMeasurements[0].length){
//				int i=0;
//				boolean result = true;
//				for(; i<this.allInitialMeasurements.length; i++){
//					System.
//				}
//				return result;
//			}else{
//				return false;
//			}
		}
	}

	public long getAccuracy() {
		return accuracy;
	}

	public long[][] getAllInitialMeasurements() {
		return raw_allInitialMeasurements;
	}
	
	public long[] getAllMeasurementsAppendedAndSorted() {
		return raw_allMeasurementsAppendedAndSorted;
	}

	public StatisticalDescription getAllMeasurementsCharacterisation() {
		return processed_allMeasurementsCharacterisation;
	}

	public SortedMap<Long, Integer> getAllMeasurementsHistogram() {
		return processed_allMeasurementsHistogram;
	}

	public List<MeasurementGroupsCluster> getClusters() {
		return processed_clusters;
	}

	public double getExternallyDeterminedTimerFrequency() {
		return externallyDeterminedTimerFrequency;
	}

	public double getExternallyDeterminedTimerInvocationCost() {
		return externallyDeterminedTimerInvocationCost;
	}

	public SortedMap<Integer, SortedMap<Long, Integer>> getHistogramElementsByProcess() {
		return processed_histogramElementsByProcess;
	}

	public SortedMap<Long, SortedMap<Integer, Integer>> getHistogramElementsByValue() {
		return processed_histogramElementsByValue;
	}
	
	public StatisticalDescription getInvocationCost() {
		return invocationCost;
	}
	
	public List<StatisticalDescription> getProcessCharacterisations() {
		return processed_processCharacterisations;
	}

	public StatisticalDescription getProcessed_allMeasurementsCharacterisation() {
		return processed_allMeasurementsCharacterisation;
	}

	public SortedMap<Long, Integer> getProcessed_allMeasurementsHistogram() {
		return processed_allMeasurementsHistogram;
	}

	public List<MeasurementGroupsCluster> getProcessed_clusters() {
		return processed_clusters;
	}

	public SortedMap<Integer, SortedMap<Long, Integer>> getProcessed_histogramElementsByProcess() {
		return processed_histogramElementsByProcess;
	}

	public SortedMap<Long, SortedMap<Integer, Integer>> getProcessed_histogramElementsByValue() {
		return processed_histogramElementsByValue;
	}

	public List<StatisticalDescription> getProcessed_processCharacterisations() {
		return processed_processCharacterisations;
	}

	public long[][] getRaw_allInitialMeasurements() {
		return raw_allInitialMeasurements;
	}

	public long[] getRaw_allMeasurementsAppendedAndSorted() {
		return raw_allMeasurementsAppendedAndSorted;
	}

	public boolean isFrequencyOfTimerSpecifiedExternally() {
		return frequencyOfTimerSpecifiedExternally;
	}

	public boolean isInvocationCostOfTimerSpecifiedExternally() {
		return invocationCostOfTimerSpecifiedExternally;
	}

	public void setAccuracy(long accuracy) {
		this.accuracy = accuracy;
	}

	public void setAllInitialMeasurements(long[][] timerMeterMeasurements) {
		this.raw_allInitialMeasurements = timerMeterMeasurements;
	}

	public void setAllMeasurementsAppendedAndSorted(long[] allMeasurementsAppendedAndSorted) {
		this.raw_allMeasurementsAppendedAndSorted = allMeasurementsAppendedAndSorted;
	}
	
	public void setAllMeasurementsCharacterisation(StatisticalDescription allMeasurementsCharacterisation) {
		this.processed_allMeasurementsCharacterisation = allMeasurementsCharacterisation;
	}

	public void setAllMeasurementsHistogram(SortedMap<Long, Integer> allMeasurementsHistogram) {
		this.processed_allMeasurementsHistogram = allMeasurementsHistogram;
	}

	public void setClusters(List<MeasurementGroupsCluster> clusters) {
		this.processed_clusters = clusters;
	}

	public void setExternallyDeterminedTimerFrequency(double frequency) {
		if(frequencyOfTimerSpecifiedExternally==false){
			this.externallyDeterminedTimerFrequency = frequency;
			frequencyOfTimerSpecifiedExternally = true;
		}else{
			logger.error("Timer externallyDeterminedTimerFrequency " +
					"already specified, cannot be overwritten");
		}
	}

	public void setExternallyDeterminedTimerInvocationCost(double cost) {
		if(invocationCostOfTimerSpecifiedExternally==false){
			this.externallyDeterminedTimerInvocationCost = cost;
			invocationCostOfTimerSpecifiedExternally = true;
		}else{
			logger.error("Timer externallyDeterminedTimerInvocationCost " +
					"already specified, cannot be overwritten");
		}
	}

	public void setHistogramElementsByProcess(
			SortedMap<Integer, SortedMap<Long, Integer>> histogramElementsByProcessAcrossAllProcesses) {
		this.processed_histogramElementsByProcess = histogramElementsByProcessAcrossAllProcesses;
	}

	public void setHistogramElementsByValue(
			SortedMap<Long, SortedMap<Integer, Integer>> histogramElementsByValueAcrossAllProcesses) {
		this.processed_histogramElementsByValue = histogramElementsByValueAcrossAllProcesses;
	}

	public void setInvocationCost(StatisticalDescription invocationCost) {
		this.invocationCost = invocationCost;
	}

	public void setProcessCharacterisations(List<StatisticalDescription> processCharacterisations) {
		this.processed_processCharacterisations = processCharacterisations;
	}

	public void setProcessed_allMeasurementsCharacterisation(
			StatisticalDescription processed_allMeasurementsCharacterisation) {
		this.processed_allMeasurementsCharacterisation = processed_allMeasurementsCharacterisation;
	}

	public void setProcessed_allMeasurementsHistogram(
			SortedMap<Long, Integer> processed_allMeasurementsHistogram) {
		this.processed_allMeasurementsHistogram = processed_allMeasurementsHistogram;
	}

	public void setProcessed_clusters(
			List<MeasurementGroupsCluster> processed_clusters) {
		this.processed_clusters = processed_clusters;
	}

	public void setProcessed_histogramElementsByProcess(
			SortedMap<Integer, SortedMap<Long, Integer>> processed_histogramElementsByProcess) {
		this.processed_histogramElementsByProcess = processed_histogramElementsByProcess;
	}

	public void setProcessed_histogramElementsByValue(
			SortedMap<Long, SortedMap<Integer, Integer>> processed_histogramElementsByValue) {
		this.processed_histogramElementsByValue = processed_histogramElementsByValue;
	}

	public void setProcessed_processCharacterisations(
			List<StatisticalDescription> processed_processCharacterisations) {
		this.processed_processCharacterisations = processed_processCharacterisations;
	}

	public void setRaw_allInitialMeasurements(long[][] raw_allInitialMeasurements) {
		this.raw_allInitialMeasurements = raw_allInitialMeasurements;
	}

	public void setRaw_allMeasurementsAppendedAndSorted(
			long[] raw_allMeasurementsAppendedAndSorted) {
		this.raw_allMeasurementsAppendedAndSorted = raw_allMeasurementsAppendedAndSorted;
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Accuracy="+this.accuracy+", \n");
		if(this.invocationCost!=null){
			sb.append("min. invocation cost="+this.invocationCost.getMin()+",\n");
			sb.append("med. invocation cost (math)="+this.invocationCost.getMedian()+",\n");
			sb.append("med. invocation cost (phys)="+this.invocationCost.getMedian_real_element()+",\n");
			sb.append("avg. invocation cost="+this.invocationCost.getMean()+",\n");
			sb.append("max. invocation cost="+this.invocationCost.getMax()+",\n");
			sb.append("variance of invocation cost="+this.invocationCost.getVariance()+".");
		}else{
			//TODO
		}
		if(frequencyOfTimerSpecifiedExternally){
			sb.append("Externally obtained timer frequency ="+
					this.externallyDeterminedTimerFrequency+", \n");
		}else{
			//TODO
		}
		if(invocationCostOfTimerSpecifiedExternally){
			sb.append("Externally obtained timer invocation cost="+
					this.externallyDeterminedTimerInvocationCost+", \n");
		}else{
			//TODO
		}
		return sb.toString();
	}

	public String toString_extensive(){//TODO add a "very extensive version that iterates over all histograms and characterisation
		StringBuffer sb = new StringBuffer();
		sb.append(this.toString()+"\n");
		
		sb.append("Characteristics accross all measurements: "+
				this.processed_allMeasurementsCharacterisation+"\n");
		sb.append("Histogram: "+
				this.processed_allMeasurementsHistogram+"\n");
		sb.append("Clusters: "+
				this.processed_clusters+"\n");
		sb.append("First of HistogramColumns-By-Process: "+
				this.processed_histogramElementsByProcess.get(
						this.processed_histogramElementsByProcess.firstKey())+"\n");
		sb.append("Last of HistogramColumns-By-Process: "+
				this.processed_histogramElementsByProcess.get(
						this.processed_histogramElementsByProcess.size()-1)+"\n");
		sb.append("First of HistogramColumns-By-Value: "+//how often a value occured in that processes
				this.processed_histogramElementsByValue.get(
						this.processed_histogramElementsByValue.firstKey())+"\n");
		sb.append("Last of HistogramColumns-By-Value: "+//how often a value occured in that processes
				this.processed_histogramElementsByValue.get(
						this.processed_histogramElementsByValue.lastKey())+"\n");
		sb.append("First process characterisation: "+
				this.processed_processCharacterisations.get(0)+"\n");
		sb.append("Last process characterisation: "+//how often a value occured in that processes
				this.processed_processCharacterisations.get(
						this.processed_processCharacterisations.size()-1)+"\n");
		
		sb.append("Stat. analysis of smallest diff value accross all processes: "+
				this.computeClusterWidthCharacteristicsAcrossProcesses(
						this.processed_allMeasurementsCharacterisation.getMin())+"\n");
		sb.append("Stat. analysis of median cluster value accross all processes: "+
				this.computeClusterWidthCharacteristicsAcrossProcesses(
						this.processed_allMeasurementsCharacterisation.getMedian_real_element()));
		return sb.toString();
	}

}
