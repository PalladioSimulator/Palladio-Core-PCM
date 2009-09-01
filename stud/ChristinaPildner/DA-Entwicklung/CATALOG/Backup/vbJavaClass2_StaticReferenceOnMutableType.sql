/*
DOES 
select the mutable classes and the fields that lieds to mutability 

CONCEPT
an immutable class is defined like: 
(class OR all methods final) 

CONSTRAINTS
it does not search for the missing in-one-step constructor
it does not search for the set Methods 
*/

SELECT *

FROM tVariables AS 		staticVariables
/*get the type of variable*/
JOIN tMembers AS 		variableAttributes ON (staticVariables.id = variableAttributes.id)
/*get the Typeacess*/
JOIN tAccesses AS 		declarationAccess ON (staticVariables.TypeDeclarationId = declarationAccess.id)
/*get the type accesses*/
JOIN tTypes AS 			variableType ON (declarationAccess.targetid=variableType.id)
/*get the Attributes of the type accesed*/
Left JOIN tMembers as 		typeAttributes ON (variableType.Id = typeAttributes.id)
/*get the file of the variable declaration*/
JOIN tSourceEntities AS 	variableSource ON (staticVariables.Id = variableSource.Id) 
JOIN tFiles AS 			variableFiles ON (variableSource.SourceFileId = variableFiles.Id) 



/*get the qualities of the functions in the the type*/
JOIN tFunctions AS 		typeFunctions ON (typeFunctions.ClassId=typeAttributes.id)
/*get the file of the variable declaration*/
JOIN tSourceEntities AS 	functionSource ON (typeFunctions.Id = functionSource.Id) 
JOIN tFiles AS 			functionFiles ON (functionSource.SourceFileId = functionFiles.Id) 
/*get the attributes of the functions*/
JOIN tMembers AS		functionAttributes ON (typeFunctions.Id = functionAttributes.Id)
/*get the variables of the type*/
LEFT JOIN tMembers AS		typeFields ON (typeFields.ClassId=variableType.id)


/*
JOIN tTypes AS staticVariablesTypes ON (staticVariables.TypeDeclarationId = staticVariablesTypes.id)
/*get the declaration of variable type*/
JOIN tMembers AS typeAttributes ON (staticVariablesTypes.id = typeAttributes.id)
/*get the declaration of the variable*/
*/


/*variable is static and stores a reference*/
WHERE 	variableAttributes.isStatic = 1 
AND 	variableType.IsReferenceType = 1
/*reference is mutable*/
/*class is not final*/
AND 	typeAttributes.IsFinal=0
/*function in class not final*/ 
AND functionAttributes.IsFinal=0
/*variable in class not final, and (not by reference)*/
AND typeFields.isFinal = 0
AND typeFields.visibility != 149
