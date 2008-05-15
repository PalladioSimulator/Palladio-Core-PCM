package de.uka.ipd.sdq.BySuite.helper.prediction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import de.uka.ipd.sdq.BySuite.helper.benchmarkedbytecode.BenchmarkedBytecode;

public class ComprehensivePredictionResult {
	
	class WeightedOpcodeDescription implements Comparable<WeightedOpcodeDescription>{
		private int opcode;
		private long opcodeCount;
		private double opcodeDuration;
		private double opcodeWeight;
		
		public WeightedOpcodeDescription(
				int opcode, 
				long opcodeCount, 
				double opcodeDuration, 
				double opcodeWeight){
			this.opcode = opcode;
			this.opcodeCount = opcodeCount;
			this.opcodeDuration = opcodeDuration;
			this.opcodeWeight = this.opcodeCount*this.opcodeDuration;
		}
		
		public int compareTo(WeightedOpcodeDescription o) {
			if(this.opcodeWeight<o.opcodeWeight){
				return -1;
			}else if(this.opcodeWeight>o.opcodeWeight){
				return 1;
			}else{
				if(this.opcodeCount<o.opcodeCount){
					return -1;
				}else if(this.opcodeCount>o.opcodeCount){
					return 1;
				}else{
					if(this.opcode<o.opcode){
						return -1;
					}if(this.opcode>o.opcode){
						return 1;
					}else{
						if(this.opcodeDuration<o.opcodeDuration){
							return -1;
						}else if(this.opcodeDuration>o.opcodeDuration){
							return 1;
						}else{
							return 0;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		Map<Integer,Long> counts = new HashMap<Integer, Long>();
		counts.put(1,20L);
		counts.put(2,5L);
		Map<Integer,Double> durations = new HashMap<Integer, Double>();
		durations.put(1,2D);
		durations.put(2,9D);
		ComprehensivePredictionResult cpr;
		cpr = new ComprehensivePredictionResult("Test", counts, durations);
//		SortedMap<Double,Integer> byWeight = cpr.getOpcodesByPredictionWeight();
		SortedSet<WeightedOpcodeDescription> byWeight = cpr.getOpcodesByPredictionWeight();
		System.out.println(cpr.toString());
//		Double currPredWeight = 0D;
//		long predResult = cpr.getPredResult();
//		System.out.println("Pred result: "+predResult);
//		for (Iterator<Double> iterator = byWeight.keySet().iterator(); iterator.hasNext();) {
//			currPredWeight = iterator.next();
//			System.out.println("Absolute weight of "+
//					byWeight.get(currPredWeight)+": "+currPredWeight+"; "+
//					"relative weight: "+((double) currPredWeight/predResult));
//			
//		}
	}
	
	private String platformDesc;
	private long predResult;
//	private int nrOfOccuringOpcodes;
//	private int nrOfOpcodesUsedForPrediction;
//	private Map<Integer,Long> opcodeCounts;
//	private Map<Integer,Double> opcodeDurations;
//	/**
//	 * @deprecated because assumption of different weights...
//	 */
//	private SortedMap<Double,Integer> opcodePredictionByWeight;
	private SortedSet<WeightedOpcodeDescription> descList;
	
	private boolean computationPerformed = false;
	
	public long getPredResult(){
		if(!computationPerformed){
			this.predResult = 0;
			for(Iterator<WeightedOpcodeDescription> iter = descList.iterator(); iter.hasNext();){
				this.predResult+=iter.next().opcodeWeight;
			}
//			double currentPred;
//			Set<Integer> keyset = opcodeCounts.keySet();
//			Integer[] keysetArray = keyset.toArray(new Integer[]{});
//			for(int i=0; i<opcodeCounts.size(); i++){
//				currentPred = opcodeCounts.get(keysetArray[i])*opcodeDurations.get(keysetArray[i]);
//				this.predResult += currentPred;
//				this.opcodePredictionByWeight.put(currentPred, keysetArray[i]);
//			}
			computationPerformed = true;
		}
		return this.predResult;
	}
	
	public SortedSet<WeightedOpcodeDescription> getOpcodesByPredictionWeight(){
		return descList;
	}
//	public SortedMap<Double,Integer> getOpcodesByPredictionWeight(){
//		if(!computationPerformed){
//			this.predResult = 0;
//			double currentPred;
//			Set<Integer> keyset = opcodeCounts.keySet();
//			Integer[] keysetArray = keyset.toArray(new Integer[]{});
//			for(int i=0; i<opcodeCounts.size(); i++){
//				currentPred = opcodeCounts.get(keysetArray[i])*opcodeDurations.get(keysetArray[i]);
//				this.predResult += currentPred;
//				this.opcodePredictionByWeight.put(currentPred, keysetArray[i]);
//			}
//			computationPerformed = true;
//		}
//		return this.opcodePredictionByWeight;
//	}
	
	private BenchmarkedBytecode bb;
	/**
	 * @param platformDesc
	 * @param opcodeCounts
	 * @param opcodeDurations
	 * @deprecated because no security checks
	 */
	public ComprehensivePredictionResult(
		String platformDesc,
//		int nrOfOccuringOpcodes,
//		int nrOfOpcodesUsedForPrediction,
		Map<Integer,Long> opcodeCounts,
		Map<Integer,Double> opcodeDurations){
		 	bb = new BenchmarkedBytecode();
		 	this.descList = new TreeSet<WeightedOpcodeDescription>();
			this.platformDesc = platformDesc;
//			this.nrOfOccuringOpcodes = nrOfOccuringOpcodes;//TODO
//			this.nrOfOpcodesUsedForPrediction = nrOfOpcodesUsedForPrediction; //TODO
			Iterator<Integer> keyIter = opcodeCounts.keySet().iterator();
			int opcode;
			long opcodeCount;
			double opcodeDuration;
			for(;keyIter.hasNext();){
				opcode = keyIter.next();
				opcodeCount = opcodeCounts.get(opcode);
				opcodeDuration = opcodeDurations.get(opcode);
				this.descList.add(new WeightedOpcodeDescription(
						opcode,
						opcodeCount,
						opcodeDuration,
						opcodeCount*opcodeDuration));
//				this.opcodeDurations = opcodeDurations;
//				this.opcodePredictionByWeight = new TreeMap<Double, Integer>();
			}
		}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		long predResult = this.getPredResult();
		sb.append("\n==========\n"+predResult+" ns =\n");
		Iterator<WeightedOpcodeDescription> iter = descList.iterator();
		WeightedOpcodeDescription currDesc;
		for(;iter.hasNext();){
			currDesc = iter.next();
			sb.append(bb.getString(currDesc.opcode)+": " +
					"opcode "+currDesc.opcode+": ~"+
					(long) currDesc.opcodeWeight+" ns "+
					"[="+currDesc.opcodeCount+"*"+currDesc.opcodeDuration+" ns "+
					"="+100*(currDesc.opcodeWeight/predResult)+" %]"+"+\n");
		}
		sb.append("==Finish==\n\n");
		return sb.toString();
	}
//	public String toString(){
//		StringBuffer sb = new StringBuffer();
//		if(!computationPerformed){
//			this.getPredResult();
//		}
//		Iterator<Double> iter = opcodePredictionByWeight.keySet().iterator();
//		int currOpcode;
//		long currCount;
//		double currentDuration;
//		double currWeight;
//		for(;iter.hasNext();){
//			currWeight = iter.next();
//			currOpcode = opcodePredictionByWeight.get(curr)
//		}
//		return sb.toString();
//	}
	
}
