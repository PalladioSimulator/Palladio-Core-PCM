/*
@Author: Christina Pildner - FZI 2009

VULNERABILITY
- vb.java.object.11 - fake clone method

DOES
- all the calls to clone methods from libraries non final public classes

MESSAGE
- this clone method is not final and might be overriden from malicious code. Make the method final if possible and validate the output before use. 
*/

SELECT 
/*mandatory columns*/
packages.fullname 	AS PackageFullName,
classes.name 		AS ClassName,
functions.name 		AS ElementName, /*the clone method itsself*/
files.PathName 		AS FilePathName,
source.StartLine	AS StartLine,
source.StartChar 	AS StartChar,
/*optional columns*/
libraryClasses.Name 	AS CloneClassName,
/*debug columns*/
accesses.kindofaccess
/*functionsource.StartLine AS DefinitionStartLine,*/ /*must be -1*/


FROM 		tFunctions 	AS functions
JOIN 		tMembers 	AS libraryClasses 	ON (functions.classID = libraryClasses.ID )
JOIN 		tAccesses 	AS accesses 		ON (functions.Id = accesses.targetid)
JOIN 		tPackages 	AS packages 		ON (accesses.packageid = packages.id)
JOIN 		tMembers 	AS classes		ON (accesses.classid = classes.id)
/*source of the Statementd*/
JOIN tSourceEntities		AS source 		ON (accesses.statementid = source.Id) 
JOIN 		tFiles 		AS files 		ON (source.SourceFileId = files.Id) 
JOIN 		tSourceEntities AS clonesource 		ON (functions.id = clonesource.Id) 
LEFT JOIN 	tFiles 		AS clonefiles 		ON (clonesource.SourceFileId = clonefiles.Id) 


WHERE functions.Name='clone'
AND (	clonesource.SourceFileId = -1 /*no filesource for definition -> not in the project*/
	OR classes.isFinal = 0
    )
;

