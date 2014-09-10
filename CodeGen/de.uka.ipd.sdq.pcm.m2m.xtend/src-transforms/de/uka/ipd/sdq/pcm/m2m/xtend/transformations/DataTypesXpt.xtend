package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.repository.CollectionDataType
import de.uka.ipd.sdq.pcm.repository.CompositeDataType
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn

@ModelIn(#[
	"pcm.repository.CollectionDataType",
	"pcm.repository.CompositeDataType",
	"pcm.repository.PrimitiveDataType",
	"pcm.repository.PrimitiveTypeEnum"
])
class DataTypesXpt {
//	def dispatch String dataType(DataType type) {
//		// «ERROR "OAW GENERATION ERROR [m2t_transforms/datatypes.xpt]: Unknown Datatype found"»
//	}
	
	def dispatch String dataType(PrimitiveDataType type) {
		switch (type.type) {
			case PrimitiveTypeEnum::INT:    "int"
			case PrimitiveTypeEnum::DOUBLE: "double"
			case PrimitiveTypeEnum::CHAR:   "char"
			case PrimitiveTypeEnum::BYTE:   "byte"
			case PrimitiveTypeEnum::STRING: "String"
		}
	}
	
	def dispatch String dataType(CollectionDataType type) '''
		«dataType(type.innerType_CollectionDataType)»[]
	'''
	
	def dispatch String dataType(CompositeDataType type) '''
		«type.entityName»
	'''
}