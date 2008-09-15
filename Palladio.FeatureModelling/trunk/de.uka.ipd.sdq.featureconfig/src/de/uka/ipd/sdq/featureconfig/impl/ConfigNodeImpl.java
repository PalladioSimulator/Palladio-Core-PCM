/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featureconfig.util.featureconfigValidator;
import de.uka.ipd.sdq.featuremodel.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl#getConfigState <em>Config State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigNodeImpl extends EObjectImpl implements ConfigNode {
	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected EObject origin;

	/**
	 * The default value of the '{@link #getConfigState() <em>Config State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigState()
	 * @generated
	 * @ordered
	 */
	protected static final ConfigState CONFIG_STATE_EDEFAULT = ConfigState.DEFAULT;

	/**
	 * The cached value of the '{@link #getConfigState() <em>Config State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigState()
	 * @generated
	 * @ordered
	 */
	protected ConfigState configState = CONFIG_STATE_EDEFAULT;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #ConfigCardinalityInvalid <em>Config Cardinality Invalid</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ConfigCardinalityInvalid
	 * @generated
	 */
	private static OCLExpression ConfigCardinalityInvalidInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.CONFIG_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOrigin() {
		if (origin != null && origin.eIsProxy()) {
			InternalEObject oldOrigin = (InternalEObject)origin;
			origin = eResolveProxy(oldOrigin);
			if (origin != oldOrigin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, featureconfigPackage.CONFIG_NODE__ORIGIN, oldOrigin, origin));
			}
		}
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(EObject newOrigin) {
		EObject oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIG_NODE__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigState getConfigState() {
		return configState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigState(ConfigState newConfigState) {
		ConfigState oldConfigState = configState;
		configState = newConfigState == null ? CONFIG_STATE_EDEFAULT : newConfigState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIG_NODE__CONFIG_STATE, oldConfigState, configState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ConfigCardinalityInvalid(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ConfigCardinalityInvalidInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "let childSelectedCount : Integer = self.children->select(c|c.configState = ConfigState::USER_SELECTED or c.configState = ConfigState::MASCHINE_SELECTED)->size()   in   	 if self.origin.oclIsTypeOf(featuremodel::FeatureGroup) then  	 	childSelectedCount >= self.origin.min and (childSelectedCount <= self.origin.max or self.origin.max = -1)  	 else  	 	self.origin.min  >= 1 implies (self.configState = ConfigState::USER_SELECTED or self.configState = ConfigState::MASCHINE_SELECTED)  	 endif ";
			
			try {
				ConfigCardinalityInvalidInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ConfigCardinalityInvalidInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featureconfigValidator.DIAGNOSTIC_SOURCE,
						 featureconfigValidator.CONFIG_NODE__CONFIG_CARDINALITY_INVALID,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ConfigCardinalityInvalid", EObjectValidator.getObjectLabel(this, context) }),
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				if (resolve) return getOrigin();
				return basicGetOrigin();
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				return getConfigState();
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				setOrigin((EObject)newValue);
				return;
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				setConfigState((ConfigState)newValue);
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				setOrigin((EObject)null);
				return;
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				setConfigState(CONFIG_STATE_EDEFAULT);
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				return origin != null;
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				return configState != CONFIG_STATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (configState: ");
		result.append(configState);
		result.append(')');
		return result.toString();
	}

} //ConfigNodeImpl
