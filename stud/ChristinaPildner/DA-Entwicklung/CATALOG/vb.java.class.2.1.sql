/*
VULNERABILITY
- bv.java.class.2 - Stores Array in Static Variable

DOES 
- select the definition of static variables whose type is array. 

OBSERVATIONS
- all the classes are included, also the not public ones
- array wrapper (classes, that wrapp arrays in order to make them more secure) are also shown


MESSAGE
- the variable declaration type is array. Secure the access to it by creating a wrapper for the array
*/

SELECT 
/*mandatory columns*/
packages.fullname 	AS PackageFullName, 
classes.name 		AS ClassName, 
fields.name 		AS ElementName, 
files.pathname 		AS FilePathName,
sources.startline 	AS StartLine,
sources.startchar 	AS StartChar,
/* optional columns*/
types.name 		AS ArrayType

FROM tvariables AS fields
JOIN tmembers 	AS fieldsAttributes ON (fields.id = fieldsAttributes.id)
JOIN taccesses 	AS accesses 		ON (accesses.id = fields.typedeclarationid) 
JOIN ttypes 	AS types ON (types.id = accesses.targetid)
JOIN tpackages 	AS packages ON (fields.packageid = packages.id) 
JOIN tmembers 	AS classes ON (fields.classid = classes.id)
JOIN tsourceentities AS sources ON (fields.id = sources.id)
JOIN tfiles 	AS files ON (sources.sourcefileid = files.id)

WHERE  accesses.classid = fields.classid /* access in the same class as the declaration class*/
AND accesses.sourceid = fields.id 
AND types.kindoftype = 39 /*TYPE_ARRAY*/
AND fieldsAttributes.isStatic = 1 /* static variable */
;

