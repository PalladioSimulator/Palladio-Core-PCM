/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.Allocation.impl;

import eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage;
import eu.qimpress.commonmodel.commonmodel.Allocation.Service;

import eu.qimpress.commonmodel.commonmodel.Allocation.util.AllocationValidator;

import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.Node;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeStructureImpl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.Allocation.impl.ServiceImpl#isIsBlackBox <em>Is Black Box</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.Allocation.impl.ServiceImpl#getNode <em>Node</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.Allocation.impl.ServiceImpl#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends CompositeStructureImpl implements Service {
	/**
	 * The default value of the '{@link #isIsBlackBox() <em>Is Black Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBlackBox()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BLACK_BOX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> node;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected ComponentType component;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBlackBox() {
		// TODO: implement this method to return the 'Is Black Box' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBlackBox(boolean newIsBlackBox) {
		// TODO: implement this method to set the 'Is Black Box' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNode() {
		if (node == null) {
			node = new EObjectResolvingEList<Node>(Node.class, this, AllocationPackage.SERVICE__NODE);
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (ComponentType)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.SERVICE__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(ComponentType newComponent) {
		ComponentType oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.SERVICE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBlackBox(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.SERVICE__IS_BLACK_BOX,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "isBlackBox", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocationPackage.SERVICE__IS_BLACK_BOX:
				return isIsBlackBox() ? Boolean.TRUE : Boolean.FALSE;
			case AllocationPackage.SERVICE__NODE:
				return getNode();
			case AllocationPackage.SERVICE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
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
			case AllocationPackage.SERVICE__IS_BLACK_BOX:
				setIsBlackBox(((Boolean)newValue).booleanValue());
				return;
			case AllocationPackage.SERVICE__NODE:
				getNode().clear();
				getNode().addAll((Collection<? extends Node>)newValue);
				return;
			case AllocationPackage.SERVICE__COMPONENT:
				setComponent((ComponentType)newValue);
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
			case AllocationPackage.SERVICE__IS_BLACK_BOX:
				setIsBlackBox(IS_BLACK_BOX_EDEFAULT);
				return;
			case AllocationPackage.SERVICE__NODE:
				getNode().clear();
				return;
			case AllocationPackage.SERVICE__COMPONENT:
				setComponent((ComponentType)null);
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
			case AllocationPackage.SERVICE__IS_BLACK_BOX:
				return isIsBlackBox() != IS_BLACK_BOX_EDEFAULT;
			case AllocationPackage.SERVICE__NODE:
				return node != null && !node.isEmpty();
			case AllocationPackage.SERVICE__COMPONENT:
				return component != null;
		}
		return super.eIsSet(featureID);
	}

} //ServiceImpl
