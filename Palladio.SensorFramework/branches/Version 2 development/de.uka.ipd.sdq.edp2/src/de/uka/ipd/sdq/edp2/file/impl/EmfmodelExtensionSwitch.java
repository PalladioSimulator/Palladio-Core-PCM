/**
 * 
 */
package de.uka.ipd.sdq.edp2.file.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.Descriptions;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.ObservedNominalMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.util.EmfmodelSwitch;

/**EMF switch class to return the file extension required by EDP2.
 * Return <code>null</code> if the element is not mapped to an EDP2 file extension.
 * @author groenda
 */
public class EmfmodelExtensionSwitch extends EmfmodelSwitch<String> {
	@Override
	public String caseExperimentGroup(ExperimentGroup object) {
		return EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION;
	}
	
	@Override
	public String caseDescriptions(Descriptions object) {
		return EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION;
	}

	@Override
	public String caseObservedNominalMeasurements(
			ObservedNominalMeasurements object) {
		return EmfModelXMIResourceFactoryImpl.EDP2_NOMINALMEASUREMENTS_EXTENSION;
	}
}
