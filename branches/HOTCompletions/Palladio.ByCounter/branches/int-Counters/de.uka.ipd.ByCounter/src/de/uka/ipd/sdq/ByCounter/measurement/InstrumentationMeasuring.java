package de.uka.ipd.sdq.ByCounter.measurement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import spec.benchmarks.scimark.lu.LU;
import spec.benchmarks.scimark.monte_carlo.MonteCarlo;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.instrumentation.Instrumenter;
import de.uka.ipd.sdq.ByCounter.test.JGFCastBench_MK;
import de.uka.ipd.sdq.ByCounter.test.Linpack_MK;
import de.uka.ipd.sdq.ByCounter.test.SciMarkMonteCarlo_MK;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;
import de.uka.ipd.sdq.ByCounter.utils.PathMapper;

/** TODO JavaDoc
 * TODO write out uninstrumented ASM-created file for comparison with the original uninstrumented file
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class InstrumentationMeasuring {
	private static final String INSTRUMENTED_CLASSFILES_ROOT_PATH = "."+File.separator + "instrumented_classfiles"; //"de"+File.separator+"uka"+File.separator+"ipd"+File.separator+"sdq"+File.separator+"ByCounter"+File.separator+"evaluation";
	private static final String TEST_CLASS_CANONICAL_NAME_JFG 	
		= JGFCastBench_MK.class.getCanonicalName();
	private static final String TEST_CLASS_CANONICAL_NAME_LI 	
		= Linpack_MK.class.getCanonicalName();
	private static final String TEST_CLASS_CANONICAL_NAME_LU2008  //TODO test
		= LU.class.getCanonicalName();
	private static final String TEST_CLASS_CANONICAL_NAME_MC	
		= SciMarkMonteCarlo_MK.class.getCanonicalName();
	private static final String TEST_CLASS_CANONICAL_NAME_MC2008  //TODO test
		= MonteCarlo.class.getCanonicalName();
	
	private static final String TEST_CLASS_CANONICAL_NAME_RD2008  //TODO test
		= MonteCarlo.class.getCanonicalName();
	
	private static final String TEST_METHODSIG_JFG				
		= "public void JGFrun_MK()";
	private static final String TEST_METHODSIG_LI 				
		= "public void run_benchmark()";
	private static final String TEST_METHODSIG_LU2008 			  //TODO test
		= "public int factor(double A[][], int pivot[])";
	private static final String TEST_METHODSIG_MC 				
		= "public static final double integrateMK()";
	private static final String TEST_METHODSIG_MC2008 			  //TODO test
		= "public final double integrate_MK(int Num_samples)";
	private static final String TEST_METHODSIG_RD2008 			  //TODO test
		= "public final double integrate_MK(int Num_samples)";
	
	private static final int USE_JGF 		= 0;
	private static final int USE_LINPACK 	= 1;
	private static final int USE_LU2008 	= 3; //TODO test
	private static final int USE_MC2008 	= 4; //TODO test
	private static final int USE_RD2008 	= 5; //TODO test
	private static final int USE_SCIMARK 	= 2;    
	
	/**TODO
	 * @param args
	 */
	public static void main(String args[]){
		InstrumentationMeasuring im = new InstrumentationMeasuring();
		im.measureAllSteps();
	}
	private List<MethodDescriptor> allMethodsOfClass = null;
	private String classCanonicalName = null;
	private boolean instrumentAllMethods;
	private boolean instrumentDynamically;
	private byte[] instrumentedBytes = null;

	@SuppressWarnings("unchecked")
	private Class instrumentedClass = null; //TODO not initialised
	private String instrumentedClassfilesRelativePath = null;
	private String instrumentedClassfilesRootPath = null;
	private Instrumenter instrumenter = null;
	private boolean instrumentFromFile;
	private Logger log = null;
	private List<MethodDescriptor> methodsToInstrument = null;
	private byte[] originalBytes = null;
	private String originalClassfilesPath = null;
	
	private boolean successfulInit = false;
	
	/**
	 * TODO
	 */
	public InstrumentationMeasuring(){
		PropertyConfigurator.configure("log4j.properties");
		this.log = Logger.getLogger(this.getClass().getCanonicalName());
		
		this.instrumentedClassfilesRootPath = INSTRUMENTED_CLASSFILES_ROOT_PATH;
		int version = USE_LU2008;
		
		this.methodsToInstrument = new ArrayList<MethodDescriptor>();
		if(version == USE_JGF){
			this.classCanonicalName = TEST_CLASS_CANONICAL_NAME_JFG;
			this.methodsToInstrument.add(new MethodDescriptor(TEST_METHODSIG_JFG));
		}else if(version == USE_LINPACK){
			this.classCanonicalName = TEST_CLASS_CANONICAL_NAME_LI;
			this.methodsToInstrument.add(new MethodDescriptor(TEST_METHODSIG_LI));
		}else if(version == USE_SCIMARK){
			this.classCanonicalName = TEST_CLASS_CANONICAL_NAME_MC;
			this.methodsToInstrument.add(new MethodDescriptor(TEST_METHODSIG_MC));
		}else if(version == USE_LU2008){
			this.classCanonicalName = TEST_CLASS_CANONICAL_NAME_LU2008;
			this.methodsToInstrument.add(new MethodDescriptor(TEST_METHODSIG_LU2008));
		}else if(version == USE_MC2008){
			this.classCanonicalName = TEST_CLASS_CANONICAL_NAME_MC2008;
			this.methodsToInstrument.add(new MethodDescriptor(TEST_METHODSIG_MC2008));
		}else if(version == USE_RD2008){
			this.classCanonicalName = TEST_CLASS_CANONICAL_NAME_RD2008;
			this.methodsToInstrument.add(new MethodDescriptor(TEST_METHODSIG_RD2008));
		}else{
			log.error("Flag "+version+" not supported!");
		}
		this.successfulInit  = this.initialize();//requires canonicalName to be set
	}
	
	public List<MethodDescriptor> getAllMethodsOfClass() {
		return allMethodsOfClass;
	}
				
	public String getClassCanonicalName() {
		return classCanonicalName;
	}

	public byte[] getInstrumentedBytes() {
		return instrumentedBytes;
	}

	@SuppressWarnings("unchecked")
	public Class getInstrumentedClass() {
		return instrumentedClass;
	}
		
	public String getInstrumentedClassfilesRelativePath() {
		return instrumentedClassfilesRelativePath;
	}
	
	public String getInstrumentedClassfilesRootPath() {
		return instrumentedClassfilesRootPath;
	}

	public Instrumenter getInstrumenter() {
		return instrumenter;
	}

	public List<MethodDescriptor> getMethodsToInstrument() {
		return methodsToInstrument;
	}

	public byte[] getOriginalBytes() {
		return originalBytes;
	}

	public String getOriginalClassfilesPath() {
		return originalClassfilesPath;
	}

	public byte[] getUninstrumentedBytes() {
		return this.instrumenter.getUninstrumentedBytes();//uninstrumentedBytes;
	}

	/** TODO
	 * 
	 */
	@SuppressWarnings("deprecation")
	private boolean initialize() {
		this.allMethodsOfClass 		= new ArrayList<MethodDescriptor>();
		this.instrumentAllMethods 	= false; //should be constant -> need to know method metrics
		this.instrumentDynamically 	= true; //should be varied, but produce very similar results!
		this.instrumentFromFile 	= false; //keep stable

		this.instrumentedClassfilesRelativePath = "";
		if(this.getClassCanonicalName()==null){
			log.error("Cannot initialise class instance " +
					"because classCanonicalName is null");
			return false;
		}
		ArrayList<String> packageTokens 
			= PathMapper.derivePackageTokensFromCanonicalName(this.getClassCanonicalName());
		for (Iterator<String> iterator = packageTokens.iterator(); iterator.hasNext();) {
			this.instrumentedClassfilesRelativePath += File.separator+iterator.next();
		}
		this.instrumentedClassfilesRelativePath += File.separator;
		try {
			this.instrumentedClass = Class.forName(this.classCanonicalName); //TODO
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Method[] methods = this.instrumentedClass.getMethods();
		log.debug("Class "+this.getClassCanonicalName()+" has "+methods.length+" methods");
		// add method descriptors for every method of the class
		for (int i = 0; i < methods.length; i++) {
			// since we use reflection, the signature can be derived simply.
			this.allMethodsOfClass.add(new MethodDescriptor(methods[i]));
		}
		if(this.instrumentAllMethods){
			this.methodsToInstrument = this.allMethodsOfClass; //effectively clearing...
			log.debug("Instrumented methods: all");
		}else{
			StringBuffer sb = new StringBuffer();
			for (Iterator<MethodDescriptor> iterator = methodsToInstrument.iterator(); iterator.hasNext();) {
				sb.append(iterator.next()+" ");
			}
			log.debug(this.methodsToInstrument.size()+" instrumented methods: "+sb.toString());
//				log.debug("No methods added for instrumentation during initialisation " +
//						"(check log/source for methods added later)");
		}
		this.originalBytes = null;
		StringTokenizer st = new StringTokenizer(this.classCanonicalName, ".");
//			System.out.println("StringTokenizer findes "+st.countTokens()+" tokens");
//			String[] parts = this.classCanonicalName.split(".");
//			System.out.println("Parts: "+parts.length);
		this.originalClassfilesPath = "."+File.separator+"bin"; //TODO
		for(; st.hasMoreTokens(); ){
			this.originalClassfilesPath+=File.separator+st.nextToken();//concat doesn't work!!!
		}
		this.originalClassfilesPath+=".class";
		try {
			File f = new File(this.originalClassfilesPath);
			if(!f.exists()){
				log.error("Original file does not exist: "+f.getAbsolutePath());
				return false;
			}
			FileInputStream fis = new FileInputStream(f); //this.originalFilePath);
			this.originalBytes = new byte[(int) f.length()];//TODO document assumption, add code to catch overflow
			fis.read(this.originalBytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			InstrumentationParameters params = 
				new InstrumentationParameters(
						this.getMethodsToInstrument(), 
						false, 
						true //TODO document / change: does not use result collector...
					);
			if(this.instrumentFromFile){
				this.instrumenter = new Instrumenter(
						this.getOriginalBytes(), 
						params //result collector usage //TODO document/test
				);
			}else{
				this.instrumenter = new Instrumenter(
						this.getClassCanonicalName(), 
						params //result collector usage //TODO document/test
				);
			}
			this.instrumenter.getInstrumentationParameters(). //TODO explain why not called earlier
				setUseHighRegistersForCounting(!this.instrumentDynamically);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			this.instrumenter = null;
		} finally {
			//nothing
		}
		log.debug("this.instrumentedClassfilesRelativePath: "+
				this.instrumentedClassfilesRelativePath);
		return true;
	}

	public boolean isInstrumentAllMethods() {
		return instrumentAllMethods;
	}

	public boolean isInstrumentDynamically() {
		return instrumentDynamically;
	}

	public boolean isInstrumentFromFile() {
		return instrumentFromFile;
	}

	private void measureAllSteps() {
		if(!this.successfulInit){
			log.error("Cannot measure because initialisation unsuccessful");
			return;
		}
		this.instrumenter.getInstrumentationParameters().
			setUseHighRegistersForCounting(!this.instrumentDynamically);
		//TODO duplicate...
		this.instrumentedBytes = this.instrumenter.getInstrumentedBytes(); 
		long afterGettingResults_4 = System.nanoTime();

		long[] measurements = this.instrumenter.getMeasurements();
		long readerInitialisation = measurements[2]-measurements[1];
		long asmSetup = measurements[3]-measurements[2];
		long readerProcessing = measurements[4]-measurements[3];
		long gettingByteArray = afterGettingResults_4-measurements[4];
		long total = afterGettingResults_4 - measurements[1];
		log.info(total+               "ns spent in instrumentation (aka \t"+
				total/1000+"us aka \t"+
				total/1000000+"ms aka \t"+
				total/1000000000+"s), of which ");
		log.info(readerInitialisation+"ns reader initialisation (aka \t"+
				readerInitialisation/1000+"us aka \t"+
				readerInitialisation/1000000+"ms aka \t"+
				readerInitialisation/1000000000+"s)");
		log.info(asmSetup+            "ns ASM setup             (aka \t"+
				asmSetup/1000+"us aka \t"+
				asmSetup/1000000+"ms aka \t"+
				asmSetup/1000000000+"s)");
		log.info(readerProcessing+    "ns reader processing     (aka \t"+
				readerProcessing/1000+"us aka \t"+
				readerProcessing/1000000+"ms aka \t"+
				readerProcessing/1000000000+"s)");
		log.info(gettingByteArray+    "ns getting byte array    (aka \t"+
				gettingByteArray/1000+"us aka \t"+
				gettingByteArray/1000000+"ms aka \t"+
				gettingByteArray/1000000000+"s)");
		
		log.info(this.getOriginalBytes().length+": bytesize of original class ("+this.originalClassfilesPath+")");
		log.info(measurements[5]+": bytesize of parsed-and-emitted class before instrumentation (MAY BE WRONG...)");
		log.info(measurements[6]+": bytesize of written class after instrumentation (should be equal to "+this.getInstrumentedBytes().length+")");
		log.info((measurements[6]/this.getOriginalBytes().length)+": instrumentation inflate factor");
		long timestamp = System.currentTimeMillis();
		this.saveInstrumentedClassfileToDisk(timestamp);
		this.saveOriginalClassfileToDisk(timestamp);
		System.err.println(total/1000+" us"); 
	}

	/** TODO
	 * @param array
	 * @param path
	 * @param createFileIfNeeded
	 */
	private void saveByteArray(byte[] array, String path, boolean createFileIfNeeded){
		log.debug("Path given to saveByteArray: "+path); 
		File f = new File(path);
		if(!f.exists()){
			f.getParentFile().mkdirs();
		}else{
			if(f.isDirectory()){
				log.error("Cannot write byte array to directory! (path given: "+path);
				return;
			}else{
				log.warn("Overwriting file "+f.getAbsolutePath());
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			fos.write(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				//nothing
			}
		}
	}

	/** TODO
	 * @param timestamp
	 */
	private void saveInstrumentedClassfileToDisk(long timestamp) {
		//TODO find "needed files"; assumption: flat structure (later: entire tree -> Martin)
		//TODO this.createDirIfNonexistent(...);

		String path = this.instrumentedClassfilesRootPath //something like ./test
			+ File.separator
			+ timestamp //z.B. System.currentTimeMillis()
			+ File.separator
			+ this.instrumentedClassfilesRelativePath
			+ File.separator
			+ PathMapper.deriveShortClassNameFromCanonicalName(this.getClassCanonicalName()) //has no .class extension
			+ ".class";
		log.debug("Saving instrumented class to "+path);
		this.saveByteArray(this.getInstrumentedBytes(), path, true);
	}

	/** TODO
	 * 
	 */
	private void saveOriginalClassfileToDisk(long timestamp) {
		//TODO find "needed files"; assumption: flat structure (later: entire tree -> Martin)
		//TODO this.createDirIfNonexistent(...);

		String path = this.instrumentedClassfilesRootPath //something like ./test
			+ File.separator
			+ timestamp //z.B. System.currentTimeMillis()
			+ File.separator
			+ this.instrumentedClassfilesRelativePath
			+ File.separator
			+ PathMapper.deriveShortClassNameFromCanonicalName(this.getClassCanonicalName()) //has no .class extension
			+ ".original.class";
		log.debug("Saving uninstrumented class to "+path);
		this.saveByteArray(this.getOriginalBytes(),path, true);
	}

	/** TODO
	 * @param timestamp
	 */
	@SuppressWarnings("unused")
	private void saveUninstrumentedClassfileToDisk(long timestamp) {
		//TODO find "needed files"; assumption: flat structure (later: entire tree -> Martin)
		//TODO this.createDirIfNonexistent(...);

		String path = this.instrumentedClassfilesRootPath //something like ./test
			+ File.separator
			+ timestamp //z.B. System.currentTimeMillis()
			+ File.separator
			+ this.instrumentedClassfilesRelativePath
			+ File.separator
			+ PathMapper.deriveShortClassNameFromCanonicalName(this.getClassCanonicalName()) //has no .class extension
			+ ".uninstrumented.class";
		log.debug("Saving uninstrumented class to "+path);
		this.saveByteArray(this.getUninstrumentedBytes(),path, true);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Class hashcode: "+((Object) this).hashCode()+"\n");
		sb.append("\t"+"this.allMethodsOfClass: "+this.allMethodsOfClass);
		if(this.allMethodsOfClass!=null){
			sb.append(" (length: "+this.allMethodsOfClass.size()+")");
		}
		sb.append("\n");
		sb.append("\t"+"this.classCanonicalName: "+this.classCanonicalName+"\n");
		sb.append("\t"+"this.instrumentAllMethods: "+this.instrumentAllMethods);
		sb.append("\t"+"this.instrumentDynamically: "+this.instrumentDynamically+"\n");
		sb.append("\t"+"this.instrumentedBytes: "+this.instrumentedBytes);
		if(this.instrumentedBytes!=null){
			sb.append(" (length: "+this.originalBytes.length+")");
		}
		sb.append("\n");
		sb.append("\t"+"this.instrumentedClass: "+this.instrumentedClass+"\n");
		sb.append("\t"+"this.instrumentedClassfilesRelativePath: "+this.instrumentedClassfilesRelativePath+"\n");
		sb.append("\t"+"this.instrumentedClassfilesRootPath: "+this.instrumentedClassfilesRootPath+"\n");
		sb.append("\t"+"this.instrumenter: "+this.instrumenter+"\n");
		sb.append("\t"+"this.instrumentFromFile: "+this.instrumentFromFile+"\n");
		sb.append("\t"+"this.methodsToInstrument: "+this.methodsToInstrument);
		if(this.methodsToInstrument!=null){
			sb.append(" (length: "+this.methodsToInstrument.size()+")");
		}
		sb.append("\t"+"this.originalBytes: "+this.originalBytes);
		if(this.originalBytes!=null){
			sb.append(" (length: "+this.originalBytes.length+")");
		}
		sb.append("\n");
		sb.append("\t"+"this.originalClassfilesPath: "+this.originalClassfilesPath+"\n");
		return sb.toString();
	}

}
