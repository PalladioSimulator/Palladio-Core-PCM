package de.uka.ipd.sdq.ByCounter.instrumentation;

import java.util.HashMap;
import java.util.Iterator;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.MethodNode;

import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;

/** TODO
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class MethodSectionCountMethodAdapter extends MethodAdapter {
	
	private InstrumentationParameters instrumentationParameters;
	
	private MethodVisitor nextVisitor;
	
	@SuppressWarnings("unused")
	private HashMap<Integer, Integer> opcodeMap; //TODO never used locally?
	
	private String owner;

	/** TODO
	 * @param owner
	 * @param access
	 * @param name
	 * @param desc
	 * @param mv
	 */
	public MethodSectionCountMethodAdapter(
			String owner, 
			int access, 
			String name,
			String desc, 
			MethodVisitor mv, 
			InstrumentationParameters params) {
		super(new MethodNode(access, name, desc, null, null));

		opcodeMap = new HashMap<Integer, Integer>();
		this.instrumentationParameters = params;
		
		this.owner = owner;
		this.nextVisitor = mv;

	}
	
	@SuppressWarnings({ "unchecked", "boxing" })
	@Override
	public void visitEnd() {
		MethodNode mn = (MethodNode) mv;

		int count;
		boolean inCountSection = true;
		HashMap<Integer, Integer> opcodeCounts = new HashMap<Integer, Integer>();
		
		for (	Iterator<AbstractInsnNode> iterator = mn.instructions.iterator(); 
				iterator.hasNext();
			) {
			AbstractInsnNode insn = iterator.next();
			if(insn instanceof LineNumberNode) {
				int l = ((LineNumberNode)insn).line;
				if(l < instrumentationParameters.getStartLine() 
						|| l > instrumentationParameters.getStopLine()) {
					inCountSection = false;
				} else {
					//log.info("Line " + l);
				}
			} else if (inCountSection) {
				// log.info("Opcode: " + DisplayOpcodes.instance().getOpcodeString(insn.getOpcode()));
				if(opcodeCounts.containsKey(insn.getOpcode()))
					count = opcodeCounts.get(insn.getOpcode());
				else
					count = 0;
				opcodeCounts.put(insn.getOpcode(), count + 1);
			}
			
		}
		int[] opcodeCountsArray = new int[opcodeCounts.size()];
		for(int i : opcodeCounts.keySet()) {
			opcodeCountsArray[i] = opcodeCounts.get(i);
		}
		CountingResultCollector.getInstance().protocolCount(0, owner, opcodeCountsArray, null, null, null, null, null);

		mn.accept(nextVisitor);
	}
}
