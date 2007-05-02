/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProvider;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * @author admin
 *
 */
public class VariableUsageLabelProvider extends ItemProviderDecorator implements
 IItemLabelProvider {

	public VariableUsageLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		
		if (object instanceof Parameter) {
			Parameter parameter = (Parameter) object;
			return parameter.getParameterName();
		}
		
		if (object instanceof CollectionDataType) {
			CollectionDataType dataType = (CollectionDataType) object;
			return "Inner: " + dataType.getEntityName();
		}
		
		if (object instanceof InnerDeclaration) {
			String typeName = "";
			InnerDeclaration declaration = (InnerDeclaration) object;
			DataType dataType = declaration.getDatatype_InnerDeclaration();
			
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

	
	
}
