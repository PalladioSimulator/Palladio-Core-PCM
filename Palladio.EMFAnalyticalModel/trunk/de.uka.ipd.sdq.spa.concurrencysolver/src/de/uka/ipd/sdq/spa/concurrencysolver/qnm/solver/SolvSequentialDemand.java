package de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.qnm.Demand;
import de.uka.ipd.sdq.qnm.impl.SequentialDemandImpl;


@SuppressWarnings("unchecked")
public class SolvSequentialDemand extends SequentialDemandImpl {

	@Override
	public EList getUsedResources() {
		EList list = new BasicEList();
		list.add( this.getLogicalserver() );
		for (Iterator iter = this.getDemands().iterator(); iter.hasNext();) {
			Demand demand = (Demand) iter.next();
			list = joinLists(list, demand.getUsedResources());
		}
		return list;
	}

	private EList joinLists(EList listA, EList listB) {
		for (Object object : listB) {
			if (!listA.contains(object)){
				listA.add(object);
			}
		}
		return listA;
	}
	
}
