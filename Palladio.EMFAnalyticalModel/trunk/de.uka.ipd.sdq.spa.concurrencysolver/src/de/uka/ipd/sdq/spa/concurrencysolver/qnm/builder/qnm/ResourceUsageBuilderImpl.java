package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.qnm;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.qnm.QnmFactory;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.ResourceUsageBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceNotDeviceException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceNotPassiveException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownResourceException;
import de.uka.ipd.sdq.spa.resourcemodel.ActiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.CompositeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelFactory;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;

public class ResourceUsageBuilderImpl implements ResourceUsageBuilder {
	
	private ResourceModelBuilderImpl qnBuilder;
	private CompositeResourceUsage compositeResourceUsage;
	private ResourceUsageBuilderImpl parentBuilder;
	private QnmFactory qnFactory = QnmFactory.eINSTANCE;
	private ResourceModelFactory rmFactory = ResourceModelFactory.eINSTANCE;
	
	public ResourceUsageBuilderImpl(ResourceModelBuilderImpl qnBuilder, ResourceUsageBuilderImpl parentBuilder) {
		super();
		this.qnBuilder = qnBuilder;
		this.compositeResourceUsage = rmFactory.createSequentialResourceUsage();
		this.parentBuilder = parentBuilder;
	}
	

	public ResourceUsageBuilderImpl(ResourceModelBuilderImpl qnBuilder, CompositeResourceUsage compositeResourceUsage, ResourceUsageBuilderImpl parentBuilder) {
		super();
		this.qnBuilder = qnBuilder;
		this.compositeResourceUsage = compositeResourceUsage;
		this.parentBuilder = parentBuilder;
	}


	public void addResourceUsage(String resourceName,
			ManagedPDF usageTime) throws UnknownResourceException, ResourceNotDeviceException {
		Resource resource = qnBuilder.getResource(resourceName);
		if (resource instanceof ActiveResource) {
			ActiveResource activeResource = (ActiveResource) resource;
			ResourceUsage resourceUsage = rmFactory.createResourceUsage();
			resourceUsage.setResource(activeResource);
			resourceUsage.setUsageTime(usageTime.getModelPdf());
			compositeResourceUsage.getResourceUsages().add(resourceUsage);
		} else {
			throw new ResourceNotDeviceException();
		}
		
		
	}

	public ResourceUsageBuilder addSequentialResourceUsage(String resourceName) throws ResourceNotPassiveException, UnknownResourceException {
		Resource resource = qnBuilder.getResource(resourceName);
		
		if (resource instanceof PassiveResource) {
			PassiveResource passiveResource = (PassiveResource) resource;
			CompositeResourceUsage sequentialResourceUsage = rmFactory.createSequentialResourceUsage();
			sequentialResourceUsage.setResource(passiveResource);
			compositeResourceUsage.getResourceUsages().add(sequentialResourceUsage);
			return new ResourceUsageBuilderImpl(qnBuilder, sequentialResourceUsage, this);
		} else {
			throw new ResourceNotPassiveException();
		}
	}


	public ResourceUsageBuilder getParentBuilder() {
		return parentBuilder;

	}

}
