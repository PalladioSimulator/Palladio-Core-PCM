/*
DOES 
-select all the calls in the code to java.security.AccessController.doPrivileged()

*/

SELECT 
  package.fullname, 
  class.name, 
  method.name, 
  tfiles.pathname, 
  tsourceentities.startline
FROM 
  public.tpackages package, 
  public.tmembers class, 
  public.tfunctions method, 
  public.taccesses access, 
  public.tfunctions doPrivileged, 
  public.tpackages privilegedPackage, 
  public.tmembers privilegedClass, 
  public.tsourceentities, 
  public.tfiles
WHERE 
  access.functionid = method.id AND
  access.packageid = package.id AND
  access.classid = class.id AND
  access.targetid = doPrivileged.id AND
  access.id = tsourceentities.id AND
  doPrivileged.packageid = privilegedPackage.id AND
  doPrivileged.classid = privilegedClass.id AND
  tfiles.id = tsourceentities.sourcefileid AND
  doPrivileged.name = 'doPrivileged' AND 
  privilegedPackage.fullname = 'java.security' AND 
  privilegedClass.name = 'AccessController';
