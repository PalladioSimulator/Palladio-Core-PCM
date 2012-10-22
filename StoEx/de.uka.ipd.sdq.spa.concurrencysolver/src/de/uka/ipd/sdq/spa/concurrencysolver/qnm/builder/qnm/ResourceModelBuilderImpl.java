package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.qnm;

import java.util.Hashtable;

import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.QnmFactory;
import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.ResourceModelBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.ResourceUsageBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownResourceException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownTaskException;
import de.uka.ipd.sdq.spa.resourcemodel.CompositeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.DelayResource;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelFactory;

public class ResourceModelBuilderImpl implements ResourceModelBuilder {
	
	private static final String ROOT = "!!ROOT!!";
	
	private QnmFactory qnmFactory = QnmFactory.eINSTANCE;
	private ResourceModelFactory rmFactory = ResourceModelFactory.eINSTANCE;
	private QNModel qnModel;
	
	private Hashtable<String, Task> taskHash;
	private Hashtable<String, Resource> resourceHash;
	

	public ResourceModelBuilderImpl(int totalNumOfTasks) {
		super();
		qnModel = qnmFactory.createQNModel();
		taskHash = new Hashtable<String, Task>();
		resourceHash = new Hashtable<String, Resource>();
		addPassivResource(ROOT, totalNumOfTasks); // add a root resource with infinite replicas
	}

	public boolean hasResource(String serverName){
		return resourceHash.containsKey(serverName);
	}
	
	public boolean hasTask(String customerName){
		return taskHash.containsKey(customerName);
	}
	
	public Task getTask(String taskName) throws UnknownTaskException{
		if (!hasTask(taskName))
			throw new UnknownTaskException(taskName);
		return taskHash.get(taskName);
	}
	
	public Resource getResource(String resourceName) throws UnknownResourceException{
		if (!hasResource(resourceName))
			throw new UnknownResourceException(resourceName);
		return resourceHash.get(resourceName);
	}
	
	public void addTask(String name, int numReplicas) {
		Task task = qnmFactory.createTask();
		task.setNumReplicas(numReplicas);
		task.setName(name);
		taskHash.put(name, task);
		qnModel.getTasks().add(task);
	}

	public void addProcessingResource(String name, int numReplicas) {
		ProcessingResource processingResource = rmFactory.createProcessingResource();
		processingResource.setName(name);
		processingResource.setNumReplicas(numReplicas);
		resourceHash.put(name, processingResource);
		qnModel.getResources().add(processingResource);
	}

	public void addDelayResource(String name) {
		DelayResource delayResource = rmFactory.createDelayResource();
		delayResource.setName(name);
		resourceHash.put(name, delayResource);
		qnModel.getResources().add(delayResource);
	}
	
	public void addPassivResource(String name, int numReplicas) {
		PassiveResource passiveResource = rmFactory.createPassiveResource();
		passiveResource.setName(name);
		passiveResource.setNumReplicas(numReplicas);
		resourceHash.put(name, passiveResource);
		qnModel.getResources().add(passiveResource);
	}

	public ResourceUsageBuilder addSequentialResourceUsage(String taskName) throws UnknownTaskException {
			try {
				CompositeResourceUsage resourceUsage = rmFactory.createSequentialResourceUsage(); 
				resourceUsage.setResource(getResource(ROOT));
				getTask(taskName).setResourceUsage(resourceUsage);
				return new ResourceUsageBuilderImpl(this, resourceUsage, null);
			} catch (UnknownResourceException e) {
				e.printStackTrace();
				System.exit(1);
				return null;
			}
	}

	public QNModel getQNModel() {
		return qnModel;
	}
}
