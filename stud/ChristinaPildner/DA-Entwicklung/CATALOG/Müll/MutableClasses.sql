/*
DOES 
- selects all the classes in Quellcode that are not final and their field are not final and private 

CONSTRAINTS
- one-step-
*/


SELECT 
  classes.id AS ClassId, 
  classes.name AS ClassName, 
  classes.visibility AS ClassVisibility, 
  tpackages.fullname AS PackageName,
  tfiles.pathname AS FilePAth, 
  tsourceentities.startline AS Startline, 
  tsourceentities.startchar AS Startchar 
 

FROM public.tmembers AS classes
/*selects the fields of classes*/
LEFT JOIN public.tmembers AS staticVariables ON classes.id = staticVariables.classid
/*selects the package of the classes */
JOIN  public.tmodelelements ON  tmodelelements.id = classes.id 
JOIN  public.tpackages ON  tpackages.id = tmodelelements.parentid
/*File source, if exitence*/
LEFT JOIN  public.tsourceentities ON tsourceentities.id = classes.id
LEFT JOIN  public.tfiles ON  tfiles.id = tsourceentities.sourcefileid

WHERE 

  classes.kindofmember = 35 AND /*TYPE_CLASS*/
  classes.isfinal = 0 AND 
  staticVariables.kindofmember = 65 AND  /* VAR_FIELD */
  staticVariables.isstatic = 0 AND 
  staticVariables.visibility != 149 AND /* NOT STATIC */
  staticVariables.isfinal = 0;
