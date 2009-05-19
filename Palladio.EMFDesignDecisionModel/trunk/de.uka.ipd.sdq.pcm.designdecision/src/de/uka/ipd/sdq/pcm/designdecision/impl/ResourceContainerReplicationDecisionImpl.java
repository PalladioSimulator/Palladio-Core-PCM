/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container Replication Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDecisionImpl#getResourcecontainer <em>Resourcecontainer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceContainerReplicationDecisionImpl extends DesignDecisionImpl implements ResourceContainerReplicationDecision {
	/**
	 * The cached value of the '{@link #getResourcecontainer() <em>Resourcecontainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcecontainer()
	 * @generated
	 * @ordered
	 */
	protected ResourceContainer resourcecontainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceContainerReplicationDecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.RESOURCE_CONTAINER_REPLICATION_DECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer getResourcecontainer() {
		if (resourcecontainer != null && resourcecontainer.eIsProxy()) {
			InternalEObject oldResourcecontainer = (InternalEObject)resourcecontainer;
			resourcecontainer = (ResourceContainer)eResolveProxy(oldResourcecontainer);
			if (resourcecontainer != oldResourcecontainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER, oldResourcecontainer, resourcecontainer));
			}
		}
		return resourcecontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetResourcecontainer() {
		return resourcecontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourcecontainer(ResourceContainer newResourcecontainer) {
		ResourceContainer oldResourcecontainer = resourcecontainer;
		resourcecontainer = newResourcecontainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER, oldResourcecontainer, resourcecontainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER:
				if (resolve) return getResourcecontainer();
				return basicGetResourcecontainer();
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
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER:
				setResourcecontainer((ResourceContainer)newValue);
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
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER:
				setResourcecontainer((ResourceContainer)null);
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
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DECISION__RESOURCECONTAINER:
				return resourcecontainer != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * @generated not
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
	@Override
	public String toString(){
		return "replication of "+this.getResourcecontainer().getEntityName();
		
	}

} //ResourceContainerReplicationDecisionImpl
