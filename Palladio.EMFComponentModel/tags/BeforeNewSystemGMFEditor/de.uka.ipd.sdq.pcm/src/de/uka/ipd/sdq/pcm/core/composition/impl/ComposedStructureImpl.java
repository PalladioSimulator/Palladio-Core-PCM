
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composed Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getChildComponentContexts_ComposedStructure <em>Child Component Contexts Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getCompositeAssemblyConnectors_ComposedStructure <em>Composite Assembly Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getProvidedDelegationConnectors_ComposedStructure <em>Provided Delegation Connectors Composed Structure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getRequiredDelegationConnectors_ComposedStructure <em>Required Delegation Connectors Composed Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComposedStructureImpl extends EObjectImpl implements ComposedStructure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getChildComponentContexts_ComposedStructure() <em>Child Component Contexts Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildComponentContexts_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList childComponentContexts_ComposedStructure = null;

	/**
	 * The cached value of the '{@link #getCompositeAssemblyConnectors_ComposedStructure() <em>Composite Assembly Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeAssemblyConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList compositeAssemblyConnectors_ComposedStructure = null;

	/**
	 * The cached value of the '{@link #getProvidedDelegationConnectors_ComposedStructure() <em>Provided Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList providedDelegationConnectors_ComposedStructure = null;

	/**
	 * The cached value of the '{@link #getRequiredDelegationConnectors_ComposedStructure() <em>Required Delegation Connectors Composed Structure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredDelegationConnectors_ComposedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList requiredDelegationConnectors_ComposedStructure = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedStructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.COMPOSED_STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getChildComponentContexts_ComposedStructure() {
		if (childComponentContexts_ComposedStructure == null) {
			childComponentContexts_ComposedStructure = new EObjectContainmentEList(AssemblyContext.class, this, CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE);
		}
		return childComponentContexts_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCompositeAssemblyConnectors_ComposedStructure() {
		if (compositeAssemblyConnectors_ComposedStructure == null) {
			compositeAssemblyConnectors_ComposedStructure = new EObjectContainmentEList(AssemblyConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE);
		}
		return compositeAssemblyConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProvidedDelegationConnectors_ComposedStructure() {
		if (providedDelegationConnectors_ComposedStructure == null) {
			providedDelegationConnectors_ComposedStructure = new EObjectContainmentEList(ProvidedDelegationConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
		}
		return providedDelegationConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRequiredDelegationConnectors_ComposedStructure() {
		if (requiredDelegationConnectors_ComposedStructure == null) {
			requiredDelegationConnectors_ComposedStructure = new EObjectContainmentEList(RequiredDelegationConnector.class, this, CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE);
		}
		return requiredDelegationConnectors_ComposedStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return ((InternalEList)getChildComponentContexts_ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getCompositeAssemblyConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getProvidedDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return ((InternalEList)getRequiredDelegationConnectors_ComposedStructure()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return getChildComponentContexts_ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return getCompositeAssemblyConnectors_ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getProvidedDelegationConnectors_ComposedStructure();
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return getRequiredDelegationConnectors_ComposedStructure();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				getChildComponentContexts_ComposedStructure().clear();
				getChildComponentContexts_ComposedStructure().addAll((Collection)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				getCompositeAssemblyConnectors_ComposedStructure().clear();
				getCompositeAssemblyConnectors_ComposedStructure().addAll((Collection)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getProvidedDelegationConnectors_ComposedStructure().clear();
				getProvidedDelegationConnectors_ComposedStructure().addAll((Collection)newValue);
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getRequiredDelegationConnectors_ComposedStructure().clear();
				getRequiredDelegationConnectors_ComposedStructure().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				getChildComponentContexts_ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				getCompositeAssemblyConnectors_ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getProvidedDelegationConnectors_ComposedStructure().clear();
				return;
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				getRequiredDelegationConnectors_ComposedStructure().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CompositionPackage.COMPOSED_STRUCTURE__CHILD_COMPONENT_CONTEXTS_COMPOSED_STRUCTURE:
				return childComponentContexts_ComposedStructure != null && !childComponentContexts_ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__COMPOSITE_ASSEMBLY_CONNECTORS_COMPOSED_STRUCTURE:
				return compositeAssemblyConnectors_ComposedStructure != null && !compositeAssemblyConnectors_ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__PROVIDED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return providedDelegationConnectors_ComposedStructure != null && !providedDelegationConnectors_ComposedStructure.isEmpty();
			case CompositionPackage.COMPOSED_STRUCTURE__REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
				return requiredDelegationConnectors_ComposedStructure != null && !requiredDelegationConnectors_ComposedStructure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComposedStructureImpl