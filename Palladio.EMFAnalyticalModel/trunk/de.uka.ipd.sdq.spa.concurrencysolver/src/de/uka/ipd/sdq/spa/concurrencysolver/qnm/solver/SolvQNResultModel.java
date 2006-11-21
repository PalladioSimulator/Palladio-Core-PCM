package de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver;

import java.util.List;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.Server;
import de.uka.ipd.sdq.qnm.qnResult.CustomerResult;
import de.uka.ipd.sdq.qnm.qnResult.QNResultPackage;
import de.uka.ipd.sdq.qnm.qnResult.ServerResult;
import de.uka.ipd.sdq.qnm.qnResult.impl.QNResultModelImpl;

public class SolvQNResultModel extends QNResultModelImpl {

	@Override
	public CustomerResult getResultForCustomer(Customer customer) {
		Query query = QueryFactory.eINSTANCE.createQuery("customer.name = '"
				+ customer.getName() + "'", QNResultPackage.eINSTANCE
				.getCustomerResult());
		List result = query.select(this.customerResults);
		// TODO: check if result.size() == 1 
		return (CustomerResult) result.get(0);
	}

	@Override
	public ServerResult getResultForServer(Server server) {
		Query query = QueryFactory.eINSTANCE.createQuery("server.name = '"
				+ server.getName() + "'", QNResultPackage.eINSTANCE
				.getServerResult());
		List result = query.select(this.serverResults);
		// TODO: check if result.size() == 1 
		return (ServerResult) result.get(0);
	}

}
