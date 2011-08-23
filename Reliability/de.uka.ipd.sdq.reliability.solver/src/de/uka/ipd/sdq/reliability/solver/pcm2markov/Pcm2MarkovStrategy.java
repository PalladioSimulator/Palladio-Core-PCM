package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.Arrays;
import java.util.List;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.transformations.EMFHelper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.reliability.solver.sensitivity.MarkovSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.MultiSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.NetworkSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.ResourceMTTRSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.SoftwareSensitivity;

/**
 * This class performs a transformation from a PCM instance to a Markov Chain
 * instance, and solves the resulting Markov Chain instance.
 * 
 * @author brosch
 * 
 */
public class Pcm2MarkovStrategy implements SolverStrategy {

	/**
	 * Configuration properties for the reliability solver workflow.
	 */
	private PCMSolverWorkflowRunConfiguration configuration;

	/**
	 * The Markov transformation results (one result object for
	 * each PCM UsageScenario).
	 */
	private List<MarkovTransformationResult> markovResults;

	/**
	 * Captures a configuration for sensitivity analysis (temporary).
	 */
	private MarkovSensitivity markovSensitivity;

	/**
	 * The constructor.
	 * 
	 * @param configuration
	 *            launch configuration parameters
	 */
	public Pcm2MarkovStrategy(
			final PCMSolverWorkflowRunConfiguration configuration) {
		this.configuration = configuration;
		this.markovSensitivity = initSensitivityAnalysis();
	}

	/**
	 * Retrieves the Markov transformation results.
	 * 
	 * If the PCM instance has multiple usage scenarios, only the results for
	 * the first usage scenario are returned.
	 * 
	 * @return the Markov transformation results
	 */
	public MarkovTransformationResult getSolvedValue() {
		return (markovResults.size() > 0) ? markovResults.get(0) : null;
	}

