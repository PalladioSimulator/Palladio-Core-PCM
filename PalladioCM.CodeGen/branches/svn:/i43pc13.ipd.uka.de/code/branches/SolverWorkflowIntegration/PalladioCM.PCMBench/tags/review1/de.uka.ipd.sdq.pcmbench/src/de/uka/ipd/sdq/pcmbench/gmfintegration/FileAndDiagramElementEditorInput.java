/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.gmfintegration;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @author Snowball
 *
 */
public class FileAndDiagramElementEditorInput extends FileEditorInput {

	protected String diagramRootElement = null;
	
	public String getDiagramRootElementUriFragment() {
		return diagramRootElement;
	}
	
	public EObject getDiagramRootElement(Resource r)
	{
		return r.getEObject(diagramRootElement);
	}

	/**
	 * @param file
	 */
	public FileAndDiagramElementEditorInput(IFile file, EObject diagramRoot) {
		super(file);
		diagramRootElement = diagramRoot.eResource().getURIFragment(diagramRoot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		boolean preResult = super.equals(obj);
		if (preResult == false)
			return false;
		if (!(obj instanceof FileAndDiagramElementEditorInput))
			return false;
		FileAndDiagramElementEditorInput otherElement = (FileAndDiagramElementEditorInput) obj;
		if (!(otherElement.getDiagramRootElementUriFragment().equals(this.getDiagramRootElementUriFragment())))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ diagramRootElement.hashCode();
	}

}
