/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembled Component Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDecisionImpl#getAssemblycontext <em>Assemblycontext</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssembledComponentDecisionImpl extends DesignDecisionImpl implements AssembledComponentDecision {
	/**
	 * The cached value of the '{@link #getAssemblycontext() <em>Assemblycontext</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblycontext()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblycontext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssembledComponentDecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.ASSEMBLED_COMPONENT_DECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblycontext() {
		if (assemblycontext != null && assemblycontext.eIsProxy()) {
			InternalEObject oldAssemblycontext = (InternalEObject)assemblycontext;
			assemblycontext = (AssemblyContext)eResolveProxy(oldAssemblycontext);
			if (assemblycontext != oldAssemblycontext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT, oldAssemblycontext, assemblycontext));
			}
		}
		return assemblycontext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblycontext() {
		return assemblycontext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblycontext(AssemblyContext newAssemblycontext) {
		AssemblyContext oldAssemblycontext = assemblycontext;
		assemblycontext = newAssemblycontext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT, oldAssemblycontext, assemblycontext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT:
				if (resolve) return getAssemblycontext();
				return basicGetAssemblycontext();
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
			case designdecisionPackage.ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT:
				setAssemblycontext((AssemblyContext)newValue);
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
			case designdecisionPackage.ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT:
				setAssemblycontext((AssemblyContext)null);
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
			case designdecisionPackage.ASSEMBLED_COMPONENT_DECISION__ASSEMBLYCONTEXT:
				return assemblycontext != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * @generated not
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
	@Override
	public String toString(){
		return "component in "+this.getAssemblycontext().getEntityName();
		
	}

} //AssembledComponentDecisionImpl
