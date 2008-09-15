/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;
import de.uka.ipd.sdq.featuremodel.util.featuremodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureGroupImpl#getMin <em>Min</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureGroupImpl#getMax <em>Max</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureGroupImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureGroupImpl extends NodeImpl implements FeatureGroup {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007-2008, SDQ, IPD, U Karlsruhe, Germany";
	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_EDEFAULT = 1;
	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected int min = MIN_EDEFAULT;
	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EDEFAULT = 1;
	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected int max = MAX_EDEFAULT;
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> children;

	/**
	 * The parsed OCL expression for the definition of the '{@link #XORorORImpliesChildrenAreMandatory <em>XO Ror OR Implies Children Are Mandatory</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XORorORImpliesChildrenAreMandatory
	 * @generated
	 */
	private static OCLExpression XORorORImpliesChildrenAreMandatoryInvOCL;
	/**
	 * The parsed OCL expression for the definition of the '{@link #ALLImpliesCardinalitiesToBeMinusOne <em>ALL Implies Cardinalities To Be Minus One</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALLImpliesCardinalitiesToBeMinusOne
	 * @generated
	 */
	private static OCLExpression ALLImpliesCardinalitiesToBeMinusOneInvOCL;
	/**
	 * The parsed OCL expression for the definition of the '{@link #ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne <em>OR Implies Cardinalities Min To Be One And Max To Be Minus One</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne
	 * @generated
	 */
	private static OCLExpression ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOneInvOCL;
	/**
	 * The parsed OCL expression for the definition of the '{@link #XORImpliesCardinalitiesToBeOne <em>XOR Implies Cardinalities To Be One</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XORImpliesCardinalitiesToBeOne
	 * @generated
	 */
	private static OCLExpression XORImpliesCardinalitiesToBeOneInvOCL;
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.FEATURE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin(int newMin) {
		int oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE_GROUP__MIN, oldMin, min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax(int newMax) {
		int oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE_GROUP__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<Feature>(Feature.class, this, featuremodelPackage.FEATURE_GROUP__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean XORorORImpliesChildrenAreMandatory(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (XORorORImpliesChildrenAreMandatoryInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "(self.groupType = GroupTypes::OR or self.groupType = GroupTypes::XOR) implies self.children->forAll(c|c.isMandatory)  ";
			
			try {
				XORorORImpliesChildrenAreMandatoryInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(XORorORImpliesChildrenAreMandatoryInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featuremodelValidator.DIAGNOSTIC_SOURCE,
						 featuremodelValidator.FEATURE_GROUP__XO_ROR_OR_IMPLIES_CHILDREN_ARE_MANDATORY,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "XORorORImpliesChildrenAreMandatory", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ALLImpliesCardinalitiesToBeMinusOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ALLImpliesCardinalitiesToBeMinusOneInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.groupType = GroupTypes::ALL implies (self.min = -1 and self.max = -1) ";
			
			try {
				ALLImpliesCardinalitiesToBeMinusOneInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ALLImpliesCardinalitiesToBeMinusOneInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featuremodelValidator.DIAGNOSTIC_SOURCE,
						 featuremodelValidator.FEATURE_GROUP__ALL_IMPLIES_CARDINALITIES_TO_BE_MINUS_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ALLImpliesCardinalitiesToBeMinusOne", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOneInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.groupType = GroupTypes::OR implies (self.min = 1  and self.max = -1) ";
			
			try {
				ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOneInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOneInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featuremodelValidator.DIAGNOSTIC_SOURCE,
						 featuremodelValidator.FEATURE_GROUP__OR_IMPLIES_CARDINALITIES_MIN_TO_BE_ONE_AND_MAX_TO_BE_MINUS_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean XORImpliesCardinalitiesToBeOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (XORImpliesCardinalitiesToBeOneInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.groupType = GroupTypes::XOR implies (self.min = 1 and self.max = 1)  ";
			
			try {
				XORImpliesCardinalitiesToBeOneInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(XORImpliesCardinalitiesToBeOneInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featuremodelValidator.DIAGNOSTIC_SOURCE,
						 featuremodelValidator.FEATURE_GROUP__XOR_IMPLIES_CARDINALITIES_TO_BE_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "XORImpliesCardinalitiesToBeOne", EObjectValidator.getObjectLabel(this, context) }),
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
			case featuremodelPackage.FEATURE_GROUP__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case featuremodelPackage.FEATURE_GROUP__MIN:
				return new Integer(getMin());
			case featuremodelPackage.FEATURE_GROUP__MAX:
				return new Integer(getMax());
			case featuremodelPackage.FEATURE_GROUP__CHILDREN:
				return getChildren();
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
			case featuremodelPackage.FEATURE_GROUP__MIN:
				setMin(((Integer)newValue).intValue());
				return;
			case featuremodelPackage.FEATURE_GROUP__MAX:
				setMax(((Integer)newValue).intValue());
				return;
			case featuremodelPackage.FEATURE_GROUP__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Feature>)newValue);
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
			case featuremodelPackage.FEATURE_GROUP__MIN:
				setMin(MIN_EDEFAULT);
				return;
			case featuremodelPackage.FEATURE_GROUP__MAX:
				setMax(MAX_EDEFAULT);
				return;
			case featuremodelPackage.FEATURE_GROUP__CHILDREN:
				getChildren().clear();
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
			case featuremodelPackage.FEATURE_GROUP__MIN:
				return min != MIN_EDEFAULT;
			case featuremodelPackage.FEATURE_GROUP__MAX:
				return max != MAX_EDEFAULT;
			case featuremodelPackage.FEATURE_GROUP__CHILDREN:
				return children != null && !children.isEmpty();
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
		result.append(" (min: ");
		result.append(min);
		result.append(", max: ");
		result.append(max);
		result.append(')');
		return result.toString();
	}

} //FeatureGroupImpl
