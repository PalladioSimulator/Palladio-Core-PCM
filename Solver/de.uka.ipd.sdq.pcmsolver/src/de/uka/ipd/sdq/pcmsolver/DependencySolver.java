/**
 * 
 */
package de.uka.ipd.sdq.pcmsolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.ExpressionPrinter;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.TransformUsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.visualisation.JFVisualisation;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.spa.expression.Expression;

/**
 * TODO: It seems that this class is never used, and the functionality expected here is implemented elsewhere. 
 * 
 * The DependencySolver (DS) is a tool to substitute parameter names inside PCM
 * stochastic expressions with characterisations originating from the usage
 * model. In the usage model, the domain expert has to specify a variable
 * characterisation (e.g., a constant or probability distribution) for each
 * RequiredCharacterisation specified by component developers in Interfaces (see
 * Chapter 4.1.4 of Heiko's dissertation).
 * 
 * The DS propagates these characterisations through all elements of a PCM
 * instance and inserts them into guard specifications, parametric loop
 * iterations, parametric resource demands, and parameter usages specified by
 * the component developer. Then, it solves the resulting stochastic
 * expressions, so that they become constant values or probability
 * distributions, and stores them, so that they can be used for a transformation
 * into a performance model.
 * 
 * The subsection on the dependencySolver in Heiko's dissertation first
 * describes the expected input and produced output of the DS. Then, it
 * describes the traversal of PCM instances, which depends on the evaluated
 * parameter characterisations. Finally, it shows the process of solving
 * dependencies, before giving an example.
 * 
 * @see Heiko's dissertation, section 6.2 at
 *      http://docserver.bis.uni-oldenburg.de
 *      /_publikationen/dissertation/2008/kozpar08/pdf/kozpar08.pdf
 * @author Koziolek
 * 
 */
public class DependencySolver {

	private static final int DOMAIN_SIZE = 32;

	private static final double DISTANCE = 0.1;

	
	protected IProbabilityFunctionFactory iProbFuncFactory = 
		IProbabilityFunctionFactory.eINSTANCE;
	
	private Properties config;
	private PCMInstance currentModel;
	private static Logger logger = 
		Logger.getLogger(DependencySolver.class.getName());

	public DependencySolver(Properties config){
		this.config = config;
		logger.debug("Loading PCM Instance");
		currentModel = new PCMInstance(config);
		
		runDSolver();
		
		Expression result = runPcm2RegEx();
		
		//IProbabilityDensityFunction iPDF = runCalculation(result);
		
		//visualize(iPDF);
		
	}


	public DependencySolver(ILaunchConfiguration configuration){
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %c - %m%n");
		ConsoleAppender myAppender = new ConsoleAppender(myLayout);
		BasicConfigurator.configure(myAppender);
		
		//currentModel = new PCMInstance(configuration);
		
		runDSolver();
		
		Expression result = runPcm2RegEx();
		
		//IProbabilityDensityFunction iPDF = runCalculation(result);
		
		//visualize(iPDF);
		
	}
	
	
	
	
	/**
	 * @param result
	 */
	private IProbabilityDensityFunction runCalculation(Expression result) {
		long timeBeforeCalc = System.nanoTime();
//		ClassicSPASolver solver = new ClassicSPASolver();
//		ManagedPDF resultPDF = solver.getResponseTime(result);
		
//		PerformanceHandlerFactory perfHandFac = new PerformanceHandlerFactory(DOMAIN_SIZE);
//		PerformanceVisitor perfVisitor = new PerformanceVisitor(perfHandFac);
//		IProbabilityDensityFunction iPDF = perfVisitor.getResponseTime(result);
		
		long timeAfterCalc = System.nanoTime();
		long duration3 = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc-timeBeforeCalc);
		logger.debug("Finished Calculation, Duration: "+ duration3 + " ms");
//		return iPDF;
		//return resultPDF.getPdfTimeDomain();
		return null;
	}

	/**
	 * @param iPDF
	 */
	private void visualize(IProbabilityDensityFunction iPDF) {
		long timeBeforeVis = System.nanoTime();
		ISamplePDF samplePDF = null;
		try {
			samplePDF = iProbFuncFactory.transformToSamplePDF(iPDF);
		} catch (UnknownPDFTypeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
			//JFVisualisation vis = new JFVisualisation(DISTANCE);
			double dist = 0.0;
			try {
				dist = PDFConfiguration.getCurrentConfiguration().getDistance();
			} catch (ConfigurationNotSetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JFVisualisation vis = new JFVisualisation(dist);
			vis.addSamplePDF(samplePDF,"Execution Time");
			vis.visualizeOverlay();
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
		}
		long timeAfterVis = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterVis-timeBeforeVis);
		logger.debug("Finished Visualisati on, Duration: "+ duration + " ms");
		
	}

	/**
	 * @return
	 */
	private Expression runPcm2RegEx() {
		long timeBeforeTransform = System.nanoTime();
		Expression result = pcm2RegEx(currentModel);
		long timeAfterTransform = System.nanoTime();
		long duration2 = TimeUnit.NANOSECONDS.toMillis(timeAfterTransform-timeBeforeTransform);
		logger.debug("Finished Transform, Duration: "+ duration2 + " ms");
		return result;
	}

	/**
	 * 
	 */
	private void runDSolver() {
		long startTime = System.nanoTime();
		visitScenarioEMFSwitch();
		currentModel.saveToFiles("SolvedDSolverExample1");
		long timeAfterDSolve = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterDSolve-startTime);
		logger.debug("Finished Traversal, Saving; Duration: "+ duration + " ms");
	}

	/**
	 * 
	 */
	private Expression pcm2RegEx(PCMInstance currentModel) {
		TransformUsageModelVisitor umVisit = new TransformUsageModelVisitor(currentModel);
		UsageScenario us = (UsageScenario)currentModel.getUsageModel().getUsageScenario_UsageModel().get(0);
		Expression result = null;
		try {
			result = (Expression)umVisit.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
		}
		
		ExpressionPrinter expPrinter = new ExpressionPrinter();
		expPrinter.doSwitch(result);
		System.out.println();
		
		return result;
	}

	private void visitScenarioEMFSwitch(){
		UsageModelVisitor visitor = new UsageModelVisitor(currentModel);
		try {
			UsageScenario us = (UsageScenario) currentModel.getUsageModel()
					.getUsageScenario_UsageModel().get(0);
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		configureLogger();
		DependencySolver dsolver = new DependencySolver(getConfig(args));
	}

	private static void configureLogger() {
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %c - %m%n");
		ConsoleAppender myAppender = new ConsoleAppender(myLayout);
		BasicConfigurator.configure(myAppender);
	}

	public static Properties getConfig(String[] args) {
		Properties configFromFile = new Properties();
		if (args.length != 1) {
			System.out.println("Usage: DependencySolver <configfile.xml>");
			System.exit(-1);
		} else {
			// read XML configuration file
			configFromFile = new Properties();
			try {
				FileInputStream fis = new FileInputStream(args[0]);
				configFromFile.loadFromXML(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return configFromFile;
	}

}
