/*
DOES
- search for the methods that can be overriden and contains security checks

CONSTRAINTS 
-there are only security checks on checkPermition
-other security checks are not listed.

Select the non final methods from non final classes that contain an funktionaccess on checkPermition mehtod. 

TODO
-file of the function 

*/


SELECT
classesAttributes.Name AS 	ClassName,
functions.Name AS 		FunctionName
FunctionDeclarationLine
FilePath

FROM 
tMember AS classesAttributes
JOIN tFunctions AS functions ON (functions.classid = classesAttributes.id)
JOIN tMember AS functionsAttributes ON (functions.id = functionsAttributes.id)
JOIN taccesses AS permitionAccess ON (functions.id = permitionsAccess.functionId)
JOIN tAccesses AS accesses ON (functions.id = accesses.FunctionId)
JOIN tFunctions AS accessedFunctions ON (accesses.targetId = accessedFunctions.id
/*source of function*/ 

WHERE 
/*class is not final*/
classesAttributes.IsFinal = 0
/*function is not final and static*/
AND functionsAttributes.IsFinal = 0 AND functionAttributes.IsStatic = 1
/*function contain a call to checkpermition*/
AND 
/*the access is function call*/
accesses.KindofAccess = "function access"
AND acessesFunction.Name = "permitionCheck"
