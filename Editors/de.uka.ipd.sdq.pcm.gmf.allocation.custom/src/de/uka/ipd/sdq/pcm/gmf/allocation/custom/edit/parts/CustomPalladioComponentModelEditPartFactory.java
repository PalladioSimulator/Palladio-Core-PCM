/*
 * Copyright 2007, SDQ, IPD, UKA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

/**
 * A custom Palladio Component model EditPart Factory.
 */
public class CustomPalladioComponentModelEditPartFactory implements EditPartFactory {

    /**
     * creates an EditPart.
     * 
     * @param context
     *            an EditPart
     * @param model
     *            an Object
     * @return an EditPart
     */
    public EditPart createEditPart(EditPart context, Object model) {
        if (model instanceof View) {
            View view = (View) model;
            switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {

            case AllocationEditPart.VISUAL_ID:
                return new AllocationEditPart(view);

            case ResourceContainerEditPart.VISUAL_ID:
                return new ResourceContainerEditPart(view);

            case ResourceContainerEntityNameEditPart.VISUAL_ID:
                return new ResourceContainerEntityNameEditPart(view);

            case AllocationContextEditPart.VISUAL_ID:
                return new AllocationContextEditPart(view);

            case AllocationContextEntityNameEditPart.VISUAL_ID:
                return new AllocationContextEntityNameEditPart(view);

            case CustomAllocationComponentLabelEditPart.VISUAL_ID:
                return new CustomAllocationComponentLabelEditPart(view); // use custom edit part

            case CustomResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
                return new CustomResourceContainerAllocationCompartmentEditPart(view); // use custom
                                                                                       // edit part
            default:
            }
        }
        return createUnrecognizedEditPart(context, model);
    }

    /**
     * Creates an unrecognized edit Part.
     * 
     * @param context
     *            an EditPart
     * @param model
     *            an Object
     * @return an EditPart
     */
    private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
        // Handle creation of unrecognized child node EditParts here
        return null;
    }

    /**
     * Gets the text CellEditorLocator.
     * 
     * @param source
     *            an ITextAwareEditPart
     * @return a CellEdotprLocator
     */
    public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
        if (source.getFigure() instanceof WrappingLabel) {
            return new TextCellEditorLocator((WrappingLabel) source.getFigure());
        } else {
            return new LabelCellEditorLocator((Label) source.getFigure());
        }
    }

    /**
     * A text CellEditorLocator.
     */
    private static class TextCellEditorLocator implements CellEditorLocator {

        /**
         * A wrapping label.
         */
        private WrappingLabel wrapLabel;

        /**
         * The constructor.
         * 
         * @param wrapLabel
         *            a WrappingLabel.
         */
        public TextCellEditorLocator(WrappingLabel wrapLabel) {
            this.wrapLabel = wrapLabel;
        }

        /**
         * Gets the wrap label.
         * 
         * @return a WrappingLabel.
         */
        public WrappingLabel getWrapLabel() {
            return wrapLabel;
        }

        /**
         * relocates the cell editor.
         * 
         * @param celleditor
         *            the CellEditor
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
     * A label cell Editor locator.
     */
    private static class LabelCellEditorLocator implements CellEditorLocator {

        /**
         * a label.
         */
        private Label label;

        /**
         * The constructor.
         * 
         * @param label
         *            a Label.
         */
        public LabelCellEditorLocator(Label label) {
            this.label = label;
        }

        /**
         * gets the label.
         * 
         * @return the label
         */
        public Label getLabel() {
            return label;
        }

        /**
         * Relocates the CellEditor.
         * 
         * @param celleditor
         *            a CellEditor
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
