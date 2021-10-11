package org.palladiosimulator.pcm.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.seff.SeffFactory;

public class ResourceDemandingTest {
	
	@Test
	void noStop() {
		var behaviour = SeffFactory.eINSTANCE.createResourceDemandingBehaviour();
		var start = SeffFactory.eINSTANCE.createStartAction();
		var internalAction = SeffFactory.eINSTANCE.createInternalAction();
		
		start.setSuccessor_AbstractAction(internalAction);
		
		behaviour.getSteps_Behaviour().add(start);
		behaviour.getSteps_Behaviour().add(internalAction);
		
		var diagnostic = Diagnostician.INSTANCE.validate(behaviour);
		assertTrue(diagnostic.getChildren().stream().anyMatch(this::checkForConstraint));
		
	}
	@Test
	void WithStop() {
		var behaviour = SeffFactory.eINSTANCE.createResourceDemandingBehaviour();
		var start = SeffFactory.eINSTANCE.createStartAction();
		var stop = SeffFactory.eINSTANCE.createStopAction();
		
		start.setSuccessor_AbstractAction(stop);
		
		behaviour.getSteps_Behaviour().add(start);
		behaviour.getSteps_Behaviour().add(stop);
		
		var diagnostic = Diagnostician.INSTANCE.validate(behaviour);
		assertFalse(diagnostic.getChildren().stream().anyMatch(this::checkForConstraint));
		
	}
	
	
	
	private boolean checkForConstraint(Diagnostic diagnostic) {
		return diagnostic.getMessage().contains("The 'startActionNeedsRouteToStopAction' constraint is violated on");
	}

}
