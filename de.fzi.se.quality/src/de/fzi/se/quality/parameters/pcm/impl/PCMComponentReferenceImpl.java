/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.parameters.impl.ComponentReferenceImpl;
import de.fzi.se.quality.parameters.pcm.PCMComponentReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentReferenceImpl#getBasicComponent <em>Basic Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMComponentReferenceImpl extends ComponentReferenceImpl implements PCMComponentReference {
	/**
     * The cached value of the '{@link #getBasicComponent() <em>Basic Component</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBasicComponent()
     * @generated
     * @ordered
     */
	protected BasicComponent basicComponent;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMComponentReferenceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_COMPONENT_REFERENCE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BasicComponent getBasicComponent() {
        if (basicComponent != null && basicComponent.eIsProxy()) {
            InternalEObject oldBasicComponent = (InternalEObject)basicComponent;
            basicComponent = (BasicComponent)eResolveProxy(oldBasicComponent);
            if (basicComponent != oldBasicComponent) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT, oldBasicComponent, basicComponent));
            }
        }
        return basicComponent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BasicComponent basicGetBasicComponent() {
        return basicComponent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBasicComponent(BasicComponent newBasicComponent) {
        BasicComponent oldBasicComponent = basicComponent;
        basicComponent = newBasicComponent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT, oldBasicComponent, basicComponent));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT:
                if (resolve) return getBasicComponent();
                return basicGetBasicComponent();
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
            case PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT:
                setBasicComponent((BasicComponent)newValue);
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
            case PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT:
                setBasicComponent((BasicComponent)null);
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
            case PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT:
                return basicComponent != null;
        }
        return super.eIsSet(featureID);
    }

} //PCMComponentReferenceImpl
