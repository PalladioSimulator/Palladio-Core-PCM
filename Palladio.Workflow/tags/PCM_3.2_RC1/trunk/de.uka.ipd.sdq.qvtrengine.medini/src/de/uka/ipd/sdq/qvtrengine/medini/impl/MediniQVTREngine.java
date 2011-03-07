package de.uka.ipd.sdq.qvtrengine.medini.impl;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;

import de.ikv.emf.qvt.EMFQvtProcessorImpl;
import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.execution.QvtSemanticAnalyserThreadPool;
import de.ikv.medini.qvt.execution.debug.QVTExitDebugSessionException;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.AbstractQVTREngine;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTREngine;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.QVTRScript;

/**
 * A implementation {@link QVTREngine} for mediniQVT.
 * 
 * @author Thomas Schuischel
 *
 */
public class MediniQVTREngine extends AbstractQVTREngine {

	/**
	 * For mediniQVT enforce can only be set global.
	 */
	private final Boolean enforce = true;
	
	/**
	 * A QVT-R script.
	 */
	private QVTRScript qvtScript;
	/**
	 * The mediniQVT processor.
	 */
	private EMFQvtProcessorImpl processorImpl;
	/**
	 * The collection of model sets.
	 */
	private Collection<Collection<Resource>> modelResources;
	/**
	 * The collection of old traces.
	 */
	private Collection<Resource> oldTraces;
	/**
	 * 
	 */
	private StringWriter logs;

	/**
	 * 
	 */
	private PrintStream extendedDebuggingLog = null;
	
	/**
	 * Creates a new mediniQVT engine.
	 */
	public MediniQVTREngine() {
		processorImpl = new EMFQvtProcessorImpl(new LogWrapper(AbstractQVTREngine.class.getName()));
		modelResources = new ArrayList<Collection<Resource>>();
		oldTraces = new ArrayList<Resource>();
		logs = new StringWriter();
		Logger.getLogger(MediniQVTREngine.class.getName()).addAppender(
				new WriterAppender(new PatternLayout("%-5p [%t]: %m%n")	, logs));
	}
	
	@Override
	public void addModels(final Collection<Resource> models) {
		modelResources.add(models);
	}

	@Override
	public void setDebug(final Boolean debug) {
		String value = "false";
		
		if (debug) {
			value = "true";
		}
		
		// set the mediniQVT debug variables
		setProperty(QVTProcessorConsts.PROP_DEBUG, value);
		setProperty(QVTProcessorConsts.PROP_DEBUG_TASKS, value);
	}

	@Override
	public void setProperty(final String name, final String value) {
		processorImpl.setProperty(name, value);
		
	}

	@Override
	public void setQVTRScript(final QVTRScript qvtrScript) {
		this.qvtScript = qvtrScript;
		addMetaModels(qvtrScript.getMetaModels());
		
	}

	@Override
	public void setWorkingDirectory(final URI directoryURI) {
		processorImpl.setWorkingLocation(directoryURI);
		
	}

	@Override
	public void setOldTracesResourceSet(final ResourceSet rSet) {
		oldTraces.addAll(rSet.getResources());
		
	}
	
	@Override
	public void setTracesResourceSet(final ResourceSet rSet) {
		processorImpl.setResourceSetForTraces(rSet);
		
	}
	
	@Override
	public void setExtendedDebugingLog(final PrintStream extendedDebuggingLog) {
		this.extendedDebuggingLog = extendedDebuggingLog;
		
	}

	@Override
	public void transform() {
		
		// where should the extended logging go?
		// this logger is only used if debug for the engine is enabled 
		if (extendedDebuggingLog != null) {
			QvtSemanticAnalyserThreadPool.setLogger(extendedDebuggingLog);
		} else {
			QvtSemanticAnalyserThreadPool.setLogger(null);
		}
		
		processorImpl.setModels(modelResources);
		processorImpl.evaluateQVT(qvtScript.toReader(), qvtScript.getTransformationName(), enforce, 
				qvtScript.getTransformationDirection(), null, oldTraces, processorImpl.getLog());
		processorImpl.setModels(Collections.EMPTY_LIST);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected QVTRScriptInfoImpl qvtrScriptInfoImpl() {
		HashMap<String, ArrayList<String>> transformationInfo = new HashMap<String, ArrayList<String>>();
		Boolean valid = true;

		
		//setDebug(true);
		try {
			// analyze the script and collect the contextDeclarations
			List<ContextDeclaration> contextDeclarations = 
				processorImpl.analyseQvt(qvtScript.toReader(), processorImpl.getLog());
			
			if (contextDeclarations == null) {
				
				throw new RuntimeException("Could not analyse QVT script. Aborting evaluation!");
			}
			
			// walk through the contextDeclarations and gather the requested informations
			Iterator<ContextDeclaration > iterator = contextDeclarations.iterator();
			while (iterator.hasNext()) {
				Transformation transformation = (Transformation) iterator.next();
				ArrayList<String> directions = new ArrayList<String>();
				
				// get the directions for a transformation
				EList modelParameter = transformation.getModelParameter();
				for (Iterator iter = modelParameter.iterator(); iter.hasNext();) {
					TypedModel currentTypedModel = (TypedModel) iter.next();
					directions.add(currentTypedModel.getName());
				}
				
				transformationInfo.put(transformation.getName(), directions);
			}
		} catch (QVTExitDebugSessionException e) {
			valid = false;
		}
		
		
		return createQVTRScriptInfo(transformationInfo, valid);
	}
	
	/**
	 * Sets the meta models for the QVT transformation.
	 * 
	 * @param metamodels
	 * 				List of meta model packages
	 */
	protected void addMetaModels(final Collection<Object> metamodels) {
		for (Object p : metamodels) {
			if (p instanceof EPackage) {
				this.processorImpl.addMetaModel(p);
			}
		}
	}

}

