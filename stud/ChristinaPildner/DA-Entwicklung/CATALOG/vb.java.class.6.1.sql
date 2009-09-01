/*
VULNERABILITY 
- vb.java.class.6 - Override Method

DOES 
- select all the non final methods in public code that have a call to a check methods implemented in java.lang.SecurityManager or that inherits from it 

OBSERVATION
- Non final method = class and method are declared non final

MESSAGE
-This method contains call(s) to Security Manager and can be overriden from subclasses. Make the class or the method final.
*/


SELECT 
/*mandatory colmuns*/
package.Fullname 	AS PackageFullName,
classAttributes.Name 	AS ClassName,
functions.Name 		AS ElementName, /*non final method name*/
files.PathName 		AS FilePathName,
source.StartLine 	AS StartLine,
source.StartChar 	AS StartChar,
/*optional columns*/
securityManagerAccess.secFuncPackageName 	AS SecurityPackageName,
securityManagerAccess.secFuncClassName 		AS SecurityClassName,
securityManagerAccess.secFuncName 		AS SecurityMethod


FROM 	tMembers 	AS classAttributes /*className of method*/
JOIN 	tFunctions 	AS functions 		ON (functions.classId = classAttributes.id)
JOIN 	tpackages 	AS package 		ON (functions.packageid = package.id)
JOIN 	tMembers 	AS functionAttributes 	ON (functions.id = functionAttributes.id)
JOIN 	tAccesses 	AS declarationAccess 	ON (declarationAccess.sourceid = functionAttributes.id)
/*element file source and position*/
JOIN 	tSourceEntities AS source 		ON (functions.Id = source.Id) 
JOIN 	tFiles 		AS files 		ON (source.SourceFileId = files.Id) 
JOIN ( /*select the functions from java.lang.SecurityManager */
     SELECT 
		functions.id 		AS secFuncId,
		functions.Name 		AS secFuncName,  
		accesses.functionId 	AS functionId ,
                package.Fullname 	AS secFuncPackageName,
                class.Name 		AS secFuncClassName
		
		FROM 	tFunctions 	AS functions
		JOIN 	taccesses 	AS accesses 		ON (functions.id = accesses.targetid)
                JOIN 	tpackages 	AS package 		ON (functions.packageid = package.id)
                JOIN 	tmembers 	AS class 		ON (functions.classid = class.id)
                JOIN 	tinheritances 	AS inherits 		ON (class.id = inherits.classid)
                JOIN 	tmodelelements 	AS SecurityManager	ON (inherits.superid = SecurityManager.id) 
                JOIN 	tpackages 	AS SecManPackage 	ON (SecurityManager.parentid = SecManPackage.id)
		
		WHERE	(	   (SecurityManager.Name = 'SecurityManager' AND SecManPackage.fullname = 'java.lang') 
				OR (class.Name = 'SecurityManager' AND package.fullname = 'java.lang')
			)
		AND  	accesses.kindofaccess = 97 /*funcaccess*/
                AND	functions.Name != class.Name /* constructor call are not interesting */
                /*methods in java.lang.SecurityManager that do not check security */
                AND ( 	    functions.name != 'getClassContext' 
			AND functions.name != 'getSecurityContext'
			AND functions.name != 'getThreadGroup'
		    )

		
	)	 	AS securityManagerAccess ON (securityManagerAccess.functionid = functions.id)


WHERE 
	functionAttributes.isFinal = 0 /*element not final*/
AND	classattributes.isfinal = 0 /*class not final*/
AND	classattributes.visibility =  145 /*class VISIBILITY_PUBLIC*/
AND 	declarationAccess.KindOfAccess = 117 /*TYPEACCESS_DECLARATION*/

;