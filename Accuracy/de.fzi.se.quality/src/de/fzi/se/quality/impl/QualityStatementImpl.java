/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.QualityPackage;
import de.fzi.se.quality.QualityRepository;
import de.fzi.se.quality.QualityStatement;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Statement</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.impl.QualityStatementImpl#getQualityRepository <em>Quality
 * Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class QualityStatementImpl extends IdentifierImpl implements QualityStatement {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected QualityStatementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityPackage.Literals.QUALITY_STATEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QualityRepository getQualityRepository() {
        if (this.eContainerFeatureID() != QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY) {
            return null;
        }
        return (QualityRepository) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetQualityRepository(final QualityRepository newQualityRepository,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newQualityRepository,
                QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setQualityRepository(final QualityRepository newQualityRepository) {
        if (newQualityRepository != this.eInternalContainer()
                || (this.eContainerFeatureID() != QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY && newQualityRepository != null)) {
            if (EcoreUtil.isAncestor(this, newQualityRepository)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newQualityRepository != null) {
                msgs = ((InternalEObject) newQualityRepository).eInverseAdd(this,
                        QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS, QualityRepository.class, msgs);
            }
            msgs = this.basicSetQualityRepository(newQualityRepository, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY, newQualityRepository, newQualityRepository));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetQualityRepository((QualityRepository) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY:
            return this.basicSetQualityRepository(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS, QualityRepository.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY:
            return this.getQualityRepository();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY:
            this.setQualityRepository((QualityRepository) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY:
            this.setQualityRepository((QualityRepository) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY:
            return this.getQualityRepository() != null;
        }
        return super.eIsSet(featureID);
    }

} // QualityStatementImpl
