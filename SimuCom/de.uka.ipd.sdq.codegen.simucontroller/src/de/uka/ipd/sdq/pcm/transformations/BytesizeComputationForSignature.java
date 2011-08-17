package de.uka.ipd.sdq.pcm.transformations;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * Responsible for determining a bytesize characterisation string for parameters in a signature. 
 * @author Steffen
 *
 */
public class BytesizeComputationForSignature {
	
	/**
	 * @author   Snowball
	 */
	public enum Modifier{
		IN,
		OUT
	}
	
	/**
	 * Composes a String, which includes the sum of BYTESIZE 
	 * characterisation strings for all the parameters of a given signature.
	 * For example: 
	 * <code>void foo(int bar, File blub)</code>
	 * would be tranformed into
	 * <code>"bar.BYTESIZE + blub.BYTESIZE"</code>
	 * 
	 * @param sig
	 * @param mod
	 * @return
	 */
	public static String getBytesizeForSignature(Signature sig, Modifier mod){
		StringBuffer result = new StringBuffer();
		
		EList<Parameter> params = sig.getParameters__Signature();
		for (Parameter param : params){
			DataType dataType = param.getDatatype__Parameter();
			ParameterModifier parMod = param.getModifier__Parameter();
			if (mod == Modifier.IN){
				if (parMod == ParameterModifier.IN || 
					parMod == ParameterModifier.INOUT || 
					parMod == ParameterModifier.NONE){
					result.append(getCharacterisationString(dataType, param.getParameterName()));
				}
			} else {
				if (parMod == ParameterModifier.INOUT || 
					parMod == ParameterModifier.OUT){
					result.append(getCharacterisationString(dataType, param.getParameterName()));
				}
			}
		}

		if (mod == Modifier.OUT){
			DataType returnType = sig.getReturntype__Signature();	
			if (returnType != null){
				result.append(getCharacterisationString(returnType, "RETURN"));	
			}
		}
		
		int length = result.length();
		if (length > 0) 
			result.delete(length-3, length); // remove last " + "
		else if (length == 0)
			result.append("0");

		return result.toString();
	}

	/**
	 * Composes the characterisation string for a single parameter. For collection types and composite types, the inner declarations are respected. 
	 * For example
	 * 
	 * <code>int bar</code> would be tranformed into <code>"bar.BYTESIZE"</code>
	 * <code>int[] myIntArray</code> would be tranformed into <code>"myIntArray.BYTESIZE + myIntArray.NUMBER_OF_ELEMENTS * myIntArray.INNER.BYTESIZE"</code>
	 * With a composite data type <code>Compositum {int a; String b}</code> <code>Compositum myCompositum</code> would be transformed into <code>"myCompositum.BYTESIZE + myCompositum.a.BYTESIZE + myCompositum.b.BYTESIZE"</code>
	 * 
	 * The method calls itself recursively for non-primitive data types. 
	 * 
	 * @param dataType The data type of the parameter for that the characterisation string is created
	 * @param name  The name of the parameter for that the characterisation string is created
	 * @return A String with the proper BYTESIZE characterisations for the given type and name of parameter  
	 */
	private static String getCharacterisationString(DataType dataType, String name){
		StringBuffer result = new StringBuffer();
		if (dataType instanceof PrimitiveDataType){
			result.append(name+".BYTESIZE + ");
		} else if (dataType instanceof CollectionDataType){
			CollectionDataType collDataType = (CollectionDataType)dataType;
			result.append(name+".BYTESIZE + ");
			DataType innerDataType = collDataType.getInnerType_CollectionDataType();
			String innerSize = getCharacterisationString(innerDataType, name + ".INNER");
			result.append(name+".NUMBER_OF_ELEMENTS * "+ innerSize);
		} else if (dataType instanceof CompositeDataType){
			CompositeDataType compDataType = (CompositeDataType)dataType;
			EList<InnerDeclaration> innerList = compDataType.getInnerDeclaration_CompositeDataType();
			result.append("(");
			result.append(name+".BYTESIZE + ");
			for (InnerDeclaration decl : innerList){
				DataType innerDataType = decl.getDatatype_InnerDeclaration();
				result.append(getCharacterisationString(innerDataType, name+"."+decl.getEntityName()));
			}
			result.delete(result.length()-3, result.length());
			result.append(") + ");
		}
		return result.toString();
	}
}
