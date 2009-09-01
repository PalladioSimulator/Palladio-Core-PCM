SELECT 
  "package".fullname AS "PackageName", 
  "class"."name" AS "ClassName", 
  "function"."name" AS "FunktionName", 
  file.pathname AS "FileName", 
  source.startline AS "Startline"
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
  "function"."name" = 'addShutdownHook' AND 
  functionpackage.fullname = 'java.lang' AND 
  functionclass."name" = 'Runtime';
