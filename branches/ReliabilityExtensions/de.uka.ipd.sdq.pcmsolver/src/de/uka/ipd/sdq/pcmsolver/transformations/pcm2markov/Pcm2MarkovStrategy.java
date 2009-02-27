package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.markovsolver.MarkovSolver;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;

/**
 * This class performs a transformation from a PCM instance to a Markov Chain
 * instance, and solves the resulting Markov Chain instance.
 * 
 * @author brosch
 * 
 */
public class Pcm2MarkovStrategy implements SolverStrategy {

	/**
	 * A logger to give detailed information about the PCM instance
	 * transformation.
	 */
	private static Logger logger = Logger.getLogger(Pcm2MarkovStrategy.class
			.getName());

	/**
	 * Reference to an EMF utility class.
	 */
	private static EMFHelper helper = new EMFHelper();

	/**
	 * The Markov Chain instance that results from the transformation of the PCM
	 * instance.
	 */
	private MarkovChain markovChain;

	/**
	 * The solving value of the resulting Markov Chain instance.
	 */
	private double solvedValue;

	/**
	 * Counts performed Markov transformation runs.
	 */
	private long transformationRunCount;

	/**
	 * The constructor.
	 */
	public Pcm2MarkovStrategy() {

		// Initialize the Markov Chain with a default value:
		markovChain = new MarkovBuilder().initNewMarkovChain("");
	}

	/**
	 * Retrieves the value that results from solving the Markov Chain instance.
	 * 
	 * @return the resulting value
	 */
	public double getSolvedValue() {
		return solvedValue;
	}

	/**
	 * Loads an already existing Markov Chain from a given XMI file. Not yet
	 * implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file
	 */
	public void loadTransformedModel(final String fileName) {
	}

	/**
	 * Solves the Markov Chain which has been created as a result of the
	 * transformation or has been loaded from an XMI file.
	 */
	public void solve() {

		// Record the time consumed for solving the Markov Chain:
		long startTime = System.nanoTime();

		// Solving of Markov Chain has already taken place during the
		// transformation.

		// Let the user know about the time consumed and the result:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger.info("Solved Markov Chain:\t\t\t" + duration + " ms");
		logger.info("Probability of Success:\t\t\t" + solvedValue);
	}

	/**
	 * Saves the Markov Chain resulting from the transformation into an XMI
	 * file. Not yet implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file to create
	 */
	public void storeTransformedModel(final String fileName) {
	}

	/**
	 * Transforms a PCM instance into a Markov Chain instance. The
	 * transformation is performed in two steps. In the first step, parametric
	 * dependencies within the PCM instance are solved using the dependency
	 * solver. The resulting PCM instance is then transformed into a Markov
	 * Chain.
	 * 
	 * @param model
	 *            the input PCM instance
	 */
	public void transform(final PCMInstance model) {

		// As a first step, solve parametric dependencies of the PCM instance:
		runDSolver(model);

		// Second, the PCM instance is transformed into a Markov Chain instance:
		runPcm2Markov(model);
	}

	/**
	 * Solves all parametric dependencies within a given PCM instance.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	private void runDSolver(final PCMInstance model) {

		// Record the time consumed for solving parametric dependencies:
		long startTime = System.nanoTime();

		// The parametric dependencies are solved by using a visitor:
		UsageModelVisitor visitor = new UsageModelVisitor(model);

		try {

			// The dependency solver supports only solving a single
			// usage scenario (08-2008):
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);

			// Solve the PCM instance using the visitor:
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());

		} catch (Exception e) {

			// The parametric dependencies could not be solved:
			logger
					.error("Solving of parametric dependencies caused Exception: "
							+ e.getMessage());
			e.printStackTrace();
		}

		// Let the user know about the time consumed:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger.info("Solved parametric dependencies:\t\t" + duration + " ms");
	}

	/**
	 * Transforms the given PCM instance into a Markov Chain instance. The PCM
	 * instance is assumed to have all parametric dependencies solved.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	private void runPcm2Markov(final PCMInstance model) {

		// Record the time consumed for creating the Markov Chain instance:
		long startTime = System.nanoTime();

		// Record the number of performed transformation runs:
		transformationRunCount = 0;

		// Build the list of resource descriptors:
		List<ProcessingResourceDescriptor> descriptors = buildResourceDescriptors(model);

		// Initialize the solved value:
		solvedValue = 0.0;

		try {

			// Count the states of the Markov Chain to build:
			countMarkovStates(model, descriptors);

			// Repeatedly run the transformation for all possible state
			// combinations:
			runPcm2MarkovRecursively(model, descriptors, 0, 1.0);

		} catch (Exception e) {
			logger.error("PCM 2 Markov transformation caused exception: "
					+ e.getMessage() + " [" + e.getClass() + "]");
			e.printStackTrace();
		}

		// Let the user know about the time consumed:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger.info("Finished Markov transformation:\t\t" + duration + " ms");
		logger.info("Number of performed transformation runs:\t"
				+ transformationRunCount);
	}

	/**
	 * Performs the Markov Transformation once, just to count the number of
	 * states in the chain.
	 * 
	 * @param model
	 *            the model which is to be transformed
	 * @param descriptors
	 *            the resource descriptors
	 */
	private void countMarkovStates(final PCMInstance model,
			final List<ProcessingResourceDescriptor> descriptors) {

		// The Markov Chain instance is created by using a visitor:
		MarkovUsageModelVisitor umVisit = new MarkovUsageModelVisitor(model,
				descriptors, false);

		// The transformation supports only solving a single
		// usage scenario (08-2008):
		UsageScenario us = (UsageScenario) model.getUsageModel()
				.getUsageScenario_UsageModel().get(0);

		// Perform the Markov Chain transformation:
		markovChain = (MarkovChain) umVisit.doSwitch(us
				.getScenarioBehaviour_UsageScenario());

		// Display information to the user:
		logger.info("Number of states in Markov Chain:\t"
				+ markovChain.getStates().size());
		logger.info("Number of transitions in Markov Chain:\t"
				+ markovChain.getTransitions().size());
	}

