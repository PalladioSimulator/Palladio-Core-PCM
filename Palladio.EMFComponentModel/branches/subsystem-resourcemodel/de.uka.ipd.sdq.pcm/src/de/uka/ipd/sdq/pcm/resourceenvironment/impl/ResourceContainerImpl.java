/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationConnector;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerStack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getAllocationConnectors_ResourceContainer <em>Allocation Connectors Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getInfrastructureComponentScope_ResourceContainer <em>Infrastructure Component Scope Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getControllerInstance_ResourceContainer <em>Controller Instance Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getControllerStack_ResourceContainer <em>Controller Stack Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceContainerImpl extends EntityImpl implements ResourceContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getActiveResourceSpecifications_ResourceContainer() <em>Active Resource Specifications Resource Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveResourceSpecifications_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessingResourceSpecification> activeResourceSpecifications_ResourceContainer;

	/**
	 * The cached value of the '{@link #getInfrastructureComponentScope_ResourceContainer() <em>Infrastructure Component Scope Resource Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructureComponentScope_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<InfrastructureComponentScope> infrastructureComponentScope_ResourceContainer;

	/**
	 * The cached value of the '{@link #getControllerInstance_ResourceContainer() <em>Controller Instance Resource Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerInstance_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<ControllerInstance> controllerInstance_ResourceContainer;

	/**
	 * The cached value of the '{@link #getControllerStack_ResourceContainer() <em>Controller Stack Resource Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerStack_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected ControllerStack controllerStack_ResourceContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.RESOURCE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AllocationConnector> getAllocationConnectors_ResourceContainer() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessingResourceSpecification> getActiveResourceSpecifications_ResourceContainer() {
		if (activeResourceSpecifications_ResourceContainer == null) {
			activeResourceSpecifications_ResourceContainer = new EObjectContainmentEList<ProcessingResourceSpecification>(ProcessingResourceSpecification.class, this, ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER);
		}
		return activeResourceSpecifications_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InfrastructureComponentScope> getInfrastructureComponentScope_ResourceContainer() {
		if (infrastructureComponentScope_ResourceContainer == null) {
			infrastructureComponentScope_ResourceContainer = new EObjectContainmentEList<InfrastructureComponentScope>(InfrastructureComponentScope.class, this, ResourceenvironmentPackage.RESOURCE_CONTAINER__INFRASTRUCTURE_COMPONENT_SCOPE_RESOURCE_CONTAINER);
		}
		return infrastructureComponentScope_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControllerInstance> getControllerInstance_ResourceContainer() {
		if (controllerInstance_ResourceContainer == null) {
			controllerInstance_ResourceContainer = new EObjectContainmentEList<ControllerInstance>(ControllerInstance.class, this, ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCE_RESOURCE_CONTAINER);
		}
		return controllerInstance_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerStack getControllerStack_ResourceContainer() {
		if (controllerStack_ResourceContainer != null && controllerStack_ResourceContainer.eIsProxy()) {
			InternalEObject oldControllerStack_ResourceContainer = (InternalEObject)controllerStack_ResourceContainer;
			controllerStack_ResourceContainer = (ControllerStack)eResolveProxy(oldControllerStack_ResourceContainer);
			if (controllerStack_ResourceContainer != oldControllerStack_ResourceContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_STACK_RESOURCE_CONTAINER, oldControllerStack_ResourceContainer, controllerStack_ResourceContainer));
			}
		}
		return controllerStack_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerStack basicGetControllerStack_ResourceContainer() {
		return controllerStack_ResourceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllerStack_ResourceContainer(ControllerStack newControllerStack_ResourceContainer) {
		ControllerStack oldControllerStack_ResourceContainer = controllerStack_ResourceContainer;
		controllerStack_ResourceContainer = newControllerStack_ResourceContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_STACK_RESOURCE_CONTAINER, oldControllerStack_ResourceContainer, controllerStack_ResourceContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return ((InternalEList<?>)getActiveResourceSpecifications_ResourceContainer()).basicRemove(otherEnd, msgs);
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__INFRASTRUCTURE_COMPONENT_SCOPE_RESOURCE_CONTAINER:
				return ((InternalEList<?>)getInfrastructureComponentScope_ResourceContainer()).basicRemove(otherEnd, msgs);
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCE_RESOURCE_CONTAINER:
				return ((InternalEList<?>)getControllerInstance_ResourceContainer()).basicRemove(otherEnd, msgs);
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ALLOCATION_CONNECTORS_RESOURCE_CONTAINER:
				return getAllocationConnectors_ResourceContainer();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return getActiveResourceSpecifications_ResourceContainer();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__INFRASTRUCTURE_COMPONENT_SCOPE_RESOURCE_CONTAINER:
				return getInfrastructureComponentScope_ResourceContainer();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCE_RESOURCE_CONTAINER:
				return getControllerInstance_ResourceContainer();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_STACK_RESOURCE_CONTAINER:
				if (resolve) return getControllerStack_ResourceContainer();
				return basicGetControllerStack_ResourceContainer();
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ALLOCATION_CONNECTORS_RESOURCE_CONTAINER:
				getAllocationConnectors_ResourceContainer().clear();
				getAllocationConnectors_ResourceContainer().addAll((Collection<? extends AllocationConnector>)newValue);
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getActiveResourceSpecifications_ResourceContainer().clear();
				getActiveResourceSpecifications_ResourceContainer().addAll((Collection<? extends ProcessingResourceSpecification>)newValue);
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__INFRASTRUCTURE_COMPONENT_SCOPE_RESOURCE_CONTAINER:
				getInfrastructureComponentScope_ResourceContainer().clear();
				getInfrastructureComponentScope_ResourceContainer().addAll((Collection<? extends InfrastructureComponentScope>)newValue);
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCE_RESOURCE_CONTAINER:
				getControllerInstance_ResourceContainer().clear();
				getControllerInstance_ResourceContainer().addAll((Collection<? extends ControllerInstance>)newValue);
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_STACK_RESOURCE_CONTAINER:
				setControllerStack_ResourceContainer((ControllerStack)newValue);
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ALLOCATION_CONNECTORS_RESOURCE_CONTAINER:
				getAllocationConnectors_ResourceContainer().clear();
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getActiveResourceSpecifications_ResourceContainer().clear();
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__INFRASTRUCTURE_COMPONENT_SCOPE_RESOURCE_CONTAINER:
				getInfrastructureComponentScope_ResourceContainer().clear();
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCE_RESOURCE_CONTAINER:
				getControllerInstance_ResourceContainer().clear();
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_STACK_RESOURCE_CONTAINER:
				setControllerStack_ResourceContainer((ControllerStack)null);
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ALLOCATION_CONNECTORS_RESOURCE_CONTAINER:
				return !getAllocationConnectors_ResourceContainer().isEmpty();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return activeResourceSpecifications_ResourceContainer != null && !activeResourceSpecifications_ResourceContainer.isEmpty();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__INFRASTRUCTURE_COMPONENT_SCOPE_RESOURCE_CONTAINER:
				return infrastructureComponentScope_ResourceContainer != null && !infrastructureComponentScope_ResourceContainer.isEmpty();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCE_RESOURCE_CONTAINER:
				return controllerInstance_ResourceContainer != null && !controllerInstance_ResourceContainer.isEmpty();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_STACK_RESOURCE_CONTAINER:
				return controllerStack_ResourceContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceContainerImpl
