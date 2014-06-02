package org.palladiosimulator.protocom.tech.servlet.repository

import org.palladiosimulator.protocom.tech.servlet.ServletInterface
import de.uka.ipd.sdq.pcm.repository.OperationInterface

class ServletOperationInterface extends ServletInterface<OperationInterface> {
	new(OperationInterface pcmEntity) {
		super(pcmEntity)
	}
}
