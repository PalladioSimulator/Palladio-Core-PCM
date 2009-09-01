/*
VULNERABILITY
- vb.java.object.1 - Return Reference to Mutable Object

DOES 
-selects all the functions that have mutable return parameter 

OBSERVATIONS
Q10 - selects all the Outputparametertype Declaration on Types by Reference
Q20 - selects all the classen in database that are overridable 

MESSAGE 
- this method returns a reference to a mutable object. This object might be accessed from other part of code. Copy or clone the object befor use or make sure the access is controlled.  
*/

SELECT 
/*mandatory columns*/
package.Fullname 	AS PackageFullName,
class.Name 		AS ClassName,
method.name 		AS ElementName, /*Element = method with mutable output type */
files.PathName 		AS FileName,
filesource.StartLine 	AS StartLine,
filesource.StartChar	AS StartChar,
/*optional columns*/
outputType.name		 AS OutPutTypeName
/*
source.name AS SourceName,
Source.kindofmember AS SourceMemberType,
method.kindoffunction AS functionMemberType,
*/

FROM taccesses 		AS access /*access from a method to a type */
JOIN tpackages 		AS package 		ON (access.packageid = package.id) /*package of the searched methods */
JOIN tMembers 		AS class 		ON (access.classid = class.id) /*class of the method*/
JOIN tFunctions 	AS method 		ON (access.sourceid = method.id) /*searched methods */
JOIN tMembers 		AS methodAttributes 	ON (method.id = methodAttributes.id)
JOIN tTypes 		AS outputType 		ON (access.targetid = outputType.id) /* searched output type */
JOIN tSourceEntities 	AS filesource 		ON (method.Id = filesource.Id) 
JOIN tFiles 		AS files 		ON (filesource.SourceFileId = files.Id) 
LEFT JOIN
(/*START Q20*/	


	/*START Q2 - select all the variables of a class that are not final*/

	SELECT DISTINCT
	classes.Id 	AS ClassId,
	classes.Name 	AS ClassName

	FROM  	tMembers 	AS classes
	JOIN 	tVariables	AS variables 		ON (variables.ClassId=classes.id)
	JOIN 	tMembers 	AS variablesAttributes 	ON (variables.id=variablesAttributes.Id)


	/*class not final */
	WHERE 	classes.kindOfMember= 35 /*TYPE_CLASS*/
	/*variable not final and not static*/
	AND 	variablesAttributes.KindOfMember = 65 /*VAR_FIELD*/
	AND 	variablesAttributes.isFinal=0
	AND 	variablesAttributes.isStatic = 0
	AND 	variablesAttributes.visibility != 149 /* !=VISIBILITY_PRIVATE */
	/*variable that are passed by reference*/
	AND 	variables.isPassedByRef = 0
	/*self points are irrelevant*/
	AND	variables.Name != '<self>'
	/*END Q2 */

	UNION
	/*Q3 - select the classes that are not final */
	SELECT DISTINCT
	classes.Id 	AS ClassId,
	classes.Name 	AS ClassName

	FROM  	tMembers AS classes

	/*class not final */
	WHERE 	classes.kindOfMember= 35 /*TYPE_CLASS*/
	AND	classes.isFinal=0
	/*END Q3*/
/*END Q20*/	
) AS mutableClasses ON (method.id = mutableClasses.classid)


WHERE 	outputType.Name != 'void' AND outputType.Name != 'String' /*string is not by reference */
AND 	outputType.isReferenceType = 1 
AND 	outputType.kindoftype != 39 /* not array */
AND 	access.kindofAccess = 117 /*TYPEACCESS_DECLARATION*/
AND 	Class.visibility = 145 /*public class containig the method*/
AND 	methodAttributes.visibility = 145









