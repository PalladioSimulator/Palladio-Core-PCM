TEMPLATES
/*startcomment*/
/*
DOES
-

COVERS VULNERABILITIES


CONSTRAINTS

TODO


*/


/*show file and position in file */
source.StartLine AS StartLine
source.StartChar AS StartChar 
files.PathName AS FileName

JOIN tSourceEntities AS source ON (x.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 


/*look after Constants*/
JOIN tConstants AS notations ON (x.KindOfx=Notations.value)

WHERE 
notations.Name = 'YOUR_NAME_HERE'
