package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.repository.DataType
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum
import de.uka.ipd.sdq.pcm.repository.CollectionDataType
import de.uka.ipd.sdq.pcm.repository.CompositeDataType

class DataTypesXpt {
	def dispatch dataType(DataType type) {
		// «ERROR "OAW GENERATION ERROR [m2t_transforms/datatypes.xpt]: Unknown Datatype found"»
	}
	
	def dispatch dataType(PrimitiveDataType type) {
		switch (type.type) {
			case PrimitiveTypeEnum::INT:    "int"
			case PrimitiveTypeEnum::DOUBLE: "double"
			case PrimitiveTypeEnum::CHAR:   "char"
			case PrimitiveTypeEnum::BYTE:   "byte"
			case PrimitiveTypeEnum::STRING: "String"
		}
	}
	
	def dispatch dataType(CollectionDataType type) '''
		«dataType(type.innerType_CollectionDataType)»[]
	'''
	
	def dispatch dataType(CompositeDataType type) '''
		«type.entityName»
	'''
}