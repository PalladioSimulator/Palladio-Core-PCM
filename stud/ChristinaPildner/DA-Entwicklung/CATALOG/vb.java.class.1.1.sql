/*
@Author: Christina Pildner - FZI 2009

VULNERABILITY
- vb.java.class.1 - Stores Mutable Object in Static Variable
 
QUERY DOES 
- select all the static variables in the code whose declaration type is mutable 

OBSERVATIONS
- also the mutable library class declarations are shown
- definition of mutable type used for the query: class not final 

MESSAGE 
- Static variable with mutable declaration type. Make the declaration type immutable or protect the access to the variable by making it private and controlling the access through secure getter and setter. 
*/

SELECT DISTINCT
/*mandatory columns */
  package.fullname AS PackageFullName, 
  class.name AS ClassName, 
  field.name AS ElementName,
  file.pathname AS FilePathName, 
  source.startline AS StartLine,
  source.startChar AS startChar, 
/*optional columns*/ 
 definitionpackage.fullname AS TypePackageName, 
  definitionclass.name AS TypeClassName 

FROM taccesses AS access 
JOIN tvariables AS field ON (field.typedeclarationid = access.id)
JOIN tpackages AS package ON (package.id = field.packageid)
JOIN tmembers AS class ON (class.id = field.classid)
JOIN tmodelelements AS definitionclass ON (access.targetid = definitionclass.id)
JOIN tpackages AS definitionpackage ON (definitionclass.parentid = definitionpackage.id)

JOIN tsourceentities AS source ON (field.id = source.id) 
JOIN tfiles AS file ON (source.sourcefileid = file.id)
JOIN tmembers AS moreDefinitionClass ON (definitionclass.id = moreDefinitionClass.id)
JOIN tmembers AS Definitionclassfields ON (definitionclass.id = Definitionclassfields.classid)

WHERE 
  moreDefinitionClass.isfinal = 0 AND 
  Definitionclassfields.isfinal = 0 AND 
  Definitionclassfields.visibility != 149 AND 
  Definitionclassfields.kindofmember = 65
;

