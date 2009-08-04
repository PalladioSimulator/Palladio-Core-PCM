package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;
import LqnCore.SolverParamsType;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;

/**
 * This is an excerpt of Heiko's dissertation (see below for link)
 * 
 * The Layered Queueing Network (LQN) model is a performance model in the class
 * of extended queueing networks. It is a popular model with widespread use
 * [BDIS04]. Like the PCM, it specifically targets analysing the performance of
 * distributed systems. While ordinary queueing networks model software
 * structures only implicitly via resource demands to service centers, LQNs
 * model a system as a layered hierarchy of interacting software entities, which
 * produce demands for the underlying physical resources such as CPUs or hard
 * disks. Therefore, LQNs reflect the structure of distributed systems more
 * naturally than ordinary queueing networks. In particular, they model the
 * routing of jobs in the network more realistically.
 * 
 * In the context of this work, a model transformation from PCM instances (with
 * computed context models) to LQNs has been implemented. The transformation
 * offers at least two advantages: First, it enables comparing the concepts of
 * the PCM with concepts of LQNs, which can be considered as a state-of-the-art
 * performance model. Second, the transformation makes the sophisticated
 * analytical solvers and simulation tools for LQNs available to the PCM. Other
 * than SREs, LQNs support concurrent behaviour, different kinds of workloads,
 * asynchronous interactions, and different scheduling strategies. Therefore, it
 * is possible to derive performance metrics such as resource utilizations and
 * throughput from PCM instances, which is not possible with SREs. However, LQNs
 * are restricted to exponential distributions and mean-values analysis as
 * discussed later.
 * 
 * The chapter 6.4 in Heiko's dissertation will first provide some background
 * about LQNs and their development in recent years (Chapter 6.4.2). Then, it
 * will describe the syntax and (informal) semantics of LQNs using the LQN
 * meta-model and several examples (Chapter 6.4.3). Chapter 6.4.4 briefly
 * describes two performance solvers for LQNs, before Chapter 6.4.5 presents the
 * mapping from PCM instances to LQN instances. Finally, Chapter 6.4.6 compares
 * the PCM model with the LQN model, as well as the existing PCM solvers with
 * two available LQN solvers.
 * 
 * @see Heiko's dissertation, section 6.4 at
 *      http://docserver.bis.uni-oldenburg.de
 *      /_publikationen/dissertation/2008/kozpar08/pdf/kozpar08.pdf
 * @author Heiko Koziolek
 * 
 */
public class Pcm2LqnStrategy implements SolverStrategy {

	private static Logger logger = Logger.getLogger(Pcm2LqnStrategy.class.getName());
	
	// the following filenames should be OS-independent
	private static final String FILENAME_INPUT_XML = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "pcm2lqn.xml";
	private static final String FILENAME_RESULT_HUMAN_READABLE = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "pcm2lqn.out";
	public static String FILENAME_RESULT_XML = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "pcm2lqn_result.xml";
	private static final String FILENAME_LQN = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "pcm2lqn.lqn";
	
	// the lqn tools should be in the system path
	private static final String FILENAME_LQNS = "lqns";
	private static final String FILENAME_LQSIM = "lqsim";
	private static final String FILENAME_LQN2XML = "lqn2xml";
	
	// Return values of lqns
	private static final int LQNS_RETURN_SUCCESS = 0;
	private static final int LQNS_RETURN_MODEL_FAILED_TO_CONVERGE = 1;
	private static final int LQNS_RETURN_INVALID_INPUT = 2;
	private static final int LQNS_RETURN_FATAL_ERROR = -1;
	
	
	
	private long overallDuration = 0;
	private ILaunchConfiguration config;
	
	public Pcm2LqnStrategy(ILaunchConfiguration configuration) {
		config = configuration;
	}

	public Pcm2LqnStrategy() {
	}
	
	public void loadTransformedModel(String fileName) {
	}

