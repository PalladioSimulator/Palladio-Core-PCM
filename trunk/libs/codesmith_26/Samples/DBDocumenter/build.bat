@echo off
echo CodeSmith DBDocumenter Templates v2.0
echo Author:  Jason Alexander (jason@ngallery.org)
echo Website: http://www.ngallery.org/dbdocumenter/
echo -------------------------------------------------------------

echo Beginning documentation...
"c:\Program Files\CodeSmith\v2.5\codesmithconsole" /t:master.cst /p:dbdocs_properties.xml /nologo

echo Done.