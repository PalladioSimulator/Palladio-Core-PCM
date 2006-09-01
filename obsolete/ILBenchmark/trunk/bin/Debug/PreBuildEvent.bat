@echo off
copy C:\Dokumente und Einstellungen\RickDangerous\Eigene Dateien\Visual Studio Projects\ILBenchmark\MinParameter.xml C:\Dokumente und Einstellungen\RickDangerous\Eigene Dateien\Visual Studio Projects\ILBenchmark\bin\Debug\MinParameter.xml
if errorlevel 1 goto CSharpReportError
goto CSharpEnd
:CSharpReportError
echo Project error: Ein Tool hat einen Fehlercode des Buildereignisses zurÅckgegeben.
exit 1
:CSharpEnd