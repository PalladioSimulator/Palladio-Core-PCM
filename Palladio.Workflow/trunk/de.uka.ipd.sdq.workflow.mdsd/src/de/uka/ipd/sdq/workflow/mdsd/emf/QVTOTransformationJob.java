package de.uka.ipd.sdq.workflow.mdsd.emf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJobWithResult;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.IModel;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.IModelTransfTarget;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOHelper;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.TransfExecutionResult;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.TransformationException;

/**
 * A job that performs a QVT Operational transformation.
 * 
 * @author Michael Hauck
 * 
 */
public class QVTOTransformationJob implements IJobWithResult<ArrayList<SeverityAndIssue>>, IBlackboardInteractingJob<MDSDBlackboard> {
	
	private static final Logger logger = Logger.getLogger(QVTOTransformationJob.class);

	private ArrayList<SeverityAndIssue> result;
	private MDSDBlackboard blackboard;
	private URI scriptURI;
	private List<IModel> models;

	private ResourceSetPartition myPartition;

	private Map<String, Object> options;
	
	private QVTOTransformationJobConf configuration;

	private URI traceURI;

	public QVTOTransformationJob(QVTOTransformationJobConf conf, ResourceSetPartition partition) {
		super();

		this.scriptURI = URI.createURI(conf.getScriptFile());
		if (this.scriptURI == null) {
			throw new IllegalArgumentException("Transformation script URI is null, check transformation filename");
		}
		
		this.configuration = conf;
		this.myPartition = partition;
		this.models = conf.getModels();
		this.options = conf.getOptions();
		this.traceURI = URI.createURI(conf.getTraceFile());
		this.result = new ArrayList<SeverityAndIssue>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.workflow.IJobWithResult#getResult()
	 */
	public ArrayList<SeverityAndIssue> getResult() {
		return this.result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seede.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		TransfExecutionResult result = runTransformation();
		
		logger.debug("Initialising EPackages for storing the output models");
		myPartition.initialiseResourceSetEPackages(configuration.getPartitionResourceSetEPackages());
		
		storeOutputModels(result);
		storeTraceModel(result);
	}

	/**
	 * @return
	 * @throws JobFailedException
	 */
	private TransfExecutionResult runTransformation() throws JobFailedException {
		logger.info("Starting Transformation...");	
		
		TransfExecutionResult result = null;
		try {
			result = QVTOHelper.runTransf(scriptURI, options, models);
		} catch (TransformationException e) {
			logger.error("Transformation job failed",e);
			throw new JobFailedException("Transformation execution failed", e);
		}
		logger.info("Transformation executed successfully");
		logger.debug("Printing transformation console (lenght "+result.getConsoleOutput().length()+")...");
		logger.debug(result.getConsoleOutput());
		logger.info("Transformation job finished");
		
		return result;
	}

	/**
	 * @param result
	 * @throws JobFailedException
	 */
	private void storeTraceModel(TransfExecutionResult result)
			throws JobFailedException {
		if(traceURI != null) {
			logger.info("Saving trace...");
			try {
				result.saveTrace(traceURI);
			} catch (IOException e) {
				logger.error("Failed saving transformation trace model");
				throw new JobFailedException("Failed to save trace model of QVT transformation",e);
			}
		}
	}

	/**
	 * @param result
	 * @throws JobFailedException
	 */
	private void storeOutputModels(TransfExecutionResult result)
			throws JobFailedException {
		logger.info("Saving output models...");
		for(IModelTransfTarget outModel : result.getOutModels()) {
			assert outModel instanceof ModelTransfTarget;
			ModelTransfTarget m = (ModelTransfTarget) outModel;
			try {
				logger.debug("Saving model " + m.getUri());
				toFile(m.getRoots(), m.getUri());
			} catch (IOException e) {
				logger.error("Failed saving transformation result model");
				throw new JobFailedException("Failed to save output model of QVT transformation",e);
			}
			logger.debug("Loading model: " + m.getUri());
			myPartition.loadModel(m.getUri().toString());
		}
		blackboard.addPartition(configuration.getPartitionId(), myPartition);
	}

	/**
	 * Save the EMF model into a file
	 * 
	 * @param objs
	 *            model to save
	 * @param tofile
	 *            filename where the model would be saved
	 * @throws Exception
	 *             raised in case an error occurs and the model is not saved.
	 * @author Andrea Ciancone
	 */
	public void toFile(List<EObject> objs, URI tofile) throws IOException {
		  
        Map<String, Object> options = new HashMap<String, Object>();
        options.put(XMLResource.OPTION_ENCODING, "UTF-8");
        
        for(EObject obj: objs) {
        	if(obj instanceof EStructuralFeature.Internal.DynamicValueHolder) {
        		options.put("SCHEMA_LOCATION", Boolean.TRUE);
        	}
        }
		Resource r = new ResourceSetImpl().createResource(tofile);

		try {
			/* Why is r null? */
			r.getContents().addAll(objs);
		} catch (NullPointerException e) {
			logger.error("No contents found in resource",e);
			throw new IOException("Resource saving failed "+ tofile.toString());
		}
		r.save(options);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	public String getName() {
		return "Perform QVT Operational Transformation";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seede.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
		// Not needed yet.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.workflow.IBlackboardInteractingJob#setBlackboard(de.uka
	 * .ipd.sdq.workflow.Blackboard)
	 */
	public void setBlackboard(MDSDBlackboard blackboard) {
		assert blackboard != null;
		
		logger.debug("Blackboard set.");
		this.blackboard = blackboard;
	}
}
