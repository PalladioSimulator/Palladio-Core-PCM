/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.palladiosimulator.pcm.pcmstoex.adapter.PCMStoExSerializer;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

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
    public CustomVariableUsageEditPart(View view) {
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
        CustomParametricParameterUsageFigure figure = new CustomParametricParameterUsageFigure();
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

        /** The figure parametric parameter usage rectangle compartment. @generated */
        private RectangleFigure fFigureParametricParameterUsageRectangleCompartment;

        /**
         * Instantiates a new custom parametric parameter usage figure.
         * 
         * @generated
         */
        public CustomParametricParameterUsageFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setLineWidth(1);
            this.setBackgroundColor(THIS_BACK);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * Creates the contents.
         * 
         * @generated not
         */
        private void createContents() {

            fFigureVariableUsageReferenceLabelFigure = new WrappingLabel();
            fFigureVariableUsageReferenceLabelFigure.setText(new PCMStoExSerializer()
                    .prettyPrint(((VariableUsage) resolveSemanticElement()).getNamedReference__VariableUsage()));
            fFigureVariableUsageReferenceLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureVariableUsageReferenceLabelFigure = new GridData();
            constraintFFigureVariableUsageReferenceLabelFigure.verticalAlignment = GridData.CENTER;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalIndent = 0;
            constraintFFigureVariableUsageReferenceLabelFigure.horizontalSpan = 1;
            constraintFFigureVariableUsageReferenceLabelFigure.verticalSpan = 1;
            constraintFFigureVariableUsageReferenceLabelFigure.grabExcessHorizontalSpace = false;
            constraintFFigureVariableUsageReferenceLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureVariableUsageReferenceLabelFigure, constraintFFigureVariableUsageReferenceLabelFigure);

            fFigureParametricParameterUsageRectangleCompartment = new RectangleFigure();
            fFigureParametricParameterUsageRectangleCompartment.setFill(false);
            fFigureParametricParameterUsageRectangleCompartment.setOutline(false);

            GridData constraintFFigureParametricParameterUsageRectangleCompartment = new GridData();
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

        /**
         * Gets the figure variable usage reference label figure.
         * 
         * @return the figure variable usage reference label figure
         * @generated
         */
        public WrappingLabel getFigureVariableUsageReferenceLabelFigure() {
            return fFigureVariableUsageReferenceLabelFigure;
        }

        /**
         * Gets the figure parametric parameter usage rectangle compartment.
         * 
         * @return the figure parametric parameter usage rectangle compartment
         * @generated
         */
        public RectangleFigure getFigureParametricParameterUsageRectangleCompartment() {
            return fFigureParametricParameterUsageRectangleCompartment;
        }

        /** The my use local coordinates. @generated */
        private boolean myUseLocalCoordinates = false;

        /**
         * Use local coordinates.
         * 
         * @return true, if successful
         * @generated
         */
        protected boolean useLocalCoordinates() {
            return myUseLocalCoordinates;
        }

        /**
         * Sets the use local coordinates.
         * 
         * @param useLocalCoordinates
         *            the new use local coordinates
         * @generated
         */
        protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }
    }
}
