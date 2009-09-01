/* 
DOES
- select all the non final funtions that are called in a constructor

TODO 
 - there are not all the function listed (see vbJavaClass11 Test - here has to be two constructors listed, there is only one) 

*/

SELECT  
package.FullName as PackageName,
class.Name AS className,
methodpackage.fullname AS MethodsPackageName,
methodclass.name AS methodsClassName,
function.Name AS MethodName,
functionFiles.PathName AS MethodfileNameFileName
/* access.KindOfAccess 	AS KindOfAccess,*/



FROM	tFunctions AS constructor
JOIN    tpackages AS package on (constructor.packageid = package.id)
JOIN    tmembers AS class ON (constructor.classid = class.id) 
/*function is called in constructor*/
JOIN 	tAccesses AS access ON (constructor.id = access.FunctionId)
/*get the function*/
JOIN	tFunctions AS function ON (access.targetid = function.Id)
/*get isFinal of function*/
JOIN	tMembers AS functionAttributes ON (functionAttributes.id=function.id)
JOIN    tpackages AS methodpackage on (function.packageid = methodpackage.id)
JOIN    tmembers AS methodclass ON (function.classid = methodclass.id) 
/*file source of function*/
JOIN 	tSourceEntities AS FunctionSource ON (constructor.Id = functionSource.Id)
JOIN	tFiles AS functionfiles ON (functionSource.SourceFileId = functionFiles.Id) 



WHERE 	
constructor.Name = class.name
AND	access.KindOfAccess = 97 /* FUNCACCESS */
AND	functionAttributes.IsFinal = 0
AND     methodclass.isFinal = 0
AND     Methodclass.visibility = 145 /* VISIBILITY_PUBLIC*/

/*constructor.kindOfMember = 53 */
ORDER BY className

;