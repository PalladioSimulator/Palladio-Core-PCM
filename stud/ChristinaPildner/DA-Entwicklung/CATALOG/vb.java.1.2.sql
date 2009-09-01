/* 
@Author: Christina Pildner - FZI 2009

VULNERABILITY
-vb.java.1 - serialized sensitive data

DOES
- search for all the calls to library functions that can be used for serialization

OBSERVATIONS
- the write* methods name used for the search are defined in java.io.ObjectOutputStream
- can not be checked if the methods are realy used for serialisation or is a bad program design

OCCURANCE MESSAGE
method is used for the serialization. Make sure that no sensitive data is beeing serialized (use for instance <b>transient<b> to declare non persistent object fields)
and that serialized data is protected through mechanism like encryption.
*/

SELECT 
/*mandatory columns*/
packages.Fullname AS PAckageFullName,
Classes.Name AS ClassName,
function.Name AS ElementName, 
functionfiles.PathName AS FilePathName,
functionsource.startLine AS StartLine,
functionsource.startchar AS StartChar

FROM tFunctions AS function
JOIN tmembers AS classes ON (function.classid = classes.id)
JOIN tPackages AS packages ON (function.packageid = packages.id)  
/*file source of function, if exists */
JOIN 	tSourceEntities AS functionSource ON (function.Id = functionSource.Id)
JOIN	tFiles AS functionFiles ON (functionSource.SourceFileId = functionFiles.Id) 
/*file souce of the using class*/
INNER JOIN 	tMembers AS containingClass ON (containingClass.Id = function.ClassId)

WHERE (	
/*covers the interface serializable*/
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
 /*covers the interface externalizable*/
	OR function.Name ='writeExternal')
;