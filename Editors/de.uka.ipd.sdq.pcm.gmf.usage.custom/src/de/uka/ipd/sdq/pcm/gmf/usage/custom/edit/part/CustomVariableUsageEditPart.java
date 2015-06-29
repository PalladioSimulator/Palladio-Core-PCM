/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.palladiosimulator.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

/**
 * The Class CustomVariableUsageEditPart.
 */
public class CustomVariableUsageEditPart extends VariableUsageEditPart {

    // ATTENTION This value is likely to break. But there was no way to get access in parent.
    /** The Constant THIS_BACK. */
    static final Color THIS_BACK = new Color(null, 220, 220, 220);

    /**
     * Instantiates a new custom variable usage edit part.
     *
     * @param view
     *            the view
     */
    public CustomVariableUsageEditPart(final View view) {
        super(view);
    }

    /**
     * Creates the node shape.
     *
     * @return the i figure
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart#createNodeShape()
     */
    @Override
    protected IFigure createNodeShape() {
        final CustomParametricParameterUsageFigure figure = new CustomParametricParameterUsageFigure();
        primaryShape = figure;
        return primaryShape;
    }

    /**
     * The Class CustomParametricParameterUsageFigure.
     *
     * @generated
     */
    public class CustomParametricParameterUsageFigure extends ParametricParameterUsageFigure {

        /** The figure variable usage reference label figure. @generated */
        private WrappingLabel fFigureVariableUsageReferenceLabelFigure;


        /**
         * Instantiates a new custom parametric parameter usage figure.
         *
         * @generated
         */
        public CustomParametricParameterUsageFigure() {
            super();

            createContents();
        }

        /**
         * Creates the contents.
         *
         * @generated not
         */
        private void createContents() {

            fFigureVariableUsageReferenceLabelFigure = getFigureVariableUsageReferenceLabelFigure();
            fFigureVariableUsageReferenceLabelFigure.setText(new PCMStoExPrettyPrintVisitor()
            .prettyPrint(((VariableUsage) resolveSemanticElement()).getNamedReference__VariableUsage()));
            fFigureVariableUsageReferenceLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));
        }

    }
}
