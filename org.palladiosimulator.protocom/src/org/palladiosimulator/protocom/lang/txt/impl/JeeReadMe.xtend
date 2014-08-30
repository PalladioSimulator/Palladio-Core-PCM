package org.palladiosimulator.protocom.lang.txt.impl

import com.google.inject.Inject
import com.google.inject.name.Named
import org.palladiosimulator.protocom.lang.GeneratedFile
import org.palladiosimulator.protocom.lang.txt.IReadMe

class JeeReadMe extends GeneratedFile<IReadMe> implements IReadMe{
	
	@Inject
	@Named("ProjectURI")
	String projectURI
	
	override generate() {
		'''The generated Java EE performance prototype contains the method "setContext" and the "throw RemoteException"
statement which have to be removed before the deployment on a real server. The generation of these is needed 
because of the ProtoCom framework that isn't changed to support Java EE. It is fit to Java SE. 

The "setContext" method, which has to be removed, is in the classes that represent the BasicComponents:
«FOR basicComponentClassProject: basicComponentClassName.keySet»
The class «basicComponentClassName.get(basicComponentClassProject)» in the project «projectURI»«basicComponentClassProject». 
«ENDFOR»

The "throw RemoteException" has to be removed from the Port classes of the BasicComponents: 
«FOR basicComponentPortClassProject:basicComponentPortClassName.keySet»
	«FOR basicComponentPortClass:basicComponentPortClassName.get(basicComponentPortClassProject)»
	The class «basicComponentPortClass» in the project «projectURI»«basicComponentPortClassProject».
	«ENDFOR»
«ENDFOR»


At last, you have to make sure that the following .jar files are in the plugins folder of Eclipse:
de.uka.ipd.sdq.simucomframework.variables_1.0.0.201401301023.jar
org.palladiosimulator.protocom.framework_1.0.0.201401301023.jar
org.palladiosimulator.protocom.resourcestrategies_1.0.0.201401301023.jar

They are served with the current Palladio Version 3.5 for Eclipse Kepler.
'''

	}
	
	override basicComponentClassName() {
		provider.basicComponentClassName
	}
	
	override basicComponentPortClassName() {
		provider.basicComponentPortClassName
	}
	
}