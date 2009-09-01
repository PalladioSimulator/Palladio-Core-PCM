/*
DOES
- search for classes that can be overriden and doesnt have a final finalizer
- Column "FinalizerIsFinal":
      - " " -> no finalizer (ko)
      - "0" -> finalizer is not final (ko)
      - "1" -> finalizer is final (ok)
*/


SELECT 
package.Fullname as Packagename,
/*classes.id AS ClassID,*/
classes.Name AS ClassName,
source.StartLine AS StartLine,
source.StartChar AS StartChar ,
files.PathName AS FileName,
/* finalizer.isFinal AS FinalizerIsFinal,*/
finalizer.StartLine AS FinalizerStartLine,
finalizer.StartChar AS FinalizerStartChar

FROM tMembers AS classes 
JOIN tModelElements AS moreClass ON (classes.id = moreclass.id)
JOIN tpackages AS package ON (moreclass.parentid = package.id) 
JOIN tSourceEntities AS source ON (classes.id = source.Id)
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 
LEFT JOIN (
	/* START Q1intern - select all the finalizer in the code */
	SELECT
	finalizer.id AS id,
	finalizer.classid AS classId,
        finalizer.isFinal as IsFinal,
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
) AS finalizer ON (finalizer.classId = classes.id)


WHERE classes.isFinal = 0 
AND classes.visibility = 145
AND classes.KindOfMember =  35 /*TYPE_CLASS*/
