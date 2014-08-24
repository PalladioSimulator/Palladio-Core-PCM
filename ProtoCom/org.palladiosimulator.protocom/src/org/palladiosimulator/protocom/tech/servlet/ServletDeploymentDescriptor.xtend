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
		
		<servlet>
			<servlet-name>REST</servlet-name>
			<servlet-class>com.sun.jersey.spi.container.servlet.ServletContainer</servlet-class>
			<init-param>
				<param-name>com.sun.jersey.config.property.packages</param-name>
				<param-value>org.palladiosimulator.protocom.framework.java.ee.api.rest</param-value>
			</init-param>
			<load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping>
			<servlet-name>REST</servlet-name>
			<url-pattern>/api/*</url-pattern>
		</servlet-mapping>
		
		<resource-ref>
			<res-ref-name>EcmService</res-ref-name>
			<res-type>com.sap.ecm.api.EcmService</res-type>
		</resource-ref>
		'''
	}
}
