/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.internal.SerializationUtil;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repositories</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoriesImpl#getAvailableRepositories <em>Available Repositories</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoriesImpl#getCommonResourceSet <em>Common Resource Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoriesImpl extends EObjectImpl implements Repositories {
	/**
     * The cached value of the '{@link #getAvailableRepositories() <em>Available Repositories</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAvailableRepositories()
     * @generated
     * @ordered
     */
	protected EList<Repository> availableRepositories;

	/**
     * The cached value of the '{@link #getCommonResourceSet() <em>Common Resource Set</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCommonResourceSet()
     * @generated
     * @ordered
     */
	protected ResourceSet commonResourceSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RepositoriesImpl() {
		super();
		// DEFAULT: Generate a new resource set by which all EMF resources are managed.
		commonResourceSet = SerializationUtil.createResourceSet();
		//EmfmodelPackageImpl.eINSTANCE.eClass();
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return RepositoryPackage.Literals.REPOSITORIES;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Repository> getAvailableRepositories() {
        if (availableRepositories == null) {
            availableRepositories = new EObjectContainmentWithInverseEList<Repository>(Repository.class, this, RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES, RepositoryPackage.REPOSITORY__REPOSITORIES);
        }
        return availableRepositories;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ResourceSet getCommonResourceSet() {
		// Added "commonResourceSet instanceof EObject && " as this returns an error
		if (commonResourceSet != null && commonResourceSet instanceof EObject && ((EObject)commonResourceSet).eIsProxy()) {
			InternalEObject oldCommonResourceSet = (InternalEObject)commonResourceSet;
			commonResourceSet = (ResourceSet)eResolveProxy(oldCommonResourceSet);
			if (commonResourceSet != oldCommonResourceSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.REPOSITORIES__COMMON_RESOURCE_SET, oldCommonResourceSet, commonResourceSet));
			}
		}
		return commonResourceSet;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ResourceSet basicGetCommonResourceSet() {
        return commonResourceSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCommonResourceSet(ResourceSet newCommonResourceSet) {
        ResourceSet oldCommonResourceSet = commonResourceSet;
        commonResourceSet = newCommonResourceSet;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REPOSITORIES__COMMON_RESOURCE_SET, oldCommonResourceSet, commonResourceSet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAvailableRepositories()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES:
                return ((InternalEList<?>)getAvailableRepositories()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES:
                return getAvailableRepositories();
            case RepositoryPackage.REPOSITORIES__COMMON_RESOURCE_SET:
                if (resolve) return getCommonResourceSet();
                return basicGetCommonResourceSet();
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
            case RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES:
                getAvailableRepositories().clear();
                getAvailableRepositories().addAll((Collection<? extends Repository>)newValue);
                return;
            case RepositoryPackage.REPOSITORIES__COMMON_RESOURCE_SET:
                setCommonResourceSet((ResourceSet)newValue);
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
            case RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES:
                getAvailableRepositories().clear();
                return;
            case RepositoryPackage.REPOSITORIES__COMMON_RESOURCE_SET:
                setCommonResourceSet((ResourceSet)null);
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
            case RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES:
                return availableRepositories != null && !availableRepositories.isEmpty();
            case RepositoryPackage.REPOSITORIES__COMMON_RESOURCE_SET:
                return commonResourceSet != null;
        }
        return super.eIsSet(featureID);
    }

} //RepositoriesImpl
