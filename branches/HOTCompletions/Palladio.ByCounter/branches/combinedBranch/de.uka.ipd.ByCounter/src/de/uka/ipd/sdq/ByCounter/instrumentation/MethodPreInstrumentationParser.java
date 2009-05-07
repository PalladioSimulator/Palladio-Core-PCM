package de.uka.ipd.sdq.ByCounter.instrumentation;


import java.util.Iterator;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;

/**
 * MethodPreInstrumentationParser implements a quick method visiting pass for 
 * finding method invocations and array constructions. The knowledge obtained 
 * from this pass can be used to count method invocations more efficiently 
 * using simple int counters and 'iinc' instructions. In addition to that, 
 * array type and dimension information can be obtained.
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
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
	
	private AdditionalOpcodeInformation additionalOpcInfo = null;
	
	private boolean countOnlySection;		// when true, only a section of the method needs to be counted
	
	private boolean inCountSection;			// when countOnlySection is true, this holds the state of the visitor: true means count here.
	
	private InstrumentationParameters instrumentationParameters;
	
	private MethodCountMethodAdapter methodCountMethodAdapter;
	
	private MethodVisitor nextVisitor;
	
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
			MethodCountMethodAdapter methodCountMethodAdapter,
			InstrumentationParameters parameters) {
		super(new MethodNode(access, name, desc, null, null));
		this.nextVisitor = mv;
		this.additionalOpcInfo = new AdditionalOpcodeInformation();
		this.methodCountMethodAdapter = methodCountMethodAdapter;
		this.instrumentationParameters = parameters;
		if(instrumentationParameters.getStartLine() < 0) {
			this.countOnlySection = false;
			this.inCountSection = false;
		} else {
			this.countOnlySection = true;
		}
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
			) {
			AbstractInsnNode insn = iterator.next();
			
			if(countOnlySection && insn instanceof LineNumberNode) {
				int l = ((LineNumberNode)insn).line;
				if(l < instrumentationParameters.getStartLine() 
						|| l > instrumentationParameters.getStopLine()) {
					inCountSection = false;
				} else {
					inCountSection = true;
				}
			} else if (!countOnlySection || inCountSection) {
				if(insn instanceof MethodInsnNode) {
					// gather signature for the method invocation
					MethodInsnNode method = ((MethodInsnNode)insn);
					String sig = constructObjectMethodSignature(method.owner, 
							method.name, method.desc);
					if(!additionalOpcInfo.getMethodInvokations().contains(sig)) {
						additionalOpcInfo.getMethodInvokations().add(sig);
					}
				} else if(instrumentationParameters.getUseArrayParameterRecording() 
						&& insn instanceof IntInsnNode 
						&& insn.getOpcode() == Opcodes.NEWARRAY) {
					// get the type integer for the newarray call
					IntInsnNode node = ((IntInsnNode)insn);
					// since the integer contains the type, duplicates are not wanted.
					if(additionalOpcInfo.getIndexOfAdditionInformation(
							node.operand, 
							AdditionalOpcodeInformation.NO_INFORMATION_STRING) == -1) {
						// add the entry
						additionalOpcInfo.addAdditionalInformation(node.operand,
								AdditionalOpcodeInformation.NO_INFORMATION_STRING);
					}
				} else if(instrumentationParameters.getUseArrayParameterRecording() 
						&& insn instanceof TypeInsnNode 
						&& insn.getOpcode() == Opcodes.ANEWARRAY) {
					// get the type string for the anewarray call
					TypeInsnNode node = ((TypeInsnNode)insn);
					if(additionalOpcInfo.getIndexOfAdditionInformation(
							AdditionalOpcodeInformation.NO_INFORMATION_INT, 
							node.desc) == -1) {
						additionalOpcInfo.addAdditionalInformation(
								AdditionalOpcodeInformation.NO_INFORMATION_INT,
								node.desc);
					}
				} else if(instrumentationParameters.getUseArrayParameterRecording() 
						&& insn instanceof MultiANewArrayInsnNode) {
					// get the type string and dimension integer
					MultiANewArrayInsnNode node = ((MultiANewArrayInsnNode)insn);
					if(additionalOpcInfo.getIndexOfAdditionInformation(
							node.dims, 
							node.desc) == -1) {
						additionalOpcInfo.addAdditionalInformation(
								node.dims,
								node.desc);
					}
				}
			}
		}
		this.methodCountMethodAdapter.setMethodInvocations(additionalOpcInfo);

		mn.accept(nextVisitor);
	}

}
