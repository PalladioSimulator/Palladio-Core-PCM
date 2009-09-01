/*
DOES 
select all the variales whos declaration Type is mutable 
*/

SELECT DISTINCT
  package.fullname, 
  class.name, 
  field.name, 
  definitionpackage .fullname, 
  definitionclass.name, 
  file.pathname, 
  source.startline
FROM 
  public.taccesses access, 
  public.tpackages package, 
  public.tmembers class, 
  public.tvariables field, 
  public.tmodelelements definitionclass, 
  public.tpackages definitionpackage , 
  public.tsourceentities source, 
  public.tfiles file, 
  public.tmembers moreDefinitionClass, 
  public.tmembers Definitionclassfields
WHERE 
  access.targetid = definitionclass.id AND
  package.id = field.packageid AND
  class.id = field.classid AND
  field.typedeclarationid = access.id AND
  field.id = source.id AND
  definitionclass.parentid = definitionpackage .id AND
  definitionclass.id = moreDefinitionClass.id AND
  definitionclass.id = Definitionclassfields.classid AND
  source.sourcefileid = file.id AND
  moreDefinitionClass.isfinal = 0 AND 
  Definitionclassfields.isfinal = 0 AND 
  Definitionclassfields.visibility != 149 AND 
  Definitionclassfields.kindofmember = 65
;

