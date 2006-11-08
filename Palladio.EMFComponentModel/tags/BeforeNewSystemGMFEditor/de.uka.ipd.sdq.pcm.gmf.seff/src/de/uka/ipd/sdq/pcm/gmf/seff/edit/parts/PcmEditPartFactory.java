/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;

/**
 * @generated
 */
public class PcmEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			int viewVisualID = PcmVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
			case StartActionEditPart.VISUAL_ID:
				return new StartActionEditPart(view);
			case StopActionEditPart.VISUAL_ID:
				return new StopActionEditPart(view);
			case ExternalCallActionEditPart.VISUAL_ID:
				return new ExternalCallActionEditPart(view);
			case ExternalCallActionEntityNameEditPart.VISUAL_ID:
				return new ExternalCallActionEntityNameEditPart(view);
			case LoopActionEditPart.VISUAL_ID:
				return new LoopActionEditPart(view);
			case LoopActionEntityName2EditPart.VISUAL_ID:
				return new LoopActionEntityName2EditPart(view);
			case LoopActionIterations2EditPart.VISUAL_ID:
				return new LoopActionIterations2EditPart(view);
			case BranchAction2EditPart.VISUAL_ID:
				return new BranchAction2EditPart(view);
			case BranchActionEntityName2EditPart.VISUAL_ID:
				return new BranchActionEntityName2EditPart(view);
			case InternalAction2EditPart.VISUAL_ID:
				return new InternalAction2EditPart(view);
			case InternalActionEntityName2EditPart.VISUAL_ID:
				return new InternalActionEntityName2EditPart(view);
			case PrimitiveParametricParameterUsageEditPart.VISUAL_ID:
				return new PrimitiveParametricParameterUsageEditPart(view);
			case PrimitiveParametricParameterUsageSpecificationEditPart.VISUAL_ID:
				return new PrimitiveParametricParameterUsageSpecificationEditPart(
						view);
			case CollectionParametricParameterUsageEditPart.VISUAL_ID:
				return new CollectionParametricParameterUsageEditPart(view);
			case CollectionParametricParameterUsageSpecificationEditPart.VISUAL_ID:
				return new CollectionParametricParameterUsageSpecificationEditPart(
						view);
			case ParametricResourceDemandEditPart.VISUAL_ID:
				return new ParametricResourceDemandEditPart(view);
			case ParametricResourceDemandDemandEditPart.VISUAL_ID:
				return new ParametricResourceDemandDemandEditPart(view);
			case ResourceDemandingBehaviourEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourEditPart(view);
			case StartAction2EditPart.VISUAL_ID:
				return new StartAction2EditPart(view);
			case StopAction2EditPart.VISUAL_ID:
				return new StopAction2EditPart(view);
			case LoopAction2EditPart.VISUAL_ID:
				return new LoopAction2EditPart(view);
			case LoopActionEntityNameEditPart.VISUAL_ID:
				return new LoopActionEntityNameEditPart(view);
			case LoopActionIterationsEditPart.VISUAL_ID:
				return new LoopActionIterationsEditPart(view);
			case InternalActionEditPart.VISUAL_ID:
				return new InternalActionEditPart(view);
			case InternalActionEntityNameEditPart.VISUAL_ID:
				return new InternalActionEntityNameEditPart(view);
			case BranchActionEditPart.VISUAL_ID:
				return new BranchActionEditPart(view);
			case BranchActionEntityNameEditPart.VISUAL_ID:
				return new BranchActionEntityNameEditPart(view);
			case BranchTransitionEditPart.VISUAL_ID:
				return new BranchTransitionEditPart(view);
			case BranchTransitionBranchConditionEditPart.VISUAL_ID:
				return new BranchTransitionBranchConditionEditPart(view);
			case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
				return new ResourceDemandingBehaviour2EditPart(view);
			case ExternalCallAction2EditPart.VISUAL_ID:
				return new ExternalCallAction2EditPart(view);
			case ExternalCallActionEntityName2EditPart.VISUAL_ID:
				return new ExternalCallActionEntityName2EditPart(view);
			case LoopActionBehaviourCompartmentEditPart.VISUAL_ID:
				return new LoopActionBehaviourCompartmentEditPart(view);
			case ResourceDemandingBehaviourLoopCompartmentEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourLoopCompartmentEditPart(
						view);
			case LoopActionBehaviourCompartment2EditPart.VISUAL_ID:
				return new LoopActionBehaviourCompartment2EditPart(view);
			case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
				return new BranchActionBranchTransitionCompartmentEditPart(view);
			case BranchTransitionBehaviourCompartmentEditPart.VISUAL_ID:
				return new BranchTransitionBehaviourCompartmentEditPart(view);
			case ResourceDemandingBehaviourBranchCompartmentEditPart.VISUAL_ID:
				return new ResourceDemandingBehaviourBranchCompartmentEditPart(
						view);
			case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
				return new BranchActionBranchTransitionCompartment2EditPart(
						view);
			case ResourceDemandingSEFFEditPart.VISUAL_ID:
				return new ResourceDemandingSEFFEditPart(view);
			case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
				return new AbstractActionSuccessor_AbstractActionEditPart(view);
			case ExternalCallActionParametricParameterUsage_ParametricParameterUsageEditPart.VISUAL_ID:
				return new ExternalCallActionParametricParameterUsage_ParametricParameterUsageEditPart(
						view);
			case AbstractResourceDemandingActionResourceDemand_ActionEditPart.VISUAL_ID:
				return new AbstractResourceDemandingActionResourceDemand_ActionEditPart(
						view);
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
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrapLabel)
			return new TextCellEditorLocator((WrapLabel) source.getFigure());
		else {
			IFigure figure = source.getFigure();
			return new LabelCellEditorLocator((Label) figure);
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrapLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrapLabel wrapLabel) {
			super();
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrapLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);

			if (getWrapLabel().isTextWrapped()
					&& getWrapLabel().getText().length() > 0)
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}

			if (!rect.equals(new Rectangle(text.getBounds())))
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
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

			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));

			if (!rect.equals(new Rectangle(text.getBounds())))
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
		}
	}
}
