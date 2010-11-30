package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.oaw;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.AbstractQVTREngine;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTRScript;

/**
 * A OAW workflow component for QVT-R transformations.
 * It uses registered QVT-R engines.
 *  
 * @author Thomas Schuischel
 *
 */
public class QVTRTransformation extends AbstractWorkflowComponent  {

	static Logger logger = Logger.getLogger(QVTRTransformation.class);
	
	private static final String COMPONENT_NAME = "QVTRTransformation";
	
	private Boolean debug = false;
	private String qvtrScript = null;
	private AbstractQVTREngine qvtrEngineType = null;
	protected ResourceSet resourceSet;

	private Collection<String> metaModels = new ArrayList<String>();

	private URI traceFileURI = null;

	private Collection<String> inputModels = new ArrayList<String>();

	private Collection<String> outputModels = new ArrayList<String>();
	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		//ctx.get(getModelSlot());
		run(issues);
		
	}
	
	public void run(Issues issues)  {
		
		logger.info("Executing QVTR Transformation...");
		logger.debug("Script: "+ getQvtrScript());
		 
		this.resourceSet = new ResourceSetImpl();
		this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		AbstractQVTREngine qvtrEngine = getQvtrEngineType();
		
		if(qvtrEngine==null)
		{
			issues.addError(this, "No QVT-R Engine available.");
			return;
		}
		
		qvtrEngine.setDebug(getDebug());
		
		QVTRScript qvtrScript = new QVTRScript();
		qvtrScript.setMetaModels(getMetaModelsFromString(getMetaModelURIs()));
		qvtrScript.setQVTFile(getQvtrScript());
		
	/*	if(configuration.getTracesPartitionName() != null) {
			ResourceSetPartition tracesPartition = this.blackboard.getPartition(configuration.getTracesPartitionName());
			if(tracesPartition == null)	{
				tracesPartition = new ResourceSetPartition();
				this.blackboard.addPartition(configuration.getTracesPartitionName(), tracesPartition);
			}
			qvtrEngine.setTracesResourceSet(tracesPartition.getResourceSet());
		}*/
		
		qvtrEngine.setWorkingDirectory(getTraceFileURI());
		
		qvtrEngine.addModels(getResorces(inputModels));
		
		qvtrEngine.addModels(getAndCreateResorces(outputModels));
		
		qvtrEngine.addModels(getResorces(inputModels));
		
		qvtrEngine.setQVTRScript(qvtrScript);
		
		try {
			qvtrEngine.transform();
		} catch (Throwable e) {
			issues.addError(this, "Error in mediniQVT Transformation",e);
			return;
		}
		
		logger.info("Transformation executed successfully");
		issues.addInfo("Transformation executed successfully");
	}


	public void setTraceFileURI(String traceFileURI) {
		this.traceFileURI = URI.createURI(traceFileURI);
	}
	
	public URI getTraceFileURI() {
		return traceFileURI;
	}

	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	public Boolean getDebug() {
		return debug;
	}

	public void setQvtrScript(String qvtrScript) {
		this.qvtrScript = qvtrScript;
	}

	public String getQvtrScript() {
		return qvtrScript;
	}

	public AbstractQVTREngine getQvtrEngineType() {
		return qvtrEngineType;
	}

	public void setQvtrEngineType(AbstractQVTREngine qvtrEngineType) {
		this.qvtrEngineType = qvtrEngineType;
	}
	
	public Collection<String> getInputModels() {
		return inputModels;
	}

	public void addInputModels(String inputModels) {
		this.inputModels.add(inputModels);
	}

	public Collection<String> getOutputModels() {
		return outputModels;
	}

	public void setOutputModels(String outputModels) {
		this.outputModels.add(outputModels);
	}

	public Collection<String> getMetaModelURIs() {
		return metaModels;
	}

	public void addMetaModelURI(String metaModel) {
		this.metaModels.add(metaModel);
	}
	
	protected Collection<Object> getMetaModelsFromString(Collection<String> models) {
		Collection<Object> modelResources = new ArrayList<Object>();
		for(String model :models) {
			URI uri = URI.createURI(model, false);
			EList<EObject> objects= resourceSet.getResource(uri, true).getContents();
			for(EObject o : objects) {
				if(o instanceof EPackageImpl) {
					EPackageImpl p = (EPackageImpl) o;
					//this.resourceSet.getPackageRegistry().put(p.getNsURI(), p);
					modelResources.add(p);
				}
			}
			
		}
		return modelResources;
	}
	
	private Collection<Resource> getResorces(Collection<String> models) {
		Collection<Resource> modelResources = new ArrayList<Resource>();
		for(String model :models) {
			URI uri = URI.createURI(model, false);
			Resource r = resourceSet.getResource(uri, true);
			modelResources.add(r);
		}
		return modelResources;
	}
	
	private Collection<Resource> getAndCreateResorces(Collection<String> models) {
		Collection<Resource> modelResources = new ArrayList<Resource>();
		ResourceSet rSet = new ResourceSetImpl();
		for(String model :models) {
			URI uri = URI.createURI(model, false);
			Resource r = rSet.createResource(uri);
			modelResources.add(r);
		}
		return modelResources;
	}
	
	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
	
	@Override
	public void checkConfiguration(final Issues issues) {
		if (qvtrScript == null) {
			issues.addError("QTRScript not set");
		}
	}
}
