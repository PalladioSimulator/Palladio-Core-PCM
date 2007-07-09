package de.uka.ipd.sdq.dialogs.datatype;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.dialogs.parameters.CreateEditorContents;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;

/**
 * @author admin
 * 
 */
public class InnerDeclarationItemProvider extends ItemProviderDecorator implements
ITableItemLabelProvider, IItemLabelProvider {

	/**
	 * @param adapterFactory
	 */
	public InnerDeclarationItemProvider(AdapterFactory adapterFactory){
		super(adapterFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnImage(java.lang.Object,
	 *      int)
	 */
	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == CreateEditorContents.ICON_COLUMN_INDEX)
			return this.getImage(object);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnText(java.lang.Object,
	 *      int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		String result = "";

		InnerDeclaration declaration = (InnerDeclaration) element;

		switch (columnIndex) {
		case CreateEditorContents.ICON_COLUMN_INDEX:
			break;
		case CreateEditorContents.CONTEXT_COLUMN_INDEX:
			result = declaration.getClass().getSimpleName();
			break;
		case CreateEditorContents.NAME_COLUMN_INDEX:
			if (declaration != null)
				result = declaration.getEntityName();
			break;
		case CreateEditorContents.TYPE_COLUMN_INDEX:
			result = ParameterRepresentation.setDataTypeToString(declaration
					.getDatatype_InnerDeclaration());
			break;
		default:
			break;
		}
		return ParameterRepresentation.isNotNull(result);
	}
}
