/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl#getParentStructure_AssemblyContext <em>Parent Structure Assembly Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl#getEncapsulatedComponent_AssemblyContext <em>Encapsulated Component Assembly Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl#getConfigVariableSetters__AssemblyContext <em>Config Variable Setters Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyContextImpl extends EntityImpl implements AssemblyContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getEncapsulatedComponent_AssemblyContext() <em>Encapsulated Component Assembly Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncapsulatedComponent_AssemblyContext()
	 * @generated
	 * @ordered
	 */
	protected RepositoryComponent encapsulatedComponent_AssemblyContext;

	/**
	 * The cached value of the '{@link #getConfigVariableSetters__AssemblyContext() <em>Config Variable Setters Assembly Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigVariableSetters__AssemblyContext()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableSetter> configVariableSetters__AssemblyContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssemblyContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.ASSEMBLY_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedStructure getParentStructure_AssemblyContext() {
		if (eContainerFeatureID() != CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT) return null;
		return (ComposedStructure)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStructure_AssemblyContext(ComposedStructure newParentStructure_AssemblyContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStructure_AssemblyContext, CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStructure_AssemblyContext(ComposedStructure newParentStructure_AssemblyContext) {
		if (newParentStructure_AssemblyContext != eInternalContainer() || (eContainerFeatureID() != CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT && newParentStructure_AssemblyContext != null)) {
			if (EcoreUtil.isAncestor(this, newParentStructure_AssemblyContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStructure_AssemblyContext != null)
				msgs = ((InternalEObject)newParentStructure_AssemblyContext).eInverseAdd(this, CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
			msgs = basicSetParentStructure_AssemblyContext(newParentStructure_AssemblyContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT, newParentStructure_AssemblyContext, newParentStructure_AssemblyContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent getEncapsulatedComponent_AssemblyContext() {
		if (encapsulatedComponent_AssemblyContext != null && encapsulatedComponent_AssemblyContext.eIsProxy()) {
			InternalEObject oldEncapsulatedComponent_AssemblyContext = (InternalEObject)encapsulatedComponent_AssemblyContext;
			encapsulatedComponent_AssemblyContext = (RepositoryComponent)eResolveProxy(oldEncapsulatedComponent_AssemblyContext);
			if (encapsulatedComponent_AssemblyContext != oldEncapsulatedComponent_AssemblyContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT, oldEncapsulatedComponent_AssemblyContext, encapsulatedComponent_AssemblyContext));
			}
		}
		return encapsulatedComponent_AssemblyContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent basicGetEncapsulatedComponent_AssemblyContext() {
		return encapsulatedComponent_AssemblyContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncapsulatedComponent_AssemblyContext(RepositoryComponent newEncapsulatedComponent_AssemblyContext) {
		RepositoryComponent oldEncapsulatedComponent_AssemblyContext = encapsulatedComponent_AssemblyContext;
		encapsulatedComponent_AssemblyContext = newEncapsulatedComponent_AssemblyContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT, oldEncapsulatedComponent_AssemblyContext, encapsulatedComponent_AssemblyContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableSetter> getConfigVariableSetters__AssemblyContext() {
		if (configVariableSetters__AssemblyContext == null) {
			configVariableSetters__AssemblyContext = new EObjectContainmentWithInverseEList<VariableSetter>(VariableSetter.class, this, CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT, ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER);
		}
		return configVariableSetters__AssemblyContext;
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
			case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStructure_AssemblyContext((ComposedStructure)otherEnd, msgs);
			case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConfigVariableSetters__AssemblyContext()).basicAdd(otherEnd, msgs);
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
			case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
				return basicSetParentStructure_AssemblyContext(null, msgs);
			case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT:
				return ((InternalEList<?>)getConfigVariableSetters__AssemblyContext()).basicRemove(otherEnd, msgs);
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
			case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
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
			case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
				return getParentStructure_AssemblyContext();
			case CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
				if (resolve) return getEncapsulatedComponent_AssemblyContext();
				return basicGetEncapsulatedComponent_AssemblyContext();
			case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT:
				return getConfigVariableSetters__AssemblyContext();
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
			case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
				setParentStructure_AssemblyContext((ComposedStructure)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
				setEncapsulatedComponent_AssemblyContext((RepositoryComponent)newValue);
				return;
			case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT:
				getConfigVariableSetters__AssemblyContext().clear();
				getConfigVariableSetters__AssemblyContext().addAll((Collection<? extends VariableSetter>)newValue);
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
			case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
				setParentStructure_AssemblyContext((ComposedStructure)null);
				return;
			case CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
				setEncapsulatedComponent_AssemblyContext((RepositoryComponent)null);
				return;
			case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT:
				getConfigVariableSetters__AssemblyContext().clear();
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
			case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
				return getParentStructure_AssemblyContext() != null;
			case CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
				return encapsulatedComponent_AssemblyContext != null;
			case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT:
				return configVariableSetters__AssemblyContext != null && !configVariableSetters__AssemblyContext.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AssemblyContextImpl
