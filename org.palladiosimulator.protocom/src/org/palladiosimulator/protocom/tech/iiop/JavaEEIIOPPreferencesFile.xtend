package org.palladiosimulator.protocom.tech.iiop

import de.uka.ipd.sdq.pcm.core.entity.Entity
import org.palladiosimulator.protocom.lang.prefs.IJeePreferences
import org.palladiosimulator.protocom.tech.ConceptMapping

class JavaEEIIOPPreferencesFile <E extends Entity> extends ConceptMapping<E> implements IJeePreferences {
	
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override eclipsePreferencesVersion() {
	}
	
	override codegenInlineJsrBytecode() {
	}
	
	override codegenTargetPlatform() {
	}
	
	override compliance() {
	}
	
	override problemAssertIdentifier() {
	}
	
	override problemEnumIdentifier() {
	}
	
	override source() {
	}
	
	override filePath() {
	}
	
	override projectName() {
	}
	
}