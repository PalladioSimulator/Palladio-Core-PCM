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
	
	private Logger logger = Logger.getLogger(QVTOTransformationJob.class);

	private ArrayList<SeverityAndIssue> result;
	private MDSDBlackboard blackboard;
	private URI scriptURI;
	private List<IModel> models;

	@SuppressWarnings("unused")
	private String inPartition;
	private String outPartition;

	private Map<String, Object> options;

	private URI traceURI;

	public QVTOTransformationJob(QVTOTransformationJobConf conf, MDSDBlackboard blackboard, String inPartition, String outPartition) {
		this.blackboard = blackboard;
		this.models = conf.getModels();
		this.options = conf.getOptions();
		this.inPartition = inPartition;
		this.outPartition = outPartition;
		this.scriptURI = URI.createURI(conf.getScriptFile());
		this.traceURI = URI.createURI(conf.getTraceFile());
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
		this.result = new ArrayList<SeverityAndIssue>();

		if (scriptURI == null) {
			throw new JobFailedException("Transformation script is null!");
		}

		logger.info("Starting Transformation...");		
		System.out.println("Starting Transformation...");
		TransfExecutionResult result = null;
		try {
			result = QVTOHelper.runTransf(scriptURI, options, models);
		} catch (TransformationException e) {
			e.printStackTrace();
			throw new JobFailedException("Transformation execution failed", e);
		}
		logger.info("Transformation executed.");
		System.out.println("Transformation executed.");
		
		logger.info("Saving models...");
		System.out.println("Saving models...");
		ResourceSetPartition pcmPartition = new ResourceSetPartition();
		for(IModelTransfTarget outModel : result.getOutModels()) {
			if(outModel instanceof ModelTransfTarget) {
				ModelTransfTarget m = (ModelTransfTarget) outModel;
				try {
					logger.info("Saving model " + m.getUri());
					toFile(m.getRoots(), m.getUri());
				} catch (IOException e) {
					e.printStackTrace();
				}
				pcmPartition.loadModel(m.getUri().toString());
			}
		}
		blackboard.addPartition(outPartition, pcmPartition);
		
		if(traceURI != null) {
			logger.info("Saving trace...");
			System.out.println("Saving trace...");
			try {
				result.saveTrace(traceURI);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Printing transformation console (lenght "+result.getConsoleOutput().length()+")...");
		System.out.println(result.getConsoleOutput());
		System.out.println("Transformation job finished.");
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
			e.printStackTrace();
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
		this.blackboard = blackboard;
	}
}
