/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.policies.CommunicationLinkResourceSpecificationItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class CommunicationLinkResourceSpecificationEditPart extends
		ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3004;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public CommunicationLinkResourceSpecificationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new CommunicationLinkResourceSpecificationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new NetworkSwitchSpecificationFigure();
	}

	/**
	 * @generated
	 */
	public NetworkSwitchSpecificationFigure getPrimaryShape() {
		return (NetworkSwitchSpecificationFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof CommunicationLinkResourceSpecificationFailureProbabilityEditPart) {
			((CommunicationLinkResourceSpecificationFailureProbabilityEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureFailureProbabilityFigure());
			return true;
		}
		if (childEditPart instanceof CommunicationLinkResourceSpecificationLatencyLabelEditPart) {
			((CommunicationLinkResourceSpecificationLatencyLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureLatencyLabelFigure());
			return true;
		}
		if (childEditPart instanceof CommunicationLinkResourceSpecificationThroughputLabelEditPart) {
			((CommunicationLinkResourceSpecificationThroughputLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureThroughputLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel6EditPart) {
			((WrappingLabel6EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureNetworkSwitchSpecificationNameFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof CommunicationLinkResourceSpecificationFailureProbabilityEditPart) {
			return true;
		}
		if (childEditPart instanceof CommunicationLinkResourceSpecificationLatencyLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof CommunicationLinkResourceSpecificationThroughputLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel6EditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects layout one may have set
	 * for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
				.getType(CommunicationLinkResourceSpecificationFailureProbabilityEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class NetworkSwitchSpecificationFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureThroughputLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLatencyLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFailureProbabilityFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureNetworkSwitchSpecificationNameFigure;

		/**
		 * @generated
		 */
		public NetworkSwitchSpecificationFigure() {
			this.setFill(false);
			this.setOutline(false);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureNetworkSwitchSpecificationNameFigure = new WrappingLabel();

			fFigureNetworkSwitchSpecificationNameFigure.setText("LAN");

			this.add(fFigureNetworkSwitchSpecificationNameFigure);

			WrappingLabel latency0 = new WrappingLabel();

			latency0.setText("Latency:");

			this.add(latency0);

			fFigureLatencyLabelFigure = new WrappingLabel();

			fFigureLatencyLabelFigure.setText("");

			this.add(fFigureLatencyLabelFigure);

			WrappingLabel throughput0 = new WrappingLabel();

			throughput0.setText("Throughput:");

			this.add(throughput0);

			fFigureThroughputLabelFigure = new WrappingLabel();

			fFigureThroughputLabelFigure.setText("");

			this.add(fFigureThroughputLabelFigure);

			WrappingLabel failureProbabiliby0 = new WrappingLabel();

			failureProbabiliby0.setText("Failure Probability:");

			this.add(failureProbabiliby0);

			fFigureFailureProbabilityFigure = new WrappingLabel();

			fFigureFailureProbabilityFigure.setText("");

			this.add(fFigureFailureProbabilityFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureThroughputLabelFigure() {
			return fFigureThroughputLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLatencyLabelFigure() {
			return fFigureLatencyLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFailureProbabilityFigure() {
			return fFigureFailureProbabilityFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNetworkSwitchSpecificationNameFigure() {
			return fFigureNetworkSwitchSpecificationNameFigure;
		}

	}

}
