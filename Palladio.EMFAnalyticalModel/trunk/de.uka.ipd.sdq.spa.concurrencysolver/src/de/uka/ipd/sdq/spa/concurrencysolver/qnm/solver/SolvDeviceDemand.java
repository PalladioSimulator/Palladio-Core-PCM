package de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.qnm.impl.DeviceDemandImpl;

@SuppressWarnings("unchecked")
public class SolvDeviceDemand extends DeviceDemandImpl{

	@Override
	public EList getUsedResources() {
		EList list = new BasicEList();
		list.add( this.getDeviceServer() );
		return list;
	}

	
	
}
