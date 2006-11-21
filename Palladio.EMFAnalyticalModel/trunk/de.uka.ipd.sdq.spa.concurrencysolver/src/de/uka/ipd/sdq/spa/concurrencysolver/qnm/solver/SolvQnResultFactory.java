package de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver;

import de.uka.ipd.sdq.qnm.qnResult.CustomerResult;
import de.uka.ipd.sdq.qnm.qnResult.QNResultModel;
import de.uka.ipd.sdq.qnm.qnResult.ServerResult;
import de.uka.ipd.sdq.qnm.qnResult.impl.QNResultFactoryImpl;

public class SolvQnResultFactory extends QNResultFactoryImpl{
	
	
	@Override
	public CustomerResult createCustomerResult() {
		return new SolvCustomerResult();
	}
	
	@Override
	public QNResultModel createQNResultModel() {
		return new SolvQNResultModel();
	}
	
	@Override
	public ServerResult createServerResult() {
		return new SolvServerResult();
	}
}
