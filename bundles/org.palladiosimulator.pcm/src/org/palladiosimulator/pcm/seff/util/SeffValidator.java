package org.palladiosimulator.pcm.seff.util;

import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.StopAction;


public class SeffValidator extends SeffValidatorGen{
	
	public static final SeffValidator INSTANCE = new SeffValidator();
	
	@Override
	public boolean validateResourceDemandingBehaviour_startActionNeedsRouteToStopAction(ResourceDemandingBehaviour resourceDemandingBehaviour, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		
		
		var listStartAction = resourceDemandingBehaviour.getSteps_Behaviour().stream().filter(StartAction.class::isInstance);
		
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
						 new Object[] { "startActionNeedsRouteToStopAction", getObjectLabel(resourceDemandingBehaviour, context) },
						 new Object[] { resourceDemandingBehaviour },
						 context));
			}
			return false;
		}
		return true;
	}
	
	private boolean findEndAction(AbstractAction action) {
		var seen = new HashSet<AbstractAction>();
		seen.add(action);
		var nextElement = action.getSuccessor_AbstractAction();
		while(nextElement != null && !(nextElement instanceof StopAction) && seen.contains(nextElement)) {
			nextElement = nextElement.getSuccessor_AbstractAction();
		}
		return nextElement instanceof StopAction;
	}

}
