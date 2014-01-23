package org.palladiosimulator.protocom.tech.iiop.repository

import de.uka.ipd.sdq.pcm.core.entity.Entity
import org.palladiosimulator.protocom.lang.java.IJeeEjbDescriptor
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.ConceptMapping

class JavaEEIIOPEjbDescriptor <E extends Entity> extends ConceptMapping<E> implements IJeeEjbDescriptor{
	
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override displayName() {
		JavaNames::implementationPackage(pcmEntity)
	}
	
	override ejbClientJar() {
		JavaNames::implementationPackage(pcmEntity)
	}
	
	override filePath() {
		JavaNames::getFilePath(pcmEntity)+"/META-INF/ejb-jar.xml"
	}
	
}