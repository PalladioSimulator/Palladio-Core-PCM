package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder;

import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownTaskException;


public interface ResourceModelBuilder {
	
	 boolean hasResource(String serverName);
	
	 boolean hasTask(String customerName);
	
	 void addTask(String name, int number);

	 void addProcessingResource(String name, int number);

	 void addPassivResource(String name, int number);

	 ResourceUsageBuilder addSequentialResourceUsage(String customerName) throws UnknownTaskException;

	void addDelayResource(String name);
}

