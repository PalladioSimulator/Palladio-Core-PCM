/*
DOES
- select clone methods that are not defined in the own project


points to the function Where they are used
CONSTRAINTS: alls the clone methods from libries are shown 
*/

/*Q1 - selects als the clone methods*/
SELECT 
functions.id AS FunctionId,
classes.id AS ClassID, 
classes.Name AS ClassName,
/*show file and position in file */
source.StartLine AS StartLine,
source.StartChar AS StartChar ,
files.PathName AS FileName,
/*Show file and Position of declaration*/
functionsource.StartLine AS DefinitionStartLine,
functionsource.StartChar AS DefinitionStartChar ,
functionfiles.PathName AS DefinitionFileName

FROM 
tFunctions AS functions
JOIN tMembers As classes ON (functions.classID = classes.ID )
JOIN tAccesses AS accesses ON (functions.Id = accesses.targetid)
/*source of the Statementd*/
JOIN tSourceEntities AS source ON (accesses.statementid = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 
JOIN tSourceEntities AS functionsource ON (functions.id = functionsource.Id) 
LEFT JOIN tFiles AS functionfiles ON (functionsource.SourceFileId = functionfiles.Id) 


WHERE functions.Name='clone'
AND accesses.kindofaccess = 97
AND functionsource.SourceFileId = -1 /*no filesource for definition -> not in the project*/
/*END Q1*/

ORDER BY Filename, Startline