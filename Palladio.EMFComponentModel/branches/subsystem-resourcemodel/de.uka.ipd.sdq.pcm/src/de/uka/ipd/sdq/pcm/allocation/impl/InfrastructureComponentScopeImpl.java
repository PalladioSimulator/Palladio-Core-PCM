/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope;

import de.uka.ipd.sdq.pcm.allocation.util.AllocationValidator;
import de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

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
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Component Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl#getLowerLayer <em>Lower Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl#getUpperLayer <em>Upper Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl#getResourceContainer_InfrastructureComponentScope <em>Resource Container Infrastructure Component Scope</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.InfrastructureComponentScopeImpl#getAllLowerLayers <em>All Lower Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureComponentScopeImpl extends ComposedProvidingRequiringEntityImpl implements InfrastructureComponentScope {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getLowerLayer() <em>Lower Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerLayer()
	 * @generated
	 * @ordered
	 */
	protected InfrastructureComponentScope lowerLayer;
	
	/**
	 * The cached value of the '{@link #getLowerLayer() <em>All Lower Layers</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllLowerLayers()
	 * @generated not
	 * @ordered
	 */
	protected EList<InfrastructureComponentScope> allLowerLayers;

	/**
	 * The cached value of the '{@link #getUpperLayer() <em>Upper Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperLayer()
	 * @generated
	 * @ordered
	 */
	protected InfrastructureComponentScope upperLayer;

	/**
	 * The cached value of the '{@link #getResourceContainer_InfrastructureComponentScope() <em>Resource Container Infrastructure Component Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceContainer_InfrastructureComponentScope()
	 * @generated
	 * @ordered
	 */
	protected ResourceContainer resourceContainer_InfrastructureComponentScope;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ScopeMustNotContainRequiredRoles <em>Scope Must Not Contain Required Roles</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ScopeMustNotContainRequiredRoles
	 * @generated
	 */
	private static OCLExpression ScopeMustNotContainRequiredRolesInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ScopeMustNotBePartOfACircle <em>Scope Must Not Be Part Of ACircle</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ScopeMustNotBePartOfACircle
	 * @generated
	 */
	private static OCLExpression ScopeMustNotBePartOfACircleInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ScopeMustNotContainResourceRequiredRoles <em>Scope Must Not Contain Resource Required Roles</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ScopeMustNotContainResourceRequiredRoles
	 * @generated
	 */
	private static OCLExpression ScopeMustNotContainResourceRequiredRolesInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureComponentScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocationPackage.Literals.INFRASTRUCTURE_COMPONENT_SCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope getLowerLayer() {
		if (lowerLayer != null && lowerLayer.eIsProxy()) {
			InternalEObject oldLowerLayer = (InternalEObject)lowerLayer;
			lowerLayer = (InfrastructureComponentScope)eResolveProxy(oldLowerLayer);
			if (lowerLayer != oldLowerLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, oldLowerLayer, lowerLayer));
			}
		}
		return lowerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope basicGetLowerLayer() {
		return lowerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public NotificationChain basicSetLowerLayer(InfrastructureComponentScope newLowerLayer, NotificationChain msgs) {
		InfrastructureComponentScope oldLowerLayer = lowerLayer;
		lowerLayer = newLowerLayer;
		// Refresh allLowerLayers association as well
		getAllLowerLayers();
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, oldLowerLayer, newLowerLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerLayer(InfrastructureComponentScope newLowerLayer) {
		if (newLowerLayer != lowerLayer) {
			NotificationChain msgs = null;
			if (lowerLayer != null)
				msgs = ((InternalEObject)lowerLayer).eInverseRemove(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, InfrastructureComponentScope.class, msgs);
			if (newLowerLayer != null)
				msgs = ((InternalEObject)newLowerLayer).eInverseAdd(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, InfrastructureComponentScope.class, msgs);
			msgs = basicSetLowerLayer(newLowerLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, newLowerLayer, newLowerLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope getUpperLayer() {
		if (upperLayer != null && upperLayer.eIsProxy()) {
			InternalEObject oldUpperLayer = (InternalEObject)upperLayer;
			upperLayer = (InfrastructureComponentScope)eResolveProxy(oldUpperLayer);
			if (upperLayer != oldUpperLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, oldUpperLayer, upperLayer));
			}
		}
		return upperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureComponentScope basicGetUpperLayer() {
		return upperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperLayer(InfrastructureComponentScope newUpperLayer, NotificationChain msgs) {
		InfrastructureComponentScope oldUpperLayer = upperLayer;
		upperLayer = newUpperLayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, oldUpperLayer, newUpperLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperLayer(InfrastructureComponentScope newUpperLayer) {
		if (newUpperLayer != upperLayer) {
			NotificationChain msgs = null;
			if (upperLayer != null)
				msgs = ((InternalEObject)upperLayer).eInverseRemove(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, InfrastructureComponentScope.class, msgs);
			if (newUpperLayer != null)
				msgs = ((InternalEObject)newUpperLayer).eInverseAdd(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, InfrastructureComponentScope.class, msgs);
			msgs = basicSetUpperLayer(newUpperLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, newUpperLayer, newUpperLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer getResourceContainer_InfrastructureComponentScope() {
		if (resourceContainer_InfrastructureComponentScope != null && resourceContainer_InfrastructureComponentScope.eIsProxy()) {
			InternalEObject oldResourceContainer_InfrastructureComponentScope = (InternalEObject)resourceContainer_InfrastructureComponentScope;
			resourceContainer_InfrastructureComponentScope = (ResourceContainer)eResolveProxy(oldResourceContainer_InfrastructureComponentScope);
			if (resourceContainer_InfrastructureComponentScope != oldResourceContainer_InfrastructureComponentScope) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_CONTAINER_INFRASTRUCTURE_COMPONENT_SCOPE, oldResourceContainer_InfrastructureComponentScope, resourceContainer_InfrastructureComponentScope));
			}
		}
		return resourceContainer_InfrastructureComponentScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetResourceContainer_InfrastructureComponentScope() {
		return resourceContainer_InfrastructureComponentScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceContainer_InfrastructureComponentScope(ResourceContainer newResourceContainer_InfrastructureComponentScope) {
		ResourceContainer oldResourceContainer_InfrastructureComponentScope = resourceContainer_InfrastructureComponentScope;
		resourceContainer_InfrastructureComponentScope = newResourceContainer_InfrastructureComponentScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_CONTAINER_INFRASTRUCTURE_COMPONENT_SCOPE, oldResourceContainer_InfrastructureComponentScope, resourceContainer_InfrastructureComponentScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public EList<InfrastructureComponentScope> getAllLowerLayers() {
		// Clear existing list, since this method may be called after lowerLayer association has been refreshed
		allLowerLayers = new EObjectResolvingEList<InfrastructureComponentScope>(InfrastructureComponentScope.class, this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ALL_LOWER_LAYERS);
		// Search iteratively for lower layers. Stop if a cycle is found.
		InfrastructureComponentScope nextLayer = this.getLowerLayer();
		if ((nextLayer != null) && nextLayer.equals(this)) {
			allLowerLayers.add(nextLayer);
			return allLowerLayers;
		}
		while (nextLayer!= null) {
			if (nextLayer.equals(this)) {
				allLowerLayers.add(nextLayer);
				break;
			}
			allLowerLayers.add(nextLayer);
			nextLayer = nextLayer.getLowerLayer();
		}			
		return allLowerLayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ScopeMustNotContainRequiredRoles(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ScopeMustNotContainRequiredRolesInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.requiredRoles_InterfaceRequiringEntity->size() = 0 ";
			
			try {
				ScopeMustNotContainRequiredRolesInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ScopeMustNotContainRequiredRolesInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.INFRASTRUCTURE_COMPONENT_SCOPE__SCOPE_MUST_NOT_CONTAIN_REQUIRED_ROLES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ScopeMustNotContainRequiredRoles", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ScopeMustNotBePartOfACircle(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ScopeMustNotBePartOfACircleInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "not self.allLowerLayers->includes(self)   ";
			
			try {
				ScopeMustNotBePartOfACircleInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ScopeMustNotBePartOfACircleInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.INFRASTRUCTURE_COMPONENT_SCOPE__SCOPE_MUST_NOT_BE_PART_OF_ACIRCLE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ScopeMustNotBePartOfACircle", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ScopeMustNotContainResourceRequiredRoles(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ScopeMustNotContainResourceRequiredRolesInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.resourceRequiredRoles_ResourceInterfaceRequiringEntity->size() = 0 ";
			
			try {
				ScopeMustNotContainResourceRequiredRolesInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ScopeMustNotContainResourceRequiredRolesInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AllocationValidator.DIAGNOSTIC_SOURCE,
						 AllocationValidator.INFRASTRUCTURE_COMPONENT_SCOPE__SCOPE_MUST_NOT_CONTAIN_RESOURCE_REQUIRED_ROLES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ScopeMustNotContainResourceRequiredRoles", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				if (lowerLayer != null)
					msgs = ((InternalEObject)lowerLayer).eInverseRemove(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER, InfrastructureComponentScope.class, msgs);
				return basicSetLowerLayer((InfrastructureComponentScope)otherEnd, msgs);
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				if (upperLayer != null)
					msgs = ((InternalEObject)upperLayer).eInverseRemove(this, AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER, InfrastructureComponentScope.class, msgs);
				return basicSetUpperLayer((InfrastructureComponentScope)otherEnd, msgs);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				return basicSetLowerLayer(null, msgs);
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				return basicSetUpperLayer(null, msgs);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				if (resolve) return getLowerLayer();
				return basicGetLowerLayer();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				if (resolve) return getUpperLayer();
				return basicGetUpperLayer();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_CONTAINER_INFRASTRUCTURE_COMPONENT_SCOPE:
				if (resolve) return getResourceContainer_InfrastructureComponentScope();
				return basicGetResourceContainer_InfrastructureComponentScope();
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ALL_LOWER_LAYERS:
				return getAllLowerLayers();
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				setLowerLayer((InfrastructureComponentScope)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				setUpperLayer((InfrastructureComponentScope)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_CONTAINER_INFRASTRUCTURE_COMPONENT_SCOPE:
				setResourceContainer_InfrastructureComponentScope((ResourceContainer)newValue);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ALL_LOWER_LAYERS:
				getAllLowerLayers().clear();
				getAllLowerLayers().addAll((Collection<? extends InfrastructureComponentScope>)newValue);
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				setLowerLayer((InfrastructureComponentScope)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				setUpperLayer((InfrastructureComponentScope)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_CONTAINER_INFRASTRUCTURE_COMPONENT_SCOPE:
				setResourceContainer_InfrastructureComponentScope((ResourceContainer)null);
				return;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ALL_LOWER_LAYERS:
				getAllLowerLayers().clear();
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
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__LOWER_LAYER:
				return lowerLayer != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__UPPER_LAYER:
				return upperLayer != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__RESOURCE_CONTAINER_INFRASTRUCTURE_COMPONENT_SCOPE:
				return resourceContainer_InfrastructureComponentScope != null;
			case AllocationPackage.INFRASTRUCTURE_COMPONENT_SCOPE__ALL_LOWER_LAYERS:
				return !getAllLowerLayers().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InfrastructureComponentScopeImpl
