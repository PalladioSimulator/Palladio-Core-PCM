##############################
###   Palladio.Webserver   ###
##############################


Palladio-Gruppe, Abteilung Software Engineering, Department für Informatik, Universität Oldenburg, Germany
Homepage of the Palladio-Group: http://se.informatik.uni-oldenburg.de/palladio



==============================
==== General Information: ====
==============================
The Palladio.Webserver is a component-based webserver for research-purposes only. 
Remark: If you are searching for a webserver for use in a productive environment you should use Webservers like the Apache Webserver (http://www.apache.org).



==================
==== Folders: ====
==================
- Webserver: Palladio.Webserver-solution and basic project
- doc: some dokumentation (currently this folder contains an overview of the component-architecture of the webserver and a short description of the architecture.)
- Config: XML-Configuration-Files
- documents: HTML-Test-Files (contains as well test-data for the bibtex-component; see: .\documents\DBTestData\Bibtex.txt - this are comma-seperated test-entries for the database)
- Libraries: Used libraries of the webserver
- Altova: do not change, because this is generated code by XML-Spy
- AltovaXML: do not change, because this is generated code by XML-Spy
- [something]XML: do not change, because this is generated code by XML-Spy
- [other]: webserver-components



======================================================
==== How to install and configure - a quick guide ====
======================================================
If you check out the Palladio.Webserver from the CVS it should be possible to open the Visual-Studio Solution file. You will find this file in ".\Webserver\Palladio.Webserver.sln". Now you can simply compile the project with the default settings - the webserver should start running, but the settings are not customized for your system by now.

Probably you will want to configure the webserver. The "Config"-directory contains all necessary configuration-files.
Overview of config-files and their meaning:
- webserverXML.xml: basical webserver-settings
- SimpleTemplateFileProviderXML.xml: configuration for the SimpleTemplateFileProvider-Component
- BibTeXProviderXML.xml: configuration for the BibTeXProviderXML; e. g. the database-settings are set here

== Basic configuration: ==
- Open the webserverXML.xml.
- First define the IP-Address the webserver should listen on. If you plan to use the webserver only on your local machine you can use "127.0.0.1" (default setting). For use in an entire network you have to set the ip-address of the network-device you are connected with to the desired network.
- Second you have to specify the "DocumentRoot", which means the path to the websites that shall be delivered by the webserver. This path can be set relative to the "webserver.exe", which is probably in the debug-folder from the Visual Studio project. By default this path is "../../../documents", and contains some test-files.
- All other settings are optional. For further configuration-options of the webserver refer to the inline-documentation of the XML-File.
- By default the webserver now already delivers static sites on the ports 81 and 82.
- To access the files you have to start a webbrowser and request the default-URL "http://127.0.0.1:81/".

== Database configuration: ==
- The BibTeXProvider-Component uses a database to create dynamic files. To set up the setting for the database-connection open the "BibTeXProviderXML.xml".
- First set the "DataSource". This is the host-name of the database-server. The webserver is configured to be used with the "Microsoft SQL Server". Other databases are currently not supported. For the use with a local database this name is be identically to the host-name of your computer. You can find the host-name at the desktop > "My Computer" > right-click: "Properties" > "Computername" > "Computername".
- Now you have to put some test-data to the database. For further exact information how to set up the MS SQL-Server using the test-data you should take a look at the "Microsoft SQL Server"-documentation.
The following short decription how to put the test-data into the database refers to the german version of MS SQL Server.
Open "SQL Server Enterprise Manader" from the startmenu. Chose the local DB-Server and create a new database (default name: "BibTeX"). Right-Click the database-icon and chose "Alle Tasks" > "Daten importieren". A MS assistant will appear to lead you through the process. Chose "Textdatei" as "Datenquelle" and specify the filename (.\documents\DBTestData\Bibtex.txt). In the next step chose "Getrennt. Die Spalten si..." and continue. As Target ("Ziel") you have to select "Microsoft OLE DB Provider für SQL Server", the target-database is the newly created database "BibTeX". The target table-name is "BibTeX" by default. If you continue executing the assistant the data will be completely imported. Now the DB-access should work.

== Other configuration-options: ==
Feel free to customize the other xml-files as well. Each option is descripted/explained in the concerned file.



=======================
==== Version-Logs: ====
=======================
$Log$
Revision 1.7  2005/02/03 07:42:40  kelsaka
Added method to adjust the size of the thread pool.

Revision 1.6  2005/02/02 17:34:57  kelsaka
Added multi-threading to handle requests.
Added short architectural description.

Revision 1.5  2005/01/07 08:26:38  kelsaka
updated documentation; added installation guide

Revision 1.4  2004/12/03 11:09:32  kelsaka
The BibTeXProvider now reads its configuration from a xml-file; fixed sql-search-error in the BibTeXProvider; added documentation especially about a strange behaviour of the socket-connection  in the BibTeXProvider;

Revision 1.3  2004/10/30 15:24:39  kelsaka
webserverMonitor-Output on console; documentation (doc) update

Revision 1.2  2004/10/22 14:18:17  kelsaka
interface-update

Revision 1.1  2004/10/17 17:25:09  kelsaka
initial cvs-version; added general project structure
