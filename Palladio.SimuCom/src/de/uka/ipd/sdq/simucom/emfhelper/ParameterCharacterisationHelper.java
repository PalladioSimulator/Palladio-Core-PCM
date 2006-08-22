package de.uka.ipd.sdq.simucom.emfhelper;

import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType;

public class ParameterCharacterisationHelper {

	public static CollectionParameterCharacterisationType getCollectionParameterCharacterisationType(String type) throws Exception
	{
		if (type.equals("NUMBER_OF_ELEMENTS"))
			return CollectionParameterCharacterisationType.NUMBER_OF_ELEMENTS_LITERAL;
		if (type.equals("STRUCTURE"))
			return CollectionParameterCharacterisationType.STRUCTURE_LITERAL;
		throw new Exception("Parameter abstraction unknown "+type);
	}

	public static PrimitiveParameterCharacterisationType getPrimitiveParameterCharacterisationType(String type) throws Exception {
		if (type.equals("BYTESIZE"))
			return PrimitiveParameterCharacterisationType.BYTESIZE_LITERAL;
		throw new Exception("Parameter abstraction unknown "+type);
	}
}
