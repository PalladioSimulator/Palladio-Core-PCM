/*
DOES
Select all the methods that might allow a thread to call a privileged block


Constraint
the implementation of an security manager is not prooved 
*/

SELECT * 
/*
source.StartLine AS StartLine
source.StartChar AS StartChar 
files.PathName AS FileName
*/


FROM tfunctions AS functions 
JOIN tMembers AS Classes On (functions.classid = classes.id )
JOIN taccesses As Access ON (functions.id = access.targetid)
LEFT JOIN tSourceEntities AS source ON (access.statementid = source.Id) 
LEFT JOIN tFiles AS files ON (source.SourceFileId = files.Id) 


WHERE Functions.name = 'doPrivileged'
AND classes.Name = 'accessControler'