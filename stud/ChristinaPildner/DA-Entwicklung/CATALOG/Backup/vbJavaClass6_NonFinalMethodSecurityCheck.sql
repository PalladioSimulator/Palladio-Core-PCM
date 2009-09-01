/*
DOES 
- select all the non final functions that have a call to a check Merthos implemented in java.lang.SecurityManager or that inherits from it 

TODO
- clean the query from tests 
*/


SELECT 

package.Fullname AS PackageName,
classAttributes.Name AS ClassName,
functions.Name AS MethodName,
securityManagerAccess.secFuncPackageName AS SecurityPackageName,
securityManagerAccess.secFuncClassName AS SecurityClassName,
securityManagerAccess.secFuncName AS SecurityMethod,
source.StartLine AS StartLine,
source.StartChar AS StartChar,
files.PathName AS FileName


FROM tMembers AS classAttributes /*className of method*/
JOIN tFunctions AS functions ON (functions.classId = classAttributes.id)
JOIN tpackages AS package ON (functions.packageid = package.id)
JOIN tMembers AS functionAttributes ON (functions.id = functionAttributes.id)
JOIN tAccesses as declarationAccess ON (declarationAccess.sourceid = functionAttributes.id)
/*definition of the functions*/
JOIN tSourceEntities AS source ON (functions.Id = source.Id) 
JOIN tFiles AS files ON (source.SourceFileId = files.Id) 
JOIN ( /*select all the functions in the code that are called like the ones ind the security manager acesses to the security manager */
     SELECT 
		functions.id AS secFuncId,
		functions.Name AS secFuncName,  
		accesses.functionId AS functionId ,
                package.Fullname AS secFuncPackageName,
                class.Name AS secFuncClassName
		
		FROM tFunctions AS functions
		JOIN taccesses AS accesses ON (functions.id = accesses.targetid)
                JOIN tpackages AS package ON (functions.packageid = package.id)
                JOIN tmembers AS class ON (functions.classid = class.id)
                JOIN tinheritances AS inherits ON (class.id = inherits.classid)
                JOIN tmodelelements AS SecurityManager ON (inherits.superid = SecurityManager.id) 
                JOIN tpackages AS SecManPackage ON (SecurityManager.parentid = SecManPackage.id)
		
		WHERE
                ( (SecurityManager.Name = 'SecurityManager' AND SecManPackage.fullname = 'java.lang') OR 
                  (class.Name = 'SecurityManager' AND package.fullname = 'java.lang')
                )
		AND  accesses.kindofaccess = 97 /*funcaccess*/
                AND functions.Name != class.Name /* constructor call are not interesting */
                /*methods in java.lang.SecurityManager that do not check */
                AND ( Functions.name != 'getClassContext' 
                       AND functions.name != 'getSecurityContext'
                       AND functions.name != 'getThreadGroup')

		/* test - Deprecated
                AND (*/
		       /*defined in java.lang.SecurityManager */
		    Functions.Name = 'checkAccept' 
		    OR Functions.Name = 'checkAccess'
		    OR Functions.Name = 'checkAwtEventQueueAccess'
		    OR Functions.Name = 'checkConnect'
		    OR Functions.Name = 'checkCreateClassLoader'
		    OR Functions.Name = 'checkDelete'
		    OR Functions.Name = 'checkExec'
		    OR Functions.Name = 'checkExit'
		    OR Functions.Name = 'checkLink'
		    OR Functions.Name = 'checkListen'
		    OR Functions.Name = 'checkMemberAccess'
		    OR Functions.Name = 'checkMulticast' /*deprecated*/
		    OR Functions.Name = 'checkPackageAccess'
		    OR Functions.Name = 'checkPackageDefinition'
		    OR Functions.Name = 'checkPermission'
		    OR Functions.Name = 'checkPrintJobAccess'
		    OR Functions.Name = 'checkPropertiesAccess'
		    OR Functions.Name = 'checkRead'
		    OR Functions.Name = 'checkAccess'
		    OR Functions.Name = 'checkSetFactory'
		    OR Functions.Name = 'checkSystemClipboardAccess'
		    OR Functions.Name = 'checkTopLevelWindow'
		    OR Functions.Name = 'checkWrite'
		    OR Functions.Name = 'classDepth' /*deprecated*/
		    OR Functions.Name = 'classLoaderDepth'  /*deprecated*/
		    OR Functions.Name = 'currentClassLoader' /*deprecated*/
		    OR Functions.Name = 'currentLoadedClass' /*deprecated*/
		    OR Functions.Name = 'getClassContext'
		    OR Functions.Name = 'getInCheck' /*deprecated*/
		    OR Functions.Name = 'getContext'
		    OR Functions.Name = 'getThreadGroup'
		    OR Functions.Name = 'inClass' /*deprecated*/
		    OR Functions.Name = 'inClassLoader' /*deprecated*/
	         )/**/
) AS securityManagerAccess ON (securityManagerAccess.functionid = functions.id)


WHERE 
functionAttributes.isFinal = 0 /*function is not final*/
/*AND functionAttributes.IsStatic = 0 /*nor really necesary*/ */
AND declarationAccess.KindOfAccess = 117 /*TYPEACCESS_DECLARATION*/

;