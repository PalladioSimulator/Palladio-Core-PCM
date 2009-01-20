/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.util.ResourceenvironmentValidator;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerStack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceContainerImpl#getControllerInstances_ResourceContainer <em>Controller Instances Resource Container</em>}</li>
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
	 * The cached value of the '{@link #getControllerInstances_ResourceContainer() <em>Controller Instances Resource Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerInstances_ResourceContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<ControllerInstance> controllerInstances_ResourceContainer;

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
	 * The parsed OCL expression for the definition of the '{@link #ForAllControllerLayersOnlyOneLayerIsTheUppestOne <em>For All Controller Layers Only One Layer Is The Uppest One</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ForAllControllerLayersOnlyOneLayerIsTheUppestOne
	 * @generated
	 */
	private static OCLExpression ForAllControllerLayersOnlyOneLayerIsTheUppestOneInvOCL;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ForAllControllerLayersOnlyOneLayerIsTheLowestOne <em>For All Controller Layers Only One Layer Is The Lowest One</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ForAllControllerLayersOnlyOneLayerIsTheLowestOne
	 * @generated
	 */
	private static OCLExpression ForAllControllerLayersOnlyOneLayerIsTheLowestOneInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

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
	public EList<ControllerInstance> getControllerInstances_ResourceContainer() {
		if (controllerInstances_ResourceContainer == null) {
			controllerInstances_ResourceContainer = new EObjectContainmentEList<ControllerInstance>(ControllerInstance.class, this, ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCES_RESOURCE_CONTAINER);
		}
		return controllerInstances_ResourceContainer;
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
	public boolean ForAllControllerLayersOnlyOneLayerIsTheUppestOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ForAllControllerLayersOnlyOneLayerIsTheUppestOneInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.controllerInstances_ResourceContainer->select(instance|instance.controllerLayer_ControllerInstance.upperLayer->asBag()->isEmpty())->size() <= 1 ";
			
			try {
				ForAllControllerLayersOnlyOneLayerIsTheUppestOneInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ForAllControllerLayersOnlyOneLayerIsTheUppestOneInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ResourceenvironmentValidator.DIAGNOSTIC_SOURCE,
						 ResourceenvironmentValidator.RESOURCE_CONTAINER__FOR_ALL_CONTROLLER_LAYERS_ONLY_ONE_LAYER_IS_THE_UPPEST_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ForAllControllerLayersOnlyOneLayerIsTheUppestOne", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ForAllControllerLayersOnlyOneLayerIsTheLowestOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ForAllControllerLayersOnlyOneLayerIsTheLowestOneInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.controllerInstances_ResourceContainer->select(instance|instance.controllerLayer_ControllerInstance.lowerLayer->asBag()->isEmpty())->size() <= 1 ";
			
			try {
				ForAllControllerLayersOnlyOneLayerIsTheLowestOneInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ForAllControllerLayersOnlyOneLayerIsTheLowestOneInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ResourceenvironmentValidator.DIAGNOSTIC_SOURCE,
						 ResourceenvironmentValidator.RESOURCE_CONTAINER__FOR_ALL_CONTROLLER_LAYERS_ONLY_ONE_LAYER_IS_THE_LOWEST_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ForAllControllerLayersOnlyOneLayerIsTheLowestOne", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return ((InternalEList<?>)getActiveResourceSpecifications_ResourceContainer()).basicRemove(otherEnd, msgs);
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCES_RESOURCE_CONTAINER:
				return ((InternalEList<?>)getControllerInstances_ResourceContainer()).basicRemove(otherEnd, msgs);
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return getActiveResourceSpecifications_ResourceContainer();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCES_RESOURCE_CONTAINER:
				return getControllerInstances_ResourceContainer();
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getActiveResourceSpecifications_ResourceContainer().clear();
				getActiveResourceSpecifications_ResourceContainer().addAll((Collection<? extends ProcessingResourceSpecification>)newValue);
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCES_RESOURCE_CONTAINER:
				getControllerInstances_ResourceContainer().clear();
				getControllerInstances_ResourceContainer().addAll((Collection<? extends ControllerInstance>)newValue);
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				getActiveResourceSpecifications_ResourceContainer().clear();
				return;
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCES_RESOURCE_CONTAINER:
				getControllerInstances_ResourceContainer().clear();
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
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER:
				return activeResourceSpecifications_ResourceContainer != null && !activeResourceSpecifications_ResourceContainer.isEmpty();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_INSTANCES_RESOURCE_CONTAINER:
				return controllerInstances_ResourceContainer != null && !controllerInstances_ResourceContainer.isEmpty();
			case ResourceenvironmentPackage.RESOURCE_CONTAINER__CONTROLLER_STACK_RESOURCE_CONTAINER:
				return controllerStack_ResourceContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceContainerImpl
