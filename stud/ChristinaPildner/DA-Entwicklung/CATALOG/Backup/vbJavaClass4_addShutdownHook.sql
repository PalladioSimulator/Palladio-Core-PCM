/*
DOES 
selects all the invocation of 'addShutdownHook' in the code
*/

SELECT 
  "package".fullname AS "PackageName", 
  "class"."name" AS "ClassName", 
  "function"."name" AS "FunktionName", 
  file.pathname AS "FileName", 
  source.startline AS "Startline", 
  functionpackage.fullname AS "FunktionDeclarationPackageName", 
  functionclass."name" AS "FunktionDeclarationClassName"
FROM 
  public.taccesses, 
  public.tfiles file, 
  public.tsourceentities source, 
  public.tmembers "class", 
  public.tpackages "package", 
  public.tfunctions "function", 
  public.tpackages functionpackage, 
  public.tmembers functionclass
WHERE 
  taccesses.id = source.id AND
  taccesses.targetid = "function".id AND
  source.sourcefileid = file.id AND
  "class".id = taccesses.classid AND
  "package".id = taccesses.packageid AND
  "function".packageid = functionpackage.id AND
  "function".classid = functionclass.id AND
  "function"."name" = 'addShutdownHook';
