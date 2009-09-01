/*   2.3 Non Final Static Fields 

- 2.1 is allmost the same but for arrays
*/

SELECT 
member.Name		AS Name, 
type.Name		AS Type,
visibility.Name	AS Visibility,
files.PathName	AS Path
 /*Zeilennummer*/



FROM 
tMembers AS member 
/*file source*/
JOIN tSourceEntities AS source ON (member.Id = source.Id)
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 
/*visibility*/
JOIN tConstants AS visibility ON (member.Visibility = visibility.value)
/*type of member*/
JOIN tConstants AS type ON (member.KindOfMember = type.Value)


WHERE 
/*static, nof final */
member.isstatic = 1 AND member.isfinal != 1
/*public visibility*/
AND (visibility.Name = 'VISIBILITY_PUBLIC')
/*type of element: variable */
/* nicht */
AND (type.Name = 'TYPE_ARRAY' OR true)


;
