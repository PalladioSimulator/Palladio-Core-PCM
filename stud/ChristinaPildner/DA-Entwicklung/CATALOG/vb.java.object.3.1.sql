/*
VULNERABILITY
- vb.java.object.3 - Field with too much Visibility

DOES
- lists all the variables that are not made private in public classes

MESSAGE
- this valiable is not private and can be accessed from malicious code. Make the variable private and provide getter ans setter to controll the access.  
*/

SELECT 
/*mandatory columns*/
package.Fullname 	AS PackageFullName,
class.Name 		AS ClassName,
variable.Name 		AS ElementName,
files.PathName 		AS FileName,
source.StartLine 	AS StartLine,
source.StartChar 	AS StartChar,
/*optional columns*/
variable.visibility 	AS ElementVisibility


FROM tMembers 		AS variable
JOIN tVariables 	AS variableAttr ON (variable.id = variableAttr.id)
JOIN tpackages 		AS package ON (variableAttr.packageid = package.id)
JOIN tMembers 		AS class ON (variableAttr.classid = class.id)
JOIN tSourceEntities 	AS source ON (variable.Id = source.Id) 
JOIN tFiles 		AS files ON (source.SourceFileId = files.Id) 

WHERE 	variable.visibility != 149 /* !=VISIBILITY_PRIVATE*/
AND 	variable.KindOfmember = 65 /*VAR_FIELD*/
AND 	class.visibility = 145
;