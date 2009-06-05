/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl#getActions_ScenarioBehaviour <em>Actions Scenario Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScenarioBehaviourImpl extends EntityImpl implements ScenarioBehaviour {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getActions_ScenarioBehaviour() <em>Actions Scenario Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions_ScenarioBehaviour()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractUserAction> actions_ScenarioBehaviour;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractUserAction> getActions_ScenarioBehaviour() {
		if (actions_ScenarioBehaviour == null) {
			actions_ScenarioBehaviour = new EObjectContainmentEList<AbstractUserAction>(AbstractUserAction.class, this, UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR);
		}
		return actions_ScenarioBehaviour;
	}

	/**
	 * The cached OCL expression body for the '{@link #Exactlyonestart(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactlyonestart</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Exactlyonestart(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.actions_ScenarioBehaviour->select(s|s.oclIsTypeOf(Start))->size() = 1";

	/**
	 * The cached OCL invariant for the '{@link #Exactlyonestart(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactlyonestart</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Exactlyonestart(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Exactlyonestart(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR);
			try {
				EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EXACTLYONESTART__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 UsagemodelValidator.DIAGNOSTIC_SOURCE,
						 UsagemodelValidator.SCENARIO_BEHAVIOUR__EXACTLYONESTART,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Exactlyonestart", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #Exactlyonestop(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactlyonestop</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Exactlyonestop(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.actions_ScenarioBehaviour->select(s|s.oclIsTypeOf(Stop))->size() = 1";

	/**
	 * The cached OCL invariant for the '{@link #Exactlyonestop(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactlyonestop</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Exactlyonestop(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Exactlyonestop(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR);
			try {
				EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EXACTLYONESTOP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 UsagemodelValidator.DIAGNOSTIC_SOURCE,
						 UsagemodelValidator.SCENARIO_BEHAVIOUR__EXACTLYONESTOP,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Exactlyonestop", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Eachuseractionexcept Startand Stopmusthaveapredecessorandsuccessor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.actions_ScenarioBehaviour->select(s|not s.oclIsTypeOf(Start) and not s.oclIsTypeOf(Stop))->exists(a|a.oclAsType(AbstractUserAction).predecessor.oclIsUndefined()) and not self.actions_ScenarioBehaviour->select(s|not s.oclIsTypeOf(Start) and not s.oclIsTypeOf(Stop))->exists(a|a.oclAsType(AbstractUserAction).successor.oclIsUndefined())";

	/**
	 * The cached OCL invariant for the '{@link #EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Eachuseractionexcept Startand Stopmusthaveapredecessorandsuccessor</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR);
			try {
				EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 UsagemodelValidator.DIAGNOSTIC_SOURCE,
						 UsagemodelValidator.SCENARIO_BEHAVIOUR__EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor", EObjectValidator.getObjectLabel(this, context) }),
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				return ((InternalEList<?>)getActions_ScenarioBehaviour()).basicRemove(otherEnd, msgs);
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				return getActions_ScenarioBehaviour();
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				getActions_ScenarioBehaviour().clear();
				getActions_ScenarioBehaviour().addAll((Collection<? extends AbstractUserAction>)newValue);
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				getActions_ScenarioBehaviour().clear();
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				return actions_ScenarioBehaviour != null && !actions_ScenarioBehaviour.isEmpty();
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

} //ScenarioBehaviourImpl
