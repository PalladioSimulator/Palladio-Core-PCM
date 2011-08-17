/**
 *
 */
package de.fzi.se.validation.util;

import java.util.zip.Checksum;

import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;

/**Builds a checksum of an action within a RD-SEFF.
 * Structure and performance-relevant behavior change leads to a different checksum, name and ID changes don't.
 * @author groenda
 *
 */
public class ActionChecksumSwitch extends SeffSwitch<Long> {
	/** Checksum generator used to calculate the checksum. */
	private Checksum checksum;

	/**Initializes the checksum calculator switch.
	 * @param checksum Instance of the checksum generator.
	 */
	public ActionChecksumSwitch(Checksum checksum) {
		this.checksum = checksum;
	}

	@Override
	public Long caseAcquireAction(AcquireAction object) {
		ValidationUtilities.updateChecksum(checksum, "AcquireAction");
		ValidationUtilities.updateChecksum(checksum, object.getPassiveresource_AcquireAction().getId());
		for (ParametricResourceDemand prd : object.getResourceDemand_Action()) {
			// TODO implement
		}
		return checksum.getValue();
	}
	@Override
	public Long caseBranchAction(BranchAction object) {
		// TODO Auto-generated method stub
		return super.caseBranchAction(object);
	}
	@Override
	public Long caseCollectionIteratorAction(CollectionIteratorAction object) {
		// TODO Auto-generated method stub
		return super.caseCollectionIteratorAction(object);
	}
	@Override
	public Long caseExternalCallAction(ExternalCallAction object) {
		// TODO Auto-generated method stub
		return super.caseExternalCallAction(object);
	}
	@Override
	public Long caseForkAction(ForkAction object) {
		// TODO Auto-generated method stub
		return super.caseForkAction(object);
	}
	@Override
	public Long caseInternalAction(InternalAction object) {
		// TODO Auto-generated method stub
		return super.caseInternalAction(object);
	}
	@Override
	public Long caseLoopAction(LoopAction object) {
		// TODO Auto-generated method stub
		return super.caseLoopAction(object);
	}
	@Override
	public Long caseReleaseAction(ReleaseAction object) {
		// TODO Auto-generated method stub
		return super.caseReleaseAction(object);
	}
	@Override
	public Long caseSetVariableAction(SetVariableAction object) {
		// TODO Auto-generated method stub
		return super.caseSetVariableAction(object);
	}
	@Override
	public Long caseStopAction(StopAction object) {
		// TODO Auto-generated method stub
		return super.caseStopAction(object);
	}
}
