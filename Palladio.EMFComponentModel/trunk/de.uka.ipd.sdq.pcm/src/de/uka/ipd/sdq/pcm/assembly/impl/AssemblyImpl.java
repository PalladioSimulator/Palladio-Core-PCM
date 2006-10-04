
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.assembly.impl;

import de.uka.ipd.sdq.pcm.assembly.Assembly;
import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;
import de.uka.ipd.sdq.pcm.assembly.AssemblyPackage;
import de.uka.ipd.sdq.pcm.assembly.SystemAssemblyConnector;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.impl.AssemblyImpl#getAssemblyContexts_Assembly <em>Assembly Contexts Assembly</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.assembly.impl.AssemblyImpl#getAssemblyConnectors_Assembly <em>Assembly Connectors Assembly</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyImpl extends EntityImpl implements Assembly {
	/**
	 * The cached value of the '{@link #getAssemblyContexts_Assembly() <em>Assembly Contexts Assembly</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContexts_Assembly()
	 * @generated
	 * @ordered
	 */
	protected EList assemblyContexts_Assembly = null;

	/**
	 * The cached value of the '{@link #getAssemblyConnectors_Assembly() <em>Assembly Connectors Assembly</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyConnectors_Assembly()
	 * @generated
	 * @ordered
	 */
	protected EList assemblyConnectors_Assembly = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssemblyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AssemblyPackage.Literals.ASSEMBLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssemblyContexts_Assembly() {
		if (assemblyContexts_Assembly == null) {
			assemblyContexts_Assembly = new EObjectContainmentEList(AssemblyContext.class, this, AssemblyPackage.ASSEMBLY__ASSEMBLY_CONTEXTS_ASSEMBLY);
		}
		return assemblyContexts_Assembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssemblyConnectors_Assembly() {
		if (assemblyConnectors_Assembly == null) {
			assemblyConnectors_Assembly = new EObjectContainmentEList(SystemAssemblyConnector.class, this, AssemblyPackage.ASSEMBLY__ASSEMBLY_CONNECTORS_ASSEMBLY);
		}
		return assemblyConnectors_Assembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONTEXTS_ASSEMBLY:
				return ((InternalEList)getAssemblyContexts_Assembly()).basicRemove(otherEnd, msgs);
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONNECTORS_ASSEMBLY:
				return ((InternalEList)getAssemblyConnectors_Assembly()).basicRemove(otherEnd, msgs);
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
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONTEXTS_ASSEMBLY:
				return getAssemblyContexts_Assembly();
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONNECTORS_ASSEMBLY:
				return getAssemblyConnectors_Assembly();
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
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONTEXTS_ASSEMBLY:
				getAssemblyContexts_Assembly().clear();
				getAssemblyContexts_Assembly().addAll((Collection)newValue);
				return;
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONNECTORS_ASSEMBLY:
				getAssemblyConnectors_Assembly().clear();
				getAssemblyConnectors_Assembly().addAll((Collection)newValue);
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
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONTEXTS_ASSEMBLY:
				getAssemblyContexts_Assembly().clear();
				return;
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONNECTORS_ASSEMBLY:
				getAssemblyConnectors_Assembly().clear();
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
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONTEXTS_ASSEMBLY:
				return assemblyContexts_Assembly != null && !assemblyContexts_Assembly.isEmpty();
			case AssemblyPackage.ASSEMBLY__ASSEMBLY_CONNECTORS_ASSEMBLY:
				return assemblyConnectors_Assembly != null && !assemblyConnectors_Assembly.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AssemblyImpl