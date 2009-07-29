package de.uka.ipd.sdq.pcm.diagram.edit.parts;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.diagram.edit.policies.PalladioComponentModelTextSelectionEditPolicy;
import de.uka.ipd.sdq.pcm.diagram.edit.policies.ResourceContainerItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.diagram.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.diagram.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ResourceContainerEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

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
	public ResourceContainerEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {
			public Command getCommand(Request request) {
				if (understandsRequest(request)) {
					if (request instanceof CreateViewAndElementRequest) {
						CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
								.getViewAndElementDescriptor().getCreateElementRequestAdapter();
						IElementType type = (IElementType) adapter
								.getAdapter(IElementType.class);
						if (type == PalladioComponentModelElementTypes.ProcessingResourceSpecification_3001) {
							EditPart compartmentEditPart = getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
									.getType(ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart
									.getCommand(request);
						}
					}
					return super.getCommand(request);
				}
				return null;
			}
		});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ResourceContainerItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		ResourceContainerFigure figure = new ResourceContainerFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ResourceContainerFigure getPrimaryShape() {
		return (ResourceContainerFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ResourceContainerEntityNameEditPart) {
			((ResourceContainerEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureResourceContainerNameFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

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

		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(40), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
				.getType(ResourceContainerEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ResourceContainerFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureResourceContainerNameFigure;

		/**
		 * @generated
		 */
		public ResourceContainerFigure() {
			this.setLayoutManager(new StackLayout());
			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(0);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(250), getMapMode()
					.DPtoLP(350)));

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			class Polyline0Class extends Shape {
				/**
				 * @generated
				 */
				private final PointList myTemplate = new PointList();
				/**
				 * @generated
				 */
				private Rectangle myTemplateBounds;

				/**
				 * @generated
				 */
				public void addPoint(Point point) {
					myTemplate.addPoint(point);
					myTemplateBounds = null;
				}

				/**
				 * @generated
				 */
				protected void fillShape(Graphics graphics) {
					Rectangle bounds = getBounds();
					graphics.pushState();
					graphics.translate(bounds.x, bounds.y);
					graphics.fillPolygon(scalePointList());
					graphics.popState();
				}

				/**
				 * @generated
				 */
				protected void outlineShape(Graphics graphics) {
					Rectangle bounds = getBounds();
					graphics.pushState();
					graphics.translate(bounds.x, bounds.y);
					graphics.drawPolygon(scalePointList());
					graphics.popState();
				}

				/**
				 * @generated
				 */
				private Rectangle getTemplateBounds() {
					if (myTemplateBounds == null) {
						myTemplateBounds = myTemplate.getBounds().getCopy().union(0, 0);
						//just safety -- we are going to use this as divider 
						if (myTemplateBounds.width < 1) {
							myTemplateBounds.width = 1;
						}
						if (myTemplateBounds.height < 1) {
							myTemplateBounds.height = 1;
						}
					}
					return myTemplateBounds;
				}

				/**
				 * @generated
				 */
				private int[] scalePointList() {
					Rectangle pointsBounds = getTemplateBounds();
					Rectangle actualBounds = getBounds();

					float xScale = ((float) actualBounds.width) / pointsBounds.width;
					float yScale = ((float) actualBounds.height) / pointsBounds.height;

					if (xScale == 1 && yScale == 1) {
						return myTemplate.toIntArray();
					}
					int[] scaled = (int[]) myTemplate.toIntArray().clone();
					for (int i = 0; i < scaled.length; i += 2) {
						scaled[i] = (int) Math.floor(scaled[i] * xScale);
						scaled[i + 1] = (int) Math.floor(scaled[i + 1] * yScale);
					}
					return scaled;
				}
			}
			;
			Polyline0Class polyline0 = new Polyline0Class();

			polyline0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(
					1)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(1), getMapMode().DPtoLP(
					0)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode()
					.DPtoLP(0)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode()
					.DPtoLP(40)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode()
					.DPtoLP(41)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(
					41)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(
					1)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode()
					.DPtoLP(1)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode()
					.DPtoLP(0)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode()
					.DPtoLP(1)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode()
					.DPtoLP(41)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode()
					.DPtoLP(40)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(29), getMapMode()
					.DPtoLP(41)));
			polyline0.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(
					41)));
			polyline0.setFill(true);

			this.add(polyline0);
			polyline0.setLayoutManager(new StackLayout());

			RectangleFigure rect0 = new RectangleFigure();
			rect0.setFill(false);
			rect0.setOutline(false);

			rect0.setBorder(new MarginBorder(getMapMode().DPtoLP(10), getMapMode()
					.DPtoLP(3), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

			this.add(rect0);
			rect0.setLayoutManager(new StackLayout());

			fFigureResourceContainerNameFigure = new WrappingLabel();
			fFigureResourceContainerNameFigure.setText("ResourceContainer");

			rect0.add(fFigureResourceContainerNameFigure);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

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
		public WrappingLabel getFigureResourceContainerNameFigure() {
			return fFigureResourceContainerNameFigure;
		}

	}

}
