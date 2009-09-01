/*
DOES 
- select all the write statement on variables that contain a reference to a mutable object 
q1 - select all the write statements
q2 - select all the variables with references on mutable objects 

VULNERABILITIES 
-vb.java.class1

CONSTRAINTS 
- mutable = by referennce
- all the object are shown, Not proove of deepcopy before

COMMENTS

*/

SELECT *


FROM tStatements AS statements
JOIN tAccesses AS accesses ON (statements.id = accesses.Statementid)
JOIN tconstants AS kindOfAccesses ON (accesses.KindOfAccess = kindOfAccesses.value)
/*get the file of the variable declaration*/
JOIN tSourceEntities AS source ON (accesses.SourceId = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 
/*get the variables that are defined as references */
JOIN (
	SELECT 
	staticVariables.id AS VariableId,
	staticVariables.Name AS VariableName,
	variableType.Name AS VariableTypeName
	
	FROM tVariables AS staticVariables
	/*get the type of variable*/
	JOIN tMembers AS variableAttributes ON (staticVariables.id = variableAttributes.id)
	/*get the Typeacess*/
	JOIN tAccesses AS declarationAccess ON (staticVariables.TypeDeclarationId = declarationAccess.id)
	/*get the type accesses*/
	JOIN tTypes AS variableType ON (declarationAccess.targetid=variableType.id)
		
	WHERE 	variableAttributes.isStatic = 1 
	AND 	variableType.IsReferenceType = 1
	) 
		AS staticVariables ON (staticVariables.variableId = accesses.TargetId )

WHERE kindOfAccesses.Name = 'VARACCESS_WRITE'


ORDER BY statements.id


;