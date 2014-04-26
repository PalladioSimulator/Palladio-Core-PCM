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
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characterised PCM Parameter Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionImpl#getForCharacterisation <em>For Characterisation</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionImpl#getPcmParameterPartition <em>Pcm Parameter Partition</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionImpl#getQualifiedElementName <em>Qualified Element Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CharacterisedPCMParameterPartitionImpl extends IdentifierImpl implements CharacterisedPCMParameterPartition {
	/**
     * The default value of the '{@link #getForCharacterisation() <em>For Characterisation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getForCharacterisation()
     * @generated
     * @ordered
     */
	protected static final VariableCharacterisationType FOR_CHARACTERISATION_EDEFAULT = VariableCharacterisationType.STRUCTURE;

	/**
     * The cached value of the '{@link #getForCharacterisation() <em>For Characterisation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getForCharacterisation()
     * @generated
     * @ordered
     */
	protected VariableCharacterisationType forCharacterisation = FOR_CHARACTERISATION_EDEFAULT;

	/**
     * The default value of the '{@link #getQualifiedElementName() <em>Qualified Element Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getQualifiedElementName()
     * @generated
     * @ordered
     */
	protected static final String QUALIFIED_ELEMENT_NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getQualifiedElementName() <em>Qualified Element Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getQualifiedElementName()
     * @generated
     * @ordered
     */
	protected String qualifiedElementName = QUALIFIED_ELEMENT_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CharacterisedPCMParameterPartitionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableCharacterisationType getForCharacterisation() {
        return forCharacterisation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setForCharacterisation(VariableCharacterisationType newForCharacterisation) {
        VariableCharacterisationType oldForCharacterisation = forCharacterisation;
        forCharacterisation = newForCharacterisation == null ? FOR_CHARACTERISATION_EDEFAULT : newForCharacterisation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION, oldForCharacterisation, forCharacterisation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PCMParameterPartition getPcmParameterPartition() {
        if (eContainerFeatureID() != QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION) return null;
        return (PCMParameterPartition)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPcmParameterPartition(PCMParameterPartition newPcmParameterPartition, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPcmParameterPartition, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPcmParameterPartition(PCMParameterPartition newPcmParameterPartition) {
        if (newPcmParameterPartition != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION && newPcmParameterPartition != null)) {
            if (EcoreUtil.isAncestor(this, newPcmParameterPartition))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPcmParameterPartition != null)
                msgs = ((InternalEObject)newPcmParameterPartition).eInverseAdd(this, QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS, PCMParameterPartition.class, msgs);
            msgs = basicSetPcmParameterPartition(newPcmParameterPartition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION, newPcmParameterPartition, newPcmParameterPartition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getQualifiedElementName() {
        return qualifiedElementName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setQualifiedElementName(String newQualifiedElementName) {
        String oldQualifiedElementName = qualifiedElementName;
        qualifiedElementName = newQualifiedElementName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME, oldQualifiedElementName, qualifiedElementName));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetPcmParameterPartition((PCMParameterPartition)otherEnd, msgs);
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
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
                return basicSetPcmParameterPartition(null, msgs);
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
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
                return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS, PCMParameterPartition.class, msgs);
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
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION:
                return getForCharacterisation();
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
                return getPcmParameterPartition();
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME:
                return getQualifiedElementName();
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
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION:
                setForCharacterisation((VariableCharacterisationType)newValue);
                return;
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
                setPcmParameterPartition((PCMParameterPartition)newValue);
                return;
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME:
                setQualifiedElementName((String)newValue);
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
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION:
                setForCharacterisation(FOR_CHARACTERISATION_EDEFAULT);
                return;
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
                setPcmParameterPartition((PCMParameterPartition)null);
                return;
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME:
                setQualifiedElementName(QUALIFIED_ELEMENT_NAME_EDEFAULT);
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
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__FOR_CHARACTERISATION:
                return forCharacterisation != FOR_CHARACTERISATION_EDEFAULT;
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION:
                return getPcmParameterPartition() != null;
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__QUALIFIED_ELEMENT_NAME:
                return QUALIFIED_ELEMENT_NAME_EDEFAULT == null ? qualifiedElementName != null : !QUALIFIED_ELEMENT_NAME_EDEFAULT.equals(qualifiedElementName);
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
        result.append(" (forCharacterisation: ");
        result.append(forCharacterisation);
        result.append(", qualifiedElementName: ");
        result.append(qualifiedElementName);
        result.append(')');
        return result.toString();
    }

} //CharacterisedPCMParameterPartitionImpl
