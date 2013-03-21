	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class PalladioComponentModelDocumentProvider extends org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider implements org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider {
	
		/**
 * @generated
 */
protected ElementInfo createElementInfo(Object element) throws org.eclipse.core.runtime.CoreException {
	if (false == element instanceof org.eclipse.ui.part.FileEditorInput && false == element instanceof org.eclipse.emf.common.ui.URIEditorInput) {
	throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 0, 
		org.eclipse.osgi.util.NLS.bind(
			de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_IncorrectInputError,
			new Object[] {element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput"}), //$NON-NLS-1$ //$NON-NLS-2$ 
		null));
}
	org.eclipse.ui.IEditorInput editorInput = (org.eclipse.ui.IEditorInput) element;
	org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument document = (org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) createDocument(editorInput);

	ResourceSetInfo info = new ResourceSetInfo(document, editorInput);
	info.setModificationStamp(computeModificationStamp(info));
	info.fStatus = null;
	return info;
}
	
		/**
 * @generated
 */
protected org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument createDocument(Object element) throws org.eclipse.core.runtime.CoreException {
	if (false == element instanceof org.eclipse.ui.part.FileEditorInput && false == element instanceof org.eclipse.emf.common.ui.URIEditorInput) {
	throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 0, 
		org.eclipse.osgi.util.NLS.bind(
			de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_IncorrectInputError,
			new Object[] {element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput"}), //$NON-NLS-1$ //$NON-NLS-2$ 
		null));
}
	org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document = createEmptyDocument();
	setDocumentContent(document, (org.eclipse.ui.IEditorInput) element);
	setupDocument(element, document);
	return document;
}
	
		/**
 * Sets up the given document as it would be provided for the given element. The
 * content of the document is not changed. This default implementation is empty.
 * Subclasses may reimplement.
 * 
 * @param element the blue-print element
 * @param document the document to set up
 * @generated
 */
protected void setupDocument(Object element, org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document) {
	// for subclasses
}
	
		/**
 * @generated
 */
private long computeModificationStamp(ResourceSetInfo info) {
	int result = 0;
	for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
			org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(nextResource);
		if (file != null) {
			if (file.getLocation() != null) {
				result += file.getLocation().toFile().lastModified();
			} else {
				result += file.getModificationStamp();
			}
		}
		}
	return result;
}
	
		/**
 * @generated
 */
protected org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument createEmptyDocument() {
	org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument document = new org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument();
	document.setEditingDomain(createEditingDomain());
	return document;
}
	
		/**
 * @generated
 */
private org.eclipse.emf.transaction.TransactionalEditingDomain createEditingDomain() {
	org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory.getInstance().createEditingDomain();
	editingDomain.setID("de.uka.ipd.sdq.pcm.gmf.allocation.EditingDomain"); //$NON-NLS-1$
	final org.eclipse.emf.transaction.NotificationFilter diagramResourceModifiedFilter = org.eclipse.emf.transaction.NotificationFilter.createNotifierFilter(editingDomain.getResourceSet()).and(org.eclipse.emf.transaction.NotificationFilter.createEventTypeFilter(org.eclipse.emf.common.notify.Notification.ADD)).and(org.eclipse.emf.transaction.NotificationFilter.createFeatureFilter(org.eclipse.emf.ecore.resource.ResourceSet.class, org.eclipse.emf.ecore.resource.ResourceSet.RESOURCE_SET__RESOURCES));
	editingDomain.getResourceSet().eAdapters().add(new org.eclipse.emf.common.notify.Adapter() {

		private org.eclipse.emf.common.notify.Notifier myTarger;

		public org.eclipse.emf.common.notify.Notifier getTarget() {
			return myTarger;
		}

		public boolean isAdapterForType(Object type) {
			return false;
		}

		public void notifyChanged(org.eclipse.emf.common.notify.Notification notification) {
			if (diagramResourceModifiedFilter.matches(notification)) {
				Object value = notification.getNewValue();
				if (value instanceof org.eclipse.emf.ecore.resource.Resource) {
					((org.eclipse.emf.ecore.resource.Resource) value).setTrackingModification(true);
				}
			}
		}

		public void setTarget(org.eclipse.emf.common.notify.Notifier newTarget) {
			myTarger = newTarget;
		}
			
	});	
	
	return editingDomain;
}
	
		/**
 * @generated
 */
