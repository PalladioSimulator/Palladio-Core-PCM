package de.uka.ipd.sdq.pcm.transformations;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.OCL;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;

public abstract class AllInstancesTransformer<T> {

	private EObject rootNode;
	private EClassifier eClass;

	public AllInstancesTransformer(EClassifier eClass, EObject rootNode) {
		super();
		this.rootNode = rootNode;
		this.eClass = eClass;
	}

	@SuppressWarnings("unchecked")
	public void transform() throws JobFailedException {
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();

		try {
			Set<EObject> result = (Set<EObject>) new SELECT(
				    new FROM(rootNode),
				    new WHERE(new BooleanOCLCondition<EClassifier, EClass, EObject>(
				    	ocl.getEnvironment(),
				        "true",
				        eClass))).getEObjects();
			for(EObject eObject : result) {
        		transform((T)eObject);
			}
    	} catch (Exception ex) {
			throw new JobFailedException("Transformation failed",ex);
    	}
	}

	protected abstract void transform(T object);
}
