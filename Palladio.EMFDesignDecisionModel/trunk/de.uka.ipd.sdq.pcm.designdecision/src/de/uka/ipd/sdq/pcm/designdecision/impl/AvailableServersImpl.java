/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.AvailableServers;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Available Servers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.AvailableServersImpl#getResourcecontainer <em>Resourcecontainer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AvailableServersImpl extends EnumerationImpl implements AvailableServers {
	/**
	 * The cached value of the '{@link #getResourcecontainer() <em>Resourcecontainer</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcecontainer()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceContainer> resourcecontainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AvailableServersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.AVAILABLE_SERVERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceContainer> getResourcecontainer() {
		if (resourcecontainer == null) {
			resourcecontainer = new EObjectResolvingEList<ResourceContainer>(ResourceContainer.class, this, designdecisionPackage.AVAILABLE_SERVERS__RESOURCECONTAINER);
		}
		return resourcecontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.AVAILABLE_SERVERS__RESOURCECONTAINER:
				return getResourcecontainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case designdecisionPackage.AVAILABLE_SERVERS__RESOURCECONTAINER:
				getResourcecontainer().clear();
				getResourcecontainer().addAll((Collection<? extends ResourceContainer>)newValue);
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
			case designdecisionPackage.AVAILABLE_SERVERS__RESOURCECONTAINER:
				getResourcecontainer().clear();
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
			case designdecisionPackage.AVAILABLE_SERVERS__RESOURCECONTAINER:
				return resourcecontainer != null && !resourcecontainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AvailableServersImpl
