/*
DOES 
Select the Definition of Static Variables on Array. 

*/

SELECT 
  packages.fullname AS PackageName, 
  classes.name AS ClassName, 
  fields.name AS FieldName, 
  types.name AS ArrayType, 
  files.pathname AS FileName,
  sources.startline AS Startline
 
/* for debugging
 fields.typedeclarationid, 
  fields.kindofvariable, 
  accesses.kindofaccess, 
  types.kindoftype
*/


FROM tvariables AS fields
JOIN tmembers AS fieldsAttributes ON (fields.id = fieldsAttributes.id)
JOIN taccesses AS accesses ON (accesses.id = fields.typedeclarationid) 
JOIN ttypes AS types ON (types.id = accesses.targetid)
JOIN tpackages AS packages ON (fields.packageid = packages.id) 
JOIN tmembers AS classes ON (fields.classid = classes.id)
JOIN tsourceentities AS sources On (fields.id = sources.id)
JOIN tfiles AS files ON (sources.sourcefileid = files.id)

WHERE  accesses.classid = fields.classid /*access hapens in the same class as the declaration*/
AND accesses.sourceid = fields.id 
AND types.kindoftype = 39 /*TYPE_ARRAY*/
AND fieldsAttributes.isStatic = 1;
