/**
 * Copyright 2005-2017 by palladiosimulator.org
 */
package org.palladiosimulator.pcm.seff.impl;

import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.StopAction;
import org.palladiosimulator.pcm.seff.util.SeffValidator;

public class ResourceDemandingBehaviourImpl extends ResourceDemandingBehaviourImplGen {

	@Override
	public boolean startActionNeedsRouteToStopAction(DiagnosticChain diagnostics, Map<Object, Object> context) {

		var listStartAction = this.getSteps_Behaviour().stream().filter(StartAction.class::isInstance);

		var routesFound = listStartAction.allMatch(this::findEndAction);
		if (!routesFound) {
			if (diagnostics != null) {
				var defaultMessage = EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
						"startActionNeedsRouteToStopAction", this.getId() });
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SeffValidator.DIAGNOSTIC_SOURCE,
						SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__START_ACTION_NEEDS_ROUTE_TO_STOP_ACTION,
						defaultMessage, new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	private boolean findEndAction(AbstractAction action) {
		var seen = new HashSet<AbstractAction>();
		seen.add(action);
		var nextElement = action.getSuccessor_AbstractAction();
		while (nextElement != null && !(nextElement instanceof StopAction) && !seen.contains(nextElement)) {
			seen.add(nextElement);
			nextElement = nextElement.getSuccessor_AbstractAction();
		}
		return nextElement instanceof StopAction;
	}

}
