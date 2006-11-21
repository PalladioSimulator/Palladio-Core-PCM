package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.qnm;

import java.util.Hashtable;

import de.uka.ipd.sdq.qnm.Customer;
import de.uka.ipd.sdq.qnm.DeviceServer;
import de.uka.ipd.sdq.qnm.LogicalDemand;
import de.uka.ipd.sdq.qnm.LogicalServer;
import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.QnmFactory;
import de.uka.ipd.sdq.qnm.Server;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.ResourceDemandBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.ResourceModelBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownCustomerException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownServerException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.solver.SolvQnmFactory;

public class QNBuilder implements ResourceModelBuilder {
	
	private static final String ROOT = "!!ROOT!!";
	private QnmFactory qnmFactory = new SolvQnmFactory();
	private QNModel qnModel;
	
	private Hashtable<String, Customer> customerHash;
	private Hashtable<String, Server> serverHash;
	

	public QNBuilder() {
		super();
		qnModel = qnmFactory.createQNModel();
		customerHash = new Hashtable<String, Customer>();
		serverHash = new Hashtable<String, Server>();
		addLogicalResource(ROOT, qnModel.getINFINITE()); // add a root resource with infinite replicas
	}

	public boolean hasServer(String serverName){
		return serverHash.containsKey(serverName);
	}
	
	public boolean hasCustomer(String customerName){
		return customerHash.containsKey(customerName);
	}
	
	public Customer getCustomer(String customerName) throws UnknownCustomerException{
		if (!hasCustomer(customerName))
			throw new UnknownCustomerException(customerName);
		return customerHash.get(customerName);
	}
	
	public Server getServer(String serverName) throws UnknownServerException{
		if (!hasServer(serverName))
			throw new UnknownServerException(serverName);
		return serverHash.get(serverName);
	}
	
	public void addCustomer(String name, int number) {
		Customer c = qnmFactory.createCustomer();
		c.setNumber(number);
		c.setName(name);
		customerHash.put(name, c);
		qnModel.getCustomers().add(c);
	}

	public void addDeviceResource(String name, int number) {
		DeviceServer ds = qnmFactory.createDeviceServer();
		ds.setName(name);
		ds.setNumber(number);
		serverHash.put(name, ds);
		qnModel.getServers().add(ds);
	}

	public void addLogicalResource(String name, int number) {
		LogicalServer ls = qnmFactory.createLogicalServer();
		ls.setName(name);
		ls.setNumber(number);
		serverHash.put(name, ls);
		qnModel.getServers().add(ls);
	}

	public ResourceDemandBuilder addResourceDemand(String customerName) throws UnknownCustomerException {
			try {
				LogicalDemand demand = qnmFactory.createSequentialDemand(); 
				demand.setLogicalserver((LogicalServer) getServer(ROOT));
				getCustomer(customerName).setDemand(demand);
				return new QNDemandBuilder(this, demand, null);
			} catch (UnknownServerException e) {
				e.printStackTrace();
				System.exit(1);
				return null;
			}
	}

	public QNModel getQNModel() {
		return qnModel;
	}
}
