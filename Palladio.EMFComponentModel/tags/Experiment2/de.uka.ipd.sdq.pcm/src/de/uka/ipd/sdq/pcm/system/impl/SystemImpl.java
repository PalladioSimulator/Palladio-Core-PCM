
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getChildComponentContexts_ComposedStructure <em>Child Component Contexts Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getProvidedDelegationConnectors_ComposedStructure <em>Provided Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getRequiredDelegationConnectors_ComposedStructure <em>Required Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getCompositeAssemblyConnectors_ComposedStructure <em>Composite Assembly Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getProvidedRoles_InterfaceProvidingEntity <em>Provided Roles Interface Providing Entity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getRequiredRoles_InterfaceRequiringEntity <em>Required Roles Interface Requiring Entity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getQosAnnotations_System <em>Qos Annotations System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends EntityImpl implements de.uka.ipd.sdq.pcm.system.System {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getChildComponentContexts_ComposedStructure() <em>Child Component Contexts Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildComponentContexts_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<AssemblyContext> childComponentContexts_ComposedStructure;

	/**
	 * The cached value of the '{@link #getProvidedDelegationConnectors_ComposedStructure() <em>Provided Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidedDelegationConnector> providedDelegationConnectors_ComposedStructure;

	/**
	 * The cached value of the '{@link #getRequiredDelegationConnectors_ComposedStructure() <em>Required Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredDelegationConnector> requiredDelegationConnectors_ComposedStructure;

	/**
	 * The cached value of the '{@link #getCompositeAssemblyConnectors_ComposedStructure() <em>Composite Assembly Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeAssemblyConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<AssemblyConnector> compositeAssemblyConnectors_ComposedStructure;

	/**
	 * The cached value of the '{@link #getProvidedRoles_InterfaceProvidingEntity() <em>Provided Roles Interface Providing Entity</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRoles_InterfaceProvidingEntity()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidedRole> providedRoles_InterfaceProvidingEntity;

	/**
	 * The cached value of the '{@link #getRequiredRoles_InterfaceRequiringEntity() <em>Required Roles Interface Requiring Entity</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRoles_InterfaceRequiringEntity()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredRole> requiredRoles_InterfaceRequiringEntity;

	/**
	 * The cached value of the '{@link #getQosAnnotations_System() <em>Qos Annotations System</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQosAnnotations_System()
	 * @generated
	 * @ordered
	 */
	protected EList<QoSAnnotations> qosAnnotations_System;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssemblyContext> getChildComponentContexts_ComposedStructure() {
		if (childComponentContexts_ComposedStructure == null) {
			childComponentContexts_ComposedStructure = new EObjectContainmentWithInverseEList<AssemblyContext>(AssemblyContext.class, this, SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE, CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT);
		}
		return childComponentContexts_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidedDelegationConnector> getProvidedDelegationConnectors_ComposedStructure() {
		if (providedDelegationConnectors_ComposedStructure == null) {
			providedDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<ProvidedDelegationConnector>(ProvidedDelegationConnector.class, this, SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.PROVIDED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_PROVIDED_DELEGATION_CONNECTOR);
		}
		return providedDelegationConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredDelegationConnector> getRequiredDelegationConnectors_ComposedStructure() {
		if (requiredDelegationConnectors_ComposedStructure == null) {
			requiredDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<RequiredDelegationConnector>(RequiredDelegationConnector.class, this, SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_REQUIRED_DELEGATION_CONNECTOR);
		}
		return requiredDelegationConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssemblyConnector> getCompositeAssemblyConnectors_ComposedStructure() {
		if (compositeAssemblyConnectors_ComposedStructure == null) {
			compositeAssemblyConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<AssemblyConnector>(AssemblyConnector.class, this, SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE, CompositionPackage.ASSEMBLY_CONNECTOR__PARENT_STRUCTURE_ASSEMBLY_CONNECTOR);
		}
		return compositeAssemblyConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidedRole> getProvidedRoles_InterfaceProvidingEntity() {
		if (providedRoles_InterfaceProvidingEntity == null) {
			providedRoles_InterfaceProvidingEntity = new EObjectContainmentWithInverseEList<ProvidedRole>(ProvidedRole.class, this, SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY, RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE);
		}
		return providedRoles_InterfaceProvidingEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredRole> getRequiredRoles_InterfaceRequiringEntity() {
		if (requiredRoles_InterfaceRequiringEntity == null) {
			requiredRoles_InterfaceRequiringEntity = new EObjectContainmentWithInverseEList<RequiredRole>(RequiredRole.class, this, SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY, RepositoryPackage.REQUIRED_ROLE__REQUIRING_ENTITY_REQUIRED_ROLE);
		}
		return requiredRoles_InterfaceRequiringEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QoSAnnotations> getQosAnnotations_System() {
		if (qosAnnotations_System == null) {
			qosAnnotations_System = new EObjectContainmentEList<QoSAnnotations>(QoSAnnotations.class, this, SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM);
		}
		return qosAnnotations_System;
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
			case SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildComponentContexts_ComposedStructure()).basicAdd(otherEnd, msgs);
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProvidedDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
			case SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCompositeAssemblyConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
			case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProvidedRoles_InterfaceProvidingEntity()).basicAdd(otherEnd, msgs);
			case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredRoles_InterfaceRequiringEntity()).basicAdd(otherEnd, msgs);
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
			case SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getChildComponentContexts_ComposedStructure()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getProvidedDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getRequiredDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList<?>)getCompositeAssemblyConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				return ((InternalEList<?>)getProvidedRoles_InterfaceProvidingEntity()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				return ((InternalEList<?>)getRequiredRoles_InterfaceRequiringEntity()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
				return ((InternalEList<?>)getQosAnnotations_System()).basicRemove(otherEnd, msgs);
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
			case SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return getChildComponentContexts_ComposedStructure();
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getProvidedDelegationConnectors_ComposedStructure();
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getRequiredDelegationConnectors_ComposedStructure();
			case SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return getCompositeAssemblyConnectors_ComposedStructure();
			case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				return getProvidedRoles_InterfaceProvidingEntity();
			case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				return getRequiredRoles_InterfaceRequiringEntity();
			case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
				return getQosAnnotations_System();
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
			case SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				getChildComponentContexts_ComposedStructure().clear();
				getChildComponentContexts_ComposedStructure().addAll((Collection<? extends AssemblyContext>)newValue);
				return;
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getProvidedDelegationConnectors_ComposedStructure().clear();
				getProvidedDelegationConnectors_ComposedStructure().addAll((Collection<? extends ProvidedDelegationConnector>)newValue);
				return;
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getRequiredDelegationConnectors_ComposedStructure().clear();
				getRequiredDelegationConnectors_ComposedStructure().addAll((Collection<? extends RequiredDelegationConnector>)newValue);
				return;
			case SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				getCompositeAssemblyConnectors_ComposedStructure().clear();
				getCompositeAssemblyConnectors_ComposedStructure().addAll((Collection<? extends AssemblyConnector>)newValue);
				return;
			case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				getProvidedRoles_InterfaceProvidingEntity().clear();
				getProvidedRoles_InterfaceProvidingEntity().addAll((Collection<? extends ProvidedRole>)newValue);
				return;
			case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				getRequiredRoles_InterfaceRequiringEntity().clear();
				getRequiredRoles_InterfaceRequiringEntity().addAll((Collection<? extends RequiredRole>)newValue);
				return;
			case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
				getQosAnnotations_System().clear();
				getQosAnnotations_System().addAll((Collection<? extends QoSAnnotations>)newValue);
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
			case SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				getChildComponentContexts_ComposedStructure().clear();
				return;
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getProvidedDelegationConnectors_ComposedStructure().clear();
				return;
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getRequiredDelegationConnectors_ComposedStructure().clear();
				return;
			case SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				getCompositeAssemblyConnectors_ComposedStructure().clear();
				return;
			case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				getProvidedRoles_InterfaceProvidingEntity().clear();
				return;
			case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				getRequiredRoles_InterfaceRequiringEntity().clear();
				return;
			case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
				getQosAnnotations_System().clear();
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
			case SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return childComponentContexts_ComposedStructure != null && !childComponentContexts_ComposedStructure.isEmpty();
			case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return providedDelegationConnectors_ComposedStructure != null && !providedDelegationConnectors_ComposedStructure.isEmpty();
			case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return requiredDelegationConnectors_ComposedStructure != null && !requiredDelegationConnectors_ComposedStructure.isEmpty();
			case SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return compositeAssemblyConnectors_ComposedStructure != null && !compositeAssemblyConnectors_ComposedStructure.isEmpty();
			case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
				return providedRoles_InterfaceProvidingEntity != null && !providedRoles_InterfaceProvidingEntity.isEmpty();
			case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
				return requiredRoles_InterfaceRequiringEntity != null && !requiredRoles_InterfaceRequiringEntity.isEmpty();
			case SystemPackage.SYSTEM__QOS_ANNOTATIONS_SYSTEM:
				return qosAnnotations_System != null && !qosAnnotations_System.isEmpty();
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
		if (baseClass == ComposedStructure.class) {
			switch (derivedFeatureID) {
				case SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE: return CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE;
				case SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE: return CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
				case SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE: return CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
				case SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE: return CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE;
				default: return -1;
			}
		}
		if (baseClass == InterfaceProvidingEntity.class) {
			switch (derivedFeatureID) {
				case SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY: return EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;
				default: return -1;
			}
		}
		if (baseClass == InterfaceRequiringEntity.class) {
			switch (derivedFeatureID) {
				case SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY: return EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;
				default: return -1;
			}
		}
		if (baseClass == InterfaceProvidingRequiringEntity.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ComposedProvidingRequiringEntity.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == ComposedStructure.class) {
			switch (baseFeatureID) {
				case CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE: return SystemPackage.SYSTEM__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE;
				case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE: return SystemPackage.SYSTEM__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
				case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE: return SystemPackage.SYSTEM__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE;
				case CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE: return SystemPackage.SYSTEM__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE;
				default: return -1;
			}
		}
		if (baseClass == InterfaceProvidingEntity.class) {
			switch (baseFeatureID) {
				case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY: return SystemPackage.SYSTEM__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;
				default: return -1;
			}
		}
		if (baseClass == InterfaceRequiringEntity.class) {
			switch (baseFeatureID) {
				case EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY: return SystemPackage.SYSTEM__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;
				default: return -1;
			}
		}
		if (baseClass == InterfaceProvidingRequiringEntity.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ComposedProvidingRequiringEntity.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SystemImpl
