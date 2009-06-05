package de.uka.ipd.sdq.ByCounter.execution;

import org.apache.log4j.Logger;

/**
 * Class to get class definitions from bytecode byte arrays. Uses the singleton pattern.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class BytecodeClassLoader extends ClassLoader {

	/**
	 * A singleton instance of this class
	 */
	private static BytecodeClassLoader singletonLoader = new BytecodeClassLoader();
	
	/**
	 * Gets a class definition from bytecode (given as array of bytes).
	 * @param className Name of the class.
	 * @param bytes Bytecode of the class.
	 * @return A <code>Class</code> instance object for the given class.
	 */
	@SuppressWarnings("unchecked")
	public static Class getClassFromBytes(String className, byte[] bytes) {
//		BytecodeClassLoader loader = new BytecodeClassLoader();//TODO make this class a singleton?
//		return loader.defineClass(className, bytes);
		return singletonLoader.defineClass(className, bytes);
	}
	
	/**
	 * A logger instance (log4j)
	 */
	private Logger log;
	
	/**
	 * Create a new classloader instance (with inside logger constuction).
	 */
	private BytecodeClassLoader() {
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
			return super.defineClass(name, b, 0, b.length);//TODO explain why "super";
		} catch (Exception e) {
			this.log.error(e);
			return null;
		}
	}
	
	/**Getting an instance of this class according to singleton pattern.
	 * @return an instance of this class, which is a singleton.
	 */
	public static BytecodeClassLoader getInstance(){
		if(singletonLoader==null){
			singletonLoader = new BytecodeClassLoader();
		}
		return singletonLoader;
	}
}
