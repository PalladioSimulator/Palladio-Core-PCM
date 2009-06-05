package de.uka.ipd.sdq.ByCounter.execution;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.instrumentation.Instrumenter;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * Use this class to trigger counting of instructions for your methods.
 * Bytecodes are counted accurate with the exception of certain special
 * versions of Opcodes, as described in the ASM Javadoc 
 * (http://asm.objectweb.org/asm30/javadoc/user/org/objectweb/asm/Opcodes.html):
 * "[..] some opcodes are automatically handled. For example, the xLOAD 
 * and xSTORE opcodes are automatically replaced by xLOAD_n and xSTORE_n 
 * opcodes when possible. The xLOAD_n and xSTORE_n opcodes are therefore 
 * not defined in this interface. Likewise for LDC, IINC, RET automatically 
 * replaced by LDC_W or LDC2_W when necessary, WIDE, GOTO_W and JSR_W."
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class BytecodeCounter {//TODO investigate whether slash-separated class names should be supported alongside "."-supported class names

	/**
	 * A logger instance (log4j)
	 */
	private static Logger log;
	
	/**
	 * A flag which is <code>true</code> if class to count was given as bytes
	 */
	private boolean classAsBytes;
	
	/**
	 * The class to count as byte array, if <code>classAsBytes</code> true
	 */
	private byte[] classBytesToInstrument; 
	
	/**
	 * The name of the class to count, if <code>classAsBytes</code> false
	 */
	private String classToInstrument;

	/**
	 * Parameters for instrumentation, can be set by the user
	 */
	private InstrumentationParameters instrumParams; // = new InstrumentationParameters();
	
	/**
	 * Setup a new BytecodeCounter.
	 * @param classToInstrument A byte array representing the class to instrument.
	 * @param className Fully qualified name of the given class (_needs_ to match the bytecode).
	 */
	public BytecodeCounter(byte[] classToInstrument, String className) {
		this.setClassToInstrument(classToInstrument, className);
		setupLog4J();
	}

	/**
	 * Setup a new BytecodeCounter.
	 * @param classToInstrument Fully qualified classname of the class to instrument, e.g. "bytecodeinstrumentation.Test".
	 */
	public BytecodeCounter(String classToInstrument) {
		this.setClassToInstrument(classToInstrument);
		setupLog4J();
	}
	
//	public BytecodeCounter(List<String> classesToInstrument, boolean allMethodsToInstrument){
//		this.setClassesToInstrument(classesToInstrument);
//		setupLog4J();
//	}

	/**
	 * Count all methods of the given class that take no arguments.
	 * To access the results use {@link CountingResultCollector.class CountingResultCollector}.
	 */
	@SuppressWarnings("unchecked")
	public void countAllMethodsWithoutParameters() { //TODO only called in a test... change modifier?
		
		try {
			// get a class object
			Class c = null;
			if(!classAsBytes) {
				c = ClassLoader.getSystemClassLoader().loadClass(
						this.classToInstrument);
			} else {
				c = BytecodeClassLoader.getClassFromBytes(
						this.classToInstrument, 
						this.classBytesToInstrument);
			}

			// select all methods that have zero parameters
			ArrayList<MethodDescriptor> methods = new ArrayList<MethodDescriptor>();
			for(Method m : c.getDeclaredMethods()) {
				if(m.getParameterTypes().length == 0) {
					methods.add(new MethodDescriptor(m));
				}
			}
			
			// create a list with empty parameters for all methods
			ArrayList<RuntimeMethodParameters> parameters 
						= new ArrayList<RuntimeMethodParameters>(methods.size());
			
			RuntimeMethodParameters params = new RuntimeMethodParameters();
			for(int i = 0; i < methods.size(); i++) {
				parameters.add(params);
			}
			
			// count the selected methods
			this.countMethods(methods, parameters);			
			
		} catch (ClassNotFoundException e) {
			log.error(e);
		}
	}

	/** TODO: replace through signature (not just the name) 
	 * Count the descriped method that takes no parameters.
	 * To access the results use {@link CountingResultCollector.class CountingResultCollector}.
	 * @param methodToInstrument Name of the method to count.
	 */
	public void countParameterlessMethod(
			MethodDescriptor methodToInstrument) {
		RuntimeMethodParameters rtParams = new RuntimeMethodParameters();

		// let the counter do its work
		this.countMethod(methodToInstrument, rtParams);
	}
	
	/**
	 * Count the bytecode of a method, but execute a (possibly) different one.
	 * To access the results use {@link CountingResultCollector.class CountingResultCollector}.
	 * @param methodToInstrument Name of the method to count.
	 * @param methodToExecute Name of the method to execute.
	 * @param params Parameters for the <b>executed</b> method.
	 */
	public void countMethod(
			MethodDescriptor methodToInstrument, 
			MethodDescriptor methodToExecute, 
			Object[] params) {
		int[] conversions = {};
		RuntimeMethodParameters rtParams = 
			new RuntimeMethodParameters(params, conversions);

		// let the counter do its work
		this.countMethod(methodToInstrument, methodToExecute, rtParams);
	}
	
	/**
	 * Count the descriped method and execute a (possibly) different one.
	 * To access the results use {@link CountingResultCollector.class CountingResultCollector}.
	 * @param methodToInstrument Name of the method to count.
	 * @param methodToExecute Name of the method to execute.
	 * @param params Parameters for the executed method.
	 */
	void countMethod( //TODO only called internally... changed modifier
			MethodDescriptor methodToInstrument,
			MethodDescriptor methodToExecute,
			RuntimeMethodParameters params) {

		// create simple one-element lists
		List<MethodDescriptor> methods = new ArrayList<MethodDescriptor>(1);
		methods.add(methodToInstrument);
		List<RuntimeMethodParameters> paramsList = new ArrayList<RuntimeMethodParameters>(1);
		paramsList.add(params);
		
		// count the method
		this.countMethods(methods, methodToExecute, paramsList);
	}
	
	/**
	 * Count the specified method.
	 * To access the results use {@link CountingResultCollector.class CountingResultCollector}.
	 * @param methodToInstrument Name of the method to instrument and to execute.
	 * @param params Parameters for the method call.
	 */
	public void countMethod(
			MethodDescriptor methodToInstrument, 
			Object[] params) {
		int[] conversions = {};
		RuntimeMethodParameters rtParams = new RuntimeMethodParameters(params, conversions);

		// let the counter do its work
		this.countMethod(methodToInstrument, rtParams);
	}
	
	
	/**
	 * Count the specified method.
	 * To access the results use {@link CountingResultCollector.class CountingResultCollector}.
	 * @param methodToInstrument Name of the method to count.
	 * @param params Parameters for the method call.
	 */
	void countMethod(
			MethodDescriptor methodToInstrument,
			RuntimeMethodParameters params) {

		this.countMethod(methodToInstrument, methodToInstrument, params);
	}

	
	/**
	 * Count the specified methods.
	 * To access the results use {@link CountingResultCollector.class CountingResultCollector}.
	 * @param methodsToInstrument List of the names of all methods to count.
	 * @param params Parameters for the method calls.
	 */
	public void countMethods(//TODO map this method to the following one? impossible, since just one method to execute in the other version of countMethods
			List<MethodDescriptor> methodsToInstrument, 
			List<RuntimeMethodParameters> params) {
		//TODO check that the parameters are of the same length as methods
		// create a class instance
		Object objInstance = null;	// class instance
		try {
			log.debug("STARTING creating instrumented class instance.");
			log.debug(">>> Creating instrumented class instance: " +
					"\n\t\t "+"methods to instrument: "+methodsToInstrument+
					"\n\t\t "+"methods to execute: "+methodsToInstrument+
					"\n\t\t "+"parameters: "+params);
			objInstance = getInstrumentedClass(methodsToInstrument).newInstance();
			log.debug("FINISHED creating instrumented class instance.");
//			log.debug("Object instance before " +
//					"reflective invocation of methods "+
//					methodsToInstrument.get(0)+", etc.: "+
//					/*objInstance.getClass().getPackage()+*/
//					objInstance.getClass().getName());
			
			// call the method
			MethodInvocationHelper.callMethods(
					log, 
					objInstance, 
					methodsToInstrument, 
					params);

		} catch (InstantiationException e1) {
			log.error(e1);
		} catch (IllegalAccessException e2) {
			log.error(e2);
		} catch (ClassNotFoundException e3) {
			log.error(e3);
		}
	}

	/**
	 * Count the specified methods.
	 * To access the results use {@link CountingResultCollector}.
	 * @param methodsToInstrument List of the names of all methods to count.
	 * @param methodToExecute A single method to execute.
	 * @param params Parameters for the method calls.
	 */
	@SuppressWarnings("unchecked")
	public void countMethods(
			List<MethodDescriptor> methodsToInstrument,
			MethodDescriptor methodToExecute,
			List<RuntimeMethodParameters> params) {

		// create a class instance
		Object objInstance = null;	// class instance
		try {
			log.debug(">>> Creating instrumented class instance: " +
					"\n\t\t "+"methods to instrument: "+methodsToInstrument+
					"\n\t\t "+"methods to execute: "+methodToExecute+
					"\n\t\t "+"parameters: "+params);
			Class instrClass = this.getInstrumentedClass(methodsToInstrument);
			objInstance = instrClass.newInstance();
			log.debug("FINISHED creating instrumented class instance.");
//			log.debug("Object instance before " +
//					"reflective invocation of methods "+
//					methodsToInstrument.get(0)+", etc.: "+
//					/*objInstance.getClass().getPackage()+*/
//					objInstance.getClass().getName());
			
			// call the method
			List<MethodDescriptor> methodsToCall = new ArrayList<MethodDescriptor>(1);
			methodsToCall.add(methodToExecute);
			MethodInvocationHelper.callMethods(log, objInstance, methodsToCall, params);

		} catch (InstantiationException e1) {
			e1.printStackTrace();
			log.error(e1);
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
			log.error(e2);
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
			log.error(e3);
		}
	}

	/**
	 * Returns the current instrumentation parameters. Use this to change 
	 * the way the instrumenter works. Note that the methods to count 
	 * will be overriden by the count* methods.
	 * @return the instrumentation parameters. 
	 */
	public InstrumentationParameters getInstrumentationParams() {
		return instrumParams;
	}

	/**
	 * Gets a Class object that represents the class given by className where  
	 * the specified methods have been instrumented to provide instruction
	 * statistics.
	 * @param className Class to instrument
	 * @param methodsToInstrument A list of all method names for methods that need to be instrumented. 
	 * @return Class with instumented methods.
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	private Class getInstrumentedClass(List<MethodDescriptor> methodsToInstrument) 
		throws ClassNotFoundException {
		
		// instrument the method
		Instrumenter instr = null;
		// make sure parameters are set
		instrumParams.setMethodsToInstrument(methodsToInstrument);
		log.debug(instrumParams);
		
		if(classAsBytes) {
			log.debug("Getting instrumenter over class bytes");
			instr = new Instrumenter(this.classBytesToInstrument, instrumParams);
		} else {
			log.debug("Getting instrumenter over class name");
			instr = new Instrumenter(this.classToInstrument, instrumParams);
		}
		long uninstrBytesize = instr.getUninstrumentedBytesize();
		log.info("A TracingCharacterisationHook registration used to be here..."); //TODO reinstate instr.registerCharacterisationHook(new TracingCharacterisationHook());
		
		log.debug("Getting instrumented bytes");
		byte[] b = instr.getInstrumentedBytes();
		long instrBytesize = b.length;
		
//		if(1==1){//TODO
//			FileOutputStream fos;
//			try {
//				fos = new FileOutputStream("MK_TEST.class");
//				fos.write(b);
//				fos.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		// Load the class from the bytecode
		log.debug("Getting class from bytes " +
				"\n\t\t("+instrBytesize+" instrumented, " +
				""+uninstrBytesize+" uninstrumented)");
		return BytecodeClassLoader.getClassFromBytes(instr.getClassName().replace('/', '.'), b);
	}

	/**
	 * Specifies (changes) the class to instrument.
	 * @param classToInstrument A byte array representing the class to instrument.
	 * @param className Name of the given class (_needs_ to match the bytecode).//TODO full name?
	 */
	private void setClassToInstrument(byte[] classToInstrument, String className) {
		this.classBytesToInstrument = classToInstrument;
		this.classToInstrument = className;
//		if(className.contains("/")) {
//			log.debug("CONTAINS");
//		}
		this.classAsBytes = true;
	}

	/**
	 * Specifies (changes) the class to instrument.
	 * @param classToInstrument Qualified classname of the class to instrument, 
	 * e.g. "mypackage.Test" (i.e., without the ".class" extension)
	 */
	private void setClassToInstrument(String classToInstrument) {
		this.classToInstrument = classToInstrument;
		this.classAsBytes = false;
	}

	/**
	 * Sets the parameters for instrumentation.
	 * @param params An {@link InstrumentationParameters} object with
	 * all properties for instrumentation set.
	 */
	public void setInstrumentationParams(InstrumentationParameters params) {
		if(params != null) {
			this.instrumParams = params;
		}		
	}

	/**
	 * Sets up logging by reading "log4j.properties". TODO add error handling
	 */
	private void setupLog4J() {
		// setup log4j
		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}
}
