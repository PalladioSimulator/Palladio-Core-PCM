package de.uka.sdq.pcm.transformations;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.OCL;
import org.openarchitectureware.workflow.issues.Issues;

public abstract class AllInstancesTransformer<T> {

	private EObject rootNode;
	private EClassifier eClass;

	public AllInstancesTransformer(EClassifier eClass, EObject rootNode) {
		super();
		this.rootNode = rootNode;
		this.eClass = eClass;
	}

	@SuppressWarnings("unchecked")
	public void transform(final Issues issues) {
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
			issues.addError("Exception during M2M transformation: " + ex.getClass().getName() + " Exception message: " + ex.getMessage());
    	}
	}

	protected abstract void transform(T object);
}
