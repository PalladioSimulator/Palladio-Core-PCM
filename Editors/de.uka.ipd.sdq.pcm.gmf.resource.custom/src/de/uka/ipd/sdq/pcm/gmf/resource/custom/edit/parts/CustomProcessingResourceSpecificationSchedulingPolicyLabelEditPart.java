package de.uka.ipd.sdq.pcm.gmf.resource.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationSchedulingPolicyLabelEditPart;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

// TODO: Auto-generated Javadoc
/**
 * An edit part.
 */
public class CustomProcessingResourceSpecificationSchedulingPolicyLabelEditPart extends
        ProcessingResourceSpecificationSchedulingPolicyLabelEditPart {

    /**
     * Instantiates a new custom processing resource specification scheduling policy label edit
     * part.
     * 
     * @param view
     *            a View
     */
    public CustomProcessingResourceSpecificationSchedulingPolicyLabelEditPart(View view) {
        super(view);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationSchedulingPolicyLabelEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;

        ProcessingResourceSpecification spec = (ProcessingResourceSpecification) resolveSemanticElement();
        if (spec.getSchedulingPolicy() != null) {
            text = spec.getSchedulingPolicy().getEntityName();
        }
        if (text == null || text.length() == 0) {
            text = "NotDefined";
        }
        return "Scheduling: " + text; // custom code

    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationSchedulingPolicyLabelEditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        ProcessingResourceSpecification spec = (ProcessingResourceSpecification) resolveSemanticElement();
        addListenerFilter("SemanticModel", this, spec); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationSchedulingPolicyLabelEditPart#removeSemanticListeners()
     */
    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter("SemanticModel"); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationSchedulingPolicyLabelEditPart
     * #handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void handleNotificationEvent(Notification event) {
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
