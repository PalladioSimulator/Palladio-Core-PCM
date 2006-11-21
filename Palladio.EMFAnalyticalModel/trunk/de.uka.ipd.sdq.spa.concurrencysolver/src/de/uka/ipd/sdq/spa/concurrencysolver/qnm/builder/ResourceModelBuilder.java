package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder;

import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownCustomerException;


public interface ResourceModelBuilder {
	
	 boolean hasServer(String serverName);
	
	 boolean hasCustomer(String customerName);
	
	 void addCustomer(String name, int number);

	 void addDeviceResource(String name, int number);

	 void addLogicalResource(String name, int number);

	 ResourceDemandBuilder addResourceDemand(String customerName) throws UnknownCustomerException;
}

