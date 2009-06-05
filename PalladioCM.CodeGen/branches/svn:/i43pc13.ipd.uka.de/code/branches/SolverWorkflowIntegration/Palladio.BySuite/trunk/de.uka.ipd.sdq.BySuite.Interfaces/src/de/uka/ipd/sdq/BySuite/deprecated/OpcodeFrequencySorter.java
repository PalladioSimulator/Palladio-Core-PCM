package de.uka.ipd.sdq.BySuite.deprecated;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import de.uka.ipd.sdq.BySuite.counting.SortableFrequency;


public class OpcodeFrequencySorter {

//	private Map<String,Map<String,Long>> inputFrequencies;
//	private Map<String,Map<String,Long>> outputFrequencies;
//	private Map<String,Double> totalWeights;
//	private Map<String,Map<String,Double>> localWeights;
//	private boolean totalWeightsInvalidated;
//	private boolean outputFrequenciesInvalidated;
//	private int sortingPolicy;
//	private int numberOfSelectedOpcodes;
//	private static final int ABSOLUTE_TOTAL_FREQUENCY = 0;
//	private static final int ABSOLUTE_LOCAL_FREQUENCY = 1;
	public static final int RELATIVE_LOCAL_FREQUENCY = 2;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args){
		OpcodeFrequencySorter ofs = new OpcodeFrequencySorter();
		try {
			ofs.testVerySimple();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public OpcodeFrequencySorter() {
		super();
//		this.inputFrequencies = new TreeMap<String, Map<String,Long>>();
//		this.localWeights = new TreeMap<String, Map<String,Double>>();
//		this.numberOfSelectedOpcodes = 10; //TODO add constant
//		this.outputFrequencies = new TreeMap<String, Map<String,Long>>();
//		this.outputFrequenciesInvalidated = true;
//		this.sortingPolicy = RELATIVE_LOCAL_FREQUENCY;
//		this.totalWeights = new TreeMap<String, Double>();
//		this.totalWeightsInvalidated = true;
	}

	/**
	 * @param sortingPolicy
	 * @param detailedOpcodeCounts
	 * @param totalOpcodeCounts
	 * @return results in <b>ascending</b> order. To get the descending order: convert to an array.
	 * @throws Exception
	 */
	public SortedSet<SortableFrequency> getMostFrequentOpcodes_Integer(
//			int nrOfMostFrequentOpcodesToReturn,
			int sortingPolicy,
			Map<String,Map<Integer,Long>> detailedOpcodeCounts,
			Map<String,Long> totalOpcodeCounts) throws Exception{
		System.out.println("Entering getMostFrequentOpcodes_Integer");
		Map<String,SortableFrequency> frequenciesMap;
		frequenciesMap = new TreeMap<String, SortableFrequency>();//for simplifying the addition...
		
		SortedSet<SortableFrequency> sortedFrequencies;
		sortedFrequencies = new TreeSet<SortableFrequency>(new SortableFrequencyComparator());
		
		
		Iterator<String> iterOverDatasets = detailedOpcodeCounts.keySet().iterator();
		Iterator<String> iterOverTotalCounts = totalOpcodeCounts.keySet().iterator();
		Iterator<Integer> iterOverCurrDatasetKeys;
		
		Map<Integer,Long> currDataset;
		String currDatasetKey;//should be present in totalOpcodeCounts as well
		Integer currOpcode;
		Long currOpcodeCount;
		Long currTotalOpcodeCountInDataset;
		
		de.uka.ipd.sdq.BySuite.utils.ASMOpcodesMapper_OLD asmom = de.uka.ipd.sdq.BySuite.utils.ASMOpcodesMapper_OLD.getInstance();
		String currOpcodeAsString;
		
		if(sortingPolicy==RELATIVE_LOCAL_FREQUENCY){
			for(;iterOverDatasets.hasNext();){
				currTotalOpcodeCountInDataset = totalOpcodeCounts.get(iterOverTotalCounts.next());
				
				currDatasetKey = iterOverDatasets.next();
				currDataset = detailedOpcodeCounts.get(currDatasetKey);
				iterOverCurrDatasetKeys = currDataset.keySet().iterator();
				
				System.out.println(currDataset.size()+" counts in current dataset");
				int position = 0;
				for(;iterOverCurrDatasetKeys.hasNext();){
					currOpcode = iterOverCurrDatasetKeys.next();
					currOpcodeAsString = asmom.getOpcodeString(currOpcode);
					currOpcodeCount = currDataset.get(currOpcode);
					Double frequencyToAdd = ((Double) currOpcodeCount.doubleValue())/((Double) currTotalOpcodeCountInDataset.doubleValue());
					if(frequenciesMap.keySet().contains(currOpcodeAsString)){
//						System.out.println("@"+position+": "+
//								currOpcodeAsString+" already in map");
						frequenciesMap.get(currOpcodeAsString).addData(
								currOpcodeCount,
								frequencyToAdd);
					}else{
//						System.out.println("@"+position+": "+
//								currOpcodeAsString+" not yet in in map");
						SortableFrequency newFrequency = new SortableFrequency(
								currOpcodeAsString,
								currOpcodeCount,
								frequencyToAdd);
						frequenciesMap.put(currOpcodeAsString,newFrequency);
						if(!sortedFrequencies.add(newFrequency)){
							System.out.println("!!! did not add "+newFrequency+
									" as it was already in "+sortedFrequencies);
						}
					}
					position++;
				}
			}
			System.out.println("Before returning: "+sortedFrequencies.size()+" elements in sortedFrequencies");
			return sortedFrequencies;
		}else{ 
			System.err.println("Sorting policy "+sortingPolicy+" not supported");
			return null;
		}
	}
	
	/**
	 * @param sortingPolicy
	 * @param detailedOpcodeCounts
	 * @param totalOpcodeCounts
	 * @return results in <b>ascending</b> order. To get the descending order: convert to an array.
	 * @throws Exception
	 */
	public SortedSet<SortableFrequency> getMostFrequentOpcodes_String(
//			int nrOfMostFrequentOpcodesToReturn,
			int sortingPolicy,
			Map<String,Map<String,Long>> detailedOpcodeCounts,
			Map<String,Long> totalOpcodeCounts) throws Exception{
		
		Map<String,SortableFrequency> frequenciesMap = new TreeMap<String, SortableFrequency>();//for simplifying the addition...
		SortedSet<SortableFrequency> sortedFrequencies;
		sortedFrequencies = new TreeSet<SortableFrequency>(new SortableFrequencyComparator());
		
		
		Iterator<String> iterOverDatasets = detailedOpcodeCounts.keySet().iterator();
		Iterator<String> iterOverTotalCounts = totalOpcodeCounts.keySet().iterator();
		Iterator<String> iterOverCurrDatasetKeys;
		
		String currDatasetKey;//should be present in totalOpcodeCounts as well
		Map<String,Long> currDataset;
		Long currTotalOpcodeCountInDataset;
		
		String currOpcode;
		Long currOpcodeCount;
		
		
		
		if(sortingPolicy==RELATIVE_LOCAL_FREQUENCY){
			for(;iterOverDatasets.hasNext();){
				currTotalOpcodeCountInDataset = totalOpcodeCounts.get(iterOverTotalCounts.next());
				
				currDatasetKey = iterOverDatasets.next();
				currDataset = detailedOpcodeCounts.get(currDatasetKey);
				iterOverCurrDatasetKeys = currDataset.keySet().iterator();
				
				for(;iterOverCurrDatasetKeys.hasNext();){
					currOpcode = iterOverCurrDatasetKeys.next();
					currOpcodeCount = currDataset.get(currOpcode);
					Double frequencyToAdd = ((Double) currOpcodeCount.doubleValue())/((Double) currTotalOpcodeCountInDataset.doubleValue());
					if(frequenciesMap.keySet().contains(currOpcode)){
						frequenciesMap.get(currOpcode).addData(currOpcodeCount,frequencyToAdd);
					}else{
						SortableFrequency newFrequency = new SortableFrequency(currOpcode,currOpcodeCount,frequencyToAdd);
						frequenciesMap.put(currOpcode,newFrequency);
						sortedFrequencies.add(newFrequency);
					}
				}
				
			}
			
			return sortedFrequencies;
		}else{ 
			System.err.println("Sorting policy "+sortingPolicy+" not supported");
			return null;
		}
	}
	
	public SortedSet<SortableFrequency> getMostFrequentOpcodesInOneDataset_Integer(
//			int nrOfMostFrequentOpcodesToReturn,
			int sortingPolicy,
			Map<Integer,Long> detailedOpcodeCounts,
			Long totalOpcodeCount) throws Exception{
		
		Map<String,Long> totalOpcodeCounts;
		totalOpcodeCounts = new TreeMap<String, Long>();
		totalOpcodeCounts.put("TheOnlyDataset",totalOpcodeCount);
		
		Map<String,Map<Integer,Long>> detailedOpcodeCountsMap;
		detailedOpcodeCountsMap = new TreeMap<String, Map<Integer,Long>>();

		detailedOpcodeCountsMap.put("TheOnlyDataset",detailedOpcodeCounts);
		SortedSet<SortableFrequency> retResult = this.getMostFrequentOpcodes_Integer(
//				nrOfMostFrequentOpcodesToReturn, 
				sortingPolicy,//sortingPolicy, 
				detailedOpcodeCountsMap, 
				totalOpcodeCounts);
		return retResult;
	}

	public SortedSet<SortableFrequency> getMostFrequentOpcodesInOneDataset_String(
//			int nrOfMostFrequentOpcodesToReturn,
			int sortingPolicy,
			Map<String,Long> detailedOpcodeCounts,
			Long totalOpcodeCount) throws Exception{
		
		Map<String,Long> totalOpcodeCounts;
		totalOpcodeCounts = new TreeMap<String, Long>();
		totalOpcodeCounts.put("TheOnlyDataset",totalOpcodeCount);
		
		Map<String,Map<String,Long>> detailedOpcodeCountsMap;
		detailedOpcodeCountsMap = new TreeMap<String, Map<String,Long>>();

		detailedOpcodeCountsMap.put("TheOnlyDataset",detailedOpcodeCounts);
		return this.getMostFrequentOpcodes_String(
//				nrOfMostFrequentOpcodesToReturn, 
				sortingPolicy,//sortingPolicy, 
				detailedOpcodeCountsMap, 
				totalOpcodeCounts);
	}

	public void serialiseSortedFrequenciesToCSV(
			SortedSet<SortableFrequency> sortedResults, 
			String fileName) {
		StringBuffer sbFirstLine = new StringBuffer();//opcode as string
		StringBuffer sbSecondLine = new StringBuffer();//sum of frequencies
		StringBuffer sbThirdLine = new StringBuffer();//number of frequencies
		StringBuffer sbFourthLine = new StringBuffer();//average frequency (sorting criteria!)
		StringBuffer sbFifthLine = new StringBuffer();//absolute counts (over ALL datasets!)
		
		Iterator<SortableFrequency> iter = sortedResults.iterator();
		SortableFrequency currentFrequency = null;
		for(;iter.hasNext();){
			currentFrequency = iter.next();
			sbFirstLine.append(currentFrequency.getID()+";");
			sbSecondLine.append(currentFrequency.getSumOfFrequencyValues()+";");
			sbThirdLine.append(currentFrequency.getNumberOfSources()+";");
			sbFourthLine.append(currentFrequency.getAverageFrequency()+";");
			sbFifthLine.append(currentFrequency.getSumOfAbsoluteOccurencies()+";");
		}
		sbFirstLine.append("\n");
		sbSecondLine.append("\n");
		sbThirdLine.append("\n");
		sbFourthLine.append("\n");
		sbFifthLine.append("\n");
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
			fos.write(sbFirstLine.toString().getBytes());
			fos.write(sbSecondLine.toString().getBytes());
			fos.write(sbThirdLine.toString().getBytes());
			fos.write(sbFourthLine.toString().getBytes());
			fos.write(sbFifthLine.toString().getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private boolean testVerySimple() throws Exception {
		Map<String,Long> totalOpcodeCounts;
		totalOpcodeCounts = new TreeMap<String, Long>();
		totalOpcodeCounts.put("FirstDataset",20L);
		totalOpcodeCounts.put("SecondDataset",30L);
		
		Map<String,Long> firstDatasetCounts;
		firstDatasetCounts = new TreeMap<String, Long>();
		firstDatasetCounts.put("FirstOpcode",15L);
		firstDatasetCounts.put("SecondOpcode",5L);
		
		Map<String,Long> secondDatasetCounts;
		secondDatasetCounts = new TreeMap<String, Long>();
		secondDatasetCounts.put("SecondOpcode",12L);
		secondDatasetCounts.put("ThirdOpcode",18L);
		
		Map<String,Map<String,Long>> detailedOpcodeCounts;
		detailedOpcodeCounts = new TreeMap<String, Map<String,Long>>();

		detailedOpcodeCounts.put("FirstDataset",firstDatasetCounts);
		detailedOpcodeCounts.put("SecondDataset",secondDatasetCounts);
		
		int usedSortingPolicy = RELATIVE_LOCAL_FREQUENCY;
		
		SortedSet<SortableFrequency> results = this.getMostFrequentOpcodes_String(
//				nrOfMostFrequentOpcodesToReturn, 
				usedSortingPolicy,//sortingPolicy, 
				detailedOpcodeCounts, 
				totalOpcodeCounts);
		Iterator<SortableFrequency> iterComputedResults = results.iterator();
		
		SortedSet<SortableFrequency> expectedResults = new TreeSet<SortableFrequency>(new SortableFrequencyComparator());
		expectedResults.add(new SortableFrequency("FirstOpcode",15,0.75));
		expectedResults.add(new SortableFrequency("SecondOpcode",17,0.325));
		expectedResults.add(new SortableFrequency("ThirdOpcode",18,0.6001));
		Iterator<SortableFrequency> iterExpectedResults = expectedResults.iterator();
		
		boolean allOK = true;
		while(iterComputedResults.hasNext() && allOK == true){
			if(iterComputedResults.next().valueEquals(iterExpectedResults.next())){
			}else{
				System.err.println("OK: Results and expected results ARE NOT identical!");
				allOK = false;
			}
		}
		if(allOK){
			System.out.println("OK: Results and expected results ARE identical!");
		}
		System.out.println("usedSortingPolicy: "+usedSortingPolicy);
		System.out.println("totalOpcodeCounts: "+totalOpcodeCounts.toString());
		System.out.println("detailedOpcodeCounts: "+detailedOpcodeCounts.toString());
		System.out.println("expectedResults: "+expectedResults.toString());
		System.out.println("results: "+results.toString());

		return allOK;
	}
}
