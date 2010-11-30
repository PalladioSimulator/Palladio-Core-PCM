package de.uka.ipd.sdq.reliability.solver.pcm2markov;


/**
 * Describes a point of failure in a PCM model.
 * 
 * @author brosch
 * 
 */
public class FailureDescription {

	/**
	 * Creates a FailureDescription for an application failure.
	 * 
	 * @param failureName
	 *            the name of the application failure type
	 * @param failureId
	 *            the id of the application failure type
	 * @param failureProbability
	 *            the probability of the failure
	 * @return a corresponding FailureDescription.
	 */
	public static FailureDescription createApplicationFailureDescription(
			final String failureName, final String failureId,
			final double failureProbability) {

		// Create an environment failure type:
		MarkovApplicationFailureType failureType = new MarkovApplicationFailureType();
		failureType.setName(failureName);
		failureType.setId(failureId);

		// Return the result:
		return new FailureDescription(failureType, failureProbability);
	}

	/**
	 * Creates a FailureDescription for an environment failure.
	 * 
	 * @param resourceName
	 *            the name of the failing resource type
	 * @param resourceId
	 *            the id of the failing resource type
	 * @param failureProbability
	 *            the probability of the failure
	 * @return a corresponding FailureDescription.
	 */
	public static FailureDescription createEnvironmentFailureDescription(
			final String resourceName,
			final String resourceId,
			final double failureProbability) {

		// Create an environment failure type:
		MarkovProcessingResourceType resourceType = new MarkovProcessingResourceType();
		resourceType.setName(resourceName);
		resourceType.setId(resourceId);
		MarkovEnvironmentFailureType failureType = new MarkovEnvironmentFailureType();
		failureType.setResourceType(resourceType);

		// Return the result:
		return new FailureDescription(failureType, failureProbability);
	}

	/**
	 * The probability of failure.
	 */
	private double failureProbability;

	/**
	 * The type of failure.
	 */
	private MarkovFailureType failureType;

	/**
	 * Creates a new FailureDescription.
	 * 
	 * @param type
	 *            the type of failure
	 * @param probability
	 *            the probability of failure
	 */
	private FailureDescription(final MarkovFailureType type, final double probability) {
		this.failureType = type;
		this.failureProbability = probability;
	}

	/**
	 * Retrieves the probability of failure.
	 * 
	 * @return the probability of failure
	 */
	public final double getFailureProbability() {
		return failureProbability;
	}

	/**
	 * Retrieves the type of failure.
	 * 
	 * @return the type of failure
	 */
	public final MarkovFailureType getFailureType() {
		return failureType;
	}
}
