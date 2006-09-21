@echo off
set ECLIPSE_HOME=C:\eclipse3.2
set SUBVERSION_JAR=..\..\lib\dom4j-1.6.1.jar;..\..\lib\ganymed.jar;..\..\lib\javasvn.jar;..\..\lib\svnjavahl.jar;..\..\lib
java -cp %SUBVERSION_JAR%;%ECLIPSE_HOME%\eclipse\startup.jar org.eclipse.core.launcher.Main -application org.eclipse.ant.core.antRunner -buildfile "C:\Dokumente und Einstellungen\Snowball\PCM\de.uka.ipd.sdq.builder\scripts\build.xml"
	