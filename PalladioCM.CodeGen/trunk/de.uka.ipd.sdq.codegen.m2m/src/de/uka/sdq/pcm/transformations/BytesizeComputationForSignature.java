package de.uka.sdq.pcm.transformations;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.Signature;

public class BytesizeComputationForSignature {

	public String getBytesizeForSignature(Signature sig){
		
		StringBuffer result = new StringBuffer();
		
		EList<Parameter> params = sig.getParameters__Signature();
		for (Parameter param : params){
			DataType dataType = param.getDatatype__Parameter();
			result.append(getCharacterisationString(dataType, param.getParameterName()));
		}
		
		int length = result.length();
		if (length > 0) result.delete(length-3, length); // remove last " + "
		
		return result.toString();
	}

	
	private String getCharacterisationString(DataType dataType, String name){
		StringBuffer result = new StringBuffer();
		if (dataType instanceof PrimitiveDataType){
			result.append(name+".BYTESIZE + ");
		} else if (dataType instanceof CollectionDataType){
			result.append(name+".NUMBER_OF_ELEMENTS * "+
					name+".INNER.BYTESIZE + ");
		} else if (dataType instanceof CompositeDataType){
			CompositeDataType compDataType = (CompositeDataType)dataType;
			EList<InnerDeclaration> innerList = compDataType.getInnerDeclaration_CompositeDataType();
			for (InnerDeclaration decl : innerList){
				DataType innerDataType = decl.getDatatype_InnerDeclaration();
				result.append(getCharacterisationString(innerDataType, name+"."+decl.getEntityName()));
			}
		}
		return result.toString();
	}
}
