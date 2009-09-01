/*   
DOES
- search vor static non final fields in the classes 

TODO 
- proove the output 

*/

SELECT 
member.Name as Name, 
type.Name as Type,
visibility.Name as Visibility,
files.PathName as Path
/**/


FROM 
tMembers AS member 
/*file source*/
JOIN tSourceEntities AS source ON (member.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 
/*type of member*/
JOIN tConstants AS type ON (member.KindOfMember = type.Value)


WHERE 
/*static, nof final */
member.isstatic = 1 AND member.isfinal != 1
/*type of element: variable */
AND (type.Name = 'TYPE_VAR)


;
