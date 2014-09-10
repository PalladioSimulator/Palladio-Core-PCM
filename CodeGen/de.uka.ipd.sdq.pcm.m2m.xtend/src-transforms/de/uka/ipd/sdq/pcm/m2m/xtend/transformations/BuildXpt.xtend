package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector
import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.Repository
import de.uka.ipd.sdq.pcm.system.System
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn

@ModelIn(#[
	"pcm.usagemodel.UsageModel",
	"pcm.usagemodel.EntryLevelSystemCall",
	"pcm.system.System",
	"pcm.repository.InfrastructureProvidedRole",
	"pcm.repository.OperationProvidedRole",
	"pcm.repository.Repository",
	"pcm.core.composition.ProvidedDelegationConnector"
])
class BuildXpt {
	@Inject M2TFileSystemAccess fsa

	@Inject extension JavaNamesExt
	@Inject extension PCMext

	def buildScripts(UsageModel um) {
		um.buildProperties
		um.fileList
		um.clientXML
		um.applicationXML
	}

	private def buildProperties(UsageModel um) {
		val fileName = "build.properties"

		// TODO: Protect
		val fileContent = '''
# Name of the application to build
projectname=pcm-generated-default-name

# Source Directory
src=src

# Class Directory
build=bin

# Directory in which the jar contents are collected
dist-dir=dist

# Path to a folder containing all additionally needed libs
lib-dir=libs

# Path to the SUN Appserver Bin Directory
sun-appserver-dir=C:/sun/sdk/bin

# Name of the Directory in which to place the final jars/ears
output=output
		'''

		fsa.generateFile(fileName, fileContent)
	}

	private def fileList(UsageModel um) {
		val fileName = "generated-filesets.xml"
		val fileContent = '''
<project name="generated-filesets">

	<fileset id="client-classes" dir="${dist-dir}">
		«FOR us : um.usageScenario_UsageModel»
		<include name="«us.basePackageName.fqnToDirectoryPath»/**/*.class" />
		«ENDFOR»
		<include name="*.class" />
		<include name="META-INF/application-client.xml" />
	</fileset>

	<fileset id="ejb-classes" dir="${dist-dir}">
		«val systems = um.usageScenario_UsageModel.map[scenarioBehaviour_UsageScenario.actions_ScenarioBehaviour].flatten.
			filter(typeof(EntryLevelSystemCall)).map[providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole].
			filter(typeof(System)).toSet»
		«FOR system : systems»«system.includeClasses»«ENDFOR»
		<include name="META-INF/ejb-jar.xml" />
	</fileset>

</project>	
		'''

		fsa.generateFile(fileName, fileContent)
	}

	private def applicationXML(UsageModel um) {
		val fileName = "META-INF/application.xml"

		// TODO: protect
		val fileContent = '''
<?xml version="1.0" encoding="UTF-8"?>
<application version="5" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/application_5.xsd">
  <display-name>@@projectname@@</display-name>
  <module>
    <java>@@projectname@@-client.jar</java>
  </module>
  <module>
    <ejb>@@projectname@@-ejb.jar</ejb>
  </module>
</application>
		'''

		fsa.generateFile(fileName, fileContent)
	}

	private def clientXML(UsageModel um) {
		val fileName = "META-INF/application-client.xml"

		// TODO: protect
		val fileContent = '''
<?xml version="1.0" encoding="UTF-8"?>
<application-client version="5" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/application-client_5.xsd">
    <display-name>@@projectname@@-Client</display-name>
    «val systemCalls = um.usageScenario_UsageModel.map[scenarioBehaviour_UsageScenario.actions_ScenarioBehaviour].
			flatten.filter(typeof(EntryLevelSystemCall)).map[providedRole_EntryLevelSystemCall].toSet»
    «FOR systemCall : systemCalls»«systemCall.ejbClientRef»«ENDFOR»
    .providedRole_EntryLevelSystemCall.toSet()»
</application-client>
		'''

		fsa.generateFile(fileName, fileContent)
	}

	def dispatch String includeClasses(Repository repository) '''
		<include name="«repository.javaName.toLowerCase.fqnToDirectoryPath»"/**/*.class" />
	'''

	def dispatch String includeClasses(System system) '''
		<include name="«system.javaName.toLowerCase.fqnToDirectoryPath»"/**/*.class" />
		«FOR repository : system.collectRepositories»«repository.includeClasses»«ENDFOR»
	'''

	def dispatch ejbClientRef(OperationProvidedRole role) '''
		<ejb-ref>
			<ejb-ref-name>ejb/«role.providedInterface__OperationProvidedRole.javaName»</ejb-ref-name>
			<ejb-ref-type>Session</ejb-ref-type> 
			<remote>«role.providedInterface__OperationProvidedRole.fqn»</remote>
			«val delegationConnector = (role.providingEntity_ProvidedRole as System).connectors__ComposedStructure.filter(
			typeof(ProvidedDelegationConnector)).filter[outerProvidedRole_ProvidedDelegationConnector == role].head»
			«val componentContext = delegationConnector.assemblyContext_ProvidedDelegationConnector»
			<ejb-link>«componentContext.encapsulatedComponent__AssemblyContext.javaName()»_«role.
			providedInterface__OperationProvidedRole.javaName»_«componentContext.id»</ejb-link> 
		</ejb-ref>
	'''

	def dispatch ejbClientRef(InfrastructureProvidedRole role) '''
		<ejb-ref>
			<ejb-ref-name>ejb/«role.providedInterface__InfrastructureProvidedRole.javaName»</ejb-ref-name>
			   <ejb-ref-type>Session</ejb-ref-type> 
			   <remote>«role.providedInterface__InfrastructureProvidedRole.fqn»</remote>
			   «val delegationConnector = (role.providingEntity_ProvidedRole as System).connectors__ComposedStructure.
			filter(typeof(ProvidedDelegationConnector)).filter[outerProvidedRole_ProvidedDelegationConnector == role].head»
			«val componentContext = delegationConnector.assemblyContext_ProvidedDelegationConnector»
			<ejb-link>«componentContext.encapsulatedComponent__AssemblyContext.javaName()»_«role.
			providedInterface__InfrastructureProvidedRole.javaName»_«componentContext.id»</ejb-link> 
		</ejb-ref>
	'''
}
