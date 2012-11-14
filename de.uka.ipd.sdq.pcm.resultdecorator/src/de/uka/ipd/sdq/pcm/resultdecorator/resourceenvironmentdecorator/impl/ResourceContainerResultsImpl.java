/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container Results</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceContainerResultsImpl#getResourceContainer_ResourceContainerResults <em>Resource Container Resource Container Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceContainerResultsImpl extends ActiveResourceUtilisationResultImpl implements ResourceContainerResults {
	/**
	 * The cached value of the '{@link #getResourceContainer_ResourceContainerResults() <em>Resource Container Resource Container Results</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceContainer_ResourceContainerResults()
	 * @generated
	 * @ordered
	 */
	protected ResourceContainer resourceContainer_ResourceContainerResults;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceContainerResultsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentdecoratorPackage.Literals.RESOURCE_CONTAINER_RESULTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer getResourceContainer_ResourceContainerResults() {
		if (resourceContainer_ResourceContainerResults != null && resourceContainer_ResourceContainerResults.eIsProxy()) {
			InternalEObject oldResourceContainer_ResourceContainerResults = (InternalEObject)resourceContainer_ResourceContainerResults;
			resourceContainer_ResourceContainerResults = (ResourceContainer)eResolveProxy(oldResourceContainer_ResourceContainerResults);
			if (resourceContainer_ResourceContainerResults != oldResourceContainer_ResourceContainerResults) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS, oldResourceContainer_ResourceContainerResults, resourceContainer_ResourceContainerResults));
			}
		}
		return resourceContainer_ResourceContainerResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetResourceContainer_ResourceContainerResults() {
		return resourceContainer_ResourceContainerResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceContainer_ResourceContainerResults(ResourceContainer newResourceContainer_ResourceContainerResults) {
		ResourceContainer oldResourceContainer_ResourceContainerResults = resourceContainer_ResourceContainerResults;
		resourceContainer_ResourceContainerResults = newResourceContainer_ResourceContainerResults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS, oldResourceContainer_ResourceContainerResults, resourceContainer_ResourceContainerResults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS:
				if (resolve) return getResourceContainer_ResourceContainerResults();
				return basicGetResourceContainer_ResourceContainerResults();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS:
				setResourceContainer_ResourceContainerResults((ResourceContainer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS:
				setResourceContainer_ResourceContainerResults((ResourceContainer)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS:
				return resourceContainer_ResourceContainerResults != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceContainerResultsImpl
