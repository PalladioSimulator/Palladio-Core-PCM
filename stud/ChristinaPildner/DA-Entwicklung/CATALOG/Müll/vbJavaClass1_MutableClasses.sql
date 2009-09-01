/*
DOES
Selects all the elements that does a class mutable 
- non final functions
- non final variables 
- non final classdeclaration

*/

/*START Q1- selects all the non final methods of an non final class*/
SELECT 
classes.Name 	AS ClassName,
classes.Id 	AS ClassId,
'function'	AS ElementType,
functions.Name  AS ElementName,
functions.Id	AS ElememtId


FROM  	tMembers AS classes
/*select functions of classes*/
JOIN 	tFunctions AS functions ON (functions.ClassId=classes.id)
/*select attributes of functions*/
JOIN 	tMembers As functionAttributes ON (functions.id=functionAttributes.Id)

/*class not final */
WHERE 	classes.kindOfMember= 35 /*TYPE_CLASS*/
AND	classes.isFinal=0
AND 	functionAttributes.isFinal=0
AND 	functions.KindOfFunction!=55
/*END Q1*/

UNION

/*START Q2 - select all the variables of a class that are not final*/

SELECT 
classes.Name 	AS ClassName,
classes.Id 	AS ClassId,
'variable'	AS ElementType,
variables.Name  AS ElementName,
variables.Id	AS ElememtId


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
/*variable that are passed by reference*/
AND 	variables.isPassedByRef = 0
/*self points are irrelevant*/
AND	variables.Name != '<self>'
/*END Q2 */


UNION

/*Q3 - select the classes that are not fianl */
SELECT 
classes.Name 	AS ClassName,
classes.Id 	AS ClassId,
'class'	AS ElementType,
classes.Name 	AS ElementName,
classes.Id	AS ElememtId

FROM  	tMembers AS classes

/*class not final */
WHERE 	classes.kindOfMember= 35 /*TYPE_CLASS*/
AND	classes.isFinal=0
/*END Q3*/



Order by ElementType