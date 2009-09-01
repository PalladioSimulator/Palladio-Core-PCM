/*
DOES
Selects all the mutable classes 
- non final functions
- non final variables 
- non final classdeclaration

DEPENDENCY
-change vbJavaClass1_MutableClasses also, if changes are made
*/

/*START Q1- selects all the non final methods of an non final class*/
SELECT DISTINCT
classes.Id 	AS ClassId,
classes.Name 	AS ClassName

FROM  	tMembers AS classes
/*select functions of classes*/
JOIN 	tFunctions AS functions ON (functions.ClassId=classes.id)
/*select attributes of functions*/
JOIN 	tMembers As functionAttributes ON (functions.id=functionAttributes.Id)

/*class not final */
WHERE 	classes.kindOfMember= 35 /*TYPE_CLASS*/
AND	classes.isFinal=0
AND 	functionAttributes.isFinal=0
AND 	functions.KindOfFunction!=55 /* != FUNC_INITIALIZER*/
/*END Q1*/

UNION

/*START Q2 - select all the variables of a class that are not final*/

SELECT DISTINCT
classes.Id 	AS ClassId,
classes.Name 	AS ClassName

FROM  	tMembers AS classes
/*select variables of classes*/
JOIN 	tVariables AS variables ON (variables.ClassId=classes.id)
/*select attributes of variables*/
JOIN 	tMembers As variablesAttributes ON (variables.id=variablesAttributes.Id)


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

order by ClassName