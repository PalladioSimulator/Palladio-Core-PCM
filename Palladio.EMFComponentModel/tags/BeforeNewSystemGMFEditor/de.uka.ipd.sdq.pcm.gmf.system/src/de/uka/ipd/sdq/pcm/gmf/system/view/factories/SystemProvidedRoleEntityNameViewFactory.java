/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.diagram.ui.util.MeasurementUnitHelper;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

import org.eclipse.gmf.runtime.notation.Location;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;

/**
 * @generated
 */
public class SystemProvidedRoleEntityNameViewFactory extends
		AbstractLabelViewFactory {

	/**
	 * @generated
	 */
	public View createView(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node view = (Node) super.createView(semanticAdapter, containerView,
				semanticHint, index, persisted, preferencesHint);
		Location location = (Location) view.getLayoutConstraint();
		IMapMode mapMode = MeasurementUnitHelper.getMapMode(containerView
				.getDiagram().getMeasurementUnit());
		location.setX(mapMode.DPtoLP(0));
		location.setY(mapMode.DPtoLP(5));
		return view;
	}

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		return styles;
	}
}
