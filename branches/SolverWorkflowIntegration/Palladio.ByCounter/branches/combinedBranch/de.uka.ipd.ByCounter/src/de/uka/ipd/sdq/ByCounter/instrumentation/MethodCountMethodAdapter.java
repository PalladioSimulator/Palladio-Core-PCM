package de.uka.ipd.sdq.ByCounter.instrumentation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.LocalVariablesSorter;

import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;

/**
 * Visitor for a method declaration.
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class MethodCountMethodAdapter extends MethodAdapter implements Opcodes {	// evil implements instead of static import
	
	/**
	 * The fully qualifyied class name of {@link CountingResultCollector}, but 
	 * in bytecode form.
	 */
	private static final String CountingResultCollectorCanonicalNameDescriptor = 
		CountingResultCollector.class.getCanonicalName().replace('.', '/');

	private AdditionalOpcodeInformation additionalOpcInfo;	// all invoked methods and array information
	
	private HashSet<ICharacterisationHook> characterisationHooks;
	
	private InstrumentationParameters instrumentationParameters;
	
	/**
	 * When true, counting code is inserted; may depend on current line number for section counting.
	 */
	private boolean instrumentCounting;
	
	private Label lastLabel;					// the label that was visited last
	
	private Logger log;
	private LocalVariableManager lVarManager = null;
	private int methodInvocationArrayVar;
	private HashMap<String,  Integer> methodCounters = null;			// map from key:methodsignature to value:variable/register index
	private HashMap<Integer, Integer> arrayCreationCounters = null; 	// map from key:indexInAddOpcInfo to value:variable/register index
	private HashMap<Integer, Integer> instructionCounters = null;		// map from key:opcode to value:variable/register index
	private String qualifyingMethodName;
	
	private Label startCountingSectionLabel;	// label after which counting shall start
	
	private Label stopCountingSectionLabel;		// label after which counting shall stop
	
	private int timeVar;				// variable register holding the nanoTime()
	private boolean instructionCountersInitialised = false;
	private boolean methodCountersInitialised = false;
	private boolean arrayCountersInitialised = false;

	/**
	 * Creates the method adapter.
	 * @param v Preceding visitor in the chain.
	 * @param qualifyingMethodName Qualifying name of the method (used for reporting).
	 * @param pUseHighRegistersForCounting Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter.
	 * @param pUseResultCollector TODO
	 * @param invokedMethods A list containing all method signatures that are 
	 * invoked in the visited method.
	 */
	public MethodCountMethodAdapter(
			MethodVisitor v, 
			String qualifyingMethodName, 
			InstrumentationParameters instrumentationParameters) {
		super(v);
		this.log = Logger.getLogger(this.getClass().getCanonicalName());
		this.instructionCounters 	= new HashMap<Integer, Integer>();
		this.methodCounters 		= new HashMap<String, Integer>();
		this.arrayCreationCounters	= new HashMap<Integer, Integer>();
		this.characterisationHooks	= new HashSet<ICharacterisationHook>();
		this.qualifyingMethodName	= qualifyingMethodName;
		this.instrumentationParameters = instrumentationParameters;
		this.lVarManager = new LocalVariableManager(instrumentationParameters.getUseHighRegistersForCounting());
		if(instrumentationParameters.getStartLine() < 0) {
			this.instrumentCounting = true;
		} else {
			this.instrumentCounting = false;
		}
	}
	
	/**
	 * Count the construction of an array with the given parameters 
	 * where applicable. Use AdditionalOpcodeInformation.NO_INFORMATION*
	 * if a parameter is not used. If this method is called, 
	 * then only in addition to countOpcode, which is called for any opcode.
	 * TODO assert that this method is not called on its own without countOpcode
	 * @param integer Integer information. For array of a primitive type 
	 * such as int[], long[], etc. this encodes the type while 's' contains 
	 * no information.
	 * For multidimensional arrays, this holds the dimension while 's' holds the 
	 * type.
	 * <p>
	 * For new object type arrays this is empty and 's' holds the type.
	 * </p>
	 * @param s String information. For primitive type arrays such as int[], long[],
	 * etc. this is empty. In all other cases this hold the type information.
	 */
	private void countArrayConstruction(int integer, String s) {
		if(!instrumentCounting) {	// we are not in the section to count - skip
			return;
		}
		if(additionalOpcInfo == null) {
			log.error("The AdditionalOpcodeInfo was not set.");
		} else {
			// use the assigned variable index
			int id = additionalOpcInfo.getIndexOfAdditionInformation(integer, s);
			assert id != -1;
			int index = this.arrayCreationCounters.get(id);
			insertCounterIncrement(index);
		}
	}

	/**
	 * Count the call to the method described by the given parameters.
	 * The parameters may be taken directly from the visit instruction.
	 * @param owner Owner of the method, i.e. name of parent class. 
	 * @param name Method name.
	 * @param desc Method descriptor, i.e. parameter types and return type in asm/bytecode syntax.
	 */
	private void countMethodCall(String owner, String name, String desc) {
		if(!instrumentCounting) {	// we are not in the section to count - skip
			return;
		}
		if(additionalOpcInfo == null) {
			log.error("The AdditionalOpcodeInfo was not set.");
		} else {
			if(methodCounters==null){
				log.error("methodCounters is null");
			}
			// use the assigned variable index
			String signature = MethodPreInstrumentationParser
				.constructObjectMethodSignature(
						owner, name, desc);
			if(signature==null){
				log.error("signature is null");
			}
		
			int index = this.methodCounters.get(signature);
			insertCounterIncrement(index);
		}
	}

	/**
	 * Count the given opcode, i.e. increment its register.
	 * This will use a new register, if the opcode has not 
	 * appeared before.
	 * @param opcode Opcode to count.
	 */
	@SuppressWarnings("boxing")
	private void countOpcode(int pOpcode) {
		if(!instrumentCounting) {	// we are not in the section to count - skip
			return;
		}
		int index;	// index of the opcode counter register
		// look up the hashmap: has this opcode appeared before?
		// note: this check is now obsolete; leave it in as a "safety net"
		if(!this.instructionCounters.containsKey(pOpcode)) {
			this.log.error("ERROR: This opcode is unknown.");//TODO rather throw an exception...
			index = getNewCounterVar();
			this.instructionCounters.put(pOpcode, index);
			this.log.error("ERROR: Created new count for opcode " + pOpcode + ".");
			this.log.error("This opcode is unknown.");
		} else {
			// use the existing variable
			index = this.instructionCounters.get(pOpcode);
		}
		log.debug("Adding counter increment for counter "+index+" (opcode "+pOpcode+").");
		insertCounterIncrement(index);
	}
	
	/**
	 * Enter the section specified by {@link InstrumentationParameters}.startLine
	 * and {@link InstrumentationParameters}.stopLine to enable counting.
	 */
	private void disableCounting() {
		this.instrumentCounting = false;
		log.debug("Exiting section for the insertion of counting instructions (line " 
				+ instrumentationParameters.getStopLine() + ").");
	}

	/**
	 * Exit the section specified by {@link InstrumentationParameters}.startLine
	 * and {@link InstrumentationParameters}.stopLine to disable counting.
	 */
	private void enableCounting() {
		this.instrumentCounting = true;
		log.debug("Entering section for the insertion of counting instructions (line " 
				+ instrumentationParameters.getStartLine() + ").");
	}

	/**
	 * Gets a new variable intended for use as a counter and respects the
	 * precision set in {@link InstrumentationParameters}.
	 * @return The index of the new variable.
	 */
	private int getNewCounterVar() {
		switch(instrumentationParameters.getCounterPrecision()) {
		case InstrumentationParameters.COUNTER_PRECISION_INT:
			return lVarManager.getNewIntVar(mv);

		case InstrumentationParameters.COUNTER_PRECISION_LONG:
			return lVarManager.getNewLongVar(mv);
			
		default:
			log.error("Unknown precision (" 
					+ instrumentationParameters.getCounterPrecision() 
					+ ")");
			return -1;
		}
	}

	/**
	 * Initializes long locals that are intended to hold array counts. 
	 */
	private void initialiseArrayCounters() {
		if(!instructionCountersInitialised || !methodCountersInitialised){
			log.error("initialiseArrayCounts must be called after " +
					"initialiseInstructionCounters and before initialiseMethodCounters");
			return;
		}
		arrayCountersInitialised = true;
		int additionalInformationSize = additionalOpcInfo.getIntInformation().length;
		int var;	// the index for the new variable
		// Initialize registers for all array constructions.
		// make sure the information lists are synchronized 
		assert additionalInformationSize
			== additionalOpcInfo.getStringInformation().size();
		for(int i = 0; 
				i < additionalInformationSize; 
				i++) {
			var = getNewCounterVar();
			// use index in list as id
			arrayCreationCounters.put(i, var);
		}
	}

	/**
	 * Initializes integer locals that are intended to hold method counts. 
	 */
	private void initialiseMethodCounters() {
		if(!instructionCountersInitialised || arrayCountersInitialised){
			log.error("initialiseMethodCounts must be called after " +
					"initialiseInstructionCounters and before initialiseArrayCounters");
			return;
		}
		methodCountersInitialised = true;
		int var;	// the index for the new variable
		// Initialize registers for all method invocations.
		int nrOfMethods = additionalOpcInfo.getMethodInvokations().size();
		log.debug(nrOfMethods+" methods to allocate counters for");
		String method;
		for(int i = 0; 
				i < nrOfMethods;
				i++) {
			var = getNewCounterVar();
			method = additionalOpcInfo.getMethodInvokations().get(i);
			methodCounters.put(method, var);
		}
	}

	/**
	 * Initializes integer locals that are intended to hold opcode counts. 
	 */
	private void initialiseInstructionCounters() {
		if(arrayCountersInitialised || methodCountersInitialised){
			log.error("initialiseInstructionCounts must be called before " +
					"initialiseMethodCounters and initialiseArrayCounters");
			return;
		}
		instructionCountersInitialised = true;
		int var;	// the index for the new variable
		// Initialize registers for all possible opcodes.
		int nrOfCountersToAllocate = 256;
		// use the fixed set of registers near max_locals
		for(int i = 0; i < nrOfCountersToAllocate; i++) {
			var = getNewCounterVar();
			//save the reference from opcode "i" to its counter in local variable var
			instructionCounters.put(i, var);
		}
	}
	
	/**
	 * Inserts bytecode that creates a new int array and fills it with the
	 * contents of the given integerList.
	 * @param integerList The integer contents.
	 * @return The variable index for the new int array.
	 */
	private int insertAndFillIntArray(int[] integerList) {
		int numElements = integerList.length;
		insertIntegerPushInsn(numElements);
		mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_INT);
		
		int index = this.lVarManager.getNewIntArrayVar(mv);
		mv.visitVarInsn(Opcodes.ASTORE, index);	// store the array
		
		for(int i = 0; i < numElements; i++) {
			// store the value in the array
			mv.visitVarInsn(Opcodes.ALOAD, index);
			insertIntegerPushInsn(i);
			mv.visitLdcInsn(integerList[i]);
			mv.visitInsn(Opcodes.IASTORE);
		}
		return index;
	}
	
	/**
	 * Inserts bytecode that creates a new string array and fills it with the
	 * contents of list.
	 * @param list The strings to store in the array.
	 * @return The variable index for the new string array.
	 */
	private int insertAndFillNewStringArray(List<String> list) {
		int numElements = list.size();
		insertIntegerPushInsn(numElements);
		mv.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/String");
		
		int index = this.lVarManager.getNewStringArrayVar(mv);
		mv.visitVarInsn(Opcodes.ASTORE, index);	// store the array
		
		for(int i = 0; i < numElements; i++) {
			// store the string in the array
			mv.visitVarInsn(Opcodes.ALOAD, index);
			insertIntegerPushInsn(i);
			mv.visitLdcInsn(list.get(i));
			mv.visitInsn(Opcodes.AASTORE);
		}
		return index;
	}

	/**
	 * Inserts bytecode that creates a new array and fills it with the
	 * contents of the locals for which the indices are given.
	 * @param indicesOfArrayCounters The indices of the counter registers.
	 * @return The variable index for the new array.
	 */
	private int insertAndFillCounterArrayFromRegisters(
			int[] indicesOfArrayCounters) {
		int index;	// the index to return
		int numElements = indicesOfArrayCounters.length;
		insertIntegerPushInsn(numElements); //load array size - has NOTHING to do with the counter type		

		// choose the instructions by precision:
		switch(instrumentationParameters.getCounterPrecision()) {
		case InstrumentationParameters.COUNTER_PRECISION_INT:
			mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_INT);
			index = this.lVarManager.getNewIntArrayVar(mv);
			mv.visitVarInsn(Opcodes.ASTORE, index);	// store the array

			for(int i = 0; i < numElements; i++) {
				// store the value in the array
				mv.visitVarInsn(Opcodes.ALOAD, index);
				insertIntegerPushInsn(i); //load index - NOT the counter value...
				mv.visitVarInsn(Opcodes.ILOAD, indicesOfArrayCounters[i]);	// load counter value from local variable
				mv.visitInsn(Opcodes.IASTORE);
			}
			break;
		case InstrumentationParameters.COUNTER_PRECISION_LONG:
			mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_LONG);
			index = this.lVarManager.getNewLongArrayVar(mv);
			mv.visitVarInsn(Opcodes.ASTORE, index);	// store the array
			
			for(int i = 0; i < numElements; i++) {
				// store the value in the array
				mv.visitVarInsn(Opcodes.ALOAD, index);
				insertIntegerPushInsn(i); //load index - NOT the counter value...
				mv.visitVarInsn(Opcodes.LLOAD, indicesOfArrayCounters[i]);	// load counter value from local variable
				mv.visitInsn(Opcodes.LASTORE);
			}
			break;
		default:
			log.error("Unknown COUNTER_PRECISION.");
			return -1;
		}
		return index;
	}

	/**
	 * Increments the counter with the given index.
	 * Chooses IINC or LADD depending on counter precision.
	 * @param index The index of the counter to increment.
	 */
	private void insertCounterIncrement(int index) {
		// choose the counter incrementation instructions by precision:
		switch(instrumentationParameters.getCounterPrecision()) {
		case InstrumentationParameters.COUNTER_PRECISION_INT:
			this.mv.visitIincInsn(index, 1);	// increment the register
			break;
		case InstrumentationParameters.COUNTER_PRECISION_LONG:
			this.mv.visitVarInsn(Opcodes.LLOAD, index);
			this.mv.visitInsn(LCONST_1);
			this.mv.visitInsn(LADD);
			this.mv.visitVarInsn(LSTORE, index);
			break;
		default:
			log.error("Unknown COUNTER_PRECISION.");
			break;
		}
	}

	/**
	 * Insert a call such as BIPUSH or SIPUSH. The latter is used if 
	 * the given integer is too big to fit into a byte.
	 * @param i Integer to push
	 */
	private void insertIntegerPushInsn(int i) {
		if(i <= Byte.MAX_VALUE) {
			mv.visitIntInsn(Opcodes.BIPUSH, i);
		} else {
			mv.visitIntInsn(Opcodes.SIPUSH, i);
		}
	}

	/**
	 * This is being called at the end of the method to report the resulting counts.
	 */
	@SuppressWarnings("boxing")
	private void insertResultCollectorCall() {
		int opcodeListVar = createOpcodeCountsArray();
		
		int methodListVar = createMethodCountsArrays();
		
		int newArrayListVar = -1;
		int newArrayTypeOrDimListVar = -1;
		int newArrayDescVar = -1;
		if(instrumentationParameters.getUseArrayParameterRecording()) {
			// set up an index array for the newarray counters
			int[] indicesOfArrayCounters = new int[arrayCreationCounters.size()];
			for(int i = 0; i < indicesOfArrayCounters.length; i++) {
				indicesOfArrayCounters[i] = arrayCreationCounters.get(i);
			}
			// store the newarray counts in an array
			newArrayListVar = insertAndFillCounterArrayFromRegisters(indicesOfArrayCounters);
			newArrayTypeOrDimListVar = insertAndFillIntArray(additionalOpcInfo.getIntInformation());
			newArrayDescVar = insertAndFillNewStringArray(additionalOpcInfo.getStringInformation());
			log.debug("Array parameter recording ON: "+indicesOfArrayCounters.length+
					" array counters");
		}
		
		if(instrumentationParameters.getUseResultCollector()){
			//use CountingResultCollector
			this.mv.visitMethodInsn(Opcodes.INVOKESTATIC, 
					CountingResultCollectorCanonicalNameDescriptor, 
					"getInstance", 
					"()L"+CountingResultCollectorCanonicalNameDescriptor + ";");
		} else {
			log.info("Instrumenting "+qualifyingMethodName+
					" without result collector: skipping getting CountingResultCollector instance");
		}
		this.mv.visitVarInsn(Opcodes.LLOAD, this.timeVar); //converted to long --> taking two bytes!
		this.mv.visitLdcInsn(this.qualifyingMethodName);
		this.mv.visitVarInsn(Opcodes.ALOAD, opcodeListVar);
		this.mv.visitVarInsn(Opcodes.ALOAD, methodListVar);
		this.mv.visitVarInsn(Opcodes.ALOAD, methodInvocationArrayVar);
		if(instrumentationParameters.getUseArrayParameterRecording()) {
			this.mv.visitVarInsn(Opcodes.ALOAD, newArrayListVar);
			this.mv.visitVarInsn(Opcodes.ALOAD, newArrayTypeOrDimListVar);
			this.mv.visitVarInsn(Opcodes.ALOAD, newArrayDescVar);
		} else {
			this.mv.visitInsn(Opcodes.ACONST_NULL);
			this.mv.visitInsn(Opcodes.ACONST_NULL);
			this.mv.visitInsn(Opcodes.ACONST_NULL);
		}
		
		String protocolCountSignature = null;
		String protocolCountMethodName = null;
		// Choose the proper protocolCountMethod depending on the precision
		String directWritingToLogSignature = null;
		if(instrumentationParameters.getCounterPrecision() 
				== InstrumentationParameters.COUNTER_PRECISION_INT) {
			protocolCountMethodName = "protocolCountInt";
			protocolCountSignature = "(JLjava/lang/String;[I[I[Ljava/lang/String;[I[I[Ljava/lang/String;)V";
			directWritingToLogSignature = "(JLjava/lang/String;[I[I[Ljava/lang/String;[I[I[Ljava/lang/String;)V";
		} else if(instrumentationParameters.getCounterPrecision() 
				== InstrumentationParameters.COUNTER_PRECISION_LONG) {
			protocolCountMethodName = "protocolCountLong";
			protocolCountSignature = "(JLjava/lang/String;[J[J[Ljava/lang/String;[J[I[Ljava/lang/String;)V";
			directWritingToLogSignature = "(JLjava/lang/String;[J[J[Ljava/lang/String;[J[I[Ljava/lang/String;)V";
		} else {
			log.fatal("AAGGGGI");
		}

		if(instrumentationParameters.getUseResultCollector()) {
			//in fact, CountingResultCollector.protocolCount(....) is static - 
			//no target CountingResultCollector instance is on the stack
			this.mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, 
				CountingResultCollectorCanonicalNameDescriptor, 
				protocolCountMethodName, 
				protocolCountSignature);
				
		} else {
			String classname = qualifyingMethodName.substring
					(0, qualifyingMethodName.lastIndexOf('.'))
					.replace('.', '/');
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, 
					classname, 
					"___directWritingToLog___", 
					directWritingToLogSignature);
		}
	}

	private int createMethodCountsArrays() {
		// set up an index array for the method counters
		int[] indicesOfMethodCounters = new int[methodCounters.size()];
		for(int i = 0; i < indicesOfMethodCounters.length; i++) {
			indicesOfMethodCounters[i] = methodCounters.get(additionalOpcInfo.getMethodInvokations().get(i));
		}
		// store the method counts
		int methodListVar = insertAndFillCounterArrayFromRegisters(indicesOfMethodCounters);
		log.debug("variable "+methodListVar+" holds array of longs that hold "+
				indicesOfMethodCounters.length+" method counts ");
		
		// Store the method signatures.
		methodInvocationArrayVar = insertAndFillNewStringArray(additionalOpcInfo.getMethodInvokations());
		log.debug("variable "+methodInvocationArrayVar+" holds array of string that hold "+
				additionalOpcInfo.getMethodInvokations().size()+" method names");
		return methodListVar;
	}

	private int createOpcodeCountsArray() {
		// set up an index array that holds the variable indices for the opcode counters
		int[] indicesOfInstructionCounters = new int[instructionCounters.size()];
		for(int i = 0; i < indicesOfInstructionCounters.length; i++) {
			indicesOfInstructionCounters[i] = instructionCounters.get(i);
		}
		// store the opcode counts
		int opcodeListVar = insertAndFillCounterArrayFromRegisters(indicesOfInstructionCounters);
		log.debug("variable "+opcodeListVar+" holds array of longs that hold "+
				indicesOfInstructionCounters.length+" opcode counts ");
		return opcodeListVar;
	}

	/**
	 * Decides whether the given opcode is a return statement or a throw
	 * which both terminate the method.
	 * @param opcode Opcode to analyze.
	 * @return True if opcode is a returnstatement/throwstatement, false otherwise.
	 */
	private boolean isReturnStatement(int opcode) {
		switch(opcode) {
			case Opcodes.ARETURN:
			case Opcodes.DRETURN:
			case Opcodes.FRETURN:
			case Opcodes.IRETURN:
			case Opcodes.LRETURN:
			case Opcodes.RETURN:
			case Opcodes.ATHROW:	// exceptions will also terminate the method TODO does this conflict with resultCollector into a log file?
				return true;
			default:
				return false;
		}
	}


	/**
	 * Record the parameters for methodcalls.
	 * @param methodCountMethodAdapter
	 * @param instrumentationParams
	 * @param opcode
	 * @param owner
	 * @param name
	 * @param desc
	 */
	private void recordParameters(
			MethodCountMethodAdapter methodCountMethodAdapter,
			InstrumentationParameters instrumentationParams, 
			int opcode,
			String owner, String name, String desc) {
		// Loop through all hooks and gather the characterisations.
		for(ICharacterisationHook hook : characterisationHooks) {
			hook.methodCallHook(methodCountMethodAdapter, 
					instrumentationParameters, opcode, owner, name, desc);
		}
	}
	
	/**
	 * Register a {@link ICharacterisationHook}.
	 * @see ICharacterisationHook
	 * @param hook
	 */
	public void registerCharacterisationHook(ICharacterisationHook hook) {
		this.characterisationHooks.add(hook);
		log.info("Registered new CharacterisationHook " + hook + " ...");
	}

	/*
	 * Insert counter into all kind of instructions.
	 */

	/**
	 * Sets the LocalVariableSorter that is used to generate new locals.
	 * This must be called before this Adapter is evaluated.
	 * @param lvars LocalVariableSorter
	 */
	public void setLVS(LocalVariablesSorter pLvars) {
		this.lVarManager.setLVS(pLvars);
	}

	/**
	 * Sets the MethodInvocationsFinder that is used to determine registers
	 * for method invocation counts.
	 * This must be called before this Adapter is evaluated.//TODO is this ensured/asserted/checken?
	 * @param additionalOpcInfo Finder instance.
	 */
	public void setMethodInvocations(AdditionalOpcodeInformation additionalOpcInfo) {
		this.additionalOpcInfo = additionalOpcInfo;
	}


	/**
	 * This is being called at the beginning of the method.
	 */
	@SuppressWarnings({ "unqualified-field-access", "boxing" })
	@Override
	public void visitCode() {
		super.visitCode();
		log.debug("Instrumenting...");
		timeVar = lVarManager.getNewLongVar(mv);

		// save the time
		mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "nanoTime", "()J");
		mv.visitVarInsn(Opcodes.LSTORE, timeVar);
		
		initialiseInstructionCounters();		
		initialiseMethodCounters();
		if(this.instrumentationParameters.getUseArrayParameterRecording()) {
			initialiseArrayCounters();
		}
	}

	/* (non-Javadoc)
	 * @see org.objectweb.asm.MethodAdapter#visitFieldInsn(int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void visitFieldInsn(int opcode, String owner, String name, String desc) {
		countOpcode(opcode);
		this.mv.visitFieldInsn(opcode, owner, name, desc);
	}

	/*
	 * Insert counter into all kind of instructions.
	 */

	/* (non-Javadoc)
	 * @see org.objectweb.asm.MethodAdapter#visitIincInsn(int, int)
	 */
	@Override
	public void visitIincInsn(int var, int increment) {
		countOpcode(Opcodes.IINC);
		mv.visitIincInsn(var, increment);
	}

	/**
	 * Step into every call to insert counters.
	 */
	@Override
	public void visitInsn(int opcode) {
			countOpcode(opcode);
		if(isReturnStatement(opcode)) {
			// call the hooks
			for(ICharacterisationHook hook : characterisationHooks) {//TODO costly collection inquiry -> wrap in a "if" query on a flag
				hook.methodReturnHook(this, instrumentationParameters);
			}
			// method ends, so report the results
			insertResultCollectorCall();
		}
		// visit statement
		mv.visitInsn(opcode);
	}

	@Override
	public void visitIntInsn(int opcode, int operand) {
		countOpcode(opcode);
		// Check whether this is a NEWARRAY instruction.
		if(instrumentationParameters.getUseArrayParameterRecording() 
				&& opcode == Opcodes.NEWARRAY) {
			this.countArrayConstruction(
					operand, //(primitive) array type 
					AdditionalOpcodeInformation.NO_INFORMATION_STRING);
		}
		mv.visitIntInsn(opcode, operand);
	}

	@Override
	public void visitJumpInsn(int opcode, Label label) {
		countOpcode(opcode);
		mv.visitJumpInsn(opcode, label);
	}

	/* (non-Javadoc)
	 * @see org.objectweb.asm.MethodAdapter#visitLabel(org.objectweb.asm.Label)
	 */
	@Override
	public void visitLabel(Label label) {
		this.lastLabel = label;
		if(startCountingSectionLabel != null && label.equals(startCountingSectionLabel)) {
			enableCounting();
		}
		if(stopCountingSectionLabel != null && label.equals(stopCountingSectionLabel)) {
			disableCounting();
		}
		super.visitLabel(label);
	}

	@Override
	public void visitLdcInsn(Object constant) {
		countOpcode(LDC);
		mv.visitLdcInsn(constant);
	}

	/* (non-Javadoc)
	 * @see org.objectweb.asm.MethodAdapter#visitLineNumber(int, org.objectweb.asm.Label)
	 */
	@Override
	public void visitLineNumber(int line, Label start) {
		// the line with the number line starts after the label start
		if(line == this.instrumentationParameters.getStartLine()) {
			if(start.equals(lastLabel)) {
				enableCounting();
			} else {
				this.startCountingSectionLabel = start;
			}
		} else if (line == this.instrumentationParameters.getStopLine() + 1) {	// the line specified as stop line is still counted!
			if(start.equals(lastLabel)) {
				disableCounting();
			} else {
				this.stopCountingSectionLabel = start;
			}
		}
		super.visitLineNumber(line, start);
	}

	@Override
	public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
		countOpcode(LOOKUPSWITCH);
		mv.visitLookupSwitchInsn(dflt, keys, labels);
	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc) {
		countOpcode(opcode); //TODO document this double-counting externally
		countMethodCall(owner, name, desc);
		recordParameters(this, instrumentationParameters, 
				opcode, owner, name, desc);
		mv.visitMethodInsn(opcode, owner, name, desc);
	}

	@Override
	public void visitMultiANewArrayInsn(String desc, int dims) {
		countOpcode(Opcodes.MULTIANEWARRAY);
		if(instrumentationParameters.getUseArrayParameterRecording()) {
			this.countArrayConstruction(
					dims, 	//dimensions 
					desc);	//type (?)
		}
		mv.visitMultiANewArrayInsn(desc, dims);
	}

	@Override
	public void visitTableSwitchInsn(int min, int max, Label dflt, Label[] labels) {
		countOpcode(TABLESWITCH);
		mv.visitTableSwitchInsn(min, max, dflt, labels);
	}

	@Override
	public void visitTypeInsn(int opcode, String desc) {
		countOpcode(opcode);
		// Check whether this is a ANEWARRAY instruction.
		if(instrumentationParameters.getUseArrayParameterRecording() 
				&& opcode == Opcodes.ANEWARRAY) {
			this.countArrayConstruction(
					AdditionalOpcodeInformation.NO_INFORMATION_INT, //dimension of the array is passed separately, not on the stack TODO: how?
					desc);
		}
		mv.visitTypeInsn(opcode, desc);
	}

	@Override
	public void visitVarInsn(int opcode, int var) {
		countOpcode(opcode);
		mv.visitVarInsn(opcode, var);
	}
}
