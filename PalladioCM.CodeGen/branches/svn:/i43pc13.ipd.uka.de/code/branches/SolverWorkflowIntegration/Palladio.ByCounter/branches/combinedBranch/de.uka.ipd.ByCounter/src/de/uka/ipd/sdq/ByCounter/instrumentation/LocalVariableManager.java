/**
 * 
 */
package de.uka.ipd.sdq.ByCounter.instrumentation;

import org.apache.log4j.Logger;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.LocalVariablesSorter;

/**
 * Class for managing the indices for local variables in bytecode.
 * For all getNew* methods, the outcome depends on the setting of 
 * getUseHighRegisters().
 * @author Martin Krogmann
 *
 */
public class LocalVariableManager {
	private static final int MAX_LOCALS = 65535;	// maximum number of locals in a method
	private static final Logger log = Logger.getLogger(LocalVariableManager.class);
	private int nextRegisterOffset;		// remembered in the class instance for the next allocation;
	private LocalVariablesSorter lvars = null;
	
	/**
	 * When true, use register numbers near the MAX_LOCALS constant.
	 */
	private boolean useHighRegisters;

	public LocalVariableManager(boolean useHighRegisters) {
		this.useHighRegisters = useHighRegisters;
		this.nextRegisterOffset = 2;
	}

	/**
	 * @return True when register numbers near the MAX_LOCALS constant are used.
	 * False otherwise.
	 */
	public boolean getUseHighRegisters() {
		return useHighRegisters;
	}

	/**
	 * 
	 * @param useHighRegisters When true, use register numbers near the MAX_LOCALS constant.
	 */
	public void setUseHighRegisters(boolean useHighRegisters) {
		this.useHighRegisters = useHighRegisters;
	}

	/**
	 * Register a new variable of type 'type'.
	 * Do not use unless a more specialised method does not exist (yet).
	 * @param readableDescr A readable description of the type. Used for debugging purposes only.
	 * @param mv The {@link MethodVisitor} to use for inserting initialisation instructions.
	 * @param type The type of the new local.
	 * @param localVarSize The number of local variables that the var blocks. This is 1 for int, 2 for long, 1 for Object etc.
	 * @return The variable index/identifier.
	 */
	public int getNewVarFor(String readableDescr, MethodVisitor mv,
			Type type, int localVarSize) {
		log.trace("nextRegisterOffset: "+this.nextRegisterOffset);
		int var = -1;
		if(getUseHighRegisters()) {
			var = MAX_LOCALS - nextRegisterOffset;
			nextRegisterOffset += localVarSize;	// update pointer for next register
		} else {
			var = this.lvars.newLocal(type);
		}
		log.trace("Registered new "+readableDescr+"@localvar "+var);
		log.trace("nextRegisterOffset: "+this.nextRegisterOffset);
		return var;
	}

	/**
	 * Register a new long and initialize it with 0.
	 * @param mv The {@link MethodVisitor} to use for inserting initialisation instructions.
	 * @return The variable index/identifier.
	 */
	@SuppressWarnings("boxing")
	public int getNewLongVar(MethodVisitor mv) {
		log.trace("nextRegisterOffset: "+this.nextRegisterOffset);
		mv.visitLdcInsn(0L);	// initialise with 0
		int var = this.getNewVarFor("LONG", mv, Type.LONG_TYPE, 2);
		mv.visitVarInsn(Opcodes.LSTORE, var);
		return var;
	}
	
	/**
	 * Register a new int and initialize it with 0.
	 * @param mv The {@link MethodVisitor} to use for inserting initialisation instructions.
	 * @return The variable index/identifier.
	 */
	@SuppressWarnings("boxing")
	public int getNewIntVar(MethodVisitor mv) {
		log.trace("nextRegisterOffset: "+this.nextRegisterOffset);
		mv.visitLdcInsn(0);	// initialise with 0
		int var = this.getNewVarFor("INT", mv, Type.INT_TYPE, 1);
		mv.visitVarInsn(Opcodes.ISTORE, var);
		return var;
	}
	
	/**
	 * Register a new int[]. Does not initialize it.
	 * @param mv The {@link MethodVisitor} to use for inserting initialisation instructions.
	 * @return The variable index/identifier.
	 */
	public int getNewIntArrayVar(MethodVisitor mv) {
		return this.getNewVarFor("INT[]", mv, Type.getObjectType("[I"), 1);
	}

	/**
	 * Register a new long[]. Does not initialize it.
	 * @param mv The {@link MethodVisitor} to use for inserting initialisation instructions.
	 * @return The variable index/identifier.
	 */
	public int getNewLongArrayVar(MethodVisitor mv) {
		return this.getNewVarFor("LONG[]", mv, Type.getObjectType("[J"), 1);
	}
	
	/**
	 * Register a new String[]. Does not initialize it.
	 * @param mv The {@link MethodVisitor} to use for inserting initialisation instructions.
	 * @return The variable index/identifier.
	 */
	public int getNewStringArrayVar(MethodVisitor mv) {
		return this.getNewVarFor("String[]", mv, Type.getObjectType("[Ljava/lang/String;"), 1);
	}

	/**
	 * Sets the LocalVariableSorter that is used to generate new locals.
	 * This must be called before this Manager is used.
	 * @param lvars LocalVariableSorter
	 */
	public void setLVS(LocalVariablesSorter pLvars) {
		this.lvars = pLvars;
	}
	
}
