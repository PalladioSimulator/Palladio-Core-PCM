/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.ResourceSignature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl#getImplementationComponentType__Variable <em>Implementation Component Type Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl#getDataType__Variable <em>Data Type Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl#getCompositeDataType__Variable <em>Composite Data Type Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl#getResourceSignature__Variable <em>Resource Signature Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl#getInfrastructureSignature__Variable <em>Infrastructure Signature Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl#getEventType__Variable <em>Event Type Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl#getVariableCharacteristics__Variable <em>Variable Characteristics Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableImpl#getOperationSignature__Variable <em>Operation Signature Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends EntityImpl implements Variable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getDataType__Variable() <em>Data Type Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType__Variable()
	 * @generated
	 * @ordered
	 */
	protected DataType dataType__Variable;

	/**
	 * The cached value of the '{@link #getVariableCharacteristics__Variable() <em>Variable Characteristics Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableCharacteristics__Variable()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCharacteristic> variableCharacteristics__Variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationComponentType getImplementationComponentType__Variable() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE) return null;
		return (ImplementationComponentType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplementationComponentType__Variable(ImplementationComponentType newImplementationComponentType__Variable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newImplementationComponentType__Variable, ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationComponentType__Variable(ImplementationComponentType newImplementationComponentType__Variable) {
		if (newImplementationComponentType__Variable != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE && newImplementationComponentType__Variable != null)) {
			if (EcoreUtil.isAncestor(this, newImplementationComponentType__Variable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newImplementationComponentType__Variable != null)
				msgs = ((InternalEObject)newImplementationComponentType__Variable).eInverseAdd(this, RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_IMPLEMENTATION_COMPONENT_TYPE, ImplementationComponentType.class, msgs);
			msgs = basicSetImplementationComponentType__Variable(newImplementationComponentType__Variable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE, newImplementationComponentType__Variable, newImplementationComponentType__Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType getEventType__Variable() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE) return null;
		return (EventType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventType__Variable(EventType newEventType__Variable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEventType__Variable, ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventType__Variable(EventType newEventType__Variable) {
		if (newEventType__Variable != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE && newEventType__Variable != null)) {
			if (EcoreUtil.isAncestor(this, newEventType__Variable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEventType__Variable != null)
				msgs = ((InternalEObject)newEventType__Variable).eInverseAdd(this, RepositoryPackage.EVENT_TYPE__PAYLOAD_EVENT_TYPE, EventType.class, msgs);
			msgs = basicSetEventType__Variable(newEventType__Variable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE, newEventType__Variable, newEventType__Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableCharacteristic> getVariableCharacteristics__Variable() {
		if (variableCharacteristics__Variable == null) {
			variableCharacteristics__Variable = new EObjectContainmentWithInverseEList<VariableCharacteristic>(VariableCharacteristic.class, this, ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE, ParameterPackage.VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC);
		}
		return variableCharacteristics__Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataType__Variable() {
		if (dataType__Variable != null && dataType__Variable.eIsProxy()) {
			InternalEObject oldDataType__Variable = (InternalEObject)dataType__Variable;
			dataType__Variable = (DataType)eResolveProxy(oldDataType__Variable);
			if (dataType__Variable != oldDataType__Variable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParameterPackage.VARIABLE__DATA_TYPE_VARIABLE, oldDataType__Variable, dataType__Variable));
			}
		}
		return dataType__Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetDataType__Variable() {
		return dataType__Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType__Variable(DataType newDataType__Variable) {
		DataType oldDataType__Variable = dataType__Variable;
		dataType__Variable = newDataType__Variable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE__DATA_TYPE_VARIABLE, oldDataType__Variable, dataType__Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeDataType getCompositeDataType__Variable() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE) return null;
		return (CompositeDataType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompositeDataType__Variable(CompositeDataType newCompositeDataType__Variable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCompositeDataType__Variable, ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeDataType__Variable(CompositeDataType newCompositeDataType__Variable) {
		if (newCompositeDataType__Variable != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE && newCompositeDataType__Variable != null)) {
			if (EcoreUtil.isAncestor(this, newCompositeDataType__Variable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCompositeDataType__Variable != null)
				msgs = ((InternalEObject)newCompositeDataType__Variable).eInverseAdd(this, RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE, CompositeDataType.class, msgs);
			msgs = basicSetCompositeDataType__Variable(newCompositeDataType__Variable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE, newCompositeDataType__Variable, newCompositeDataType__Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSignature getResourceSignature__Variable() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE) return null;
		return (ResourceSignature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceSignature__Variable(ResourceSignature newResourceSignature__Variable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceSignature__Variable, ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceSignature__Variable(ResourceSignature newResourceSignature__Variable) {
		if (newResourceSignature__Variable != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE && newResourceSignature__Variable != null)) {
			if (EcoreUtil.isAncestor(this, newResourceSignature__Variable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceSignature__Variable != null)
				msgs = ((InternalEObject)newResourceSignature__Variable).eInverseAdd(this, RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE, ResourceSignature.class, msgs);
			msgs = basicSetResourceSignature__Variable(newResourceSignature__Variable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE, newResourceSignature__Variable, newResourceSignature__Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureSignature getInfrastructureSignature__Variable() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE) return null;
		return (InfrastructureSignature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInfrastructureSignature__Variable(InfrastructureSignature newInfrastructureSignature__Variable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInfrastructureSignature__Variable, ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfrastructureSignature__Variable(InfrastructureSignature newInfrastructureSignature__Variable) {
		if (newInfrastructureSignature__Variable != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE && newInfrastructureSignature__Variable != null)) {
			if (EcoreUtil.isAncestor(this, newInfrastructureSignature__Variable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInfrastructureSignature__Variable != null)
				msgs = ((InternalEObject)newInfrastructureSignature__Variable).eInverseAdd(this, RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE, InfrastructureSignature.class, msgs);
			msgs = basicSetInfrastructureSignature__Variable(newInfrastructureSignature__Variable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE, newInfrastructureSignature__Variable, newInfrastructureSignature__Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature getOperationSignature__Variable() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE) return null;
		return (OperationSignature)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationSignature__Variable(OperationSignature newOperationSignature__Variable, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperationSignature__Variable, ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationSignature__Variable(OperationSignature newOperationSignature__Variable) {
		if (newOperationSignature__Variable != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE && newOperationSignature__Variable != null)) {
			if (EcoreUtil.isAncestor(this, newOperationSignature__Variable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperationSignature__Variable != null)
				msgs = ((InternalEObject)newOperationSignature__Variable).eInverseAdd(this, RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE, OperationSignature.class, msgs);
			msgs = basicSetOperationSignature__Variable(newOperationSignature__Variable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE, newOperationSignature__Variable, newOperationSignature__Variable));
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
			case ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetImplementationComponentType__Variable((ImplementationComponentType)otherEnd, msgs);
			case ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCompositeDataType__Variable((CompositeDataType)otherEnd, msgs);
			case ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceSignature__Variable((ResourceSignature)otherEnd, msgs);
			case ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInfrastructureSignature__Variable((InfrastructureSignature)otherEnd, msgs);
			case ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEventType__Variable((EventType)otherEnd, msgs);
			case ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariableCharacteristics__Variable()).basicAdd(otherEnd, msgs);
			case ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperationSignature__Variable((OperationSignature)otherEnd, msgs);
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
			case ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE:
				return basicSetImplementationComponentType__Variable(null, msgs);
			case ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE:
				return basicSetCompositeDataType__Variable(null, msgs);
			case ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE:
				return basicSetResourceSignature__Variable(null, msgs);
			case ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE:
				return basicSetInfrastructureSignature__Variable(null, msgs);
			case ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE:
				return basicSetEventType__Variable(null, msgs);
			case ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE:
				return ((InternalEList<?>)getVariableCharacteristics__Variable()).basicRemove(otherEnd, msgs);
			case ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE:
				return basicSetOperationSignature__Variable(null, msgs);
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
			case ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_IMPLEMENTATION_COMPONENT_TYPE, ImplementationComponentType.class, msgs);
			case ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE, CompositeDataType.class, msgs);
			case ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE, ResourceSignature.class, msgs);
			case ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE, InfrastructureSignature.class, msgs);
			case ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.EVENT_TYPE__PAYLOAD_EVENT_TYPE, EventType.class, msgs);
			case ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE, OperationSignature.class, msgs);
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
			case ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE:
				return getImplementationComponentType__Variable();
			case ParameterPackage.VARIABLE__DATA_TYPE_VARIABLE:
				if (resolve) return getDataType__Variable();
				return basicGetDataType__Variable();
			case ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE:
				return getCompositeDataType__Variable();
			case ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE:
				return getResourceSignature__Variable();
			case ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE:
				return getInfrastructureSignature__Variable();
			case ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE:
				return getEventType__Variable();
			case ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE:
				return getVariableCharacteristics__Variable();
			case ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE:
				return getOperationSignature__Variable();
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
			case ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE:
				setImplementationComponentType__Variable((ImplementationComponentType)newValue);
				return;
			case ParameterPackage.VARIABLE__DATA_TYPE_VARIABLE:
				setDataType__Variable((DataType)newValue);
				return;
			case ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE:
				setCompositeDataType__Variable((CompositeDataType)newValue);
				return;
			case ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE:
				setResourceSignature__Variable((ResourceSignature)newValue);
				return;
			case ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE:
				setInfrastructureSignature__Variable((InfrastructureSignature)newValue);
				return;
			case ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE:
				setEventType__Variable((EventType)newValue);
				return;
			case ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE:
				getVariableCharacteristics__Variable().clear();
				getVariableCharacteristics__Variable().addAll((Collection<? extends VariableCharacteristic>)newValue);
				return;
			case ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE:
				setOperationSignature__Variable((OperationSignature)newValue);
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
			case ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE:
				setImplementationComponentType__Variable((ImplementationComponentType)null);
				return;
			case ParameterPackage.VARIABLE__DATA_TYPE_VARIABLE:
				setDataType__Variable((DataType)null);
				return;
			case ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE:
				setCompositeDataType__Variable((CompositeDataType)null);
				return;
			case ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE:
				setResourceSignature__Variable((ResourceSignature)null);
				return;
			case ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE:
				setInfrastructureSignature__Variable((InfrastructureSignature)null);
				return;
			case ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE:
				setEventType__Variable((EventType)null);
				return;
			case ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE:
				getVariableCharacteristics__Variable().clear();
				return;
			case ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE:
				setOperationSignature__Variable((OperationSignature)null);
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
			case ParameterPackage.VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE:
				return getImplementationComponentType__Variable() != null;
			case ParameterPackage.VARIABLE__DATA_TYPE_VARIABLE:
				return dataType__Variable != null;
			case ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE:
				return getCompositeDataType__Variable() != null;
			case ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE:
				return getResourceSignature__Variable() != null;
			case ParameterPackage.VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE:
				return getInfrastructureSignature__Variable() != null;
			case ParameterPackage.VARIABLE__EVENT_TYPE_VARIABLE:
				return getEventType__Variable() != null;
			case ParameterPackage.VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE:
				return variableCharacteristics__Variable != null && !variableCharacteristics__Variable.isEmpty();
			case ParameterPackage.VARIABLE__OPERATION_SIGNATURE_VARIABLE:
				return getOperationSignature__Variable() != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableImpl
