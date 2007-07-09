package de.uka.ipd.sdq.pcmsolver;

import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList.Basic;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import de.uka.ipd.sdq.dsolver.UsageModelVisitor;
import de.uka.ipd.sdq.exprsolver.ExpressionSolver;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm2regex.ExpressionPrinter;
import de.uka.ipd.sdq.pcm2regex.TransformUsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
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
	
	public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain";

	
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
	.getEditingDomain(EDITING_DOMAIN_ID);

	
	public PCMSolver(ILaunchConfiguration configuration, IProgressMonitor monitor){
		this.monitor = monitor;
		
		configureLogging();
		
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
//		ResourceSet set = editingDomain.getResourceSet();
//		EcoreUtil.getObjectByType(, arg1)
		
		monitor.beginTask("Analysis", 100);
		
		runDSolver();
		monitor.worked(33);
		
		Expression result = runPcm2RegEx();
		monitor.worked(33);
		
		IProbabilityDensityFunction iPDF = runCalculation(result);

		ManagedPDF resultPDF = new ManagedPDF(iPDF);
		System.out.println(resultPDF);
		
		monitor.worked(33);
		
		monitor.done();
		
		visualize(iPDF);
	}

	private void configureLogging() {
		MessageConsole console = new MessageConsole("PCM Solver Console: Analysis Tool Output", null);
		console.activate();
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{ console });
		MessageConsoleStream stream = console.newMessageStream();
		
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %c - %m%n");
		WriterAppender writerAppender = new WriterAppender(myLayout, stream);
		BasicConfigurator.configure(writerAppender);
	}
	
	private void runDSolver() {
		long startTime = System.nanoTime();
		visitScenarioEMFSwitch();
		currentModel.saveToFiles("SolvedDSolverExample1");
		long timeAfterDSolve = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterDSolve-startTime);
		logger.debug("Finished Traversal, Saving; Duration: "+ duration + " ms");
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
		logger.debug("Finished Transform, Duration: "+ duration2 + " ms");
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
		logger.debug("ExpressionPrinter: "+expPrinter.getOutput());
		
		return result;
	}
	
	private IProbabilityDensityFunction runCalculation(Expression result) {
		long timeBeforeCalc = System.nanoTime();

		ExpressionSolver solver = new ExpressionSolver();
		ManagedPDF resultPDF = solver.getResponseTime(result);
		
		long timeAfterCalc = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc-timeBeforeCalc);
		logger.debug("Finished Calculation, Duration: "+ duration + " ms");
		
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
		//logger.debug("Finished Visualisation, Duration: "+ duration + " ms");
	}
	
}
