package de.uka.ipd.sdq.workflow.mdsd.emf.qvto;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public interface IModel {

	public EObject getRoot();
	public void setRoots(List<EObject> content);
	public List<EObject> getRoots();
	public URI getUri();

}