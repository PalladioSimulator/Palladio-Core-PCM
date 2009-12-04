package de.uka.ipd.sdq.workflow.mdsd.emf.qvto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.WorkspaceQvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.UriMappingAwareResourceSet;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;

/**
 * QVT OperationalMapping Transformation Helper, based on qvt-oml belongs to M2M umbrella
 * @author Andrea Ciancone
 *
 */
@SuppressWarnings("restriction")
public class QVTOHelper {

	/**
	 * Executes the model transformation
	 * @param scriptFile Filename containing the transformation code 
	 * @param modelsFiles Ordered list of files uri containing input models used by the transformation
	 * @param outModel if initialize at the end will be filled with the files uri of the output models 
	 * @return the transformation result
	 * @throws TransformationException
	 * @throws Exception raised in case the transformation fails 
	 */
	public static TransfExecutionResult runTransf(URI scriptUri, List<IModel> modelsFiles) throws TransformationException {
		 return runTransf(scriptUri, null, modelsFiles);
	}
	public static TransfExecutionResult runTransf(URI scriptUri, Map<String, Object> opt, List<IModel> modelsFiles) throws TransformationException {
		if(opt == null)
			opt = new HashMap<String, Object>();
		QvtModule qvtModule = getQvtModule(scriptUri);
		final QvtInterpretedTransformation transformation = new QvtInterpretedTransformation(qvtModule);
		ResourceSetImpl metamodelResourceSet = new ResourceSetImpl();
		ResourceSet wrappedMetamodelResourceSet = metamodelResourceSet; 
		QvtCompilerOptions options = new QvtCompilerOptions();
		options.setGenerateCompletionData(false);
		transformation.setQvtCompilerOptions(options);
		options.setMetamodelResourceSet(wrappedMetamodelResourceSet);
		
		if (qvtModule instanceof WorkspaceQvtModule) {
			WorkspaceQvtModule workspaceQvtModule = (WorkspaceQvtModule) qvtModule;
			IFile transformationFile = workspaceQvtModule.getTransformationFile();
			try {
				wrappedMetamodelResourceSet = new UriMappingAwareResourceSet(metamodelResourceSet, transformationFile);
			} catch (IOException e) {
				e.printStackTrace();
				throw new TransformationException("Script content is not valid", e);
			}
		}
		TransfExecutionResult result;
		try {
			 result = executeTransformation(transformation, modelsFiles, opt);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TransformationException("Transformation failed", e);
		}
		try {
			transformation.cleanup();
		} catch (MdaException e) {
		}
		return result;
	}
	
	public static QvtModule getQvtModule(URI scriptURI) throws TransformationException {
		QvtModule qvtModule;
		try {
			qvtModule = TransformationUtil.getQvtModule(scriptURI);
		} catch (MdaException e) {
			e.printStackTrace();
			throw new TransformationException("Script's uri is not valid", e);
		}
		return qvtModule;
	}
	
	protected static TransfExecutionResult executeTransformation(final QvtTransformation transformation, final List<IModel> models, final Map<String, Object> inConfigProperties) throws TransformationException {
		List<IModelTransfTarget> outModels = new ArrayList<IModelTransfTarget>();

		final List<ModelContent> inModels = new ArrayList<ModelContent>();
		try {
			if (models.size() <transformation.getParameters().size()) {
			    throw new TransformationException("Model list is incomplete");
			}
			/**
			 * load all input models from file and generate a list of output models
			 */
			Iterator<IModel> iterModel = models.iterator();
			for (TransformationParameter transfParam : transformation.getParameters()) {
				IModel model = iterModel.next();
				if (transfParam.getDirectionKind() == DirectionKind.IN || transfParam.getDirectionKind() == DirectionKind.INOUT) {
					ModelContent inObj = null;
					if(!(model instanceof IModelTransfSource)) {
						throw new TransformationException("The model is not a source model ("+model.getUri().toString()+")");
					}
					try {
						inObj = transformation.loadInput(model.getUri());
					} catch (MdaException e) {
						throw new TransformationException("The model load failed ("+model.toString()+")", e);
					}
					inModels.add(inObj);
				}
				if (transfParam.getDirectionKind() == DirectionKind.OUT || transfParam.getDirectionKind() == DirectionKind.INOUT) {
					if(!(model instanceof IModelTransfTarget)) {
						throw new TransformationException("The model is not a target model ("+model.getUri().toString()+")");
					}
					outModels.add((IModelTransfTarget) model);
				}
			}
		} catch (MdaException e1) {
			e1.printStackTrace();
			throw new TransformationException("Transformation script malformed");
		}
		final List<ModelExtentContents> outExtents = new ArrayList<ModelExtentContents>();
		final List<EObject> outMainParams = new ArrayList<EObject>();
		final List<Trace> outTraces = new ArrayList<Trace>(1);
		final List<String> outConsole = new ArrayList<String>(1);
		
		ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
			public void run() throws Exception {
				QvtLaunchConfigurationDelegateBase.doLaunch(transformation, inModels, inConfigProperties, outExtents, outMainParams, outTraces, outConsole);
				
				transformation.cleanup();
			}
		
		};
		try {
			r = QvtLaunchConfigurationDelegateBase.getSafeRunnable(transformation, r);
		} catch (CoreException e) {
			e.printStackTrace();
			throw new TransformationException("Transformation failed", e);
		}
		try {
			r.run();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for(int i=0; outExtents.size() > i && outModels.size() > i; i++) {
			IModelTransfTarget outModel = outModels.get(i);
			outModel.setRoots(outExtents.get(i).getAllRootElements());
			outModel.setInitialElements(outExtents.get(i).getInitialElements());
		}
		
		return new TransfExecutionResult((outConsole==null || outConsole.size()<1)?"":outConsole.get(0), (outTraces==null || outTraces.size()<1)?null:outTraces.get(0), outMainParams, outModels);
	} 
}