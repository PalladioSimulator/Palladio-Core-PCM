package de.uka.ipd.sdq.ByCounter.instrumentation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
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
public class MethodCountMethodAdapter extends MethodAdapter {
	
	/**
	 * 
	 */
	private static final String CountingResultCollectorCanonicalNameDescriptor = 
		CountingResultCollector.class.getCanonicalName().replace('.', '/');
	
	private static final int max_locals = 65535;	// maximum number of locals in a method
	
	private static int register_offset = 1;
		
	private AdditionalOpcodeInformation additionalOpcInfo;	// all invoked methods and array information
	
	private HashSet<ICharacterisationHook> characterisationHooks;
	
	private InstrumentationParameters instrumentationParameters;
	
	/**
	 * When true, counting code is inserted; may depend on current line number for section counting.
	 */
	private boolean instrumentCounting;
	
	private Label lastLabel;					// the label that was visited last
	
	private Logger log;
	
	private LocalVariablesSorter lvars = null;
	
	private int methodCallStackVar;	// variable register holding the string stack for method call de.uka.ipd.sdq.ByCount
	
	private int methodInvocationArrayVar;
	
	private HashMap<String, Integer> methodMap = null;	// map from key:methodsignature to value:variable/register number
	
	private HashMap<Integer, Integer> newArrayMap = null; // map from key:indexInAddOpcInfo to value:variable/register number

	private HashMap<Integer, Integer> opcodeMap = null;	// map from key:opcode to value:variable/register number
	
	private String qualifyingMethodName;
	
	private Label startCountingSectionLabel;	// label after which counting shall start
	
	private Label stopCountingSectionLabel;		// label after which counting shall stop
	
	private int timeVar;	// variable register holding the nanoTime()
	
	private int tmpVar;		// temporarily holds variable register numbers; always used locally only!

	/**
	 * Creates the method adapter.
	 * @param v Preceding visitor in the chain.
	 * @param qualifyingName Qualifying name of the method (used for reporting).
	 * @param pUseHighRegistersForCounting Decides whether to preallocate registers near max_locals instead of using LocalVariablesSorter.
	 * @param pUseResultCollector TODO
	 * @param invokedMethods A list containing all method signatures that are 
	 * invoked in the visited method.
	 */
	public MethodCountMethodAdapter(
			MethodVisitor v, 
			String qualifyingName, 
			InstrumentationParameters instrumentationParameters) {
		super(v);
		this.log = Logger.getLogger(this.getClass().getCanonicalName());
		this.opcodeMap = new HashMap<Integer, Integer>();
		this.methodMap = new HashMap<String, Integer>();
		this.newArrayMap = new HashMap<Integer, Integer>();
		this.characterisationHooks = new HashSet<ICharacterisationHook>();
		this.qualifyingMethodName = qualifyingName;
		this.instrumentationParameters = instrumentationParameters;
		if(instrumentationParameters.getStartLine() < 0) {
			this.instrumentCounting = true;
		} else {
			this.instrumentCounting = false;
		}
	}
	
	/**
	 * Count the construction of an array with the given parameters 
	 * where applicable. Use AdditionalOpcodeInformation.NO_INFORMATION*
	 * if a parameter is not used.
	 * @param integer Integer information.
	 * @param s String information.
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
			this.tmpVar = this.newArrayMap.get(id);
			this.mv.visitIincInsn(this.tmpVar, 1);	// increment the register
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
			// use the assigned variable index
			this.tmpVar = this.methodMap.get(MethodPreInstrumentationParser.constructObjectMethodSignature(
					owner, name, desc));
			this.mv.visitIincInsn(this.tmpVar, 1);	// increment the register
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
		// look up the hashmap: has this opcode appeared before?
		// note: this check is now obsolete; leave it in as a "safety net"
		if(!this.opcodeMap.containsKey(pOpcode)) {
			// create a new variable
			this.tmpVar = getNewLongVar();
			this.opcodeMap.put(pOpcode, this.tmpVar);
			this.log.error("ERROR: Created new long var for opcode " + pOpcode + ".");
			this.log.error("This opcode is unknown.");
		} else {
			// use the existing variable
			this.tmpVar = this.opcodeMap.get(pOpcode);
		}
		
		// Check whether this is a *NEWARRAY instruction.
		// This happens for visitIntInsn (NEWARRAY), 
		// visitTypeInsn (ANEWARRAY)
		// and visitMultiANewArrayInsn (MULTIANEWARRAY)
		if(pOpcode == Opcodes.NEWARRAY) {
			
		} else if(pOpcode == Opcodes.ANEWARRAY) {
			
		} else if(pOpcode == Opcodes.MULTIANEWARRAY) {
			
		}
		
		this.mv.visitIincInsn(this.tmpVar, 1);	// increment the register
	}

	/**
	 * This is Michael's Java code for direct writing to a log that 
	 * serves as a template for the bytecode that is inserted 
	 * by the call to <code>insertDirectWritingToLogCalls()</code>.
	 * @see insertDirectWritingToLogCalls()
	 * @deprecated
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean directWritingToLogTemplate_MK() {
		String filename = "MK_TEST.log";
		byte[] ba1 = new byte[]{1};
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filename);
			out.write(ba1);
			if(out!=null){
				out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
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
	 * Register a new long and initialize it with 0.
	 * @return The variable index/identifier.
	 */
	@SuppressWarnings("boxing")
	private int getNewLongVar() {
		int var = this.lvars.newLocal(Type.LONG_TYPE);
		this.mv.visitLdcInsn(0);
		this.mv.visitVarInsn(Opcodes.ISTORE, var);
		return var;
	}

