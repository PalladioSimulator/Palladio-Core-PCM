/*
DOES
- selects all the definition of the clone functions in the code
- shows if the class implements from Cloneable (the ones with a number in the ClassImplementscloneable)
*/

SELECT 
package.name AS PackageName,  
classes.NAme AS ClassName,
implementsCloneable.classid AS ClassImplemetsCloneable,
/*show file and position in file */
files.PathName AS FileName,
source.StartLine AS StartLine,
source.StartChar AS StartChar


FROM
tFunctions AS functions
JOIN tMembers AS classes ON (functions.classid = classes.id)
JOIN Tpackages AS package ON (functions.packageid = package.id)
JOIN tSourceEntities AS source ON (functions.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 
LEFT JOIN(
         SELECT classes.classid
         FROM tInheritances as Classes
         JOIN tMembers AS Interface on (interface.id=classes.superid)
         WHERE interface.Name = 'Cloneable'
         ) AS implementsCloneable ON (classes.id = implementsCloneable.classid)


WHERE 
functions.name = 'clone'

