/*
DOES
- select all the non static variables that are not made private


*/

SELECT 

variablesAttributes.id AS Id,
variablesAttributes.Name AS Name,
variablesAttributes.visibility, 
/*show file and position in file */
source.StartLine AS StartLine,
source.StartChar AS StartChar ,
files.PathName AS FileName

FROM tMembers AS variablesAttributes
JOIN tSourceEntities AS source ON (variablesAttributes.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 

WHERE 
variablesAttributes.visibility != 149 /* !=VISIBILITY_PRIVATE*/
AND variablesAttributes.isStatic = 0 
AND VariablesAttributes.KindOfmember = 65