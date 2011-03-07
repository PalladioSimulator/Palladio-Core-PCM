package de.uka.ipd.sdq.probespec.framework.test.mockup;

import de.uka.ipd.sdq.probespec.framework.BlackboardVote;
import de.uka.ipd.sdq.probespec.framework.IBlackboardListener;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;

public class BlackboardListenerMockup implements IBlackboardListener {

	private BlackboardVote deletionVote;

	public BlackboardListenerMockup(BlackboardVote deletionVote) {
		this.deletionVote = deletionVote;
	}

	@Override
	public BlackboardVote sampleArrived(ProbeSetSample pss) {
		return deletionVote;
	}

}
