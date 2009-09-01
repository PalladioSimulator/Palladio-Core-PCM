/*
DOES 
-selects all the declarations of static variables who hat a reference on an Object (rather then a copy)

CONSTRINTS
-it can not be sad, if the deep copy of the object have been made
*/

SELECT 
staticVariables.id AS VariableId,
staticVariables.Name AS VariableName,
variableType.Name AS VariableTypeName,
/*show file and position in file */
source.StartLine AS StartLine,
source.StartChar AS StartChar ,
files.PathName AS FileName

FROM tVariables AS staticVariables
/*get the type of variable*/
JOIN tMembers AS variableAttributes ON (staticVariables.id = variableAttributes.id)
/*get the Typeacess*/
JOIN tAccesses AS declarationAccess ON (staticVariables.TypeDeclarationId = declarationAccess.id)
/*get the type accesses*/
JOIN tTypes AS variableType ON (declarationAccess.targetid=variableType.id)
/*get the Attributes of the type accesed*/
Left JOIN tMembers as typeAttributes ON (variableType.Id = typeAttributes.id)
/*get the file of the variable declaration*/
JOIN tSourceEntities AS source ON (staticVariables.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 


/*
JOIN tTypes AS staticVariablesTypes ON (staticVariables.TypeDeclarationId = staticVariablesTypes.id)
/*get the declaration of variable type*/
JOIN tMembers AS typeAttributes ON (staticVariablesTypes.id = typeAttributes.id)
/*get the declaration of the variable*/
*/

WHERE 	variableAttributes.isStatic = 1 
AND 	variableType.IsReferenceType = 1


;