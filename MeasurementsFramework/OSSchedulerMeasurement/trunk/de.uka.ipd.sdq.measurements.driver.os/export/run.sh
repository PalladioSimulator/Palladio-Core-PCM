#!/bin/sh
#java -ea -Xms40m -Xmx512m -cp osdriver.jar -Djava.security.policy=host.policy -Dhost.properties=host.properties StartHost

java -ea -Xms40m -Xmx512m -Djava.security.policy=host.policy -Dhost.properties=host.properties -cp osdriver.jar StartHost