/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import de.uka.ipd.sdq.edp2.models.ExperimentData.Descriptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;
import de.uka.ipd.sdq.edp2.models.impl.EmfModelXMIResourceFactoryImpl;

/**
 * EMF switch class to return the file extension required by EDP2.
 * Return <code>null</code> if the element is not mapped to an EDP2 file extension.
 * @author groenda
 */
public class EmfmodelExtensionSwitch extends ExperimentDataSwitch<String> {
	@Override
	public String caseExperimentGroup(ExperimentGroup object) {
		return EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION;
	}
	
	@Override
	public String caseDescriptions(Descriptions object) {
		return EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION;
	}

	@Override
	public String caseObservedIdentifierBasedMeasurements(
			ObservedIdentifierBasedMeasurements object) {
		return EmfModelXMIResourceFactoryImpl.EDP2_NOMINALMEASUREMENTS_EXTENSION;
	}
}
