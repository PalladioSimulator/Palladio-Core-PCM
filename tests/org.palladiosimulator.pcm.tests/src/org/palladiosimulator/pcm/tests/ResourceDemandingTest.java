package org.palladiosimulator.pcm.tests;

import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.seff.SeffFactory;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

public class ResourceDemandingTest extends ConstraintTestBase{
	
	@Test
	void noStop() {
		var behaviour = SeffFactory.eINSTANCE.createResourceDemandingBehaviour();
		var start = SeffFactory.eINSTANCE.createStartAction();
		var internalAction = SeffFactory.eINSTANCE.createInternalAction();

		start.setSuccessor_AbstractAction(internalAction);
		
		behaviour.getSteps_Behaviour().add(start);
		behaviour.getSteps_Behaviour().add(internalAction);
		
		assertViolation(behaviour, "startActionNeedsRouteToStopAction");
	}

	@Test
	void WithStop() {
		var behaviour = SeffFactory.eINSTANCE.createResourceDemandingBehaviour();
		var start = SeffFactory.eINSTANCE.createStartAction();
		var stop = SeffFactory.eINSTANCE.createStopAction();
		
		start.setSuccessor_AbstractAction(stop);
		
		behaviour.getSteps_Behaviour().add(start);
		behaviour.getSteps_Behaviour().add(stop);

		assertNoViolation(behaviour, "startActionNeedsRouteToStopAction");
	}

}
