/*
VULNERABILITY 
- vb.java.objec.4 - Non Final non Private Field

DOES
- lists object variables in public code that are private or non final.

MESSAGE 
- this variable is neither private and or final. Make it final and private and profide the getter and setter that controll the access on it. 
*/

SELECT 
/*mandatory columns*/
package.Fullname 	AS PackageFullName,
class.Name 		AS ClassName,
variable.Name 		AS ElementName, /*(Element = variable)*/
files.PathName 		AS FileName,
source.StartLine 	AS StartLine,
source.StartChar	AS StartChar ,
/*mandatory columns*/
variable.visibility, 
declarationType.FullName AS TypeName


FROM tMembers 		AS variable
JOIN tVariables 	AS variableAttr ON (variable.id = variableAttr.id)
JOIN tpackages 		AS package ON (variableAttr.packageid = package.id)
JOIN tMembers 		AS class ON (variableAttr.classid = class.id)
/*join the type*/
JOIN taccesses 		AS access ON (variable.id = access.sourceid)
JOIN tTypes 		AS declarationType ON (access.targetid = declarationType.id)
JOIN tSourceEntities 	AS source ON (variable.Id = source.Id) 
JOIN tFiles 		AS files ON (source.SourceFileId = files.Id) 

WHERE 
(variable.visibility != 149 /* !=VISIBILITY_PRIVATE*/ OR variable.isFinal = 0)
AND variable.KindOfmember = 65 /*VAR_FIELD*/
AND class.visibility = 145 /* VISIBILITY_PUBLIC */
AND variable.isStatic = 0

ORDER By PackageFullName, ClassName

;