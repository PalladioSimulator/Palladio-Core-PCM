package de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.exprsolver.ExpressionSolver;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
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
import de.uka.ipd.sdq.probfunction.print.ProbFunctionCSVPrint;
import de.uka.ipd.sdq.spa.expression.Expression;

public class Pcm2RegExStrategy implements SolverStrategy {

	Expression stoRegEx;

	protected IProbabilityFunctionFactory iProbFuncFactory = 
		IProbabilityFunctionFactory.eINSTANCE;
	
	private static Logger logger = Logger.getLogger(Pcm2RegExStrategy.class.getName());
	
	private long overallDuration = 0;
	
	public void loadTransformedModel(String fileName) {
		// TODO Auto-generated method stub

	}

	public void solve() {
		if (stoRegEx != null){
			long timeBeforeCalc = System.nanoTime();
			ExpressionSolver solver = new ExpressionSolver();
			ManagedPDF resultPDF = solver.getResponseTime(stoRegEx);
			
			if(resultPDF == null){
				logger.error("StochasticRegularExpression could not be solved!");
				return;
			}
			
			long timeAfterCalc = System.nanoTime();
			long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc-timeBeforeCalc);
			overallDuration += duration;
			logger.info("Finished Running ExprSolver:\t"+ duration + " ms");
			logger.debug("Resulting PDF:\t\t\t"+resultPDF.toString());
			logger.trace("As csv:\n\nx;probability\n"+new ProbFunctionCSVPrint().doSwitch(resultPDF.getModelBoxedPdf()));
			
			visualize(resultPDF.getPdfTimeDomain());
			long timeAfterVisualisation = System.nanoTime();
			duration = TimeUnit.NANOSECONDS.toMillis(timeAfterVisualisation-timeAfterCalc);
			overallDuration += duration;
			logger.info("Finished Visualisation:\t\t"+ duration + " ms");
			logger.info("Finished SRE-Solver:\t\t"+ overallDuration+ " ms");
			
		} else
			logger.error("No StochasticRegularExpression available for solution!");
	}

	public void storeTransformedModel(String fileName) {
	}

	public void transform(PCMInstance model) {
		long timeBeforeCalc = System.nanoTime();
		runDSolver(model);
		runPcm2RegEx(model);
		printStoRegEx();
		
		long timeAfterCalc = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(timeAfterCalc-timeBeforeCalc);
		overallDuration += duration;
		logger.info("Finished Running PCM2SRE:\t\t"+ duration + " ms");
		
		
	}

	private void printStoRegEx() {
		ExpressionPrinter expPrinter = new ExpressionPrinter();
		expPrinter.doSwitch(stoRegEx);
		logger.debug("ExpressionPrinter: "+expPrinter.getOutput());
	}

	private void runPcm2RegEx(PCMInstance model) {
		TransformUsageModelVisitor umVisit = new TransformUsageModelVisitor(model);
		UsageScenario us = (UsageScenario)model.getUsageModel().getUsageScenario_UsageModel().get(0);
		try {
			stoRegEx = (Expression)umVisit.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Transforming the PCM instance into a stochastic regular expression caused an Exception! Check your model for broken references, e.g. old, dangling Connectors." + e.getMessage());
			e.printStackTrace();
			
			throw new RuntimeException(e);
		}
	}

	private void runDSolver(PCMInstance model) {
		UsageModelVisitor visitor = new UsageModelVisitor(model);
		try {
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Running the dependency solver caused an Exception! Check your model for broken references, e.g. old, dangling Connectors." + e.getMessage());
			e.printStackTrace();
			
			throw new RuntimeException(e);
		}
	}
	
	private void visualize(IProbabilityDensityFunction iPDF) {
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
	}

}