protected void setDocumentContent(org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document, org.eclipse.ui.IEditorInput element) throws org.eclipse.core.runtime.CoreException {
	org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument diagramDocument = (org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) document;
	org.eclipse.emf.transaction.TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
	if (element instanceof org.eclipse.ui.part.FileEditorInput) {
		org.eclipse.core.resources.IStorage storage = ((org.eclipse.ui.part.FileEditorInput) element).getStorage();
		org.eclipse.gmf.runtime.notation.Diagram diagram = org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil.load(domain, storage, true, getProgressMonitor());
		document.setContent(diagram);
	} else if(element instanceof org.eclipse.emf.common.ui.URIEditorInput) {
		org.eclipse.emf.common.util.URI uri = ((org.eclipse.emf.common.ui.URIEditorInput) element).getURI();
		org.eclipse.emf.ecore.resource.Resource resource = null;
		try {
			resource = domain.getResourceSet().getResource(uri.trimFragment(), false);
			if (resource == null) {
				resource = domain.getResourceSet().createResource(uri.trimFragment());
			}
			if (!resource.isLoaded()) {
				try {
					java.util.Map options = new java.util.HashMap(org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory.getDefaultLoadOptions());
					// @see 171060 
					// options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
					resource.load(options);
				} catch (java.io.IOException e) {
					resource.unload();
					throw e;
				}
			}
			if (uri.fragment() != null) {
				org.eclipse.emf.ecore.EObject rootElement = resource.getEObject(uri.fragment());
				if (rootElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
					document.setContent((org.eclipse.gmf.runtime.notation.Diagram) rootElement);
					return;
				}
			} else {
				for (java.util.Iterator it = resource.getContents().iterator(); it.hasNext();) {
					Object rootElement = it.next();
					if (rootElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
						document.setContent((org.eclipse.gmf.runtime.notation.Diagram) rootElement);
						return;
					}
				}
			}
			throw new RuntimeException(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_NoDiagramInResourceError);
		} catch (Exception e) {
			org.eclipse.core.runtime.CoreException thrownExcp = null;
			if (e instanceof org.eclipse.core.runtime.CoreException) {
				thrownExcp = (org.eclipse.core.runtime.CoreException) e;
			} else {
				String msg = e.getLocalizedMessage();
				thrownExcp = new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 0, 
				msg != null ? msg : de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_DiagramLoadingError, e));
			}
			throw thrownExcp;
		}
	} else {
	throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 0, 
		org.eclipse.osgi.util.NLS.bind(
			de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_IncorrectInputError,
			new Object[] {element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput"}), //$NON-NLS-1$ //$NON-NLS-2$ 
		null));
	}	
}
	
		/**
 * @generated
 */
public long getModificationStamp(Object element) {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		return computeModificationStamp(info);
	}
	return super.getModificationStamp(element);
}
	
		/**
 * @generated
 */
public boolean isDeleted(Object element) {
	org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument document = getDiagramDocument(element);
	if (document != null) {
		org.eclipse.emf.ecore.resource.Resource diagramResource = document.getDiagram().eResource();
		if (diagramResource != null) {
				org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(diagramResource);
			return file == null || file.getLocation() == null || !file.getLocation().toFile().exists();
			}
	}
	return super.isDeleted(element);
}
	
		/**
 * @generated
 */
public ResourceSetInfo getResourceSetInfo(Object editorInput) {
	return (ResourceSetInfo) super.getElementInfo(editorInput);
}
	
		/**
 * @generated
 */
protected void disposeElementInfo(Object element, ElementInfo info) {
	if (info instanceof ResourceSetInfo) {
		ResourceSetInfo resourceSetInfo = (ResourceSetInfo) info;
		resourceSetInfo.dispose();
	}
	super.disposeElementInfo(element, info);
}
	
			/**
 * @generated
 */
