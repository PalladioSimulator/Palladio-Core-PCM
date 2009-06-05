/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.performance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametric Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.performance.impl.ParametricResourceDemandImpl#getSpecification_ParametericResourceDemand <em>Specification Parameteric Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.performance.impl.ParametricResourceDemandImpl#getResourceRequiredRole_ParametricResourceDemand <em>Resource Required Role Parametric Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.performance.impl.ParametricResourceDemandImpl#getCalledResourceService_ParametricResourceDemand <em>Called Resource Service Parametric Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.performance.impl.ParametricResourceDemandImpl#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParametricResourceDemandImpl extends EObjectImpl implements ParametricResourceDemand {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSpecification_ParametericResourceDemand() <em>Specification Parameteric Resource Demand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification_ParametericResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable specification_ParametericResourceDemand;

	/**
	 * The cached value of the '{@link #getResourceRequiredRole_ParametricResourceDemand() <em>Resource Required Role Parametric Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequiredRole_ParametricResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected ResourceRequiredRole resourceRequiredRole_ParametricResourceDemand;

	/**
	 * The cached value of the '{@link #getCalledResourceService_ParametricResourceDemand() <em>Called Resource Service Parametric Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledResourceService_ParametricResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected ResourceService calledResourceService_ParametricResourceDemand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParametricResourceDemandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PerformancePackage.Literals.PARAMETRIC_RESOURCE_DEMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getSpecification_ParametericResourceDemand() {
		return specification_ParametericResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification_ParametericResourceDemand(PCMRandomVariable newSpecification_ParametericResourceDemand, NotificationChain msgs) {
		PCMRandomVariable oldSpecification_ParametericResourceDemand = specification_ParametericResourceDemand;
		specification_ParametericResourceDemand = newSpecification_ParametericResourceDemand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND, oldSpecification_ParametericResourceDemand, newSpecification_ParametericResourceDemand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification_ParametericResourceDemand(PCMRandomVariable newSpecification_ParametericResourceDemand) {
		if (newSpecification_ParametericResourceDemand != specification_ParametericResourceDemand) {
			NotificationChain msgs = null;
			if (specification_ParametericResourceDemand != null)
				msgs = ((InternalEObject)specification_ParametericResourceDemand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND, null, msgs);
			if (newSpecification_ParametericResourceDemand != null)
				msgs = ((InternalEObject)newSpecification_ParametericResourceDemand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND, null, msgs);
			msgs = basicSetSpecification_ParametericResourceDemand(newSpecification_ParametericResourceDemand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND, newSpecification_ParametericResourceDemand, newSpecification_ParametericResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole getResourceRequiredRole_ParametricResourceDemand() {
		if (resourceRequiredRole_ParametricResourceDemand != null && resourceRequiredRole_ParametricResourceDemand.eIsProxy()) {
			InternalEObject oldResourceRequiredRole_ParametricResourceDemand = (InternalEObject)resourceRequiredRole_ParametricResourceDemand;
			resourceRequiredRole_ParametricResourceDemand = (ResourceRequiredRole)eResolveProxy(oldResourceRequiredRole_ParametricResourceDemand);
			if (resourceRequiredRole_ParametricResourceDemand != oldResourceRequiredRole_ParametricResourceDemand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__RESOURCE_REQUIRED_ROLE_PARAMETRIC_RESOURCE_DEMAND, oldResourceRequiredRole_ParametricResourceDemand, resourceRequiredRole_ParametricResourceDemand));
			}
		}
		return resourceRequiredRole_ParametricResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetResourceRequiredRole_ParametricResourceDemand() {
		return resourceRequiredRole_ParametricResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiredRole_ParametricResourceDemand(ResourceRequiredRole newResourceRequiredRole_ParametricResourceDemand) {
		ResourceRequiredRole oldResourceRequiredRole_ParametricResourceDemand = resourceRequiredRole_ParametricResourceDemand;
		resourceRequiredRole_ParametricResourceDemand = newResourceRequiredRole_ParametricResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__RESOURCE_REQUIRED_ROLE_PARAMETRIC_RESOURCE_DEMAND, oldResourceRequiredRole_ParametricResourceDemand, resourceRequiredRole_ParametricResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceService getCalledResourceService_ParametricResourceDemand() {
		if (calledResourceService_ParametricResourceDemand != null && calledResourceService_ParametricResourceDemand.eIsProxy()) {
			InternalEObject oldCalledResourceService_ParametricResourceDemand = (InternalEObject)calledResourceService_ParametricResourceDemand;
			calledResourceService_ParametricResourceDemand = (ResourceService)eResolveProxy(oldCalledResourceService_ParametricResourceDemand);
			if (calledResourceService_ParametricResourceDemand != oldCalledResourceService_ParametricResourceDemand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__CALLED_RESOURCE_SERVICE_PARAMETRIC_RESOURCE_DEMAND, oldCalledResourceService_ParametricResourceDemand, calledResourceService_ParametricResourceDemand));
			}
		}
		return calledResourceService_ParametricResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceService basicGetCalledResourceService_ParametricResourceDemand() {
		return calledResourceService_ParametricResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledResourceService_ParametricResourceDemand(ResourceService newCalledResourceService_ParametricResourceDemand) {
		ResourceService oldCalledResourceService_ParametricResourceDemand = calledResourceService_ParametricResourceDemand;
		calledResourceService_ParametricResourceDemand = newCalledResourceService_ParametricResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__CALLED_RESOURCE_SERVICE_PARAMETRIC_RESOURCE_DEMAND, oldCalledResourceService_ParametricResourceDemand, calledResourceService_ParametricResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractInternalControlFlowAction getAction_ParametricResourceDemand() {
		if (eContainerFeatureID != PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND) return null;
		return (AbstractInternalControlFlowAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAction_ParametricResourceDemand(AbstractInternalControlFlowAction newAction_ParametricResourceDemand, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAction_ParametricResourceDemand, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction_ParametricResourceDemand(AbstractInternalControlFlowAction newAction_ParametricResourceDemand) {
		if (newAction_ParametricResourceDemand != eInternalContainer() || (eContainerFeatureID != PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND && newAction_ParametricResourceDemand != null)) {
			if (EcoreUtil.isAncestor(this, newAction_ParametricResourceDemand))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAction_ParametricResourceDemand != null)
				msgs = ((InternalEObject)newAction_ParametricResourceDemand).eInverseAdd(this, SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION, AbstractInternalControlFlowAction.class, msgs);
			msgs = basicSetAction_ParametricResourceDemand(newAction_ParametricResourceDemand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND, newAction_ParametricResourceDemand, newAction_ParametricResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAction_ParametricResourceDemand((AbstractInternalControlFlowAction)otherEnd, msgs);
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
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
				return basicSetSpecification_ParametericResourceDemand(null, msgs);
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
				return basicSetAction_ParametricResourceDemand(null, msgs);
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
		switch (eContainerFeatureID) {
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
				return eInternalContainer().eInverseRemove(this, SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION, AbstractInternalControlFlowAction.class, msgs);
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
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
				return getSpecification_ParametericResourceDemand();
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__RESOURCE_REQUIRED_ROLE_PARAMETRIC_RESOURCE_DEMAND:
				if (resolve) return getResourceRequiredRole_ParametricResourceDemand();
				return basicGetResourceRequiredRole_ParametricResourceDemand();
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__CALLED_RESOURCE_SERVICE_PARAMETRIC_RESOURCE_DEMAND:
				if (resolve) return getCalledResourceService_ParametricResourceDemand();
				return basicGetCalledResourceService_ParametricResourceDemand();
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
				return getAction_ParametricResourceDemand();
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
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
				setSpecification_ParametericResourceDemand((PCMRandomVariable)newValue);
				return;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__RESOURCE_REQUIRED_ROLE_PARAMETRIC_RESOURCE_DEMAND:
				setResourceRequiredRole_ParametricResourceDemand((ResourceRequiredRole)newValue);
				return;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__CALLED_RESOURCE_SERVICE_PARAMETRIC_RESOURCE_DEMAND:
				setCalledResourceService_ParametricResourceDemand((ResourceService)newValue);
				return;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
				setAction_ParametricResourceDemand((AbstractInternalControlFlowAction)newValue);
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
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
				setSpecification_ParametericResourceDemand((PCMRandomVariable)null);
				return;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__RESOURCE_REQUIRED_ROLE_PARAMETRIC_RESOURCE_DEMAND:
				setResourceRequiredRole_ParametricResourceDemand((ResourceRequiredRole)null);
				return;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__CALLED_RESOURCE_SERVICE_PARAMETRIC_RESOURCE_DEMAND:
				setCalledResourceService_ParametricResourceDemand((ResourceService)null);
				return;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
				setAction_ParametricResourceDemand((AbstractInternalControlFlowAction)null);
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
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
				return specification_ParametericResourceDemand != null;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__RESOURCE_REQUIRED_ROLE_PARAMETRIC_RESOURCE_DEMAND:
				return resourceRequiredRole_ParametricResourceDemand != null;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__CALLED_RESOURCE_SERVICE_PARAMETRIC_RESOURCE_DEMAND:
				return calledResourceService_ParametricResourceDemand != null;
			case PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
				return getAction_ParametricResourceDemand() != null;
		}
		return super.eIsSet(featureID);
	}

} //ParametricResourceDemandImpl
