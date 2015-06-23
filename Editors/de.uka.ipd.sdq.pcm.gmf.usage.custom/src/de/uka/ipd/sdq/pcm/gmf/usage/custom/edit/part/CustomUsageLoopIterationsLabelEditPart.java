/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart;
import org.palladiosimulator.pcm.usagemodel.Loop;

/**
 * The Class CustomUsageLoopIterationsLabelEditPart.
 */
public class CustomUsageLoopIterationsLabelEditPart extends UsageLoopIterationsLabelEditPart {

    /** The change listener. */
    private EContentAdapter changeListener = null;

    /** The adapted element. */
    private EObject adaptedElement = null;

    /**
     * Instantiates a new custom usage loop iterations label edit part.
     * 
     * @param view
     *            the view
     */
    public CustomUsageLoopIterationsLabelEditPart(View view) {
        super(view);
    }

    /**
     * Gets the label text.
     * 
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        EObject object = resolveSemanticElement();
        if (object instanceof Loop) {
            Loop loop = (Loop) object;
            // Loop loop = (Loop) resolveSemanticElement();
            if (loop.getLoopIteration_Loop() != null) {
                text = "Iterations: " + loop.getLoopIteration_Loop().getSpecification();
            }
            if (text == null || text.length() == 0) {
                text = getLabelTextHelper(getFigure());
            }
        }

        return text;
    }

    /**
     * Adds the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        EObject element = resolveSemanticElement();
        changeListener = new EContentAdapter() {

            @Override
            public void notifyChanged(Notification notification) {
                super.notifyChanged(notification);
                CustomUsageLoopIterationsLabelEditPart.this.notifyChanged(notification);
            }

        };
        adaptedElement = element;
        element.eAdapters().add(changeListener);
        addListenerFilter("SemanticModel", this, element); //$NON-NLS-1$
    }

    /**
     * Removes the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart#removeSemanticListeners()
     */
    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter("SemanticModel"); //$NON-NLS-1$
        adaptedElement.eAdapters().remove(changeListener);
    }

    /**
     * Handle notification event.
     * 
     * @param event
     *            the event
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void handleNotificationEvent(final Notification event) {
        Object feature = event.getFeature();
        if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
            Integer c = (Integer) event.getNewValue();
            setFontColor(DiagramColorRegistry.getInstance().getColor(c));
        } else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
            refreshUnderline();
        } else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
            refreshStrikeThrough();
        } else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
            refreshFont();
        } else {
            refreshLabel();
        }
        super.handleNotificationEvent(event);
    }
}
