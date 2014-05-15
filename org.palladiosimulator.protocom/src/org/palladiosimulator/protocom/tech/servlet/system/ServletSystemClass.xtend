package org.palladiosimulator.protocom.tech.servlet.system

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity
import org.palladiosimulator.protocom.tech.servlet.ServletClass
import org.palladiosimulator.protocom.lang.java.IJClass

class ServletSystemClass<E extends ComposedProvidingRequiringEntity> extends ServletClass<E> implements IJClass {
	new(E pcmEntity) {
		super(pcmEntity)
	}
}