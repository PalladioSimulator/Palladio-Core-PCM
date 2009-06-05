package de.uka.ipd.sdq.ByCounter.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javassist.ByteArrayClassPath;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.Loader;
import javassist.NotFoundException;

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
 * To instrument methods of classes, call instrument.
 * To execute instrumented code, call execute.
 * To access the results use {@link CountingResultCollector}.
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
	 * A flag which is <code>true</code> if class to count was given as bytes.
	 */
	private boolean classAsBytes;
	
	/**
	 * The class to count as byte array, if <code>classAsBytes</code> is true.
	 * This is null otherwise.
	 */
	private byte[] classBytesToInstrument; 
	
	/**
	 * The name of the class to count, if <code>classAsBytes</code> is false.
	 * This is null otherwise.
	 */
	private String classToInstrument;

	/**
	 * Parameters for instrumentation, can be set by the user
	 */
	private InstrumentationParameters instrumParams = new InstrumentationParameters();
		
	/**
	 * An array of bytes representing the instrumented class once 
	 * instrument() was called.
	 */
	private byte[] instrumentedClassBytes;
	
	/**
	 * The Javassist {@link ClassPool} used to replace classes that were 
	 * modified using ByCounter.
	 */
	private ClassPool classPool;
	
	/**
	 * Setup a new BytecodeCounter.
	 */
	public BytecodeCounter() {
		this.classPool = ClassPool.getDefault();
		setupLog4J();
	}
	
	/**
	 * This undoes the call of setClassToInstrument() and returns
	 * BytecodeCounter into it's standard instrumentation mode.
	 */
	public void clearClassFileToInstrument() {
		this.classAsBytes = false;
		this.classBytesToInstrument = null;
	}

	/**
	 * Instrument the methods specified in the 
	 * {@link InstrumentationParameters} of this BytecodeCounter.
	 * The {@link InstrumentationParameters} can be accessed using 
	 * get- or setInstrumentationParameters().
	 * Make sure you set the methodsToInstrument or this call will fail with 
	 * an error.
	 * @return True, if the instrumentation was successful, false otherwise.
	 */
	public boolean instrument() {
		List<MethodDescriptor> methodsToInstrument = this.instrumParams.getMethodsToInstrument();
		if(methodsToInstrument == null) {
			log.error("Trying to instrument but no method(s) to instrument were specified.");
		}
		return this.instrument(methodsToInstrument);
	}
	
	/**
	 * Instrument the specified methods with bycounter instructions for 
	 * counting, reporting etc. Note that all methods in the given list
	 * have to be definined on the same class for one call of instrument!
	 * @param methodsToInstrument A {@link List} of {@link MethodDescriptor}s 
	 * where each MethodDescriptor represent a method that will be 
	 * instrumented.
	 * @return True, if the instrumentation was successful, false otherwise.
	 */
	public boolean instrument(List<MethodDescriptor> methodsToInstrument) {

		// check the supplied list
		if(methodsToInstrument == null) {
			log.error("methodsToInstrument is null; no methods to instrument");
			return false;
		}
		// set the instrumentationParameters to match
		this.instrumParams.setMethodsToInstrument(methodsToInstrument);
		
		log.debug(">>> Instrumenting methods: " +
				"\n\t\t "+"methods to instrument: "+methodsToInstrument);

		this.setClassToInstrument(methodsToInstrument.get(0).getCanonicalClassName());
		// instrument the method
		Instrumenter instr = null;
		// make sure parameters are set
		instrumParams.setMethodsToInstrument(methodsToInstrument);
		log.debug(instrumParams);
		
		boolean success = false;

		try {
			if(classAsBytes) {
				log.debug("Getting instrumenter over class bytes");
				instr = new Instrumenter(this.classBytesToInstrument, instrumParams);
			} else {
				log.debug("Getting instrumenter over class name");
				instr = new Instrumenter(this.classToInstrument, instrumParams);
			}
			long uninstrBytesize = instr.getUninstrumentedBytesize();
			log.info("A TracingCharacterisationHook registration used to be here..."); //TODO reinstate instr.registerCharacterisationHook(new TracingCharacterisationHook());
			
			log.debug("Instrumenting now");
			success = instr.instrument();
			
			if(success == false) {
				log.error("Not all specified methods could be instrumented.");
			}
			log.debug("Getting instrumented bytes");
			byte[] b = instr.getInstrumentedBytes();
			long instrBytesize = b.length;
			
			this.instrumentedClassBytes = b;

			// write classes to disk ('bin_instrumented') 
			// if specified in the instrumentation parameters
			if(this.instrumParams.getWriteClassesToDisk()) {
				for(int i = 0; i < methodsToInstrument.size(); i++) {
					writeClassFile(methodsToInstrument.get(i).getPackageName(),
							methodsToInstrument.get(i).getSimpleClassName(), b);
				}
			}

			log.debug("\n\t\t("+instrBytesize+" instrumented, " +
					""+uninstrBytesize+" uninstrumented)");
 
			log.debug("Updating class pool");
			updateClassInClassPool(this.classToInstrument, b);
		} catch (ClassNotFoundException e3) {
			log.error("Could not find the specified class");
		}
		return success;
	}
	
	/**
	 * Instrument the specified method with ByCounter instructions for 
	 * counting, reporting etc.
	 * @param methodToInstrument A {@link MethodDescriptor} representing 
	 * the method to instrument.
	 */
	public void instrument(MethodDescriptor methodToInstrument) {
		ArrayList<MethodDescriptor> methodDescriptors = new ArrayList<MethodDescriptor>(1);
		methodDescriptors.add(methodToInstrument);
		this.instrument(methodDescriptors);
	}

	/**
	 * Execute the method specified by methodToExecute using the given parameters.
	 * @param methodToExecute A {@link MethodDescriptor} describing the 
	 * specific method that shall be executed.
	 * @param params Parameters as an array of Objects that are 
	 * used to execute the method specified by methodToExecute. Use an empty 
	 * array for methods that take no parameters. 
	 */
	public void execute(MethodDescriptor methodToExecute, Object[] params) {
		int[] conversions = {};
		RuntimeMethodParameters rtParams = new RuntimeMethodParameters(params, conversions);
		this.execute(methodToExecute, rtParams);
	}

	/**
	 * Execute the method specified by methodToExecute using the given parameters.
	 * @param methodToExecute A {@link MethodDescriptor} describing the 
	 * specific method that shall be executed.
	 * @param params Parameters as {@link RuntimeMethodParameters} that are 
	 * used to execute the method specified by methodToExecute. Use the 
	 * default constructor of {@link RuntimeMethodParameters} for methods 
	 * that take no parameters. 
	 */
	public void execute(MethodDescriptor methodToExecute,
			RuntimeMethodParameters params) {

		log.debug(">>> Creating instrumented class instance: " +
				"\n\t\t "+"methods to execute: "+methodToExecute+
				"\n\t\t "+"parameters: "+params);


		// create a class instance
		Object objInstance = null;	// class instance
		try {
			// Load the class from the bytecode
			log.debug("Getting class from class pool.");
			Class<?> classToExecute = null;
			CtClass ctClassToExecute = null;
			// get the CtClass from the pool
			ctClassToExecute = this.classPool.get(methodToExecute.getCanonicalClassName());
			Loader loader = new Loader(this.classPool);
			// make sure that the CountingResultCollector (important!) and all other 
			// ByCounter classes do not get reloaded.
			loader.delegateLoadingOf("de.uka.ipd.sdq.ByCounter.execution.");
			// use the ClassLoader loader to get the Class<?> object
			// use a standard protection domain
			classToExecute = ctClassToExecute.toClass(loader, 
					BytecodeCounter.class.getProtectionDomain());

			// instantiate the class; this only works for Classes without 
			// constructors or parameterless constructors
			objInstance = classToExecute.newInstance();
			log.debug("FINISHED creating instrumented class instance.");
			if(methodToExecute != null) {
				log.info(">>> Executing method on instrumented class instance");
				// call the method
				List<MethodDescriptor> methodsToCall = new ArrayList<MethodDescriptor>(1);
				methodsToCall.add(methodToExecute);
				List<RuntimeMethodParameters> methodCallParams = new ArrayList<RuntimeMethodParameters>(1);
				methodCallParams.add(params);
				MethodInvocationHelper.callMethods(log, objInstance, methodsToCall, methodCallParams);
			} else {
				log.error("No method to execute.");
			}
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the current instrumentation parameters. Use this to change 
	 * the way the instrumenter works. Note that the methods to count 
	 * will be overridden by the count* methods.
	 * @return the instrumentation parameters. 
	 */
	public InstrumentationParameters getInstrumentationParams() {
		return instrumParams;
	}

	/**
	 * Gets a byte[] representing a {@link Class} of the type specified by the 
	 * className attribute of the first MethodDescriptor supplied to instrument(..) 
	 * The class is modified in such a way that the methods specified by 
	 * methodsToInstrument (again see instrument(..)) have been instrumented 
	 * by ByCounter.
	 * This makes the assumption that the class for all methods is the same. 
	 * @return Class as byte[] with instrumented methods if the instrumentation 
	 * succeeded. 'null' otherwise.
	 */
	public byte[] getInstrumentedBytes() {
		if(this.instrumentedClassBytes == null) {
			log.error("Could not get the instrumented class as bytes. "
					+ "Please make sure to call BytecodeCounter.instrument(..).");
		}
		return this.instrumentedClassBytes;
	}

	/**
		 * Updates the class definition for the class given by className
		 * and bytes by adding it to the Javassist {@link ClassPool}.
		 * @param className Fully qualified name of the given class.
		 * @param bytes Byte array representing the class.
		 */
		private void updateClassInClassPool(String className, byte[] bytes) {
			if(className == null || className.length() == 0) {
				log.error("Cannot update class pool because the given classname "
						+ "was null or invalid.");
				return;
			} else if(bytes == null) {
				log.error("Cannot update class pool as the given byte[] for the class"
						+ "was null.");
				return;
			}
			// make the class known to the classpool
			classPool.insertClassPath(new ByteArrayClassPath(className, bytes));
		}

	/**
	 * Writes .class file given as byte[].
	 * @param packageName Package name of the class.
	 * @param className Simple classname used to determine where to save the class.
	 * @param b Class as byte[] to write.
	 */
	private void writeClassFile(String packageName, String className, byte[] b) {
		FileOutputStream fileOut = null;
		try {
			try {
				String classPath = packageName.replace('.', File.separatorChar);
				String path = ("bin_instrumented" + File.separatorChar + classPath
						+ File.separatorChar);
				File directory = new File (path);
				// make sure the directories exist
				if(!directory.exists() && !directory.mkdirs()) {
					log.error("Could not create directory for instrumented class files.");
				} else {
					fileOut = new FileOutputStream(new File(directory, className + ".class"));				
					fileOut.write(b);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fileOut != null) {
					fileOut.close();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Specifies (changes) the class to instrument to be the class specified 
	 * as the byte array.
	 * <p>
	 * To stop using the here specified class and use the standard 
	 * instrumentation mode again, call clearClassFileToInstrument().
	 * </p>
	 * @param classToInstrument A byte array representing the class to instrument.
	 */
	public void setClassToInstrument(byte[] classToInstrument) {
		this.classBytesToInstrument = classToInstrument;
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
