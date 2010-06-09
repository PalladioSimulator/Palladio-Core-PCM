/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalActionImpl#getFailureOccurrenceDescriptions <em>Failure Occurrence Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalActionImpl extends AbstractInternalControlFlowActionImpl implements InternalAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getFailureOccurrenceDescriptions() <em>Failure Occurrence Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureOccurrenceDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureOccurrenceDescription> failureOccurrenceDescriptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.INTERNAL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureOccurrenceDescription> getFailureOccurrenceDescriptions() {
		if (failureOccurrenceDescriptions == null) {
			failureOccurrenceDescriptions = new EObjectContainmentWithInverseEList<FailureOccurrenceDescription>(FailureOccurrenceDescription.class, this, SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS, SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS);
		}
		return failureOccurrenceDescriptions;
	}

	/**
	 * The cached OCL expression body for the '{@link #Multipleusagesofsamefailuretypearenotallowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Multipleusagesofsamefailuretypearenotallowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Multipleusagesofsamefailuretypearenotallowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String MULTIPLEUSAGESOFSAMEFAILURETYPEARENOTALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.failureOccurrenceDescriptions->forAll(x : FailureOccurrenceDescription,y:FailureOccurrenceDescription  | x<>y implies x.failureType <> y.failureType )";

	/**
	 * The cached OCL invariant for the '{@link #Multipleusagesofsamefailuretypearenotallowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Multipleusagesofsamefailuretypearenotallowed</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Multipleusagesofsamefailuretypearenotallowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint MULTIPLEUSAGESOFSAMEFAILURETYPEARENOTALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Multipleusagesofsamefailuretypearenotallowed(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (MULTIPLEUSAGESOFSAMEFAILURETYPEARENOTALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.INTERNAL_ACTION);
			try {
				MULTIPLEUSAGESOFSAMEFAILURETYPEARENOTALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(MULTIPLEUSAGESOFSAMEFAILURETYPEARENOTALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(MULTIPLEUSAGESOFSAMEFAILURETYPEARENOTALLOWED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.INTERNAL_ACTION__MULTIPLEUSAGESOFSAMEFAILURETYPEARENOTALLOWED,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Multipleusagesofsamefailuretypearenotallowed", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #Sumoffailureoccurrenceprobabilitiesmustnotexceed10(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sumoffailureoccurrenceprobabilitiesmustnotexceed10</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Sumoffailureoccurrenceprobabilitiesmustnotexceed10(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SUMOFFAILUREOCCURRENCEPROBABILITIESMUSTNOTEXCEED10__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.failureOccurrenceDescriptions.failureProbability.oclAsType(Real)->sum()<=1";

	/**
	 * The cached OCL invariant for the '{@link #Sumoffailureoccurrenceprobabilitiesmustnotexceed10(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sumoffailureoccurrenceprobabilitiesmustnotexceed10</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Sumoffailureoccurrenceprobabilitiesmustnotexceed10(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint SUMOFFAILUREOCCURRENCEPROBABILITIESMUSTNOTEXCEED10__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Sumoffailureoccurrenceprobabilitiesmustnotexceed10(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (SUMOFFAILUREOCCURRENCEPROBABILITIESMUSTNOTEXCEED10__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.INTERNAL_ACTION);
			try {
				SUMOFFAILUREOCCURRENCEPROBABILITIESMUSTNOTEXCEED10__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(SUMOFFAILUREOCCURRENCEPROBABILITIESMUSTNOTEXCEED10__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(SUMOFFAILUREOCCURRENCEPROBABILITIESMUSTNOTEXCEED10__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.INTERNAL_ACTION__SUMOFFAILUREOCCURRENCEPROBABILITIESMUSTNOTEXCEED10,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Sumoffailureoccurrenceprobabilitiesmustnotexceed10", EObjectValidator.getObjectLabel(this, context) }),
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFailureOccurrenceDescriptions()).basicAdd(otherEnd, msgs);
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
			case SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS:
				return ((InternalEList<?>)getFailureOccurrenceDescriptions()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS:
				return getFailureOccurrenceDescriptions();
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
			case SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS:
				getFailureOccurrenceDescriptions().clear();
				getFailureOccurrenceDescriptions().addAll((Collection<? extends FailureOccurrenceDescription>)newValue);
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
			case SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS:
				getFailureOccurrenceDescriptions().clear();
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
			case SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS:
				return failureOccurrenceDescriptions != null && !failureOccurrenceDescriptions.isEmpty();
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

} //InternalActionImpl
