package org.palladiosimulator.protocom.lang.xml

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector
import java.util.HashMap

interface IJeeGlassfishEjbDescriptor extends IJeeDescriptor {
	 
	def String jndiName()
	
	def String ipAddress()
	
	def HashMap<AssemblyConnector,String> requiredComponentsAndResourceContainerIPAddress()
}