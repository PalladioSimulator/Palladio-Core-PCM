@ECHO OFF
java -ea -Xms40m -Xmx512m -cp osdriver.jar -Djava.security.policy=host.policy -Dhost.properties=host.properties StartHost