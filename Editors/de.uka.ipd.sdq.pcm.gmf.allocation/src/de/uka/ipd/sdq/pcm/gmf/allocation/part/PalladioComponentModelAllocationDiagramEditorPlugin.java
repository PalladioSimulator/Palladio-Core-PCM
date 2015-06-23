/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class PalladioComponentModelAllocationDiagramEditorPlugin extends org.eclipse.ui.plugin.AbstractUIPlugin {

	/**
 * @generated
 */
	public static final String ID = "de.uka.ipd.sdq.pcm.gmf.allocation"; //$NON-NLS-1$

	/**
 * @generated
 */
	public static final org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint DIAGRAM_PREFERENCES_HINT =
			new org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint(ID);

	/**
 * @generated
 */
	private static PalladioComponentModelAllocationDiagramEditorPlugin instance;

	/**
 * @generated
 */
	private org.eclipse.emf.edit.provider.ComposedAdapterFactory adapterFactory;	

	/**
 * @generated
 */
	private de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDocumentProvider documentProvider;


	/**
 * @generated
 */
	private de.uka.ipd.sdq.pcm.gmf.allocation.providers.ElementInitializers initializers;


	/**
 * @generated
 */
	public PalladioComponentModelAllocationDiagramEditorPlugin() {
	}

	/**
 * @generated
 */
	public void start(org.osgi.framework.BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());
		adapterFactory = createAdapterFactory();
	}

	/**
 * @generated
 */
	public void stop(org.osgi.framework.BundleContext context) throws Exception {
		adapterFactory.dispose();
		adapterFactory = null;
		initializers = null;
		instance = null;
		super.stop(context);
	}

	/**
 * @generated
 */
	public static PalladioComponentModelAllocationDiagramEditorPlugin getInstance() {
		return instance;
	}

	/**
 * @generated
 */
	protected org.eclipse.emf.edit.provider.ComposedAdapterFactory createAdapterFactory() {
		java.util.ArrayList<org.eclipse.emf.common.notify.AdapterFactory> factories = new java.util.ArrayList<org.eclipse.emf.common.notify.AdapterFactory>();
		fillItemProviderFactories(factories);
		return new org.eclipse.emf.edit.provider.ComposedAdapterFactory(factories);
	}

	/**
 * @generated
 */
	protected void fillItemProviderFactories(java.util.List<org.eclipse.emf.common.notify.AdapterFactory> factories) {
		factories.add(new de.uka.ipd.sdq.pcm.provider.PcmItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.core.provider.CoreItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.core.composition.provider.CompositionItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.usagemodel.provider.UsagemodelItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.resourcetype.provider.ResourcetypeItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.protocol.provider.ProtocolItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.parameter.provider.ParameterItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.reliability.provider.ReliabilityItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.seff.seff_performance.provider.SeffPerformanceItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.seff.seff_reliability.provider.SeffReliabilityItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.qosannotations.provider.QosannotationsItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.qosannotations.qos_performance.provider.QosPerformanceItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.provider.QosReliabilityItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.system.provider.SystemItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.resourceenvironment.provider.ResourceenvironmentItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.allocation.provider.AllocationItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.pcm.subsystem.provider.SubsystemItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.probfunction.provider.ProbfunctionItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.stoex.provider.StoexItemProviderAdapterFactory());
		factories.add(new de.uka.ipd.sdq.units.provider.UnitsItemProviderAdapterFactory());
		factories.add(new org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory());
		factories.add(new org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory());
	}

	/**
 * @generated
 */
	public org.eclipse.emf.common.notify.AdapterFactory getItemProvidersAdapterFactory() {
		return adapterFactory;
	}

	/**
 * @generated
 */
	public org.eclipse.jface.resource.ImageDescriptor getItemImageDescriptor(Object item) {
		org.eclipse.emf.edit.provider.IItemLabelProvider labelProvider =
				(org.eclipse.emf.edit.provider.IItemLabelProvider) adapterFactory.adapt(
						item, org.eclipse.emf.edit.provider.IItemLabelProvider.class);
		if (labelProvider != null) {
			return org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry.getInstance().getImageDescriptor(
					labelProvider.getImage(item));
		}
		return null;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @generated
	 * @param path the path
	 * @return the image descriptor
	 */
	public static org.eclipse.jface.resource.ImageDescriptor getBundledImageDescriptor(String path) {
		return org.eclipse.ui.plugin.AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
	}

	/**
	 * Respects images residing in any plug-in. If path is relative,
	 * then this bundle is looked up for the image, otherwise, for absolute 
	 * path, first segment is taken as id of plug-in with image
	 *
	 * @generated
	 * @param path the path to image, either absolute (with plug-in id as first segment), or relative for bundled images
	 * @return the image descriptor
	 */
	public static org.eclipse.jface.resource.ImageDescriptor findImageDescriptor(String path) {
		final org.eclipse.core.runtime.IPath p = new org.eclipse.core.runtime.Path(path);
		if (p.isAbsolute() && p.segmentCount() > 1) {
			return org.eclipse.ui.plugin.AbstractUIPlugin.imageDescriptorFromPlugin(
					p.segment(0), p.removeFirstSegments(1).makeAbsolute().toString());
		} else {
			return getBundledImageDescriptor(p.makeAbsolute().toString());
		} 
	}

	/**
	 * Returns an image for the image file at the given plug-in relative path.
	 * Client do not need to dispose this image. Images will be disposed automatically.
	 *
	 * @generated
	 * @param path the path
	 * @return image instance
	 */
	public org.eclipse.swt.graphics.Image getBundledImage(String path) {
		org.eclipse.swt.graphics.Image image = getImageRegistry().get(path);
		if (image == null) {
			getImageRegistry().put(path, getBundledImageDescriptor(path));
			image = getImageRegistry().get(path);
		}
		return image;
	}

	/**
	 * Returns string from plug-in's resource bundle
	 *
	 * @generated
	 */
	public static String getString(String key) {
		return org.eclipse.core.runtime.Platform.getResourceString(
				getInstance().getBundle(), "%" + key); //$NON-NLS-1$
	}

	/**
 * @generated
 */
	public de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDocumentProvider getDocumentProvider() {
		if (documentProvider == null) {
			documentProvider = new de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelDocumentProvider();
		}
		return documentProvider;
	}

	/**
 * @generated
 */
	public de.uka.ipd.sdq.pcm.gmf.allocation.providers.ElementInitializers getElementInitializers() {
		return initializers;
	}

	/**
 * @generated
 */
	public void setElementInitializers(de.uka.ipd.sdq.pcm.gmf.allocation.providers.ElementInitializers i) {
		this.initializers = i;
	}


	/**
 * @generated
 */
	public void logError(String error) {
		logError(error, null);
	}

	/**
 * @generated
 */
	public void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(new org.eclipse.core.runtime.Status(
				org.eclipse.core.runtime.IStatus.ERROR,
				PalladioComponentModelAllocationDiagramEditorPlugin.ID,
				org.eclipse.core.runtime.IStatus.OK,
				error, throwable));
		debug(error, throwable);
	}

	/**
 * @generated
 */
	public void logInfo(String message) {
		logInfo(message, null);
	}

	/**
 * @generated
 */
	public void logInfo(String message, Throwable throwable) {
		if (message == null && throwable != null) {
			message = throwable.getMessage();
		}
		getLog().log(new org.eclipse.core.runtime.Status(
				org.eclipse.core.runtime.IStatus.INFO,
				PalladioComponentModelAllocationDiagramEditorPlugin.ID,
				org.eclipse.core.runtime.IStatus.OK,
				message, throwable));
		debug(message, throwable);
	}

	/**
 * @generated
 */
	private void debug(String message, Throwable throwable) {
		if (!isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}
	}
