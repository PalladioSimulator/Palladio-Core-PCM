/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart.ParametricParameterUsageFigure;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

public class CustomVariableUsage4EditPart extends VariableUsage4EditPart {

	static final Color THIS_BACK = new Color(null, 220, 220, 220);

	public CustomVariableUsage4EditPart(View view) {
		super(view);
	}

	protected IFigure createNodeShape() {
		ParametricParameterUsageFigure figure = new CustomParametricParameterUsageFigure();
		return primaryShape = figure;
	}

	public class CustomParametricParameterUsageFigure extends ParametricParameterUsageFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureVariableUsageReferenceLabelFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureParametricParameterUsageRectangleCompartment;

		/**
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
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated not
		 */
		private void createContents() {

			fFigureVariableUsageReferenceLabelFigure = new WrappingLabel();
			fFigureVariableUsageReferenceLabelFigure
					.setText(new PCMStoExPrettyPrintVisitor()
							.prettyPrint(((VariableUsage) resolveSemanticElement())
									.getNamedReference__VariableUsage()));
			fFigureVariableUsageReferenceLabelFigure
					.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureVariableUsageReferenceLabelFigure = new GridData();
			constraintFFigureVariableUsageReferenceLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureVariableUsageReferenceLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureVariableUsageReferenceLabelFigure.horizontalIndent = 0;
			constraintFFigureVariableUsageReferenceLabelFigure.horizontalSpan = 1;
			constraintFFigureVariableUsageReferenceLabelFigure.verticalSpan = 1;
			constraintFFigureVariableUsageReferenceLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureVariableUsageReferenceLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureVariableUsageReferenceLabelFigure,
					constraintFFigureVariableUsageReferenceLabelFigure);

			fFigureParametricParameterUsageRectangleCompartment = new RectangleFigure();
			fFigureParametricParameterUsageRectangleCompartment.setFill(false);
			fFigureParametricParameterUsageRectangleCompartment
					.setOutline(false);
			fFigureParametricParameterUsageRectangleCompartment.setLineWidth(1);
			fFigureParametricParameterUsageRectangleCompartment
					.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureParametricParameterUsageRectangleCompartment = new GridData();
			constraintFFigureParametricParameterUsageRectangleCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureParametricParameterUsageRectangleCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureParametricParameterUsageRectangleCompartment.horizontalIndent = 0;
			constraintFFigureParametricParameterUsageRectangleCompartment.horizontalSpan = 1;
			constraintFFigureParametricParameterUsageRectangleCompartment.verticalSpan = 1;
			constraintFFigureParametricParameterUsageRectangleCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureParametricParameterUsageRectangleCompartment.grabExcessVerticalSpace = true;
			this
					.add(fFigureParametricParameterUsageRectangleCompartment,
							constraintFFigureParametricParameterUsageRectangleCompartment);

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
