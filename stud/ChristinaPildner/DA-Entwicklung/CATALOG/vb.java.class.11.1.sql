/*
VULNERABILITY
- vb.java.class.11 - Call Overridable Methods in Constructor

DOES
- selects all the non final funtions that are called in constructors

OBSERVATION
- overridable methods = method class OR method are not final

MESSAGE
-The method called in the constructor is overridable. Either make it final or validate the output. 
*/

SELECT  
/*mandatory columns*/
package.FullName 	AS PackageFullName,
class.Name 		AS ClassName,
function.Name 		AS ElementName, /* element = overridable method in constructor */
file.pathname 		AS FilePathName,
source.startline 	AS StartLine,
source.startchar 	AS StartChar,
/*optional columns*/
methodpackage.fullname 	AS MethodsPackageName,
methodclass.name 	AS methodsClassName

/*constructors*/
FROM	tFunctions 	AS constructor
JOIN    tpackages 	AS package 		ON (constructor.packageid = package.id)
JOIN    tmembers 	AS class 		ON (constructor.classid = class.id) 
/*function is called in constructor*/
JOIN 	tAccesses 	AS access 		ON (constructor.id = access.FunctionId)
/*get the function*/
JOIN	tFunctions 	AS function 		ON (access.targetid = function.Id)
/*get is final? for function*/
JOIN	tMembers 	AS functionAttributes	ON (functionAttributes.id=function.id)
JOIN    tpackages 	AS methodpackage 	ON (function.packageid = methodpackage.id)
JOIN    tmembers 	AS methodclass 		ON (function.classid = methodclass.id) 
/*file source of access*/
JOIN 	tSourceEntities AS source 		ON (access.Id = source.Id)
JOIN	tFiles 		AS file 		ON (source.SourceFileId = file.Id) 



WHERE 	
constructor.Name = class.name
AND	access.KindOfAccess = 97 /* FUNCACCESS */
AND	functionAttributes.isFinal = 0
AND     methodclass.isFinal = 0
AND     Methodclass.visibility = 145 /* VISIBILITY_PUBLIC*/
/*constructor.kindOfMember = 53 */

;