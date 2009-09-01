/* 
DOES 
- selects all the classes that implements SERIALIZABLE 
- selects all the classes that implements EXTERNALIZABLE

OBSERVATIONS
- Boolean, Number, String, Integer, Externalisable are also shown 
- Externalisable inherits from Serialisable
- library classes are shown 
*/

SELECT
Classes.Name AS ClassName, 
packages.Fullname AS PAckageFullName,

/*inheritances.DepthOfInheritance AS DeepOfInheritance,*/
superClasses.Name As SuperClassName,
files.PathName AS FilePathName,
source.startLine AS StartLine

FROM 		tmodelelements AS classes
/*inheritance relation*/
JOIN		tInheritances AS inheritances ON (inheritances.ClassId = classes.Id) 
JOIN		tMembers AS superclasses ON (superclasses.id = inheritances.SuperId)
/*package name*/
JOIN 		tpackages AS packages ON (classes.parentid = packages.id) 
/*file source if available*/
LEFT JOIN 	tSourceEntities AS source ON (classes.Id = source.Id) /*LEFT for Libraries also*/ 
LEFT JOIN	tFiles AS files ON (source.SourceFileId = files.Id) 


WHERE (superClasses.Name = 'Serializable' OR superClasses.Name = 'Externalizable');
