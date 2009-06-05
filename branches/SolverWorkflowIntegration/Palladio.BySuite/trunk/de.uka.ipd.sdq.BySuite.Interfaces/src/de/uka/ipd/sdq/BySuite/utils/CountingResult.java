package de.uka.ipd.sdq.BySuite.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Class that holds the results of an (instrumented) method run.
 * TODO test serialisation? test O/R-mapper? test XML serialisation?
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class CountingResult 
implements Serializable, Cloneable, IFullCountingResult{
	
	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The returned CountingResult is completely different from the summands 
	 * w.r.t. the method name, etc. Hence, it is not initialised and only 
	 * holds the sum of the two added {@link CountingResult}s.
	 * Calling this method is quite expensive.
	 * @param left the first summand
	 * @param right the second summand
	 * @return an instance of {@link CountingResult} where only counts are initialised
	 * @deprecated because not adapted to the new fields
	 */
	public synchronized static CountingResult add(CountingResult left, CountingResult right){
		//TODO replace cloning
		TreeMap<Integer,Long> resultOpcodeCounts = new TreeMap<Integer, Long>();
		TreeMap<String,Long>  resultMethodCallCounts = new TreeMap<String, Long>();
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
				new String(""),
				0,
				0L,
				0L,
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

	/**
	 * The returned CountingResult is completely different from the summands 
	 * w.r.t. the method name, etc. Hence, it is not initialised and only 
	 * holds the sum of the two added {@link CountingResult}s.
	 * Calling this method is quite expensive.
	 * @param left the first summand
	 * @param right the second summand
	 * @return an instance of {@link CountingResult} where only counts are initialised
	 * @deprecated because not adapted to the new fields
	 */
	public synchronized static CountingResult add_methodInstructionsOnly(CountingResult left, CountingResult right){
		//TODO replace cloning
		TreeMap<Integer,Long> resultOpcodeCounts = new TreeMap<Integer, Long>();
		TreeMap<String,Long>  resultMethodCallCounts = new TreeMap<String, Long>();

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

		CountingResult cr;
		cr = new CountingResult(
				new String(""),
				new String(""),
				0,
				0L,
				0L,
				-1L,
				-1L,
				resultOpcodeCounts,
				resultMethodCallCounts,
				null, //resultNewArrayCountsArray,
				null, //resultNewArrayDimArray,
				null, //resultNewArrayTypeArray,
				null,
				null);
		return cr;
	}
	
	/**
	 * This is extremely sub-optimal and redundant. Optimise later, because called infrequently.
	 * 
	 * @param opcodeCounts2
	 * @param opcodeCounts3
	 * @return
	 */
	private static final boolean compareCounts(
			TreeMap<Integer, Long> opcodeCounts2,
			TreeMap<Integer, Long> opcodeCounts3) {
		Iterator<Integer> iterLeft = opcodeCounts2.keySet().iterator();
		Iterator<Integer> iterRight = opcodeCounts3.keySet().iterator();
		Long currCountLeft;
		Long currCountRight;
		Integer currKey;
		while(iterLeft.hasNext()){//TODO move most likely case to the top...
			currKey = iterLeft.next();
			currCountLeft = opcodeCounts2.get(currKey);
			currCountRight = opcodeCounts3.get(currKey);
			if(currCountLeft==null || currCountLeft==0){
				if(currCountRight==null){
					//everything is fine
				}else if(currCountRight==0){
					//everything is fine
				}else if(currCountRight>0){
//					log.debug("For instruction "+currKey+", " +
//							"the first CountingResult has count 0 while "
//							"the second CountingResult has count "+currCountRight);
					return false;
				}else if(currCountRight<0){
//					log.debug("For instruction "+currKey+", " +
//					"the first CountingResult has count 0 while "
//					"the second CountingResult has count "+currCountRight+", "+
//					"even though negative counts are not allowed!");
					return false;
				}
			}else if(currCountLeft<0){
//				log.error("For instruction "+currKey+", " +
//				"the first CountingResult has a negative count of "+
//				currCountLeft+" even though negative counts are not allowed!");
				return false;
			}else{//if(currCountLeft>0)
				if(currCountRight==currCountLeft){//TODO make sure equals is not needed here... object level!
					//everything is fine
				}else{
//					log.error("opcode "+currKey+": " +
//							"positive first count of "+currCountLeft+
//							" different from second count of "+currCountRight);
					return false;
				}
			}
		}

		while(iterRight.hasNext()){//TODO move most likely case to the top...
			currKey = iterRight.next();
			currCountLeft = opcodeCounts2.get(currKey);
			currCountRight = opcodeCounts3.get(currKey);
			if(currCountRight==null || currCountRight==0){
				if(currCountLeft==null){
					//everything is fine
				}else if(currCountLeft==0){
					//everything is fine
				}else if(currCountLeft>0){
//					log.debug("For instruction "+currKey+", " +
//							"the second CountingResult has count 0 while "
//							"the first CountingResult has count "+currCountRight);
					return false;
				}else if(currCountLeft<0){
//					log.debug("For instruction "+currKey+", " +
//					"the second CountingResult has count 0 while "
//					"the first CountingResult has count "+currCountRight+", "+
//					"even though negative counts are not allowed!");
					return false;
				}
			}else if(currCountRight<0){
//				log.error("For instruction "+currKey+", " +
//				"the second CountingResult has a negative count of "+
//				currCountLeft+" even though negative counts are not allowed!");
				return false;
			}else{//if(currCountRight>0)
				if(currCountRight==currCountLeft){//TODO make sure equals is not needed here... object level!
					//everything is fine
				}else{
//					log.error("opcode "+currKey+": " +
//							"positive second count of "+currCountRight+
//							" different from first count of "+currCountLeft);
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		System.out.println("The main method of CountingResult serves as " +
				"a test case for compareCounts method");
		TreeMap<Integer, Long> opcodeCounts1 = new TreeMap<Integer, Long>();
		TreeMap<Integer, Long> opcodeCounts2 = new TreeMap<Integer, Long>();
		TreeMap<Integer, Long> opcodeCounts3 = new TreeMap<Integer, Long>();
		opcodeCounts1.put(1, 11L);
		opcodeCounts1.put(2, 0L);

		opcodeCounts2.put(1, 11L);
		opcodeCounts2.put(3, 0L);
		
		opcodeCounts3.put(1, 12L);
		opcodeCounts3.put(2, 0L);
		
		if(compareCounts(opcodeCounts1, opcodeCounts1)){
			System.out.println("Properly compared opcodeCounts1 with itself");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts1 with itself");
		}
		
		if(compareCounts(opcodeCounts2, opcodeCounts2)){
			System.out.println("Properly compared opcodeCounts2 with itself");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts2 with itself");
		}
		
		if(compareCounts(opcodeCounts3, opcodeCounts3)){
			System.out.println("Properly compared opcodeCounts3 with itself");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts3 with itself");
		}
		
		
		if(compareCounts(opcodeCounts1, opcodeCounts2)){
			System.out.println("Properly compared opcodeCounts1 and opcodeCounts2");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts1 and opcodeCounts2");
		}
		
		if(!compareCounts(opcodeCounts1, opcodeCounts3)){
			System.out.println("Properly compared opcodeCounts1 and opcodeCounts3");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts1 and opcodeCounts3");
		}
		
		if(compareCounts(opcodeCounts2, opcodeCounts1)){
			System.out.println("Properly compared opcodeCounts2 and opcodeCounts1");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts2 and opcodeCounts1");
		}
		
		if(!compareCounts(opcodeCounts2, opcodeCounts3)){
			System.out.println("Properly compared opcodeCounts2 and opcodeCounts3");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts2 and opcodeCounts3");
		}
		
		if(!compareCounts(opcodeCounts3, opcodeCounts1)){
			System.out.println("Properly compared opcodeCounts3 and opcodeCounts1");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts3 and opcodeCounts1");
		}
		
		if(!compareCounts(opcodeCounts3, opcodeCounts2)){
			System.out.println("Properly compared opcodeCounts3 and opcodeCounts2");
		}else{
			System.err.println("IMPROPERLY compared opcodeCounts3 and opcodeCounts2");
		}
	}

	/**
	 * TODO
	 */
	private transient long[] arrayCreationCounts;
	
	/**
	 * TODO 
	 */
	private transient int[] arrayCreationDimensions;
	
	/**
	 * TODO
	 */
	private transient String[] arrayCreationTypeInfo;
	
	/**
	 * TODO 
	 */
	private transient List<Object> characterisations;
	
	/**
	 * TODO
	 */
	private transient List<String> characterisationTitles;
	
	/**
	 * TODO
	 */
	private transient List<Integer> characterisationTypes;
	
	/**
	 * For SPECjvm2008, we are using the constants from compress.Harness:
	 *     public static final int DATA_TYPE_COMPRESSED=3;
     *     public static final int DATA_TYPE_MIXED=2;
     *     public static final int DATA_TYPE_UNCOMPRESSED=1;
	 *     public static final int DATA_TYPE_UNKNOWN=0;//
 	 */
	private int fileType=0;
	
	//idea: QualifyingMethodSignatureInclClassName+.+
	//methodInvocationBeginning+.+
	//methodReportingTime+_+<optional:ParamDescription>_.SCResult
	/**
	 * There are no strict rules for the ID. For SPECjvm2008, we are using the
	 * file name of the file which is being compressed.
	 */
	private String ID;
	
	/**
	 * For example, for SPECjvm2008.Compress, this is the size of the input file (in bytes)
	 */
	private long inputCharacterisation=0;
	
	private boolean invariantMethodsAreInlined = false;
	
	/**
	 * This Map contains counts of method invocations, where the key is the 
	 * method signature
	 */
	private TreeMap<String, Long> methodCallCounts;

	/**
	 * This Map says whether the counts of the methods have been computed and 
	 * integrated into this CountingResults's method and instruction counts TODO
	 */
	@SuppressWarnings("unused")
	private TreeMap<String, Boolean> methodCountsExpansionStatus;
	
	/**
	 * The timestamp which marks the beginning of execution (i.e. run) 
	 * of the method for which this CountingResult holds bytecode counts 
	 */
	private long methodInvocationBeginning;
	
	/**
	 * The timestamp which was set immediately before this method called  
	 * the CountingResultCollector. In other words, this is 
	 * <b>approximately</b> the time when the method execution was finished.
	 */
	private long methodReportingTime;
	
	/**
	 * This Map contains the counts of elementary bytecode instructions
	 */
	private TreeMap<Integer, Long> opcodeCounts;
	
	/**
	 * For example, for SPECjvm2008.Compress, this is the size of the 
	 * buffer which holds the compressed data of the input file
	 */
	private long outputCharacterisation=0;
	
	/**
	 * The name of the method whose execution was counted.
	 */
	private String qualifyingMethodName;
	
	/**
	 * Should be used by the next release
	 */
	private transient SortedMap<BytecodeSectionDescription,SortedMap<Integer,Long>> sectionInstCounts;
	
	/**
	 * Should be used by the next release
	 */
	private transient SortedMap<BytecodeSectionDescription,SortedMap<String,Long>> sectionMethCounts;
	
	/**
	 * Total count of all opcodes, except the four INVOKE* opcodes
	 */
	private Long totalCountExclInvokes;
	
	/**
	 * Total count of all opcodes, including the four INVOKE* opcodes
	 */
	private Long totalCountInclInvokes;

	/**
	 * Internal field which is using for "lazy computation"
	 */
	boolean totalCountsAlreadyComputed = false;

	/** This constructor passes the arguments to the corresponding fields;
	 * the five fields that do not appear (this.characterisations, 
	 * this.characterisationTitles, this.characterisationTypes and 
	 * this.totalCountExclInvokes / this.totalCountInclInvokes) are 
	 * initialised to empty collections (the first three) or set to 0 
	 * (the last two).
	 * @param ID
	 * @param qualifyingMethodName
	 * @param methodInvocationBeginning
	 * @param methodReportingTime
	 * @param opcodeCounts
	 * @param methodCallCounts
	 * @param arrayCreationCounts
	 * @param arrayCreationDimensions
	 * @param arrayCreationTypeInfo
	 * @param sectionInstCounts
	 * @param sectionMethCounts
	 */
	public CountingResult(//TODO make sure the instructions are "full", even if some instruction counts are zero
			String ID,
			String qualifyingMethodName, 
			int fileType,
			long inputCharacterisation,
			long outputCharacterisation,
			long methodInvocationBeginning, 
			long methodReportingTime, 
			TreeMap<Integer, Long> opcodeCounts, 
			TreeMap<String, Long> methodCallCounts,
			long[] arrayCreationCounts,
			int[] arrayCreationDimensions,
			String[] arrayCreationTypeInfo,
			SortedMap<BytecodeSectionDescription,SortedMap<Integer,Long>> sectionInstCounts,
			SortedMap<BytecodeSectionDescription,SortedMap<String,Long>> sectionMethCounts) {
		this.ID = ID;
		this.qualifyingMethodName = qualifyingMethodName;
		this.methodInvocationBeginning = methodInvocationBeginning;
		this.methodReportingTime = methodReportingTime;
		this.opcodeCounts = opcodeCounts;
		this.methodCallCounts = methodCallCounts;
		this.arrayCreationCounts = arrayCreationCounts;
		this.arrayCreationDimensions = arrayCreationDimensions;
		this.arrayCreationTypeInfo = arrayCreationTypeInfo;
		this.sectionInstCounts = sectionInstCounts;
		this.sectionMethCounts = sectionMethCounts;
		this.characterisations = new ArrayList<Object>();
		this.characterisationTitles = new ArrayList<String>();
		this.characterisationTypes = new ArrayList<Integer>();
		this.totalCountExclInvokes = 0L;
		this.totalCountInclInvokes = 0L;
		this.inputCharacterisation = inputCharacterisation;
		this.outputCharacterisation = outputCharacterisation;
//		try {
//			this.computeTotalOpcodeCounts();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	/** Adds the counts of this {@link CountingResult} instance to 
	 * the counting results 
	 * of the {@link CountingResult} instance given as parameter
	 * @param toBeAdded {@link CountingResult} instance whose counts are to be added
	 * @deprecated because yet untested w.r.t. new fields and side effects
	 */
	public synchronized void add(CountingResult toBeAdded){
		CountingResult skeletonResult = add(this,toBeAdded);
		this.methodCallCounts = skeletonResult.getMethodCallCounts();
		this.opcodeCounts = skeletonResult.getOpcodeCounts();
		this.arrayCreationCounts = skeletonResult.getNewArrayCounts();
		this.arrayCreationDimensions = skeletonResult.getNewArrayDim();
		this.arrayCreationTypeInfo = skeletonResult.getNewArrayTypes();
		skeletonResult = null;
//		TODO add section counts ... and other non-copied fields
	}

	/** Adds the counts of this {@link CountingResult} instance to 
	 * the counting results 
	 * of the {@link CountingResult} instance given as parameter
	 * @param toBeAdded {@link CountingResult} instance whose counts are to be added
	 * @deprecated because yet untested w.r.t. new fields and side effects
	 */
	public synchronized void add_methodsInstructionsOnly(CountingResult toBeAdded){
		CountingResult skeletonResult = add_methodInstructionsOnly(this,toBeAdded);
		this.methodCallCounts = skeletonResult.getMethodCallCounts();
		this.opcodeCounts = skeletonResult.getOpcodeCounts();
		skeletonResult = null;
	}

	/** TODO document
	 * @param characterisationTitle
	 * @param characterisationType
	 * @param characterisationValue
	 */
	public void addCharacterisation(
			String characterisationTitle,
			Integer characterisationType,
			Object characterisationValue){
		characterisationTitles.add(characterisationTitle);
		characterisationTypes.add(characterisationType);
		characterisations.add(characterisationValue);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@SuppressWarnings("unchecked")
	public Object clone(){ //TODO fix/test/coverage-test this!
		return new CountingResult(
				new String(this.ID),
				new String(this.qualifyingMethodName),
				fileType,
				inputCharacterisation,
				outputCharacterisation,
				methodInvocationBeginning,
				methodReportingTime,
				(TreeMap<Integer,Long>) this.opcodeCounts.clone(),
				(TreeMap<String,Long>) this.methodCallCounts.clone(),
				null, //this.arrayCreationCounts.clone(),
				null, //this.arrayCreationDimensions.clone(),
				null, //this.arrayCreationTypeInfo.clone(),
				null, //TODO: this.sectionInstCounts,
				null //this.sectionMethCounts
				);
	}
	
	/**
	 * TODO
	 * @throws Exception
	 */
	private synchronized void computeTotalOpcodeCounts() throws Exception {
		Iterator<Integer> iter = opcodeCounts.keySet().iterator();
		Integer currKey;
		long tentativeNewTotalCountInclInvokes = 0L;
		long tentativeNewTotalCountExclInvokes = 0L;
		for(;iter.hasNext();){
			currKey = iter.next();
			tentativeNewTotalCountInclInvokes = 
				totalCountInclInvokes
				+opcodeCounts.get(currKey);
			if(tentativeNewTotalCountInclInvokes<totalCountInclInvokes){
				throw new Exception("Overflow detected while " +
						"computing total opcode counts INCL invoke*");
			}else{
				totalCountInclInvokes = tentativeNewTotalCountInclInvokes;
			}
			if(currKey.intValue()==ASMOpcodesMapper_OLD.INVOKEINTERFACE
					|| currKey.intValue()==ASMOpcodesMapper_OLD.INVOKESPECIAL
					|| currKey.intValue()==ASMOpcodesMapper_OLD.INVOKESTATIC
					|| currKey.intValue()==ASMOpcodesMapper_OLD.INVOKEVIRTUAL){
				//not counting them
			}else{
				tentativeNewTotalCountExclInvokes = 
					totalCountExclInvokes
					+opcodeCounts.get(currKey);
				if(tentativeNewTotalCountExclInvokes<totalCountExclInvokes){
					throw new Exception("Overflow detected while " +
							"computing total opcode counts EXCL invoke*");
				}else{
					totalCountExclInvokes = tentativeNewTotalCountExclInvokes;
				}
			}
		}
		this.totalCountsAlreadyComputed = true;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public long[] getArrayCreationCounts() {
		return arrayCreationCounts;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public int[] getArrayCreationDimensions() {
		return arrayCreationDimensions;
	}
    
	/**
	 * TODO
	 * @return
	 */
	public String[] getArrayCreationTypeInfo() {
		return arrayCreationTypeInfo;
	}

	/**
	 * TODO
	 * @return
	 */
	public List<Object> getCharacterisations() {
		return characterisations;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public List<String> getCharacterisationTitles() {
		return characterisationTitles;
	}

	/**
	 * TODO
	 * @return
	 */
	public List<Integer> getCharacterisationTypes() {
		return characterisationTypes;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.ISimpleCountingResult#getFileType()
	 */
	public int getFileType() {
		return fileType;
	}

	/**
	 * @return
	 */
	public String getID() {
		return ID;
	}

//	/**
//	 * Constructs a new Result instance with the given values.
//	 * @param time Time of method execution as returned by System.nanoTime().
//	 * @param qualifyingMethodName Name of the evaluated method.
//	 * @param opcodeCounts HashMap containing counts for every opcode occurrence.
//	 * @param methodCallCounts HashMap containing count for every method that was called.
//	 * @param newArrayCounts The counts for the specific array construction.
//	 * @param newArrayDim The dimension information for the 
//	 * specific array construction if more than one dimension exists.
//	 * @param newArrayType The descriptor string for array construction of non-
//	 * simple type or a string identifying the type else.
//	 * @deprecated
//	 */
//	public CountingResult(
//			long time, 
//			String qualifyingMethodName, 
//			HashMap<Integer, Long> opcodeCounts, 
//			HashMap<String, Long> methodCallCounts,
//			long[] newArrayCounts,
//			int[] newArrayDim,
//			String[] newArrayType) {
//		this.methodInvocationBeginning = time;
//		this.qualifyingMethodName = qualifyingMethodName;
//		this.opcodeCounts = opcodeCounts;
//		this.methodCallCounts = methodCallCounts;
//		this.arrayCreationCounts = newArrayCounts;
//		this.arrayCreationDimensions = newArrayDim;
//		this.arrayCreationTypeInfo = newArrayType;
//	}
	
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.ISimpleCountingResult#getInputCharacterisation()
	 */
	public long getInputCharacterisation() {
		return inputCharacterisation;
	}
	
	/** 
	 * Simple getter for method call counts.
	 * @return A {@link HashMap} were the method name is mapped to the number 
	 * of calls of that method.
	 */
	public TreeMap<String, Long> getMethodCallCounts() {
		return methodCallCounts;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getMethodCount(java.lang.String)
	 */
	public Long getMethodCount(String methodName){
		return getMethodCountByString(methodName);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getMethodCountByString(java.lang.String)
	 */
	public Long getMethodCountByString(String methodName){
		Long count = this.methodCallCounts.get(methodName);//TODO check keys!
		if(count==null){
			return new Long(NO_COUNT_AVAILABLE);
		}else{
			return count;
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getMethodInvocationBeginning()
	 */
	public long getMethodInvocationBeginning() {
		return methodInvocationBeginning;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getMethodReportingTime()
	 */
	public long getMethodReportingTime() {
		return methodReportingTime;
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

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getOpcodeCount(int)
	 */
	public Long getOpcodeCount(int opcode){
		return getOpcodeCountByInteger(opcode);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getOpcodeCount(java.lang.String)
	 */
	public Long getOpcodeCount(String opcode){
		return getOpcodeCountByString(opcode);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getOpcodeCountByInteger(int)
	 */
	public Long getOpcodeCountByInteger(int opcode){
		Long count = this.opcodeCounts.get(new Integer(opcode));
		if(count==null){
			return new Long(NO_COUNT_AVAILABLE);
		}else{
			return count;
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getOpcodeCountByString(java.lang.String)
	 */
	public Long getOpcodeCountByString(String opcode){
		Long count = this.opcodeCounts.get(ASMOpcodesMapper_OLD.getInstance().getOpcodeInteger(opcode));
		if(count==null){
			return new Long(NO_COUNT_AVAILABLE);
		}else{
			return count;
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getOpcodeCounts()
	 */
	public TreeMap<Integer, Long> getOpcodeCounts() {
		return opcodeCounts;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.ISimpleCountingResult#getOutputCharacterisation()
	 */
	public long getOutputCharacterisation() {
		return outputCharacterisation;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getQualifyingMethodName()
	 */
	public String getQualifyingMethodName() {
		return qualifyingMethodName;
	}

	/**
	 * @return
	 */
	public SortedMap<BytecodeSectionDescription, SortedMap<Integer, Long>> getSectionInstCounts() {
		return sectionInstCounts;
	}

	/**
	 * @return
	 */
	public SortedMap<BytecodeSectionDescription, SortedMap<String, Long>> getSectionMethCounts() {
		return sectionMethCounts;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.IFullCountingResult#getTotalOpcodeCount(boolean)
	 */
	public synchronized Long getTotalOpcodeCount(boolean includeInvokeOpcodes) {
		if(!totalCountsAlreadyComputed){
			try {
				this.computeTotalOpcodeCounts();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(includeInvokeOpcodes){
			return totalCountInclInvokes;
		}else{
			return totalCountExclInvokes;
		}
	}

	/**
	 * Flag indicating whether called methods are inlined (already part of bytecode counts)
	 * @return
	 */
	public boolean isInvariantMethodsAreInlined() {
		return invariantMethodsAreInlined;
	}

	/**
	 * Returns the total number of method invocations 
	 * @return
	 */
	public synchronized Long methodCountSum() {
		return getTotalOpcodeCount(true) - getTotalOpcodeCount(false);
	}

	public void overwriteMethodCallCounts(TreeMap<String, Long> methodCounts){
//		System.err.println("Method call counts overwritten (instead of adding...)");
		this.methodCallCounts = methodCounts;
	}

	public void overwriteOpcodeCounts(TreeMap<Integer, Long> opcodeCounts){
//		System.err.println("Opcode counts overwritten (instead of adding...)");
		this.opcodeCounts = opcodeCounts;
	}

	public void resetMethodInstructionCountsOnly(){
		this.opcodeCounts = new TreeMap<Integer, Long>();
		this.methodCallCounts = new TreeMap<String, Long>();
	}
	
	/**
	 * @param characterisations
	 */
	public void setCharacterisations(List<Object> characterisations) {
		this.characterisations = characterisations;
	}

//	/* (non-Javadoc)
//	 * @see de.uka.ipd.sdq.ByCounter.execution.ISimpleCountingResult#KK_getMethodCount(java.lang.String)
//	 */
//	public Long KK_getMethodCount(String methodName){
//		return getMethodCountByString(methodName);
//	}
//
//	/* (non-Javadoc)
//	 * @see de.uka.ipd.sdq.ByCounter.execution.ISimpleCountingResult#KK_getOpcodeCount(int)
//	 */
//	public Long KK_getOpcodeCount(int opcode){
//		return getOpcodeCountByInteger(opcode);
//	}
//
//	/* (non-Javadoc)
//	 * @see de.uka.ipd.sdq.ByCounter.execution.ISimpleCountingResult#KK_getOpcodeCount(java.lang.String)
//	 */
//	public Long KK_getOpcodeCount(String opcode){
//		return getOpcodeCountByString(opcode);
//	}

	/**
	 * @param characterisationTitles
	 */
	public void setCharacterisationTitles(List<String> characterisationTitles) {
		this.characterisationTitles = characterisationTitles;
	}

	/**
	 * @param characterisationTypes
	 */
	public void setCharacterisationTypes(List<Integer> characterisationTypes) {
		this.characterisationTypes = characterisationTypes;
	}

	/**
	 * @param fileType
	 */
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	/**
	 * @param newID
	 */
	public void setID(String newID) {
		ID = newID;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.ITestCountingResult#setInputCharacterisation(long)
	 */
	public void setInputCharacterisation(long inputCharacterisation) {
		this.inputCharacterisation = inputCharacterisation;
	}

	/**
	 * Flag indicating whether called methods are inlined (already part of bytecode counts)
	 */
	public void setInvariantMethodsAreInlined(boolean invariantMethodsAreInlined) {
		this.invariantMethodsAreInlined = invariantMethodsAreInlined;
	}

	public void setMethodInvocationBeginning(long methodInvocationBeginning) {
		this.methodInvocationBeginning = methodInvocationBeginning;
	}

	public void setMethodReportingTime(long methodReportingTime) {
		this.methodReportingTime = methodReportingTime;
	}

	/**
	 * TODO: SEE Interface 
	 */
	public void setOpcodeCount(int opcode, Long count) {
		Integer opcodeI = new Integer(opcode);
		if(this.opcodeCounts.containsKey(opcodeI)) {
			this.opcodeCounts.remove(opcodeI);
		}
		this.opcodeCounts.put(opcodeI, count);
		this.totalCountsAlreadyComputed = false;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.ByCounter.execution.ITestCountingResult#setOutputCharacterisation(long)
	 */
	public void setOutputCharacterisation(long outputCharacterisation) {
		this.outputCharacterisation = outputCharacterisation;
	}

	/**
	 * TODO replace return type to indicate precise location of difference (using the sum 1+2+4+8+16+etc.)
	 * @param vr
	 * @return
	 */
	public boolean shallowEquals(CountingResult vr){
		if(this.inputCharacterisation!=vr.inputCharacterisation){
			System.out.println("CountingResult.shallowEquals: == on inputCharacterisation: "+this.inputCharacterisation+" vs "+vr.inputCharacterisation);
			return false;
		}
		if(this.invariantMethodsAreInlined!=vr.invariantMethodsAreInlined){
			System.out.println("CountingResult.shallowEquals: == on invariantMethodsAreInlined: "+this.invariantMethodsAreInlined+" vs "+vr.invariantMethodsAreInlined);
			return false;
		}
		if(this.outputCharacterisation!=vr.outputCharacterisation){
			System.out.println("CountingResult.shallowEquals: == on outputCharacterisation: "+this.outputCharacterisation+" vs "+vr.outputCharacterisation);
			return false;
		}
		if(this.qualifyingMethodName!=vr.qualifyingMethodName){
			System.out.println("CountingResult.shallowEquals: == on qualifyingMethodName: "+this.qualifyingMethodName+" vs "+vr.qualifyingMethodName);
			return false;
		}
		if(this.totalCountExclInvokes!=vr.totalCountExclInvokes){
			System.out.println("CountingResult.shallowEquals: == on totalCountExclInvokes: "+this.totalCountExclInvokes+" vs "+vr.totalCountExclInvokes);
			return false;
		}
		if(this.totalCountInclInvokes!=vr.totalCountInclInvokes){
			System.out.println("CountingResult.shallowEquals: == on totalCountInclInvokes returns false: "+this.totalCountInclInvokes+" vs "+vr.totalCountInclInvokes);
			return false;
		}

		if(!this.methodCallCounts.equals(vr.methodCallCounts)){
			System.out.println("CountingResult.shallowEquals: equals on methodCallCounts returns false"/*+this.methodCallCounts+" vs "+vr.methodCallCounts*/);
			return false;
		}
		
		//TODO care for the case of zeros vs. non-figurement...
		if(this.opcodeCounts.equals(vr.opcodeCounts)){
			//could say "return true;" here directly, because no other check is following 
		}else{
			if(!compareCounts(opcodeCounts,vr.opcodeCounts)){
				System.out.println("CountingResult.shallowEquals: " +
						"equals on opcodeCounts returns false"
						/*+this.opcodeCounts+" vs "+vr.opcodeCounts*/);
				return false;
			}else{
				//could say "return true;" here directly, because no other check is following
				//
				//everything is fine despite the fact that "equals" returned false: 
				//this is due to the possibility that CountingResult is not 
				//obliged to explicitly list zero-counted opcodes; they may 
				//be skipped internally because values are stored using TreeMaps
				//
				//TODO instead of this dirty hack, consider enforcing fully
				//complete TreeMaps (this may result in ca. 200 additional
				//TreeMap entries, though...
			}
		}
//		if(!Arrays.equals(this.arrayCreationCounts, vr.arrayCreationCounts)){
//			return false;
//		}
//		if(!Arrays.equals(this.arrayCreationDimensions, vr.arrayCreationDimensions)){
//			return false;
//		}
//		if(!Arrays.equals(this.arrayCreationTypeInfo, vr.arrayCreationTypeInfo)){
//			return false;
//		}
//		if(!this.characterisations.equals(vr.characterisations)){
//			return false;
//		}
//		if(!this.characterisationTitles.equals(vr.characterisationTitles)){
//			return false;
//		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){ //TODO add missing fields (data type, ...)
		StringBuffer sb = new StringBuffer();
		sb.append("\n"+
				  "      "+this.getClass().getSimpleName()+" (hash code: "+this.hashCode()+")\n");
		sb.append("      > Method name     : "+this.qualifyingMethodName+"\n");
		sb.append("      > Method duration : "+(this.methodReportingTime-this.methodInvocationBeginning)+
				"(start: "+this.methodInvocationBeginning+", end: "+this.methodReportingTime+" \n");
		sb.append("      > Opcode counts   : "+this.opcodeCounts+"\n");
		sb.append("      > Method counts   : "+this.methodCallCounts+"\n");
//		sb.append("      > Method input    : "+this.inputParams+"\n");
//		sb.append("      > Method output   : "+this.outputParams+"\n");
//		sb.append("      > Array creations : "+this.arrayCreationCounts+"\n");
//		sb.append("      > Array dimensions: "+this.arrayCreationDimensions+"\n");
//		sb.append("      > Array type infos: "+this.arrayCreationTypeInfo+"\n");
//		sb.append("      > Sect. opc. cnts : "+this.sectionInstCounts+"\n");
//		sb.append("      > Sect. meth. cnts: "+this.sectionMethCounts+"\n");
		return sb.toString();
	}
	
	
}
