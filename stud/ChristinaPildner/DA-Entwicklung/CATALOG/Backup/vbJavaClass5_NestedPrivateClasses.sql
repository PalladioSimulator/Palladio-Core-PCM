/*
DOES
- selects the static private nested classes in public classes
*/

SELECT 
nestedClass.id AS nestedClassID,
nestedClass.Name AS NestedClassName,
tconstants.Name AS NestedClassScope,
upperClass.id AS UpperClassID,
upperClass.Name AS UpperClassName,
/*point to the declaration of the nested class*/
nestedRelation.DepthOfContainment AS ContaintmentDepth,
nestedClassSource.startLine AS NestedClassStartLine,
files.Pathname AS nestedClassFilePath


FROM tMembers AS nestedClass
JOIN tClassContainmentRelations AS nestedRelation ON (nestedRelation.ClassId = nestedClass.id)
JOIN tMembers AS upperClass ON (nestedRelation.ContainingClassId=upperClass.id)
/*for the scope*/
JOIN tModelElements AS moreAttributes ON (nestedClass.id= moreAttributes.id)
JOIN tconstants ON (moreAttributes.scope = tconstants.value)
/*file code of the nested class */
JOIN tSourceEntities AS nestedClassSource ON (nestedClass.ClassId=nestedClassSource.id)
JOIN tFiles as files ON (nestedClassSource.sourceFileId = files.id)

WHERE 
nestedClass.visibility = 149  AND /*VISIBILITY_PRIVATE*/ 
nestedClass.isStatic = 1 and 
upperclass.visibility = 145 /*VISIBILITY_PUBLIC*/


;