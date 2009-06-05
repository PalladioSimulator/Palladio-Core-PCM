package de.uka.ipd.sdq.ByCounter.instrumentation;

import org.apache.log4j.Logger;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.LocalVariablesSorter;

import de.uka.ipd.sdq.ByCounter.MethodDescriptor;


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
 * @version 0.1
 */
public class MethodCountClassAdapter extends ClassAdapter {
	
	// have a static log for the class to use
	private static Logger log = 
		Logger.getLogger(MethodDescriptor.class.getClass().getCanonicalName());

	private String className;
	private InstrumentationParameters instrumentationParameters;
	private CountingMethodAdapter methodCountMethodAdapter;
	
	/**
	 * Create a new MethodCountAdapter.
	 * @param visitor The preceding visitor in the chain.
	 */
	public MethodCountClassAdapter(
			ClassVisitor visitor, InstrumentationParameters parameters) {
		super(visitor);
		this.instrumentationParameters = parameters;
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
	 * This is called when a method declaration happens in the class.
	 */
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor nextVisitor = null;
		MethodVisitor mv = null;
		
		// call other classvisitors in the chain:
		// The actual call order is visitors at the bottom call the visitor //TODO what does it mean "in the bottom"?
		// over them. (bottom to top order)
		mv = this.cv.visitMethod(access, name, desc, signature, exceptions);
		
		if (mv != null) {
			if (instrumentationParameters.doMethodsMatch(name, desc)) {
				// this is the method to instrument
				this.methodCountMethodAdapter = new CountingMethodAdapter(
						mv, 
						this.className + "." + name, 
						instrumentationParameters);
				mv = this.methodCountMethodAdapter; 

				nextVisitor = new LocalVariablesSorter(access, desc, mv);
				if(!instrumentationParameters.getUseHighRegistersForCounting()) {
					((CountingMethodAdapter)methodCountMethodAdapter)
						.setLVS((LocalVariablesSorter)nextVisitor);
				}
				nextVisitor = new MethodPreInstrumentationParser(nextVisitor, access, 
						name, desc, methodCountMethodAdapter, instrumentationParameters);
			} else {
				// this is not a method that has to be instrumented: use default visitor
				nextVisitor = new MethodAdapter(mv);
			}
		} else {
			log.error("The method visitor found in the chain was null.");
		}

		return nextVisitor;
	}
}
