/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Control Flow Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ActionControlFlowLinkImpl#getControlflowlevelsourcecodelink <em>Controlflowlevelsourcecodelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ActionControlFlowLinkImpl#getAbstractaction <em>Abstractaction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionControlFlowLinkImpl extends IdentifierImpl implements ActionControlFlowLink {
	/**
	 * The cached value of the '{@link #getControlflowlevelsourcecodelink() <em>Controlflowlevelsourcecodelink</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlflowlevelsourcecodelink()
	 * @generated
	 * @ordered
	 */
	protected ControlFlowLevelSourceCodeLink controlflowlevelsourcecodelink;

	/**
	 * The cached value of the '{@link #getAbstractaction() <em>Abstractaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractaction()
	 * @generated
	 * @ordered
	 */
	protected AbstractAction abstractaction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionControlFlowLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCMLinkPackage.Literals.ACTION_CONTROL_FLOW_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowLevelSourceCodeLink getControlflowlevelsourcecodelink() {
		if (controlflowlevelsourcecodelink != null && controlflowlevelsourcecodelink.eIsProxy()) {
			InternalEObject oldControlflowlevelsourcecodelink = (InternalEObject)controlflowlevelsourcecodelink;
			controlflowlevelsourcecodelink = (ControlFlowLevelSourceCodeLink)eResolveProxy(oldControlflowlevelsourcecodelink);
			if (controlflowlevelsourcecodelink != oldControlflowlevelsourcecodelink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK, oldControlflowlevelsourcecodelink, controlflowlevelsourcecodelink));
			}
		}
		return controlflowlevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowLevelSourceCodeLink basicGetControlflowlevelsourcecodelink() {
		return controlflowlevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlflowlevelsourcecodelink(ControlFlowLevelSourceCodeLink newControlflowlevelsourcecodelink) {
		ControlFlowLevelSourceCodeLink oldControlflowlevelsourcecodelink = controlflowlevelsourcecodelink;
		controlflowlevelsourcecodelink = newControlflowlevelsourcecodelink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK, oldControlflowlevelsourcecodelink, controlflowlevelsourcecodelink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getAbstractaction() {
		if (abstractaction != null && abstractaction.eIsProxy()) {
			InternalEObject oldAbstractaction = (InternalEObject)abstractaction;
			abstractaction = (AbstractAction)eResolveProxy(oldAbstractaction);
			if (abstractaction != oldAbstractaction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION, oldAbstractaction, abstractaction));
			}
		}
		return abstractaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction basicGetAbstractaction() {
		return abstractaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractaction(AbstractAction newAbstractaction) {
		AbstractAction oldAbstractaction = abstractaction;
		abstractaction = newAbstractaction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION, oldAbstractaction, abstractaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK:
				if (resolve) return getControlflowlevelsourcecodelink();
				return basicGetControlflowlevelsourcecodelink();
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION:
				if (resolve) return getAbstractaction();
				return basicGetAbstractaction();
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
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK:
				setControlflowlevelsourcecodelink((ControlFlowLevelSourceCodeLink)newValue);
				return;
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION:
				setAbstractaction((AbstractAction)newValue);
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
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK:
				setControlflowlevelsourcecodelink((ControlFlowLevelSourceCodeLink)null);
				return;
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION:
				setAbstractaction((AbstractAction)null);
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
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK:
				return controlflowlevelsourcecodelink != null;
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION:
				return abstractaction != null;
		}
		return super.eIsSet(featureID);
	}

} //ActionControlFlowLinkImpl
