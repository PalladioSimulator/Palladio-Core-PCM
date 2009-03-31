package de.uka.ipd.sdq.edp2.file.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EmfModelXMIResourceFactoryImpl extends XMIResourceFactoryImpl {
	public static final String EXTENSION_SENSORFRAMEWORK = "sensorframework";
	
	public EmfModelXMIResourceFactoryImpl() {
		super();
	}
	
	@Override
	public Resource createResource(URI uri) {
		return new EmfModelResourceImpl(uri);
	}
}