	/**
	 * Loads an already existing Markov Chain from a given XMI file. Not yet
	 * implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file
	 */
	public void loadTransformedModel(final String fileName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Solves the Markov Chain which has been created as a result of the
	 * transformation or has been loaded from an XMI file.
	 */
	public void solve() {

		// Solving of Markov Chain has already taken place during the
		// transformation.

	}

	/**
	 * Saves the Markov Chain resulting from the transformation into an XMI
	 * file.
	 * 
	 * If the PCM instance has multiple usage scenarios, only the results for
	 * the first usage scenario are written into the file.
	 * 
	 * @param fileName
	 *            the name of the XMI file to create
	 */
	public void storeTransformedModel(final String fileName) {
		MarkovTransformationResult result = (markovResults.size() > 0) ? markovResults
				.get(0)
				: null;
		if (result != null) {
			EMFHelper.saveToXMIFile(result.getResultChain(), fileName);
		}
	}

	/**
	 * Transforms a PCM instance into a Markov Chain instance.
	 * 
	 * The transformation is performed either as a single transformation, or as
	 * a repeated transformation to perform sensitivity analysis.
	 * 
	 * @param model
	 *            the input PCM instance
	 */
	public void transform(final PCMInstance model) {
		markovResults = new MarkovTransformation().runTransform(model,
				configuration, markovSensitivity);
		if (configuration.isMarkovModelStorageEnabled()) {
			storeTransformedModel(configuration.getMarkovModelFile());
		}
	}

	/**
	 * Initializes sensitivity analysis parameters.
	 * 
	 * @return the sensitivity configuration; NULL if no sensitivity analysis
	 *         shall be performed
	 */
	private MarkovSensitivity initSensitivityAnalysis() {

////		 // Hardware MTTF uncertainty:
////		 MarkovSensitivity uncertainty = new MTTFSensitivity(
////				"UncertaintySensitivity", // (name)
////				Arrays.asList(new Double[]{315360000.0,177339960.3,99725588.3,56079819.5,31536000.0,17733996.0,9972558.8,5607981.9,3153600.0}), // 10 - 0.1 years
////		 		"C://temp//UncertaintySensitivity.txt"); // log file
//
////		 // Software uncertainty:
////		 MarkovSensitivity uncertainty = new SoftwareSensitivity(
////				 "UncertaintySensitivity", // (name)
////				 Arrays.asList(new Double[]{0.00000010,0.00000032,0.00000100,0.00000316,0.00001000,0.00003162,0.00010000,0.00031623,0.00100000}), // 10^(-7) - 10^(-3)
////		 		"C://temp//UncertaintySensitivity.txt"); // log file
//
//		// Network uncertainty:
//		MarkovSensitivity uncertainty = new NetworkSensitivity(
//				"UncertaintySensitivity", // (name)
//				Arrays.asList(new Double[] { 0.00000010, 0.00000032,0.00000100, 0.00000316, 0.00001000, 0.00003162,0.00010000, 0.00031623, 0.00100000 }), // 10^(-7) - 10^(-3)
//				"C://temp//UncertaintySensitivity.txt"); // log file
//
//		// Design alternative 1: High-reliability components
//		MarkovSensitivity alt1 = new SoftwareSensitivity(
//				"DesignAlt1Sensitivity", // (name)
//				Arrays.asList(new Double[] { 0.00001, 0.0, 0.00001 }), // (values)
//				"C://temp//DesignAlt1Sensitivity.txt"); // log file
//
//		// Design alternative 2: High-availability Servers
//		MarkovSensitivity alt2_1 = new ResourceMTTRSensitivity(
//				"MTTRSensitivity", // (name)
//				"_L0Dy4dpAEdyxgfK4Hy_RFA", // WebServer
//				"_oro4gG3fEdy4YaaT-RYrLQ", // CPU
//				Arrays.asList(new Double[] { 72000.0, 72000.0, 36000.0 }), // 10.0 hours
//				"C://temp//MTTRSensitivity.txt"); // log file
//		MarkovSensitivity alt2_2 = new ResourceMTTRSensitivity(
//				"MTTRSensitivity", // (name)
//				"_EX6xcdpAEdyxgfK4Hy_RFA", // SchedulerServer
//				"_oro4gG3fEdy4YaaT-RYrLQ", // CPU
//				Arrays.asList(new Double[] { 72000.0, 72000.0, 36000.0 }), // 10.0 hours
//				"C://temp//MTTRSensitivity.txt"); // log file
//		MarkovSensitivity alt2_3 = new ResourceMTTRSensitivity(
//				"MTTRSensitivity", // (name)
//				"_8-cpgNo_EdyxgfK4Hy_RFA", // ApplicationServerMain
//				"_oro4gG3fEdy4YaaT-RYrLQ", // CPU
//				Arrays.asList(new Double[] { 54000.0, 54000.0, 12000.0 }), // 3.3 hours
//				"C://temp//MTTRSensitivity.txt"); // log file
//		MarkovSensitivity alt2_4 = new ResourceMTTRSensitivity(
//				"MTTRSensitivity", // (name)
//				"_hYj24eWjEd--j947m9nMPA", // ApplicationServerBackup1
//				"_oro4gG3fEdy4YaaT-RYrLQ", // CPU
//				Arrays.asList(new Double[] { 54000.0, 54000.0, 12000.0 }), // 3.3 hours
//				"C://temp//MTTRSensitivity.txt"); // log file
//		MarkovSensitivity alt2_5 = new ResourceMTTRSensitivity(
//				"MTTRSensitivity", // (name)
//				"_j5W_seWjEd--j947m9nMPA", // ApplicationServerBackup2
//				"_oro4gG3fEdy4YaaT-RYrLQ", // CPU
//				Arrays.asList(new Double[] { 54000.0, 54000.0, 12000.0 }), // 3.3 hours
//				"C://temp//MTTRSensitivity.txt"); // log file
//		MarkovSensitivity alt2_6 = new ResourceMTTRSensitivity(
//				"MTTRSensitivity", // (name)
//				"_U2Nv4dpAEdyxgfK4Hy_RFA", // DatabaseServer
//				"_BIjHoQ3KEdyouMqirZIhzQ", // HDD
//				Arrays.asList(new Double[] { 36000.0, 36000.0, 12000.0 }), // 3.3 hours
//				"C://temp//MTTRSensitivity.txt"); // log file
//		MarkovSensitivity alt2_7 = new ResourceMTTRSensitivity(
//				"MTTRSensitivity", // (name)
//				"_U2Nv4dpAEdyxgfK4Hy_RFA", // DatabaseServer
//				"_oro4gG3fEdy4YaaT-RYrLQ", // CPU
//				Arrays.asList(new Double[] { 36000.0, 36000.0, 12000.0 }), // 3.3 hours
//				"C://temp//MTTRSensitivity.txt"); // log file
//		MarkovSensitivity alt2 = new MultiSensitivity("DesignAlt2Sensitivity",
//				Arrays.asList(new MarkovSensitivity[] { alt2_1, alt2_2, alt2_3,alt2_4, alt2_5, alt2_6, alt2_7 }),
//				false,
//				"C://temp//DesignAlt2Sensitivity.txt");
//
////		 // Design alternative 3: High-reliability Network
////		 MarkovSensitivity alt3 = new NetworkSensitivity(
////				"DesignAlt3Sensitivity", // (name)
////				Arrays.asList(new Double[]{0.000001,0.000001,0.0}), // sensitivity params
////		 		"C://temp//DesignAlt3Sensitivity.txt"); // log file
//
//		// Design alternatives:
//		MarkovSensitivity alt = new MultiSensitivity("DesignAlternatives",
//				Arrays.asList(new MarkovSensitivity[] { alt1, alt2 }), false,
//				"C://temp//DesignAlternatives.txt");
//
//		// Overall sensitivity:
//		return new MultiSensitivity("OverallSensitivity",
//				Arrays.asList(new MarkovSensitivity[] { uncertainty, alt }), true,
//				"C://temp//OverallSensitivity.txt");

		return null;
	}
}