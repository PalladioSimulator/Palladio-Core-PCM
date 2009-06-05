package de.uka.ipd.sdq.ByCounter.instrumentation;

import static org.objectweb.asm.Opcodes.AALOAD;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACONST_NULL;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARRAYLENGTH;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IALOAD;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.IFNULL;
import static org.objectweb.asm.Opcodes.IF_ICMPLT;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.ISTORE;
import static org.objectweb.asm.Opcodes.LLOAD;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.RETURN;

import java.io.FileOutputStream;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.LocalVariablesSorter;

import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;

/**
 * This is the visitor for the class declaration. It watches each 
 * method declaration and selects the methods which have to be 
 * instrumented as specified in the instrumentation parameters.
 * For those methods, the MethodCountMethodAdapter is activated.
 * @see MethodCountMethodAdapter
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class MethodCountClassAdapter extends ClassAdapter {
	
	// have a static log for the class to use
	private Logger log = 
		Logger.getLogger(this.getClass().getCanonicalName());

	/**
	 * This is java code for direct writing to a log that 
	 * serves as a template for the bytecode that is inserted 
	 * by the call to <code>insertDirectWritingToLogCalls()</code>.
	 */
	@SuppressWarnings("unused")
	private static void directWritingToLogTemplate(
			long time, 
			String qualifyingMethodName, 
			int[] opcodeCounts, 
			int[] methodCallCounts,
			String[] calledMethods,
			int[] newArrayCounts,
			int[] newArrayTypeOrDim,
			String[] newArrayDescr) {

		String lineSep = System.getProperty("line.separator");
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("instrumentationParameters.getResultLogFileName()");
			out.write(("Timestamp: " + time + lineSep
				+ "Qualifying methodname: " + qualifyingMethodName + lineSep
				+ "Opcode counts:" + lineSep).getBytes());

			for(int i = 0; i < opcodeCounts.length; i++) {
				out.write((ASMOpcodesMapper.getInstance().getOpcodeString(i)
					+ ": " + opcodeCounts[i] + lineSep).getBytes());
			}
			out.write(("Method counts:" + lineSep).getBytes());
			for(int i = 0; i < methodCallCounts.length; i++) {
				out.write((calledMethods[i]
					+ ": " + methodCallCounts[i] + lineSep).getBytes());
			}
			if(newArrayCounts != null 
					&& newArrayTypeOrDim != null) {
				out.write(("Array constructions:" + lineSep).getBytes());
				for(int i = 0; i < newArrayCounts.length; i++) {
					// TODO: improve output readability
					out.write(("type/dimension: '" + newArrayDescr[i]
							+ "'/" + newArrayTypeOrDim[i] + " "
							+ "count: " + newArrayCounts[i]
							+ lineSep).getBytes());
				}
			}
			if (out != null)	out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * TODO
	 */
	private HashSet<ICharacterisationHook> characterisationHooks;
	
	/**
	 * TODO
	 */
	private String className;
	
	/**
	 * TODO
	 */
	private InstrumentationParameters instrumentationParameters;

	/**
	 * TODO
	 */
	private MethodCountMethodAdapter methodCountMethodAdapter;
	
	/**
	 * Holds the original value for the resultLogFileName when result collector is NOT used.
	 */
	private String resultLogFileNameTemplate;

	/**
	 * Create a new MethodCountAdapter.
	 * @param visitor The preceding visitor in the chain.
	 */
	public MethodCountClassAdapter(
			ClassVisitor visitor, InstrumentationParameters parameters) {
		super(visitor);
		this.instrumentationParameters = parameters;
		this.characterisationHooks = new HashSet<ICharacterisationHook>();
		
		if(! instrumentationParameters.getUseResultCollector()) {
			this.resultLogFileNameTemplate = 
				instrumentationParameters.getResultLogFileName();
		}
	}

	/**
	 * Constructs the filename for the result log by replacing the 
	 * template strings.
	 * @see InstrumentationParameters.setResultLogFileName()
	 * @param methodName The method name of the 
	 * method that is currently being instrumented.
	 * @param methodDescriptor The descriptor for the method. 
	 * @return The resulting file name string.
	 */
	private String constructResultLogFileName(
			String methodName,
			String methodDescriptor) {
		String result = resultLogFileNameTemplate;
		result = result.replaceAll("\\{\\$TIME\\}", "" + System.currentTimeMillis());
		result = result.replaceAll("\\{\\$CLASSNAME\\}", "" + this.className);
		result = result.replaceAll("\\{\\$METHODNAME\\}", methodName);
		result = result.replaceAll("\\{\\$METHODDESC\\}", methodDescriptor.replaceAll("/", "."));
		return result;
	}

	/**
	 * Register a {@link ICharacterisationHook}.
	 * @see ICharacterisationHook
	 * @param hook
	 */
	public void registerCharacterisationHook(ICharacterisationHook hook) {
		this.characterisationHooks.add(hook);
	}

	/**
	 * Visits the header of the class and grabs the classname.
	 * This is being called from other class visitors in the chain for 
	 * classes that get passed to the Instrumenter.
	 * The classname attribute is important as it serves for describing 
	 * the output in logs or files in order to associate counts to the 
	 * correct classes/methods.
	 * {@inheritDoc}
	 * @see Instrumenter
	 */
	@Override 
	public void visit(int version, int access, String name, String signature, String supername, String[] interfaces) {
		super.visit(version, access, name, signature, supername, interfaces);
		this.className = name.replace('/', '.');
	}
	

	/**
	 * Overridden to insert a result log writing method.
	 * @see org.objectweb.asm.ClassAdapter#visitEnd()
	 */
	@Override
	public void visitEnd() {
		// When the result collector is used, nothing needs to be done
		if(instrumentationParameters.getUseResultCollector()) {
			cv.visitEnd();
			return;
		}
		
		// Result collector is not used: add a method for direct result log writing
		
		// the methods signature
		String strDescr = "(JLjava/lang/String;[I[I[Ljava/lang/String;[I[I[Ljava/lang/String;)V";
		
		// make the method private + static and use an uncommon name to avoid collisions with an already existing method
		MethodVisitor mv = 
			cv.visitMethod(ACC_PRIVATE + ACC_STATIC,
					"___directWritingToLog___", 
					strDescr, null, null);
		
		if (mv != null) {
			// here follows the code as converted from directWritingToLogTemplate:
			mv.visitCode();
			Label l0 = new Label();
			Label l1 = new Label();
			Label l2 = new Label();
			mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
			Label l3 = new Label();
			mv.visitLabel(l3);
			mv.visitLdcInsn("line.separator");
			mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "getProperty", "(Ljava/lang/String;)Ljava/lang/String;");
			mv.visitVarInsn(ASTORE, 9);
			Label l4 = new Label();
			mv.visitLabel(l4);
			mv.visitInsn(ACONST_NULL);
			mv.visitVarInsn(ASTORE, 10);
			mv.visitLabel(l0);
			mv.visitTypeInsn(NEW, "java/io/FileOutputStream");
			mv.visitInsn(DUP);
			mv.visitLdcInsn(instrumentationParameters.getResultLogFileName());
			mv.visitMethodInsn(INVOKESPECIAL, "java/io/FileOutputStream", "<init>", "(Ljava/lang/String;)V");
			mv.visitVarInsn(ASTORE, 10);
			Label l5 = new Label();
			mv.visitLabel(l5);
			mv.visitVarInsn(ALOAD, 10);
			Label l6 = new Label();
			mv.visitLabel(l6);
			mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
			mv.visitInsn(DUP);
			mv.visitLdcInsn("Timestamp: ");
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
			mv.visitVarInsn(LLOAD, 0);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 9);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			Label l7 = new Label();
			mv.visitLabel(l7);
			mv.visitLdcInsn("Qualifying methodname: ");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 2);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 9);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitLdcInsn("Opcode counts:");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 9);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
			Label l8 = new Label();
			mv.visitLabel(l8);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
			Label l9 = new Label();
			mv.visitLabel(l9);
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ISTORE, 11);
			Label l10 = new Label();
			mv.visitLabel(l10);
			Label l11 = new Label();
			mv.visitJumpInsn(GOTO, l11);
			Label l12 = new Label();
			mv.visitLabel(l12);
			mv.visitVarInsn(ALOAD, 10);
			Label l13 = new Label();
			mv.visitLabel(l13);
			mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESTATIC, "de/uka/ipd/sdq/ByCounter/utils/ASMOpcodesMapper", "getInstance", "()Lde/uka/ipd/sdq/ByCounter/utils/ASMOpcodesMapper;");
			mv.visitVarInsn(ILOAD, 11);
			mv.visitMethodInsn(INVOKEVIRTUAL, "de/uka/ipd/sdq/ByCounter/utils/ASMOpcodesMapper", "getOpcodeString", "(I)Ljava/lang/String;");
			mv.visitMethodInsn(INVOKESTATIC, "java/lang/String", "valueOf", "(Ljava/lang/Object;)Ljava/lang/String;");
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
			mv.visitLdcInsn(": ");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 3);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitInsn(IALOAD);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 9);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
			Label l14 = new Label();
			mv.visitLabel(l14);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
			Label l15 = new Label();
			mv.visitLabel(l15);
			mv.visitIincInsn(11, 1);
			mv.visitLabel(l11);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitVarInsn(ALOAD, 3);
			mv.visitInsn(ARRAYLENGTH);
			mv.visitJumpInsn(IF_ICMPLT, l12);
			Label l16 = new Label();
			mv.visitLabel(l16);
			mv.visitVarInsn(ALOAD, 10);
			mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
			mv.visitInsn(DUP);
			mv.visitLdcInsn("Method counts:");
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
			mv.visitVarInsn(ALOAD, 9);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
			Label l17 = new Label();
			mv.visitLabel(l17);
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ISTORE, 11);
			Label l18 = new Label();
			mv.visitLabel(l18);
			Label l19 = new Label();
			mv.visitJumpInsn(GOTO, l19);
			Label l20 = new Label();
			mv.visitLabel(l20);
			mv.visitVarInsn(ALOAD, 10);
			Label l21 = new Label();
			mv.visitLabel(l21);
			mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
			mv.visitInsn(DUP);
			mv.visitVarInsn(ALOAD, 5);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitInsn(AALOAD);
			mv.visitMethodInsn(INVOKESTATIC, "java/lang/String", "valueOf", "(Ljava/lang/Object;)Ljava/lang/String;");
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
			mv.visitLdcInsn(": ");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 4);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitInsn(IALOAD);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 9);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
			Label l22 = new Label();
			mv.visitLabel(l22);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
			Label l23 = new Label();
			mv.visitLabel(l23);
			mv.visitIincInsn(11, 1);
			mv.visitLabel(l19);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitVarInsn(ALOAD, 4);
			mv.visitInsn(ARRAYLENGTH);
			mv.visitJumpInsn(IF_ICMPLT, l20);
			Label l24 = new Label();
			mv.visitLabel(l24);
			mv.visitVarInsn(ALOAD, 6);
			Label l25 = new Label();
			mv.visitJumpInsn(IFNULL, l25);
			Label l26 = new Label();
			mv.visitLabel(l26);
			mv.visitVarInsn(ALOAD, 7);
			mv.visitJumpInsn(IFNULL, l25);
			Label l27 = new Label();
			mv.visitLabel(l27);
			mv.visitVarInsn(ALOAD, 10);
			mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
			mv.visitInsn(DUP);
			mv.visitLdcInsn("Array constructions:");
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
			mv.visitVarInsn(ALOAD, 9);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
			Label l28 = new Label();
			mv.visitLabel(l28);
			mv.visitInsn(ICONST_0);
			mv.visitVarInsn(ISTORE, 11);
			Label l29 = new Label();
			mv.visitLabel(l29);
			Label l30 = new Label();
			mv.visitJumpInsn(GOTO, l30);
			Label l31 = new Label();
			mv.visitLabel(l31);
			mv.visitVarInsn(ALOAD, 10);
			Label l32 = new Label();
			mv.visitLabel(l32);
			mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
			mv.visitInsn(DUP);
			mv.visitLdcInsn("type/dimension: '");
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
			mv.visitVarInsn(ALOAD, 8);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitInsn(AALOAD);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			Label l33 = new Label();
			mv.visitLabel(l33);
			mv.visitLdcInsn("'/");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 7);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitInsn(IALOAD);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
			mv.visitLdcInsn(" ");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitLdcInsn("count: ");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 6);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitInsn(IALOAD);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
			mv.visitVarInsn(ALOAD, 9);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B");
			Label l34 = new Label();
			mv.visitLabel(l34);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/FileOutputStream", "write", "([B)V");
			Label l35 = new Label();
			mv.visitLabel(l35);
			mv.visitIincInsn(11, 1);
			mv.visitLabel(l30);
			mv.visitVarInsn(ILOAD, 11);
			mv.visitVarInsn(ALOAD, 6);
			mv.visitInsn(ARRAYLENGTH);
			mv.visitJumpInsn(IF_ICMPLT, l31);
			mv.visitLabel(l25);
			mv.visitVarInsn(ALOAD, 10);
			Label l36 = new Label();
			mv.visitJumpInsn(IFNULL, l36);
			mv.visitVarInsn(ALOAD, 10);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/FileOutputStream", "close", "()V");
			mv.visitLabel(l1);
			mv.visitJumpInsn(GOTO, l36);
			mv.visitLabel(l2);
			mv.visitVarInsn(ASTORE, 11);
			Label l37 = new Label();
			mv.visitLabel(l37);
			mv.visitVarInsn(ALOAD, 11);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Exception", "printStackTrace", "()V");
			mv.visitLabel(l36);
			mv.visitInsn(RETURN);
			Label l38 = new Label();
			mv.visitLabel(l38);
			mv.visitLocalVariable("time", "J", null, l3, l38, 0);
			mv.visitLocalVariable("qualifyingMethodName", "Ljava/lang/String;", null, l3, l38, 2);
			mv.visitLocalVariable("opcodeCounts", "[I", null, l3, l38, 3);
			mv.visitLocalVariable("methodCallCounts", "[I", null, l3, l38, 4);
			mv.visitLocalVariable("calledMethods", "[Ljava/lang/String;", null, l3, l38, 5);
			mv.visitLocalVariable("newArrayCounts", "[I", null, l3, l38, 6);
			mv.visitLocalVariable("newArrayTypeOrDim", "[I", null, l3, l38, 7);
			mv.visitLocalVariable("newArrayDescr", "[Ljava/lang/String;", null, l3, l38, 8);
			mv.visitLocalVariable("lineSep", "Ljava/lang/String;", null, l4, l38, 9);
			mv.visitLocalVariable("out", "Ljava/io/FileOutputStream;", null, l0, l38, 10);
			mv.visitLocalVariable("i", "I", null, l10, l16, 11);
			mv.visitLocalVariable("i", "I", null, l18, l24, 11);
			mv.visitLocalVariable("i", "I", null, l29, l25, 11);
			mv.visitLocalVariable("e", "Ljava/lang/Exception;", null, l37, l36, 11);
			mv.visitMaxs(5, 12);
			mv.visitEnd();

		} else {
			log.error("Could not visit method: " + "directWritingToLog");
		}
		
		cv.visitEnd();
	}

	/**
	 * This is called when a method declaration happens in the class.
	 */
	@Override
	public MethodVisitor visitMethod(
			int access, 
			String name, 
			String desc, 
			String signature, 
			String[] exceptions) {
		MethodVisitor nextVisitor = null;
		MethodVisitor mv = null;
		
		
		// call other classvisitors in the chain:
		// The actual call order is visitors at the bottom call the visitor
		// over them. (bottom to top order)
		mv = this.cv.visitMethod(access, name, desc, signature, exceptions);
		
		if (mv != null) {
			if (instrumentationParameters.doMethodsMatch(name, desc)) {

				String qualifyingMethodName = this.className + "." + name;
				
				if(instrumentationParameters.getUseResultCollector() == false) {
					String result = constructResultLogFileName(name, desc);
					instrumentationParameters.setResultLogFileName(result);
				}
				
				// this is the method to instrument
				this.methodCountMethodAdapter = new MethodCountMethodAdapter(
						mv, 
						qualifyingMethodName, 
						instrumentationParameters);
				mv = this.methodCountMethodAdapter;
				
				// call the methodStart hooks
				for(ICharacterisationHook hooks : characterisationHooks) {
					hooks.methodStartHook(methodCountMethodAdapter, instrumentationParameters, access, name, 
							desc, signature, exceptions);
				}
				// register hooks for method adapter
			    for(ICharacterisationHook hook : characterisationHooks) {
					methodCountMethodAdapter.registerCharacterisationHook(hook);
				}				

				nextVisitor = new LocalVariablesSorter(access, desc, mv);
				((MethodCountMethodAdapter)mv).setLVS((LocalVariablesSorter)nextVisitor);
				nextVisitor = new MethodPreInstrumentationParser(nextVisitor, access, 
						name, desc, methodCountMethodAdapter, instrumentationParameters);
			} else {
				// this is not the right method: use default visitor
				nextVisitor = new MethodAdapter(mv);
			}
		} else {
			log.error("The method visitor found in the chain was null.");
		}

		return nextVisitor;
	}
}
