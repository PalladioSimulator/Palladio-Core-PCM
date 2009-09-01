/*
VULNERABILITY
- vb.java.object.6 - Information Leak through Exception

DOES 
- lists all the exceptions thrown in the code

MESSAGE 
- this method throws exception(s). Make sure the exception data trown is not sensitive. 
*/

SELECT
/*mandatory columns*/
package.FullName 	AS PackageFullName,
class.Name 		AS ClassName,
functions.name 		AS ElementName, /*method with the thrown exception*/
files.PathName 		AS FileName,
source.StartLine 	AS StartLine,
source.StartChar 	AS StartChar 


FROM tstatements	AS statements
JOIN tfunctions 	AS functions 	ON (statements.functionid =  functions.id)
JOIN tpackages 		AS package 	ON (functions.packageid = package.id) 
JOIN tMembers 		AS class 	ON (functions.classid = class.id ) 
JOIN tSourceEntities 	AS source 	ON (statements.Id = source.Id) 
JOIN tFiles 		AS files 	ON (source.SourceFileId = files.Id) 

WHERE	statements.kindofstatement = 72 /*STETEMENT_THROW*/



