Select *





FROM 	tMembers AS 		classes 
JOIN 	tMembers AS 		classElements ON (classElements.classId=classes.Id)
JOIN 	tVariables AS		fields ON (classElements.id=Fields.id)
JOIN 	tConstants AS 		notations ON (classes.KindOfMember=Notations.value)
/*path file of the element*/
JOIN 	tSourceEntities AS 	source ON (classElements.Id = source.Id) 
JOIN 	tFiles AS 		files ON (source.SourceFileId = files.Id) 


WHERE 	(classElements.isFinal=0 AND classElements.isStatic=0 )
AND 	(fields.IsPassedByRef=1)
AND 	(notations.Name = 'TYPE_CLASS' OR notations.Name = 'TYPE_GENERICCLASS')
/*AND classElements.KindOfMember=65 */