package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;
import de.uka.ipd.sdq.pcmbench.tabs.table.ParameterRepresentation;

/**
 * @author admin
 * 
 */
public class DeclarationItemProvider extends ItemProviderDecorator implements
ITableItemLabelProvider, IItemLabelProvider {

	private AdapterFactory decoratedFactory;

	/**
	 * @param adapterFactory
	 */
	public DeclarationItemProvider(AdapterFactory adapterFactory,
			AdapterFactory decoratedFactory) {
		super(adapterFactory);
		this.decoratedFactory = decoratedFactory;
		OperationsTabResources.setDeclarationDecoratedFactory(decoratedFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnImage(java.lang.Object,
	 *      int)
	 */
	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == ParametersDialogResources.ICON_COLUMN_INDEX)
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
		ParameterRepresentation parser = new ParameterRepresentation();

		InnerDeclaration declaration = (InnerDeclaration) element;

		switch (columnIndex) {
		case ParametersDialogResources.ICON_COLUMN_INDEX:
			break;
		case ParametersDialogResources.CONTEXT_COLUMN_INDEX:
			result = declaration.getClass().getSimpleName();
			break;
		case ParametersDialogResources.NAME_COLUMN_INDEX:
			if (declaration != null)
				result = declaration.getEntityName();
			break;
		case ParametersDialogResources.TYPE_COLUMN_INDEX:
			result = parser.setDataTypeToString(declaration
					.getDatatype_InnerDeclaration(), decoratedFactory);
			break;
		default:
			break;
		}
		return parser.isNotNull(result);
	}
}
