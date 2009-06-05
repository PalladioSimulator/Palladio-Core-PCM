package de.uka.ipd.sdq.ByCounter.instrumentation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
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
 * @version 0.1
 * @deprecated
 */
public class MethodCountMethodAdapter extends MethodAdapter {
	private static final int max_locals = 65535;	// maximum number of locals in a method
	private static int register_offset = 1;
	private static final String ResultCollectorCanonicalNameDescriptor = 
		CountingResultCollector.class.getCanonicalName().replace('.', '/');
	
	/**
	 * This is java code for direct writing to a log that 
	 * serves as a template for the bytecode that is inserted 
	 * by the call to <code>insertDirectWritingToLogCalls()</code>.
	 * @see insertDirectWritingToLogCalls()
	 */
	@SuppressWarnings("unused")
	private static void directWritingToLogTemplate() {
		String lineSep = System.getProperty("line.separator");
		// The inserted bytecode is similar to the following java code:
		FileOutputStream out = null;
		try {
			try {
				out = new FileOutputStream("ByCounter output + File.separatorChar + ByCounterResult_test.log");
				out.write(("TimeStamp: " + 123456789012345L/*this.timeVar*/ + "lineSep"
					+ "Qualifying methodname: " + "this.qualifyingMethodName" + "lineSep"
					+ "Opcode counts:" + "lineSep").getBytes());
				// for i in (0, .., 256):
				out.write(("OPCODE"	// (ASMOpcodesMapper.getInstance().getOpcodeString(i)
						+ ": " + 9 + "lineSep").getBytes());
				out.write(("Method counts:" + "lineSep").getBytes());
				// for i in (0, numMethods):
				out.write(("SIGNATURE"	// methodInvocations.get(i)
						+ ": " + 9 + "lineSep").getBytes());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if(out != null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private AdditionalOpcodeInformation additionalOpcInfo;	// all invoked methods and array information
	private InstrumentationParameters instrumentationParameters;
	private Logger log;
	private LocalVariablesSorter lvars = null;
	private int methodCallStackVar;	// variable register holding the string stack for method call de.uka.ipd.sdq.ByCount
	private int methodInvocationArrayVar;
	private HashMap<String, Integer>  methodMap = null;		// map from key:methodsignature to value:variable/register number
	private HashMap<Integer, Integer> newArrayMap = null; 	// map from key:indexInAddOpcInfo to value:variable/register number
	private HashMap<Integer, Integer> opcodeMap = null;		// map from key:opcode to value:variable/register number
	private String qualifyingMethodName;
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
		this.qualifyingMethodName = qualifyingName;
		this.instrumentationParameters = instrumentationParameters;
	}
	
	/**
	 * Count the construction of an array with the given parameters 
	 * where applicable. Use AdditionalOpcodeInformation.NO_INFORMATION*
	 * if a parameter is not used.
	 * @param integer Integer information.
	 * @param s String information.
	 */
	private void countArrayConstruction(int integer, String s) {
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
				methodMap.put(additionalOpcInfo.getMethodInvokations().get(i-register_offset), max_locals-i);
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
	 * @see directWritingToLogTemplate_MK()
	 * @deprecated because not matching directWritingToLogTemplate_MK anymore
	 */
	private void insertDirectWritingToLogCalls() {
//		mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, "directWritingToLogTemplate_MK", "()V", null, null);
//		mv.visitCode();

		String strFileOutputStream = "java/io/FileOutputStream";
		String strFileNotFoundException = "java/io/FileNotFoundException";
		
		int outVar = this.lvars.newLocal(Type.getObjectType(strFileOutputStream));
		int exceptVar = this.lvars.newLocal(Type.getObjectType(strFileNotFoundException));
		int exceptVar0 = this.lvars.newLocal(Type.getObjectType("java/lang/Exception"));
		int logNameVar = this.lvars.newLocal(Type.getObjectType("java/lang/String"));
		int ba1Var = this.lvars.newLocal(Type.getObjectType("[B"));
		int testVar = this.lvars.newLocal(Type.getObjectType("int"));
		
	if (2 == 2) {	
		mv.visitVarInsn(Opcodes.ISTORE, testVar);
		Label l0 = new Label();
		Label l1 = new Label();
		Label l2 = new Label();
		mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
		Label l3 = new Label();
		mv.visitLabel(l3);
		mv.visitInsn(Opcodes.ACONST_NULL);
		mv.visitVarInsn(Opcodes.ASTORE, outVar);
		mv.visitLabel(l0);	// try start
		mv.visitTypeInsn(Opcodes.NEW, "java/io/FileOutputStream");
//		mv.visitInsn(Opcodes.DUP);
		mv.visitLdcInsn("./test.txt");
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/io/FileOutputStream", "<init>", "(Ljava/lang/String;)V");
//		mv.visitVarInsn(Opcodes.ASTORE, outVar);
		Label l4 = new Label();
		mv.visitLabel(l4);
//		mv.visitVarInsn(Opcodes.ALOAD, outVar);
//		mv.visitInsn(Opcodes.ICONST_1);
//		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "(I)V");
		mv.visitLabel(l1); // try end
		Label l5 = new Label();
//		mv.visitJumpInsn(Opcodes.GOTO, l5);
		mv.visitLabel(l2);
//		mv.visitVarInsn(Opcodes.ASTORE, exceptVar0);
//		mv.visitLabel(l5);
//		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
//		mv.visitInsn(Opcodes.ICONST_1);
//		mv.visitInsn(Opcodes.IRETURN);
		mv.visitVarInsn(Opcodes.ILOAD, testVar);
	}
		
		
if(1==0){
		Label l0 = new Label();
		Label l1 = new Label();
		Label l2 = new Label();
		mv.visitTryCatchBlock(l0/*start*/, l1/*end*/, l2/*handler*/, "java/io/FileNotFoundException");
		Label l3 = new Label();
		mv.visitTryCatchBlock(l0, l1, l3/*another handler*/, "java/io/IOException");
		Label l4 = new Label();
		mv.visitLabel(l4);
		mv.visitLineNumber(351, l4);
		mv.visitLdcInsn("MK_TEST.log");
		mv.visitVarInsn(Opcodes.ASTORE, logNameVar);
		Label l5 = new Label();
		mv.visitLabel(l5);
		mv.visitLineNumber(352, l5);
		mv.visitInsn(Opcodes.ICONST_1);
		mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE);
		mv.visitInsn(Opcodes.DUP);
		mv.visitInsn(Opcodes.ICONST_0);
		mv.visitInsn(Opcodes.ICONST_1);
		mv.visitInsn(Opcodes.BASTORE);
		mv.visitVarInsn(Opcodes.ASTORE, ba1Var);
		
		Label l6 = new Label();
		mv.visitLabel(l6);
		mv.visitLineNumber(353, l6);
		mv.visitInsn(Opcodes.ACONST_NULL);
		mv.visitVarInsn(Opcodes.ASTORE, outVar);
		
		mv.visitLabel(l0);//"TRY"
		mv.visitLineNumber(355, l0);
		mv.visitTypeInsn(Opcodes.NEW, "java/io/FileOutputStream");
		mv.visitInsn(Opcodes.DUP);
		mv.visitVarInsn(Opcodes.ALOAD, logNameVar);
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/io/FileOutputStream", "<init>", "(Ljava/lang/String;)V");
		mv.visitVarInsn(Opcodes.ASTORE, outVar);
		Label l7 = new Label();
		mv.visitLabel(l7);
		mv.visitLineNumber(356, l7);
		mv.visitVarInsn(Opcodes.ALOAD, outVar);
		mv.visitVarInsn(Opcodes.ALOAD, ba1Var);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
		Label l8 = new Label();
		mv.visitLabel(l8);
		mv.visitLineNumber(357, l8);
		mv.visitVarInsn(Opcodes.ALOAD, outVar);
		Label l9 = new Label();
		mv.visitJumpInsn(Opcodes.IFNULL, l9);
		Label l10 = new Label();
		mv.visitLabel(l10);
		mv.visitLineNumber(358, l10);
		mv.visitVarInsn(Opcodes.ALOAD, outVar);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileOutputStream", "close", "()V");
		mv.visitLabel(l1);
		mv.visitJumpInsn(Opcodes.GOTO, l9);//end of "TRY" -> jump to l9 if no exceptions
		
		mv.visitLabel(l2); //first exception block handler
		mv.visitLineNumber(360, l2);
		mv.visitVarInsn(Opcodes.ASTORE, exceptVar); //exception wegspeichern
		Label l11 = new Label();
		mv.visitLabel(l11);
		mv.visitLineNumber(361, l11);
		mv.visitVarInsn(Opcodes.ALOAD, exceptVar); //exception holen und stack drucken
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileNotFoundException", "printStackTrace", "()V");
		Label l12 = new Label();
		mv.visitLabel(l12);
		mv.visitJumpInsn(Opcodes.GOTO, l9); //nur eine exception, also nicht die n�chste
		
		mv.visitLabel(l3); //first exception block handler
		mv.visitLineNumber(362, l3);
		mv.visitVarInsn(Opcodes.ASTORE, exceptVar);
		Label l13 = new Label();
		mv.visitLabel(l13);
		mv.visitLineNumber(363, l13);
		mv.visitVarInsn(Opcodes.ALOAD, exceptVar);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/IOException", "printStackTrace", "()V");

		
		//hier fortfahren, falls keine Exception geworfen, bzw. nach deren Handling
		mv.visitLabel(l9);
		mv.visitLineNumber(365, l9);
		
//		mv.visitInsn(Opcodes.ACONST_NULL);//MK just added for testing
}
	}

	/**
	 * TODO: not implemented yet
	 */
	@SuppressWarnings("unused")
	private void insertDirectWritingToLogCalls_MaKro() {
		// Directly from ASMifier:
		
		Label l0 = new Label();
		Label l1 = new Label();
		Label l2 = new Label();
		mv.visitTryCatchBlock(l0, l1, l2, "java/io/FileNotFoundException");
		Label l3 = new Label();
		Label l4 = new Label();
		mv.visitTryCatchBlock(l0, l3, l4, "java/io/IOException");
		Label l5 = new Label();
		mv.visitLabel(l5);
		mv.visitLineNumber(234, l5);
		mv.visitLdcInsn("line.separator");
		mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "getProperty", "(Ljava/lang/String;)Ljava/lang/String;");
		mv.visitVarInsn(Opcodes.ASTORE, 1);
		Label l6 = new Label();
		mv.visitLabel(l6);
		mv.visitLineNumber(237, l6);
		mv.visitInsn(Opcodes.ACONST_NULL);
		mv.visitVarInsn(Opcodes.ASTORE, 2);
		mv.visitLabel(l0);
		mv.visitLineNumber(240, l0);
		mv.visitTypeInsn(Opcodes.NEW, "java/io/FileOutputStream");
		mv.visitInsn(Opcodes.DUP);
		mv.visitLdcInsn("ByCounter output + File.separatorChar + ByCounterResult_test.log");
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/io/FileOutputStream", "<init>", "(Ljava/lang/String;)V");
		mv.visitVarInsn(Opcodes.ASTORE, 2);
		Label l7 = new Label();
		mv.visitLabel(l7);
		mv.visitLineNumber(241, l7);
		mv.visitVarInsn(Opcodes.ALOAD, 2);
		Label l8 = new Label();
		mv.visitLabel(l8);
		mv.visitLineNumber(243, l8);
		mv.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
		mv.visitInsn(Opcodes.DUP);
		mv.visitLdcInsn("TimeStamp: ");
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
		
		mv.visitLdcInsn("lineSep");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		Label l9 = new Label();
		mv.visitLabel(l9);
		mv.visitLineNumber(242, l9);
		mv.visitLdcInsn("Qualifying methodname: ");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		
		mv.visitLdcInsn("lineSep");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		mv.visitLdcInsn("Opcode counts:");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		mv.visitLdcInsn("lineSep");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
		Label l10 = new Label();
		mv.visitLabel(l10);
		mv.visitLineNumber(241, l10);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
		Label l11 = new Label();
		mv.visitLabel(l11);
		mv.visitLineNumber(245, l11);
		mv.visitVarInsn(Opcodes.ALOAD, 2);
		Label l12 = new Label();
		mv.visitLabel(l12);
		mv.visitLineNumber(246, l12);
		mv.visitLdcInsn("OPCODE: 9lineSep");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
		Label l13 = new Label();
		mv.visitLabel(l13);
		mv.visitLineNumber(245, l13);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
		Label l14 = new Label();
		mv.visitLabel(l14);
		mv.visitLineNumber(247, l14);
		mv.visitVarInsn(Opcodes.ALOAD, 2);
		mv.visitLdcInsn("Method counts:lineSep");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
		Label l15 = new Label();
		mv.visitLabel(l15);
		mv.visitLineNumber(249, l15);
		mv.visitVarInsn(Opcodes.ALOAD, 2);
		Label l16 = new Label();
		mv.visitLabel(l16);
		mv.visitLineNumber(250, l16);
		mv.visitLdcInsn("SIGNATURE: 9lineSep");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
		Label l17 = new Label();
		mv.visitLabel(l17);
		mv.visitLineNumber(249, l17);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
		mv.visitLabel(l1);
		Label l18 = new Label();
		mv.visitJumpInsn(Opcodes.GOTO, l18);
		mv.visitLabel(l2);
		mv.visitLineNumber(251, l2);
		mv.visitFrame(Opcodes.F_FULL, 3, new Object[] {"de/uka/ipd/sdq/ByCounter/instrumentation/MethodCountMethodAdapter", "java/lang/String", "java/io/FileOutputStream"}, 1, new Object[] {"java/io/FileNotFoundException"});
		mv.visitVarInsn(Opcodes.ASTORE, 3);
		Label l19 = new Label();
		mv.visitLabel(l19);
		mv.visitLineNumber(252, l19);
		mv.visitVarInsn(Opcodes.ALOAD, 3);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileNotFoundException", "printStackTrace", "()V");
		mv.visitLabel(l18);
		mv.visitLineNumber(254, l18);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		mv.visitVarInsn(Opcodes.ALOAD, 2);
		Label l20 = new Label();
		mv.visitJumpInsn(Opcodes.IFNULL, l20);
		Label l21 = new Label();
		mv.visitLabel(l21);
		mv.visitLineNumber(255, l21);
		mv.visitVarInsn(Opcodes.ALOAD, 2);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/FileOutputStream", "close", "()V");
		mv.visitLabel(l3);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		mv.visitJumpInsn(Opcodes.GOTO, l20);
		mv.visitLabel(l4);
		mv.visitLineNumber(257, l4);
		mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {"java/io/IOException"});
		mv.visitVarInsn(Opcodes.ASTORE, 3);
		Label l22 = new Label();
		mv.visitLabel(l22);
		mv.visitLineNumber(258, l22);
		mv.visitVarInsn(Opcodes.ALOAD, 3);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/IOException", "printStackTrace", "()V");
		mv.visitLabel(l20);
		mv.visitLineNumber(408, l20);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		
		
		
		
		
		
		
		// modified from ASMifier:
			/*	
		String strFileOutputStream = "java/io/FileOutputStream";
		String strStringBuilder = "java/lang/StringBuilder";
		String strFileNotFoundException = "java/io/FileNotFoundException";
		
		int outVar = this.lvars.newLocal(Type.getObjectType(strFileOutputStream));
		int exceptVar = this.lvars.newLocal(Type.getObjectType(strFileNotFoundException));
		
		Label lStartTry = new Label();
		Label lEndTry1 = new Label();
		Label lCatch1 = new Label();
		mv.visitTryCatchBlock(lStartTry, lEndTry1, lCatch1, strFileNotFoundException);
//		Label lEndTry2 = new Label();
//		Label lCatch2 = new Label();
//		mv.visitTryCatchBlock(lStartTry, lEndTry2, lCatch2, null);
		Label lEndTry3 = new Label();
		Label lCatch3 = new Label();
		mv.visitTryCatchBlock(lStartTry, lEndTry3, lCatch3, "java/io/IOException");

		mv.visitInsn(Opcodes.ACONST_NULL);
		mv.visitVarInsn(Opcodes.ASTORE, outVar);
		mv.visitLabel(lStartTry);
		mv.visitTypeInsn(Opcodes.NEW, strFileOutputStream);
		mv.visitInsn(Opcodes.DUP);
		
		// Load name string for result file:
		if(this.instrumentationParameters.getResultLogFileName() == null
				|| this.instrumentationParameters.getResultLogFileName().length() < 1) {
			// provide a good default
			mv.visitLdcInsn("ByCounter output" + File.separatorChar 
					+ "results_" + System.currentTimeMillis() + "_"
					+ this.qualifyingMethodName	+ ".log");
		} else {
			// load user name
			mv.visitLdcInsn(this.instrumentationParameters.getResultLogFileName());
		}
		
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, strFileOutputStream, "<init>", "(Ljava/lang/String;)V");
		mv.visitVarInsn(Opcodes.ASTORE, outVar);*/
		/*mv.visitVarInsn(Opcodes.ALOAD, outVar);
		
		mv.visitTypeInsn(Opcodes.NEW, strStringBuilder);
		mv.visitInsn(Opcodes.DUP);
		mv.visitLdcInsn("TimeStamp: ");
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, strStringBuilder, "<init>", "(Ljava/lang/String;)V");

		mv.visitVarInsn(Opcodes.LLOAD, timeVar);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(J)Ljava/lang/StringBuilder;");
		mv.visitLdcInsn(lineSep);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");

		mv.visitLdcInsn("Qualifying methodname: ");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		
		mv.visitLdcInsn(this.qualifyingMethodName);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		mv.visitLdcInsn(lineSep);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		mv.visitLdcInsn("Opcode counts:");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		mv.visitLdcInsn(lineSep);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "toString", "()Ljava/lang/String;");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");

		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strFileOutputStream, "write", "([B)V");
		*//*
		// write count for every opcode:
		for(int opc = 0; opc < 256; opc++) {
			mv.visitVarInsn(Opcodes.ALOAD, outVar);				// load out
			mv.visitTypeInsn(Opcodes.NEW, strStringBuilder);	// create string buffer
			mv.visitInsn(Opcodes.DUP);
			mv.visitLdcInsn(ASMOpcodesMapper.getInstance().getOpcodeString(opc) + ": ");
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, strStringBuilder, "<init>", "(Ljava/lang/String;)V");
			mv.visitVarInsn(Opcodes.ILOAD, opcodeMap.get(opc));
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(I)Ljava/lang/StringBuilder;");
			mv.visitLdcInsn(lineSep);
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "toString", "()Ljava/lang/String;");
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
			
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strFileOutputStream, "write", "([B)V");
		}
		
		mv.visitVarInsn(Opcodes.ALOAD, outVar);
		mv.visitLdcInsn("Method counts:" + lineSep);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strFileOutputStream, "write", "([B)V");
		
		// write count for every method:
		for(String methodStr : methodMap.keySet()) {
			mv.visitVarInsn(Opcodes.ALOAD, outVar);
			mv.visitTypeInsn(Opcodes.NEW, strStringBuilder);
			mv.visitInsn(Opcodes.DUP);
			mv.visitLdcInsn(methodStr + ": ");
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, strStringBuilder, "<init>", "(Ljava/lang/String;)V");
			mv.visitVarInsn(Opcodes.ILOAD,  methodMap.get(methodStr));
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(I)Ljava/lang/StringBuilder;");
			mv.visitLdcInsn(lineSep);
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strStringBuilder, "toString", "()Ljava/lang/String;");
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
			
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strFileOutputStream, "write", "([B)V");
		}*/
/*		mv.visitLabel(lEndTry1);

		Label l20 = new Label();
		Label l22 = new Label();
		Label l26 = new Label();
		mv.visitJumpInsn(Opcodes.GOTO, l20);
		
		mv.visitLabel(lCatch1);
		mv.visitVarInsn(Opcodes.ASTORE, exceptVar);*/
//		mv.visitVarInsn(Opcodes.ALOAD, exceptVar);
//		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strFileNotFoundException, "printStackTrace", "()V");
		
/*		mv.visitLabel(lEndTry2);
		mv.visitVarInsn(Opcodes.ALOAD, outVar);
		mv.visitJumpInsn(Opcodes.IFNULL, l22);
//		mv.visitVarInsn(Opcodes.ALOAD, outVar);
//		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strFileOutputStream, "close", "()V");
		mv.visitJumpInsn(Opcodes.GOTO, l22);
		
		mv.visitLabel(lCatch2);
//		mv.visitVarInsn(Opcodes.ASTORE, exceptVar);
		mv.visitVarInsn(Opcodes.ALOAD, outVar);
		mv.visitJumpInsn(Opcodes.IFNULL, l26);
//		mv.visitVarInsn(Opcodes.ALOAD, outVar);
//		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strFileOutputStream, "close", "()V");
		
		mv.visitLabel(l26);
//		mv.visitVarInsn(Opcodes.ALOAD, exceptVar);
//		mv.visitInsn(Opcodes.ATHROW);
*/		
/*		mv.visitLabel(l20);
		mv.visitVarInsn(Opcodes.ALOAD, outVar);
		mv.visitJumpInsn(Opcodes.IFNULL, l22);
//		mv.visitVarInsn(Opcodes.ALOAD, outVar);
//		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strFileOutputStream, "close", "()V");
		mv.visitLabel(lEndTry3);
		mv.visitJumpInsn(Opcodes.GOTO, l22);
		
		mv.visitLabel(lCatch3);
		mv.visitVarInsn(Opcodes.ASTORE, exceptVar);
//		mv.visitVarInsn(Opcodes.ALOAD, exceptVar);
//		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/IOException", "printStackTrace", "()V");
		mv.visitLabel(l22);*/
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
		
		if(!instrumentationParameters.getUseResultCollector()){
			log.info("Instrumenting "+qualifyingMethodName+" without result collector: skipping getting ResultCollector instance");//TODO insert "hard disk writing"
			this.insertDirectWritingToLogCalls();
		} else { //FIXME
			log.info("Instrumenting "+qualifyingMethodName+" with result collector: skipping getting ResultCollector instance");//TODO insert "hard disk writing"
			//use ResultCollector
			this.mv.visitMethodInsn(Opcodes.INVOKESTATIC, 
					ResultCollectorCanonicalNameDescriptor, 
					"getInstance", 
					"()L"+ResultCollectorCanonicalNameDescriptor + ";");
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
			//in fact, ResultCollector.protocolCount(....) is static - no target ResultCollector instance is on the stack
			this.mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, 
				ResultCollectorCanonicalNameDescriptor, 
				"protocolCount", 
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
		
		// create a string stack to store all method calls
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
		if(isReturnStatement(opcode)) {	// no need to count return statements
			// method ends, so report the results
			insertResultCollectorCall();
		} else {
			countOpcode(opcode);
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
	
	@Override
	public void visitLdcInsn(Object constant) {
		countOpcode(18);	// 18 is LDC
		mv.visitLdcInsn(constant);
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
