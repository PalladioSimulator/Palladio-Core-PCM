/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container Replication Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationChoiceImpl#getMultiplicityOfResourceContainer <em>Multiplicity Of Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceContainerReplicationChoiceImpl extends ChoiceImpl implements ResourceContainerReplicationChoice {
	/**
	 * The default value of the '{@link #getMultiplicityOfResourceContainer() <em>Multiplicity Of Resource Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicityOfResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected static final int MULTIPLICITY_OF_RESOURCE_CONTAINER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMultiplicityOfResourceContainer() <em>Multiplicity Of Resource Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicityOfResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected int multiplicityOfResourceContainer = MULTIPLICITY_OF_RESOURCE_CONTAINER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceContainerReplicationChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.RESOURCE_CONTAINER_REPLICATION_CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMultiplicityOfResourceContainer() {
		return multiplicityOfResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicityOfResourceContainer(int newMultiplicityOfResourceContainer) {
		int oldMultiplicityOfResourceContainer = multiplicityOfResourceContainer;
		multiplicityOfResourceContainer = newMultiplicityOfResourceContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_CHOICE__MULTIPLICITY_OF_RESOURCE_CONTAINER, oldMultiplicityOfResourceContainer, multiplicityOfResourceContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_CHOICE__MULTIPLICITY_OF_RESOURCE_CONTAINER:
				return new Integer(getMultiplicityOfResourceContainer());
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
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_CHOICE__MULTIPLICITY_OF_RESOURCE_CONTAINER:
				setMultiplicityOfResourceContainer(((Integer)newValue).intValue());
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
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_CHOICE__MULTIPLICITY_OF_RESOURCE_CONTAINER:
				setMultiplicityOfResourceContainer(MULTIPLICITY_OF_RESOURCE_CONTAINER_EDEFAULT);
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
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_CHOICE__MULTIPLICITY_OF_RESOURCE_CONTAINER:
				return multiplicityOfResourceContainer != MULTIPLICITY_OF_RESOURCE_CONTAINER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (multiplicityOfResourceContainer: ");
		result.append(multiplicityOfResourceContainer);
		result.append(')');
		return result.toString();
	}

} //ResourceContainerReplicationChoiceImpl
