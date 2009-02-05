/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import de.uka.ipd.sdq.featureconfig.ConfigFeatureGroup;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
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
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featureconfig.util.featureconfigValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getConfignode <em>Confignode</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getConfigfeaturegroup <em>Configfeaturegroup</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureConfigImpl extends EObjectImpl implements FeatureConfig {
	/**
	 * The cached value of the '{@link #getReferencedObject() <em>Referenced Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedObject()
	 * @generated
	 * @ordered
	 */
	protected EObject referencedObject;

	/**
	 * The cached value of the '{@link #getConfignode() <em>Confignode</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfignode()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigNode> confignode;

	/**
	 * The cached value of the '{@link #getConfigfeaturegroup() <em>Configfeaturegroup</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigfeaturegroup()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigFeatureGroup> configfeaturegroup;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.FEATURE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getReferencedObject() {
		if (referencedObject != null && referencedObject.eIsProxy()) {
			InternalEObject oldReferencedObject = (InternalEObject)referencedObject;
			referencedObject = eResolveProxy(oldReferencedObject);
			if (referencedObject != oldReferencedObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, featureconfigPackage.FEATURE_CONFIG__REFERENCED_OBJECT, oldReferencedObject, referencedObject));
			}
		}
		return referencedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetReferencedObject() {
		return referencedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedObject(EObject newReferencedObject) {
		EObject oldReferencedObject = referencedObject;
		referencedObject = newReferencedObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.FEATURE_CONFIG__REFERENCED_OBJECT, oldReferencedObject, referencedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigNode> getConfignode() {
		if (confignode == null) {
			confignode = new EObjectContainmentEList<ConfigNode>(ConfigNode.class, this, featureconfigPackage.FEATURE_CONFIG__CONFIGNODE);
		}
		return confignode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigFeatureGroup> getConfigfeaturegroup() {
		if (configfeaturegroup == null) {
			configfeaturegroup = new EObjectContainmentEList<ConfigFeatureGroup>(ConfigFeatureGroup.class, this, featureconfigPackage.FEATURE_CONFIG__CONFIGFEATUREGROUP);
		}
		return configfeaturegroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean RootIsFeatureModel(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featureconfigValidator.DIAGNOSTIC_SOURCE,
						 featureconfigValidator.FEATURE_CONFIG__ROOT_IS_FEATURE_MODEL,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "RootIsFeatureModel", EObjectValidator.getObjectLabel(this, context) }),
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
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				return ((InternalEList<?>)getConfignode()).basicRemove(otherEnd, msgs);
			case featureconfigPackage.FEATURE_CONFIG__CONFIGFEATUREGROUP:
				return ((InternalEList<?>)getConfigfeaturegroup()).basicRemove(otherEnd, msgs);
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
			case featureconfigPackage.FEATURE_CONFIG__REFERENCED_OBJECT:
				if (resolve) return getReferencedObject();
				return basicGetReferencedObject();
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				return getConfignode();
			case featureconfigPackage.FEATURE_CONFIG__CONFIGFEATUREGROUP:
				return getConfigfeaturegroup();
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
			case featureconfigPackage.FEATURE_CONFIG__REFERENCED_OBJECT:
				setReferencedObject((EObject)newValue);
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				getConfignode().clear();
				getConfignode().addAll((Collection<? extends ConfigNode>)newValue);
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGFEATUREGROUP:
				getConfigfeaturegroup().clear();
				getConfigfeaturegroup().addAll((Collection<? extends ConfigFeatureGroup>)newValue);
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
			case featureconfigPackage.FEATURE_CONFIG__REFERENCED_OBJECT:
				setReferencedObject((EObject)null);
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				getConfignode().clear();
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGFEATUREGROUP:
				getConfigfeaturegroup().clear();
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
			case featureconfigPackage.FEATURE_CONFIG__REFERENCED_OBJECT:
				return referencedObject != null;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				return confignode != null && !confignode.isEmpty();
			case featureconfigPackage.FEATURE_CONFIG__CONFIGFEATUREGROUP:
				return configfeaturegroup != null && !configfeaturegroup.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FeatureConfigImpl
