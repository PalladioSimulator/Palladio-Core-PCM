package de.uka.ipd.sdq.ByCounter.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 * 
 * Bytecode instructions are counted accurately with the exception of 
 * certain special versions of opcodes, as described in the ASM JavaDoc 
 * (http://asm.objectweb.org/asm30/javadoc/user/org/objectweb/asm/Opcodes.html):
 * "[..] some opcodes are automatically handled. For example, the xLOAD 
 * and xSTORE opcodes are automatically replaced by xLOAD_n and xSTORE_n 
 * opcodes when possible. The xLOAD_n and xSTORE_n opcodes are therefore 
 * not defined in this interface. Likewise for LDC, IINC, RET automatically 
 * replaced by LDC_W or LDC2_W when necessary, WIDE, GOTO_W and JSR_W."
 * 
 * To instrument methods of classes, call instrument(...).
 * To execute instrumented code, call execute(...).
 * To access the results use {@link CountingResultCollector} singleton.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 1.1
 * TODO investigate whether slash-separated class names should be supported alongside "."-supported class names
 */
@SuppressWarnings("deprecation")
public class BytecodeCounter {

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
	 * When a method is instrumented by ByCounter, the class that holds the 
	 * method is changed. So if the unchanged class has been loaded by a 
	 * {@link ClassLoader}, we need to make sure that the instrumented version
	 * of the class is used. 
	 * This Javassist {@link ClassPool} holds the instrumented classes that 
	 * are then used instead of their unmodified versions.
	 */
	private ClassPool classPool;

	/**
	 * The name of the class to count, if <code>classAsBytes</code> is false.
	 * This is null otherwise.
	 */
	private String classToInstrument;
		
	/**
	 * An array of bytes representing the instrumented class once 
	 * instrument() was called.
	 */
	private byte[] instrumentedClassBytes;
	
	/**
	 * Parameters for instrumentation, can be set by the user
	 */
	private InstrumentationParameters instrumParams = new InstrumentationParameters();
	
	/**
	 * Parameters for class construction that are needed when execute is called 
	 * on a class with no default constructor.
	 * Index is in sync with constructionDescriptors.
	 */
	private ArrayList<Object[]> constructionParameters = 
		new ArrayList<Object[]>();
	/**
	 * Descriptors for the constructors that correspond to the 
	 * constructionParameters.
	 * Index is in sync with constructionParameters.
	 */
	private ArrayList<MethodDescriptor> constructionDescriptors = 
		new ArrayList<MethodDescriptor>();
	
	/**
	 * Setup a new BytecodeCounter.
	 */
	public BytecodeCounter() {
		this.classPool = ClassPool.getDefault();
		setupLog4J();
	}
	
	/**
	 * This undoes the call of setClassToInstrument() and returns
	 * BytecodeCounter into its standard instrumentation mode.
	 */
	public void clearClassFileToInstrument() {
		this.classAsBytes = false;
		this.classBytesToInstrument = null;
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
			// avoid log4j class inconsistencies (caused an error in example.ByCounterExample)
			loader.delegateLoadingOf("org.apache.log4j.");
			// use the ClassLoader loader to get the Class<?> object
			// use a standard protection domain
			classToExecute = ctClassToExecute.toClass(
					loader, 
					BytecodeCounter.class.getProtectionDomain()
					);
			
			// look for constructors for the class
			for(MethodDescriptor constD : constructionDescriptors) {
				if (constD.getCanonicalClassName().equals(methodToExecute.getCanonicalClassName())) {
					// we found a matching constructor
					// now use the parameters to construct the instance
					Constructor<?>[] constructors = classToExecute.getDeclaredConstructors();
					for(int i = 0; i < constructors.length; i++ ) {
						Constructor<?> c = constructors[i];
						if((new MethodDescriptor(c)).getDescriptor().equals(constD.getDescriptor())) {
							try {
								objInstance = c.newInstance(this.constructionParameters.get(i));
							} catch (Exception e) {
								log.error("Could not call constructor with the given arguments.");
								e.printStackTrace();
								return;
							}
							break;
						}
					}
					break;
				}
			}

			// instantiate the class; this only works for Classes without 
			// constructors or parameterless constructors
			if(objInstance == null) {
				try{
					objInstance = classToExecute.newInstance();
				} catch (InstantiationException e) {
					log.error("Could not instantiate class. Please make sure that "
							+ "valid construction parameters are available.");
					e.printStackTrace();
					return;
				} catch (IllegalAccessException e2) {
					e2.printStackTrace();
					return;
				}
			}
			log.debug("FINISHED creating instrumented class instance.");
			if(methodToExecute != null) {
				log.info(">>> Executing method on instrumented class instance");
				// call the method
				List<MethodDescriptor> methodsToCall = new ArrayList<MethodDescriptor>(1);
				methodsToCall.add(methodToExecute);
				List<RuntimeMethodParameters> methodCallParams = new ArrayList<RuntimeMethodParameters>(1);
				methodCallParams.add(params);
				if(objInstance==null) log.error("objInstance is null");
				MethodInvocationHelper.callMethods(
						log, 
						objInstance, 
						methodsToCall, 
						methodCallParams);
			} else {
				log.error("No method to execute.");
			}
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
			//TODO explain/correct: if instrumentedClassBytes==null: why not call instrument automatically?
		}
		return this.instrumentedClassBytes;
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
	 * Instrument the specified methods with ByCounter instructions for 
	 * counting, reporting etc.
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
		
		log.debug("Instrumenting following methods: " + methodsToInstrument);
		
		// create a set of class names to instrument
		Set<String> classesToInstrument = new HashSet<String>();
		for(int i = 0; i < methodsToInstrument.size(); i++) {
			// the add operation of set ensures that there are no duplicates
			classesToInstrument.add(
					methodsToInstrument.get(i).getCanonicalClassName());
		}

		boolean success = true;
		// iterate through all selected classes
		for(String className : classesToInstrument) {
			success = instrumentSingleClass(methodsToInstrument, className) && success;
		}
		return success;
	}


	/**
	 * Instrument the specified methods with ByCounter instructions for 
	 * counting, reporting etc.
	 * @param methodsToInstrument A {@link List} of {@link MethodDescriptor}s 
	 * where each MethodDescriptor represent a method that will be 
	 * instrumented.
	 * @param className Name of the (single) class for which all methods shall
	 * be instrumented.
	 * @return True, if the instrumentation was successful, false otherwise.
	 */
	private boolean instrumentSingleClass(
			List<MethodDescriptor> methodsToInstrument, 
			String className) {
		this.setClassToInstrument(className);
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
//			long uninstrBytesize = instr.getUninstrumentedBytesize();
			log.info("A TracingCharacterisationHook " +
					"registration used to be here..."); 
			//TODO reinstate instr.registerCharacterisationHook(new TracingCharacterisationHook());
			
			log.debug("Instrumenting "+methodsToInstrument.size()+" methods in class "+className);
			success = instr.instrument();
			
			if(success == false) {
				log.error("Not all specified methods could be instrumented.");
			}
			log.debug("Getting instrumented bytes");
			byte[] b = instr.getInstrumentedBytes();
//			long instrBytesize = b.length;
			
			this.instrumentedClassBytes = b;

			// write classes to disk ('bin_instrumented') 
			// if specified in the instrumentation parameters
			if(this.instrumParams.getWriteClassesToDisk()) {
				for(int i = 0; i < methodsToInstrument.size(); i++) {
					writeClassFile(methodsToInstrument.get(i).getPackageName(),
							methodsToInstrument.get(i).getSimpleClassName(), b);
				}
			}//TODO else

//			TODO fix the error with uninstrumented bytesize (as well as the problem the re-outputting uninstrumented bytes yields a non-executable something, i.e. not a class at all
//			log.debug("\n\t\t("+instrBytesize+" instrumented, " +
//					""+uninstrBytesize+" uninstrumented)");
 
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
	 * @param classToInstrument Qualified class name of the class to instrument, 
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
		}else{
			log.error("Instrumentation parameters are null, not accepted");
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
			// make the class known to the class pool
			classPool.insertClassPath(new ByteArrayClassPath(className, bytes));
		}

	/**
	 * Writes .class file given as byte[].
	 * @param packageName Package name of the class.
	 * @param className Simple class name used to determine where to save the class.
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
	 * Parameters for class construction are needed when execute is called 
	 * on a class with no default constructor.
	 * Use this method to supply these construction parameters.
	 * @param constructor A {@link MethodDescriptor} for the constructor that 
	 * shall be used for a following execute() call on the same class.
	 * Use MethodDescriptor.forConstructor() to describe constructors.
	 * @param parameters
	 */
	public void setConstructionParameters(MethodDescriptor constructor,
			Object[] parameters) {
		assert this.constructionDescriptors.size() == this.constructionParameters.size();
		if(constructor == null) {
			log.error("setConstructionParameters: You need to supply a MethodDescriptor that is not null!");
			return;
		}
		if(parameters == null || parameters.length == 0) {
			log.error("setConstructionParameters: You need to supply a parameters!");
			return;
		}
		this.constructionDescriptors.add(constructor);
		this.constructionParameters.add(parameters);
	}
	
	/**
	 * Removes all construction parameters passed by calling 
	 * setConstructionParameters(..);.
	 * This is necessary if you want to call execute() on a method that 
	 * was called before and that was constructed differently. 
	 */
	public void clearConstructionParameters() {
		this.constructionDescriptors.clear();
		this.constructionParameters.clear();
	}
}
