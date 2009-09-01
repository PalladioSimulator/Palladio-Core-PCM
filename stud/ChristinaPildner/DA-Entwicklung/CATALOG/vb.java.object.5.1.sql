/*
VULNERABILITY	
- vb.java.class.5 - No Wrapper

DOES
- list all the declared fields and available, if the getter OR setter functions to this variable are not defined 

MESSAGE 
- this variable has no wrapper. Make it private and provide the getter and setter that controll the access.  
*/


SELECT
/*mandatory columns*/
package.FullName 	AS PackageFullName,
class.Name 		AS ClassName,
variables.Name 		AS ElementName,
files.PathName 		AS FileName,
source.StartLine 	AS StartLine,
source.StartChar 	AS StartChar,
/*optional columns*/
getter.name 		AS GetterName,
setter.name 		AS SetterName


FROM 	tvariables 	AS variables
JOIN 	tMembers 	AS variableAttr ON (variables.id = variableAttr.id)
JOIN	tpackages 	AS package 	ON (variables.packageid = package.id )
JOIN 	tMembers 	AS class 	ON (variables.classid = class.id)  
JOIN 	tSourceEntities AS source 	ON (variables.Id = source.Id) 
JOIN 	tFiles 		AS files 	ON (source.SourceFileId = files.Id) 
LEFT JOIN tfunctions 	AS setter 	ON (variables.classid = setter.classid AND (lower(setter.Name) = lower ('set'||variables.Name) ))
LEFT JOIN tfunctions 	AS getter 	ON (variables.classid = getter.classid AND (lower(getter.Name) = lower('get'||variables.Name) ))
 
WHERE variables.KindOfVariable = 65 /* VAR_FIELD */
AND variables.name != '<self>'
AND variables.functionId = -1 /*they are not declared in a function*/
AND (setter.name is null OR getter.name is null)
AND class.visibility = 145 /*VISIBILITY_PUBLIC*/

