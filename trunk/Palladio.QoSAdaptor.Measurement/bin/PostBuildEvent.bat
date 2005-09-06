@echo off
copy C:\Dokumente und Einstellungen\user\Eigene Dateien\Visual Studio Projects\Palladio.QoSAdapter\Palladio.QoSAdaptor.Measurement\Palladio.QoSAdaptor.Measurement.exe.config bin\
if errorlevel 1 goto CSharpReportError
goto CSharpEnd
:CSharpReportError
echo Project error: Ein Tool hat einen Fehlercode des Buildereignisses zurÅckgegeben.
exit 1
:CSharpEnd