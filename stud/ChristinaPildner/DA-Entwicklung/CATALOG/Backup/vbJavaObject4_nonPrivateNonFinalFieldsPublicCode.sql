/*
DOES
- selects all the static variables prom public classes whos type is a reference type (object) 

*/

SELECT 
package.Fullname AS PackageName,
class.Name AS ClassName,
variable.Name AS VariableName,
variable.visibility, 
declarationType.FullName as TypeName,
/*show file and position in file */
files.PathName AS FileName,
source.StartLine AS StartLine,
source.StartChar AS StartChar 


FROM tMembers AS variable
JOIN tVariables AS variableAttr ON (variable.id = variableAttr.id)
JOIN tpackages AS package ON (variableAttr.packageid = package.id)
JOIN tMembers AS class ON (variableAttr.classid = class.id)
/*join the type*/
JOIN taccesses AS access ON (variable.id = access.sourceid)
JOIN tTypes AS declarationType ON (access.targetid = declarationType.id)
JOIN tSourceEntities AS source ON (variable.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 

WHERE 
(variable.visibility != 149 /* !=VISIBILITY_PRIVATE*/ OR variable.isFinal = 0)
AND variable.KindOfmember = 65 /*VAR_FIELD*/
AND class.visibility = 145 /* VISIBILITY_PUBLIC */
AND variable.isStatic = 1
AND declarationType.IsReferenceType = 1
/* AND variableAttr.isPassedByRef = 1 can not be any help. all the variables possess value 0 */ 

ORDER By PackageName, ClassName

;