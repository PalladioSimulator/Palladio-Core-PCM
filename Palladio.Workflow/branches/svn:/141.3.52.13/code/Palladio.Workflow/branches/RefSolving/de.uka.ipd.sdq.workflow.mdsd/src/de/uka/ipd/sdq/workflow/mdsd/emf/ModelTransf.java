package de.uka.ipd.sdq.workflow.mdsd.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.IModel;

public class ModelTransf implements IModel {
	URI uri;
	private List<EObject> roots = new ArrayList<EObject>();

	public ModelTransf(String model) {
		if (model.indexOf(":/") >= 0) {
			uri = URI.createURI(model);
		} else {
			uri = URI.createFileURI(model);
		}
	}
	
	@Override
	public List<EObject> getRoots() {
		return roots;
	}

	@Override
	public EObject getRoot() {
		if(roots.size()<1)
			return null;
		return roots.get(0);
	}

	@Override
	public URI getUri() {
		return uri;
	}

	@Override
	public void setRoots(List<EObject> content) {
		if(roots != null)
			roots = content;
	}
}
