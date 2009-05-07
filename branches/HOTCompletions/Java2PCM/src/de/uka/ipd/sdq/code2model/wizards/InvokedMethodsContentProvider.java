package de.uka.ipd.sdq.code2model.wizards;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.code2model.wrappers.Method;
import de.uka.ipd.sdq.code2model.wrappers.Package;

/**
 * The content provider for the wizard page where the user can select among all
 * methods invoked in the selection, grouped by package. The objects handled
 * here must be {@link Package}s.
 * 
 * @author thomas
 */
public class InvokedMethodsContentProvider implements ITreeContentProvider {

	protected static final Object[] NO_CHILDREN = new Object[0];
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement == null) {
			return NO_CHILDREN;
		}
		
		if (parentElement instanceof Package) {
			Package pkg = (Package) parentElement;
			return pkg.getChildren();
		}
		
		return NO_CHILDREN;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		if (element instanceof Method) {
			Method method = (Method) element;
			return method.getPackage();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof Package) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// EMPTY because we provide no images to clear from memory
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// EMPTY
	}

}
