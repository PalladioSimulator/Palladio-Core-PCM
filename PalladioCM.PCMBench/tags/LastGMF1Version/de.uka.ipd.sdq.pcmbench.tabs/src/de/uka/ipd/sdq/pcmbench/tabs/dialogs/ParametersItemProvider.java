package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.tabs.table.ParameterRepresentation;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;

/**
 * @author roman
 * 
 */
public class ParametersItemProvider extends ItemProviderDecorator implements
		ITableItemLabelProvider, IItemLabelProvider {

	private AdapterFactory decoratedFactory;

	/**
	 * Inherited default constructor
	 * 
	 * @param factory
	 *            The factory which created this object
	 */
	public ParametersItemProvider(AdapterFactory adapterFactory,
			AdapterFactory decoratedFactory) {
		super(adapterFactory);
		this.decoratedFactory = decoratedFactory;
		OperationsTabResources.setAttributeDecoratedFactory(decoratedFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnImage(java.lang.Object,
	 *      int)
	 */
	/**
	 * Get the icon by delegation if the first column is displayed
	 */
	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == ParametersDialogResources.ICON_COLUMN_INDEX)
			return this.getImage(object);
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object,
	 *      int) Format the columns with the given index constant as string text
	 *      for displaying
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
		Parameter parameter = (Parameter) element;
		ParameterRepresentation parser = new ParameterRepresentation();

		switch (columnIndex) {
		case ParametersDialogResources.ICON_COLUMN_INDEX:
			break;
		case ParametersDialogResources.CONTEXT_COLUMN_INDEX:
			result = ((Signature) parameter.eContainer()).getServiceName();
			break;
		case ParametersDialogResources.NAME_COLUMN_INDEX:
			if (parameter.getParameterName() != null)
				result = parameter.getParameterName();
			else
				result = "null";
			break;
		case ParametersDialogResources.TYPE_COLUMN_INDEX:
			result = parser.setDataTypeToString(parameter
					.getDatatype__Parameter(), decoratedFactory);
			break;
		default:
			break;
		}
		return parser.isNotNull(result);
	}
}
