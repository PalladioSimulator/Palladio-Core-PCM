@ECHO OFF
CD %~dp0
java -ea -Xms40m -Xmx512m -cp osdriver.jar -Djava.security.policy=host.policy -Dosdriver.properties=osdriver.properties StartHost