/*
VULNERABILITY
- vb.java.class.9 - Cloning

DOES
- lists all the definition of the clone methods in code 

MESSAGE 
- This method is used for cloning. Make sure that security checks are made on the clone before it can be used.
*/

SELECT 
/*mandatory columns */
package.name AS PackageFullName,  
classes.Name AS ClassName,
functions.Name AS ElementsName, /*Element = clone method*/
files.PathName AS FilePathName,
source.StartLine AS StartLine,
source.StartChar AS StartChar

FROM	tFunctions 	AS functions
JOIN 	tMembers 	AS classes 	ON (functions.classid = classes.id)
JOIN 	tPackages 	AS package 	ON (functions.packageid = package.id)
JOIN 	tSourceEntities AS source	ON (functions.Id = source.Id) 
JOIN 	tFiles 		AS files 	ON (source.SourceFileId = files.Id) 
LEFT JOIN(
         SELECT classes.classid
         FROM tInheritances as Classes
         JOIN tMembers AS Interface on (interface.id=classes.superid)
         WHERE interface.Name = 'Cloneable'
         ) 
			AS implementsCloneable ON (classes.id = implementsCloneable.classid)


WHERE functions.name = 'clone'
;
