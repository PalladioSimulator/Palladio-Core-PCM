/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;

import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ResourceDemandingSEFFViewFactory extends DiagramViewFactory {

	/**
	 * @generated 
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createPageStyle());
		styles.add(NotationFactory.eINSTANCE.createGuideStyle());
		styles.add(NotationFactory.eINSTANCE.createDescriptionStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View view, IAdaptable semanticAdapter,
			String diagramKind) {
		super.decorateView(view, semanticAdapter, diagramKind);
	}

	/**
	 * @generated
	 */
	protected MeasurementUnit getMeasurementUnit() {
		return MeasurementUnit.PIXEL_LITERAL;
	}

}
