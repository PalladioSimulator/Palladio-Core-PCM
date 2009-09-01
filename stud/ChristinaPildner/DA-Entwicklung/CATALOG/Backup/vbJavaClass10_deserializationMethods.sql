/* 
DOES
- search for the call of the functions that could deserialise 


Restrictions
- vb.java.class.10 - just a very little part of it t is implemented

*/
SELECT 
	*

FROM tFunctions AS function
/*file source of function, if exists */
LEFT JOIN 	tSourceEntities AS functionSource ON (function.Id = functionSource.Id)
LEFT JOIN	tFiles AS functionFiles ON (functionSource.SourceFileId = functionFiles.Id) 
/*file souce of the using class*/
JOIN 	tMembers AS containingClass ON (containingClass.Id = function.ClassId)



WHERE (/*all read functions of ObjectInputStream*/
           function.Name ='read' 
	OR function.Name ='readBoolean' 
	OR function.Name ='readByte' 
	OR function.Name ='readChar'
	OR function.Name ='readClassDescriptor'
	OR function.Name ='readDouble'
	OR function.Name ='readFields'
	OR function.Name ='readFloat'
	OR function.Name ='readFully'
	OR function.Name ='readInt'
	OR function.Name ='readLine'
	OR function.Name ='readLong'
	OR function.Name ='read'
	OR function.Name ='readObject'
	OR function.Name ='readObjectOverride'
	OR function.Name ='readShort'
	OR function.Name ='readStreamHeader'
	OR function.Name ='readUnshared'
	OR function.Name ='readUnsignedByte'
	OR function.Name ='readUnsingnedShort'
	OR function.Name ='readUTF') 


;