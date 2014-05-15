package org.palladiosimulator.protocom.tech.servlet.repository

import org.palladiosimulator.protocom.tech.servlet.ServletInterface
import de.uka.ipd.sdq.pcm.repository.BasicComponent

class ServletComponentClassInterface extends ServletInterface<BasicComponent> {
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
}
