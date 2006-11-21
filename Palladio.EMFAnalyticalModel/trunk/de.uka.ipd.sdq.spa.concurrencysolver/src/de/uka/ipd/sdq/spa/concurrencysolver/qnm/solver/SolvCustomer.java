package de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.DeviceDemand;
import de.uka.ipd.sdq.qnm.LogicalDemand;
import de.uka.ipd.sdq.qnm.impl.CustomerImpl;
import de.uka.ipd.sdq.qnm.util.QnmSwitch;

public class SolvCustomer extends CustomerImpl implements Customer {
	
		@SuppressWarnings("unchecked")
		QnmSwitch demandCollector = new QnmSwitch(){
			@Override
			public Object caseLogicalDemand(LogicalDemand ld) {
				EList result = new BasicEList();
				for (Object d : ld.getDemands()) {
					result.addAll((Collection)doSwitch((EObject)d));
				}
				result.add(ld);
				return result;
			}
			
			@Override
			public Object caseDeviceDemand(DeviceDemand dd) {
				EList result = new BasicEList();
				result.add(dd);
				return result;
			}
		};

		@Override
		public EList getAllDemands() {
			return (EList)demandCollector.doSwitch(this.getDemand());
		}
}
