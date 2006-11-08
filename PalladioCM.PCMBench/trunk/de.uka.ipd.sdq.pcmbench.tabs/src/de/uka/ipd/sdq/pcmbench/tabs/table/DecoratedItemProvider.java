package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Iterator;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;

public class DecoratedItemProvider extends ItemProviderDecorator 
implements ITableItemLabelProvider, IItemLabelProvider {

	public DecoratedItemProvider(AdapterFactory factory) {
		super(factory);
	}

	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == 0)
			return this.getImage(object);
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
		Signature signature = (Signature)element;
		
		switch (columnIndex) {
			case 0:
				break;
			case 1 :
				result = setParametersToString(signature.getParameters__Signature());
				break;
			case 2 :
				if(signature.getReturntype__Signature() != null){
					result = signature.getReturntype__Signature().getType(); 
				} else result = "void";
				break;
			case 3 :
				result = signature.getServiceName();
				break;
			case 4 :
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
			if(parameter.getDatatype__Parameter() != null){
				result += parameter.getDatatype__Parameter().getType()
								+ " " + parameter.getParameterName() + ", ";
				
			} else result += "void";
		}
		if(!result.equals("") && !result.equals("void")){
			result = result.substring(0, result.length()-3);
		}
		return result;
	}
}
