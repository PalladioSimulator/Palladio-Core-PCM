/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerLayer;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.resourcetype.util.ResourcetypeValidator;
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
import org.eclipse.emf.ecore.impl.EObjectImpl;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controller Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl#getUpperLayer <em>Upper Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl#getLowerLayer <em>Lower Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl#getControllerType_ControllerLayer <em>Controller Type Controller Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ControllerLayerImpl#getAllLowerLayers <em>All Lower Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControllerLayerImpl extends EObjectImpl implements ControllerLayer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getUpperLayer() <em>Upper Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperLayer()
	 * @generated
	 * @ordered
	 */
	protected ControllerLayer upperLayer;

	/**
	 * The cached value of the '{@link #getLowerLayer() <em>Lower Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerLayer()
	 * @generated
	 * @ordered
	 */
	protected ControllerLayer lowerLayer;
	
	/**
	 * The cached value of the '{@link #getLowerLayer() <em>All Lower Layers</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllLowerLayers()
	 * @generated not
	 * @ordered
	 */
	protected EList<ControllerLayer> allLowerLayers;

	/**
	 * The cached value of the '{@link #getControllerType_ControllerLayer() <em>Controller Type Controller Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerType_ControllerLayer()
	 * @generated
	 * @ordered
	 */
	protected ControllerType controllerType_ControllerLayer;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ControllerLayerMustNotBePartOfACircle <em>Controller Layer Must Not Be Part Of ACircle</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ControllerLayerMustNotBePartOfACircle
	 * @generated
	 */
	private static OCLExpression ControllerLayerMustNotBePartOfACircleInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControllerLayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcetypePackage.Literals.CONTROLLER_LAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer getUpperLayer() {
		if (upperLayer != null && upperLayer.eIsProxy()) {
			InternalEObject oldUpperLayer = (InternalEObject)upperLayer;
			upperLayer = (ControllerLayer)eResolveProxy(oldUpperLayer);
			if (upperLayer != oldUpperLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, oldUpperLayer, upperLayer));
			}
		}
		return upperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer basicGetUpperLayer() {
		return upperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperLayer(ControllerLayer newUpperLayer, NotificationChain msgs) {
		ControllerLayer oldUpperLayer = upperLayer;
		upperLayer = newUpperLayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, oldUpperLayer, newUpperLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperLayer(ControllerLayer newUpperLayer) {
		if (newUpperLayer != upperLayer) {
			NotificationChain msgs = null;
			if (upperLayer != null)
				msgs = ((InternalEObject)upperLayer).eInverseRemove(this, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, ControllerLayer.class, msgs);
			if (newUpperLayer != null)
				msgs = ((InternalEObject)newUpperLayer).eInverseAdd(this, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, ControllerLayer.class, msgs);
			msgs = basicSetUpperLayer(newUpperLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, newUpperLayer, newUpperLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer getLowerLayer() {
		if (lowerLayer != null && lowerLayer.eIsProxy()) {
			InternalEObject oldLowerLayer = (InternalEObject)lowerLayer;
			lowerLayer = (ControllerLayer)eResolveProxy(oldLowerLayer);
			if (lowerLayer != oldLowerLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, oldLowerLayer, lowerLayer));
			}
		}
		return lowerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerLayer basicGetLowerLayer() {
		return lowerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public NotificationChain basicSetLowerLayer(ControllerLayer newLowerLayer, NotificationChain msgs) {
		ControllerLayer oldLowerLayer = lowerLayer;
		lowerLayer = newLowerLayer;
		// Refresh allLowerLayers association as well
		getAllLowerLayers();
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, oldLowerLayer, newLowerLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerLayer(ControllerLayer newLowerLayer) {
		if (newLowerLayer != lowerLayer) {
			NotificationChain msgs = null;
			if (lowerLayer != null)
				msgs = ((InternalEObject)lowerLayer).eInverseRemove(this, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, ControllerLayer.class, msgs);
			if (newLowerLayer != null)
				msgs = ((InternalEObject)newLowerLayer).eInverseAdd(this, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, ControllerLayer.class, msgs);
			msgs = basicSetLowerLayer(newLowerLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, newLowerLayer, newLowerLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerType getControllerType_ControllerLayer() {
		if (controllerType_ControllerLayer != null && controllerType_ControllerLayer.eIsProxy()) {
			InternalEObject oldControllerType_ControllerLayer = (InternalEObject)controllerType_ControllerLayer;
			controllerType_ControllerLayer = (ControllerType)eResolveProxy(oldControllerType_ControllerLayer);
			if (controllerType_ControllerLayer != oldControllerType_ControllerLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_LAYER, oldControllerType_ControllerLayer, controllerType_ControllerLayer));
			}
		}
		return controllerType_ControllerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerType basicGetControllerType_ControllerLayer() {
		return controllerType_ControllerLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllerType_ControllerLayer(ControllerType newControllerType_ControllerLayer) {
		ControllerType oldControllerType_ControllerLayer = controllerType_ControllerLayer;
		controllerType_ControllerLayer = newControllerType_ControllerLayer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_LAYER, oldControllerType_ControllerLayer, controllerType_ControllerLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public EList<ControllerLayer> getAllLowerLayers() {
		// Clear existing list, since this method may be called after lowerLayer association has been refreshed
		allLowerLayers = new EObjectResolvingEList<ControllerLayer>(InfrastructureComponentScope.class, this, ResourcetypePackage.CONTROLLER_LAYER__ALL_LOWER_LAYERS);
		// Search iteratively for lower layers. Stop if a circle is found.
		ControllerLayer nextLayer = this.getLowerLayer();
		if ((nextLayer != null) && nextLayer.equals(this)) {
			allLowerLayers.add(nextLayer);
			return allLowerLayers;
		}
		while ((nextLayer!= null)) {
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
	public boolean ControllerLayerMustNotBePartOfACircle(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ControllerLayerMustNotBePartOfACircleInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "not self.allLowerLayers->includes(self) ";
			
			try {
				ControllerLayerMustNotBePartOfACircleInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ControllerLayerMustNotBePartOfACircleInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ResourcetypeValidator.DIAGNOSTIC_SOURCE,
						 ResourcetypeValidator.CONTROLLER_LAYER__CONTROLLER_LAYER_MUST_NOT_BE_PART_OF_ACIRCLE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ControllerLayerMustNotBePartOfACircle", EObjectValidator.getObjectLabel(this, context) }),
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				if (upperLayer != null)
					msgs = ((InternalEObject)upperLayer).eInverseRemove(this, ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER, ControllerLayer.class, msgs);
				return basicSetUpperLayer((ControllerLayer)otherEnd, msgs);
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				if (lowerLayer != null)
					msgs = ((InternalEObject)lowerLayer).eInverseRemove(this, ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER, ControllerLayer.class, msgs);
				return basicSetLowerLayer((ControllerLayer)otherEnd, msgs);
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				return basicSetUpperLayer(null, msgs);
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				return basicSetLowerLayer(null, msgs);
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				if (resolve) return getUpperLayer();
				return basicGetUpperLayer();
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				if (resolve) return getLowerLayer();
				return basicGetLowerLayer();
			case ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_LAYER:
				if (resolve) return getControllerType_ControllerLayer();
				return basicGetControllerType_ControllerLayer();
			case ResourcetypePackage.CONTROLLER_LAYER__ALL_LOWER_LAYERS:
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				setUpperLayer((ControllerLayer)newValue);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				setLowerLayer((ControllerLayer)newValue);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_LAYER:
				setControllerType_ControllerLayer((ControllerType)newValue);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__ALL_LOWER_LAYERS:
				getAllLowerLayers().clear();
				getAllLowerLayers().addAll((Collection<? extends ControllerLayer>)newValue);
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				setUpperLayer((ControllerLayer)null);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				setLowerLayer((ControllerLayer)null);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_LAYER:
				setControllerType_ControllerLayer((ControllerType)null);
				return;
			case ResourcetypePackage.CONTROLLER_LAYER__ALL_LOWER_LAYERS:
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
			case ResourcetypePackage.CONTROLLER_LAYER__UPPER_LAYER:
				return upperLayer != null;
			case ResourcetypePackage.CONTROLLER_LAYER__LOWER_LAYER:
				return lowerLayer != null;
			case ResourcetypePackage.CONTROLLER_LAYER__CONTROLLER_TYPE_CONTROLLER_LAYER:
				return controllerType_ControllerLayer != null;
			case ResourcetypePackage.CONTROLLER_LAYER__ALL_LOWER_LAYERS:
				return !getAllLowerLayers().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ControllerLayerImpl
