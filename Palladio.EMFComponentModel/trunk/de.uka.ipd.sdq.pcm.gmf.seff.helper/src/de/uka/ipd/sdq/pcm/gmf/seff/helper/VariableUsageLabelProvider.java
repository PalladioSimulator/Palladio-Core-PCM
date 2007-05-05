/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;

/**
 * @author admin
 *
 */
public class VariableUsageLabelProvider extends ItemProviderDecorator implements
 IItemLabelProvider {

	public VariableUsageLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getImage(Object object) {
		
		if (object instanceof TreeType) {
			TreeType treeType = (TreeType) object;
			return super.getImage(treeType.getObject());
		}
		
		if (object instanceof TreeDeclaration) {
			TreeDeclaration treeDeclaration = (TreeDeclaration) object;
			return super.getImage(treeDeclaration.getObject());
		}

		return super.getImage(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		
		if (object instanceof Parameter)
			return ((Parameter) object).getParameterName();
		
		if (object instanceof TreeType) {
			DataType dataType = getTreeTypeObject(object);
			if (dataType instanceof PrimitiveDataType) {
				PrimitiveDataType primDataType = (PrimitiveDataType) dataType;
				return  "INNER: " + primDataType.getType().getName();
			}
			CollectionDataType collDataType = (CollectionDataType) dataType;
			return "INNER: " + collDataType.getEntityName();
		}
		
		if (object instanceof TreeDeclaration) {
			InnerDeclaration declaration = getTreeDeclarationObject(object);
			DataType dataType = declaration.getDatatype_InnerDeclaration();
			
			String typeName = "";

			if (dataType instanceof CollectionDataType) {
				CollectionDataType collType = (CollectionDataType) dataType;
				typeName = collType.getEntityName();
			}
			if (dataType instanceof CompositeDataType) {
				CompositeDataType compType = (CompositeDataType) dataType;
				typeName = compType.getEntityName();
			}
			if (dataType instanceof PrimitiveDataType) {
				PrimitiveDataType primType = (PrimitiveDataType) dataType;
				typeName = primType.getType().getName();
			}
			
			return declaration.getEntityName() + ": " + typeName;
		}
		return super.getText(object);
	}

	/**
	 * @return - return the DdataType from TreeType-Object
	 */
	private DataType getTreeTypeObject(Object object){
		TreeType treeType = (TreeType)object;
		return (DataType) treeType.getObject();
	}
	
	/**
	 * @return - return the InnerDeclaration from TreeDeclaration-Object
	 */
	private InnerDeclaration getTreeDeclarationObject(Object object) {
		TreeDeclaration treeDeclaration = (TreeDeclaration) object;
		return (InnerDeclaration) treeDeclaration.getObject();
	}
}
