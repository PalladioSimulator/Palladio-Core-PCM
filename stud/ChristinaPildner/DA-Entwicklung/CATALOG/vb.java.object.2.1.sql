/*
VULNERABILITY
vb.java.object.2 - Returns Reference to Array

DOES 
- Selects all the methods in public code that have array return parameter type

MESSAGE 
- this method return a reference to an array. The objects in array might be accessed from other code. Copy or clone the array object before use or make sure the access is controlled
*/

SELECT 
/*mandatory columns*/
package.Fullname 	AS PackageFullName,
class.Name 		AS ClassName,
method.name 		AS MethodName,
files.PathName 		AS FilePathName,
filesource.StartLine 	AS StartLine,
filesource.StartChar	AS StartChar,
/*optional columns*/
outputType.name 	AS OutPutTypeName


FROM taccesses 		AS access /*access from a method to a type */
JOIN tpackages 		AS package 		ON (access.packageid = package.id) /*package of the searched methods */
JOIN tMembers 		AS class 		ON (access.classid = class.id) /*class of the method*/
JOIN tFunctions 	AS method 		ON (access.sourceid = method.id) /*searched methods */
JOIN tMembers		AS methodAttributes 	ON (method.id = methodAttributes.id)
JOIN tTypes 		AS outputType 		ON (access.targetid = outputType.id) /* searched output type */
JOIN tSourceEntities 	AS filesource 		ON (method.Id = filesource.Id) 
JOIN tFiles 		AS files 		ON (filesource.SourceFileId = files.Id) 


WHERE 	outputType.Name != 'void' AND outputType.Name != 'String' /*string is not by reference */
AND 	outputType.isReferenceType = 1 
AND 	outputType.kindoftype = 39 /* TYPE_ARRAY */
AND 	access.kindofAccess = 117 /*TYPEACCESS_DECLARATION*/
AND 	Class.visibility = 145 /*public class containig the method*/
AND 	methodAttributes.visibility = 145
;








