/*   2.1 Stores Mutable Object in Static Variables 
Status : 50 %

DONE
- search vor static non final variables


TODO
- output fields list
- search for public code
- kind of objects 

IDEA
- 

QUESTION
- is VISIBILITY_PUBLIC the accumulative or the declared visibility?

HINT
- 2.2 is allmost the same but  for arrays
*/

SELECT 
member.Name as Name, 
type.Name as Type,
visibility.Name as Visibility,
files.PathName as Path
 /*Zeilennummer*/



FROM 
tMembers AS member 
/*file source*/
JOIN 
	tSourceEntities AS source ON (member.Id = source.Id) JOIN
	tFiles AS files ON (source.SourceFileId = files.Id) 
/*visibility*/
JOIN
	tConstants AS visibility ON (member.Visibility = visibility.value)
/*type of member*/
JOIN 
	tConstants AS type ON (member.KindOfMember = type.Value)


WHERE 
/*static, nof final */
member.isstatic = 1 AND member.isfinal != 1
/*public visibility*/
AND (visibility.Name = 'VISIBILITY_PUBLIC')
/*type of element: variable */
/* nicht */
AND (type.Name = 'VAR_FIELD' OR true);
