/*   vbJavaObject16 
6.11 Non-Final Parameters - Inversion of control  
Status : 50 %

DONE

IDEA
-search for non final methods in non final classes 

TODO
-search package limitation on public - See  WHERE Statement 

OBSERVATIONS
- also are shown anonymous classes
*/

SELECT 
method.Name as MethodName, 
class.Name as ClassName,
type.Name as Type,
files.PathName as Path
 /*Zeilennummer*/


FROM 
tMembers AS method 
/*class*/
JOIN	tMembers AS class ON (method.ClassId=class.id)

/*file source*/
JOIN	tSourceEntities AS source ON (method.Id = source.Id)
JOIN	tFiles AS files ON (source.SourceFileId = files.Id) 
/*type of member*/
JOIN 
	tConstants AS type ON (method.KindOfMember = type.Value)


WHERE 
/*method is not final*/
method.IsFinal = 0 
AND
/*class of method is not final*/
class.IsFinal = 0 
AND
/*only methods as type*/
type.Name like 'FUNC_METHOD'
AND
/*class can be seen out of package*/
class.IsInternal = '0'
/*class.IsExtern = '0'*/

;

