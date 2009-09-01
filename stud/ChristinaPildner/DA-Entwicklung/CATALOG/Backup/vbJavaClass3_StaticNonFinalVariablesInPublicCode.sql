/*
DOES
-search for static non final variables in public code
*/

SELECT 
  "package".fullname, 
  "class"."name", 
  variable."name", 
  file.pathname, 
  source.startline, 
  source.startchar
FROM 
  public.tvariables variable, 
  public.tpackages "package", 
  public.tmembers "variableAttributes", 
  public.tmembers "class", 
  public.tsourceentities source, 
  public.tfiles file
WHERE 
  variable.id = "variableAttributes".id AND
  variable.id = source.id AND
  "package".id = variable.packageid AND
  "class".id = variable.classid AND
  source.sourcefileid = file.id AND
  "variableAttributes".isstatic = 1 AND 
  "variableAttributes".isfinal = 0 AND 
  "class".visibility = 145;