protected void doValidateState(Object element, Object computationContext) throws org.eclipse.core.runtime.CoreException {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		java.util.LinkedList<org.eclipse.core.resources.IFile> files2Validate = new java.util.LinkedList<org.eclipse.core.resources.IFile>();
		for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
			org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(nextResource);
			if (file != null && file.isReadOnly()) {
				files2Validate.add(file);
			}
		}
		org.eclipse.core.resources.ResourcesPlugin.getWorkspace().validateEdit((org.eclipse.core.resources.IFile[]) files2Validate.toArray(new org.eclipse.core.resources.IFile[files2Validate.size()]), computationContext);
	}

	super.doValidateState(element, computationContext);
}
		
		/**
 * @generated
 */
public boolean isReadOnly(Object element) {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		if (info.isUpdateCache()) {
	try {
		updateCache(element);
	} catch (org.eclipse.core.runtime.CoreException ex) {
		de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_isModifiable, ex);
		// Error message to log was initially taken from org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.internal.l10n.EditorMessages.StorageDocumentProvider_isModifiable
	}
}
		return info.isReadOnly();
	}
	return super.isReadOnly(element);
}
	
		/**
 * @generated
 */
public boolean isModifiable(Object element) {
	if (!isStateValidated(element)) {
		if (element instanceof org.eclipse.ui.part.FileEditorInput || element instanceof org.eclipse.emf.common.ui.URIEditorInput) {
			return true;
		}
	}
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		if (info.isUpdateCache()) {
	try {
		updateCache(element);
	} catch (org.eclipse.core.runtime.CoreException ex) {
		de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_isModifiable, ex);
		// Error message to log was initially taken from org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.internal.l10n.EditorMessages.StorageDocumentProvider_isModifiable
	}
}
		return info.isModifiable();
	}
	return super.isModifiable(element);
}
	
		/**
 * @generated
 */
protected void updateCache(Object element) throws org.eclipse.core.runtime.CoreException {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
				org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(nextResource);
			if (file != null && file.isReadOnly()) {
					info.setReadOnly(true);
				info.setModifiable(false);
				return;
			}
		}
		info.setReadOnly(false);
		info.setModifiable(true);
		return;
	}
}
	
		/**
 * @generated
 */
protected void doUpdateStateCache(Object element) throws org.eclipse.core.runtime.CoreException {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		info.setUpdateCache(true);
	}
	super.doUpdateStateCache(element);
}
	
		/**
 * @generated
 */
public boolean isSynchronized(Object element) {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		return info.isSynchronized();
	}
	return super.isSynchronized(element);
}
			
			/**
 * @generated
 */
protected org.eclipse.core.runtime.jobs.ISchedulingRule getResetRule(Object element) {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		java.util.LinkedList<org.eclipse.core.runtime.jobs.ISchedulingRule> rules = new java.util.LinkedList<org.eclipse.core.runtime.jobs.ISchedulingRule>();
		for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
			org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(nextResource);
			if (file != null) {
				rules.add(org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(file));
			}
		}
		return new org.eclipse.core.runtime.jobs.MultiRule((org.eclipse.core.runtime.jobs.ISchedulingRule[]) rules.toArray(new org.eclipse.core.runtime.jobs.ISchedulingRule[rules.size()]));
	}
	return null;
}
	
			/**
 * @generated
 */
protected org.eclipse.core.runtime.jobs.ISchedulingRule getSaveRule(Object element) {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		java.util.LinkedList<org.eclipse.core.runtime.jobs.ISchedulingRule> rules = new java.util.LinkedList<org.eclipse.core.runtime.jobs.ISchedulingRule>();
		for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
			org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(nextResource);
			if (file != null) {
				rules.add(computeSchedulingRule(file));
			}
		}
		return new org.eclipse.core.runtime.jobs.MultiRule((org.eclipse.core.runtime.jobs.ISchedulingRule[]) rules.toArray(new org.eclipse.core.runtime.jobs.ISchedulingRule[rules.size()]));
	}
	return null;
}
	
			/**
 * @generated
 */
protected org.eclipse.core.runtime.jobs.ISchedulingRule getSynchronizeRule(Object element) {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		java.util.LinkedList<org.eclipse.core.runtime.jobs.ISchedulingRule> rules = new java.util.LinkedList<org.eclipse.core.runtime.jobs.ISchedulingRule>();
		for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
			org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(nextResource);
			if (file != null) {
				rules.add(org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRuleFactory().refreshRule(file));
			}
		}
		return new org.eclipse.core.runtime.jobs.MultiRule((org.eclipse.core.runtime.jobs.ISchedulingRule[]) rules.toArray(new org.eclipse.core.runtime.jobs.ISchedulingRule[rules.size()]));
	}
	return null;
}
	
			/**
 * @generated
 */
