/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getNamedReference_VariableUsage <em>Named Reference Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getUserData_VariableUsage <em>User Data Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getAssemblyContext_VariableUsage <em>Assembly Context Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getEntryLevelSystemCall_VariableUsage <em>Entry Level System Call Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getEntryLevelSystemCall_OutputParameterUsage <em>Entry Level System Call Output Parameter Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getCallAction_in_VariableUsage <em>Call Action in Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getSynchronisationPoint_VariableUsage <em>Synchronisation Point Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getSetVariableAction_VariableUsage <em>Set Variable Action Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getCallAction_out_VariableUsage <em>Call Action out Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage <em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableUsageImpl extends EObjectImpl implements VariableUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getVariableCharacterisation_VariableUsage() <em>Variable Characterisation Variable Usage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableCharacterisation_VariableUsage()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCharacterisation> variableCharacterisation_VariableUsage;

	/**
	 * The cached value of the '{@link #getNamedReference_VariableUsage() <em>Named Reference Variable Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedReference_VariableUsage()
	 * @generated
	 * @ordered
	 */
	protected AbstractNamedReference namedReference_VariableUsage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.VARIABLE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableCharacterisation> getVariableCharacterisation_VariableUsage() {
		if (variableCharacterisation_VariableUsage == null) {
			variableCharacterisation_VariableUsage = new EObjectContainmentWithInverseEList<VariableCharacterisation>(VariableCharacterisation.class, this, ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE, ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION);
		}
		return variableCharacterisation_VariableUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNamedReference getNamedReference_VariableUsage() {
		return namedReference_VariableUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamedReference_VariableUsage(AbstractNamedReference newNamedReference_VariableUsage, NotificationChain msgs) {
		AbstractNamedReference oldNamedReference_VariableUsage = namedReference_VariableUsage;
		namedReference_VariableUsage = newNamedReference_VariableUsage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, oldNamedReference_VariableUsage, newNamedReference_VariableUsage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamedReference_VariableUsage(AbstractNamedReference newNamedReference_VariableUsage) {
		if (newNamedReference_VariableUsage != namedReference_VariableUsage) {
			NotificationChain msgs = null;
			if (namedReference_VariableUsage != null)
				msgs = ((InternalEObject)namedReference_VariableUsage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, null, msgs);
			if (newNamedReference_VariableUsage != null)
				msgs = ((InternalEObject)newNamedReference_VariableUsage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, null, msgs);
			msgs = basicSetNamedReference_VariableUsage(newNamedReference_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, newNamedReference_VariableUsage, newNamedReference_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserData getUserData_VariableUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE) return null;
		return (UserData)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUserData_VariableUsage(UserData newUserData_VariableUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUserData_VariableUsage, ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserData_VariableUsage(UserData newUserData_VariableUsage) {
		if (newUserData_VariableUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE && newUserData_VariableUsage != null)) {
			if (EcoreUtil.isAncestor(this, newUserData_VariableUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUserData_VariableUsage != null)
				msgs = ((InternalEObject)newUserData_VariableUsage).eInverseAdd(this, UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA, UserData.class, msgs);
			msgs = basicSetUserData_VariableUsage(newUserData_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE, newUserData_VariableUsage, newUserData_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_VariableUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE) return null;
		return (AssemblyContext)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssemblyContext_VariableUsage(AssemblyContext newAssemblyContext_VariableUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAssemblyContext_VariableUsage, ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_VariableUsage(AssemblyContext newAssemblyContext_VariableUsage) {
		if (newAssemblyContext_VariableUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE && newAssemblyContext_VariableUsage != null)) {
			if (EcoreUtil.isAncestor(this, newAssemblyContext_VariableUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAssemblyContext_VariableUsage != null)
				msgs = ((InternalEObject)newAssemblyContext_VariableUsage).eInverseAdd(this, CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT, AssemblyContext.class, msgs);
			msgs = basicSetAssemblyContext_VariableUsage(newAssemblyContext_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE, newAssemblyContext_VariableUsage, newAssemblyContext_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall getEntryLevelSystemCall_VariableUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE) return null;
		return (EntryLevelSystemCall)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntryLevelSystemCall_VariableUsage(EntryLevelSystemCall newEntryLevelSystemCall_VariableUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEntryLevelSystemCall_VariableUsage, ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryLevelSystemCall_VariableUsage(EntryLevelSystemCall newEntryLevelSystemCall_VariableUsage) {
		if (newEntryLevelSystemCall_VariableUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE && newEntryLevelSystemCall_VariableUsage != null)) {
			if (EcoreUtil.isAncestor(this, newEntryLevelSystemCall_VariableUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEntryLevelSystemCall_VariableUsage != null)
				msgs = ((InternalEObject)newEntryLevelSystemCall_VariableUsage).eInverseAdd(this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL, EntryLevelSystemCall.class, msgs);
			msgs = basicSetEntryLevelSystemCall_VariableUsage(newEntryLevelSystemCall_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE, newEntryLevelSystemCall_VariableUsage, newEntryLevelSystemCall_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall getEntryLevelSystemCall_OutputParameterUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE) return null;
		return (EntryLevelSystemCall)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntryLevelSystemCall_OutputParameterUsage(EntryLevelSystemCall newEntryLevelSystemCall_OutputParameterUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEntryLevelSystemCall_OutputParameterUsage, ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryLevelSystemCall_OutputParameterUsage(EntryLevelSystemCall newEntryLevelSystemCall_OutputParameterUsage) {
		if (newEntryLevelSystemCall_OutputParameterUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE && newEntryLevelSystemCall_OutputParameterUsage != null)) {
			if (EcoreUtil.isAncestor(this, newEntryLevelSystemCall_OutputParameterUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEntryLevelSystemCall_OutputParameterUsage != null)
				msgs = ((InternalEObject)newEntryLevelSystemCall_OutputParameterUsage).eInverseAdd(this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL, EntryLevelSystemCall.class, msgs);
			msgs = basicSetEntryLevelSystemCall_OutputParameterUsage(newEntryLevelSystemCall_OutputParameterUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE, newEntryLevelSystemCall_OutputParameterUsage, newEntryLevelSystemCall_OutputParameterUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallAction getCallAction_in_VariableUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE) return null;
		return (CallAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallAction_in_VariableUsage(CallAction newCallAction_in_VariableUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCallAction_in_VariableUsage, ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallAction_in_VariableUsage(CallAction newCallAction_in_VariableUsage) {
		if (newCallAction_in_VariableUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE && newCallAction_in_VariableUsage != null)) {
			if (EcoreUtil.isAncestor(this, newCallAction_in_VariableUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCallAction_in_VariableUsage != null)
				msgs = ((InternalEObject)newCallAction_in_VariableUsage).eInverseAdd(this, SeffPackage.CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION, CallAction.class, msgs);
			msgs = basicSetCallAction_in_VariableUsage(newCallAction_in_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE, newCallAction_in_VariableUsage, newCallAction_in_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronisationPoint getSynchronisationPoint_VariableUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE) return null;
		return (SynchronisationPoint)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSynchronisationPoint_VariableUsage(SynchronisationPoint newSynchronisationPoint_VariableUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSynchronisationPoint_VariableUsage, ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronisationPoint_VariableUsage(SynchronisationPoint newSynchronisationPoint_VariableUsage) {
		if (newSynchronisationPoint_VariableUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE && newSynchronisationPoint_VariableUsage != null)) {
			if (EcoreUtil.isAncestor(this, newSynchronisationPoint_VariableUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSynchronisationPoint_VariableUsage != null)
				msgs = ((InternalEObject)newSynchronisationPoint_VariableUsage).eInverseAdd(this, SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT, SynchronisationPoint.class, msgs);
			msgs = basicSetSynchronisationPoint_VariableUsage(newSynchronisationPoint_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE, newSynchronisationPoint_VariableUsage, newSynchronisationPoint_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetVariableAction getSetVariableAction_VariableUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE) return null;
		return (SetVariableAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSetVariableAction_VariableUsage(SetVariableAction newSetVariableAction_VariableUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSetVariableAction_VariableUsage, ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetVariableAction_VariableUsage(SetVariableAction newSetVariableAction_VariableUsage) {
		if (newSetVariableAction_VariableUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE && newSetVariableAction_VariableUsage != null)) {
			if (EcoreUtil.isAncestor(this, newSetVariableAction_VariableUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSetVariableAction_VariableUsage != null)
				msgs = ((InternalEObject)newSetVariableAction_VariableUsage).eInverseAdd(this, SeffPackage.SET_VARIABLE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION, SetVariableAction.class, msgs);
			msgs = basicSetSetVariableAction_VariableUsage(newSetVariableAction_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE, newSetVariableAction_VariableUsage, newSetVariableAction_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallAction getCallAction_out_VariableUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE) return null;
		return (CallAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallAction_out_VariableUsage(CallAction newCallAction_out_VariableUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCallAction_out_VariableUsage, ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallAction_out_VariableUsage(CallAction newCallAction_out_VariableUsage) {
		if (newCallAction_out_VariableUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE && newCallAction_out_VariableUsage != null)) {
			if (EcoreUtil.isAncestor(this, newCallAction_out_VariableUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCallAction_out_VariableUsage != null)
				msgs = ((InternalEObject)newCallAction_out_VariableUsage).eInverseAdd(this, SeffPackage.CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION, CallAction.class, msgs);
			msgs = basicSetCallAction_out_VariableUsage(newCallAction_out_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE, newCallAction_out_VariableUsage, newCallAction_out_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecifiedOutputParameterAbstraction getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE) return null;
		return (SpecifiedOutputParameterAbstraction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(SpecifiedOutputParameterAbstraction newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage, ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(SpecifiedOutputParameterAbstraction newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage) {
		if (newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE && newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage != null)) {
			if (EcoreUtil.isAncestor(this, newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage != null)
				msgs = ((InternalEObject)newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage).eInverseAdd(this, QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION, SpecifiedOutputParameterAbstraction.class, msgs);
			msgs = basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE, newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage, newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage));
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariableCharacterisation_VariableUsage()).basicAdd(otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUserData_VariableUsage((UserData)otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAssemblyContext_VariableUsage((AssemblyContext)otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEntryLevelSystemCall_VariableUsage((EntryLevelSystemCall)otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEntryLevelSystemCall_OutputParameterUsage((EntryLevelSystemCall)otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCallAction_in_VariableUsage((CallAction)otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSynchronisationPoint_VariableUsage((SynchronisationPoint)otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSetVariableAction_VariableUsage((SetVariableAction)otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCallAction_out_VariableUsage((CallAction)otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage((SpecifiedOutputParameterAbstraction)otherEnd, msgs);
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				return ((InternalEList<?>)getVariableCharacterisation_VariableUsage()).basicRemove(otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				return basicSetNamedReference_VariableUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
				return basicSetUserData_VariableUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
				return basicSetAssemblyContext_VariableUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE:
				return basicSetEntryLevelSystemCall_VariableUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
				return basicSetEntryLevelSystemCall_OutputParameterUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE:
				return basicSetCallAction_in_VariableUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
				return basicSetSynchronisationPoint_VariableUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
				return basicSetSetVariableAction_VariableUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE:
				return basicSetCallAction_out_VariableUsage(null, msgs);
			case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
				return basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
				return eInternalContainer().eInverseRemove(this, UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA, UserData.class, msgs);
			case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT, AssemblyContext.class, msgs);
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE:
				return eInternalContainer().eInverseRemove(this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL, EntryLevelSystemCall.class, msgs);
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
				return eInternalContainer().eInverseRemove(this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL, EntryLevelSystemCall.class, msgs);
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE:
				return eInternalContainer().eInverseRemove(this, SeffPackage.CALL_ACTION__INPUT_PARAMETER_USAGES_EXTERNAL_CALL_ACTION, CallAction.class, msgs);
			case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
				return eInternalContainer().eInverseRemove(this, SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT, SynchronisationPoint.class, msgs);
			case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
				return eInternalContainer().eInverseRemove(this, SeffPackage.SET_VARIABLE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION, SetVariableAction.class, msgs);
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE:
				return eInternalContainer().eInverseRemove(this, SeffPackage.CALL_ACTION__OUTPUT_VARIABLE_USAGES_EXTERNAL_CALL_ACTION, CallAction.class, msgs);
			case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
				return eInternalContainer().eInverseRemove(this, QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION, SpecifiedOutputParameterAbstraction.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				return getVariableCharacterisation_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				return getNamedReference_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
				return getUserData_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
				return getAssemblyContext_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE:
				return getEntryLevelSystemCall_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
				return getEntryLevelSystemCall_OutputParameterUsage();
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE:
				return getCallAction_in_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
				return getSynchronisationPoint_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
				return getSetVariableAction_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE:
				return getCallAction_out_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
				return getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage();
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				getVariableCharacterisation_VariableUsage().clear();
				getVariableCharacterisation_VariableUsage().addAll((Collection<? extends VariableCharacterisation>)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				setNamedReference_VariableUsage((AbstractNamedReference)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
				setUserData_VariableUsage((UserData)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
				setAssemblyContext_VariableUsage((AssemblyContext)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE:
				setEntryLevelSystemCall_VariableUsage((EntryLevelSystemCall)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
				setEntryLevelSystemCall_OutputParameterUsage((EntryLevelSystemCall)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE:
				setCallAction_in_VariableUsage((CallAction)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
				setSynchronisationPoint_VariableUsage((SynchronisationPoint)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
				setSetVariableAction_VariableUsage((SetVariableAction)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE:
				setCallAction_out_VariableUsage((CallAction)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
				setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage((SpecifiedOutputParameterAbstraction)newValue);
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				getVariableCharacterisation_VariableUsage().clear();
				return;
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				setNamedReference_VariableUsage((AbstractNamedReference)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
				setUserData_VariableUsage((UserData)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
				setAssemblyContext_VariableUsage((AssemblyContext)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE:
				setEntryLevelSystemCall_VariableUsage((EntryLevelSystemCall)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
				setEntryLevelSystemCall_OutputParameterUsage((EntryLevelSystemCall)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE:
				setCallAction_in_VariableUsage((CallAction)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
				setSynchronisationPoint_VariableUsage((SynchronisationPoint)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
				setSetVariableAction_VariableUsage((SetVariableAction)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE:
				setCallAction_out_VariableUsage((CallAction)null);
				return;
			case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
				setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage((SpecifiedOutputParameterAbstraction)null);
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				return variableCharacterisation_VariableUsage != null && !variableCharacterisation_VariableUsage.isEmpty();
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				return namedReference_VariableUsage != null;
			case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
				return getUserData_VariableUsage() != null;
			case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
				return getAssemblyContext_VariableUsage() != null;
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE:
				return getEntryLevelSystemCall_VariableUsage() != null;
			case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
				return getEntryLevelSystemCall_OutputParameterUsage() != null;
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_IN_VARIABLE_USAGE:
				return getCallAction_in_VariableUsage() != null;
			case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
				return getSynchronisationPoint_VariableUsage() != null;
			case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
				return getSetVariableAction_VariableUsage() != null;
			case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_OUT_VARIABLE_USAGE:
				return getCallAction_out_VariableUsage() != null;
			case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
				return getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage() != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableUsageImpl
