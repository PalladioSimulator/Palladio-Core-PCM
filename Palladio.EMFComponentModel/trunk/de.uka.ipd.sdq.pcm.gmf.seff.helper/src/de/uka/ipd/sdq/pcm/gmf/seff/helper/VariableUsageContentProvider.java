/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**
 * @author admin
 *
 */
public class VariableUsageContentProvider implements ITreeContentProvider {

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ResourceDemandingSEFF) {
			return getChildren((ResourceDemandingSEFF) inputElement);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parent) {
		
		if (parent instanceof ResourceDemandingSEFF) {
			ResourceDemandingSEFF seff = (ResourceDemandingSEFF) parent;
			return new Object[] {seff.getDescribedService__SEFF()};
		}

		if (parent instanceof Signature) {
			Signature signature = (Signature) parent;
			return signature.getParameters__Signature().toArray();
		}
		
		if (parent instanceof Parameter) {
			Parameter parameter = (Parameter) parent;
			DataType dataType = parameter.getDatatype__Parameter();
			if (dataType instanceof CompositeDataType) {
				return getObjectsCompositeDataType(dataType,parameter);
			}
			return new Object[] {new TreeEntry(dataType,parameter)};
		}
		
		if (parent instanceof TreeEntry) {
			TreeEntry entry = (TreeEntry) parent;
			Object object = entry.getObject();

			if (object instanceof CollectionDataType) {
				CollectionDataType dataType = (CollectionDataType) object;
				DataType innerType = dataType.getInnerType_CollectionDataType();
				if (innerType instanceof PrimitiveDataType)
					return new Object[0];
				return new Object[] { new TreeEntry(innerType, dataType) };
			}
			
			if (object instanceof InnerDeclaration) {
				InnerDeclaration declaration = (InnerDeclaration) object;
				DataType innerType = declaration.getDatatype_InnerDeclaration();
				if (innerType instanceof CollectionDataType) {
					CollectionDataType collDataType = (CollectionDataType) innerType;
					return new Object[] { new TreeEntry(collDataType
							.getInnerType_CollectionDataType(), declaration) };
				}
				if (innerType instanceof CompositeDataType)
					return getObjectsCompositeDataType(innerType,declaration);
			}
		}
		return new Object[0];
	}

	private Object[] getObjectsCompositeDataType(Object object, Object parent) {
		CompositeDataType dataType = (CompositeDataType) object;
		EList<InnerDeclaration> list = dataType
				.getInnerDeclaration_CompositeDataType();
		Object[] objects = new Object[list.size()];
		int i = 0;
		for (InnerDeclaration inner : list)
			objects[i++] = new TreeEntry(inner, parent);
		return objects;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		if (element instanceof TreeEntry){
			TreeEntry entry = (TreeEntry) element;
			return entry.getParent();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof ResourceDemandingSEFF)
			return true;
		if (element instanceof Signature)
			return true;
		if (element instanceof Parameter)
			return true;

		if (element instanceof TreeEntry) {
			TreeEntry entry = (TreeEntry) element;
			if (entry.getObject() instanceof CollectionDataType) {
				CollectionDataType dataType = (CollectionDataType) entry
						.getObject();
				DataType innerType = dataType.getInnerType_CollectionDataType();
				if (innerType instanceof PrimitiveDataType)
					return false;
				return true;
			}
			if (entry.getObject() instanceof InnerDeclaration) {
				InnerDeclaration declaration = (InnerDeclaration) entry
						.getObject();
				DataType dataType = declaration.getDatatype_InnerDeclaration();
				if (dataType instanceof CollectionDataType) {
					CollectionDataType collDataType = (CollectionDataType) dataType;
					DataType innerType = collDataType
							.getInnerType_CollectionDataType();
					if (innerType instanceof PrimitiveDataType)
						return false;
				}

				if (dataType instanceof PrimitiveDataType)
					return false;
				return true;
			}
		}
		return false;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}
}
class TreeEntry extends EObjectImpl{
	
	private Object object;
	private Object parent;
	/**
	 * @param child
	 * @param parent
	 */
	public TreeEntry(Object object, Object parent) {
		this.object = object;
		this.parent = parent;
	}
	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	/**
	 * @return the parent
	 */
	public Object getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Object parent) {
		this.parent = parent;
	}
	
	
}