protected org.eclipse.core.runtime.jobs.ISchedulingRule getValidateStateRule(Object element) {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		java.util.LinkedList<org.eclipse.core.runtime.jobs.ISchedulingRule> files = new java.util.LinkedList<org.eclipse.core.runtime.jobs.ISchedulingRule>();
		for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
			org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(nextResource);
			if (file != null) {
				files.add(file);
			}
		}
		return org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRuleFactory().validateEditRule((org.eclipse.core.resources.IFile[]) files.toArray(new org.eclipse.core.resources.IFile[files.size()]));
	}
	return null;
}
	
			/**
 * @generated
 */
private org.eclipse.core.runtime.jobs.ISchedulingRule computeSchedulingRule(org.eclipse.core.resources.IResource toCreateOrModify) {
	if (toCreateOrModify.exists())
		return org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(toCreateOrModify);

	org.eclipse.core.resources.IResource parent = toCreateOrModify;
	do {
		/*
		 * XXX This is a workaround for
		 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=67601
		 * IResourceRuleFactory.createRule should iterate the hierarchy
		 * itself.
		 */
		toCreateOrModify = parent;
		parent = toCreateOrModify.getParent();
	} while (parent != null && !parent.exists());

	return org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRuleFactory().createRule(toCreateOrModify);
}
		
		/**
 * @generated
 */
protected void doSynchronize(Object element, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
			handleElementChanged(info, nextResource, monitor);	
		}
		return;
	}
	super.doSynchronize(element, monitor);
}
	
		/**
 * @generated
 */
protected void doSaveDocument(org.eclipse.core.runtime.IProgressMonitor monitor, Object element, org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document, boolean overwrite) throws org.eclipse.core.runtime.CoreException {
	ResourceSetInfo info = getResourceSetInfo(element);
	if (info != null) {
		if (!overwrite && !info.isSynchronized()) {
			throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 
				org.eclipse.core.resources.IResourceStatus.OUT_OF_SYNC_LOCAL, 
				de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_UnsynchronizedFileSaveError, 
				null));
		}
			info.stopResourceListening();
			fireElementStateChanging(element);
		try {
			monitor.beginTask(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_SaveDiagramTask, info.getResourceSet().getResources().size() + 1); //"Saving diagram"
			for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource nextResource = it.next();
				monitor.setTaskName(org.eclipse.osgi.util.NLS.bind(
						de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_SaveNextResourceTask, 
						nextResource.getURI()));
				if (nextResource.isLoaded() && !info.getEditingDomain().isReadOnly(nextResource)) {
					try {
						nextResource.save(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramEditorUtil.getSaveOptions());
					} catch (java.io.IOException e) {
						fireElementStateChangeFailed(element);
						throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.EditorStatusCodes.RESOURCE_FAILURE, e.getLocalizedMessage(), null));
					}
				}
				monitor.worked(1);
			}
			monitor.done();
			info.setModificationStamp(computeModificationStamp(info));
		} catch (RuntimeException x) {
			fireElementStateChangeFailed(element);
			throw x;
		}  finally {
			info.startResourceListening();
		} 
	} else {
		org.eclipse.emf.common.util.URI newResoruceURI;
		java.util.List<org.eclipse.core.resources.IFile> affectedFiles = null;
		if (element instanceof org.eclipse.ui.part.FileEditorInput) {
			org.eclipse.core.resources.IFile newFile = ((org.eclipse.ui.part.FileEditorInput) element).getFile();
			affectedFiles = java.util.Collections.singletonList(newFile);
			newResoruceURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
		} else if(element instanceof org.eclipse.emf.common.ui.URIEditorInput) {
			newResoruceURI = ((org.eclipse.emf.common.ui.URIEditorInput) element).getURI();
		} else {
			fireElementStateChangeFailed(element);
			throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 0, 
		org.eclipse.osgi.util.NLS.bind(
			de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_IncorrectInputError,
			new Object[] {element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput"}), //$NON-NLS-1$ //$NON-NLS-2$ 
		null));
		}
		if (false == document instanceof org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) {
			fireElementStateChangeFailed(element);
			throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 0,
			"Incorrect document used: " + document + " instead of org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument", null)); //$NON-NLS-1$ //$NON-NLS-2$
		}
		org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument diagramDocument = (org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) document;
		final org.eclipse.emf.ecore.resource.Resource newResource = diagramDocument.getEditingDomain().getResourceSet().createResource(newResoruceURI);
		final org.eclipse.gmf.runtime.notation.Diagram diagramCopy = (org.eclipse.gmf.runtime.notation.Diagram) org.eclipse.emf.ecore.util.EcoreUtil.copy(diagramDocument.getDiagram());
		try {
			new org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand(diagramDocument.getEditingDomain(), org.eclipse.osgi.util.NLS.bind(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_SaveAsOperation, diagramCopy.getName()), affectedFiles) {
				protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {
					newResource.getContents().add(diagramCopy);					
					return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult();
				}
			}.execute(monitor, null);
			newResource.save(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDiagramEditorUtil.getSaveOptions());
		} catch (org.eclipse.core.commands.ExecutionException e) {
			fireElementStateChangeFailed(element);
			throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 0, e.getLocalizedMessage(), null));
		} catch (java.io.IOException e) {
			fireElementStateChangeFailed(element);
			throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.ID, 0, e.getLocalizedMessage(), null));
		}
		newResource.unload();
	}
}
	
		/**
 * @generated
 */
