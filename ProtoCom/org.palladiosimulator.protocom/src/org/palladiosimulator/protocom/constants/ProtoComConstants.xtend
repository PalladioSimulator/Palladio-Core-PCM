package org.palladiosimulator.protocom.constants

import org.eclipse.pde.internal.core.natures.PDE
import org.eclipse.jdt.core.JavaCore

interface ProtoComConstants {
	final public String JAVA_BUILDER = JavaCore.BUILDER_ID;
	
	final public String[] JAVA_SE_NATURE = #[JavaCore.NATURE_ID, PDE.PLUGIN_NATURE];
	final public String[] JAVA_SE_BUILDERS = #[JAVA_BUILDER];
	
	final public String[] JAVA_EE_NATURE = #["org.eclipse.jem.workbench.JavaEMFNature","org.eclipse.wst.common.modulecore.ModuleCoreNature","org.eclipse.wst.common.project.facet.core.nature","org.eclipse.jdt.core.javanature"];
	final public String[] JAVA_EE_BUILDERS = #[JAVA_BUILDER, "org.eclipse.wst.common.project.facet.core.builder", "org.eclipse.wst.validation.validationbuilder"];
}