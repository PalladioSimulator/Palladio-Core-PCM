/*
 * 
 */
package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.visualisation.LQNHtmlResultGenerator;
import de.uka.ipd.sdq.pcmsolver.visualisation.LQNResultEditorInput;

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
	private String filenameInputXML;
	private String filenameResultHumanReadable;
	private String filenameResultXML;
	private String filenameLQN;

	// the lqn tools should be in the system path
	private static final String FILENAME_LQNS = "lqns";

	private static final String FILENAME_LQSIM = "lqsim";


	private static final String FILENAME_PERFENG = "LINE";

	private static final String FILENAME_LQN2XML = "lqn2xml";

	// Return values of lqns
	private static final int LQNS_RETURN_SUCCESS = 0;
	private static final int LQNS_RETURN_MODEL_FAILED_TO_CONVERGE = 1;
	private static final int LQNS_RETURN_INVALID_INPUT = 2;
	private static final int LQNS_RETURN_FATAL_ERROR = -1;

	private long overallDuration = 0;
	private PCMSolverWorkflowRunConfiguration config;

	public Pcm2LqnStrategy(PCMSolverWorkflowRunConfiguration configuration) {
		config = configuration;

		DateFormat dateFormat = new SimpleDateFormat("-yyyy-MM-dd-HHmmss");
		Date date = new Date();
		String timestamp = dateFormat.format(date);

		filenameInputXML = getOutputFolder()
				+ System.getProperty("file.separator") + "pcm2lqn" + timestamp
				+ ".xml";
		filenameResultHumanReadable = getOutputFolder()
				+ System.getProperty("file.separator") + "pcm2lqn" + timestamp
				+ ".out";
		filenameResultXML = getOutputFolder()
				+ System.getProperty("file.separator") + "pcm2lqn"
				+ timestamp + ".lqxo";
		filenameLQN = getOutputFolder() + System.getProperty("file.separator")
				+ "pcm2lqn" + timestamp + ".lqn";

	}

	public String getFilenameResultXML() {
		return filenameResultXML;
	}

	private String getOutputFolder() {
		if (getSolverProgramName().equals(FILENAME_LQNS)) {
			return config.getLqnsOutputDir();
		} else if (getSolverProgramName().equals(FILENAME_PERFENG)) {
			return config.getPerfEngOutputDir();
		} else {
			return config.getLqsimOutputDir();
		}
	}

	public Pcm2LqnStrategy() {
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy#loadTransformedModel(java.lang.String)
	 */
	public void loadTransformedModel(String fileName) {
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy#solve()
	 */
	public void solve() {
		String solverProgram = getSolverProgramName();
		String lqnsOutputType = getLqnsOutputTypeName();		
		String lqnSimOutputType = getLqsimOutputTypeName();

		String options = "";

		String resultFile = "";
		String inputFile = "";
		String xmlresultFile = "";

		File  folder = null; //diretory of execution of the perfromance engine

		long timeBeforeCalc = System.nanoTime();

		int exitVal = LQNS_RETURN_FATAL_ERROR;
		String errorMessages = "";

		try {
			String command = "";

			// Process proc = null;
			if (solverProgram.equals(FILENAME_LQNS)) {

				// check whether Pragmas (see LQN documentation) are used and if
				// yes, set -P option
				if (!config.getStopOnMessageLossLQNS()
						|| !"".equals(config.getPragmas())) {
					options += " -P ";
					if (!config.getStopOnMessageLossLQNS()) {
						options += "stop-on-message-loss=false ";
					}
					if (!"".equals(config.getPragmas())) {
						options += config.getPragmas();
					}
				}
				if (lqnsOutputType.equals(MessageStrings.LQN_OUTPUT_HUMAN)) {
					inputFile = filenameInputXML;
					resultFile = filenameResultHumanReadable;
					xmlresultFile = filenameResultXML;
					command = solverProgram + options + " -o " + resultFile
							+ " " + inputFile;
					//Read the XML input file encoding the LQN instance
					FileReader fr = new FileReader(inputFile);
					BufferedReader br = new BufferedReader(fr);
					//Skip the first line (wrong encoding ASCII)
					br.readLine();
					//Read the following lines
					List<String> content = new ArrayList<String>();
					String line = br.readLine();
					while (line != null) {
						content.add(line + "\n");
						line = br.readLine();
					}
					//Close the file
					br.close();
					fr.close();
					//Delete the file
					File f = new File(inputFile);
					f.delete();
					//Create a new file with the same name and start writing in it
					FileWriter fw = new FileWriter(f);
					BufferedWriter bw = new BufferedWriter(fw);
					//Write the correct XML header (encoding us-ascii)
					bw.write("<?xml version=\"1.0\" encoding=\"us-ascii\"?>\n");
					bw.flush();
					//Write all the following lines
					for (String s : content) {
						bw.write(s);
						bw.flush();
					}
					//Close the file
					bw.close();
					fw.close();
				} else if (lqnsOutputType.equals(MessageStrings.LQN_OUTPUT_XML)
						|| lqnsOutputType
						.equals(MessageStrings.LQN_OUTPUT_HTML)) {
					// The lqns produces XML output when the input is as well in
					// XML
					inputFile = filenameInputXML;					
					resultFile = filenameResultXML;
					xmlresultFile = filenameResultXML;
					command = solverProgram + options + " " + inputFile;

					//Read the XML input file encoding the LQN instance
					FileReader fr = new FileReader(inputFile);
					BufferedReader br = new BufferedReader(fr);
					//Skip the first line (wrong encoding ASCII)
					br.readLine();
					//Read the following lines
					List<String> content = new ArrayList<String>();
					String line = br.readLine();
					while (line != null) {
						content.add(line + "\n");
						line = br.readLine();
					}
					//Close the file
					br.close();
					fr.close();
					//Delete the file
					File f = new File(inputFile);
					f.delete();
					//Create a new file with the same name and start writing in it
					FileWriter fw = new FileWriter(f);
					BufferedWriter bw = new BufferedWriter(fw);
					//Write the correct XML header (encoding us-ascii)
					bw.write("<?xml version=\"1.0\" encoding=\"us-ascii\"?>\n");
					bw.flush();
					//Write all the following lines
					for (String s : content) {
						bw.write(s);
						bw.flush();
					}
					//Close the file
					bw.close();
					fw.close();
				}
			} else if (solverProgram.equals(FILENAME_LQSIM)) {
				// LQSim config
				String blocks = config.getLQSimBlocks();
				String runtime = config.getLQSimRuntime();

				if (runtime != null && runtime != "") {
					options += " -A " + runtime;
				}
				if (blocks != null && blocks != "") {
					options += " -B " + blocks;
				}
				if (!config.getStopOnMessageLossLQSim()) {
					options += " -P stop-on-message-loss=false";
				}

				if (lqnSimOutputType.equals(MessageStrings.LQN_OUTPUT_HUMAN)
						|| lqnSimOutputType
						.equals(MessageStrings.LQN_OUTPUT_HTML)) {
					inputFile = filenameLQN;
					resultFile = filenameResultHumanReadable;
					command = solverProgram + options + " -o" + resultFile
							+ " " + inputFile;
				} else if (lqnSimOutputType
						.equals(MessageStrings.LQN_OUTPUT_XML)) {
					// The lqsim produces XML output when the input is as well
					// in XML
					inputFile = filenameInputXML;					
					resultFile = filenameResultXML;
					xmlresultFile = filenameResultXML;
					//command = solverProgram + options + " " + inputFile;

					//Read the XML input file encoding the LQN instance
					FileReader fr = new FileReader(inputFile);
					BufferedReader br = new BufferedReader(fr);
					//Skip the first line (wrong encoding ASCII)
					br.readLine();
					//Read the following lines
					List<String> content = new ArrayList<String>();
					String line = br.readLine();
					while (line != null) {
						content.add(line + "\n");
						line = br.readLine();
					}
					//Close the file
					br.close();
					fr.close();
					//Delete the file
					File f = new File(inputFile);
					f.delete();
					//Create a new file with the same name and start writing in it
					FileWriter fw = new FileWriter(f);
					BufferedWriter bw = new BufferedWriter(fw);
					//Write the correct XML header (encoding us-ascii)
					bw.write("<?xml version=\"1.0\" encoding=\"us-ascii\"?>\n");
					bw.flush();
					//Write all the following lines
					for (String s : content) {
						bw.write(s);
						bw.flush();
					}
					//Close the file
					bw.close();
					fw.close();

					command = solverProgram + options + " " + inputFile;
				}
			}
			//Perfromance Engine Solution Method
			else if(solverProgram.equals(FILENAME_PERFENG)){	
				inputFile = filenameInputXML;
				resultFile = filenameResultXML;

				//Read the XML input file encoding the LQN instance
				FileReader fr = new FileReader(inputFile);
				BufferedReader br = new BufferedReader(fr);
				//Skip the first line (wrong encoding ASCII)
				br.readLine();
				//Read the following lines
				List<String> content = new ArrayList<String>();
				String line = br.readLine();
				while (line != null) {
					content.add(line + "\n");
					line = br.readLine();
				}
				//Close the file
				br.close();
				fr.close();
				//Delete the file
				File f = new File(inputFile);
				f.delete();
				//Create a new file with the same name and start writing in it				
				File recordFile = new File(inputFile);			
				FileWriter recordFw = new FileWriter(recordFile);
				BufferedWriter recordBw = new BufferedWriter(recordFw);
				//Write the correct XML header (encoding us-ascii)
				recordBw.write("<?xml version=\"1.0\" encoding=\"us-ascii\"?>\n");
				recordBw.flush();
				//Write all the following lines
				for (String s : content) {
					recordBw.write(s);
					recordBw.flush();
				}
				//Close the file
				recordBw.close();
				recordFw.close();

				LineServerHandler lineHandler = new LineServerHandler();
				//connect to LINE
				lineHandler.connectToLINEServer(config.getPerfEngPropFile());

				String inputFileAbsPath = new File(inputFile).getAbsolutePath(); 
				//solve the model
				lineHandler.solve(inputFileAbsPath,null);
				while(!lineHandler.isSolved(inputFileAbsPath)) Thread.sleep(100);
				//terminate the connection
				lineHandler.terminateLine();				

			}

			if(!solverProgram.equals(FILENAME_PERFENG)){
				logger.warn("Calling LQN analysis tool with " + command);
				ProcessBuilder pb = new ProcessBuilder(splitToCommandArray(command));

				if (solverProgram.equals(FILENAME_PERFENG)) {													
					pb.directory(folder);

				}
				pb.redirectErrorStream(true);

				long lStartTime = System.nanoTime();
				Process proc = pb.start();
				// StreamGobbler errorGobbler = new
				// StreamGobbler(proc.getErrorStream(), "ERROR");
				// StreamGobbler outputGobbler = new
				// StreamGobbler(proc.getInputStream(), "OUTPUT");
				// errorGobbler.start();
				// outputGobbler.start();
				System.out.println(readStream(proc.getInputStream()));
				exitVal = proc.waitFor();

				//some tasks
				long lEndTime = System.nanoTime();

				long difference = lEndTime - lStartTime;

				System.out.println("Evaulated in: " + difference/1000000);

				proc.destroy();
			}
		} catch (Throwable e) {
			logger.error("Running " + solverProgram + " failed!");
			throw new RuntimeException(e);
		}

		long timeAfterCalc = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc
				- timeBeforeCalc);
		overallDuration += duration;
		logger.warn("Finished Running " + solverProgram + ":\t\t" + duration
				+ " ms");
		logger.warn("Completed Analysis:\t\t" + overallDuration + " ms overall");

		/* return if results are available or throw exception. */
		//If we are using LQNS
		if(!solverProgram.equals(FILENAME_PERFENG)){
			if (exitVal == LQNS_RETURN_SUCCESS) {
				logger.warn("Analysis Result has been written to: " + resultFile);
				if (lqnsOutputType.equals(MessageStrings.LQN_OUTPUT_HTML)&& config.isShowHtmlResults()) {
					// showOutput(resultFile);
					LQNHtmlResultGenerator result = new LQNHtmlResultGenerator(
							xmlresultFile);
					result.display();
				}

			} else if (exitVal == LQNS_RETURN_MODEL_FAILED_TO_CONVERGE) {
				logger.error(solverProgram
						+ " exited with "
						+ exitVal
						+ ": The model failed to converge. Results are most likely inaccurate. ");
				logger.warn("Analysis Result has been written to: " + resultFile);
			} else {
				String message = "";
				if (exitVal == LQNS_RETURN_INVALID_INPUT) {
					message = solverProgram + " exited with " + exitVal
							+ ": Invalid Input.";
				} else if (exitVal == LQNS_RETURN_FATAL_ERROR) {
					message = solverProgram + " exited with " + exitVal
							+ ": Fatal error";
				} else {
					message = solverProgram
							+ " returned an unrecognised exit value "
							+ exitVal
							+ ". Key: 0 on success, 1 if the model failed to meet the convergence criteria, 2 if the input was invalid, 4 if a command line argument was incorrect, 8 for file read/write problems and -1 for fatal errors. If multiple input files are being processed, the exit code is the bit-wise OR of the above conditions.";
				}
				message += "\nFurther errors: " + errorMessages;
				logger.error(message);
				throw new RuntimeException(message);
			}
		}
		//if we are using the Performance Engine Solver
		else{
			logger.info("Using the perfromance Engine Solver");
			logger.info("Exit val: "+exitVal);
			logger.info("Results writte in: "+resultFile);
		}
	}



	private String getSolverProgramName() {
		if (config.getSolver().equals(MessageStrings.LQNS_SOLVER)) {
			return FILENAME_LQNS;
		} else if (config.getSolver().equals(MessageStrings.PERFENGINE_SOLVER)) {
			return FILENAME_PERFENG;
		} else{
			return FILENAME_LQSIM;
		}
	}


	private String getLqnsOutputTypeName() {
		return config.getLqnsOutput();
	}


	private String getLqsimOutputTypeName() {
		return config.getLqsimOutput();
	}

	/**
	 * Reads the output file and shows its content in a new text editor window.
	 *
	 * @param filename the filename
	 */
	private void showOutput(String filename) {
		FileInputStream fis = null;
		byte b[] = null;
		try {
			fis = new FileInputStream(filename);
			int x = 0;
			x = fis.available();
			b = new byte[x];
			fis.read(b);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String content = new String(b);

		final String htmlText = getHtmlForLqnResult(content);

		// ResultWindow rw = new ResultWindow(content);
		// rw.open();

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				if (page != null) {
					try {
						page.openEditor(new LQNResultEditorInput(htmlText),
								"de.uka.ipd.sdq.pcmsolver.LQNResultEditor");
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			}
		});

	}

	private String getHtmlForLqnResult(String lqnResult) {
		String htmlText = "<html><head><title>LQN Results</title></head>"
				+ "<body><pre>" + lqnResult + "</pre></body></html>";
		return htmlText;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy#storeTransformedModel(java.lang.String)
	 */
	public void storeTransformedModel(String fileName) {
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy#transform(de.uka.ipd.sdq.pcmsolver.models.PCMInstance)
	 */
	public void transform(PCMInstance model) {
		long startTime = System.nanoTime();

		runDSolver(model);

		long timeAfterDSolve = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterDSolve
				- startTime);
		overallDuration += duration;
		logger.warn("Finished DSolver:\t\t" + duration + " ms");

		long timeBeforeTransform = System.nanoTime();

		// model.saveComputedContextToFiles(System.getProperty("user.dir")
		// + System.getProperty("file.separator")+"computedContexts");

		runPcm2Lqn(model);

		long timeAfterTransform = System.nanoTime();
		long duration2 = TimeUnit.NANOSECONDS.toMillis(timeAfterTransform
				- timeBeforeTransform);
		overallDuration += duration2;
		logger.warn("Finished PCM2LQN:\t\t" + duration2 + " ms");
	}

	private void runPcm2Lqn(PCMInstance model) {

		LqnBuilder lqnBuilder = new LqnBuilder(
				config.isInfiniteTaskMultiplicity());

		if (getSolverProgramName().equals(FILENAME_LQSIM)) {
			lqnBuilder.setIsLQSimAnalysis(true);
		}

		ResourceEnvironment2Lqn reVisitor = new ResourceEnvironment2Lqn(
				lqnBuilder, config);
		reVisitor.doSwitch(model.getResourceEnvironment());

		UsageModel2Lqn umVisitor = new UsageModel2Lqn(lqnBuilder,
				new ContextWrapper(model));
		umVisitor.doSwitch(model.getUsageModel());

		lqnBuilder.finalizeLqnModel(config);

		LqnXmlHandler lqnXmlHandler = new LqnXmlHandler(
				lqnBuilder.getLqnModel());
		lqnXmlHandler.saveModelToXMI(filenameInputXML);

		Pcm2LqnHelper.clearGuidMap();
		runLqn2Xml();
		runLqn2XmlReformat();

	}

	/**
	 * Converts the resulting XML file back to the old LQN file format.
	 */
	private void runLqn2Xml() {
		try {

			ProcessBuilder pb = new ProcessBuilder(
					splitToCommandArray(FILENAME_LQN2XML + " -o" + filenameLQN
							+ " -Oxml " + filenameInputXML));
			pb.redirectErrorStream(true);
			// Process proc = Runtime.getRuntime().exec(
			// FILENAME_LQN2XML+" -o" + FILENAME_LQN +
			// " -Oxml " + FILENAME_INPUT_XML);

			// StreamGobbler errorGobbler = new StreamGobbler(proc
			// .getErrorStream(), "ERROR");
			// StreamGobbler outputGobbler = new StreamGobbler(proc
			// .getInputStream(), "OUTPUT");
			// errorGobbler.start();
			// outputGobbler.start();

			Process proc = pb.start();

			this.readStream(proc.getInputStream());

			int exitVal = proc.waitFor();
			proc.destroy();

			if (exitVal == 0) {
				logger.info("lqn2xml terminated successfully");
			} else {
				logger.error("lqn2xml terminated unsuccessfully. Exit value was "
						+ exitVal + ".");
			}

		} catch (Throwable e) {
			logger.error("lqn2xml terminated unsuccessfully. Exception "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Performs a reformat of the resulting XML file in order to produce XML
	 * which can be processed from lqns. This is done utilizing lqn2xml. Without
	 * the reformat lqns don't like the XML file and will probably return an
	 * error.
	 * <p>
	 * The reformatted file will be written to {@link #filenameResultXML}.
	 */
	private void runLqn2XmlReformat() {
		try {
			ProcessBuilder pb = new ProcessBuilder(
					splitToCommandArray(FILENAME_LQN2XML + " -o"
							+ filenameResultXML + " -Oxml " + filenameInputXML));
			pb.redirectErrorStream(true);

			// Process proc = Runtime.getRuntime().exec(
			// FILENAME_LQN2XML+" -o" + FILENAME_RESULT_XML +
			// " -Oxml " + FILENAME_INPUT_XML);
			//
			Process proc = pb.start();

			// StreamGobbler errorGobbler = new StreamGobbler(proc
			// .getErrorStream(), "ERROR");
			// StreamGobbler outputGobbler = new StreamGobbler(proc
			// .getInputStream(), "OUTPUT");
			// errorGobbler.start();
			// outputGobbler.start();

			this.readStream(proc.getInputStream());

			int exitVal = proc.waitFor();
			proc.destroy();

			if (exitVal == 0) {
				logger.info("lqn2xml terminated sucessfully");
			} else {
				logger.warn("lqn2xml terminated unsuccessfully. Exit value was "
						+ exitVal + ".");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void runDSolver(PCMInstance model) {
		// TODO: fix this (only uses one usage scenario):
		UsageModelVisitor visitor = new UsageModelVisitor(model);
		List<UsageScenario> scenarios = model.getUsageModel()
				.getUsageScenario_UsageModel();
		for (UsageScenario usageScenario : scenarios) {
			visitor.doSwitch(usageScenario.getScenarioBehaviour_UsageScenario());
		}
	}

	/**
	 * Read stream.
	 *
	 * @param is the is
	 * @return the concatenated String of all error messages encountered during
	 * the analysis
	 */
	private String readStream(InputStream is) {
		String errorMessages = "";
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				// if (type.equals("ERROR")) logger.error(line);
				if (line.contains("warning")) {
					if (isDebug()) {
						logger.debug(line);
					}
					// else do not log.
				} else {
					logger.warn(line);
					errorMessages += line + "\n";
				}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return errorMessages;
	}

	private String[] splitToCommandArray(String command) {
		return command.split("\\s");
	}

	// FIXME: This is not a good way to remove get the debugging statements. Fix
	// this when introducing a better configuration concept here.
	private boolean isDebug() {
		int level = config.getDebugLevel();
		if (level <= 1) {
			return true;
		} else
			return false;

		// case 0:
		// return Level.TRACE;
		// case 1:
		// return Level.DEBUG;
		// case 2:
		// return Level.INFO;
		// case 3:
		// return Level.WARN;
		// case 4:
		// return Level.ERROR;
		// case 5:
		// return Level.ALL;
		// default:
		// return Level.INFO;
	}

	public String getFilenameInputXML() {
		return filenameInputXML;
	}



}

// TODO: Anne: delete this method and the related comments above if the changes
// (to use ProcessBuilder and a single threaded reading out of the output) has
// proved useful.
@Deprecated
class StreamGobbler extends Thread {

	private static Logger logger = Logger.getLogger(StreamGobbler.class
			.getName());

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
				// if (type.equals("ERROR")) logger.error(line);
				if (line.contains("warning")) {
					logger.debug(line);
				} else {
					logger.warn(line);
				}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}


}

