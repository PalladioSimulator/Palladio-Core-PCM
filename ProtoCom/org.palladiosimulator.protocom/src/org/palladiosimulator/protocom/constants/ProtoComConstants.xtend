package org.palladiosimulator.protocom.constants

import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.launching.JavaRuntime
import org.eclipse.jem.workbench.utility.IJavaEMFNature
import org.eclipse.pde.internal.core.natures.PDE
import org.eclipse.wst.common.componentcore.internal.util.IModuleConstants
import org.eclipse.pde.internal.core.PDECore
import org.eclipse.core.runtime.IPath

interface ProtoComConstants {	
	val String JAVA_NATURE = JavaCore.NATURE_ID
	val String JAVA_BUILDER = JavaCore.BUILDER_ID
	val IClasspathEntry JAVA_CLASSPATH_ENTRY_JRE = JavaRuntime.getDefaultJREContainerEntry()
	
	val String JAVA_EMF_NATURE = IJavaEMFNature.NATURE_ID
	
	val String PLUGIN_NATURE = PDE.PLUGIN_NATURE
	val IPath PLUGIN_CONTAINER_PATH = PDECore.REQUIRED_PLUGINS_CONTAINER_PATH
	
	val String WST_MODULCORE_NATURE = IModuleConstants.MODULE_NATURE_ID
	val String WST_FACET_CORE_NATURE = "org.eclipse.wst.common.project.facet.core.nature"
	val String WST_FACET_CORE_BUILDER = "org.eclipse.wst.common.project.facet.core.builder"
	val String WST_VALIDATION_BUILDER = "org.eclipse.wst.validation.validationbuilder"

	val String[] JAVA_SE_NATURE = #[JAVA_NATURE, PLUGIN_NATURE]
	val String[] JAVA_SE_BUILDERS = #[JAVA_BUILDER]
	val String JAVA_SE_SOURCE_LOCATION = "src"
	val String JAVA_SE_OUTPUT_LOCATION = "bin" 
	
	val String[] JAVA_EE_NATURE = #[JAVA_NATURE, JAVA_EMF_NATURE, WST_MODULCORE_NATURE, WST_FACET_CORE_NATURE]
	val String[] JAVA_EE_BUILDERS = #[JAVA_BUILDER, WST_FACET_CORE_BUILDER, WST_VALIDATION_BUILDER]
}