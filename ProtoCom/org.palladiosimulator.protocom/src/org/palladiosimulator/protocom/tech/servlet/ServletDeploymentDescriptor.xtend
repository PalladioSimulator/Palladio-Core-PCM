package org.palladiosimulator.protocom.tech.servlet

import org.palladiosimulator.protocom.lang.xml.impl.JeeDeploymentDescriptor

class ServletDeploymentDescriptor extends JeeDeploymentDescriptor {
	override filePath() {
		"WebContent/WEB-INF/web.xml"
	}
	
	override body() {
		'''
		<display-name>Reference</display-name>
		<jsp-config>
			<jsp-property-group>
				<url-pattern>*.jsp</url-pattern>
				<trim-directive-whitespaces>true</trim-directive-whitespaces>
			</jsp-property-group>
		</jsp-config>
		'''
	}
}
