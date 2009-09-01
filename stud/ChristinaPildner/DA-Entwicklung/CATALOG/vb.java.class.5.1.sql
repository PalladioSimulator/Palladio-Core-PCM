/*
VULNERABILITY
- vb.java.class.5 - Private Nested Class and Attributes made Protected

DOES
- selects the static private nested classes in public classes

MESSAGE
- This nested class can be made package-protected during compilation. Make sure that this class do not contain sensitive data.  
*/

SELECT 
/*mandatory columns*/
package.fullname 		AS PackageFullName, 
upperClass.Name 		AS ClassName, 
nestedClass.Name		AS ElementName, /* Nested class */
files.Pathname  		AS FilePathName, 
nestedClassSource.startline 	AS StartLine, 
nestedClassSource.startchar	AS StartChar
/*debug columns*/
/*nestedRelation.DepthOfContainment AS ContaintmentDepth*/


FROM 
	tMembers AS nestedClass
JOIN 	tClassContainmentRelations 	AS nestedRelation 		ON (nestedRelation.ClassId = nestedClass.id)
JOIN 	tMembers 			AS upperClass 			ON (nestedRelation.ContainingClassId=upperClass.id)
/*package*/
JOIN 	tModelelements 			AS upperClassAttributes 	ON (upperClass.id = upperClassAttributes.id)
JOIN 	tPackages 			AS package 			ON (upperclassAttributes.parentid = package.id)
/*file code of the nested class */
JOIN 	tSourceEntities 		AS nestedClassSource 		ON (nestedClass.ClassId=nestedClassSource.id)
JOIN 	tFiles 				AS files 			ON (nestedClassSource.sourceFileId = files.id)


WHERE 	
	nestedClass.visibility = 149 /*VISIBILITY_PRIVATE*/ 
AND 	nestedClass.isStatic = 1  
AND	upperclass.visibility = 145 /*VISIBILITY_PUBLIC*/
;