/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.util.MeasurementUnitHelper;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * A factory for creating ProvidedRoleEntityName2View objects.
 *
 * @generated
 */
public class ProvidedRoleEntityName2ViewFactory extends AbstractLabelViewFactory {

    /**
     * Creates a new ProvidedRoleEntityName2View object.
     *
     * @param semanticAdapter the semantic adapter
     * @param containerView the container view
     * @param semanticHint the semantic hint
     * @param index the index
     * @param persisted the persisted
     * @param preferencesHint the preferences hint
     * @return the view
     * @generated
     */
    public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
            boolean persisted, PreferencesHint preferencesHint) {
        Node view = (Node) super.createView(semanticAdapter, containerView, semanticHint, index, persisted,
                preferencesHint);
        Location location = (Location) view.getLayoutConstraint();
        IMapMode mapMode = MeasurementUnitHelper.getMapMode(containerView.getDiagram().getMeasurementUnit());
        location.setX(mapMode.DPtoLP(0));
        location.setY(mapMode.DPtoLP(5));
        return view;
    }

    /**
     * Creates a new ProvidedRoleEntityName2View object.
     *
     * @param view the view
     * @return the list
     * @generated
     */
    protected List createStyles(View view) {
        List styles = new ArrayList();
        return styles;
    }
}
