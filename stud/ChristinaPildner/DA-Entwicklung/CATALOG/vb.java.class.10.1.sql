/* 
VULNERABILITY
- vb.java.class.10 - Deserialization

DOES
- search for the call of the functions that could deserialize an code Element in the public code

OBSERVATIONS
- not only objects deserialization is considered, also the common data types.

MESSAGE 
- this method is used for deserialisation. Make sure that the deserialized object or element is provided from secure code and it state is valid ans secure.
*/

SELECT 
/*mandatory columns*/
packages.FullName AS PackageFullName, 
classes.Name AS ClassName, 
function.Name AS ElementName, 
functionfiles.pathname AS FilePathName, 
functionSource.Startline AS StartLine, 
functionSource.Startchar AS StartChar


FROM tFunctions AS function
JOIN tAccesses AS accesses ON (function.id = accesses.targetid)
JOIN tPackages AS packages ON (accesses.packageId = packages.id)
JOIN tMembers AS classes ON (accesses.classId = classes.id) 
/*file source of function, if exists */
LEFT JOIN 	tSourceEntities AS functionSource ON (accesses.Id = functionSource.Id)
LEFT JOIN	tFiles AS functionFiles ON (functionSource.SourceFileId = functionFiles.Id) 
/*file souce of the using class*/
JOIN 	tMembers AS containingClass ON (containingClass.Id = function.ClassId)



WHERE 	accesses.kindofaccess = 97 /*FUNCACCESS*/
AND	classes.visibility = 145 /*VISIBILITY_PUBLIC*/
AND	(/*all read functions of ObjectInputStream*/
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
		OR function.Name ='readUTF'
	) 
;