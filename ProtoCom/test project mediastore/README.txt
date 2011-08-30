See also https://sdqweb.ipd.kit.edu/wiki/ProtoCom

This folder contains example projects for Protocom. They have been generated with the PCM2Protocom transformation and then manually adjusted to run with EJB (BRS*flat folders).

The original models are found at https://svnserver.informatik.kit.edu/i43/svn/code/Palladio.Examples/trunk/PCM3.3_BRS_Optimisation_Heuristics
 
The PCM2Protocom transformation probably cannot handle the latest metamodel changes yet, so an older PCM build and an older version of the BRS (August 2010) could be used. I used the PCM nightly build of 2010-07-21. 

Protocom does currently not support composite components. Thus, I have created a flat version of the BRS without composites. This has been committed on 2011-02-07 to the BRS model folder. From this, the BRS*flat EJB projects have been generated and manually adjusted. 

Documentation Protocom Structure.txt contains notes on how components are mapped to EJB structures. 

Konfiguration.txt contains notes of what I additionally changed when deploying the EJBs to my glassfish instance. This is not all, other changes are described on the Wiki page and others may not be described at all. 

BRS distribution setup describes Anne's setup for some experiments with Protocom. The EAR to deploy on the remote server is in the SVN at https://svnserver.informatik.kit.edu/i43/svn/code/Palladio/Core/branches/ProtocomBRSHeikosServerVersion/ProtoCom/test project mediastore/ It is thus not of general interest, but may be an example for how to distribute the system.

To use the system on one machine, copy and rename BRSProtocomEJBFlat/ejbModule/META-INF/ejb-jar-single-server-setup.xml to ejb-jar.xml. The current ejb-jar.xml might describe a distributed setup.

I have so far ignored all CHKJ* errors. 

As the sensorframework output is a bit problematic on my machine, I added more debugging using a ResultsWriter class from the DSEExplore project that writes plain csv files. That is not committed to the SVN, contact Anne if you want it, too.


In der verteilten Version ProtocomBRSHeikosServerVersion wird im Classpath auf resourcestrategies2.jar und prototype.framework2.jar verwiesen. Diese jars enthielten die Pfade auf die Temp-Verzeichnisse in die die Kalibrierungsdateien von Protocom geschrieben werden. Ich hatte auf Heikos Rechner ja zwei EJB-Server laufen, die verschiedene CPU Speeds haben sollten, die sich aber nicht in die Quere kommen sollten. In dem plugin wird aber in der Datei  de.uka.ipd.sdq.resourcestrategies\src\conf\CPUConfig.properties fest ein Pfad vorgegeben, unter dem die Kalibrierungsergebnisse gespeichert werden. Daher musste ich das Projekt duplizieren und habe es in resourcestrategies2.jar umbenannt und dort die Config-Datei angepasst. 







