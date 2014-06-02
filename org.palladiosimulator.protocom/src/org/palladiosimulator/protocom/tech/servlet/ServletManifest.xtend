package org.palladiosimulator.protocom.tech.servlet

import org.palladiosimulator.protocom.lang.manifest.IJeeManifest
import org.palladiosimulator.protocom.tech.ConceptMapping
import de.uka.ipd.sdq.pcm.system.System;

/**
 * @author Christian Klaussner
 */
class ServletManifest extends ConceptMapping<System> implements IJeeManifest {
	
	new(System pcmEntity) {
		super(pcmEntity)
	}
	
	override classPath() {
		''
	}
	
	override manifestVersion() {
		'1.0'
	}
	
	override filePath() {
		'META-INF/MANIFEST.MF'
	}
	
	override projectName() {
	}
}