	public void solve() {
		String solverProgram = getSolverProgramName();
		String lqnsOutputType = getLqnsOutputTypeName();
		
		String resultFile = "";
		String inputFile = "";
		
		long timeBeforeCalc = System.nanoTime();
		
		int exitVal = LQNS_RETURN_FATAL_ERROR;
		try {
			Process proc = null;
			if (solverProgram.equals(FILENAME_LQNS)) {
				if (lqnsOutputType.equals(MessageStrings.LQNS_OUTPUT_HUMAN)) {
					inputFile = FILENAME_LQN;
					resultFile = FILENAME_RESULT_HUMAN_READABLE;
					proc = Runtime.getRuntime().exec(solverProgram+" -o"+
							resultFile+" "+inputFile);
				}
				else if (lqnsOutputType.equals(MessageStrings.LQNS_OUTPUT_XML)) {
					// The lqns produces XML output when the input is as well in XML
					inputFile = FILENAME_RESULT_XML;
					resultFile = inputFile;
					proc = Runtime.getRuntime().exec(solverProgram+" "+inputFile);
				}
			}
			else if (solverProgram.equals(FILENAME_LQSIM)) {
				inputFile = FILENAME_LQN;
				resultFile = FILENAME_RESULT_HUMAN_READABLE;
				proc = Runtime.getRuntime().exec(solverProgram+" -o"+
						resultFile+" "+inputFile);
			}

            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");            
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "OUTPUT");
            errorGobbler.start();
            outputGobbler.start();

            exitVal = proc.waitFor();
            
		} catch (Throwable e) {
			logger.error("Running "+solverProgram+" failed!");
			throw new RuntimeException(e);
		}
		
