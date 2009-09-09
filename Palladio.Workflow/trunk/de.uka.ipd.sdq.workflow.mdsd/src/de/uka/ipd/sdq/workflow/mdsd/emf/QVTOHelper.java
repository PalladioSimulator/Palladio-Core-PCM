package de.uka.ipd.sdq.workflow.mdsd.emf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.qvt.oml.runtime.util.QvtoTransformationHelper;
import org.eclipse.m2m.qvt.oml.runtime.util.QvtoTransformationHelper.TransfExecutionResult;
import org.eclipse.osgi.util.NLS;

/**
 * QVT OperationalMapping Transformation Helper, based on qvt-oml belongs to M2M umbrella
 * @author Andrea Ciancone
 *
 */
public class QVTOHelper {
	/**
	 * Executes model transformation
	 * @param scriptURI Filename containing the transformation code 
	 * @param modelArgs Ordered list of all input models used by the transformation 
	 * @return the transformation result
	 * @throws CoreException raised in case the transformation fails 
	 */
	public static TransfExecutionResult runTransf(String scriptURI, List<EObject> modelArgs) throws CoreException {
		assert(scriptURI.length()>0);
		assert(modelArgs.size()>0);

		URI scriptUri = URI.createURI(scriptURI);
		
		return new QvtoTransformationHelper(scriptUri).executeTransformation(modelArgs, Collections.<String, Object> emptyMap(), null);
	}
	/**
	 * Executes model transformation
	 * @param scriptURI Filename containing the transformation code 
	 * @param modelsURI Ordered list of files uri containing input models used by the transformation
	 * @param outModel if initialize at the end will be filled with the files uri of the output models 
	 * @return the transformation result
	 * @throws CoreException raised in case the transformation fails 
	 */
	public static TransfExecutionResult runTransf(String scriptURI, List<String> modelsURI, List<URI> outModel) throws Exception {
    	QvtTransformation transformation = new QvtInterpretedTransformation(TransformationUtil.getQvtModule(toUri(scriptURI)));
    	List<EObject> inObjects = new ArrayList<EObject>();
    	
		if (modelsURI.size() <transformation.getParameters().size()) {
            throw new MdaException("Model list incomplete");
		}

		/**
		 * load all input models from file and generate a list of output models
		 */
		Iterator<String> iterModel = modelsURI.iterator();
    	for (TransformationParameter transfParam : transformation.getParameters()) {
			URI model = toUri(iterModel.next());
			if (transfParam.getDirectionKind() == DirectionKind.IN || transfParam.getDirectionKind() == DirectionKind.INOUT) {
		        //EObject inObj = transformation.loadInput(model);
				EObject inObj = transformation.loadInput(model);
		        inObjects.add(inObj);
			}
			if (transfParam.getDirectionKind() == DirectionKind.OUT || transfParam.getDirectionKind() == DirectionKind.INOUT) {
				if(outModel != null)
					outModel.add(model);
			}
		}
	
//	    String traceFileName = "platform:/resource/xxx.qvtotrace";
	    return runTransf(scriptURI, inObjects);
	}
 
    private static URI toUri(String uriString) throws MdaException {
        URI uri = URI.createURI(uriString);  
        if(uri == null) {
            throw new MdaException(NLS.bind("Invalid URI", uriString));
        }
        
        return uri;
    }
}