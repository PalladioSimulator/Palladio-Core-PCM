package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import uk.ac.kent.cs.kmf.util.OutputStreamLog;
import uk.ac.kent.cs.kmf.util.ILog;

import de.ikv.emf.qvt.EMFQvtProcessorImpl;
import de.ikv.medini.qvt.QVTProcessorConsts;

public class SimpleMediniQVT {
	
	private static Logger logger = Logger.getLogger(SimpleMediniQVT.class);
	private EMFQvtProcessorImpl processorImpl;
	private ILog qvtLogger;
	private FileReader qvtReader = null;
	private Collection<Collection<Resource>> modelResources;
	
	/**
	 * Initializes the QVT processor
	 * 
	 * 
	 */
	public SimpleMediniQVT() {
		super();
		this.qvtLogger = new LogWrapper("de.uka.ipd.sdq.workflow.qvtr");
		//this.qvtLogger = new OutputStreamLog(System.out);
		processorImpl = new EMFQvtProcessorImpl(this.qvtLogger);
		modelResources = new ArrayList<Collection<Resource>>();
	}
	
	/**
	 * Sets a Property of the QVT Processor
	 * 
	 * @param name
	 *            name of the property
	 * @param value
	 * 			  value of the property
	 */
	public void setProperty(String name, String value){
		this.processorImpl.setProperty(name, value);
	}
	
	public void setDebug(Boolean debug, Boolean debugTask) {
		if(debug)
			setProperty(QVTProcessorConsts.PROP_DEBUG, "true");
		if(debug && debugTask)
			setProperty(QVTProcessorConsts.PROP_DEBUG_TASKS, "true");
	}
	
	
	/**
	 * Sets a ResourceSet for the QVT engine to load models
	 * 
	 * @param rSet
	 * 				EMF-ResourceSet
	 */
	public void addModelResourceSet(ResourceSet rSet){
		//ArrayList<Resource> setOfModels = new ArrayList<Resource>();
		modelResources.add(rSet.getResources());
		addMetaModels(rSet.getPackageRegistry().values());
	}
	
	/**
	 * Sets a ResourceSet for the QVT engine to store traces
	 * 
	 * @param rSet
	 * 				EMF-ResourceSet
	 */
	public void setWorkingResourceSet(ResourceSet rSet){
		processorImpl.setResourceSetForTraces(rSet);
	}
	
	/**
	 * Sets a working-directory for the QVT engine, e.g. to store traces
	 * 
	 * @param directoryName
	 * 				name of the Directory
	 */
	public void setWorkingDirectory(String directoryName){
		URI directoryURI = URI.createURI(directoryName);
		processorImpl.setWorkingLocation(directoryURI);
	}
	
	/**
	 * Sets the meta models for the QVT transformation
	 * 
	 * @param metamodels
	 * 				List of meta model packages
	 */
	protected void addMetaModels(Collection<Object> metamodels) {
		for(Object p : metamodels){
			if(p instanceof EPackage )
				this.processorImpl.addMetaModel(p);
		}
	}
		
	/**
	 * Sets the QVT file to work on
	 * 
	 * @param fileName
	 * 				name of the QVT file
	 */
	public void setQVTFile(String fileName){
		URI qvturl = null;
		try {
			qvturl = URI.createURI(fileName);
		} catch (IllegalArgumentException e) {
			logger.error("Wrong URI format.",e);
		}
		try {
			String fileuri = CommonPlugin.asLocalURI(qvturl).toFileString();
			qvtReader  = new FileReader(fileuri);
		} catch (FileNotFoundException fileNotFoundException) {
			logger.error("QVT file not found!",fileNotFoundException);
			return;
		}
	}
	
	/**
	 * Transform a QVT script in a specific direction.
	 * 
	 * @param transformation
	 *            name of the transformation
	 * @param direction
	 *            name of the target - must conform to your QVT transformation definition
	 * @throws Throwable
	 */
	public void transform(String transformation, String direction) throws Throwable {
		
		processorImpl.setModels(modelResources);
		processorImpl.evaluateQVT(qvtReader, transformation, true, direction, new Object[0], null, qvtLogger);
		processorImpl.setModels(Collections.EMPTY_LIST);
	}

	
}
