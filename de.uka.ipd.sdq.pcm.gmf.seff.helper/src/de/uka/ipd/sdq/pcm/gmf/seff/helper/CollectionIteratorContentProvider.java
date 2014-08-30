package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;

// FIXME: Find out what roman wanted to say in this comment.
/**
 * The Class CollectionIteratorContentProvider.
 * 
 * The ContentProvider for SelectObjectDialog. The Dialog will coll from
 * ParameterCollectionIteratorActionEditHelperAdvice. Are only indicated parameter, which have an
 * inside type CollectionDataType.
 * 
 * @author roman
 * 
 */
public class CollectionIteratorContentProvider implements ITreeContentProvider {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    /**
     * Gets the children.
     * 
     * @param parent
     *            the parent
     * @return the children
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    @Override
    public Object[] getChildren(final Object parent) {

        if (parent instanceof OperationInterface) {
            final OperationInterface interf = (OperationInterface) parent;
            return interf.getSignatures__OperationInterface().toArray();
        }

        if (parent instanceof OperationSignature) {
            final OperationSignature signature = (OperationSignature) parent;
            final ArrayList<Parameter> collParameters = new ArrayList<Parameter>();
            final EList<Parameter> parameters = signature.getParameters__OperationSignature();
            for (final Parameter p : parameters) {
                final DataType dataType = p.getDataType__Parameter();
                if (dataType instanceof CollectionDataType) {
                    collParameters.add(p);
                }
            }
            return collParameters.toArray();
        }
        return new Object[0];
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    /**
     * Gets the parent.
     * 
     * @param element
     *            the element
     * @return the parent
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    @Override
    public Object getParent(final Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    /**
     * Checks for children.
     * 
     * @param element
     *            the element
     * @return true, if successful
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    @Override
    public boolean hasChildren(final Object element) {
        if (element instanceof Interface) {
            return true;
        }
        if (element instanceof Signature) {
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    /**
     * Gets the elements.
     * 
     * @param inputElement
     *            the input element
     * @return the elements
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
     */
    @Override
    public Object[] getElements(final Object inputElement) {
        if (inputElement instanceof Interface) {
            return this.getChildren(inputElement);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    /**
     * Dispose.
     * 
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
     * java.lang.Object, java.lang.Object)
     */
    /**
     * Input changed.
     * 
     * @param viewer
     *            the viewer
     * @param oldInput
     *            the old input
     * @param newInput
     *            the new input
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
        // TODO Auto-generated method stub

    }

}
