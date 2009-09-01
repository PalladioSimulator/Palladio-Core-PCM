/* used for
-vb.java.1 serialisation

DOES
- search for the call of write_something

TO DO
find all the library functions
proove if all the function can be used for serialisation

CONSTRAINTS
-can not be checked if the methods are realy used for serialisation or is a bad program design

*/
SELECT 
	*

FROM tFunctions AS function
/*file source of function, if exists */
JOIN 	tSourceEntities AS functionSource ON (function.Id = functionSource.Id)
JOIN		tFiles AS functionFiles ON (functionSource.SourceFileId = functionFiles.Id) 
/*file souce of the using class*/
INNER JOIN 	tMembers AS containingClass ON (containingClass.Id = function.ClassId)

WHERE (	
/*covers the serializable*/
	/*for classes that need to designate an alternative object*/
	function.Name = 'writeReplace'
	/*all write functions of ObjectOutputStream*/
	OR function.Name ='write' 
	OR function.Name ='writeBoolean' 
	OR function.Name ='writeByte'
	OR function.Name ='writeBytes'
	OR function.Name ='writeChar'
	OR function.Name ='writeChars'
	OR function.Name ='writeClassDescriptor'
	OR function.Name ='writeDouble'
	OR function.Name ='writeFields'
	OR function.Name ='writeFloat'
	OR function.Name ='writeFully'
	OR function.Name ='writeInt'
	OR function.Name ='writeLong'
	OR function.Name ='write'
	OR function.Name ='writeObject'
	OR function.Name ='writeObjectOverride'
	OR function.Name ='writeShort'
	OR function.Name ='writeStreamHeader'
	OR function.Name ='writeUnshared'
	OR function.Name ='writeUnsignedByte'
	OR function.Name ='writeUnsingnedShort'
	OR function.Name ='writeUTF' 
 /*covers the externalization*/
	OR function.Name ='writeExternal')
;