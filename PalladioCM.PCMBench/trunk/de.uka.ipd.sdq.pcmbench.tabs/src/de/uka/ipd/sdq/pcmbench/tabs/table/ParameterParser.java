package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcmbench.ui.provider.RepositoryPrinter;

public class ParameterParser {

	public String setParametersToString(EList parameters) {
		
		String result = "";
		RepositoryPrinter rPrinter = new RepositoryPrinter();
		
		for(Iterator<Parameter> it = parameters.iterator(); it.hasNext(); ){
			result += (String) rPrinter.caseParameter(it.next()) + ", "; 
		}
		return deleteComma(result);
	}

	/**
	 * Comma of the sentence deletes ends
	 */
	public String deleteComma(String result) {
		if(!result.equals("")){
			result = result.substring(0, result.length()-2);
		}
		return result;
	}
	
	public String setExceptionsToString(EList exceptions){
		
		String result = "";
		ExceptionType exceptionType;
		
		for(Iterator<ExceptionType> it = exceptions.iterator(); it.hasNext(); ){
			exceptionType =  it.next();
			result += exceptionType.getExceptionName() + ", "; 
		}
		return deleteComma(result);
		
	}
	
	public String dataTypeFormater(DataType dataType)
	{
		//if (dataType == null || dataType.getType() == null)
//			return "void";
//		else return dataType.getType();
		// TODO: Fix me
		return "";
	}
	
	public String isNotNull(String string){
		return string == null ? "" : string;
	}
}
