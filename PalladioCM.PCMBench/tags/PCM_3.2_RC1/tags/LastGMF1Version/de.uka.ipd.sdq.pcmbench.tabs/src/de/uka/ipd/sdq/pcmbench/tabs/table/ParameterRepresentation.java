package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.Parameter;

/**
 * @author roman
 * Responsibly for representation different Signature propertys (ReturnType, Parameters, Exceptions), as string
 */
public class ParameterRepresentation {

	/**
	 * @param DataType
	 * @param AdapterFactory
	 * @return String
	 */
	public String setDataTypeToString(DataType returnType,
			AdapterFactory decoratedFactory) {

		String result = "";

		if (returnType != null) {
			IItemLabelProvider datatypeProvider = (IItemLabelProvider) decoratedFactory
					.adapt((Object) returnType, IItemLabelProvider.class);
			result = datatypeProvider.getText(returnType);
		}

		return result;
	}

	public String setParametersToString(EList parameters) {

		String result = "";

		for (Iterator<Parameter> it = parameters.iterator(); it.hasNext();) {
			result += it.next().getParameterName() + ", ";
		}
		return deleteComma(result);
	}

	/**
	 * Comma of the sentence deletes ends
	 */
	public String deleteComma(String result) {
		if (!result.equals("")) {
			result = result.substring(0, result.length() - 2);
		}
		return result;
	}

	public String setExceptionsToString(EList exceptions) {

		String result = "";
		ExceptionType exceptionType;

		for (Iterator<ExceptionType> it = exceptions.iterator(); it.hasNext();) {
			exceptionType = it.next();
			result += exceptionType.getExceptionName() + ", ";
		}
		return deleteComma(result);

	}


	public String isNotNull(String string) {
		return string == null ? "" : string;
	}
}