	/**
	 * Runs the PCM 2 Markov transformation for all possible combinations of
	 * states of resources.
	 * 
	 * @param model
	 *            the PCM instance
	 * @param descriptors
	 *            the resource descriptors
	 * @param index
	 *            the current resource state manipulation level
	 * @param currentProbability
	 *            the probability of the current resource state combination
	 */
	private void runPcm2MarkovRecursively(final PCMInstance model,
			final List<ProcessingResourceDescriptor> descriptors,
			final int index, final double currentProbability) {

		// Check for the base case:
		if (index == descriptors.size()) {

			// The Markov Chain instance is created by using a visitor:
			MarkovUsageModelVisitor umVisit = new MarkovUsageModelVisitor(
					model, descriptors);

			// The transformation supports only solving a single
			// usage scenario (08-2008):
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);

			// Create the Markov Chain instance using the visitor:
			markovChain = (MarkovChain) umVisit.doSwitch(us
					.getScenarioBehaviour_UsageScenario());

			// Update the transformation runs counter:
			transformationRunCount++;

			// Solve the Markov Chain, and add the result to the overall success
			// probability, weighted by the probability of the current resource
			// state combination:
			double result = new MarkovSolver().solve(markovChain);
			solvedValue += result * currentProbability;

			// Base case finished:
			return;
		}

		// Consider all possible resource states:
		for (ProcessingResourceState state : ProcessingResourceState.values()) {

			// Get the probability of this state for the resource:
			descriptors.get(index).setCurrentState(state);
			Double newProbability = descriptors.get(index).getStateProbability(
					state);

			// If no MTTF/MTTR have been specified for the resource, assume that
			// the resource never breaks down:
			if ((newProbability == null) || (newProbability.isNaN())) {
				newProbability = (state.equals(ProcessingResourceState.OK)) ? 1.0
						: 0.0;
			}

			// Consider the next resource and its possible states:
			if (newProbability != 0.0) {
				runPcm2MarkovRecursively(model, descriptors, index + 1,
						currentProbability * newProbability);
			}
		}
	}

	/**
	 * Builds a list of resource descriptors based on a given PCM instance.
	 * 
	 * @param model
	 *            the given PCM instance
	 * @return the list of resource descriptors
	 */
	private List<ProcessingResourceDescriptor> buildResourceDescriptors(
			final PCMInstance model) {

		// Create the result list:
		ArrayList<ProcessingResourceDescriptor> resultList = new ArrayList<ProcessingResourceDescriptor>();

		// Search for PCM resource containers:
		EList<EObject> resourceContainers = helper.getElements(model
				.getResourceEnvironment(), ResourceenvironmentFactory.eINSTANCE
				.createResourceContainer().eClass());

		// Go through the resource container list:
		for (int i = 0; i < resourceContainers.size(); i++) {

			// Reference the container:
			ResourceContainer container = (ResourceContainer) resourceContainers
					.get(i);

			// Special case: ignore resource containers with the name
			// "SystemExternalResourceContainer", as they have been internally
			// created by the dependency solver:
			if (container.getEntityName().equals(
					"SystemExternalResourceContainer")) {
				continue;
			}

			// Go through the list of resources in the container:
			for (ProcessingResourceSpecification resource : container
					.getActiveResourceSpecifications_ResourceContainer()) {

				// Special case: Ignore resource specifications

				// Each resource has a type and MTTF/MTTR values:
				Double resourceMTTF = resource.getMTTF();
				Double resourceMTTR = resource.getMTTR();
				ProcessingResourceType type = resource
						.getActiveResourceType_ActiveResourceSpecification();

				// Check the proper MTTF/MTTR specification:
				if (resourceMTTF < 0.0) {
					logger
							.warn("Improper MTTF/MTTR specification for resource "
									+ type.getEntityName()
									+ " in container "
									+ container.getEntityName()
									+ ": negative MTTF. Assuming MTTF = 0.0");
					resourceMTTF = 0.0;
				}
				if (resourceMTTR < 0.0) {
					logger
							.warn("Improper MTTF/MTTR specification for resource "
									+ type.getEntityName()
									+ " in container "
									+ container.getEntityName()
									+ ": negative MTTR. Assuming MTTR = 0.0");
					resourceMTTR = 0.0;
				}
				if ((resourceMTTF == 0.0) && (resourceMTTR == 0.0)) {
					logger
							.warn("Improper MTTF/MTTR specification for resource "
									+ type.getEntityName()
									+ " in container "
									+ container.getEntityName()
									+ ": Both values are 0. Assuming that resource is always ok");
				}

				// Generate a new descriptor:
				ProcessingResourceDescriptor descriptor = new ProcessingResourceDescriptor();
				descriptor.setResourceContainerId(container.getId());
				descriptor.setProcessingResourceTypeId(type.getId());
				descriptor.setStateProbability(ProcessingResourceState.OK,
						resourceMTTF / (resourceMTTF + resourceMTTR));
				descriptor.setStateProbability(ProcessingResourceState.NA,
						resourceMTTR / (resourceMTTF + resourceMTTR));
				resultList.add(descriptor);
			}
		}

		// Return the result:
		return resultList;
	}
}
