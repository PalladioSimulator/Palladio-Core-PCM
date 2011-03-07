/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InterfaceSignatureListEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RepositoryEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.RequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.SignatureEditPart;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import java.io.IOException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.commands.operations.OperationHistoryFactory;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.eclipse.emf.edit.provider.IWrapperItemProvider;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;

import org.eclipse.gmf.runtime.diagram.core.services.ViewService;

import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import org.eclipse.ui.ide.IDE;

/**
 * @generated
 */
public class PcmNewDiagramFileWizard extends Wizard {

	/**
	 * @generated
	 */
	private TransactionalEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WizardNewFileCreationPage myFileCreationPage;

	/**
	 * @generated
	 */
	private IFile mySelectedModelFile;

	/**
	 * @generated
	 */
	private IWorkbenchPage myWorkbenchPage;

	/**
	 * @generated
	 */
	private IStructuredSelection mySelection;

	/**
	 * @generated
	 */
	private EObject myDiagramRoot;

	/**
	 * @generated
	 */
	public PcmNewDiagramFileWizard(IFile selectedModelFile,
			IWorkbenchPage workbenchPage, IStructuredSelection selection,
			EObject diagramRoot, TransactionalEditingDomain editingDomain) {
		assert selectedModelFile != null : "Null selectedModelFile in PcmNewDiagramFileWizard constructor"; //$NON-NLS-1$
		assert workbenchPage != null : "Null workbenchPage in PcmNewDiagramFileWizard constructor"; //$NON-NLS-1$
		assert selection != null : "Null selection in PcmNewDiagramFileWizard constructor"; //$NON-NLS-1$
		assert diagramRoot != null : "Null diagramRoot in PcmNewDiagramFileWizard constructor"; //$NON-NLS-1$
		assert editingDomain != null : "Null editingDomain in PcmNewDiagramFileWizard constructor"; //$NON-NLS-1$

		mySelectedModelFile = selectedModelFile;
		myWorkbenchPage = workbenchPage;
		mySelection = selection;
		myDiagramRoot = diagramRoot;
		myEditingDomain = editingDomain;
	}

	/**
	 * @generated
	 */
	public void addPages() {
		myFileCreationPage = new WizardNewFileCreationPage(
				"Initialize new Ecore diagram file", mySelection) {

			public void createControl(Composite parent) {
				super.createControl(parent);

				IContainer parentContainer = mySelectedModelFile.getParent();
				String originalFileName = mySelectedModelFile
						.getProjectRelativePath().removeFileExtension()
						.lastSegment();
				String fileExtension = ".repository_diagram"; //$NON-NLS-1$
				String fileName = originalFileName + fileExtension;
				for (int i = 1; parentContainer.getFile(new Path(fileName))
						.exists(); i++) {
					fileName = originalFileName + i + fileExtension;
				}
				setFileName(fileName);
			}

		};
		myFileCreationPage.setTitle("Diagram file");
		myFileCreationPage.setDescription("Create new diagram based on "
				+ RepositoryEditPart.MODEL_ID + " model content");
		addPage(myFileCreationPage);
		addPage(new RootElementSelectorPage());
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		IFile diagramFile = myFileCreationPage.createNewFile();
		try {
			diagramFile.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
		} catch (CoreException e) {
			RepositoryDiagramEditorPlugin.getInstance().logError(
					"Unable to set charset for diagram file", e); //$NON-NLS-1$
		}

		ResourceSet resourceSet = myEditingDomain.getResourceSet();
		final Resource diagramResource = resourceSet
				.createResource(URI.createPlatformResourceURI(diagramFile
						.getFullPath().toString()));

		List affectedFiles = new LinkedList();
		affectedFiles.add(mySelectedModelFile);
		affectedFiles.add(diagramFile);

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				myEditingDomain, "Initializing diagram contents", affectedFiles) { //$NON-NLS-1$
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				int diagramVID = PcmVisualIDRegistry
						.getDiagramVisualID(myDiagramRoot);
				if (diagramVID != RepositoryEditPart.VISUAL_ID) {
					return CommandResult
							.newErrorCommandResult("Incorrect model object stored as a root resource object"); //$NON-NLS-1$
				}
				Diagram diagram = ViewService.createDiagram(myDiagramRoot,
						RepositoryEditPart.MODEL_ID,
						RepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);
				initDiagramContents(diagram, myDiagramRoot);
				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
			diagramResource.save(Collections.EMPTY_MAP);
			IDE.openEditor(myWorkbenchPage, diagramFile);
		} catch (ExecutionException e) {
			RepositoryDiagramEditorPlugin.getInstance().logError(
					"Unable to create model and diagram", e); //$NON-NLS-1$
		} catch (IOException ex) {
			RepositoryDiagramEditorPlugin
					.getInstance()
					.logError(
							"Save operation failed for: " + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$
		} catch (PartInitException ex) {
			RepositoryDiagramEditorPlugin.getInstance().logError(
					"Unable to open editor", ex); //$NON-NLS-1$
		}
		return true;
	}

