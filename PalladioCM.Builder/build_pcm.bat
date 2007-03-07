@echo off

rem The install directory of the PDE Build
set ECLIPSE_HOME=C:\pdebuild\org.eclipse.releng.basebuilder

rem The directory where this script is located
set BASE_DIR=C:\coding\pcm2builder

java -cp %ECLIPSE_HOME%\plugins\org.eclipse.equinox.launcher.jar org.eclipse.core.launcher.Main -application org.eclipse.ant.core.antRunner -clean -buildfile "%ECLIPSE_HOME%\plugins\org.eclipse.pde.build\scripts\build.xml" -Dbuilder="%BASE_DIR%\pcm_build_scripts" %1
	