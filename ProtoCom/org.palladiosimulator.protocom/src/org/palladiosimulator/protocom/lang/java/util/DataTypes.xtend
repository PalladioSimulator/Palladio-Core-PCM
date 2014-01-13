package org.palladiosimulator.protocom.lang.java.util

import de.uka.ipd.sdq.pcm.repository.DataType
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType
import de.uka.ipd.sdq.pcm.repository.CollectionDataType
import de.uka.ipd.sdq.pcm.repository.CompositeDataType
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum
import de.uka.ipd.sdq.pcm.repository.Signature
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature

/**
 * Utility class for creating datatype strings. Inspired by the old datatype xpand template.
 * 
 * @author Sebastian Lehrig
 */
class DataTypes {

	/**
	 * If this method is called, an error occured because every possible data type should be covered.
	 */
	def static dispatch String getDataType(DataType d) {
		"Xtend2 GENERATION ERROR [org.palladiosimulator.protocom.lang.java.util.DataTypes]:" +
			"Unknown data type found (" + d + ")."
	}

	/**
	 * Handles "void" as return type.
	 */
	def static dispatch String getDataType(Void d) {
		"void"
	}

	/**
	 * Primitive types can directly be resolved.
	 */
	def static dispatch  String getDataType(PrimitiveDataType d) {
		switch d.type {
			case PrimitiveTypeEnum::INT:
				"int"
			case PrimitiveTypeEnum::DOUBLE:
				"double"
			case PrimitiveTypeEnum::CHAR:
				"char"
			case PrimitiveTypeEnum::BYTE:
				"byte"
			case PrimitiveTypeEnum::STRING:
				"String"
			default:
				"Xtend2 GENERATION ERROR [org.palladiosimulator.protocom.lang.java.util.DataTypes]:" +
					"Unknown primitive data type found (" + d + ")."
		}
	}

	/**
	 * Uses an array for collections while resolving inner types.
	 */
	def static dispatch  String getDataType(CollectionDataType d) {
		getDataType(d.innerType_CollectionDataType) + "[]"
	}

	/**
	 * Composite data types can directly be resolved by their name.
	 */
	def static dispatch String getDataType(CompositeDataType d) {
		d.entityName
	}
	
	def static dispatch String getReturnDataType(Signature s) {
	}
	
	def static dispatch String getReturnDataType(OperationSignature s) {
		getDataType(s.returnType__OperationSignature)
	}
	
	def static dispatch String getReturnDataType(InfrastructureSignature s) {
		"void"
	}
}