	/**
	 * @generated
	 */
	private Collection myLinkDescriptors = new LinkedList();

	/**
	 * @generated
	 */
	private Map myEObject2NodeMap = new HashMap();

	/**
	 * @generated
	 */
	private void initDiagramContents(Diagram diagram, EObject diagramModelObject) {
		createRepository_79Children(diagram, diagramModelObject);

		createLinks(diagram);
	}

	/**
	 * @generated
	 */
	private void createInterface_1001Children(View viewObject,
			EObject modelObject) {

		Node nextCompartment = getCompartment(viewObject, PcmVisualIDRegistry
				.getType(InterfaceSignatureListEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createInterfaceSignatureList_5001Children(nextCompartment,
					modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createBasicComponent_1002Children(View viewObject,
			EObject modelObject) {

		Node nextCompartment = getCompartment(viewObject, PcmVisualIDRegistry
				.getType(BasicComponentSEFFCompartmentEditPart.VISUAL_ID));
		if (nextCompartment != null) {
			createBasicComponentSEFFCompartment_5002Children(nextCompartment,
					modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createSignature_2001Children(View viewObject,
			EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createResourceDemandingSEFF_2002Children(View viewObject,
			EObject modelObject) {

		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createInterfaceSignatureList_5001Children(View viewObject,
			EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Interface) modelObject)
				.getSignatures__Interface().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = PcmVisualIDRegistry
					.getNodeVisualID(viewObject, nextValue);
			if (SignatureEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue,
						PcmVisualIDRegistry
								.getType(SignatureEditPart.VISUAL_ID),
						RepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createSignature_2001Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createBasicComponentSEFFCompartment_5002Children(
			View viewObject, EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((BasicComponent) modelObject)
				.getServiceEffectSpecifications__BasicComponent().iterator(); values
				.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = PcmVisualIDRegistry
					.getNodeVisualID(viewObject, nextValue);
			if (ResourceDemandingSEFFEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService
						.createNode(
								viewObject,
								nextValue,
								PcmVisualIDRegistry
										.getType(ResourceDemandingSEFFEditPart.VISUAL_ID),
								RepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createResourceDemandingSEFF_2002Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createRepository_79Children(View viewObject,
			EObject modelObject) {
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Repository) modelObject)
				.getInterfaces__Repository().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = PcmVisualIDRegistry
					.getNodeVisualID(viewObject, nextValue);
			if (InterfaceEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue,
						PcmVisualIDRegistry
								.getType(InterfaceEditPart.VISUAL_ID),
						RepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createInterface_1001Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((Repository) modelObject)
				.getComponents__Repository().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = PcmVisualIDRegistry
					.getNodeVisualID(viewObject, nextValue);
			if (BasicComponentEditPart.VISUAL_ID == nodeVID) {
				Node nextNode = ViewService.createNode(viewObject, nextValue,
						PcmVisualIDRegistry
								.getType(BasicComponentEditPart.VISUAL_ID),
						RepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createBasicComponent_1002Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private Node getCompartment(View node, String name) {
		for (Iterator it = node.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView instanceof Node && name.equals(nextView.getType())) {
				return (Node) nextView;
			}
		}
		return null;
	}

	/**
	 *@generated
	 */
	private void storeLinks(EObject container, Diagram diagram) {
		EClass containerMetaclass = container.eClass();
		storeFeatureModelFacetLinks(container, containerMetaclass, diagram);
		storeTypeModelFacetLinks(container, containerMetaclass);
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks(EObject container,
			EClass containerMetaclass) {
		if (RepositoryPackage.eINSTANCE.getProvidesComponentType()
				.isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((ProvidesComponentType) container)
					.getProvidedRoles__ProvidesComponentType().iterator(); values
					.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = PcmVisualIDRegistry
						.getLinkWithClassVisualID(nextValue);
				if (ProvidedRoleEditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((ProvidedRole) nextValue)
							.getProvidedInterface__ProvidedRole();
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						structuralFeatureResult = ((ProvidedRole) nextValue)
								.getProvidingComponent__ProvidedRole();
						if (structuralFeatureResult instanceof EObject) {
							EObject src = (EObject) structuralFeatureResult;
							myLinkDescriptors.add(new LinkDescriptor(src, dst,
									nextValue, linkVID));
						}
					}
				}
			}
		}
		if (RepositoryPackage.eINSTANCE.getProvidesComponentType()
				.isSuperTypeOf(containerMetaclass)) {
			for (Iterator values = ((ProvidesComponentType) container)
					.getRequiredRoles_ProvidesComponentType().iterator(); values
					.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = PcmVisualIDRegistry
						.getLinkWithClassVisualID(nextValue);
				if (RequiredRoleEditPart.VISUAL_ID == linkVID) {
					Object structuralFeatureResult = ((RequiredRole) nextValue)
							.getRequiredInterface__RequiredRole();
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						EObject src = container;
						myLinkDescriptors.add(new LinkDescriptor(src, dst,
								nextValue, linkVID));
					}
				}
			}
		}
	}

	/**
	 *@generated
	 */
	private void storeFeatureModelFacetLinks(EObject container,
			EClass containerMetaclass, Diagram diagram) {

	}

	/**
	 * @generated
	 */
	private void createLinks(Diagram diagram) {
		for (Iterator it = myLinkDescriptors.iterator(); it.hasNext();) {
			LinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();
			Edge edge = (Edge) ViewService.getInstance().createEdge(
					nextLinkDescriptor.getSemanticAdapter(), diagram,
					String.valueOf(nextLinkDescriptor.getVisualID()),
					ViewUtil.APPEND,
					RepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			if (edge != null) {
				edge.setSource((Node) myEObject2NodeMap.get(nextLinkDescriptor
						.getSource()));
				edge.setTarget((Node) myEObject2NodeMap.get(nextLinkDescriptor
						.getDestination()));
			}
		}
	}

	/**
	 * @generated
	 */
	private class LinkDescriptor {

		/**
		 * @generated
		 */
		private EObject mySource;

		/**
		 * @generated
		 */
		private EObject myDestination;

		/**
		 * @generated
		 */
		private EObject myLinkElement;

		/**
		 * @generated
		 */
		private int myVisualID;

		/**
		 * @generated
		 */
		private IAdaptable mySemanticAdapter;

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination,
				EObject linkElement, int linkVID) {
			this(source, destination, linkVID);
			myLinkElement = linkElement;
			mySemanticAdapter = new EObjectAdapter(linkElement);
		}

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination,
				IElementType elementType, int linkVID) {
			this(source, destination, linkVID);
			myLinkElement = null;
			final IElementType elementTypeCopy = elementType;
			mySemanticAdapter = new IAdaptable() {
				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return elementTypeCopy;
					}
					return null;
				}
			};
		}

		/**
		 * @generated
		 */
		private LinkDescriptor(EObject source, EObject destination, int linkVID) {
			mySource = source;
			myDestination = destination;
			myVisualID = linkVID;
		}

		/**
		 * @generated
		 */
		protected EObject getSource() {
			return mySource;
		}

		/**
		 * @generated
		 */
		protected EObject getDestination() {
			return myDestination;
		}

		/**
		 * @generated
		 */
		protected EObject getLinkElement() {
			return myLinkElement;
		}

		/**
		 * @generated
		 */
		protected int getVisualID() {
			return myVisualID;
		}

		/**
		 * @generated
		 */
		protected IAdaptable getSemanticAdapter() {
			return mySemanticAdapter;
		}
	}

	/**
	 * @generated
	 */
	private class RootElementSelectorPage extends WizardPage implements
			ISelectionChangedListener {

		/**
		 * @generated
		 */
		protected RootElementSelectorPage() {
			super("Select diagram root element");
			setTitle("Diagram root element");
			setDescription("Select semantic model element to be depicted on diagram");
		}

		/**
		 * @generated
		 */
		public void createControl(Composite parent) {
			initializeDialogUnits(parent);
			Composite topLevel = new Composite(parent, SWT.NONE);
			topLevel.setLayout(new GridLayout());
			topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
					| GridData.HORIZONTAL_ALIGN_FILL));
			topLevel.setFont(parent.getFont());
			setControl(topLevel);
			createModelBrowser(topLevel);
			setPageComplete(validatePage());
		}

		/**
		 * @generated
		 */
		private void createModelBrowser(Composite parent) {
			Composite panel = new Composite(parent, SWT.NONE);
			panel.setLayoutData(new GridData(GridData.FILL_BOTH));
			GridLayout layout = new GridLayout();
			layout.marginWidth = 0;
			panel.setLayout(layout);

			Label label = new Label(panel, SWT.NONE);
			label.setText("Select diagram root element:");
			label.setLayoutData(new GridData(
					GridData.HORIZONTAL_ALIGN_BEGINNING));

			TreeViewer treeViewer = new TreeViewer(panel, SWT.SINGLE
					| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
			GridData layoutData = new GridData(GridData.FILL_BOTH);
			layoutData.heightHint = 300;
			layoutData.widthHint = 300;
			treeViewer.getTree().setLayoutData(layoutData);
			treeViewer.setContentProvider(new AdapterFactoryContentProvider(
					RepositoryDiagramEditorPlugin.getInstance()
							.getItemProvidersAdapterFactory()));
			treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
					RepositoryDiagramEditorPlugin.getInstance()
							.getItemProvidersAdapterFactory()));
			treeViewer.setInput(myDiagramRoot.eResource());
			treeViewer.setSelection(new StructuredSelection(myDiagramRoot));
			treeViewer.addSelectionChangedListener(this);
		}

		/**
		 * @generated
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			myDiagramRoot = null;
			if (event.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				if (selection.size() == 1) {
					Object selectedElement = selection.getFirstElement();
					if (selectedElement instanceof IWrapperItemProvider) {
						selectedElement = ((IWrapperItemProvider) selectedElement)
								.getValue();
					}
					if (selectedElement instanceof FeatureMap.Entry) {
						selectedElement = ((FeatureMap.Entry) selectedElement)
								.getValue();
					}
					if (selectedElement instanceof EObject) {
						myDiagramRoot = (EObject) selectedElement;
					}
				}
			}
			setPageComplete(validatePage());
		}

		/**
		 * @generated
		 */
		private boolean validatePage() {
			if (myDiagramRoot == null) {
				setErrorMessage("No diagram root element selected");
				return false;
			}
			boolean result = ViewService
					.getInstance()
					.provides(
							new CreateDiagramViewOperation(
									new EObjectAdapter(myDiagramRoot),
									RepositoryEditPart.MODEL_ID,
									RepositoryDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
			setErrorMessage(result ? null
					: "Invalid diagram root element was selected");
			return result;
		}

	}
}