package de.uka.ipd.sdq.ByCounter.measurement;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeClassLoader;
import de.uka.ipd.sdq.ByCounter.execution.MethodInvocationHelper;
import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.instrumentation.Instrumenter;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * Implementation for the measuring of the cost for running
 * a specific method in a specified class with or without being instrumented.
 * This includes constructing the Instrumenter. The resulting bytearray is 
 * being queried with <code>getTransformedBytes()</code> but is discarded 
 * (i.e. not saved in a variable).
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 * @deprecated
 */
public class MeasurableCostsForMethodRun implements IMeasurable {
	
	private static Logger log;
	
	private int instrumentationMode;
	private MethodDescriptor method;
	private ArrayList<MethodDescriptor> methods;
	//private ArrayList<RuntimeMethodParameters> paramsList;
	private Object objInstance;

	/**
	 * Construct a meausurable for the specified method in the specified class.
	 * @param method The method that shall be measured.
	 * @param instrumentationMode Specifies in which way (if at all) the method shall be altered. See the INSTRUMENTATION_* constants in <code>CostMeasurement</code>.
	 */
	public MeasurableCostsForMethodRun(
			MethodDescriptor method, 
			int instrumentationMode) {
		this.method = method;
		this.instrumentationMode = instrumentationMode;
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}

	/**
	 * Call the method on the constructed object.
	 */
	public void callForMeasuring() {
		// call the method
		MethodInvocationHelper.callMethodsNoArgs(log, objInstance, methods);
	}
	
	/**
	 * @return Returns the integer constant for the current instrumentation mode. 
	 */
	public int getInstrumentationMode() {
		return instrumentationMode;
	}

	/**
	 * This is beeing called before the repeated run of <code>callForMeasuring</code>.
	 * Modifies the methods bytecode if nessecary and constructs the class.
	 */
	public boolean prepareMeasuring() {
		methods = new ArrayList<MethodDescriptor>(1);
		methods.add(method);
/*		
		int[] conversions = {};
		Object[] params = {};
		
		RuntimeMethodParameters rtParams;
		rtParams = new RuntimeMethodParameters(params, conversions);
		paramsList = new ArrayList<RuntimeMethodParameters>(1);
		paramsList.add(rtParams);
*/
		Class<?> classObj = null;
		try {
			if((instrumentationMode & CostMeasurement.INSTRUMENTATION_NONE) > 0) {
				classObj = ClassLoader.getSystemClassLoader().loadClass(this.method.getCanonicalClassName());
				log.debug("Declared methods: "+Arrays.toString(classObj.getDeclaredMethods()));
			} else {	// instrument the method
				InstrumentationParameters p = new InstrumentationParameters(methods);
				if((instrumentationMode & CostMeasurement.INSTRUMENTATION_USE_HIGH_REGISTERS) > 0) {
					p.setUseHighRegistersForCounting(true);
				} else {
					p.setUseHighRegistersForCounting(false);
				}
				Instrumenter instr = new Instrumenter(this.method.getCanonicalClassName(), p);
				instr.instrument();
				byte[] b = instr.getInstrumentedBytes();
				
				// Load the class from the bytecode
				BytecodeClassLoader loader = BytecodeClassLoader.getInstance();
				classObj = loader.defineClass(this.method.getCanonicalClassName(), b);
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}
		
		// class instance
		objInstance = null;
		
		try {
			objInstance = classObj.newInstance(); //Problem in constructors with parameters...
		} catch (InstantiationException e1) {
			e1.printStackTrace();
			log.error("Instantiation failure");
			return false;
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			log.error("Instantiation failure");
			return false;
		}
		
		// Return if instantiation failed.
		if(objInstance == null) {
			log.error("Error: Could not create class instance.");
			return false;
		}
		
		// nothing failed - return success
		return true;
	}

	/**
	 * Sets the way in which the method to be measured is instrumented.
	 * @param instrumentationMode An integer constant as specified in <code>CostMeasurement</code>.
	 */
	public void setInstrumentationMode(int instrumentationMode) {
		this.instrumentationMode = instrumentationMode;
	}
}