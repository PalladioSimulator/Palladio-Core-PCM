package de.uka.ipd.sdq.workflow.mdsd.emf;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.IModelTransfTarget;

public class ModelTransfTarget extends ModelTransf implements IModelTransfTarget {
	public ModelTransfTarget(String model) {
		super(model);
	}
	private List<EObject> initElem;
	@Override
	public List<EObject> getInitialElements() {
		return initElem;
	}
	@Override
	public void setInitialElements(List<EObject> initialElements) {
		initElem = initialElements;
	}
}
