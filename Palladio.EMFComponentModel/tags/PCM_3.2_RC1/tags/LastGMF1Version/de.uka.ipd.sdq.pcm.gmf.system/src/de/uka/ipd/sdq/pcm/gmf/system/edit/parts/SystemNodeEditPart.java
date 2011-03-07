/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.parts;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import de.uka.ipd.sdq.pcm.gmf.system.LabelUpdatingAbstractBorderedShapeEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.RotatingBorderItemLocator;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.SystemNodeCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.SystemNodeGraphicalNodeEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.SystemNodeItemSemanticEditPolicy;

/**
 * @generated NOT
 */
public class SystemNodeEditPart extends LabelUpdatingAbstractBorderedShapeEditPart implements Listener {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1002;

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
	public SystemNodeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy(){
			protected Command getCreateCommand(CreateViewRequest request) {

		        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
		            .getEditingDomain();
		        CompositeTransactionalCommand cc = new CompositeTransactionalCommand(
		            editingDomain, DiagramUIMessages.AddCommand_Label);
		        
		        Iterator descriptors = request.getViewDescriptors().iterator();

				while (descriptors.hasNext()) {
					CreateViewRequest.ViewDescriptor descriptor =
						(CreateViewRequest.ViewDescriptor)descriptors.next();

					if (descriptor.getSemanticHint() != null && descriptor.getSemanticHint().equals("1001")) {
						CreateCommand createCommand =
							new CreateCommand(editingDomain,
								descriptor, 
								(View)(getHost().getModel()));
						Point p = request.getLocation();
						p = SystemNodeEditPart.this.primaryShape.getBounds().getTopLeft().getNegated().getTranslated(p);
						SetBoundsCommand setBoundsCmd = new
							SetBoundsCommand(editingDomain, "Move", 
									(IAdaptable)createCommand.getCommandResult().getReturnValue(),p);
	
						cc.compose(createCommand);
						cc.compose(setBoundsCmd);
					} else {
						CreateCommand createCommand =
							new CreateCommand(editingDomain,
								descriptor, 
								(View)(getHost().getModel()));
						cc.compose(createCommand);
					}
				}
				return new ICommandProxy(cc.reduce());

			}
		});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SystemNodeItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new SystemNodeGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new SystemNodeCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
//		installEditPolicy(EditPolicy.LAYOUT_ROLE,
//				new XYLayoutEditPolicy());
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
		SystemFigure figure = new SystemFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SystemFigure getPrimaryShape() {
		return (SystemFigure) primaryShape;
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
		return super.createNodeFigure();
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

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * @generated
	 */
	public class SystemFigure extends org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		public SystemFigure() {

			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {
			org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig_0 = new org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel();
			fig_0.setText("<<system>>");

			setFigureSystemNameLabelFigure(fig_0);

			Object layData0 = null;

			this.add(fig_0, layData0);
		}

		/**
		 * @generated
		 */
		private org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fSystemNameLabelFigure;

		/**
		 * @generated
		 */
		public org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel getFigureSystemNameLabelFigure() {
			return fSystemNameLabelFigure;
		}

		/**
		 * @generated
		 */
		private void setFigureSystemNameLabelFigure(
				org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig) {
			fSystemNameLabelFigure = fig;
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
	
	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		RotatingBorderItemLocator locator;
		borderItemContainer.add(borderItemEditPart.getFigure(),
			locator = new RotatingBorderItemLocator(getMainFigure()));
		locator.addListener(this);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#addChildVisual(org.eclipse.gef.EditPart, int)
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof IBorderItemEditPart)
			super.addChildVisual(childEditPart, index);
		else {
			IFigure childFigure = ((GraphicalEditPart) childEditPart).getFigure();
			// IFigure fig = getContentPaneFor((IGraphicalEditPart) childEditPart);
			getPrimaryShape().add(childFigure);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#setLayoutConstraint(org.eclipse.gef.EditPart, org.eclipse.draw2d.IFigure, java.lang.Object)
	 */
	@Override
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		if (child instanceof AbstractBorderItemEditPart)
			super.setLayoutConstraint(child, childFigure, constraint);
		else {
			getPrimaryShape().setConstraint(childFigure, constraint);
		}
	}

	public void handleEvent(Event event) {
		refreshChildLabels();
	}
	

}
