package org.palladiosimulator.protocom.tech.iiop.repository

import de.uka.ipd.sdq.pcm.core.entity.Entity
import org.palladiosimulator.protocom.lang.java.IJeeGlassfishEjbDescriptor
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.ConceptMapping

class JavaEEIIOPGlassfishEjbDescriptor <E extends Entity> extends ConceptMapping<E> implements IJeeGlassfishEjbDescriptor {
	
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override ejbName() {
		JavaNames::javaName(pcmEntity)
	}
	
	override ejbRefName() {
		"Remote Required EJB Name"
	}
	
	override jndiName() {
		"Corba IP Bla Bla"
	}
	
	override filePath() {
		JavaNames::getFilePath(pcmEntity)+"/META-INF/glassfish-ejb-jar.xml"
	}
	
}