		long timeAfterCalc = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc-timeBeforeCalc);
		overallDuration += duration;
		logger.warn("Finished Running "+solverProgram+":\t\t"+ duration + " ms");
		logger.warn("Completed Analysis:\t\t"+ overallDuration + " ms overall");
		
		if (exitVal==LQNS_RETURN_SUCCESS) {
			logger.warn("Analysis Result has been written to: " + resultFile);
		}
		else {
			String message = "";
			if (exitVal==LQNS_RETURN_MODEL_FAILED_TO_CONVERGE) {
				message = solverProgram+" exited with " + exitVal + ": The model failed to converge.";
		}
		else if (exitVal==LQNS_RETURN_INVALID_INPUT) {
			message = solverProgram+" exited with " + exitVal + ": Invalid Input.";
		} else if (exitVal==LQNS_RETURN_FATAL_ERROR){
			message = solverProgram+" exited with "+exitVal+": Fatal error";
		} else {
			message = solverProgram +" returned an unrecognised exit value "+exitVal+". Key: 0 on success, 1 if the model failed to meet the convergence criteria, 2 if the input was invalid, 4 if a command line argument was incorrect, 8 for file read/write problems and -1 for fatal errors. If multiple input files are being processed, the exit code is the bit-wise OR of the above conditions.";
		}
			logger.error(message);
			throw new RuntimeException(message);
		}
	}

	private String getSolverProgramName() {
		String solverProgram = "";
		try {
			solverProgram = config.getAttribute(MessageStrings.SOLVER,
					MessageStrings.LQNS_SOLVER);
		} catch (CoreException e1) {
			logger.error("Could not determine LQN Solver. Check Configuration.");
		}

		if (solverProgram.equals(MessageStrings.LQNS_SOLVER))
			solverProgram = FILENAME_LQNS;
		else
			solverProgram = FILENAME_LQSIM;
		return solverProgram;
	}
	
	private String getLqnsOutputTypeName() {
		String outputType = "";
		
		try {
			 outputType = config.getAttribute(
					MessageStrings.LQNS_OUTPUT,
					MessageStrings.LQNS_OUTPUT_HUMAN);
		} catch (CoreException e) {
			logger.error("Could not determine LQN Solver output type.");
		}
		
		return outputType;
	}
	
	/**
	 * Reads the output file and shows its content 
	 * in a new text editor window.
	 * @param filename
	 */
	private void showOutput(String filename) {
		FileInputStream fis = null;
		byte b[]= null;
		try {
			fis = new FileInputStream(filename);
			int x = 0;
			x = fis.available();
			b= new byte[x];
			fis.read(b);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String content = new String(b);

		ResultWindow rw = new ResultWindow(content);
		rw.open();
	}
	
	public void storeTransformedModel(String fileName) {
	}

	public void transform(PCMInstance model) {
		long startTime = System.nanoTime();
		
		runDSolver(model);
		
		long timeAfterDSolve = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterDSolve-startTime);
		overallDuration += duration;
		logger.warn("Finished DSolver:\t\t"+ duration + " ms");
		

		long timeBeforeTransform = System.nanoTime();
		
		runPcm2Lqn(model);
		
		long timeAfterTransform = System.nanoTime();
		long duration2 = TimeUnit.NANOSECONDS.toMillis(timeAfterTransform-timeBeforeTransform);
		overallDuration += duration2;
		logger.warn("Finished PCM2LQN:\t\t"+ duration2 + " ms");
	}
	
	private void runPcm2Lqn(PCMInstance model) {
		
		LqnBuilder lqnBuilder = new LqnBuilder();

		ResourceEnvironment2Lqn reVisitor = new ResourceEnvironment2Lqn(lqnBuilder, config);
		reVisitor.doSwitch(model.getResourceEnvironment());
		
		UsageModel2Lqn umVisitor = new UsageModel2Lqn(lqnBuilder, new ContextWrapper(model));
		umVisitor.doSwitch(model.getUsageModel());
		
		lqnBuilder.finalizeLqnModel(config);
		
		LqnXmlHandler lqnXmlHandler = new LqnXmlHandler(lqnBuilder.getLqnModel());
		lqnXmlHandler.saveModelToXMI(FILENAME_INPUT_XML);

		Pcm2LqnHelper.clearGuidMap();
		runLqn2Xml();
		runLqn2XmlReformat();
		
	}
	
	/**
	 * Converts the resulting XML file back to the old LQN file format.
	 */
	private void runLqn2Xml() {
		try {
			Process proc = Runtime.getRuntime().exec(
					FILENAME_LQN2XML+" -o" + FILENAME_LQN + 
					" -Oxml " + FILENAME_INPUT_XML);

			StreamGobbler errorGobbler = new StreamGobbler(proc
					.getErrorStream(), "ERROR");
			StreamGobbler outputGobbler = new StreamGobbler(proc
					.getInputStream(), "OUTPUT");
			errorGobbler.start();
			outputGobbler.start();

			int exitVal = proc.waitFor();
			
            if (exitVal == 0){
            	logger.info("lqn2xml terminated sucessfully");
            } else {
            	logger.warn("lqn2xml terminated unsuccessfully. Exit value was "+ exitVal+".");
            }
            
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Performs a reformat of the resulting XML file in order to produce XML
	 * which can be processed from lqns. This is done utilizing lqn2xml. Without
	 * the reformat lqns don't like the XML file and will probably return an
	 * error.
	 * <p>
	 * The reformatted file will be written to {@link #FILENAME_RESULT_XML}.
	 */
	private void runLqn2XmlReformat() {
		try {
			Process proc = Runtime.getRuntime().exec(
					FILENAME_LQN2XML+" -o" + FILENAME_RESULT_XML + 
					" -Oxml " + FILENAME_INPUT_XML);

			StreamGobbler errorGobbler = new StreamGobbler(proc
					.getErrorStream(), "ERROR");
			StreamGobbler outputGobbler = new StreamGobbler(proc
					.getInputStream(), "OUTPUT");
			errorGobbler.start();
			outputGobbler.start();

			int exitVal = proc.waitFor();
			
            if (exitVal == 0){
            	logger.info("lqn2xml terminated sucessfully");
            } else {
            	logger.warn("lqn2xml terminated unsuccessfully. Exit value was "+ exitVal+".");
            }
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void runDSolver(PCMInstance model) {
		// TODO: fix this (only uses one usage scenario):
		UsageModelVisitor visitor = new UsageModelVisitor(model);
		//try {
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());
		/*} catch (Exception e) {
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
		}*/
	}
}

class StreamGobbler extends Thread {
	
	private static Logger logger = Logger.getLogger(StreamGobbler.class.getName());
	
	InputStream is;
	String type;

	StreamGobbler(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	@Override
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				//if (type.equals("ERROR")) logger.error(line);
				if (line.contains("warning")){
					logger.debug(line);
				} else {
					logger.warn(line);
				}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}