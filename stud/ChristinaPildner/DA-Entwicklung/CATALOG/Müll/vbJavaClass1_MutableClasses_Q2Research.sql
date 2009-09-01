/*START Q2 - select all the variables of a class that are not final*/


/*FixMe - <self> anotations are also shown*/



SELECT *
/*
classes.Name 	AS ClassName,
classes.Id 	AS ClassId,
'variable'	AS ElementType,
variables.Name  AS ElementName,
variables.Id	AS ElememtId
*/
/*
source.StartLine AS StartLine
source.StartChar AS StartChar 
files.PathName AS FileName
*/


FROM  	tMembers AS classes
/*select variables of classes*/
JOIN 	tVariables AS variables ON (variables.ClassId=classes.id)
/*select attributes of variables*/
JOIN 	tMembers As variablesAttributes ON (variables.id=variablesAttributes.Id)


/*class not final */
WHERE 	classes.kindOfMember= 35 /*TYPE_CLASS*/
AND	classes.isFinal=0
/*variable not final and not static*/
AND 	variablesAttributes.KindOfMember = 65 /*VAR_FIELD*/
AND 	variablesAttributes.isFinal=0
AND 	variablesAttributes.isStatic = 0
AND 	variables.isPassedByRef = 0
AND	variables.Name != '<self>'
/*END Q2 */