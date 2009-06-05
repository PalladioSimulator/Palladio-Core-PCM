package de.uka.ipd.sdq.ByCounter.measurement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.instrumentation.Instrumenter;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * Implementation for the measuring of the cost for instrumenting
 * a specific method in a specified class.
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
public class MeasurableInstrumentationCostsForMethod implements IMeasurable {
	
	private static Logger log;
	private MethodDescriptor method;
	private ArrayList<MethodDescriptor> methods;
	private boolean useHighRegisters;
	private boolean useIntermediateTimeMeasurements;
	
	public MeasurableInstrumentationCostsForMethod(
			MethodDescriptor method, 
			boolean highRegisters) {
		this.method = method;
		this.useHighRegisters = highRegisters;
		this.useIntermediateTimeMeasurements = true;
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}

	public void callForMeasuring() {
		try{
			// instrument the method
			Random rd = new Random(); 
			String fileName = "C:\\TODELETE."+((int) rd.nextLong()*10000)+".class";
			long beforeInitialisation = 0L; 	//MK TODO
			long afterInitialisation = 0L; 		//MK TODO
			long afterByteTransformation = 0L; 	//MK TODO
			long afterFileSaving = 0L;			//MK TODO
		
			beforeInitialisation = System.nanoTime();
		
			InstrumentationParameters params = 
				new InstrumentationParameters(methods, useHighRegisters);
			Instrumenter instr = new Instrumenter(this.method.getCanonicalClassName(), params);
			if(useIntermediateTimeMeasurements){
				afterInitialisation = System.nanoTime();
			}				
			byte[] transformedClass = instr.getInstrumentedBytes(); //MK TODO: save
			if(useIntermediateTimeMeasurements){
				afterByteTransformation = System.nanoTime();
			}
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(fileName);
				fos.write(transformedClass);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(fos!=null) fos.close();
				} catch (IOException e) {
					log.warn("Failed to close...");
					e.printStackTrace();
				}finally{
				}
			}
			afterFileSaving = System.nanoTime();
			log.info("\n ");
			if(useIntermediateTimeMeasurements){
				log.info("MK Initialisation cost: "+(afterInitialisation-beforeInitialisation)+" ns");
				log.info("MK Transformation cost: "+(afterByteTransformation-afterInitialisation)+" ns");
				log.info("MK File saving cost:    "+(afterFileSaving-afterByteTransformation)+" ns");
			}
			log.info("INSTRUMENTATION: Total (incl. timer): "+(afterFileSaving-beforeInitialisation)+" ns");
		} catch(ClassNotFoundException e) {
			log.error("MK Could not find class " + this.method.getCanonicalClassName());
		}
	}
	
	public boolean getUseHighRegisters() {
		return useHighRegisters;
	}

	public boolean getUseIntermediateTimeMeasurements() {
		return useIntermediateTimeMeasurements;
	}

	public boolean prepareMeasuring() {
		methods = new ArrayList<MethodDescriptor>(1);
		methods.add(method);
		return true;		
	}
	
	public void setUseHighRegisters(boolean highRegisters) {
		this.useHighRegisters = highRegisters;
	}
	
	public void setUseIntermediateTimeMeasurements(boolean use) {
		this.useIntermediateTimeMeasurements = use;
	}
}