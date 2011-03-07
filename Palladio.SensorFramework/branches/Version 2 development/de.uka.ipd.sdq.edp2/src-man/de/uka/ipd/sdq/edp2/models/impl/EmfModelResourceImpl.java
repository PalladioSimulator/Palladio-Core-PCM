package de.uka.ipd.sdq.edp2.models.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class EmfModelResourceImpl extends XMIResourceImpl {
	public EmfModelResourceImpl() {
		super();
	}
	
	public EmfModelResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	protected boolean useUUIDs() {
		//return true;
		return false;
	}
	
}