	/**
	 * Initializes integer locals that are intended to hold array counts. 
	 */
	private void initialiseArrayRegisters() {
		int intInformationSize = additionalOpcInfo.getIntInformation().length;
		// Initialize registers for all array constructions.
		if(instrumentationParameters.getUseHighRegistersForCounting()) {
			// use the fixed set of registers near max_locals
			// make sure the information lists are synchronized 
			assert intInformationSize
				== additionalOpcInfo.getStringInformation().size();
			for(int i = register_offset; 
					i < register_offset + intInformationSize; 
					i++) {
				mv.visitLdcInsn(0);
				mv.visitVarInsn(Opcodes.ISTORE, max_locals-i);
				// use index in list as id
				newArrayMap.put(i-register_offset, max_locals-i);
			}
			// update the register offset
			register_offset += intInformationSize;
		} else {
			// use LocalVariablesSorter
			for(int i = 0; i < intInformationSize; i++) {
				tmpVar = getNewLongVar();
				newArrayMap.put(i, tmpVar);
			}
		}
	}
	
	
	/**
	 * Initializes integer locals that are intended to hold method counts. 
	 */
	private void initialiseMethodRegisters() {
		// Initialize registers for all method invocations.
		if(instrumentationParameters.getUseHighRegistersForCounting()) {
			// use the fixed set of registers near max_locals
			for(int i = register_offset; 
					i < register_offset + additionalOpcInfo.getMethodInvokations().size();
					i++) {
				mv.visitLdcInsn(0);
				mv.visitVarInsn(Opcodes.ISTORE, max_locals-i);
				methodMap.put(additionalOpcInfo.getMethodInvokations()
						.get(i-register_offset), max_locals-i);
			}
			// update the register offset
			register_offset += additionalOpcInfo.getMethodInvokations().size();
		} else {
			// use LocalVariablesSorter
			for(int i = 0; i < additionalOpcInfo.getMethodInvokations().size(); i++) {
				tmpVar = getNewLongVar();
				methodMap.put(additionalOpcInfo.getMethodInvokations().get(i), tmpVar);
			}
		}
	}
	
