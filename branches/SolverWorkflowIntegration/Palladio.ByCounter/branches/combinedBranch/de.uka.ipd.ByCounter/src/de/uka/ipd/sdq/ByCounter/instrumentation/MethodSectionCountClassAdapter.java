package de.uka.ipd.sdq.ByCounter.instrumentation;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;

/**
 * Visitor for the class declaration.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
@Deprecated // Static is counting not supported
public class MethodSectionCountClassAdapter extends ClassAdapter {

	private String className;
	
	private InstrumentationParameters instrumentationParameters;
	
	/**
	 * Create a new MethodSectionCountClassAdapter.
	 * @param visitor The preceding visitor in the chain.
	 * @param methodsToInstrument Name of the method that shall be instrumented.
	 * @param startLine first line in source file to count
	 * @param endLine last line in source file to count
	 */
	public MethodSectionCountClassAdapter(
			ClassVisitor visitor, 
			InstrumentationParameters params) {
		super(visitor);
		this.instrumentationParameters = params;
	}

	/**
	 * Visits the header of the class and grabs the classname.
	 */
	@Override
	public void visit(int version, int access, String name, String signature, String supername, String[] interfaces) {
		super.visit(version, access, name, signature, supername, interfaces);
		this.className = name.replace('/', '.');
	}

	/**
	 * This is called when a method declaration happens in the class
	 */
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor nextVisitor = null;
		MethodVisitor mv = null;
		
		// call other classvisitors in the chain:
		mv = cv.visitMethod(access, name, desc, signature, exceptions);
		
		if (mv != null) {
			if (instrumentationParameters.getIndexOfMethodMatch(name, desc) >= 0) {
				// this is the method to instrument
				mv = new MethodSectionCountMethodAdapter(name, access, 
						className + "." + name, desc, mv, instrumentationParameters);
				nextVisitor = mv;
			} else {
				// this is not the right method: use default visitor
				nextVisitor = new MethodAdapter(mv);
			}
		}
		return nextVisitor;
	}
}
