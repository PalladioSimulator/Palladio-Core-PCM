package org.palladiosimulator.protocom.tech.servlet.repository

import org.palladiosimulator.protocom.tech.servlet.ServletInterface
import de.uka.ipd.sdq.pcm.repository.OperationInterface
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.impl.JMethod

class ServletOperationInterface extends ServletInterface<OperationInterface> {
	new(OperationInterface pcmEntity) {
		super(pcmEntity)
	}
	
	override methods() {
		pcmEntity.signatures__OperationInterface.map[
			new JMethod()
				.withName(JavaNames::javaSignature(it))
				.withReturnType('''«frameworkBase».stubs.SimulatedStackframe<Object>''')
				.withParameters('''«frameworkBase».stubs.StackContext ctx''')
		]
	}
}
