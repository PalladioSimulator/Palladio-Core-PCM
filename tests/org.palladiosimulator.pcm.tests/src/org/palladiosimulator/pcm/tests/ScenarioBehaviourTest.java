package org.palladiosimulator.pcm.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;

public class ScenarioBehaviourTest{
	
	@Test
	void noStop() {
		var scenario = UsagemodelFactory.eINSTANCE.createScenarioBehaviour();
		var start = UsagemodelFactory.eINSTANCE.createStart();
		var middle = UsagemodelFactory.eINSTANCE.createEntryLevelSystemCall();
		
		start.setSuccessor(middle);
		
		scenario.getActions_ScenarioBehaviour().add(start);
		scenario.getActions_ScenarioBehaviour().add(middle);
		
		var diagnostic = Diagnostician.INSTANCE.validate(scenario);
		
		assertTrue(diagnostic.getChildren().stream().anyMatch(this::checkForConstraint));
		
	}
	
	@Test
	void WithStop() {
		var scenario = UsagemodelFactory.eINSTANCE.createScenarioBehaviour();
		var start = UsagemodelFactory.eINSTANCE.createStart();
		var stop = UsagemodelFactory.eINSTANCE.createStop();
		
		start.setSuccessor(stop);
		
		scenario.getActions_ScenarioBehaviour().add(start);
		scenario.getActions_ScenarioBehaviour().add(stop);
		
		var diagnostic = Diagnostician.INSTANCE.validate(scenario);
		
		assertFalse(diagnostic.getChildren().stream().anyMatch(this::checkForConstraint));
		
	}
	
	private boolean checkForConstraint(Diagnostic diagnostic) {
		return diagnostic.getMessage().contains("The 'routeFromStartToStopAction' constraint is violated on");
	}

}
