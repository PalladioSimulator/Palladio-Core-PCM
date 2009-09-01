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
- 2.2 is allmost the same but for arrays
*/

/*
SELECT funktionen,  
FROM  
WHERE
*/


SELECT 
functions.Name AS 	FunctionName, 		/*name of the function*/
variables.Name AS 	VariableName, 		/*name of the variable in the function*/ 
/*AS 			StoredReferenceVariableName	/*name of the accessed static variable*/ */
files.PathName AS 	Path



FROM 
tVariables AS variables 
/*funtion that contains variable*/
JOIN
	tFunctions AS 	functions	ON (variables.functionid = functions.id)

/*variable stores a reference to this static element*/
	

/*file source*/
JOIN 
	tSourceEntities AS source 	ON (functions.Id = source.Id) JOIN
	tFiles AS 	files 		ON (source.SourceFileId = files.Id) 

/*type of member*/

 
ORDER BY FunctionName

;


