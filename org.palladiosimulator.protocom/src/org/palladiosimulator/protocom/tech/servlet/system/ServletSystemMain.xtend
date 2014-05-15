package org.palladiosimulator.protocom.tech.servlet.system

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario

// TODO: Why is this class in the system package, not in usage?
class ServletSystemMain extends ServletClass<UsageScenario> {
	new(UsageScenario pcmEntity) {
		super(pcmEntity)
	}	
}
