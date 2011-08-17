/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.util.QMLContractValidator;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType;

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
 * An implementation of the model object '<em><b>Simple QML Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SimpleQMLContractImpl#getCriteria <em>Criteria</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.SimpleQMLContractImpl#getContractType <em>Contract Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleQMLContractImpl extends GenericQMLContractImpl implements SimpleQMLContract {
	/**
	 * The cached value of the '{@link #getCriteria() <em>Criteria</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCriteria()
	 * @generated
	 * @ordered
	 */
	protected EList<Criterion> criteria;

	/**
	 * The cached value of the '{@link #getContractType() <em>Contract Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContractType()
	 * @generated
	 * @ordered
	 */
	protected QMLContractType contractType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleQMLContractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLContractPackage.Literals.SIMPLE_QML_CONTRACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Criterion> getCriteria() {
		if (criteria == null) {
			criteria = new EObjectContainmentEList<Criterion>(Criterion.class, this, QMLContractPackage.SIMPLE_QML_CONTRACT__CRITERIA);
		}
		return criteria;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLContractType getContractType() {
		if (contractType != null && contractType.eIsProxy()) {
			InternalEObject oldContractType = (InternalEObject)contractType;
			contractType = (QMLContractType)eResolveProxy(oldContractType);
			if (contractType != oldContractType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QMLContractPackage.SIMPLE_QML_CONTRACT__CONTRACT_TYPE, oldContractType, contractType));
			}
		}
		return contractType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLContractType basicGetContractType() {
		return contractType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContractType(QMLContractType newContractType) {
		QMLContractType oldContractType = contractType;
		contractType = newContractType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLContractPackage.SIMPLE_QML_CONTRACT__CONTRACT_TYPE, oldContractType, contractType));
	}

	/**
	 * The cached OCL expression body for the '{@link #all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>All DIMENSIO Ns must be from same CONTRACTTYPE</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_DIMENSIO_NS_MUST_BE_FROM_SAME_CONTRACTTYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.contractType<> null) implies ("+
"	self.criteria->forAll(c|"+
"		self.contractType.dimensions->exists(dim|c.dimension=dim)"+
"	)"+
")";

	/**
	 * The cached OCL invariant for the '{@link #all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>All DIMENSIO Ns must be from same CONTRACTTYPE</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ALL_DIMENSIO_NS_MUST_BE_FROM_SAME_CONTRACTTYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ALL_DIMENSIO_NS_MUST_BE_FROM_SAME_CONTRACTTYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QMLContractPackage.Literals.SIMPLE_QML_CONTRACT);
			try {
				ALL_DIMENSIO_NS_MUST_BE_FROM_SAME_CONTRACTTYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ALL_DIMENSIO_NS_MUST_BE_FROM_SAME_CONTRACTTYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ALL_DIMENSIO_NS_MUST_BE_FROM_SAME_CONTRACTTYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QMLContractValidator.DIAGNOSTIC_SOURCE,
						 QMLContractValidator.SIMPLE_QML_CONTRACT__ALL_DIMENSIO_NS_MUST_BE_FROM_SAME_CONTRACTTYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "all_DIMENSIONs_must_be_from_same_CONTRACTTYPE", EObjectValidator.getObjectLabel(this, context) }),
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
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CRITERIA:
				return ((InternalEList<?>)getCriteria()).basicRemove(otherEnd, msgs);
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
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CRITERIA:
				return getCriteria();
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CONTRACT_TYPE:
				if (resolve) return getContractType();
				return basicGetContractType();
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
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CRITERIA:
				getCriteria().clear();
				getCriteria().addAll((Collection<? extends Criterion>)newValue);
				return;
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CONTRACT_TYPE:
				setContractType((QMLContractType)newValue);
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
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CRITERIA:
				getCriteria().clear();
				return;
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CONTRACT_TYPE:
				setContractType((QMLContractType)null);
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
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CRITERIA:
				return criteria != null && !criteria.isEmpty();
			case QMLContractPackage.SIMPLE_QML_CONTRACT__CONTRACT_TYPE:
				return contractType != null;
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

} //SimpleQMLContractImpl
