package de.uka.ipd.sdq.workflow.mdsd.emf.qvto;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.BaseProcess.IRunnable;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.WorkspaceQvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.UriMappingAwareResourceSet;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.util.WriterLog;

/**
 * QVT OperationalMapping Transformation Helper, based on qvt-oml belongs to M2M umbrella
 * @author Andrea Ciancone
 *
 */
@SuppressWarnings("restriction")
public class QVTOHelper {

	/**
	 * Logger of this class 
	 */
	private static final Logger logger = Logger.getLogger(QVTOHelper.class);
	
	/**
	 * Executes the model transformation
	 * @param scriptUri Filename containing the transformation code 
	 * @param modelsFiles Ordered list of files uri containing input models used by the transformation
	 * @return the transformation result
	 * @throws TransformationException
	 * @throws Exception raised in case the transformation fails 
	 */
	public static TransfExecutionResult runTransf(URI scriptUri, List<IModel> modelsFiles) throws TransformationException {
		 return runTransf(scriptUri, null, modelsFiles);
	}
	
	/**
	 * Executes the model transformation
	 * @param scriptUri Filename containing the transformation code 
	 * @param modelsFiles Ordered list of files uri containing input models used by the transformation
	 * @param opt Transformation options (?)
	 * @return the transformation result
	 * @throws TransformationException
	 * @throws Exception raised in case the transformation fails 
	 */
	public static TransfExecutionResult runTransf(URI scriptUri, Map<String, Object> opt, List<IModel> modelsFiles) throws TransformationException {
		if(opt == null) {
			opt = new HashMap<String, Object>();
		}
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
				logger.error("IO Exception occured while trying to execute transformation",e);
				throw new TransformationException("Script content is not valid", e);
			}
		}
		TransfExecutionResult result = executeTransformation(opt, modelsFiles,
				transformation);
		cleanupTransformation(transformation);
		return result;
	}

	/**
	 * TODO Add docu, why is this needed?
	 * @param transformation
	 */
	private static void cleanupTransformation(
			final QvtInterpretedTransformation transformation) {
		try {
			transformation.cleanup();
		} catch (MdaException ex) {
			logger.warn("Transformation cleanup failed",ex);
		}
	}

	/**
	 * @param opt
	 * @param modelsFiles
	 * @param transformation
	 * @return
	 * @throws TransformationException
	 */
	private static TransfExecutionResult executeTransformation(
			Map<String, Object> opt, List<IModel> modelsFiles,
			final QvtInterpretedTransformation transformation)
			throws TransformationException {
		TransfExecutionResult result;
		try {
			 result = executeTransformation(transformation, modelsFiles, opt);
		} catch (TransformationException ex) {
			logger.error("Transformation execution failed",ex);
			throw new TransformationException("Transformation failed", ex);
		}
		return result;
	}
	
	/**
	 * Load the specified transformation module from the given URI
	 * @param scriptURI The URI of the transformation script
	 * @return The loaded and parsed transformation
	 * @throws TransformationException If something goes wrong
	 */
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
	
	/**
	 * Executes the transformation
	 * @param transformation The transformation to execute
	 * @param models The models which serve as input and as output
	 * @param inConfigProperties Options passed to the transformation
	 * @return The transformation result
	 * @throws TransformationException
	 */
	protected static TransfExecutionResult executeTransformation(final QvtTransformation transformation, final List<IModel> models, final Map<String, Object> inConfigProperties) throws TransformationException {
		List<TransformationParameter> transformationParameters = getFormalTransformationParameters(transformation);
		
		if (models.size() < transformationParameters.size()) {
		    throw new IllegalArgumentException("Model list is incomplete");
		}

		List<IModelTransfTarget> outModels = new ArrayList<IModelTransfTarget>();
		final List<ModelContent> inModels = new ArrayList<ModelContent>();
			
		setupInAndOutModels(transformation, models, transformationParameters,
				outModels, inModels);

		return executeTransformation(transformation, inModels,
				inConfigProperties, outModels);
	}

	/**
	 * @param transformation
	 * @param inModels
	 * @param inConfigProperties
	 * @param outModels
	 * @return
	 * @throws TransformationException
	 */
	private static TransfExecutionResult executeTransformation(
			final QvtTransformation transformation,
			final List<ModelContent> inModels,
			final Map<String, Object> inConfigProperties,
			List<IModelTransfTarget> outModels) throws TransformationException {
		final List<ModelExtentContents> outExtents = new ArrayList<ModelExtentContents>();
		final List<EObject> outMainParams = new ArrayList<EObject>();
		final List<Trace> outTraces = new ArrayList<Trace>(1);
		final List<String> outConsole = new ArrayList<String>(1);
		
		IRunnable innerRunnable = new ShallowProcess.IRunnable() {
			public void run() throws Exception {
				try {
					runTransformation(transformation, inModels, inConfigProperties, outExtents, outMainParams, outTraces, outConsole);
					transformation.cleanup();
				} catch (MdaException ex) {
					logger.error("Transformation execution failed",ex);
					throw new CoreException(new Status(IStatus.ERROR, "", "Transformation failed", ex));
				}
			}
		};
		try {
			QvtLaunchConfigurationDelegateBase.getSafeRunnable(transformation, innerRunnable).run();
		} catch (Exception e) {
			logger.trace("Transformation runnable did not succeed",e);
			logger.error("QVT Operations Transformation failed. See QVT Console for further information...");
			dumpQVTConsole(Level.ERROR,outConsole);
			if (e instanceof QvtRuntimeException) {
				logStackTrace(Level.TRACE,(QvtRuntimeException)e);
			}
			throw new TransformationException("Transformation failed", e);
		}
		for(int i=0; outExtents.size() > i && outModels.size() > i; i++) {
			IModelTransfTarget outModel = outModels.get(i);
			outModel.setRoots(outExtents.get(i).getAllRootElements());
			outModel.setInitialElements(outExtents.get(i).getInitialElements());
		}
		dumpQVTConsole(Level.DEBUG,outConsole);
		return new TransfExecutionResult((outConsole==null || outConsole.size()<1)?"":outConsole.get(0), (outTraces==null || outTraces.size()<1)?null:outTraces.get(0), outMainParams, outModels);
	}

	protected static void runTransformation(QvtTransformation transformation, List<ModelContent> inObjs, Map<String, Object> configProps,
    		List<ModelExtentContents> outExtents, List<EObject> outMainParams, List<Trace> outTraces, List<String> outConsole) throws MdaException {
        // Copied from QvtLaunchConfigurationDelegateBase.class to fix their crapy error handling. 
		// May need updating when new QVTO releases appear
		
		IStatus status = QvtValidator.validateTransformation(transformation, inObjs);                    
        if (status.getSeverity() > IStatus.WARNING) {
        	logger.error("Transformation script is invalid");
        	throw new MdaException(status);
        }      	
    	
        Context context = QvtLaunchUtil.createContext(configProps);

		final StringWriter consoleLogger = new StringWriter();
		context.setLog(new WriterLog(consoleLogger));
    	
		try {
	        TransformationRunner.In in = new TransformationRunner.In(inObjs.toArray(new ModelContent[inObjs.size()]), context);
	        TransformationRunner.Out out = transformation.run(in);

	        outExtents.addAll(out.getExtents());

	        for (Object outValue : out.getOutParamValues()) {
	        	if (outValue instanceof EObject) {
	        		outMainParams.add((EObject) outValue);
	        	}
	        	else {
	        		outMainParams.add(null);
	        	}
	        }
	        if (out.getTrace() != null) {
	        	outTraces.add(out.getTrace());
	        }
		} catch (MdaException e) {
			throw e;
		}
		finally {
			outConsole.add(consoleLogger.getBuffer().toString());	
		}
	}

	/**
	 * @param outConsole
	 */
	private static void dumpQVTConsole(Level p, List<String> outConsole) {
		logger.log(p, "QVT Console output");
		for (String s : outConsole) {
			logger.log(p, s);
		}
	}

	/**
	 * Dump the stack trace of the QVTO Engine
	 * @param trace 
	 * @param e The exception thrown by the QVTO Engine
	 */
	private static void logStackTrace(Level level, QvtRuntimeException e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printQvtStackTrace(pw);
		logger.log(level,sw.toString());
	}

	/**
	 * @param transformation
	 * @param models
	 * @param transformationParameters
	 * @param outModels
	 * @param inModels
	 * @throws TransformationException
	 */
	private static void setupInAndOutModels(
			final QvtTransformation transformation, final List<IModel> models,
			List<TransformationParameter> transformationParameters,
			List<IModelTransfTarget> outModels,
			final List<ModelContent> inModels) throws TransformationException {
		/**
		 * load all input models from file and generate a list of output models
		 */
		Iterator<IModel> iterModel = models.iterator();
		for (TransformationParameter transfParam : transformationParameters) {
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
	}

	/**
	 * @param transformation
	 * @return 
	 * @throws TransformationException
	 */
	private static List<TransformationParameter> getFormalTransformationParameters(
			final QvtTransformation transformation)
			throws TransformationException {
		List<TransformationParameter> transformationParameters;
		try {
			transformationParameters = transformation.getParameters();
		} catch (MdaException ex) {
			logger.error("Failed to read formal transformation parameters", ex);
			throw new TransformationException("Failed to read formal transformation parameters", ex);
		}
		return transformationParameters;
	} 
}