/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelEditPartFactory implements EditPartFactory {

    /**
     * @generated
     */
    public EditPart createEditPart(EditPart context, Object model) {
        if (model instanceof View) {
            View view = (View) model;
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

            case RepositoryEditPart.VISUAL_ID:
                return new RepositoryEditPart(view);

            case OperationInterfaceEditPart.VISUAL_ID:
                return new OperationInterfaceEditPart(view);

            case OperationInterfaceEntityNameEditPart.VISUAL_ID:
                return new OperationInterfaceEntityNameEditPart(view);

            case EventGroupEditPart.VISUAL_ID:
                return new EventGroupEditPart(view);

            case EventGroupEntityNameEditPart.VISUAL_ID:
                return new EventGroupEntityNameEditPart(view);

            case BasicComponentEditPart.VISUAL_ID:
                return new BasicComponentEditPart(view);

            case BasicComponentEntityNameEditPart.VISUAL_ID:
                return new BasicComponentEntityNameEditPart(view);

            case CompositeComponentEditPart.VISUAL_ID:
                return new CompositeComponentEditPart(view);

            case CompositeComponentEntityNameEditPart.VISUAL_ID:
                return new CompositeComponentEntityNameEditPart(view);

            case CompleteComponentTypeEditPart.VISUAL_ID:
                return new CompleteComponentTypeEditPart(view);

            case CompleteComponentTypeEntityNameEditPart.VISUAL_ID:
                return new CompleteComponentTypeEntityNameEditPart(view);

            case ProvidesComponentTypeEditPart.VISUAL_ID:
                return new ProvidesComponentTypeEditPart(view);

            case ProvidesComponentTypeEntityNameEditPart.VISUAL_ID:
                return new ProvidesComponentTypeEntityNameEditPart(view);

            case SubSystemEditPart.VISUAL_ID:
                return new SubSystemEditPart(view);

            case SubSystemEntityNameEditPart.VISUAL_ID:
                return new SubSystemEntityNameEditPart(view);

            case InfrastructureInterfaceEditPart.VISUAL_ID:
                return new InfrastructureInterfaceEditPart(view);

            case InfrastructureInterfaceEntityNameEditPart.VISUAL_ID:
                return new InfrastructureInterfaceEntityNameEditPart(view);

            case OperationSignatureEditPart.VISUAL_ID:
                return new OperationSignatureEditPart(view);

            case EventTypeEditPart.VISUAL_ID:
                return new EventTypeEditPart(view);

            case ResourceDemandingSEFFEditPart.VISUAL_ID:
                return new ResourceDemandingSEFFEditPart(view);

            case PassiveResourceEditPart.VISUAL_ID:
                return new PassiveResourceEditPart(view);

            case VariableUsageEditPart.VISUAL_ID:
                return new VariableUsageEditPart(view);

            case VariableUsageLabelEditPart.VISUAL_ID:
                return new VariableUsageLabelEditPart(view);

            case VariableCharacterisationEditPart.VISUAL_ID:
                return new VariableCharacterisationEditPart(view);

            case InfrastructureSignatureEditPart.VISUAL_ID:
                return new InfrastructureSignatureEditPart(view);

            case OperationInterfaceSignatureListEditPart.VISUAL_ID:
                return new OperationInterfaceSignatureListEditPart(view);

            case EventGroupEventTypeListEditPart.VISUAL_ID:
                return new EventGroupEventTypeListEditPart(view);

            case BasicComponentSEFFCompartmentEditPart.VISUAL_ID:
                return new BasicComponentSEFFCompartmentEditPart(view);

            case BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID:
                return new BasicComponentPassiveResourceCompartmentEditPart(view);

            case BasicComponentComponentParameterCompartmentEditPart.VISUAL_ID:
                return new BasicComponentComponentParameterCompartmentEditPart(view);

            case VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart.VISUAL_ID:
                return new VariableUsageComponentParameterVariableCharacterisationCompartmentEditPart(view);

            case InfrastructureInterfaceInfrastructureSignatureListEditPart.VISUAL_ID:
                return new InfrastructureInterfaceInfrastructureSignatureListEditPart(view);

            case OperationProvidedRoleEditPart.VISUAL_ID:
                return new OperationProvidedRoleEditPart(view);

            case OperationProvidedRoleLabelEditPart.VISUAL_ID:
                return new OperationProvidedRoleLabelEditPart(view);

            case InfrastructureProvidedRoleEditPart.VISUAL_ID:
                return new InfrastructureProvidedRoleEditPart(view);

            case WrappingLabelEditPart.VISUAL_ID:
                return new WrappingLabelEditPart(view);

            case InfrastructureRequiredRoleEditPart.VISUAL_ID:
                return new InfrastructureRequiredRoleEditPart(view);

            case WrappingLabel2EditPart.VISUAL_ID:
                return new WrappingLabel2EditPart(view);

            case SinkRoleEditPart.VISUAL_ID:
                return new SinkRoleEditPart(view);

            case SinkRoleLabelEditPart.VISUAL_ID:
                return new SinkRoleLabelEditPart(view);

            case OperationRequiredRoleEditPart.VISUAL_ID:
                return new OperationRequiredRoleEditPart(view);

            case OperationRequiredRoleLabelEditPart.VISUAL_ID:
                return new OperationRequiredRoleLabelEditPart(view);

            case ImplementationComponentTypeParentCompleteComponentTypesEditPart.VISUAL_ID:
                return new ImplementationComponentTypeParentCompleteComponentTypesEditPart(view);

            case ImplementationComponentTypeParentCompleteTypesLabelEditPart.VISUAL_ID:
                return new ImplementationComponentTypeParentCompleteTypesLabelEditPart(view);

            case CompleteComponentTypeParentProvidesComponentTypesEditPart.VISUAL_ID:
                return new CompleteComponentTypeParentProvidesComponentTypesEditPart(view);

            case CompleteComponentTypeParentProvidesComponentTypesLabelEditPart.VISUAL_ID:
                return new CompleteComponentTypeParentProvidesComponentTypesLabelEditPart(view);

            case SourceRoleEditPart.VISUAL_ID:
                return new SourceRoleEditPart(view);

            case SourceRoleLabelEditPart.VISUAL_ID:
                return new SourceRoleLabelEditPart(view);

            }
        }
        return createUnrecognizedEditPart(context, model);
    }

    /**
     * @generated
     */
    private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
        // Handle creation of unrecognized child node EditParts here
        return null;
    }

    /**
     * @generated
     */
    public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
        if (source.getFigure() instanceof WrappingLabel)
            return new TextCellEditorLocator((WrappingLabel) source.getFigure());
        else {
            return new LabelCellEditorLocator((Label) source.getFigure());
        }
    }

    /**
     * @generated
     */
    static private class TextCellEditorLocator implements CellEditorLocator {

        /**
         * @generated
         */
        private WrappingLabel wrapLabel;

        /**
         * @generated
         */
        public TextCellEditorLocator(WrappingLabel wrapLabel) {
            this.wrapLabel = wrapLabel;
        }

        /**
         * @generated
         */
        public WrappingLabel getWrapLabel() {
            return wrapLabel;
        }

        /**
         * @generated
         */
        public void relocate(CellEditor celleditor) {
            Text text = (Text) celleditor.getControl();
            Rectangle rect = getWrapLabel().getTextBounds().getCopy();
            getWrapLabel().translateToAbsolute(rect);
            if (getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
                rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
            } else {
                int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
                rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
            }
            if (!rect.equals(new Rectangle(text.getBounds()))) {
                text.setBounds(rect.x, rect.y, rect.width, rect.height);
            }
        }

    }

    /**
     * @generated
     */
    private static class LabelCellEditorLocator implements CellEditorLocator {

        /**
         * @generated
         */
        private Label label;

        /**
         * @generated
         */
        public LabelCellEditorLocator(Label label) {
            this.label = label;
        }

        /**
         * @generated
         */
        public Label getLabel() {
            return label;
        }

        /**
         * @generated
         */
        public void relocate(CellEditor celleditor) {
            Text text = (Text) celleditor.getControl();
            Rectangle rect = getLabel().getTextBounds().getCopy();
            getLabel().translateToAbsolute(rect);
            int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
            rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
            if (!rect.equals(new Rectangle(text.getBounds()))) {
                text.setBounds(rect.x, rect.y, rect.width, rect.height);
            }
        }
    }
}
