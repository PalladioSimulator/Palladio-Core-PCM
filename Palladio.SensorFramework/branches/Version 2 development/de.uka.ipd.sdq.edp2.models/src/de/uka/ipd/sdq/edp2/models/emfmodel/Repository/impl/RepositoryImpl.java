/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Repository.impl;

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
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.local.file.LocalDirectoryMetaDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.Description;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryStatus;
import de.uka.ipd.sdq.edp2.models.emfmodel.impl.IdentifiableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.impl.RepositoryImpl#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.impl.RepositoryImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.impl.RepositoryImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.impl.RepositoryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Repository.impl.RepositoryImpl#getExperimentGroup <em>Experiment Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RepositoryImpl extends IdentifiableImpl implements Repository {
	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final RepositoryStatus STATUS_EDEFAULT = RepositoryStatus.OPEN;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected RepositoryStatus status = STATUS_EDEFAULT;

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
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<Description> description;

	/**
	 * The cached value of the '{@link #getExperimentGroup() <em>Experiment Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<ExperimentGroup> experimentGroup;

	/** The DAO to load/access/store the data handled by this repository.
	 * @generated NOT
	 */
	protected LocalDirectoryMetaDao metaDao;

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
		return (Repositories)eContainer();
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
	public RepositoryStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(RepositoryStatus newStatus) {
		RepositoryStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REPOSITORY__STATUS, oldStatus, status));
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
	public EList<Description> getDescription() {
		if (description == null) {
			description = new EObjectWithInverseResolvingEList<Description>(Description.class, this, RepositoryPackage.REPOSITORY__DESCRIPTION, EmfmodelPackage.DESCRIPTION__REPOSITORY);
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExperimentGroup> getExperimentGroup() {
		if (experimentGroup == null) {
			experimentGroup = new EObjectWithInverseResolvingEList<ExperimentGroup>(ExperimentGroup.class, this, RepositoryPackage.REPOSITORY__EXPERIMENT_GROUP, EmfmodelPackage.EXPERIMENT_GROUP__REPOSITORY);
		}
		return experimentGroup;
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
			case RepositoryPackage.REPOSITORY__DESCRIPTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDescription()).basicAdd(otherEnd, msgs);
			case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentGroup()).basicAdd(otherEnd, msgs);
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
			case RepositoryPackage.REPOSITORY__DESCRIPTION:
				return ((InternalEList<?>)getDescription()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUP:
				return ((InternalEList<?>)getExperimentGroup()).basicRemove(otherEnd, msgs);
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
			case RepositoryPackage.REPOSITORY__STATUS:
				return getStatus();
			case RepositoryPackage.REPOSITORY__READ_ONLY:
				return isReadOnly();
			case RepositoryPackage.REPOSITORY__DESCRIPTION:
				return getDescription();
			case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUP:
				return getExperimentGroup();
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
			case RepositoryPackage.REPOSITORY__STATUS:
				setStatus((RepositoryStatus)newValue);
				return;
			case RepositoryPackage.REPOSITORY__READ_ONLY:
				setReadOnly((Boolean)newValue);
				return;
			case RepositoryPackage.REPOSITORY__DESCRIPTION:
				getDescription().clear();
				getDescription().addAll((Collection<? extends Description>)newValue);
				return;
			case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUP:
				getExperimentGroup().clear();
				getExperimentGroup().addAll((Collection<? extends ExperimentGroup>)newValue);
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
			case RepositoryPackage.REPOSITORY__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case RepositoryPackage.REPOSITORY__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case RepositoryPackage.REPOSITORY__DESCRIPTION:
				getDescription().clear();
				return;
			case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUP:
				getExperimentGroup().clear();
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
			case RepositoryPackage.REPOSITORY__STATUS:
				return status != STATUS_EDEFAULT;
			case RepositoryPackage.REPOSITORY__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case RepositoryPackage.REPOSITORY__DESCRIPTION:
				return description != null && !description.isEmpty();
			case RepositoryPackage.REPOSITORY__EXPERIMENT_GROUP:
				return experimentGroup != null && !experimentGroup.isEmpty();
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
		result.append(" (status: ");
		result.append(status);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(')');
		return result.toString();
	}

	@Override
	public MeasurementsDaoFactory getMeasurementsDaoFactory() {
		return metaDao.getMeasurementsDaoFactory();
	}

	@Override
	public boolean canClose() {
		return metaDao.canClose();
	}

	@Override
	public boolean canDelete() {
		return metaDao.canDelete();
	}

	@Override
	public boolean canOpen() {
		return metaDao.canOpen();
	}

	@Override
	public void close() throws DataNotAccessibleException {
		metaDao.close();
	}

	@Override
	public void delete() throws DataNotAccessibleException {
		metaDao.delete();
	}

	@Override
	public boolean isDeleted() {
		return metaDao.isDeleted();
	}

	@Override
	public boolean isOpen() {
		return metaDao.isOpen();
	}

	@Override
	public void open() throws DataNotAccessibleException {
		metaDao.open();
	}
	
} //RepositoryImpl