	/**
	 * Initializes integer locals that are intended to hold opcode counts. 
	 */
	private void initialiseOpcodeRegisters() {
		// Initialize registers for all possible opcodes.
		if(instrumentationParameters.getUseHighRegistersForCounting()) {
			// use the fixed set of registers near max_locals
			for(int i = register_offset; i < 256 + register_offset; i++) {
				mv.visitLdcInsn(0);
				mv.visitVarInsn(Opcodes.ISTORE, max_locals-i);
				opcodeMap.put(i-register_offset, max_locals-i);
			}
			// update the register offset
			register_offset += 256;
		} else {
			// use LocalVariablesSorter
			for(int i = 0; i < 256; i++) {
				tmpVar = getNewLongVar();
				opcodeMap.put(i, tmpVar);
			}
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
		
		tmpVar = this.lvars.newLocal(Type.getObjectType("[I"));
		mv.visitVarInsn(Opcodes.ASTORE, tmpVar);	// store the array
		
		for(int i = 0; i < numElements; i++) {
			// store the value in the array
			mv.visitVarInsn(Opcodes.ALOAD, tmpVar);
			insertIntegerPushInsn(i);
			mv.visitLdcInsn(integerList[i]);
			mv.visitInsn(Opcodes.IASTORE);
		}
		return tmpVar;
	}

	
	/**
	 * Inserts bytecode that creates a new int array and fills it with the
	 * contents of integer locals for which the indices are given.
	 * @param indexList The indices of the integer registers
	 * @return The variable index for the new int array.
	 */
	private int insertAndFillIntArrayFromRegisters(int[] indexList) {
		int numElements = indexList.length;
		insertIntegerPushInsn(numElements);
		mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_INT);
		
		tmpVar = this.lvars.newLocal(Type.getObjectType("[I"));
		mv.visitVarInsn(Opcodes.ASTORE, tmpVar);	// store the array
		
		for(int i = 0; i < numElements; i++) {
			// store the value in the array
			mv.visitVarInsn(Opcodes.ALOAD, tmpVar);
			insertIntegerPushInsn(i);
			mv.visitVarInsn(Opcodes.ILOAD, indexList[i]);
			mv.visitInsn(Opcodes.IASTORE);
		}
		return tmpVar;
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
		
		tmpVar = this.lvars.newLocal(Type.getObjectType("[Ljava/lang/String;"));
		mv.visitVarInsn(Opcodes.ASTORE, tmpVar);	// store the array
		
		for(int i = 0; i < numElements; i++) {
			// store the string in the array
			mv.visitVarInsn(Opcodes.ALOAD, tmpVar);
			insertIntegerPushInsn(i);
			mv.visitLdcInsn(list.get(i));
			mv.visitInsn(Opcodes.AASTORE);
		}
		return tmpVar;
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
		// set up an index array that holds the variable indices for the opcode counters
		int[] indices = new int[opcodeMap.size()];
		for(int i = 0; i < opcodeMap.size(); i++) {
			indices[i] = opcodeMap.get(i);
		}		
		// store the opcode counts
		int opcodeListVar = insertAndFillIntArrayFromRegisters(indices);
		
		// set up an index array for the method counters
		indices = new int[methodMap.size()];
		for(int i = 0; i < methodMap.size(); i++) {
			indices[i] = methodMap.get(additionalOpcInfo.getMethodInvokations().get(i));
		}
		// store the method counts
		int methodListVar = insertAndFillIntArrayFromRegisters(indices);
		
		// Store the method signatures.
		methodInvocationArrayVar = insertAndFillNewStringArray(additionalOpcInfo.getMethodInvokations());
		
		int newArrayListVar = -1;
		int newArrayTypeOrDimListVar = -1;
		int newArrayDescVar = -1;
		if(instrumentationParameters.getUseArrayParameterRecording()) {
			// set up an index array for the newarray counters
			indices = new int[newArrayMap.size()];
			for(int i = 0; i < newArrayMap.size(); i++) {
				indices[i] = newArrayMap.get(i);
			}
			// store the newarray counts in an array
			newArrayListVar = insertAndFillIntArrayFromRegisters(indices);
			
			newArrayTypeOrDimListVar = insertAndFillIntArray(additionalOpcInfo.getIntInformation());
			newArrayDescVar = insertAndFillNewStringArray(additionalOpcInfo.getStringInformation());
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

		if(instrumentationParameters.getUseResultCollector()) {
			//in fact, CountingResultCollector.protocolCount(....) is static - 
			//no target CountingResultCollector instance is on the stack
			this.mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, 
				CountingResultCollectorCanonicalNameDescriptor, 
				"protocolCount", 
				"(JLjava/lang/String;[I[I[Ljava/lang/String;[I[I[Ljava/lang/String;)V");
		} else {
			String classname = qualifyingMethodName.substring
					(0, qualifyingMethodName.lastIndexOf('.'))
					.replace('.', '/');
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, 
					classname, 
					"___directWritingToLog___", 
					"(JLjava/lang/String;[I[I[Ljava/lang/String;[I[I[Ljava/lang/String;)V");
		}
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
			case Opcodes.ATHROW:	// exceptions will also terminate the method
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
		this.lvars  = pLvars;
	}

	/**
	 * Sets the MethodInvocationsFinder that is used to determine registers
	 * for method invocation counts.
	 * This must be called before this Adapter is evaluated.
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
		timeVar = getNewLongVar();

		// save the time
		mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "nanoTime", "()J");
		mv.visitVarInsn(Opcodes.LSTORE, timeVar);
		
		// create a string stack to store all method calls //TODO is this still used?
		methodCallStackVar = lvars.newLocal(Type.getObjectType("java/util/Stack"));
		mv.visitTypeInsn(Opcodes.NEW, "java/util/Stack");
		mv.visitInsn(Opcodes.DUP);
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Stack", "<init>", "()V");
		mv.visitVarInsn(Opcodes.ASTORE, methodCallStackVar);
				
		initialiseOpcodeRegisters();		
		initialiseMethodRegisters();
		if(instrumentationParameters.getUseArrayParameterRecording()) {
			initialiseArrayRegisters();
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
			this.countArrayConstruction(operand, 
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
		countOpcode(18);	// 18 is LDC
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
		countOpcode(171);	// 171 is LOOKUPSWITCH
		mv.visitLookupSwitchInsn(dflt, keys, labels);
	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc) {
		countOpcode(opcode);
		countMethodCall(owner, name, desc);
		recordParameters(this, instrumentationParameters, 
				opcode, owner, name, desc);
		mv.visitMethodInsn(opcode, owner, name, desc);
	}

	@Override
	public void visitMultiANewArrayInsn(String desc, int dims) {
		countOpcode(197);	// 197 is MULTIANEWARRAY
		if(instrumentationParameters.getUseArrayParameterRecording()) {
			this.countArrayConstruction(dims, desc);
		}
		mv.visitMultiANewArrayInsn(desc, dims);
	}
	
	@Override
	public void visitTableSwitchInsn(int min, int max, Label dflt, Label[] labels) {
		countOpcode(170);	// 170 is TABLESWITCH
		mv.visitTableSwitchInsn(min, max, dflt, labels);
	}

	@Override
	public void visitTypeInsn(int opcode, String desc) {
		countOpcode(opcode);
		// Check whether this is a ANEWARRAY instruction.
		if(instrumentationParameters.getUseArrayParameterRecording() 
				&& opcode == Opcodes.ANEWARRAY) {
			this.countArrayConstruction(AdditionalOpcodeInformation.NO_INFORMATION_INT, 
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
