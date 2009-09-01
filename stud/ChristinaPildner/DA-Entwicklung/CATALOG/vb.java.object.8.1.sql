/*
@Author: Christina Pildner - FZI 2009

VULNERABILITY
vb.java.object.8 - Malicious Program Abuse – Native Code

QUERY DOES 
-lists class load function accesses in the code that might load native classes

CONSTRAINTS
- the 'hand made' invocations are not listed

MESSAGE 
- this method might load native code. Make sure the method can not be accessed from malicious code.  
*/

SELECT 
/*mandatory columns*/
package.Fullname AS PAckageName,
class.NAme As ClassName,
function.Name AS FunctionName,  
source.startline AS StartLine, 
source.startchar AS StartChar, 
files.pathname AS Patchname,
/*optional columns*/
classLoaderPackage.fullname AS ClassLoaderPackageName, 
classLoaderClass.name AS ClassLoaderClassName, 
classLoaderMethod.name AS ClassLoaderMethodName


FROM public.tfunctions AS classLoaderMethod 
LEFT JOIN public.tpackages AS classLoaderPackage ON ( classLoaderMethod.packageid = classLoaderPackage.id )
LEFT JOIN  public.tmembers AS  classLoaderClass ON ( classLoaderMethod.classid = classLoaderClass.id)
JOIN taccesses AS accesses ON ( classLoaderMethod.id = accesses.targetid)
JOIN tmembers AS class ON (accesses.classid = class.id)
JOIN tpackages AS package ON (accesses.packageid = package.id) 
LEFT JOIN tfunctions AS function ON (accesses.functionid = function.id)

JOIN  public.tsourceentities AS source ON (accesses.id = source.id)
JOIN  public.tfiles as files ON (source.sourcefileid = files.id)

WHERE 
accesses.kindofaccess = 97 /*FUNCACCESS*/
/*classLoader methods invocation methods*/
AND ( 
        (classLoaderPackage.fullname = 'java.lang' AND classLoaderClass.name = 'Class' AND classLoaderMethod.name = 'forName')
     OR (classLoaderPackage.fullname = 'java.lang' AND classLoaderClass.name = 'Package' AND classLoaderMethod.name = 'getPackage')
     OR (classLoaderPackage.fullname = 'java.lang' AND classLoaderClass.name = 'Runtime' AND classLoaderMethod.name = 'load')
     OR (classLoaderPackage.fullname = 'java.lang' AND classLoaderClass.name = 'Runtime' AND classLoaderMethod.name = 'loadLibrary')
     OR (classLoaderPackage.fullname = 'java.lang' AND classLoaderClass.name = 'System' AND classLoaderMethod.name = 'load')
     OR (classLoaderPackage.fullname = 'java.lang' AND classLoaderClass.name = 'System' AND classLoaderMethod.name = 'loadLibrary')
     OR (classLoaderPackage.fullname = 'java.sql' AND classLoaderClass.name = 'DriverManager' AND classLoaderMethod.name = 'getConnection')
     OR (classLoaderPackage.fullname = 'java.sql' AND classLoaderClass.name = 'DriverManager' AND classLoaderMethod.name = 'getDriver')
     OR (classLoaderPackage.fullname = 'java.sql' AND classLoaderClass.name = 'DriverManager' AND classLoaderMethod.name = 'deregisterDriver')
     OR (classLoaderPackage.fullname = 'java.util' AND classLoaderClass.name = 'ResourceBundle' AND classLoaderMethod.name = 'getBundle')
     
    )
order by PackageName
;

