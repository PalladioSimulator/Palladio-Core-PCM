package org.palladiosimulator.protocom.lang.java.impl

import org.palladiosimulator.protocom.lang.GeneratedFile
import org.palladiosimulator.protocom.lang.java.IJeeGlassfishEjbDescriptor

class JeeGlassfishEjbDescriptor extends GeneratedFile<IJeeGlassfishEjbDescriptor> implements IJeeGlassfishEjbDescriptor{
	
	def header() {
		'''<!DOCTYPE glassfish-ejb-jar PUBLIC "-//GlassFish.org//DTD GlassFish Application Server 3.1 EJB 3.1//EN" "http://glassfish.org/dtds/glassfish-ejb-jar_3_1-1.dtd">'''
	}
	
	def body() {
	'''<glassfish-ejb-jar>
    	<enterprise-beans>
       	 <ejb>
        	<ejb-name>«ejbName»</ejb-name>
        	<ejb-ref>
            	<ejb-ref-name>«ejbRefName»</ejb-ref-name>
           		 <jndi-name>«jndiName»</jndi-name>
      		 </ejb-ref>
       	 </ejb>
    	</enterprise-beans>
	</glassfish-ejb-jar>'''
	}
	
	override ejbName() {
		provider.ejbName
	}
	
	override ejbRefName() {
		provider.ejbRefName
	}
	
	override jndiName() {
		provider.jndiName
	}
	
	override generate() {
		'''
		«header»
		«body»
		'''
	}
	
}