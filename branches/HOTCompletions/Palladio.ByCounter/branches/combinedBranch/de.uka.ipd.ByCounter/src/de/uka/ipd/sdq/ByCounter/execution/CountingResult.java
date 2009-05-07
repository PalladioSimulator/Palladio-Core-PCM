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
	
	private long[] arrayCreationCounts;
	
	private int[] arrayCreationDimensions;
	
	private String[] arrayCreationTypeInfo;
	
	private List<Object> characterisations;
	
	private List<String> characterisationTitles;
	
	private List<Integer> characterisationTypes;
	
	private HashMap<String, Long> methodCallCounts;

	private long methodInvocationBeginning;

	private Long methodReportingTime;
	
	private HashMap<Integer, Long> opcodeCounts;
	
	private String qualifyingMethodName;
    
	/**
	 * Should be used by the next release
	 */
    @SuppressWarnings("unused")
	private SortedMap<BytecodeSectionDescription,SortedMap<Integer,Long>> sectionInstCounts;

	/**
	 * Should be used by the next release
	 */
    @SuppressWarnings("unused")
	private SortedMap<BytecodeSectionDescription,SortedMap<String,Long>> sectionMethCounts;
	
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
			HashMap<Integer, Long> opcodeCounts, 
			HashMap<String, Long> methodCallCounts,
			long[] newArrayCounts,
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
	 * @param opcodeCounts
	 * @param methodCallCounts
	 * @param newArrayCounts
	 * @param newArrayDim
	 * @param newArrayType
	 * @param sectionInstCounts
	 * @param sectionMethCounts
	 */
	public CountingResult(
			String qualifyingMethodName, 
			long timeStart, 
			long timeReport, 
			HashMap<Integer, Long> opcodeCounts, 
			HashMap<String, Long> methodCallCounts,
			long[] newArrayCounts,
			int[] newArrayDim,
			String[] newArrayType,
			SortedMap<BytecodeSectionDescription,SortedMap<Integer,Long>> sectionInstCounts,
			SortedMap<BytecodeSectionDescription,SortedMap<String,Long>> sectionMethCounts) {
		this.qualifyingMethodName = qualifyingMethodName;
		this.methodInvocationBeginning = timeStart;
		this.methodReportingTime = timeReport;
		this.opcodeCounts = opcodeCounts;
		this.methodCallCounts = methodCallCounts;
		this.arrayCreationCounts = newArrayCounts;
		this.arrayCreationDimensions = newArrayDim;
		this.arrayCreationTypeInfo = newArrayType;
		this.sectionInstCounts = sectionInstCounts;
		this.sectionMethCounts = sectionMethCounts;
		this.characterisations = new ArrayList<Object>();
		this.characterisationTitles = new ArrayList<String>();
		this.characterisationTypes = new ArrayList<Integer>();
	}
	
	/**
	 * The returned CountingResult is completely different from the summands 
	 * w.r.t. the method name, etc. Hence, it is not initialised and only 
	 * holds the sum of the two added {@link CountingResult}s.
	 * Calling this method is quite expensive.
	 * @param left the first summand
	 * @param right the second summand
	 * @return an instance of {@link CountingResult} where only counts are initialised
	 */
	public static CountingResult add(CountingResult left, CountingResult right){
		//TODO replace cloning
		HashMap<Integer,Long> resultOpcodeCounts = new HashMap<Integer, Long>();
		HashMap<String,Long>  resultMethodCallCounts = new HashMap<String, Long>();
		// the following three lists need to keep their indices in sync
		ArrayList<Long> resultNewArrayCounts = new ArrayList<Long>();
		ArrayList<Integer> resultNewArrayDim = new ArrayList<Integer>();
		ArrayList<String> resultNewArrayType = new ArrayList<String>();
		

		long[] resultNewArrayCountsArray = null;
		int[] resultNewArrayDimArray = null;
		String[] resultNewArrayTypeArray = null;
		
		Integer keyInt;
		String keyString;

		Long resultValue;
		Integer rightKey;
		String rightKey_String;
		Long rightValue;

		// set all opcode counts for which 'left' has keys:
		Iterator<Integer> iteratorOpcodes = left.opcodeCounts.keySet().iterator();
		while (iteratorOpcodes.hasNext()) {
			keyInt = iteratorOpcodes.next();
			rightValue = right.opcodeCounts.get(keyInt);
			resultValue = left.opcodeCounts.get(keyInt);
			if(rightValue != null) {
				resultValue += rightValue;
			}
			resultOpcodeCounts.put(
					new Integer(keyInt), 
					new Long(resultValue));
		}
		// set all opcode counts for which only 'right' has keys:
		Iterator<Integer> opcodesKeysetRight = right.getOpcodeCounts().keySet().iterator();
		while (opcodesKeysetRight.hasNext()){
			rightKey = opcodesKeysetRight.next();
			rightValue = right.opcodeCounts.get(rightKey);
			resultValue = resultOpcodeCounts.get(rightKey);
			if(resultValue == null) {
				resultOpcodeCounts.put(rightKey, rightValue);
			}
		}
		
		// set all method call counts for which 'left' has keys:
		Iterator<String> iteratorMethods = left.methodCallCounts.keySet().iterator();
		while (iteratorMethods.hasNext()) {
			keyString = iteratorMethods.next();
			rightValue = right.methodCallCounts.get(keyString);
			resultValue = left.methodCallCounts.get(keyString);
			if(rightValue != null) {
				resultValue += rightValue;
			}
			resultMethodCallCounts.put(
					new String(keyString), 
					new Long(resultValue));
		}
		// set all method call counts for which only 'right' has keys:		
		Iterator<String> methodsKeysetRight = right.getMethodCallCounts().keySet().iterator();
		while (methodsKeysetRight.hasNext()) {
			rightKey_String = methodsKeysetRight.next();
			rightValue = right.methodCallCounts.get(rightKey_String);
			resultValue = resultMethodCallCounts.get(rightKey_String);
			if(resultValue == null) {
				resultMethodCallCounts.put(rightKey_String, rightValue);
			}
		}
		if(left.getNewArrayCounts() != null && right.getNewArrayCounts() != null) {
			// copy array counts from 'left':
			for(int i = 0; i < left.getNewArrayCounts().length; i++) {
				resultNewArrayCounts.add(left.getNewArrayCounts()[i]);
				resultNewArrayDim.add(left.getNewArrayDim()[i]);
				resultNewArrayType.add(left.getNewArrayTypes()[i]);
			}
			
			int rightDim;
			String rightType;
			long rightCount;
			int resultDim;
			String resultType;
			boolean currentCountDone;
			// now merge in the array counts from 'right'
			for(int i = 0; i < right.getNewArrayCounts().length; i++) {
				rightDim = right.getNewArrayDim()[i];
				rightType = right.getNewArrayTypes()[i];
				rightCount = right.getNewArrayCounts()[i];
				currentCountDone = false;
				// is this entry in the list already?
				for(int j = 0; j < resultNewArrayCounts.size() && !currentCountDone; j++) {
					resultDim = resultNewArrayDim.get(j);
					resultType = resultNewArrayType.get(j);
					if(rightDim == resultDim
							&& rightType.equals(resultType)) {
						// add the count value
						resultNewArrayCounts.set(j, 
								resultNewArrayCounts.get(j) + rightCount);
						currentCountDone = true;
					}
				}
				if(!currentCountDone) {
					// we have a new type/dimension; add it to the result
					resultNewArrayCounts.add(rightCount);
					resultNewArrayDim.add(rightDim);
					resultNewArrayType.add(rightType);
				}
			}
			// create arrays from the arraylists
			int numOfNewArray = resultNewArrayCounts.size();
			resultNewArrayCountsArray = new long[numOfNewArray];
			resultNewArrayDimArray = new int[numOfNewArray];
			resultNewArrayTypeArray = resultNewArrayType.toArray(new String[numOfNewArray]);
			for(int i = 0; i < numOfNewArray; i++) {
				resultNewArrayCountsArray[i] = resultNewArrayCounts.get(i);
				resultNewArrayDimArray[i] = resultNewArrayDim.get(i);
			}
		}
		
		CountingResult cr;
		cr = new CountingResult(
				new String(""),
				-1L,
				-1L,
				resultOpcodeCounts,
				resultMethodCallCounts,
				resultNewArrayCountsArray,
				resultNewArrayDimArray,
				resultNewArrayTypeArray,
				null,
				null);
		return cr;
	}

	/** Adds to this {@link CountingResult} instance the counting results 
	 * of the {@link CountingResult} instance given as parameter
	 * @param toBeAdded {@link CountingResult} instance whose counts are to be added
	 */
	public void add(CountingResult toBeAdded){
		CountingResult skeletonResult = add(this,toBeAdded);
		this.methodCallCounts = skeletonResult.getMethodCallCounts();
		this.opcodeCounts = skeletonResult.getOpcodeCounts();
		this.arrayCreationCounts = skeletonResult.getNewArrayCounts();
		this.arrayCreationDimensions = skeletonResult.getNewArrayDim();
		this.arrayCreationTypeInfo = skeletonResult.getNewArrayTypes();
		
//		TODO add section counts ...
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

	/** 
	 * Simple getter for method call counts.
	 * @return A {@link HashMap} were the method name is mapped to the number 
	 * of calls of that method.
	 */
	public HashMap<String, Long> getMethodCallCounts() {
		return methodCallCounts;
	}

	/**
	 * Simple getter
	 * @return Counts for array constructions when recording was enabled; <code>null</code> else.
	 */
	public long[] getNewArrayCounts() {
		return arrayCreationCounts;
	}

	/**
	 * Simple getter for the dimension of the new array if applicable; -1 else.
	 * @return The array dimension when recording was enabled as descriped 
	 * above. Null else.
	 */
	public int[] getNewArrayDim() {
		return arrayCreationDimensions;
	}
	
	/**
	 * Simple getter for the types of the new arrays.
	 * @return The array type when recording was enabled. Null else.
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
	public HashMap<Integer, Long> getOpcodeCounts() {
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
