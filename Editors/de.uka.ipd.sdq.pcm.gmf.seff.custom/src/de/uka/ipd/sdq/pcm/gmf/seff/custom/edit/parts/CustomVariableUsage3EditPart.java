/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

/**
 * The customized variable usage3 edit part class.
 */
public class CustomVariableUsage3EditPart extends VariableUsage3EditPart {

    /** The Constant THIS_BACK. */
    static final Color THIS_BACK = new Color(null, 220, 220, 220);

    /**
     * Instantiates a new customized variable usage3 edit part.
     * 
     * @param view
     *            the view
     */
    public CustomVariableUsage3EditPart(final View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart#createNodeShape()
     */
    /**
     * Creates the node shape.
     *
     * @return the i figure
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart#createNodeShape()
     */
    @Override
    protected IFigure createNodeShape() {
        final ParametricParameterUsageFigure figure = new CustomParametricParameterUsageFigure();
        this.primaryShape = figure;
        return figure;
    }

    /**
     * The customized parametric parameter usage figure class.
     */
    public class CustomParametricParameterUsageFigure extends ParametricParameterUsageFigure {

        /**
         * Constructor.
         */
        public CustomParametricParameterUsageFigure() {

            super();
            // Clear super layout
            this.removeAll();
            this.createCustomContents();
        }

        /**
         * Create custom labels and layout.
         */
        private void createCustomContents() {

            final WrappingLabel fFigureVariableUsageReferenceLabelFigure = this
                    .getFigureVariableUsageReferenceLabelFigure();
            VariableUsage variableUsage = (VariableUsage) resolveSemanticElement();
            if (variableUsage == null) {
            	fFigureVariableUsageReferenceLabelFigure.setText("<not set>");
            } else {
                fFigureVariableUsageReferenceLabelFigure.setText(new PCMStoExPrettyPrintVisitor()
                .prettyPrint(variableUsage.getNamedReference__VariableUsage()));
            }

            fFigureVariableUsageReferenceLabelFigure.setBorder(new MarginBorder(CustomVariableUsage3EditPart.this
                    .getMapMode().DPtoLP(2), CustomVariableUsage3EditPart.this.getMapMode().DPtoLP(0),
                    CustomVariableUsage3EditPart.this.getMapMode().DPtoLP(2), CustomVariableUsage3EditPart.this
                            .getMapMode().DPtoLP(0)));

            final GridData constraintFFigureVariableUsageReferenceLabelFigure = new GridData();
            constraintFFigureVariableUsageReferenceLabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalIndent = 0;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalSpan = 1;
            constraintFFigureVariableUsageReferenceLabelFigure.verticalSpan = 1;
            constraintFFigureVariableUsageReferenceLabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureVariableUsageReferenceLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureVariableUsageReferenceLabelFigure, constraintFFigureVariableUsageReferenceLabelFigure);

            final RectangleFigure fFigureParametricParameterUsageRectangleCompartment = this
                    .getFigureParametricParameterUsageRectangleCompartment();
            fFigureParametricParameterUsageRectangleCompartment.setFill(false);
            fFigureParametricParameterUsageRectangleCompartment.setOutline(false);

            final GridData constraintFFigureParametricParameterUsageRectangleCompartment = new GridData();
            constraintFFigureParametricParameterUsageRectangleCompartment.verticalAlignment = GridData.FILL;
            constraintFFigureParametricParameterUsageRectangleCompartment.horizontalAlignment = GridData.FILL;
            constraintFFigureParametricParameterUsageRectangleCompartment.horizontalIndent = 0;
            constraintFFigureParametricParameterUsageRectangleCompartment.horizontalSpan = 1;
            constraintFFigureParametricParameterUsageRectangleCompartment.verticalSpan = 1;
            constraintFFigureParametricParameterUsageRectangleCompartment.grabExcessHorizontalSpace = true;
            constraintFFigureParametricParameterUsageRectangleCompartment.grabExcessVerticalSpace = true;
            this.add(fFigureParametricParameterUsageRectangleCompartment,
                    constraintFFigureParametricParameterUsageRectangleCompartment);

        }

    }

}