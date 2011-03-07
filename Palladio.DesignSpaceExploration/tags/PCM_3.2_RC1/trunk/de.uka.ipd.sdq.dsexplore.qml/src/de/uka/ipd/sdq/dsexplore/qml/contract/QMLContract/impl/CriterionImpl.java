/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.util.QMLContractValidator;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

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

import org.eclipse.ocl.ParserException;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Criterion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.CriterionImpl#getDimension <em>Dimension</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.CriterionImpl#getAspects <em>Aspects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CriterionImpl extends IdentifierImpl implements Criterion {
	/**
	 * The cached value of the '{@link #getDimension() <em>Dimension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
	protected Dimension dimension;

	/**
	 * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspects()
	 * @generated
	 * @ordered
	 */
	protected EList<EvaluationAspect> aspects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CriterionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLContractPackage.Literals.CRITERION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getDimension() {
		if (dimension != null && dimension.eIsProxy()) {
			InternalEObject oldDimension = (InternalEObject)dimension;
			dimension = (Dimension)eResolveProxy(oldDimension);
			if (dimension != oldDimension) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QMLContractPackage.CRITERION__DIMENSION, oldDimension, dimension));
			}
		}
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension basicGetDimension() {
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimension(Dimension newDimension) {
		Dimension oldDimension = dimension;
		dimension = newDimension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLContractPackage.CRITERION__DIMENSION, oldDimension, dimension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationAspect> getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentEList<EvaluationAspect>(EvaluationAspect.class, this, QMLContractPackage.CRITERION__ASPECTS);
		}
		return aspects;
	}

	/**
	 * The cached OCL expression body for the '{@link #Only_CONSTRAINTS_have_RESTRICTIONS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Only CONSTRAINTS have RESTRICTIONS</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Only_CONSTRAINTS_have_RESTRICTIONS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ONLY_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.aspects->exists(a|a.aspectRequirement <> null and a.aspectRequirement.oclIsTypeOf(QMLContract::Restriction)) implies ("+
"	self.oclIsTypeOf(QMLContract::Constraint)"+
")";

	/**
	 * The cached OCL invariant for the '{@link #Only_CONSTRAINTS_have_RESTRICTIONS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Only CONSTRAINTS have RESTRICTIONS</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Only_CONSTRAINTS_have_RESTRICTIONS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ONLY_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Only_CONSTRAINTS_have_RESTRICTIONS(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ONLY_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QMLContractPackage.Literals.CRITERION);
			try {
				ONLY_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ONLY_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ONLY_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QMLContractValidator.DIAGNOSTIC_SOURCE,
						 QMLContractValidator.CRITERION__ONLY_CONSTRAINTS_HAVE_RESTRICTIONS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Only_CONSTRAINTS_have_RESTRICTIONS", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #FREQUENCY_only_possible_if_DIMENSION_is_ordered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>FREQUENCY only possible if DIMENSION is ordered</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREQUENCY_only_possible_if_DIMENSION_is_ordered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String FREQUENCY_ONLY_POSSIBLE_IF_DIMENSION_IS_ORDERED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.aspects->forAll(aspect|"+
"	aspect.oclIsTypeOf(QMLContract::Frequency) implies ("+
"		self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeNumeric) or"+
"		(self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeEnum) and self.dimension.type.oclAsType(QMLContractType::DimensionTypeEnum).order->size()>0 ) or "+
"		(self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeSet) and self.dimension.type.oclAsType(QMLContractType::DimensionTypeSet).order->size()>0 )"+
"	)"+
")";

	/**
	 * The cached OCL invariant for the '{@link #FREQUENCY_only_possible_if_DIMENSION_is_ordered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>FREQUENCY only possible if DIMENSION is ordered</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREQUENCY_only_possible_if_DIMENSION_is_ordered(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint FREQUENCY_ONLY_POSSIBLE_IF_DIMENSION_IS_ORDERED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean FREQUENCY_only_possible_if_DIMENSION_is_ordered(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (FREQUENCY_ONLY_POSSIBLE_IF_DIMENSION_IS_ORDERED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QMLContractPackage.Literals.CRITERION);
			try {
				FREQUENCY_ONLY_POSSIBLE_IF_DIMENSION_IS_ORDERED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(FREQUENCY_ONLY_POSSIBLE_IF_DIMENSION_IS_ORDERED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(FREQUENCY_ONLY_POSSIBLE_IF_DIMENSION_IS_ORDERED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QMLContractValidator.DIAGNOSTIC_SOURCE,
						 QMLContractValidator.CRITERION__FREQUENCY_ONLY_POSSIBLE_IF_DIMENSION_IS_ORDERED,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "FREQUENCY_only_possible_if_DIMENSION_is_ordered", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #POINTESTIMATOR_only_for_numeric_dimensions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>POINTESTIMATOR only for numeric dimensions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POINTESTIMATOR_only_for_numeric_dimensions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String POINTESTIMATOR_ONLY_FOR_NUMERIC_DIMENSIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.aspects->forAll(aspect|"+
"	aspect.oclIsTypeOf(QMLContract::PointEstimator) implies ("+
"		self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeNumeric)"+
"	)"+
")";

	/**
	 * The cached OCL invariant for the '{@link #POINTESTIMATOR_only_for_numeric_dimensions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>POINTESTIMATOR only for numeric dimensions</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POINTESTIMATOR_only_for_numeric_dimensions(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint POINTESTIMATOR_ONLY_FOR_NUMERIC_DIMENSIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean POINTESTIMATOR_only_for_numeric_dimensions(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (POINTESTIMATOR_ONLY_FOR_NUMERIC_DIMENSIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QMLContractPackage.Literals.CRITERION);
			try {
				POINTESTIMATOR_ONLY_FOR_NUMERIC_DIMENSIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(POINTESTIMATOR_ONLY_FOR_NUMERIC_DIMENSIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(POINTESTIMATOR_ONLY_FOR_NUMERIC_DIMENSIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QMLContractValidator.DIAGNOSTIC_SOURCE,
						 QMLContractValidator.CRITERION__POINTESTIMATOR_ONLY_FOR_NUMERIC_DIMENSIONS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "POINTESTIMATOR_only_for_numeric_dimensions", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #Only_OBJECTIVES_have_GOALS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Only OBJECTIVES have GOALS</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Only_OBJECTIVES_have_GOALS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ONLY_OBJECTIVES_HAVE_GOALS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.aspects->exists(a|a.aspectRequirement <> null and a.aspectRequirement.oclIsTypeOf(QMLContract::Goal)) implies ("+
"	self.oclIsTypeOf(QMLContract::Objective)"+
")";

	/**
	 * The cached OCL invariant for the '{@link #Only_OBJECTIVES_have_GOALS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Only OBJECTIVES have GOALS</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Only_OBJECTIVES_have_GOALS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ONLY_OBJECTIVES_HAVE_GOALS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Only_OBJECTIVES_have_GOALS(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ONLY_OBJECTIVES_HAVE_GOALS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QMLContractPackage.Literals.CRITERION);
			try {
				ONLY_OBJECTIVES_HAVE_GOALS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ONLY_OBJECTIVES_HAVE_GOALS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ONLY_OBJECTIVES_HAVE_GOALS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QMLContractValidator.DIAGNOSTIC_SOURCE,
						 QMLContractValidator.CRITERION__ONLY_OBJECTIVES_HAVE_GOALS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Only_OBJECTIVES_have_GOALS", EObjectValidator.getObjectLabel(this, context) }),
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
			case QMLContractPackage.CRITERION__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
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
			case QMLContractPackage.CRITERION__DIMENSION:
				if (resolve) return getDimension();
				return basicGetDimension();
			case QMLContractPackage.CRITERION__ASPECTS:
				return getAspects();
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
			case QMLContractPackage.CRITERION__DIMENSION:
				setDimension((Dimension)newValue);
				return;
			case QMLContractPackage.CRITERION__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends EvaluationAspect>)newValue);
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
			case QMLContractPackage.CRITERION__DIMENSION:
				setDimension((Dimension)null);
				return;
			case QMLContractPackage.CRITERION__ASPECTS:
				getAspects().clear();
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
			case QMLContractPackage.CRITERION__DIMENSION:
				return dimension != null;
			case QMLContractPackage.CRITERION__ASPECTS:
				return aspects != null && !aspects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //CriterionImpl
