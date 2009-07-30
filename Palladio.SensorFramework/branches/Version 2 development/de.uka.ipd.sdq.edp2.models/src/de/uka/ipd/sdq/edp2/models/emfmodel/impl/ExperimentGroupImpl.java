/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.Propertyable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl#getAdditionalInformation <em>Additional Information</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl#getExperimentSettings <em>Experiment Settings</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl#getStorageNode <em>Storage Node</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.ExperimentGroupImpl#getMeasure <em>Measure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentGroupImpl extends IdentifiableImpl implements ExperimentGroup {
	/**
	 * The cached value of the '{@link #getAdditionalInformation() <em>Additional Information</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalInformation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> additionalInformation;

	/**
	 * The cached value of the '{@link #getExperimentSettings() <em>Experiment Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ExperimentSetting> experimentSettings;

	/**
	 * The cached value of the '{@link #getStorageNode() <em>Storage Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageNode()
	 * @generated
	 * @ordered
	 */
	protected StorageNode storageNode;

	/**
	 * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected static final String PURPOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected String purpose = PURPOSE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected EList<Edp2Measure> measure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.EXPERIMENT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getAdditionalInformation() {
		if (additionalInformation == null) {
			additionalInformation = new EcoreEMap<String,Object>(EmfmodelPackage.Literals.ESTRINGTO_EOBJECT_MAP_ENTRY, EStringtoEObjectMapEntryImpl.class, this, EmfmodelPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION);
		}
		return additionalInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExperimentSetting> getExperimentSettings() {
		if (experimentSettings == null) {
			experimentSettings = new EObjectContainmentEList<ExperimentSetting>(ExperimentSetting.class, this, EmfmodelPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS);
		}
		return experimentSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageNode getStorageNode() {
		if (storageNode != null && storageNode.eIsProxy()) {
			InternalEObject oldStorageNode = (InternalEObject)storageNode;
			storageNode = (StorageNode)eResolveProxy(oldStorageNode);
			if (storageNode != oldStorageNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE, oldStorageNode, storageNode));
			}
		}
		return storageNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageNode basicGetStorageNode() {
		return storageNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStorageNode(StorageNode newStorageNode, NotificationChain msgs) {
		StorageNode oldStorageNode = storageNode;
		storageNode = newStorageNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE, oldStorageNode, newStorageNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageNode(StorageNode newStorageNode) {
		if (newStorageNode != storageNode) {
			NotificationChain msgs = null;
			if (storageNode != null)
				msgs = ((InternalEObject)storageNode).eInverseRemove(this, UIPackage.STORAGE_NODE__EXPERIMENT_GROUP, StorageNode.class, msgs);
			if (newStorageNode != null)
				msgs = ((InternalEObject)newStorageNode).eInverseAdd(this, UIPackage.STORAGE_NODE__EXPERIMENT_GROUP, StorageNode.class, msgs);
			msgs = basicSetStorageNode(newStorageNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE, newStorageNode, newStorageNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		String oldPurpose = purpose;
		purpose = newPurpose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EXPERIMENT_GROUP__PURPOSE, oldPurpose, purpose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edp2Measure> getMeasure() {
		if (measure == null) {
			measure = new EObjectContainmentWithInverseEList<Edp2Measure>(Edp2Measure.class, this, EmfmodelPackage.EXPERIMENT_GROUP__MEASURE, EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_SETTING);
		}
		return measure;
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
			case EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE:
				if (storageNode != null)
					msgs = ((InternalEObject)storageNode).eInverseRemove(this, UIPackage.STORAGE_NODE__EXPERIMENT_GROUP, StorageNode.class, msgs);
				return basicSetStorageNode((StorageNode)otherEnd, msgs);
			case EmfmodelPackage.EXPERIMENT_GROUP__MEASURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMeasure()).basicAdd(otherEnd, msgs);
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
			case EmfmodelPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				return ((InternalEList<?>)getAdditionalInformation()).basicRemove(otherEnd, msgs);
			case EmfmodelPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				return ((InternalEList<?>)getExperimentSettings()).basicRemove(otherEnd, msgs);
			case EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE:
				return basicSetStorageNode(null, msgs);
			case EmfmodelPackage.EXPERIMENT_GROUP__MEASURE:
				return ((InternalEList<?>)getMeasure()).basicRemove(otherEnd, msgs);
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
			case EmfmodelPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				if (coreType) return getAdditionalInformation();
				else return getAdditionalInformation().map();
			case EmfmodelPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				return getExperimentSettings();
			case EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE:
				if (resolve) return getStorageNode();
				return basicGetStorageNode();
			case EmfmodelPackage.EXPERIMENT_GROUP__PURPOSE:
				return getPurpose();
			case EmfmodelPackage.EXPERIMENT_GROUP__MEASURE:
				return getMeasure();
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
			case EmfmodelPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				((EStructuralFeature.Setting)getAdditionalInformation()).set(newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				getExperimentSettings().clear();
				getExperimentSettings().addAll((Collection<? extends ExperimentSetting>)newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE:
				setStorageNode((StorageNode)newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_GROUP__PURPOSE:
				setPurpose((String)newValue);
				return;
			case EmfmodelPackage.EXPERIMENT_GROUP__MEASURE:
				getMeasure().clear();
				getMeasure().addAll((Collection<? extends Edp2Measure>)newValue);
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
			case EmfmodelPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				getAdditionalInformation().clear();
				return;
			case EmfmodelPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				getExperimentSettings().clear();
				return;
			case EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE:
				setStorageNode((StorageNode)null);
				return;
			case EmfmodelPackage.EXPERIMENT_GROUP__PURPOSE:
				setPurpose(PURPOSE_EDEFAULT);
				return;
			case EmfmodelPackage.EXPERIMENT_GROUP__MEASURE:
				getMeasure().clear();
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
			case EmfmodelPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION:
				return additionalInformation != null && !additionalInformation.isEmpty();
			case EmfmodelPackage.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS:
				return experimentSettings != null && !experimentSettings.isEmpty();
			case EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE:
				return storageNode != null;
			case EmfmodelPackage.EXPERIMENT_GROUP__PURPOSE:
				return PURPOSE_EDEFAULT == null ? purpose != null : !PURPOSE_EDEFAULT.equals(purpose);
			case EmfmodelPackage.EXPERIMENT_GROUP__MEASURE:
				return measure != null && !measure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Propertyable.class) {
			switch (derivedFeatureID) {
				case EmfmodelPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION: return EmfmodelPackage.PROPERTYABLE__ADDITIONAL_INFORMATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Propertyable.class) {
			switch (baseFeatureID) {
				case EmfmodelPackage.PROPERTYABLE__ADDITIONAL_INFORMATION: return EmfmodelPackage.EXPERIMENT_GROUP__ADDITIONAL_INFORMATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (purpose: ");
		result.append(purpose);
		result.append(')');
		return result.toString();
	}

} //ExperimentGroupImpl
