package de.uka.ipd.sdq.workflow.mdsd.emf.qvto;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public interface IModelTransfTarget extends IModel {
	public List<EObject> getInitialElements();
	public void setInitialElements(List<EObject> initialElements);
}