package org.palladiosimulator.protocom.model.seff

import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.StartAction
import de.uka.ipd.sdq.pcm.seff.StopAction
import de.uka.ipd.sdq.pcm.seff.BranchAction
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.InternalAction

/**
 * @author Christian Klaussner
 */
class ActionAdapter<E extends AbstractAction> extends ModelAdapter<E> {
	new(E entity) {
		super(entity)
	}
	
	def getId() {
		entity.id
	}
	
	def getSuccessor() {
		val successor = entity.successor_AbstractAction
		
		switch successor {
			BranchAction: new BranchActionAdapter(successor)
			ExternalCallAction: new ExternalCallActionAdapter(successor)
			InternalAction: new InternalActionAdapter(successor)
			StartAction: new StartActionAdapter(successor)
			StopAction: new StopActionAdapter(successor)
			
			default: throw new RuntimeException("unknown action type")
		}
	}
	
	// Translation methods
	
	def getSafeId() {
		// TODO: Really necessary? IDs seem to be alphanumeric (+ underscore)...
	}
}