protected void handleElementChanged(ResourceSetInfo info, org.eclipse.emf.ecore.resource.Resource changedResource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.core.resources.IFile file = org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(changedResource);
	if (file != null) {
		try {
			file.refreshLocal(org.eclipse.core.resources.IResource.DEPTH_INFINITE, monitor);
		} catch (org.eclipse.core.runtime.CoreException ex) {
			de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelAllocationDiagramEditorPlugin.getInstance().logError(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.PalladioComponentModelDocumentProvider_handleElementContentChanged, ex);
			// Error message to log was initially taken from org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.internal.l10n.EditorMessages.FileDocumentProvider_handleElementContentChanged
		}
	}
		changedResource.unload();
	
	fireElementContentAboutToBeReplaced(info.getEditorInput());
	removeUnchangedElementListeners(info.getEditorInput(), info);
	info.fStatus = null;
	try {
		setDocumentContent(info.fDocument, info.getEditorInput());
	} catch (org.eclipse.core.runtime.CoreException e) {
		info.fStatus = e.getStatus();
	}
	if (!info.fCanBeSaved) {
		info.setModificationStamp(computeModificationStamp(info));
	}
	addUnchangedElementListeners(info.getEditorInput(), info);
	fireElementContentReplaced(info.getEditorInput());
}

		/**
 * @generated
 */
protected void handleElementMoved(org.eclipse.ui.IEditorInput input, org.eclipse.emf.common.util.URI uri) {
	if (input instanceof org.eclipse.ui.part.FileEditorInput) {
		org.eclipse.core.resources.IFile newFile = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().getFile(new org.eclipse.core.runtime.Path(org.eclipse.emf.common.util.URI.decode(uri.path())).removeFirstSegments(1));
		fireElementMoved(input, newFile == null ? null : new org.eclipse.ui.part.FileEditorInput(newFile));
		return;
	}
	// TODO: append suffix to the URI! (use diagram as a parameter)
	fireElementMoved(input, new org.eclipse.emf.common.ui.URIEditorInput(uri));
}

		/**
 * @generated
 */
public org.eclipse.ui.IEditorInput createInputWithEditingDomain(org.eclipse.ui.IEditorInput editorInput, org.eclipse.emf.transaction.TransactionalEditingDomain domain) {
	return editorInput;
}

		/**
 * @generated
 */
public org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument getDiagramDocument(Object element) {
	org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument doc = getDocument(element);
	if (doc instanceof org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) {
		return (org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) doc;
	}
	return null;
}
	
		/**
 * @generated
 */
protected org.eclipse.jface.operation.IRunnableContext getOperationRunner(org.eclipse.core.runtime.IProgressMonitor monitor) {
	return null;
}
		
		/**
 * @generated
 */	
protected class ResourceSetInfo extends ElementInfo {

		/**
 * @generated
 */
 	private long myModificationStamp = org.eclipse.core.resources.IResource.NULL_STAMP;

