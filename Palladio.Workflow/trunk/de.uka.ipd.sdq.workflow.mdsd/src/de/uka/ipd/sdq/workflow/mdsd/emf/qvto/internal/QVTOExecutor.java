package de.uka.ipd.sdq.workflow.mdsd.emf.qvto.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ModelExtent;

import de.uka.ipd.sdq.workflow.mdsd.Activator;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOResult;

public class QVTOExecutor {

	public static QVTOResult execute(
			URI transformationURI,
			/* INOUT */ List<EObject>[] inoutParameter){
		return QVTOExecutor.execute(transformationURI, new HashMap<String,Object>(), inoutParameter);
	}
	
	public static QVTOResult execute(
			URI transformationURI,
			Map<String,Object> parameters,
			/* INOUT */ List<EObject>[] inoutParameter){

		// create executor for the given transformation
		TransformationExecutor executor = new TransformationExecutor(transformationURI);

		// create the input extent with its initial contents
		ModelExtent[] transformationParameter = new ModelExtent[inoutParameter.length];
		for (int i = 0; i < inoutParameter.length; i++) {
			transformationParameter[i] = new BasicModelExtent();
			if (inoutParameter[i] != null) {
				ArrayList<EObject> contents = new ArrayList<EObject>();
				contents.addAll(inoutParameter[i]);
				transformationParameter[i].setContents(contents);
			}
		}

		// setup the execution environment details -> 
		// configuration properties, logger, monitor object etc.
		ExecutionContextImpl context = new ExecutionContextImpl();
		for (Map.Entry<String,Object> parameter : parameters.entrySet()) {
			context.setConfigProperty(parameter.getKey(), parameter.getValue());
		}
		context.setLog(new QVTOLogger());

		// run the transformation assigned to the executor with the given 
		// input and output and execution context -> ChangeTheWorld(in, out)
		// Remark: variable arguments count is supported
		ExecutionDiagnostic result = executor.execute(context, transformationParameter);

		QVTOResult qvtResult = null;
		// check the result for success
		if(result.getSeverity() != Diagnostic.OK) {
			qvtResult = new QVTOResult(result);
			// turn the result diagnostic into status and send it to error log			
			IStatus status = BasicDiagnostic.toIStatus(result);
			Activator.getDefault().getLog().log(status);
		} else {
			qvtResult = new QVTOResult(result,executor.getLastTrace());
			for (int i = 0; i < inoutParameter.length; i++) {
				assert transformationParameter[i].getContents().size() == 1;
				inoutParameter[i] = transformationParameter[i].getContents();
			}
		}
		
		return qvtResult;
	}
}
