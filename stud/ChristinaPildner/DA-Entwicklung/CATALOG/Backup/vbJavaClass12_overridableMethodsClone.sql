/* 
DOES
- select all the non final funtions that are called in a clone method

TODO 
 - there are not all the function listed. debug 

*/

SELECT  
package.FullName as PackageName,
class.Name AS className,
methodpackage.fullname AS MethodsPackageName,
methodclass.name AS methodsClassName,
function.Name AS MethodName,
functionFiles.PathName AS MethodfileNameFileName
/* access.KindOfAccess 	AS KindOfAccess,*/



FROM	tFunctions AS clone
JOIN    tpackages AS package on (clone.packageid = package.id)
JOIN    tmembers AS class ON (clone.classid = class.id) 
/*function is called in clone*/
JOIN 	tAccesses AS access ON (clone.id = access.FunctionId)
/*get the function*/
JOIN	tFunctions AS function ON (access.targetid = function.Id)
/*get isFinal of function*/
JOIN	tMembers AS functionAttributes ON (functionAttributes.id=function.id)
JOIN    tpackages AS methodpackage on (function.packageid = methodpackage.id)
JOIN    tmembers AS methodclass ON (function.classid = methodclass.id) 
/*file source of function*/
JOIN 	tSourceEntities AS FunctionSource ON (clone.Id = functionSource.Id)
JOIN	tFiles AS functionfiles ON (functionSource.SourceFileId = functionFiles.Id) 



WHERE 	
clone.Name = 'clone'
AND	access.KindOfAccess = 97 /* FUNCACCESS */
AND	functionAttributes.IsFinal = 0
AND     methodclass.isFinal = 0
AND     Methodclass.visibility != 149 /*not VISIBILITY_PRIVATE*/

/*clone.kindOfMember = 53 */
ORDER BY className

;