/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

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
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ResourceDemandingSEFF) {
			return getChildren((ResourceDemandingSEFF) inputElement);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
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
				CompositeDataType compType = (CompositeDataType) dataType;
				return compType.getInnerDeclaration_CompositeDataType().toArray();
			}
			return new Object[] {dataType};
		}
		
		if (parent instanceof CollectionDataType) {
			CollectionDataType dataType = (CollectionDataType) parent;
			DataType innerType = dataType.getInnerType_CollectionDataType();
			if (innerType instanceof PrimitiveDataType)
				return new Object[0];
			return new Object[] {innerType};
		}
		
		if (parent instanceof CompositeDataType) {
			CompositeDataType dataType = (CompositeDataType) parent;
			return dataType.getInnerDeclaration_CompositeDataType().toArray();
		}
		
		if (parent instanceof InnerDeclaration) {
			InnerDeclaration declaration = (InnerDeclaration) parent;
			DataType innerType = declaration.getDatatype_InnerDeclaration();
			
			if (innerType instanceof CollectionDataType) {
				CollectionDataType collDataType = (CollectionDataType) innerType;
				return new Object[] {collDataType.getInnerType_CollectionDataType()};
			}
			
			if (innerType instanceof CompositeDataType) {
				CompositeDataType compDataType = (CompositeDataType) innerType;
				return compDataType.getInnerDeclaration_CompositeDataType().toArray();
			}
			
//			if (innerType instanceof PrimitiveDataType)
//				return new Object[0];
		}
		return new Object[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ResourceDemandingSEFF)
			return true;
		if (element instanceof Signature)
			return true;
		if (element instanceof Parameter)
			return true;
		if (element instanceof CollectionDataType){
			CollectionDataType dataType = (CollectionDataType) element;
			DataType innerType = dataType.getInnerType_CollectionDataType();
			if (innerType instanceof PrimitiveDataType)
				return false;
			return true;
		}
		if (element instanceof CompositeDataType)
			return true;
		if (element instanceof InnerDeclaration){
			InnerDeclaration declaration = (InnerDeclaration) element;
			DataType dataType = declaration.getDatatype_InnerDeclaration();
			if (dataType instanceof CollectionDataType){
				CollectionDataType collDataType = (CollectionDataType) dataType;
				DataType innerType = collDataType.getInnerType_CollectionDataType();
				if (innerType instanceof PrimitiveDataType)
					return false;
			}
				
			if (dataType instanceof PrimitiveDataType)
				return false;
			return true;
		}
		return false;
	}

}
