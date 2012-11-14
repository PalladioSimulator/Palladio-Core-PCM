/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

/**
 * The Class PalladioComponentModelDomainNavigatorItem.
 *
 * @generated
 */
public class PalladioComponentModelDomainNavigatorItem extends PlatformObject {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[] { EObject.class,
				IPropertySource.class };
		Platform.getAdapterManager().registerAdapters(
				new IAdapterFactory() {

					public Object getAdapter(Object adaptableObject,
							Class adapterType) {
						if (adaptableObject instanceof de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelDomainNavigatorItem) {
							de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelDomainNavigatorItem domainNavigatorItem = (de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelDomainNavigatorItem) adaptableObject;
							EObject eObject = domainNavigatorItem.getEObject();
							if (adapterType == EObject.class) {
								return eObject;
							}
							if (adapterType == IPropertySource.class) {
								return domainNavigatorItem
										.getPropertySourceProvider()
										.getPropertySource(eObject);
							}
						}

						return null;
					}

					public Class[] getAdapterList() {
						return supportedTypes;
					}
				},
				de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelDomainNavigatorItem.class);
	}

	/** The my parent. @generated */
	private Object myParent;

	/** The my e object. @generated */
	private EObject myEObject;

	/** The my property source provider. @generated */
	private IPropertySourceProvider myPropertySourceProvider;

	/**
	 * Instantiates a new palladio component model domain navigator item.
	 *
	 * @param eObject the e object
	 * @param parent the parent
	 * @param propertySourceProvider the property source provider
	 * @generated
	 */
	public PalladioComponentModelDomainNavigatorItem(EObject eObject,
			Object parent, IPropertySourceProvider propertySourceProvider) {
		myParent = parent;
		myEObject = eObject;
		myPropertySourceProvider = propertySourceProvider;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 * @generated
	 */
	public Object getParent() {
		return myParent;
	}

	/**
	 * Gets the e object.
	 *
	 * @return the e object
	 * @generated
	 */
	public EObject getEObject() {
		return myEObject;
	}

	/**
	 * Gets the property source provider.
	 *
	 * @return the property source provider
	 * @generated
	 */
	public IPropertySourceProvider getPropertySourceProvider() {
		return myPropertySourceProvider;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj instanceof de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelDomainNavigatorItem) {
			return EcoreUtil
					.getURI(getEObject())
					.equals(
							EcoreUtil
									.getURI(((de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelDomainNavigatorItem) obj)
											.getEObject()));
		}
		return super.equals(obj);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 * @generated
	 */
	public int hashCode() {
		return EcoreUtil.getURI(getEObject()).hashCode();
	}

}
