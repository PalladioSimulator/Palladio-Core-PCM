/**
 * Copyright 2005-2017 by palladiosimulator.org
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.Start;
import org.palladiosimulator.pcm.usagemodel.Stop;
import org.palladiosimulator.pcm.usagemodel.util.UsagemodelValidator;

public class ScenarioBehaviourImpl extends ScenarioBehaviourImplGen {
	@Override
	public boolean routeFromStartToStopAction(DiagnosticChain diagnostics, Map<Object, Object> context) {
		var listStartAction = this.getActions_ScenarioBehaviour().stream().filter(Start.class::isInstance);

		var routesFound = listStartAction.allMatch(this::findEndAction);

		if (!routesFound) {
			if (diagnostics != null) {
				var defaultMessage = EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
						new Object[] { "routeFromStartToStopAction", this.getId() });
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
						UsagemodelValidator.SCENARIO_BEHAVIOUR__ROUTE_FROM_START_TO_STOP_ACTION, defaultMessage,
						new Object[] { this }));

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
