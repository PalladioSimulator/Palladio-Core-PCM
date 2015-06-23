/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

/**
 * A custom variable usage EditPart.
 */
public class CustomVariableUsageEditPart extends VariableUsageEditPart {

    /**
     * The constructor.
     * 
     * @param view
     *            a View
     */
    public CustomVariableUsageEditPart(View view) {
        super(view);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected IFigure createNodeShape() {
        ParametricParameterUsageFigure2 figure = new ParametricParameterUsageFigure2();
        primaryShape = figure;
        return primaryShape;
    }

    // I left the @generated tags in, so it is clear what part(s) of the class has been modified.
    // Somewhat dirty but the lesser evil imho.

    /**
     * A parametric parameter usage figure.
     */
    public class ParametricParameterUsageFigure2 extends ParametricParameterUsageFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureVariableUsageReferenceLabelFigure;

        /**
         * @generated
         */
        private RectangleFigure fFigureParametricParameterUsageRectangleCompartment;

        /**
         * @generated not
         */
        public ParametricParameterUsageFigure2() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setLineWidth(1);
            // TODO: Find a better way!
            this.setBackgroundColor(getThisBack());
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * @generated not
         */
        private void createContents() {

            fFigureVariableUsageReferenceLabelFigure = new WrappingLabel();
            if (resolveSemanticElement() != null) {
                fFigureVariableUsageReferenceLabelFigure.setText(new PCMStoExPrettyPrintVisitor()
                        .prettyPrint(((VariableUsage) resolveSemanticElement()).getNamedReference__VariableUsage()));
            } else {
                fFigureVariableUsageReferenceLabelFigure.setText("<null>");
            }

            this.add(fFigureVariableUsageReferenceLabelFigure);

        }

        /**
         * @generated
         */
        private boolean myUseLocalCoordinates = false;

        /**
         * @generated
         */
        protected boolean useLocalCoordinates() {
            return myUseLocalCoordinates;
        }

        /**
         * @generated
         */
        protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureVariableUsageReferenceLabelFigure() {
            return fFigureVariableUsageReferenceLabelFigure;
        }

        /**
         * @generated
         */
        public RectangleFigure getFigureParametricParameterUsageRectangleCompartment() {
            return fFigureParametricParameterUsageRectangleCompartment;
        }

    }

}
