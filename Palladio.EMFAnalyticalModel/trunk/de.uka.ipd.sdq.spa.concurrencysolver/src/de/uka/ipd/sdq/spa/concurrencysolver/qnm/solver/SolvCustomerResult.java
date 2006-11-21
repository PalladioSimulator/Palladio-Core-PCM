package de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver;

import java.util.List;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.qnm.Server;
import de.uka.ipd.sdq.qnm.qnResult.CustomerServerUsage;
import de.uka.ipd.sdq.qnm.qnResult.QNResultPackage;
import de.uka.ipd.sdq.qnm.qnResult.impl.CustomerResultImpl;

public class SolvCustomerResult extends CustomerResultImpl {
 
	@Override
	public CustomerServerUsage getServerUsage(Server server) {
		Query q = QueryFactory.eINSTANCE.createQuery("serverResult.server.name = '" + server.getName() + "'", QNResultPackage.eINSTANCE.getCustomerServerUsage());
		List result = (List) q.select(this.getServerUsage());
		return (CustomerServerUsage) result.get(0);
	}
}
