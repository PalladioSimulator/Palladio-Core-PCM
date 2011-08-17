/**
 *
 */
package de.fzi.se.accuracy.issues;

import org.eclipse.emf.ecore.EObject;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.SeverityEnum;

/**
 * Factory to create accuracy influence analysis issues.
 *
 * @author groenda
 */
public class AccuracyIssueFactory {

	/**Creates a new missing quality annotation issue for EObjects.
	 * @param object The object for which no quality annotation was found.
	 * @return the issue.
	 */
	public static SeverityAndIssue createMissingQualityAnnotationIssue(
			EObject object) {
		return new SeverityAndIssue(
				SeverityEnum.WARNING,
				"No information on the quality was provided for the RDSEFF. Assuming a quality of ExactlyAsSpecifiedPrecision. This assumption may lead to prediction errors.",
				object);
	}

	/**Creates a new missing quality annotation issue for Objects which are not EObjects.
	 * @param resourceName The location of the resource.
	 * @param rdseffId UUID of the RD-SEFF.
	 * @return the issue.
	 */
	public static SeverityAndIssue createMissingQualityAnnotationIssue(
			String resourceName, String rdseffId) {
		return new RDSEFFSourceCodeIssue(
				SeverityEnum.WARNING,
				"No information on the quality was provided for the RDSEFF. Assuming a quality of ExactlyAsSpecifiedPrecision. This assumption may lead to prediction errors.",
				null, resourceName, rdseffId);
	}

	/**Creates a new invalid quality annotation issue.
	 * @param object The object for which the quality annotation was invalid.
	 * @return the issue.
	 */
	public static SeverityAndIssue createInvalidQualityAnnotationIssue(
			EObject object) {
		return new SeverityAndIssue(
				SeverityEnum.WARNING,
				"The quality information provided for the RDSEFF was invalid. Assuming a quality of ExactlyAsSpecifiedPrecision. This assumption may lead to prediction errors.",
				object);
	}

	/**Create a new parameter extrapolation issue.
	 * @param variableReference Identifier of the variable (including the variable's namespace).
	 * @param characterization The characterization of the variable
	 * @param rdseffId ID of the RD-SEFF in which the variable was used.
	 * @param resourceName The location of the resource.
	 * @param actualValue The actual experienced value which lead to the issue.
	 * @return new issue.
	 */
	public static SeverityAndIssue createParameterExtrapolationIssue(
			String variableReference, String rdseffId, String resourceName,
			Object actualValue, String actionId) {
		return new VariableSourceCodeIssue(
				SeverityEnum.WARNING,
				"The experienced parameter value was outside of the provided accuracy bounds. The experienced value is used nonetheless. This extrapolation may lead to prediction errors.",
				actualValue,
				resourceName,
				rdseffId,
				actionId,
				variableReference);
	}

	/**Creates a new type inference issue.
	 * @return new issue.
	 */
	public static SeverityAndIssue createTypeInferenceIssue(String msg) {
		return new SeverityAndIssue(SeverityEnum.ERROR, msg, null);
	}

	/**Creates a new issue for {@link CharacterisedPCMParameterPartition}.
	 * @param msg The message.
	 * @param objectResourceName The resource in which the message occurred.
	 * @param partitionId The UUID of the partition.
	 * @return new issue.
	 */
	public static SeverityAndIssue createCharacterisedPCMParameterPartition(String msg, String objectResourceName, String partitionId) {
		return new CharacterisedPCMParameterPartitionSourceCodeIssue(SeverityEnum.ERROR, msg, null, objectResourceName, partitionId);
	}
}
