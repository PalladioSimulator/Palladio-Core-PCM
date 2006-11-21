package de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver;

import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.DeviceDemand;
import de.uka.ipd.sdq.qnm.SequentialDemand;
import de.uka.ipd.sdq.qnm.impl.QnmFactoryImpl;

public class SolvQnmFactory extends QnmFactoryImpl {

	@Override
	public DeviceDemand createDeviceDemand() {
		return new SolvDeviceDemand();
	}
	
	@Override
	public SequentialDemand createSequentialDemand() {
		return new SolvSequentialDemand();
	}
	
	@Override
	public Customer createCustomer() {
		return new SolvCustomer();
	}
}
