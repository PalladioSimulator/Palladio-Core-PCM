@echo off
set ECLIPSE_HOME=C:\pdebuild\org.eclipse.releng.basebuilder
set BASE_DIR=C:\PCM\PalladioCM.Builder
java -cp %ECLIPSE_HOME%\startup.jar org.eclipse.core.launcher.Main -application org.eclipse.ant.core.antRunner -clean -buildfile "%ECLIPSE_HOME%\plugins\org.eclipse.pde.build\scripts\build.xml" -Dbuilder="%BASE_DIR%\pcm_build_scripts"
	