/**
 * 
 */
package de.uka.ipd.sdq.pcm.dialogs.variableusage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.pcm.dialogs.datatype.DataTypeContainer;
import de.uka.ipd.sdq.pcm.dialogs.datatype.InnerDeclarationContainer;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
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
		if (inputElement instanceof Signature) {
			return getChildren(inputElement);
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
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parent) {
		/**
		 * SEFF
		 */
		if (parent instanceof ResourceDemandingSEFF) {
			ResourceDemandingSEFF seff = (ResourceDemandingSEFF) parent;
			return new Object[] {seff.getDescribedService__SEFF()};
		}
		
		/**
		 * Parameter
		 */
		if (parent instanceof Variable) {
			Variable parameter = (Variable) parent;
			DataType dataType = (DataType) parameter.getDataType__Variable();
			
			if (dataType instanceof CompositeDataType) {
				return getCompositeTypeElements(dataType, parameter);
			}
			else if (dataType instanceof CollectionDataType) {
				return new Object[] {new DataTypeContainer(((CollectionDataType)dataType).getInnerDataType__CollectionDataType(),parent)};
			}
			else
				return new Object[]{};
		}
		
		/**
		 * TreeType
		 */
		if (parent instanceof DataTypeContainer) {
			DataType innerType = getTreeTypeInner(parent);
			
			if (innerType instanceof PrimitiveDataType)
				return new Object[0];
			
			if (innerType instanceof CompositeDataType)
				return getCompositeTypeElements(innerType,parent);
			
			return new Object[] { new DataTypeContainer(innerType,parent) };
		}
		
		/**
		 * TreeDeclaration
		 */
		if (parent instanceof InnerDeclarationContainer) {
			DataType innerType = getTreeDeclarationInner(parent);

			if (innerType instanceof CompositeDataType) {
				return getCompositeTypeElements(innerType, parent);
			}

			CollectionDataType collDataType = (CollectionDataType) innerType;
			return new Object[] { new DataTypeContainer(collDataType
					.getInnerDataType__CollectionDataType(),parent) };
		}

		return new Object[0];
	}

	/**
	 * @return - return the DataType from InnerDeclaration of
	 *         TreeDeclaration-Object
	 */
	private DataType getTreeDeclarationInner(Object parent) {
		InnerDeclarationContainer treeDeclaration = (InnerDeclarationContainer) parent;
		Variable declaration = (Variable) treeDeclaration
				.getObject();
		return declaration.getDataType__Variable();
	}

	/**
	 * @return - return the DataType from inner collection datatype of
	 *         TreeType-Object
	 */
	private DataType getTreeTypeInner(Object parent) {
		DataTypeContainer treeType = (DataTypeContainer) parent;
		DataType dataType = (DataType) treeType.getObject();
		
		if (dataType instanceof PrimitiveDataType) {
			return dataType;
			
		}
		CollectionDataType collDataType = (CollectionDataType) dataType;
		return collDataType.getInnerDataType__CollectionDataType();
	}
	
	/**
	 * TODO
	 * 
	 * @return - array of TreeDeclaration from composite datatype
	 */
	private Object[] getCompositeTypeElements(DataType dataType, Object parent) {
		CompositeDataType compDataType = (CompositeDataType) dataType;
		EList<Variable> list = compDataType
				.getMembers__CompositeDataType();
		Object[] objects = new Object[list.size()];
		
		int i = 0;
		
		for (Variable inner : list)
			objects[i++] = new InnerDeclarationContainer(inner, parent);
		
		return objects;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		
		if (element instanceof Variable) {
			Variable parameter = (Variable) element;
			DataType dataType = parameter.getDataType__Variable();
			return hasChildren(dataType);
		}
		
		if (element instanceof DataTypeContainer){
			DataType innerType = getTreeTypeInner(element);
			return hasChildren(innerType);
		}
		
		if (element instanceof InnerDeclarationContainer){
			DataType dataType = getTreeDeclarationInner(element);
			return hasChildren(dataType);
		}
		
		if (element instanceof PrimitiveDataType)
			return false;
		
		return true;
	}
}




