/**
 * 
 */
package de.fzi.se.quality.util;

import de.fzi.se.quality.qualityannotation.ServiceSpecification;

/**Interface for algorithm which calculate the checksum for a given specification.
 * @author groenda
 *
 */
public interface SpecificationChecksumCalculator {

	/**Calculates the checksum for the provided specification.
	 * Throws a runtime exception if the calculation fails, e.g. the specification language is not supported.
	 * @param specification The performance specification.
	 */
	public long calculate(ServiceSpecification specification);
	
	/**
	 * @return The unique identifier for this algorithm.
	 */
	public String identify();

	/**Updates the checksum of the provided specification.
	 * Throws a runtime exception if the calculation fails, e.g. the specification language is not supported.
	 * @param specification The performance specification.
	 */
	public void update(ServiceSpecification specification);
}
