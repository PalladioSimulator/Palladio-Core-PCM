/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditor;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;

import org.eclipse.core.runtime.CoreException;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;

import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;

import org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager;
import org.eclipse.gmf.runtime.common.ui.resources.IFileObserver;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;

import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.swt.graphics.Image;

import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/** 
 * @generated
 */
public class PalladioComponentModelValidationDecoratorProvider extends
		AbstractProvider implements IDecoratorProvider {
	/**
	 * @generated
	 */
	private static final String KEY = "validationStatus"; //$NON-NLS-1$
	/**
	 * @generated
	 */
	private static final String MARKER_TYPE = PalladioComponentModelRepositoryDiagramEditorPlugin.ID
			+ "." + "diagnostic"; //$NON-NLS-1$ //$NON-NLS-2$
	/**
	 * @generated
	 */
	private static MarkerObserver fileObserver = null;

	/**
	 * @generated
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget
				.getAdapter(EditPart.class);
		if (editPart instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart
				|| editPart instanceof AbstractConnectionEditPart) {
			Object model = editPart.getModel();
			if ((model instanceof View)) {
				View view = (View) model;
				if (!(view instanceof Edge) && !view.isSetElement()) {
					return;
				}
			}
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (((DiagramEditDomain) ed).getEditorPart() instanceof PalladioComponentModelRepositoryDiagramEditor) {
				decoratorTarget.installDecorator(KEY, new StatusDecorator(
						decoratorTarget));
			}
		}
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}

		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
				.getDecoratorTarget();
		View view = (View) decoratorTarget.getAdapter(View.class);
		return view != null
				&& RepositoryEditPart.MODEL_ID
						.equals(PalladioComponentModelVisualIDRegistry
								.getModelID(view));
	}

	/**
	 * @generated
	 */
	public static class StatusDecorator extends AbstractDecorator {
		/**
		 * @generated
		 */
		private String viewId;

		/**
		 * @generated
		 */
		public StatusDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			try {
				final View view = (View) getDecoratorTarget().getAdapter(
						View.class);
				TransactionUtil.getEditingDomain(view).runExclusive(
						new Runnable() {
							public void run() {
								StatusDecorator.this.viewId = view != null ? ViewUtil
										.getIdStr(view)
										: null;
							}
						});
			} catch (Exception e) {
				PalladioComponentModelRepositoryDiagramEditorPlugin
						.getInstance().logError("ViewID access failure", e); //$NON-NLS-1$			
			}
		}

		/**
		 * @generated
		 */
		public void refresh() {
			removeDecoration();

			View view = (View) getDecoratorTarget().getAdapter(View.class);
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);
			if (view == null || view.eResource() == null) {
				return;
			}

			IResource resource = getResource(view);
			// make sure we have a resource and that it exists in an open project
			if (resource == null || !resource.exists()) {
				return;
			}

			// query for all the validation markers of the current resource
			IMarker[] markers = null;
			try {
				markers = resource.findMarkers(MARKER_TYPE, true,
						IResource.DEPTH_INFINITE);
			} catch (CoreException e) {
				PalladioComponentModelRepositoryDiagramEditorPlugin
						.getInstance().logError(
								"Validation marker refresh failure", e); //$NON-NLS-1$
			}
			if (markers == null || markers.length == 0) {
				return;
			}

			String elementId = ViewUtil.getIdStr(view);
			if (elementId == null) {
				return;
			}

			IMarker foundMarker = null;
			Label toolTip = null;
			int severity = IMarker.SEVERITY_INFO;
			for (int i = 0; i < markers.length; i++) {
				IMarker marker = markers[i];
				String attribute = marker
						.getAttribute(
								org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
								""); //$NON-NLS-1$
				if (attribute.equals(elementId)) {
					int nextSeverity = marker.getAttribute(IMarker.SEVERITY,
							IMarker.SEVERITY_INFO);
					Image nextImage = getImage(nextSeverity);
					if (foundMarker == null) {
						foundMarker = marker;
						toolTip = new Label(marker.getAttribute(
								IMarker.MESSAGE, ""), nextImage);
					} else {
						if (toolTip.getChildren().isEmpty()) {
							Label comositeLabel = new Label();
							FlowLayout fl = new FlowLayout(false);
							fl.setMinorSpacing(0);
							comositeLabel.setLayoutManager(fl);
							comositeLabel.add(toolTip);
							toolTip = comositeLabel;
						}
						toolTip.add(new Label(marker.getAttribute(
								IMarker.MESSAGE, ""), nextImage)); //$NON-NLS-1$
					}
					severity = (nextSeverity > severity) ? nextSeverity
							: severity;
				}
			}
			if (foundMarker == null) {
				return;
			}

			// add decoration
			if (editPart instanceof GraphicalEditPart) {
				Image img = getImage(severity);
				if (view instanceof Edge) {
					setDecoration(getDecoratorTarget().addConnectionDecoration(
							img, 50, true));
				} else {
					int margin = -1;
					if (editPart instanceof GraphicalEditPart) {
						margin = MapModeUtil.getMapMode(
								((GraphicalEditPart) editPart).getFigure())
								.DPtoLP(margin);
					}
					setDecoration(getDecoratorTarget()
							.addShapeDecoration(img,
									IDecoratorTarget.Direction.NORTH_EAST,
									margin, true));
				}
				getDecoration().setToolTip(toolTip);
			}
		}

		/**
		 * @generated
		 */
		private Image getImage(int severity) {
			String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			switch (severity) {
			case IMarker.SEVERITY_ERROR:
				imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
				break;
			case IMarker.SEVERITY_WARNING:
				imageName = ISharedImages.IMG_OBJS_WARN_TSK;
				break;
			default:
				imageName = ISharedImages.IMG_OBJS_INFO_TSK;
			}
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					imageName);
		}

		/**
		 * @generated
		 */
		private static IResource getResource(View view) {
			Resource model = view.eResource();
			if (model != null) {
				return WorkspaceSynchronizer.getFile(model);
			}
			return null;
		}

		/**
		 * @generated
		 */
		public void activate() {
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null)
				return;
			Diagram diagramView = view.getDiagram();
			if (diagramView == null)
				return;
			IFile file = WorkspaceSynchronizer.getFile(diagramView.eResource());
			if (file != null) {
				if (fileObserver == null) {
					fileObserver = new MarkerObserver(diagramView);
				}

				fileObserver.registerDecorator(this);
			}
		}

		/**
		 * @generated
		 */
		public void deactivate() {
			if (fileObserver != null) {
				fileObserver.unregisterDecorator(this);
				if (!fileObserver.isRegistered()) {
					fileObserver = null;
				}
			}

			super.deactivate();
		}

		/**
		 * @generated
		 */
		String getViewId() {
			return viewId;
		}
	}

	/**
	 * @generated
	 */
	static class MarkerObserver implements IFileObserver {
		/**
		 * @generated
		 */
		private HashMap mapOfIdsToDecorators = null;
		/**
		 * @generated
		 */
		private boolean isRegistered = false;
		/**
		 * @generated
		 */
		private Diagram diagramView;

		/**
		 * @generated
		 */
		private MarkerObserver(Diagram diagramView) {
			this.diagramView = diagramView;
		}

		/**
		 * @generated
		 */
		private void registerDecorator(StatusDecorator decorator) {
			if (decorator == null) {
				return;
			}

			if (mapOfIdsToDecorators == null) {
				mapOfIdsToDecorators = new HashMap();
			}

			String decoratorViewId = decorator.getViewId();
			if (decoratorViewId == null) {
				return;
			}

			/* Add to the list */
			List list = (List) mapOfIdsToDecorators.get(decoratorViewId);
			if (list == null) {
				list = new ArrayList(2);
				list.add(decorator);
				mapOfIdsToDecorators.put(decoratorViewId, list);
			} else if (!list.contains(decorator)) {
				list.add(decorator);
			}

			/* Register with the file change manager */
			if (!isRegistered()) {
				FileChangeManager.getInstance().addFileObserver(this);
				isRegistered = true;
			}
		}

		/**
		 * @generated
		 */
		private void unregisterDecorator(StatusDecorator decorator) {
			/* Return if invalid decorator */
			if (decorator == null) {
				return;
			}

			/* Return if the decorator has invalid view id */
			String decoratorViewId = decorator.getViewId();
			if (decoratorViewId == null) {
				return;
			}

			if (mapOfIdsToDecorators != null) {
				List list = (List) mapOfIdsToDecorators.get(decoratorViewId);
				if (list != null) {
					list.remove(decorator);
					if (list.isEmpty()) {
						mapOfIdsToDecorators.remove(decoratorViewId);
					}
				}

				if (mapOfIdsToDecorators.isEmpty()) {
					mapOfIdsToDecorators = null;
				}
			}

			if (mapOfIdsToDecorators == null) {
				/* Unregister with the file change manager */
				if (isRegistered()) {
					FileChangeManager.getInstance().removeFileObserver(this);
					isRegistered = false;
				}
			}
		}

		/**
		 * @generated
		 */
		public void handleFileRenamed(IFile oldFile, IFile file) { /* Empty Code */
		}

		/**
		 * @generated
		 */
		public void handleFileMoved(IFile oldFile, IFile file) { /* Empty Code */
		}

		/**
		 * @generated
		 */
		public void handleFileDeleted(IFile file) { /* Empty Code */
		}

		/**
		 * @generated
		 */
		public void handleFileChanged(IFile file) { /* Empty Code */
		}

		/**
		 * @generated
		 */
		public void handleMarkerAdded(IMarker marker) {
			if (marker
					.getAttribute(
							org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
							null) != null) {
				handleMarkerChanged(marker);
			}
		}

		/**
		 * @generated
		 */
		public void handleMarkerDeleted(IMarker marker, Map attributes) {
			if (mapOfIdsToDecorators == null) {
				return;
			}
			// Extract the element guid from the marker and retrieve
			// corresponding view
			String elementId = (String) attributes
					.get(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID);
			List list = elementId != null ? (List) mapOfIdsToDecorators
					.get(elementId) : null;
			if (list != null && !list.isEmpty()) {
				refreshDecorators(list);
			}
		}

		/**
		 * @generated
		 */
		public void handleMarkerChanged(IMarker marker) {
			if (mapOfIdsToDecorators == null
					|| !MARKER_TYPE.equals(getType(marker))) {
				return;
			}
			// Extract the element ID list from the marker and retrieve
			// corresponding view	
			String elementId = marker
					.getAttribute(
							org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
							""); //$NON-NLS-1$
			List list = elementId != null ? (List) mapOfIdsToDecorators
					.get(elementId) : null;

			if (list != null && !list.isEmpty()) {
				refreshDecorators(list);
			}
		}

		/**
		 * @generated
		 */
		private void refreshDecorators(List decorators) {
			final List decoratorsToRefresh = decorators;
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					try {
						TransactionUtil.getEditingDomain(diagramView)
								.runExclusive(new Runnable() {
									public void run() {
										for (Iterator it = decoratorsToRefresh
												.iterator(); it.hasNext();) {
											IDecorator decorator = (IDecorator) it
													.next();
											if (decorator != null) {
												decorator.refresh();
											}
										}
									}
								});
					} catch (Exception e) {
						PalladioComponentModelRepositoryDiagramEditorPlugin
								.getInstance().logError(
										"Decorator refresh failure", e); //$NON-NLS-1$
					}
				}
			});
		}

		/**
		 * @generated
		 */
		private boolean isRegistered() {
			return isRegistered;
		}

		/**
		 * @generated
		 */
		private String getType(IMarker marker) {
			try {
				return marker.getType();
			} catch (CoreException e) {
				PalladioComponentModelRepositoryDiagramEditorPlugin
						.getInstance().logError(
								"Validation marker refresh failure", e); //$NON-NLS-1$
				return ""; //$NON-NLS-1$
			}
		}
	}
}
