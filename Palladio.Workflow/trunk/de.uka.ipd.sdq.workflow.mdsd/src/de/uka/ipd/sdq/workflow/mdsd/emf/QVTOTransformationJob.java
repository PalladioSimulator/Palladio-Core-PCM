package de.uka.ipd.sdq.workflow.mdsd.emf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.qvt.oml.runtime.util.QvtoTransformationHelper;
import org.eclipse.m2m.qvt.oml.runtime.util.QvtoTransformationHelper.ModelExtent;
import org.eclipse.m2m.qvt.oml.runtime.util.QvtoTransformationHelper.TransfExecutionResult;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJobWithResult;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

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
	private Map<String, String> inputModels;
	private Map<String, String> outputModels;
	private URI scriptURI;

	public QVTOTransformationJob(URI scriptURI, Map<String, String> inputModels, Map<String, String> outputModels) {
		super();
		this.scriptURI = scriptURI;
		this.inputModels = inputModels;
		this.outputModels = outputModels;
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
		// URI uri = URI.createURI(scriptURI);
		if (scriptURI == null) {
			throw new JobFailedException("Transformation script is null!");
		}
		List<EObject> inObjects = new ArrayList<EObject>();
		List<URI> outModel = new ArrayList<URI>();
		/**
		 * load all input models from file and generate a list of output models
		 */
		try {
			QvtTransformation transformation = new QvtInterpretedTransformation(TransformationUtil.getQvtModule(scriptURI));
			int i = 0;
			for (TransformationParameter transfParam : transformation.getParameters()) {
				i++;
				logger.debug("Loading transformation parameter " + transfParam.getName());
				if (transfParam.getDirectionKind() == DirectionKind.IN || transfParam.getDirectionKind() == DirectionKind.INOUT) {
					Resource res = null;
					if (inputModels.get(transfParam.getName()).indexOf("://") >= 0) {
						res = blackboard.getPartition("samm_input").getResourceSet().getResource(URI.createURI(inputModels.get(transfParam.getName())), true);
					} else {
						res = blackboard.getPartition("samm_input").getResourceSet().getResource(URI.createFileURI(inputModels.get(transfParam.getName())), true);
					}
					EObject eobj = res.getContents().get(0);
					inObjects.add(eobj);
				}
				if (transfParam.getDirectionKind() == DirectionKind.OUT || transfParam.getDirectionKind() == DirectionKind.INOUT) {
					outModel.add(URI.createFileURI(outputModels.get(transfParam.getName())));

				}
			}
		} catch (MdaException e) {
			e.printStackTrace();
			// throw new JobFailedException("Transformation failed.",
			// e.getCause());
		}
		QvtoTransformationHelper qvtoTransformationHelper = new QvtoTransformationHelper(scriptURI);
		TransfExecutionResult qvtResult = null;
		try {
			logger.info("Executing transformation...");
			qvtResult = qvtoTransformationHelper.executeTransformation(inObjects, Collections.<String, Object> emptyMap(), null);
			logger.info("Transformation executed. Writing results to file...");
			for (int i = 0; i < outModel.size() && i < qvtResult.getOutModelExtents().size(); i++) {
				ModelExtent extend = qvtResult.getOutModelExtents().get(i);
				toFile(extend.getAllRootElements(), outModel.get(i));
			}
			logger.debug("Output files written.");
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	private void toFile(List<EObject> objs, URI tofile) throws IOException {

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		for (EObject obj : objs) {
			if (obj instanceof EStructuralFeature.Internal.DynamicValueHolder) {
				options.put("SCHEMA_LOCATION", Boolean.TRUE);
			}
		}

		Resource r = new ResourceSetImpl().createResource(tofile);

		try {
			/* Why is r null? */
			r.getContents().addAll(objs);
		} catch (NullPointerException e3) {
			e3.printStackTrace();
			throw new IOException("Resource saving failed " + tofile.toString());
		}
		try {
			r.save(options);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Resource saving failed " + tofile.toString());
		}
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
