/*
VULNERABILITY
-  bv.java.class.13 - Finalize Method

DOES
- search for classes that can be overriden and doesnt have a final finalizer

OBSERVATIONS
- if finalizerstartline columns is empty means that the class do not have a finalizer. If the column is not empty, then the finalizer is not final 

MESSAGE 
- This class can be overriden and has no final finalizer. Implement a final finalizer in order to make it secure. 
*/


SELECT 
/*mandatory columns*/
package.Fullname	AS PackageFullName,
classes.Name 		AS ClassName,
classes.Name 		AS ElementName, /*Element = class */
files.PathName 		AS FileName,
source.StartLine 	AS StartLine,
source.StartChar 	AS StartChar ,
/*optional columns*/
finalizer.StartLine 	AS FinalizerStartLine


FROM tMembers 		AS classes 
JOIN tModelElements 	AS moreClass 	ON (classes.id = moreclass.id)
JOIN tpackages 		AS package 	ON (moreclass.parentid = package.id) 
JOIN tSourceEntities 	AS source 	ON (classes.id = source.Id)
JOIN tFiles 		AS files 	ON (source.SourceFileId = files.Id) 
LEFT JOIN (
	/* START Q1intern - select all the non final finalizer methods in the code */
	SELECT
	finalizer.id AS id,
	finalizer.classid AS classId,
        finalizer.isFinal AS IsFinal,
	source.StartLine AS StartLine,
	source.StartChar AS StartChar ,
	files.PathName AS FileName
	
	
	FROM tMembers AS finalizer
	JOIN tSourceEntities AS source ON (finalizer.Id = source.Id) 
	JOIN tFiles AS files ON (source.SourceFileId = files.Id) 
	  
	
	WHERE finalizer.Name = 'finalizer'
	AND finalizer.KindOfMember = 52
        AND Finalizer.isFinal != 1
	/*END Q1intern*/
	) 		AS finalizer 	ON (finalizer.classId = classes.id)


WHERE classes.isFinal = 0 
AND classes.visibility = 145 /*visibility_public*/
AND classes.KindOfMember =  35 /*TYPE_CLASS*/
;