/*
DOES 
selects all the Exception Types thrown in the code

CONSTRAINTS
it kann not proove if the information seen by the User is sensitive. 
*/


SELECT
package.FullName AS PackageName,
class.Name AS ClassName,
functions.name AS MethodName,
files.PathName AS FileName,
source.StartLine AS StartLine,
source.StartChar AS StartChar 




FROM tstatements AS statements
JOIN tfunctions AS functions on (statements.functionid =  functions.id)
JOIN tpackages AS package ON (functions.packageid = package.id) 
JOIN tMembers AS class ON (functions.classid = class.id ) 
JOIN tSourceEntities AS source ON (statements.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 

where statements.kindofstatement = 72 /*STETEMENT_THROW*/
AND class.visibility = 145 /* VISIBILITY_PUBLIC */ 


