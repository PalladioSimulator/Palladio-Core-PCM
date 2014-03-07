/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.models.ExperimentData.Description;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Descriptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DescriptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DescriptionImpl#getTextualDescription <em>Textual Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DescriptionImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DescriptionImpl#getDescriptions <em>Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DescriptionImpl extends IdentifiableImpl implements Description {
	/**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected static final String NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected String name = NAME_EDEFAULT;

	/**
     * The default value of the '{@link #getTextualDescription() <em>Textual Description</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTextualDescription()
     * @generated
     * @ordered
     */
	protected static final String TEXTUAL_DESCRIPTION_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTextualDescription() <em>Textual Description</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTextualDescription()
     * @generated
     * @ordered
     */
	protected String textualDescription = TEXTUAL_DESCRIPTION_EDEFAULT;

	/**
     * The cached value of the '{@link #getRepository() <em>Repository</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRepository()
     * @generated
     * @ordered
     */
	protected Repository repository;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DescriptionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.DESCRIPTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DESCRIPTION__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTextualDescription() {
        return textualDescription;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTextualDescription(String newTextualDescription) {
        String oldTextualDescription = textualDescription;
        textualDescription = newTextualDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DESCRIPTION__TEXTUAL_DESCRIPTION, oldTextualDescription, textualDescription));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Repository getRepository() {
        if (repository != null && repository.eIsProxy()) {
            InternalEObject oldRepository = (InternalEObject)repository;
            repository = (Repository)eResolveProxy(oldRepository);
            if (repository != oldRepository) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.DESCRIPTION__REPOSITORY, oldRepository, repository));
            }
        }
        return repository;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Repository basicGetRepository() {
        return repository;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRepository(Repository newRepository, NotificationChain msgs) {
        Repository oldRepository = repository;
        repository = newRepository;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DESCRIPTION__REPOSITORY, oldRepository, newRepository);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRepository(Repository newRepository) {
        if (newRepository != repository) {
            NotificationChain msgs = null;
            if (repository != null)
                msgs = ((InternalEObject)repository).eInverseRemove(this, RepositoryPackage.REPOSITORY__DESCRIPTIONS, Repository.class, msgs);
            if (newRepository != null)
                msgs = ((InternalEObject)newRepository).eInverseAdd(this, RepositoryPackage.REPOSITORY__DESCRIPTIONS, Repository.class, msgs);
            msgs = basicSetRepository(newRepository, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DESCRIPTION__REPOSITORY, newRepository, newRepository));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Descriptions getDescriptions() {
        if (eContainerFeatureID() != ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS) return null;
        return (Descriptions)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetDescriptions(Descriptions newDescriptions, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDescriptions, ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDescriptions(Descriptions newDescriptions) {
        if (newDescriptions != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS && newDescriptions != null)) {
            if (EcoreUtil.isAncestor(this, newDescriptions))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDescriptions != null)
                msgs = ((InternalEObject)newDescriptions).eInverseAdd(this, ExperimentDataPackage.DESCRIPTIONS__DESCRIPTION, Descriptions.class, msgs);
            msgs = basicSetDescriptions(newDescriptions, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS, newDescriptions, newDescriptions));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.DESCRIPTION__REPOSITORY:
                if (repository != null)
                    msgs = ((InternalEObject)repository).eInverseRemove(this, RepositoryPackage.REPOSITORY__DESCRIPTIONS, Repository.class, msgs);
                return basicSetRepository((Repository)otherEnd, msgs);
            case ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDescriptions((Descriptions)otherEnd, msgs);
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
            case ExperimentDataPackage.DESCRIPTION__REPOSITORY:
                return basicSetRepository(null, msgs);
            case ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS:
                return basicSetDescriptions(null, msgs);
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
            case ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.DESCRIPTIONS__DESCRIPTION, Descriptions.class, msgs);
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
            case ExperimentDataPackage.DESCRIPTION__NAME:
                return getName();
            case ExperimentDataPackage.DESCRIPTION__TEXTUAL_DESCRIPTION:
                return getTextualDescription();
            case ExperimentDataPackage.DESCRIPTION__REPOSITORY:
                if (resolve) return getRepository();
                return basicGetRepository();
            case ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS:
                return getDescriptions();
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
            case ExperimentDataPackage.DESCRIPTION__NAME:
                setName((String)newValue);
                return;
            case ExperimentDataPackage.DESCRIPTION__TEXTUAL_DESCRIPTION:
                setTextualDescription((String)newValue);
                return;
            case ExperimentDataPackage.DESCRIPTION__REPOSITORY:
                setRepository((Repository)newValue);
                return;
            case ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS:
                setDescriptions((Descriptions)newValue);
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
            case ExperimentDataPackage.DESCRIPTION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ExperimentDataPackage.DESCRIPTION__TEXTUAL_DESCRIPTION:
                setTextualDescription(TEXTUAL_DESCRIPTION_EDEFAULT);
                return;
            case ExperimentDataPackage.DESCRIPTION__REPOSITORY:
                setRepository((Repository)null);
                return;
            case ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS:
                setDescriptions((Descriptions)null);
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
            case ExperimentDataPackage.DESCRIPTION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ExperimentDataPackage.DESCRIPTION__TEXTUAL_DESCRIPTION:
                return TEXTUAL_DESCRIPTION_EDEFAULT == null ? textualDescription != null : !TEXTUAL_DESCRIPTION_EDEFAULT.equals(textualDescription);
            case ExperimentDataPackage.DESCRIPTION__REPOSITORY:
                return repository != null;
            case ExperimentDataPackage.DESCRIPTION__DESCRIPTIONS:
                return getDescriptions() != null;
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
        result.append(" (name: ");
        result.append(name);
        result.append(", textualDescription: ");
        result.append(textualDescription);
        result.append(')');
        return result.toString();
    }

} //DescriptionImpl
