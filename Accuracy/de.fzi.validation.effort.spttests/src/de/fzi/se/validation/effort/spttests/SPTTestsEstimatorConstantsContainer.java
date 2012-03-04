/**
 *
 */
package de.fzi.se.validation.effort.spttests;

import org.eclipse.emf.ecore.EPackage;

import de.fzi.se.validation.effort.estimation.spt.SPTPackage;

/**Constants container for the SPT-Tests estimation.
 *
 * @author Martin Krogmann
 *
 */
public class SPTTestsEstimatorConstantsContainer {
	// launch configuration attributes
	/** Launch configuration attribute name for the paramter n in SPT Tests. */
	public static final String N = "n";

	// default values
	/** Default value for n. */
	public static final String DEFAULT_N= "1";

	// EMF packages used by the JJnPathsEstimator
	/** EMF packages for the control-flow description package. */
	public static final EPackage[] CFD_EPACKAGES = new EPackage[] {
	};

	/** EMF packages for the effort estimation result package. */
	public static final EPackage[] RESULT_EPACKAGES = new EPackage[] {
			SPTPackage.eINSTANCE
	};
}
