package org.palladiosimulator.protocom.model.usage

import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
import de.uka.ipd.sdq.pcm.usagemodel.Branch
import de.uka.ipd.sdq.pcm.usagemodel.Delay
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.Loop
import de.uka.ipd.sdq.pcm.usagemodel.Start
import de.uka.ipd.sdq.pcm.usagemodel.Stop

/**
 * Abstract base class for PCM user actions.
 * @author Christian Klaussner
 */
class UserActionAdapter<E extends AbstractUserAction> extends ModelAdapter<E> {
	new(E entity) {
		super(entity)
	}
	
	/**
	 * Gets the successor action.
	 * @return an adapter for the successor action
	 */
	def getSuccessor() {
		val successor = entity.successor
		
		switch successor {
			Branch: new BranchAdapter(successor)
			Delay: new DelayAdapter(successor)
			EntryLevelSystemCall: new EntryLevelSystemCallAdapter(successor)
			Loop: new LoopAdapter(successor)
			Start: new StartAdapter(successor)
			Stop: new StopAdapter(successor)
			
			default: throw new RuntimeException("unknown action type")
		}
	}
}
