package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;

import org.palladiosimulator.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationComponentLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes;

/**
 * a custom Allocation Component Label EditPart.
 */
public class CustomAllocationComponentLabelEditPart extends AllocationComponentLabelEditPart {

    /**
     * The default text.
     */
    private String defaultText;

    /**
     * The constructor.
     * 
     * @param view
     *            a View
     */
    public CustomAllocationComponentLabelEditPart(View view) {
        super(view);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Image getLabelIcon() {
        EObject parserElement = getParserElement();
        if (parserElement == null) {
            return null;
        }
        AllocationContext ctx = (AllocationContext) resolveSemanticElement();
        if (ctx.getAssemblyContext_AllocationContext() != null) {
            if (ctx.getAssemblyContext_AllocationContext().getEncapsulatedComponent__AssemblyContext() != null) {
                return PalladioComponentModelElementTypes.getImage(ctx.getAssemblyContext_AllocationContext()
                        .getEncapsulatedComponent__AssemblyContext().eClass());
            }
        }
        if (ctx.getEventChannel__AllocationContext() != null) {
            return PalladioComponentModelElementTypes.getImage(ctx.getEventChannel__AllocationContext().eClass());
        }
        return PalladioComponentModelElementTypes.getImage(parserElement.eClass());
    }

    @Override
    protected String getLabelText() {
        String text = "";
        AllocationContext ctx = (AllocationContext) resolveSemanticElement();
        if (ctx.getAssemblyContext_AllocationContext() != null) {
            text += "<" + ctx.getAssemblyContext_AllocationContext().getEntityName() + ">";
            if (ctx.getAssemblyContext_AllocationContext().getEncapsulatedComponent__AssemblyContext() != null) {
                text = ctx.getAssemblyContext_AllocationContext().getEncapsulatedComponent__AssemblyContext()
                        .getEntityName()
                        + " " + text;
            }
        }
        if (ctx.getEventChannel__AllocationContext() != null) {
            text += "<" + ctx.getEventChannel__AllocationContext().getEntityName() + ">";
        }
        if (text == null || text.length() == 0) {
            text = defaultText;
        }
        return text;
    }

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
