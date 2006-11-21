package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.qnm;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.qnm.DeviceDemand;
import de.uka.ipd.sdq.qnm.DeviceServer;
import de.uka.ipd.sdq.qnm.LogicalDemand;
import de.uka.ipd.sdq.qnm.LogicalServer;
import de.uka.ipd.sdq.qnm.QnmFactory;
import de.uka.ipd.sdq.qnm.Server;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.ResourceDemandBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceNotDeviceException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceNotLogicalServerException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownServerException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver.SolvQnmFactory;

public class QNDemandBuilder implements ResourceDemandBuilder {
	
	private QNBuilder qnBuilder;
	private LogicalDemand logicalDemand;
	private QNDemandBuilder parentBuilder;
	private QnmFactory qnFactory = new SolvQnmFactory();
	
	public QNDemandBuilder(QNBuilder qnBuilder, QNDemandBuilder parentBuilder) {
		super();
		this.qnBuilder = qnBuilder;
		this.logicalDemand = qnFactory.createSequentialDemand();
		this.parentBuilder = parentBuilder;
	}
	

	public QNDemandBuilder(QNBuilder qnBuilder, LogicalDemand demand, QNDemandBuilder parentBuilder) {
		super();
		this.qnBuilder = qnBuilder;
		this.logicalDemand = demand;
		this.parentBuilder = parentBuilder;
	}


	public void addDeviceDemand(String resourceName,
			ManagedPDF demandTime) throws UnknownServerException, ResourceNotDeviceException {
		Server s = qnBuilder.getServer(resourceName);
		if (s instanceof DeviceServer) {
			DeviceServer server = (DeviceServer) s;
			DeviceDemand demand = qnFactory.createDeviceDemand();
			demand.setDeviceServer(server);
			demand.setServiceTime(demandTime);
			logicalDemand.getDemands().add(demand);
		} else {
			throw new ResourceNotDeviceException();
		}
		
		
	}

	public ResourceDemandBuilder addLogicalDemand(String resourceName) throws ResourceNotLogicalServerException, UnknownServerException {
		Server s = qnBuilder.getServer(resourceName);
		
		if (s instanceof LogicalServer) {
			LogicalServer server = (LogicalServer) s;
			LogicalDemand demand = qnFactory.createSequentialDemand();
			demand.setLogicalserver(server);
			logicalDemand.getDemands().add(demand);
			return new QNDemandBuilder(qnBuilder, demand, this);
		} else {
			throw new ResourceNotLogicalServerException();
		}
	}


	public ResourceDemandBuilder getParentBuilder() {
		return parentBuilder;

	}

}
