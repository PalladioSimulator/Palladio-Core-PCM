/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import de.uka.ipd.sdq.pcm.gmf.system.LabelUpdatingAbstractBorderedShapeEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.RotatingBorderItemLocator;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.AssemblyContextCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.AssemblyContextGraphicalNodeEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.AssemblyContextItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.part.PcmVisualIDRegistry;

/**
 * @generated NOT
 */
public class AssemblyContextEditPart extends LabelUpdatingAbstractBorderedShapeEditPart implements Listener {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1001;

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
	public AssemblyContextEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AssemblyContextItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new AssemblyContextGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new AssemblyContextCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

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
		AssemblyContextFigure figure = new AssemblyContextFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public AssemblyContextFigure getPrimaryShape() {
		return (AssemblyContextFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssemblyContextEntityNameEditPart) {
			((AssemblyContextEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureEntityEntityName2Figure());
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
	protected NodeFigure createNodePlate() {
		return new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode()
				.DPtoLP(40));
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated NOT
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure fig = super.createNodeFigure();
		((BorderedNodeFigure)fig).getBorderItemContainer().addLayoutListener(new LayoutListener(){

			public void invalidate(IFigure container) {
				// TODO Auto-generated method stub
				
			}

			public boolean layout(IFigure container) {
				// TODO Auto-generated method stub
				return false;
			}

			public void postLayout(IFigure container) {
				System.out.println("BorderItems layed out");
			}

			public void remove(IFigure child) {
				// TODO Auto-generated method stub
				
			}

			public void setConstraint(IFigure child, Object constraint) {
				// TODO Auto-generated method stub
				
			}
			
		});
		return fig;
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
		return getChildBySemanticHint(PcmVisualIDRegistry
				.getType(AssemblyContextEntityNameEditPart.VISUAL_ID));
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
	public class AssemblyContextFigure extends
			org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		public AssemblyContextFigure() {

			this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_DASH);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {
			org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig_0 = new org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel();
			fig_0.setText("<...>");

			setFigureEntityEntityName2Figure(fig_0);

			Object layData0 = null;

			this.add(fig_0, layData0);
		}

		/**
		 * @generated
		 */
		private org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fEntityEntityName2Figure;

		/**
		 * @generated
		 */
		public org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel getFigureEntityEntityName2Figure() {
			return fEntityEntityName2Figure;
		}

		/**
		 * @generated
		 */
		private void setFigureEntityEntityName2Figure(
				org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig) {
			fEntityEntityName2Figure = fig;
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
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		RotatingBorderItemLocator locator;
		borderItemContainer.add(borderItemEditPart.getFigure(),
			locator = new RotatingBorderItemLocator(getMainFigure()));
		locator.addListener(this);
	}

	public void handleEvent(Event event) {
		refreshChildLabels();
	}	
}
