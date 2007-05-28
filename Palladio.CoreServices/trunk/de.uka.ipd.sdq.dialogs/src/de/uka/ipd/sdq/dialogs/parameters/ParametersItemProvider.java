package de.uka.ipd.sdq.dialogs.parameters;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.dialogs.datatype.ParameterRepresentation;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * @author roman
 * 
 */
public class ParametersItemProvider extends ItemProviderDecorator implements
		ITableItemLabelProvider, IItemLabelProvider {

	/**
	 * Inherited default constructor
	 * 
	 * @param factory
	 *            The factory which created this object
	 */
	public ParametersItemProvider(AdapterFactory adapterFactory){
		super(adapterFactory);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnImage(java.lang.Object,
	 *      int) Get the icon by delegation if the first column is displayed
	 */
	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == CreateEditorContents.ICON_COLUMN_INDEX)
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

		switch (columnIndex) {
		case CreateEditorContents.ICON_COLUMN_INDEX:
			break;
		case CreateEditorContents.CONTEXT_COLUMN_INDEX:
			result = ((Signature) parameter.eContainer()).getServiceName();
			break;
		case CreateEditorContents.NAME_COLUMN_INDEX:
			if (parameter.getParameterName() != null)
				result = parameter.getParameterName();
			else
				result = "null";
			break;
		case CreateEditorContents.TYPE_COLUMN_INDEX:
			result = ParameterRepresentation.setDataTypeToString(parameter
					.getDatatype__Parameter());
			break;
		default:
			break;
		}
		return ParameterRepresentation.isNotNull(result);
	}
}
