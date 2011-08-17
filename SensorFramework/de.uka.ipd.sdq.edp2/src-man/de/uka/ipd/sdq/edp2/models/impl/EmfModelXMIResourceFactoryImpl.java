package de.uka.ipd.sdq.edp2.models.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EmfModelXMIResourceFactoryImpl extends XMIResourceFactoryImpl {
	/** File extension for files containing an ExperimentGroup. */
	public static final String EDP2_EXPERIMENT_GROUP_EXTENSION = "edp2";
	/** File extension for files containing Descriptions. */
	public static final String EDP2_DESCRIPTIONS_EXTENSION = "edp2desc";
	/** File extension for files containing NominalMeasurements. */
	public static final String EDP2_NOMINALMEASUREMENTS_EXTENSION = "edp2nm";
	
	public EmfModelXMIResourceFactoryImpl() {
		super();
	}
	
	@Override
	public Resource createResource(URI uri) {
		return new EmfModelResourceImpl(uri);
	}
}
