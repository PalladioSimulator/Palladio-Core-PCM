package de.uka.sdq.pcm.transformations;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SET;
import org.eclipse.emf.query.statements.UPDATE;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.system.System;

public class TransformationWorkflowComponent 
	extends AbstractWorkflowComponent2 {

	System resource = null;
	
	@Override
	protected void checkConfigurationInternal(Issues arg0) {
	}

	@Override
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor,
			Issues issues) {
		this.resource = (de.uka.ipd.sdq.pcm.system.System) context.get("pcmmodel");
		performTransformation(issues);
	}

	@SuppressWarnings("unchecked")
	private void performTransformation(Issues issues) {
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();

		try {
			new UPDATE(
				    new FROM(resource),
				    new WHERE(new BooleanOCLCondition<EClassifier, EClass, EObject>(
				    	ocl.getEnvironment(),
				        "true",
				        CompositionPackage.eINSTANCE.getAssemblyConnector())),
				    new SET() {
				        public boolean set(EObject eObject) {
				        	transform(eObject);
							return true;
				        }}).execute();
		} catch (ParserException e) {
			issues.addError("Parser error on OCL: "+e.getMessage());
		}
	}

	protected void transform(EObject object) {
		AssemblyConnector con = (AssemblyConnector) object;
		java.lang.System.out.println("con "+con.getEntityName());
	}

}
