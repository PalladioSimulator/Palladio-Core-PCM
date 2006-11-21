package de.uka.ipd.sdq.spa.concurrencysolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.qnm.Demand;
import de.uka.ipd.sdq.qnm.DeviceDemand;
import de.uka.ipd.sdq.qnm.SequentialDemand;
import de.uka.ipd.sdq.qnm.util.QnmSwitch;

public class ServiceTimeSwitch extends QnmSwitch {
	private static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	
	@Override
	public Object caseDeviceDemand(DeviceDemand object) {
		return object.getServiceTime();
	}
	
	@Override
	public Object caseSequentialDemand(SequentialDemand object) {
		ResponseTimeSwitch rtSwitch = new ResponseTimeSwitch();
		List<ManagedPDF> pdfList = new ArrayList<ManagedPDF>();
		
		for (Iterator iter = object.getDemands().iterator(); iter.hasNext();) {
			Demand d = (Demand) iter.next();
			ManagedPDF responsePDF = (ManagedPDF) rtSwitch.doSwitch(d);
		}
		
		return QNSolver.sum(pdfList);
	}
	
}
