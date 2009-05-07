package de.uka.ipd.sdq.ByCounter.instrumentation;


import java.util.Iterator;

import org.apache.log4j.Logger;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;

/**
 * MethodPreInstrumentationParser implements a quick method visiting pass for 
 * finding method invocations and array constructions. 
 * The knowledge obtained from this pass can be used to count method invocations 
 * more efficiently using simple int counters and 'iinc' instructions, 
 * or using 'long'-based counters with higher capacity. 
 * In addition to that, array type and dimension information can be obtained.
 * @author Martin Krogmann
 *
 */
public class MethodPreInstrumentationParser extends MethodAdapter {
	
	/**
	 * Constructs a method signature that accounts for the object the method 
	 * is invoked on.
	 * @param owner The object that the method is invoked on.
	 * @param name The methods name.
	 * @param desc The methods signature.
	 * @return The method signature that was constructed.
	 */
	public static String constructObjectMethodSignature(
			String owner, 
			String name,
			String desc) {
		return owner + "." + name + desc;
	}
	
	private AdditionalOpcodeInformation additionalOpcInfo;
	private InstrumentationParameters instrumentationParameters;
	private CountingMethodAdapter methodCountMethodAdapter;
	private MethodVisitor nextVisitor;
	private Logger log;
	
	/**
	 * {@inheritDoc}
	 * @param access As from ClassVisitor.
	 * @param name As from ClassVisitor.
	 * @param desc As from ClassVisitor.
	 * @param methodCountMethodAdapter MethodCountMethodAdapter that needs the method
	 * @param parameters Parameters for instrumentation. Also contains information that decides what is done before instrumetation.
	 * invocation information for proper instrumentation.
	 */
	public MethodPreInstrumentationParser(
			MethodVisitor mv,
			int access, 
			String name,
			String desc, 
			CountingMethodAdapter methodCountMethodAdapter,
			InstrumentationParameters parameters) {
		super(new MethodNode(access, name, desc, null, null));
		this.log = Logger.getLogger(this.getClass().getCanonicalName());
		this.additionalOpcInfo = new AdditionalOpcodeInformation();
		this.instrumentationParameters = parameters;
		this.methodCountMethodAdapter = methodCountMethodAdapter;
		this.nextVisitor = mv;
		log.debug("initialised with instrumentation parameters "+instrumentationParameters);
	}

	/**
	 * Get the list containing all method signatures that were called in the 
	 * visited method.
	 * @return A map containing method signatures as keys in the form 
	 * <code>owner + "." + name + desc</code>. Signatures are specific to 
	 * the object they are invoked on. This means that a certain methods 
	 * may be more than once in the array. However, their signatures differ, 
	 * as the owner property differs.
	 * @see constructObjectMethodSignature
	 */
	public AdditionalOpcodeInformation getAdditionalOpcodeInformation() {
		return additionalOpcInfo;
	}

	/**
	 * Visiting the end of the method allows to collect the needed method 
	 * invocation information.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void visitEnd() {
		// Initialize registers for all appearing method invocations
		MethodNode mn = (MethodNode) mv;

		for (	Iterator<AbstractInsnNode> iterator = mn.instructions.iterator(); 
				iterator.hasNext();
				/*NOP*/
			) {
			AbstractInsnNode insn = iterator.next();
			if(insn instanceof MethodInsnNode) {
				// gather signature for the method invocation
				MethodInsnNode method = ((MethodInsnNode)insn);
				String sig = constructObjectMethodSignature(method.owner, 
						method.name, method.desc);
				if(additionalOpcInfo.getMethodInvokations().contains(sig)) {
					log.debug("Method "+sig+" already known");
				}else{
					log.debug("Method "+sig+" will be added");
					additionalOpcInfo.getMethodInvokations().add(sig);
				}
			} else if(instrumentationParameters.getUseArrayParameterRecording() 
					&& insn instanceof IntInsnNode 
					&& insn.getOpcode() == Opcodes.NEWARRAY) {
				// get the type integer for the newarray call
				IntInsnNode node = ((IntInsnNode)insn);
				// since the integer contains the type, duplicates are not wanted.
				int info = additionalOpcInfo.getIndexOfAdditionInformation(
						node.operand, 
						AdditionalOpcodeInformation.NO_INFORMATION_STRING);
				if(info == -1) {// add the entry
					log.debug("NEWARRAY with operand "+node.operand+" will be added");
					additionalOpcInfo.addAdditionalInformation(node.operand,
							AdditionalOpcodeInformation.NO_INFORMATION_STRING);
				}else{
					log.debug("NEWARRAY with operand "+node.operand+" already exists");
				}
			} else if(instrumentationParameters.getUseArrayParameterRecording() 
					&& insn instanceof TypeInsnNode 
					&& insn.getOpcode() == Opcodes.ANEWARRAY) {
				// get the type string for the anewarray call
				TypeInsnNode node = ((TypeInsnNode)insn);
				int info = additionalOpcInfo.getIndexOfAdditionInformation(
						AdditionalOpcodeInformation.NO_INFORMATION_INT, 
						node.desc);
				if(info == -1) {
					log.debug("ANEWARRAY of type "+node.desc+" will be added");
					additionalOpcInfo.addAdditionalInformation(
							AdditionalOpcodeInformation.NO_INFORMATION_INT,
							node.desc);
				}else{
					log.debug("ANEWARRAY of type "+node.desc+" already existed");
				}
			} else if(instrumentationParameters.getUseArrayParameterRecording() 
					&& insn instanceof MultiANewArrayInsnNode) {
				// get the type string and dimension integer
				MultiANewArrayInsnNode node = ((MultiANewArrayInsnNode)insn);
				int info = additionalOpcInfo.getIndexOfAdditionInformation(
						node.dims, 
						node.desc);
				if(info == -1) {
					log.debug("MULTIANEWARRAY of dimension "+node.dims+" and desc "+node.desc+" will be added");
					additionalOpcInfo.addAdditionalInformation(
							node.dims,
							node.desc);
				}else{
					log.debug("MULTIANEWARRAY of dimension "+node.dims+" and desc "+node.desc+" already existed");
				}
			}
		}
		if(this.methodCountMethodAdapter == null) {
			log.error("MethodCountMethodAdapter was not set for MethodPreInstrumentationVisitor.");
		} else {
			this.methodCountMethodAdapter.setMethodInvocations(additionalOpcInfo);
		}
		log.debug("accepting next visitor: "+nextVisitor);
		mn.accept(nextVisitor);
		log.debug("finished accepting next visitor: "+nextVisitor);
	}

}
