/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import org.eclipse.emf.ecore.EPackage;

import de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage;
import de.fzi.se.controlflowdescription.graph.GraphPackage;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage;
import de.fzi.se.validation.effort.estimation.EstimationPackage;

/**Constants container for the JJn-Paths estimation.
 *
 * @author groenda
 *
 */
public class JJnPathsEstimatorConstantsContainer {
	// launch configuration attributes
	/** Launch configuration attribute name for the paramter n in JJn-Paths. */
	public static final String N = "JJnPaths_n";

	// default values
	/** Default value for n. */
	public static final String DEFAULT_N= "1";

	// EMF packages used by the JJnPathsEstimator
	/** EMF packages for the control-flow description package. */
	public static final EPackage[] CFD_EPACKAGES = new EPackage[] {
			ControlFlowDescriptionPackage.eINSTANCE,
			GraphPackage.eINSTANCE,
			JJnPathsPackage.eINSTANCE
	};

	/** EMF packages for the effort estimation result package. */
	public static final EPackage[] RESULT_EPACKAGES = new EPackage[] {
			EstimationPackage.eINSTANCE
	};
}
