package de.uka.ipd.sdq.ByCounter.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

/**
 * Class that holds the results of an (instrumented) method run.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class CountingResult {
	
	/**The returned CountingResult is completely different from the summands 
	 * w.r.t. the method name, etc. Hence, it is not initialised and only 
	 * holds the sum of the two added {@link CountingResult}. 
	 * TODO Ignores the array counts for the moment...
	 * @param left the first summand
	 * @param right the second summand
	 * @return an instance of {@link CountingResult} where only counts are initialised
	 */
	public static CountingResult add(CountingResult left, CountingResult right){
		//TODO replace cloning
		HashMap<Integer,Integer> resultOpcodeCounts = new HashMap<Integer, Integer>();
		HashMap<String,Integer>  resultMethodCallCounts = new HashMap<String, Integer>(); 
		Integer keyInt;
		String keyString;
//		Integer value;
		Iterator<Integer> iteratorOpcodes = left.opcodeCounts.keySet().iterator();
		for (; iteratorOpcodes.hasNext();) {
			keyInt = iteratorOpcodes.next();
			resultOpcodeCounts.put(
					new Integer(keyInt), 
					new Integer(left.opcodeCounts.get(keyInt)));
		}
		Iterator<String> iteratorMethods = left.methodCallCounts.keySet().iterator();
		for (; iteratorMethods.hasNext();) {
			keyString = iteratorMethods.next();
			resultMethodCallCounts.put(
					new String(keyString), 
					new Integer(left.methodCallCounts.get(keyString)));
		}
//		HashMap<Integer,Integer> leftOpcodeCounts = left.getOpcodeCounts();
//		HashMap<String,Integer>  leftMethodCallCounts = left.getMethodCallCounts();
		HashMap<Integer,Integer> rightOpcodeCounts = right.getOpcodeCounts();
		HashMap<String,Integer>  rightMethodCallCounts = right.getMethodCallCounts();
		
//		Iterator<Integer> opcodesKeysetLeft  = left.getOpcodeCounts().keySet().iterator();
//		Iterator<String> methodsKeysetLeft  = left.getMethodCallCounts().keySet().iterator();
		Iterator<Integer> opcodesKeysetRight = right.getOpcodeCounts().keySet().iterator();
		Iterator<String> methodsKeysetRight = right.getMethodCallCounts().keySet().iterator();
		
//		Integer leftKey;
//		Integer leftValue;
		Integer resultValue;
		Integer rightKey;
		Integer rightValue;

		for(;opcodesKeysetRight.hasNext();){
			rightKey = opcodesKeysetRight.next();
			rightValue = rightOpcodeCounts.get(rightKey);
			resultValue = resultOpcodeCounts.get(rightKey);
			if(resultValue==null){
				resultOpcodeCounts.put(rightKey, rightValue);
			}else{
				resultValue += rightValue;
				resultOpcodeCounts.remove(rightKey);//TODO enhance?
				resultOpcodeCounts.put(rightKey, resultValue);
			}
		}
		
		String rightKey_String;
		for(;methodsKeysetRight.hasNext();){
			rightKey_String = methodsKeysetRight.next();
			rightValue = rightMethodCallCounts.get(rightKey_String);
			resultValue = resultMethodCallCounts.get(rightKey_String);
			if(resultValue==null){
				resultMethodCallCounts.put(rightKey_String, rightValue);
			}else{
				resultValue += rightValue;
				resultOpcodeCounts.remove(rightKey_String);//TODO enhance?
				resultMethodCallCounts.put(rightKey_String, resultValue);
			}
		}
		
		CountingResult cr;
		cr = new CountingResult(
				new String(""),
				-1L,
				-1L,
				null,
				null,
				resultOpcodeCounts,
				resultMethodCallCounts,
				null,
				null,
				null,
				null,
				null,
				null);
		return cr;
	}
	
	private int[] arrayCreationCounts;
	
	private int[] arrayCreationDimensions;
	
	private String[] arrayCreationTypeInfo;
	
	private List<Object> characterisations;
	
	private List<String> characterisationTitles;
	
	private List<Integer> characterisationTypes;
	
	/**
	 * duplicate information - should be in CountingArtefactInformation
	 */
	@SuppressWarnings("unused")
	private RuntimeMethodParameters inputParams;
	
	private HashMap<String, Integer> methodCallCounts;

	private long methodInvocationBeginning;

	private Long methodReportingTime;
	
	/**
	 * duplicate information? - should be in CountingArtefactInformation?
	 */
	@SuppressWarnings("unused")
	private CountingResultCollector myCollector;
	
	private HashMap<Integer, Integer> opcodeCounts;
	
	/**
	 * duplicate information? - should be in CountingArtefactInformation?
	 */
	@SuppressWarnings("unused")
	private RuntimeMethodParameters outputParams;
    
	private String qualifyingMethodName;
    
	/**
	 * Should be used by the next release
	 */
    @SuppressWarnings("unused")
	private SortedMap<BytecodeSectionDescription,SortedMap<Integer,Integer>> sectionInstCounts;

	/**
	 * Should be used by the next release
	 */
    @SuppressWarnings("unused")
	private SortedMap<BytecodeSectionDescription,SortedMap<String,Integer>> sectionMethCounts;
	
	/**
	 * Constructs a new Result instance with the given values.
	 * @param time Time of method execution as returned by System.nanoTime().
	 * @param qualifyingMethodName Name of the evaluated method.
	 * @param opcodeCounts HashMap containing counts for every opcode occurrence.
	 * @param methodCallCounts HashMap containing count for every method that was called.
	 * @param newArrayCounts The counts for the specific array construction.
	 * @param newArrayDim The dimension information for the 
	 * specific array construction if more than one dimension exists.
	 * @param newArrayType The descriptor string for array construction of non-
	 * simple type or a string identifying the type else.
	 * @deprecated
	 */
	public CountingResult(
			long time, 
			String qualifyingMethodName, 
			HashMap<Integer, Integer> opcodeCounts, 
			HashMap<String, Integer> methodCallCounts,
			int[] newArrayCounts,
			int[] newArrayDim,
			String[] newArrayType) {
		this.methodInvocationBeginning = time;
		this.qualifyingMethodName = qualifyingMethodName;
		this.opcodeCounts = opcodeCounts;
		this.methodCallCounts = methodCallCounts;
		this.arrayCreationCounts = newArrayCounts;
		this.arrayCreationDimensions = newArrayDim;
		this.arrayCreationTypeInfo = newArrayType;
	}

	/**TODO document
	 * @param qualifyingMethodName
	 * @param timeStart
	 * @param timeReport
	 * @param inputParams
	 * @param outputParams
	 * @param opcodeCounts
	 * @param methodCallCounts
	 * @param newArrayCounts
	 * @param newArrayDim
	 * @param newArrayType
	 * @param sectionInstCounts
	 * @param sectionMethCounts
	 * @param collector
	 */
	public CountingResult(
			String qualifyingMethodName, 
			long timeStart, 
			long timeReport, 
			RuntimeMethodParameters inputParams,
			RuntimeMethodParameters outputParams,
			HashMap<Integer, Integer> opcodeCounts, 
			HashMap<String, Integer> methodCallCounts,
			int[] newArrayCounts,
			int[] newArrayDim,
			String[] newArrayType,
			SortedMap<BytecodeSectionDescription,SortedMap<Integer,Integer>> sectionInstCounts,
			SortedMap<BytecodeSectionDescription,SortedMap<String,Integer>> sectionMethCounts,
			CountingResultCollector collector) {
		this.qualifyingMethodName = qualifyingMethodName;
		this.methodInvocationBeginning = timeStart;
		this.methodReportingTime = timeReport;
		this.inputParams = inputParams;
		this.outputParams = outputParams;
		this.opcodeCounts = opcodeCounts;
		this.methodCallCounts = methodCallCounts;
		this.arrayCreationCounts = newArrayCounts;
		this.arrayCreationDimensions = newArrayDim;
		this.arrayCreationTypeInfo = newArrayType;
		this.sectionInstCounts = sectionInstCounts;
		this.sectionMethCounts = sectionMethCounts;
		this.myCollector = collector;
		this.characterisations = new ArrayList<Object>();
		this.characterisationTitles = new ArrayList<String>();
		this.characterisationTypes = new ArrayList<Integer>();
	}

	/** Adds to this {@link CountingResult} instance the counting results 
	 * of the {@link CountingResult} instance given as parameter
	 * @param toBeAdded {@link CountingResult} instance whose counts are to be added
	 */
	public void add(CountingResult toBeAdded){
		CountingResult skeletonResult = add(this,toBeAdded);
		this.methodCallCounts = skeletonResult.getMethodCallCounts();
		this.opcodeCounts = skeletonResult.getOpcodeCounts();
//		TODO add section counts, array counts, ...
	}

	public void addCharacterisation(
			String characterisationTitle,
			Integer characterisationType,
			Object characterisationValue){
		characterisationTitles.add(characterisationTitle);
		characterisationTypes.add(characterisationType);
		characterisations.add(characterisationValue);
	}

	public List<Object> getCharacterisations() {
		return characterisations;
	}

	public List<String> getCharacterisationTitles() {
		return characterisationTitles;
	}

	public List<Integer> getCharacterisationTypes() {
		return characterisationTypes;
	}

	/** Simple getter
	 * @return the methodCallCounts
	 */
	public HashMap<String, Integer> getMethodCallCounts() {
		return methodCallCounts;
	}

	/**
	 *  Simple getter
	 * @return Counts for array constructions when recording was enabled; <code>null</code> else.
	 */
	public int[] getNewArrayCounts() {
		return arrayCreationCounts;
	}

	/**
	 * Simple getter for the dimension of the new array if applicable; -1 else.
	 * @return The array when recording was enabled. Null else.
	 */
	public int[] getNewArrayDim() {
		return arrayCreationDimensions;
	}
	
	/**
	 * Simple getter for the types of the new arrays.
	 * @return The array when recording was enabled. Null else.
	 */
	public String[] getNewArrayTypes() {
		return arrayCreationTypeInfo;
	}

	/** 
	 * Simple getter for the opcode counts as a HashMap integers 
	 * where each bytecode instruction is the key for which 
	 * the value represents the number of calls to a specific instruction.
	 * @return The counts.
	 */
	public HashMap<Integer, Integer> getOpcodeCounts() {
		return opcodeCounts;
	}

	/**
	 * Simple getter
	 * @return the qualifyingMethodName
	 */
	public String getQualifyingMethodName() {
		return qualifyingMethodName;
	}

	/**
	 * Simple getter
	 * @return the time
	 */
	public long getTime() {
		return methodInvocationBeginning;
	}

	public void setCharacterisations(List<Object> characterisations) {
		this.characterisations = characterisations;
	}

	public void setCharacterisationTitles(List<String> characterisationTitles) {
		this.characterisationTitles = characterisationTitles;
	}

	public void setCharacterisationTypes(List<Integer> characterisationTypes) {
		this.characterisationTypes = characterisationTypes;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n"+
				  "      "+this.getClass().getSimpleName()+" (hash code: "+this.hashCode()+")\n");
		sb.append("      > Method name     : "+this.qualifyingMethodName+"\n");
		sb.append("      > Method start    : "+this.methodInvocationBeginning+/*" (aka +"+(new Timestamp(methodInvocationBeginning)).toString()+")"+*/" \n");
		sb.append("      > Method end      : "+this.methodReportingTime+/*" (aka +"+(new Timestamp(methodReportingTimestamp)).toString()+")"+*/" \n");
//		sb.append("      > Method input    : "+this.inputParams+"\n");
//		sb.append("      > Method output   : "+this.outputParams+"\n");
		sb.append("      > Opcode counts   : "+this.opcodeCounts+"\n");
		sb.append("      > Method counts   : "+this.methodCallCounts+"\n");
//		sb.append("      > Array creations : "+this.arrayCreationCounts+"\n");
//		sb.append("      > Array dimensions: "+this.arrayCreationDimensions+"\n");
//		sb.append("      > Array type infos: "+this.arrayCreationTypeInfo+"\n");
//		sb.append("      > Sect. opc. cnts : "+this.sectionInstCounts+"\n");
//		sb.append("      > Sect. meth. cnts: "+this.sectionMethCounts+"\n");
		return sb.toString();
	}
}
