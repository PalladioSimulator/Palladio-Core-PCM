package de.uka.ipd.sdq.spa.concurrencysolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.qnm.util.QnmSwitch;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.util.ResourceModelSwitch;

public class ServiceTimeSwitch extends ResourceModelSwitch {
	private static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	
	@Override
	public Object caseResourceUsage(ResourceUsage object) {
		return new ManagedPDF(object.getUsageTime());
	}
	
	
	@Override
	public Object caseSequentialResourceUsage(SequentialResourceUsage object) {
		ResponseTimeSwitch rtSwitch = new ResponseTimeSwitch();
		List<ManagedPDF> pdfList = new ArrayList<ManagedPDF>();
		
		for (Iterator iter = object.getResourceUsages().iterator(); iter.hasNext();) {
			ResourceUsage d = (ResourceUsage) iter.next();
			ManagedPDF responsePDF = (ManagedPDF) rtSwitch.doSwitch(d);
		}
		return QNSolver.sum(pdfList);
	}
	
	
}
