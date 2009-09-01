/*
VULNERABILITY
- vb.java.class.7 - Privileged Execution of Caller provided Code

DOES 
- select all the methods in the code have calls in the code to java.security.AccessController.doPrivileged() method

MESSAGE
- this methods calls the doProvileged method of the accesscontroller. Use only validated secure threads for the call. Make the implemented class od method final.
*/

SELECT 
/*mandatory columns*/
package.fullname 	AS PackeageFullName, 
class.name 		AS ClassName, 
method.name 		AS ElementName, /*method name*/ 
files.pathname 		AS FilePathName, 
source.startline 	AS StartLine,
source.startchar	AS StartChar


FROM taccesses 		AS access 
JOIN tmembers 		AS class 		ON (access.classid = class.id)  
JOIN tfunctions 	AS method 		ON (access.functionid = method.id) 
JOIN public.tpackages 	AS package 		ON (access.packageid = package.id) 
JOIN tfunctions 	AS doPrivileged 	ON (access.targetid = doPrivileged.id) 
JOIN tpackages 		AS privilegedPackage 	ON (doPrivileged.packageid = privilegedPackage.id) 
JOIN tmembers 		AS privilegedClass 	ON (doPrivileged.classid = privilegedClass.id) 
JOIN tsourceentities 	AS source 		ON (access.id = source.id)
JOIN tfiles		AS files 		ON (files.id = source.sourcefileid)


WHERE 	doPrivileged.name = 'doPrivileged'  
AND 	privilegedPackage.fullname = 'java.security'  
AND	privilegedClass.name = 'AccessController';
