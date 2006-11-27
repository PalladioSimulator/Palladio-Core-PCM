package de.uka.ipd.sdq.pcmbench.tabs.dialog;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.tabs.table.ParameterParser;

/**
 * @author admin
 *
 */
public class AttributesItemProvider extends ItemProviderDecorator
		implements ITableItemLabelProvider, IItemLabelProvider {
	
	AttributeCellModifier cellModifier = new AttributeCellModifier();
	/**
	 * Inherited default constructor
	 * @param factory The factory which created this object
	 */
	public AttributesItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnImage(java.lang.Object, int)
	 */
	/**
	 * Get the icon by delegation if the first column is displayed
	 */
	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == AttributesViewer.ICON_COLUMN_INDEX)
			return this.getImage(object);
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 * Format the columns with the given index constant as string text for displaying
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
		Parameter parameter  = (Parameter) element;
		ParameterParser parameterParser = new ParameterParser();
		
		switch (columnIndex) {
			case AttributesViewer.ICON_COLUMN_INDEX:
				break;
			case AttributesViewer.CONTEXT_COLUMN_INDEX :
				result = ((Signature) parameter.eContainer()).getServiceName();
				break;
			case AttributesViewer.NAME_COLUMN_INDEX :
				//TODO Fix mich
				if (parameter.getParameterName()== null)
					result = "null";
				else result = parameter.getParameterName();
				break;
			case AttributesViewer.TYPE_COLUMN_INDEX:
				
				//TODO Fix mich
				if(parameter.getDatatype__Parameter()!= null)
					result = parameter.getDatatype__Parameter().toString();
				break;
			default :
				break; 	
		}
		return parameterParser.isNotNull(result);
	}
}
