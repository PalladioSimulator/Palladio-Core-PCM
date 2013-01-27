/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

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

            case ComposedProvidingRequiringEntityEditPart.VISUAL_ID:
                return new ComposedProvidingRequiringEntityEditPart(view);

            case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
                return new ComposedProvidingRequiringEntity2EditPart(view);

            case ComposedProvidingRequiringEntityEntityNameEditPart.VISUAL_ID:
                return new ComposedProvidingRequiringEntityEntityNameEditPart(view);

            case AssemblyContextEditPart.VISUAL_ID:
                return new AssemblyContextEditPart(view);

            case AssemblyContextEntityNameEditPart.VISUAL_ID:
                return new AssemblyContextEntityNameEditPart(view);

            case OperationProvidedRoleEditPart.VISUAL_ID:
                return new OperationProvidedRoleEditPart(view);

            case OperationProvidedRoleEntityNameEditPart.VISUAL_ID:
                return new OperationProvidedRoleEntityNameEditPart(view);

            case OperationRequiredRoleEditPart.VISUAL_ID:
                return new OperationRequiredRoleEditPart(view);

            case OperationRequiredRoleEntityNameEditPart.VISUAL_ID:
                return new OperationRequiredRoleEntityNameEditPart(view);

            case SourceRoleEditPart.VISUAL_ID:
                return new SourceRoleEditPart(view);

            case SourceRoleEntityNameEditPart.VISUAL_ID:
                return new SourceRoleEntityNameEditPart(view);

            case SinkRoleEditPart.VISUAL_ID:
                return new SinkRoleEditPart(view);

            case SinkRoleEntityNameEditPart.VISUAL_ID:
                return new SinkRoleEntityNameEditPart(view);

            case InfrastructureProvidedRoleEditPart.VISUAL_ID:
                return new InfrastructureProvidedRoleEditPart(view);

            case InfrastructureProvidedRoleEntityNameEditPart.VISUAL_ID:
                return new InfrastructureProvidedRoleEntityNameEditPart(view);

            case InfrastructureRequiredRoleEditPart.VISUAL_ID:
                return new InfrastructureRequiredRoleEditPart(view);

            case InfrastructureRequiredRoleEntityNameEditPart.VISUAL_ID:
                return new InfrastructureRequiredRoleEntityNameEditPart(view);

            case OperationProvidedRole2EditPart.VISUAL_ID:
                return new OperationProvidedRole2EditPart(view);

            case OperationProvidedRoleEntityName2EditPart.VISUAL_ID:
                return new OperationProvidedRoleEntityName2EditPart(view);

            case OperationRequiredRole2EditPart.VISUAL_ID:
                return new OperationRequiredRole2EditPart(view);

            case OperationRequiredRoleEntityName2EditPart.VISUAL_ID:
                return new OperationRequiredRoleEntityName2EditPart(view);

            case EventChannelEditPart.VISUAL_ID:
                return new EventChannelEditPart(view);

            case EventChannelEntityNameEditPart.VISUAL_ID:
                return new EventChannelEntityNameEditPart(view);

            case ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.VISUAL_ID:
                return new ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart(view);

            case EventChannelSinkConnectorEditPart.VISUAL_ID:
                return new EventChannelSinkConnectorEditPart(view);

            case EventChannelSourceConnectorEditPart.VISUAL_ID:
                return new EventChannelSourceConnectorEditPart(view);

            case AssemblyConnectorEditPart.VISUAL_ID:
                return new AssemblyConnectorEditPart(view);

            case AssemblyEventConnectorEditPart.VISUAL_ID:
                return new AssemblyEventConnectorEditPart(view);

            case RequiredDelegationConnectorEditPart.VISUAL_ID:
                return new RequiredDelegationConnectorEditPart(view);

            case ProvidedDelegationConnectorEditPart.VISUAL_ID:
                return new ProvidedDelegationConnectorEditPart(view);

            case AssemblyInfrastructureConnectorEditPart.VISUAL_ID:
                return new AssemblyInfrastructureConnectorEditPart(view);

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
