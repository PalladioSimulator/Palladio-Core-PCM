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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.MetaDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Description;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.IdentifiableImpl;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryImpl#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryImpl#getExperimentGroups <em>Experiment Groups</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Repository.impl.RepositoryImpl#getDescriptions <em>Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RepositoryImpl extends IdentifiableImpl implements Repository {
	/**
     * The cached value of the '{@link #getExperimentGroups() <em>Experiment Groups</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExperimentGroups()
     * @generated
     * @ordered
     */
	protected EList<ExperimentGroup> experimentGroups;

	/**
     * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isReadOnly()
     * @generated
     * @ordered
     */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isReadOnly()
     * @generated
     * @ordered
     */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
     * The cached value of the '{@link #getDescriptions() <em>Descriptions</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDescriptions()
     * @generated
     * @ordered
     */
	protected EList<Description> descriptions;

	/** The DAO to load/access/store the data handled by this repository.
	 * @generated NOT
	 */
	protected MetaDao metaDao;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RepositoryImpl() {
		super();
		metaDao = null;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return RepositoryPackage.Literals.REPOSITORY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Repositories getRepositories() {
        if (eContainerFeatureID() != RepositoryPackage.REPOSITORY__REPOSITORIES) return null;
        return (Repositories)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRepositories(Repositories newRepositories, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRepositories, RepositoryPackage.REPOSITORY__REPOSITORIES, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRepositories(Repositories newRepositories) {
        if (newRepositories != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.REPOSITORY__REPOSITORIES && newRepositories != null)) {
            if (EcoreUtil.isAncestor(this, newRepositories))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRepositories != null)
                msgs = ((InternalEObject)newRepositories).eInverseAdd(this, RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES, Repositories.class, msgs);
            msgs = basicSetRepositories(newRepositories, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REPOSITORY__REPOSITORIES, newRepositories, newRepositories));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isReadOnly() {
        return readOnly;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setReadOnly(boolean newReadOnly) {
        boolean oldReadOnly = readOnly;
        readOnly = newReadOnly;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REPOSITORY__READ_ONLY, oldReadOnly, readOnly));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Description> getDescriptions() {
        if (descriptions == null) {
            descriptions = new EObjectWithInverseResolvingEList<Description>(Description.class, this, RepositoryPackage.REPOSITORY__DESCRIPTIONS, ExperimentDataPackage.DESCRIPTION__REPOSITORY);
        }
        return descriptions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ExperimentGroup> getExperimentGroups() {
        if (experimentGroups == null) {
            experimentGroups = new EObjectWithInverseResolvingEList<ExperimentGroup>(ExperimentGroup.class, this, RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS, ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY);
        }
        return experimentGroups;
    }

	/**
	 * <!-- begin-user-doc -->
	 * Resets the experiment groups attribute.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void resetExperimentGroups() {
		experimentGroups = new EObjectWithInverseResolvingEList<ExperimentGroup>(ExperimentGroup.class, this, RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS, ExperimentDataPackage.EXPERIMENT_GROUP__REPOSITORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Resets the descriptions attribute.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void resetDescriptions() {
		descriptions = new EObjectWithInverseResolvingEList<Description>(Description.class, this, RepositoryPackage.REPOSITORY__DESCRIPTIONS, ExperimentDataPackage.DESCRIPTION__REPOSITORY);
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
            case RepositoryPackage.REPOSITORY__REPOSITORIES:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetRepositories((Repositories)otherEnd, msgs);
            case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentGroups()).basicAdd(otherEnd, msgs);
            case RepositoryPackage.REPOSITORY__DESCRIPTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDescriptions()).basicAdd(otherEnd, msgs);
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
            case RepositoryPackage.REPOSITORY__REPOSITORIES:
                return basicSetRepositories(null, msgs);
            case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS:
                return ((InternalEList<?>)getExperimentGroups()).basicRemove(otherEnd, msgs);
            case RepositoryPackage.REPOSITORY__DESCRIPTIONS:
                return ((InternalEList<?>)getDescriptions()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case RepositoryPackage.REPOSITORY__REPOSITORIES:
                return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORIES__AVAILABLE_REPOSITORIES, Repositories.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.REPOSITORY__REPOSITORIES:
                return getRepositories();
            case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS:
                return getExperimentGroups();
            case RepositoryPackage.REPOSITORY__READ_ONLY:
                return isReadOnly();
            case RepositoryPackage.REPOSITORY__DESCRIPTIONS:
                return getDescriptions();
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
            case RepositoryPackage.REPOSITORY__REPOSITORIES:
                setRepositories((Repositories)newValue);
                return;
            case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS:
                getExperimentGroups().clear();
                getExperimentGroups().addAll((Collection<? extends ExperimentGroup>)newValue);
                return;
            case RepositoryPackage.REPOSITORY__READ_ONLY:
                setReadOnly((Boolean)newValue);
                return;
            case RepositoryPackage.REPOSITORY__DESCRIPTIONS:
                getDescriptions().clear();
                getDescriptions().addAll((Collection<? extends Description>)newValue);
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
            case RepositoryPackage.REPOSITORY__REPOSITORIES:
                setRepositories((Repositories)null);
                return;
            case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS:
                getExperimentGroups().clear();
                return;
            case RepositoryPackage.REPOSITORY__READ_ONLY:
                setReadOnly(READ_ONLY_EDEFAULT);
                return;
            case RepositoryPackage.REPOSITORY__DESCRIPTIONS:
                getDescriptions().clear();
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
            case RepositoryPackage.REPOSITORY__REPOSITORIES:
                return getRepositories() != null;
            case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUPS:
                return experimentGroups != null && !experimentGroups.isEmpty();
            case RepositoryPackage.REPOSITORY__READ_ONLY:
                return readOnly != READ_ONLY_EDEFAULT;
            case RepositoryPackage.REPOSITORY__DESCRIPTIONS:
                return descriptions != null && !descriptions.isEmpty();
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
        result.append(" (readOnly: ");
        result.append(readOnly);
        result.append(')');
        return result.toString();
    }

	@Override
	public MeasurementsDaoFactory getMeasurementsDaoFactory() {
		if (metaDao != null) {
			return metaDao.getMeasurementsDaoFactory();
		} else {
			return null;
		}
	}

	@Override
	public boolean canClose() {
		if (metaDao != null) {
			return metaDao.canClose();
		} else {
			return false;
		}
	}

	@Override
	public boolean canDelete() {
		if (metaDao != null) {
			return metaDao.canDelete();
		} else {
			return false;
		}
	}

	@Override
	public boolean canOpen() {
		if (metaDao != null) {
			return metaDao.canOpen();
		} else {
			return false;
		}
	}

	@Override
	public void close() throws DataNotAccessibleException {
		if (metaDao != null) {
			metaDao.close();
		}
	}

	@Override
	public void delete() throws DataNotAccessibleException {
		if (metaDao != null) {
			metaDao.delete();
		}
	}

	@Override
	public boolean isDeleted() {
		if (metaDao != null) {
			return metaDao.isDeleted();
		} else {
			return false;
		}
	}

	@Override
	public boolean isOpen() {
		if (metaDao != null) {
			return metaDao.isOpen();
		} else {
			return false;
		}
	}

	@Override
	public void open() throws DataNotAccessibleException {
		if (metaDao != null) {
			metaDao.open();
		}
	}
	
} //RepositoryImpl
