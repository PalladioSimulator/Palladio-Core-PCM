/**
 * 
 */
package de.fzi.se.quality.util;

import java.util.Arrays;
import java.util.List;

import de.fzi.se.quality.qualityannotation.ServiceSpecification;

/**Contains general utilities used for the validation of performance specifications.
 * Provides checksum calculation algorithms.
 * 
 * @author groenda
 */
public class ValidationUtilities {
	/** List of available data type converters. */
	public static List<SpecificationChecksumCalculator> calculators = 
			Arrays.asList((SpecificationChecksumCalculator) new Checksum_PCM_10());

	/**Calculates the checksum for the given specification with a calculator for the given identifier.
	 * @param specification The performance specification.
	 * @param algorithmIdentifier The unique identifier for the algorithm.
	 */
	public static long calculate(ServiceSpecification specification, String algorithmIdentifier) {
		for (SpecificationChecksumCalculator calculator : calculators) {
			if (calculator.identify().equals(algorithmIdentifier)) {
				return calculator.calculate(specification);
			}
		}
		throw new IllegalArgumentException("There was no algorithm known for the provided identifier. The identifier was " + algorithmIdentifier);
	}
	
	/**Updates the checksum for the given specification using a calculator for the given identifier.
	 * @param specification The performance specification.
	 * @param algorithmIdentifier The unique identifier for the algorithm.
	 */
	public static void update(ServiceSpecification specification, String algorithmIdentifier) {
		for (SpecificationChecksumCalculator calculator : calculators) {
			if (calculator.identify().equals(algorithmIdentifier)) {
				calculator.update(specification);
				return;
			}
		}
		throw new IllegalArgumentException("There was no algorithm known for the provided identifier. The identifier was " + algorithmIdentifier);
	}
}
