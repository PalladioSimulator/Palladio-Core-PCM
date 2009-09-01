/*
VULNERABYLITY 
- vb.java.class.3 - Non Final Static Field

DOES
-search for  non final static variables in public classes

MESSAGE
- this static field is not final. Make it final or declare it private and provide the getter an setter that controlls the access on it. 
*/

SELECT 
/*mandatory column*/
package.fullname AS PackageFullName, 
class.name AS ClassName, 
variable.name AS ElementName, 
file.pathname AS FilePathName, 
source.startline AS StartLine, 
source.startchar AS StartChar

FROM 
     tvariables variable 
JOIN tpackages AS package ON (package.id = variable.packageid) 
JOIN tmembers AS variableAttributes ON (variable.id = variableAttributes.id) 
JOIN tmembers AS class ON (class.id = variable.classid) 
JOIN tsourceentities AS source ON (variable.id = source.id) 
JOIN tfiles AS file ON (source.sourcefileid = file.id)

WHERE 
variableAttributes.isstatic = 1  
AND variableAttributes.isfinal = 0  
AND class.visibility = 145 /*VISIBILITY_PUBLIC*/;
