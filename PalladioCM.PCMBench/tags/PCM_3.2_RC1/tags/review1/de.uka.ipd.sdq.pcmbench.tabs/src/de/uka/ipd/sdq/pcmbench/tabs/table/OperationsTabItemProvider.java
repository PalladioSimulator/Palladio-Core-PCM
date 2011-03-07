package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Iterator;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;


/**
 * @author Snowball
 * This class is a decorator for the generated EMF.Edit item providers. It provides item
 * providers which are used in the operations tab of the tabbed properties sheet when editing
 * interfaces. It implements ITableItemLabelProvider to display the given EObject in a tabular form.
 * Additionally it provided the labels by partcial delegation to the original IItemLabelProvider.
 */
public class OperationsTabItemProvider extends ItemProviderDecorator 
implements ITableItemLabelProvider, IItemLabelProvider {

	/**
	 * Inherited default constructor
	 * @param factory The factory which created this object
	 */
	public OperationsTabItemProvider(AdapterFactory factory) {
		super(factory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnImage(java.lang.Object, int)
	 */
	/**
	 * Get the icon by delegation if the first column is displayed
	 */
	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == OperationsPropertySectionTable.ICON_COLUMN_INDEX)
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
		Signature signature = (Signature)element;
		
		switch (columnIndex) {
			case OperationsPropertySectionTable.ICON_COLUMN_INDEX:
				break;
			case OperationsPropertySectionTable.PARAMETER_COLUMN_INDEX :
				result = setParametersToString(signature.getParameters__Signature());
				break;
			case OperationsPropertySectionTable.RETURNTYPE_COLUMN_INDEX :
				result = dataTypeFormater(signature.getReturntype__Signature());
				break;
			case OperationsPropertySectionTable.SIGNATURENAME_COLUMN_INDEX :
				result = signature.getServiceName();
				break;
			case OperationsPropertySectionTable.EXCEPTIONS_COLUMN_INDEX :
				result = setParametersToString(signature.getExceptions__Signature());
				break;
			default :
				break; 	
		}
		return result == null ? "" : result;
	}

	private String setParametersToString(EList parameters) {
		
		String result = "";
		Parameter parameter;
		
		for(Iterator<Parameter> it = parameters.iterator(); it.hasNext(); ){
			parameter = it.next();
			result += dataTypeFormater(parameter.getDatatype__Parameter())
								+ " " + parameter.getParameterName() + ", ";
		}
		if(!result.equals("")){
			result = result.substring(0, result.length()-2);
		}
		return result;
	}
	
	private String dataTypeFormater(DataType d)
	{
		if (d == null)
			return "void";
		return nullSafeFormater(d.getType(), "void");
	}
	
	private String nullSafeFormater(String s, String alternativeText)
	{
		return s == null ? s : alternativeText;
	}
}