			/**
 * @generated
 */
		private org.eclipse.emf.workspace.util.WorkspaceSynchronizer mySynchronizer;

		/**
 * @generated
 */
		private java.util.LinkedList<org.eclipse.emf.ecore.resource.Resource> myUnSynchronizedResources = new java.util.LinkedList<org.eclipse.emf.ecore.resource.Resource>();
	
		/**
 * @generated
 */
	private org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument myDocument;

	/**
 * @generated
 */
	private org.eclipse.ui.IEditorInput myEditorInput;
		
	/**
 * @generated
 */
	private boolean myUpdateCache = true;
	
	/**
 * @generated
 */
	private boolean myModifiable = false;

	/**
 * @generated
 */
	private boolean myReadOnly = true;
	
	/**
 * @generated
 */
	private ResourceSetModificationListener myResourceSetListener;
	
		/**
 * @generated
 */
public ResourceSetInfo(org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument document, org.eclipse.ui.IEditorInput editorInput) {
	super(document);
	myDocument = document;
	myEditorInput = editorInput;
		startResourceListening();
		myResourceSetListener = new ResourceSetModificationListener(this);
	getResourceSet().eAdapters().add(myResourceSetListener);
}

		/**
 * @generated
 */
public long getModificationStamp() {
	return myModificationStamp;
}

		/**
 * @generated
 */
public void setModificationStamp(long modificationStamp) {
	myModificationStamp = modificationStamp;
}
	
		/**
 * @generated
 */
public org.eclipse.emf.transaction.TransactionalEditingDomain getEditingDomain() {
	return myDocument.getEditingDomain();
}

		/**
 * @generated
 */
public org.eclipse.emf.ecore.resource.ResourceSet getResourceSet() {
	return getEditingDomain().getResourceSet();
}
	
		/**
 * @generated
 */
public java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> getLoadedResourcesIterator() {
	return new java.util.ArrayList<org.eclipse.emf.ecore.resource.Resource>(getResourceSet().getResources()).iterator();
}

		/**
 * @generated
 */
public org.eclipse.ui.IEditorInput getEditorInput() {
	return myEditorInput;
}

		/**
 * @generated
 */
public void dispose() {
		stopResourceListening();
		getResourceSet().eAdapters().remove(myResourceSetListener);
	for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = getLoadedResourcesIterator(); it.hasNext();) {
	org.eclipse.emf.ecore.resource.Resource resource = it.next();
		resource.unload();
	}
	getEditingDomain().dispose();
}

		/**
 * @generated
 */
public boolean isSynchronized() {
		return myUnSynchronizedResources.size() == 0;
	}

				/**
 * @generated
 */
public void setUnSynchronized(org.eclipse.emf.ecore.resource.Resource resource) {
	myUnSynchronizedResources.add(resource);
}

			/**
 * @generated
 */
public void setSynchronized(org.eclipse.emf.ecore.resource.Resource resource) {
	myUnSynchronizedResources.remove(resource);
}

			/**
 * @generated
 */
public final void stopResourceListening() {
	mySynchronizer.dispose();
	mySynchronizer = null;
}

			/**
 * @generated
 */
public final void startResourceListening() {
	mySynchronizer = new org.eclipse.emf.workspace.util.WorkspaceSynchronizer(getEditingDomain(), new SynchronizerDelegate());
}
	
			/**
 * @generated
 */
public boolean isUpdateCache() {
	return myUpdateCache;
}
	
		/**
 * @generated
 */
public void setUpdateCache(boolean update) {
	myUpdateCache = update;
}
	
		/**
 * @generated
 */
public boolean isModifiable() {
	return myModifiable;
}
	
		/**
 * @generated
 */
public void setModifiable(boolean modifiable) {
	myModifiable = modifiable;
}
	
		/**
 * @generated
 */
public boolean isReadOnly() {
	return myReadOnly;
}
	
		/**
 * @generated
 */
public void setReadOnly(boolean readOnly) {
	myReadOnly = readOnly;
}

				/**
 * @generated
 */	
private class SynchronizerDelegate implements org.eclipse.emf.workspace.util.WorkspaceSynchronizer.Delegate {

		/**
 * @generated
 */
public void dispose() {
}

