package org.palladiosimulator.pcm.usagemodel.util;

import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.Stop;

public class UsagemodelValidator extends UsagemodelValidatorGen {

	@Override
	public boolean validateScenarioBehaviour_routeFromStartToStopAction(ScenarioBehaviour scenarioBehaviour, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		var listStartAction = scenarioBehaviour.getActions_ScenarioBehaviour().stream().filter(Start.class::isInstance);
		
		var routesFound = listStartAction.allMatch(this::findEndAction);
		
		if (!routesFound)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "routeFromStartToStopAction", getObjectLabel(scenarioBehaviour, context) },
						 new Object[] { scenarioBehaviour },
						 context));
			}
			return false;
		}
		return true;
	}

	private boolean findEndAction(AbstractUserAction action) {
		var seen = new HashSet<AbstractUserAction>();
		seen.add(action);
		var nextElement = action.getSuccessor();
		while (nextElement != null && !(nextElement instanceof Stop) && !seen.contains(nextElement)) {
			seen.add(nextElement);
			nextElement = nextElement.getSuccessor();		
		}
		return nextElement instanceof Stop;
	}

}
