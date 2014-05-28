package org.palladiosimulator.protocom.tech.iiop.system

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import java.util.List
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPClasspathFile

class JavaEEIIOPClasspath extends JavaEEIIOPClasspathFile<BasicComponent> {

	List<AssemblyConnector> assemblyConnector

	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}

	new(BasicComponent pcmEntity, List<AssemblyConnector> assemblyConnectorList) {
		super(pcmEntity)
		this.assemblyConnector = assemblyConnectorList
	}

	override classPathEntries() {
		'''
			<classpathentry kind="src" path="ejbModule"/>
			<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7">
				<attributes>
					<attribute name="owner.project.facets" value="java"/>
				</attributes>
			</classpathentry>
			<classpathentry kind="con" path="oracle.eclipse.tools.glassfish.lib.system">
				<attributes>
					<attribute name="owner.project.facets" value="jst.ejb"/>
				</attributes>
			</classpathentry>
			<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.module.container"/>
			<classpathentry kind="var" path="ECLIPSE_HOME/plugins/de.uka.ipd.sdq.simucomframework.variables_1.0.0.201401301023.jar"/>
			<classpathentry kind="var" path="ECLIPSE_HOME/plugins/org.palladiosimulator.protocom.framework_1.0.0.201401301023.jar"/>
			<classpathentry kind="var" path="ECLIPSE_HOME/plugins/org.palladiosimulator.protocom.resourcestrategies_1.0.0.201401301023.jar"/>
			'''
	}

	override filePath() {
		".classpath"
	}

	override projectName() {
		JavaNames::fqnJavaEEDescriptorProjectName(pcmEntity)
	}

	override clientClassPathEntry() {
		JavaNames::fqnJavaEEClientDeployName(pcmEntity)
	}

	override requiredClientProjects() {
		val basicComponentAssemblyConnectors = assemblyConnector.filter[
			it.requiredRole_AssemblyConnector.requiringEntity_RequiredRole.equals(pcmEntity)]
		val results = newLinkedList

		for (assemblyConnector : basicComponentAssemblyConnectors) {
			var assemblyProvidedRole = assemblyConnector.providedRole_AssemblyConnector
			results += #[
				JavaNames::fqnJavaEEClientDeployName(assemblyProvidedRole.providingEntity_ProvidedRole)
			]
		}

		return results
	}
}
