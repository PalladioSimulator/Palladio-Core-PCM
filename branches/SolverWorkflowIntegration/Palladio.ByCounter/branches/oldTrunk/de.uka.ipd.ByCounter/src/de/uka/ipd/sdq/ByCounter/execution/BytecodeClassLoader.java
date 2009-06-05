package de.uka.ipd.sdq.ByCounter.execution;

import org.apache.log4j.Logger;

/**
 * Class to get class definitions from bytecode byte arrays.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.1
 */
public class BytecodeClassLoader extends ClassLoader {

	/**
	 * Gets a class definition from bytecode.
	 * @param className Name of the class.
	 * @param bytes Bytecode of the class.
	 * @return A class object for the given class.
	 */
	@SuppressWarnings("unchecked")
	public static Class getClassFromBytes(String className, byte[] bytes) {
		BytecodeClassLoader loader = new BytecodeClassLoader();
		return loader.defineClass(className, bytes);
	}
	
	private Logger log;
	
	/**
	 * Create a new classloader instance (logger constuction).
	 */
	public BytecodeClassLoader() {
		this.log = Logger.getLogger(this.getClass().getCanonicalName());
	}
	
	/**
	 * Get class definition from the given bytes.
	 * @param name Class name - make sure this matches the bytecode!
	 * @param b Bytecode representing the class.
	 * @return A <code>class</code> as represented by the bytecode.
	 */
	@SuppressWarnings("unchecked")
	public Class defineClass(String name, byte[] b) {
		try {
			return super.defineClass(name, b, 0, b.length);
		} catch (Exception e) {
			this.log.error(e);
			return null;
		}
	}
}
