package de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex;

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
import de.uka.ipd.sdq.spa.expression.Expression;

public class Pcm2RegExStrategy implements SolverStrategy {

	Expression stoRegEx;

	protected IProbabilityFunctionFactory iProbFuncFactory = 
		IProbabilityFunctionFactory.eINSTANCE;
	
	private static Logger logger = Logger.getLogger(Pcm2RegExStrategy.class.getName());
	
	public void loadTransformedModel(String fileName) {
		// TODO Auto-generated method stub

	}

	public void solve() {
		if (stoRegEx != null){
			ExpressionSolver solver = new ExpressionSolver();
			ManagedPDF resultPDF = solver.getResponseTime(stoRegEx);
			visualize(resultPDF.getPdfTimeDomain());
		} else
			logger.error("No StochasticRegularExpression available for solution!");
	}

	public void storeTransformedModel(String fileName) {
	}

	public void transform(PCMInstance model) {
		runDSolver(model);
		runPcm2RegEx(model);
		printStoRegEx();
	}

	private void printStoRegEx() {
		ExpressionPrinter expPrinter = new ExpressionPrinter();
		expPrinter.doSwitch(stoRegEx);
		logger.info("ExpressionPrinter: "+expPrinter.getOutput());
	}

	private void runPcm2RegEx(PCMInstance model) {
		TransformUsageModelVisitor umVisit = new TransformUsageModelVisitor(model);
		UsageScenario us = (UsageScenario)model.getUsageModel().getUsageScenario_UsageModel().get(0);
		try {
			stoRegEx = (Expression)umVisit.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void runDSolver(PCMInstance model) {
		UsageModelVisitor visitor = new UsageModelVisitor(model);
		try {
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());
		} catch (Exception e) {
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
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
