package org.palladiosimulator.protocom.model.usage

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import org.palladiosimulator.protocom.model.repository.OperationProvidedRoleAdapter

/**
 * Adapter class for PCM EntryLevelSystemCall user actions.
 * @author Christian Klaussner
 */
class EntryLevelSystemCallAdapter extends UserActionAdapter<EntryLevelSystemCall> {
	new(EntryLevelSystemCall entity) {
		super(entity)
	}
	
	def getProvidedRole() {
		new OperationProvidedRoleAdapter(entity.providedRole_EntryLevelSystemCall)
	}
	
	def getOperationSignature() {
		// TODO
	}
}
