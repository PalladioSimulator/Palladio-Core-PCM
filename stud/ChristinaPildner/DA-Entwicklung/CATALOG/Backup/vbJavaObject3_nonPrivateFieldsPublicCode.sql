/*
DOES
- select all the non variables that are not made private in public classes


*/

SELECT 
package.Fullname AS PackageName,
class.Name AS ClassName,
variable.Name AS VariableName,
variable.visibility, 
variableAttr.functionid,
/*show file and position in file */
files.PathName AS FileName,
source.StartLine AS StartLine,
source.StartChar AS StartChar 


FROM tMembers AS variable
JOIN tVariables AS variableAttr ON (variable.id = variableAttr.id)
JOIN tpackages AS package ON (variableAttr.packageid = package.id)
JOIN tMembers AS class ON (variableAttr.classid = class.id)
JOIN tSourceEntities AS source ON (variable.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 

WHERE 
variable.visibility != 149 /* !=VISIBILITY_PRIVATE*/
AND variable.KindOfmember = 65 /*VAR_FIELD*/
AND class.visibility = 145
ORDER By PackageName, ClassName

;