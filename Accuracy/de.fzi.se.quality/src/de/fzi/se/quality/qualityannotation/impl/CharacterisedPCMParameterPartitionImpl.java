/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Characterised PCM Parameter Partition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionImpl#getForCharacterisation
 * <em>For Characterisation</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionImpl#getPcmParameterPartition
 * <em>Pcm Parameter Partition</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionImpl#getQualifiedElementName
 * <em>Qualified Element Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CharacterisedPCMParameterPartitionImpl extends IdentifierImpl implements
CharacterisedPCMParameterPartition {

    /**
     * The default value of the '{@link #getForCharacterisation() <em>For Characterisation</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getForCharacterisation()
     * @generated
     * @ordered
     */
    protected static final VariableCharacterisationType FOR_CHARACTERISATION_EDEFAULT = VariableCharacterisationType.STRUCTURE;

    /**
     * The cached value of the '{@link #getForCharacterisation() <em>For Characterisation</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getForCharacterisation()
     * @generated
     * @ordered
     */
    protected VariableCharacterisationType forCharacterisation = FOR_CHARACTERISATION_EDEFAULT;

    /**
     * The default value of the '{@link #getQualifiedElementName() <em>Qualified Element Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getQualifiedElementName()
     * @generated
     * @ordered
     */
    protected static final String QUALIFIED_ELEMENT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQualifiedElementName() <em>Qualified Element Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getQualifiedElementName()
     * @generated
     * @ordered
     */
    protected String qualifiedElementName = QUALIFIED_ELEMENT_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CharacterisedPCMParameterPartitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public VariableCharacterisationType getForCharacterisation() {
        return this.forCharacterisation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setForCharacterisation(final VariableCharacterisationType newForCharacterisation) {
        final VariableCharacterisationType oldForCharacterisation = this.forCharacterisation;
        this.forCharacterisation = newForCharacterisation == null ? FOR_CHARACTERISATION_EDEFAULT
                : newForCharacterisation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION,
                    oldForCharacterisation, this.forCharacterisation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMParameterPartition getPcmParameterPartition() {
        if (this.eContainerFeatureID() != QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION) {
            return null;
        }
        return (PCMParameterPartition) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPcmParameterPartition(final PCMParameterPartition newPcmParameterPartition,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newPcmParameterPartition,
                QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPcmParameterPartition(final PCMParameterPartition newPcmParameterPartition) {
        if (newPcmParameterPartition != this.eInternalContainer()
                || (this.eContainerFeatureID() != QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION && newPcmParameterPartition != null)) {
            if (EcoreUtil.isAncestor(this, newPcmParameterPartition)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newPcmParameterPartition != null) {
                msgs = ((InternalEObject) newPcmParameterPartition).eInverseAdd(this,
                        QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS,
                        PCMParameterPartition.class, msgs);
            }
            msgs = this.basicSetPcmParameterPartition(newPcmParameterPartition, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION,
                    newPcmParameterPartition, newPcmParameterPartition));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getQualifiedElementName() {
        return this.qualifiedElementName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setQualifiedElementName(final String newQualifiedElementName) {
        final String oldQualifiedElementName = this.qualifiedElementName;
        this.qualifiedElementName = newQualifiedElementName;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME,
                    oldQualifiedElementName, this.qualifiedElementName));
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetPcmParameterPartition((PCMParameterPartition) otherEnd, msgs);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
            return this.basicSetPcmParameterPartition(null, msgs);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS,
                    PCMParameterPartition.class, msgs);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION:
            return this.getForCharacterisation();
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
            return this.getPcmParameterPartition();
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME:
            return this.getQualifiedElementName();
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION:
            this.setForCharacterisation((VariableCharacterisationType) newValue);
            return;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
            this.setPcmParameterPartition((PCMParameterPartition) newValue);
            return;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME:
            this.setQualifiedElementName((String) newValue);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION:
            this.setForCharacterisation(FOR_CHARACTERISATION_EDEFAULT);
            return;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
            this.setPcmParameterPartition((PCMParameterPartition) null);
            return;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME:
            this.setQualifiedElementName(QUALIFIED_ELEMENT_NAME_EDEFAULT);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION:
            return this.forCharacterisation != FOR_CHARACTERISATION_EDEFAULT;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
            return this.getPcmParameterPartition() != null;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME:
            return QUALIFIED_ELEMENT_NAME_EDEFAULT == null ? this.qualifiedElementName != null
            : !QUALIFIED_ELEMENT_NAME_EDEFAULT.equals(this.qualifiedElementName);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (forCharacterisation: ");
        result.append(this.forCharacterisation);
        result.append(", qualifiedElementName: ");
        result.append(this.qualifiedElementName);
        result.append(')');
        return result.toString();
    }

} // CharacterisedPCMParameterPartitionImpl
