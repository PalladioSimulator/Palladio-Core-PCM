package de.uka.ipd.sdq.pcmsolver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.exprsolver.ExpressionSolver;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.ExpressionPrinter;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.Pcm2RegExStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.TransformUsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.visualisation.JFVisualisation;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.spa.expression.Expression;

public class PCMSolver {

	protected IProbabilityFunctionFactory iProbFuncFactory = 
		IProbabilityFunctionFactory.eINSTANCE;
	
	private PCMInstance currentModel;
	private IProgressMonitor monitor;
	
	private static Logger logger = Logger.getLogger(PCMSolver.class.getName());
	
	private long overallDuration = 0;
	
	public PCMSolver(ILaunchConfiguration configuration, IProgressMonitor monitor){
		this.monitor = monitor;
		
		configureLogging(configuration);
		
		currentModel = new PCMInstance(configuration);
		
		try {
			int domainSize = Integer.parseInt(configuration.getAttribute("maxDomain", "32"));
			double distance = Double.parseDouble(configuration.getAttribute("samplingDist", "1.0"));
			PDFConfiguration.setCurrentConfiguration(domainSize, distance, iProbFuncFactory.createDefaultUnit());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void start(){

		if (!currentModel.isValid()){
			logger.error("PCM Instance invalid! Check filenames.");
			return;
		}

		
		SolverStrategy strat = new Pcm2RegExStrategy();
		

		monitor.beginTask("Analysis", 100);
		strat.transform(currentModel);
		monitor.worked(50);
		strat.solve();
		monitor.worked(50);
		

		
		logger.warn("Completed Analysis:\t\t"+ overallDuration + " ms overall");
	}

	private void configureLogging(ILaunchConfiguration configuration) {
		MessageConsole console = new MessageConsole("PCM Solver Console: Analysis Tool Output", null);
		//PCMSolverPatternMatchListener listener = new PCMSolverPatternMatchListener();
		//console.addPatternMatchListener(listener);
		
		console.activate();
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{ console });
		MessageConsoleStream stream = console.newMessageStream();
		//IOConsoleOutputStream stream = listener.getStream();
		//stream.setColor(new org.eclipse.swt.graphics.Color(Display.getCurrent(), 0, 255, 0));
		
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %c - %m%n");
		WriterAppender writerAppender = new WriterAppender(myLayout, stream);
		BasicConfigurator.configure(writerAppender);
		
		try {
			if (configuration.getAttribute("verboseLogging", false)){
				Logger.getRootLogger().setLevel(Level.DEBUG);
			} else {
				Logger.getRootLogger().setLevel(Level.WARN);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
	}
	
	private void runDSolver() {
		long startTime = System.nanoTime();
		visitScenarioEMFSwitch();

		// uncomment for debugging purposes:
		//currentModel.saveToFiles("SolvedDSolverExample1");
		
		long timeAfterDSolve = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterDSolve-startTime);
		overallDuration += duration;
		
		logger.warn("Finished DSolver:\t\t"+ duration + " ms");
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
	
	private Expression runPcm2RegEx() {
		long timeBeforeTransform = System.nanoTime();
		Expression result = pcm2RegEx(currentModel);
		long timeAfterTransform = System.nanoTime();
		long duration2 = TimeUnit.NANOSECONDS.toMillis(timeAfterTransform-timeBeforeTransform);
		overallDuration += duration2;
		logger.warn("Finished PCM2RegEx:\t\t"+ duration2 + " ms");
		return result;
	}
	
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
		logger.info("ExpressionPrinter: "+expPrinter.getOutput());
		
		return result;
	}
	
	private IProbabilityDensityFunction runCalculation(Expression result) {
		long timeBeforeCalc = System.nanoTime();

		ExpressionSolver solver = new ExpressionSolver();
		ManagedPDF resultPDF = solver.getResponseTime(result);
		
		long timeAfterCalc = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc-timeBeforeCalc);
		overallDuration += duration;
		logger.warn("Finished Calculation:\t"+ duration + " ms");
		
		return resultPDF.getPdfTimeDomain();
	}

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
		overallDuration += duration;
		logger.warn("Finished Visualisation:\t"+ duration + " ms");
	}
	
}
