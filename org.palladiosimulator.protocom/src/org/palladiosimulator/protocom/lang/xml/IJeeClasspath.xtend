package org.palladiosimulator.protocom.lang.xml

import java.util.List

interface IJeeClasspath extends IClasspath {
	
	def String clientClassPathEntry()
	
	def List <String> requiredClientProjects()
	
	}