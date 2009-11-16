#!/bin/sh
#java -ea -Xms40m -Xmx512m -cp osdriver.jar -Djava.security.policy=host.policy -Dosdriver.properties=osdriver.properties StartHost

java -ea -Xms40m -Xmx512m -Djava.security.policy=host.policy -Dosdriver.properties=osdriver.properties -cp osdriver.jar StartHost