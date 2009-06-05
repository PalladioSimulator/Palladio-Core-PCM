/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.notation.View;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;

import org.eclipse.gmf.runtime.notation.NotationFactory;

/**
 * @generated
 */
public class UsageBranchStereotypeLabelViewFactory extends BasicNodeViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createDescriptionStyle());
		return styles;
	}
}
