/*
VULNERABILITY
- vb.java.class.4 - Shutdown Hook

DOES 
selects all the invocation of 'addShutdownHook' method in code

OBSERVATION
- the addShutDownHook method is declared in java.lang.Runtime
- also the non public classes are considered for the search
- as SISSY doesn't store information from static blocks, the invocation of 'addShutdownHook' in static blocks are not listed

MESSAGE
- the method addShutdownHook can be used to run usecure threads during the virtual mashine shutdown sequence. Make the invocation secure by making the calling thread class final. 
*/

SELECT 
/*mandatory columns*/
package.fullname AS PackageFullName, 
class.name AS ClassName, 
function.name AS ElementName, /* Element = functions, where the "addShutdownHook" is called */ 
file.pathname AS FileName, 
source.startline AS Startline,
source.startchar AS Startchar, 
/*optional columns*/
functionpackage.fullname AS FunktionDeclarationPackageName, 
functionclass.name AS FunktionDeclarationClassName

FROM 
     public.taccesses AS access 
JOIN public.tsourceentities AS source ON (access.id = source.id) 
JOIN public.tfiles AS file ON (source.sourcefileid = file.id) 
JOIN public.tmembers AS class ON (class.id = access.classid) 
JOIN public.tpackages AS package ON (package.id = access.packageid) 
JOIN public.tfunctions AS function ON (access.targetid = function.id) 
JOIN public.tpackages AS functionpackage ON (function.packageid = functionpackage.id) 
JOIN public.tmembers AS functionclass ON (function.classid = functionclass.id)

WHERE 
function.name = 'addShutdownHook';