		/**
 * @generated
 */
public boolean handleResourceChanged(final org.eclipse.emf.ecore.resource.Resource resource) {
	synchronized (ResourceSetInfo.this) {
	if (ResourceSetInfo.this.fCanBeSaved) {
		ResourceSetInfo.this.setUnSynchronized(resource);
		return true;
	}
}
	org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {
		public void run() {
			handleElementChanged(ResourceSetInfo.this, resource, null);
		}
	});
	return true;
}

		/**
 * @generated
 */
public boolean handleResourceDeleted(org.eclipse.emf.ecore.resource.Resource resource) {
	synchronized (ResourceSetInfo.this) {
	if (ResourceSetInfo.this.fCanBeSaved) {
		ResourceSetInfo.this.setUnSynchronized(resource);
		return true;
	}
}
	org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {
		public void run() {
			fireElementDeleted(ResourceSetInfo.this.getEditorInput());
		}
	});
	return true;
}

		/**
 * @generated
 */
public boolean handleResourceMoved(org.eclipse.emf.ecore.resource.Resource resource, final org.eclipse.emf.common.util.URI newURI) {
	synchronized (ResourceSetInfo.this) {
	if (ResourceSetInfo.this.fCanBeSaved) {
		ResourceSetInfo.this.setUnSynchronized(resource);
		return true;
	}
}
	if (myDocument.getDiagram().eResource() == resource) {
		org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {
			public void run() {
				handleElementMoved(ResourceSetInfo.this.getEditorInput(), newURI);
			}
		});
	} else {
		handleResourceDeleted(resource);
	}
	return true;
}
	
	}
		
		}
	
		/**
 * @generated
 */	
private class ResourceSetModificationListener extends org.eclipse.emf.ecore.util.EContentAdapter {

			/**
 * @generated
 */	
		private org.eclipse.emf.transaction.NotificationFilter myModifiedFilter;

		/**
 * @generated
 */	
		private ResourceSetInfo myInfo;
	
		/**
 * @generated
 */	
public ResourceSetModificationListener(ResourceSetInfo info) {
	myInfo = info;
	myModifiedFilter = org.eclipse.emf.transaction.NotificationFilter.createEventTypeFilter(org.eclipse.emf.common.notify.Notification.SET).or(org.eclipse.emf.transaction.NotificationFilter.createEventTypeFilter(org.eclipse.emf.common.notify.Notification.UNSET)).and(org.eclipse.emf.transaction.NotificationFilter.createFeatureFilter(org.eclipse.emf.ecore.resource.Resource.class, org.eclipse.emf.ecore.resource.Resource.RESOURCE__IS_MODIFIED));
}
	
		/**
 * @generated
 */	
public void notifyChanged(org.eclipse.emf.common.notify.Notification notification) {
	if (notification.getNotifier() instanceof org.eclipse.emf.ecore.resource.ResourceSet) {
		super.notifyChanged(notification);
	}
	if (!notification.isTouch() && myModifiedFilter.matches(notification)) {
		if (notification.getNotifier() instanceof org.eclipse.emf.ecore.resource.Resource) {
			org.eclipse.emf.ecore.resource.Resource resource = (org.eclipse.emf.ecore.resource.Resource) notification.getNotifier();
			if (resource.isLoaded()) {
				boolean modified = false;
				for (java.util.Iterator/*<org.eclipse.emf.ecore.resource.Resource>*/ it = myInfo.getLoadedResourcesIterator(); it.hasNext() && !modified;) {
					org.eclipse.emf.ecore.resource.Resource nextResource = (org.eclipse.emf.ecore.resource.Resource) it.next();
					if (nextResource.isLoaded()) {
						modified = nextResource.isModified();
					}
				}
				boolean dirtyStateChanged = false;
				synchronized (myInfo) {
					if (modified != myInfo.fCanBeSaved) {
						myInfo.fCanBeSaved = modified;
						dirtyStateChanged = true;
					}
						if (!resource.isModified()) {
						myInfo.setSynchronized(resource);
					}
					}
				if (dirtyStateChanged) {
					fireElementDirtyStateChanged(myInfo.getEditorInput(), modified);
	
					if (!modified) {
						myInfo.setModificationStamp(computeModificationStamp(myInfo));
					}
				}
			}
		}
	}
}

	}

	}
