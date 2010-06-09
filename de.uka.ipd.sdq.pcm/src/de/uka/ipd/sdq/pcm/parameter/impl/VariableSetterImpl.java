/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.CallReturnAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Setter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getSpecification__VariableSetter <em>Specification Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getUserData__VariableSetter <em>User Data Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getAssemblyContext__VariableSetter <em>Assembly Context Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getEntryLevelSystemCall__InputVariableSetter <em>Entry Level System Call Input Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getEntryLevelSystemCall__OutputVariableSetter <em>Entry Level System Call Output Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getCallAction__VariableSetter <em>Call Action Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getSynchronisationPoint__VariableSetter <em>Synchronisation Point Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getCallReturnAction__VariableSetter <em>Call Return Action Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getSetVariableAction__VariableSetter <em>Set Variable Action Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter <em>Specified Output Parameter Abstraction expected External Outputs Variable Setter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableSetterImpl#getVariableCharacteristic__VariableSetter <em>Variable Characteristic Variable Setter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableSetterImpl extends EObjectImpl implements VariableSetter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSpecification__VariableSetter() <em>Specification Variable Setter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification__VariableSetter()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable specification__VariableSetter;

	/**
	 * The cached value of the '{@link #getVariableCharacteristic__VariableSetter() <em>Variable Characteristic Variable Setter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableCharacteristic__VariableSetter()
	 * @generated
	 * @ordered
	 */
	protected VariableCharacteristic variableCharacteristic__VariableSetter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableSetterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.VARIABLE_SETTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getSpecification__VariableSetter() {
		return specification__VariableSetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification__VariableSetter(PCMRandomVariable newSpecification__VariableSetter, NotificationChain msgs) {
		PCMRandomVariable oldSpecification__VariableSetter = specification__VariableSetter;
		specification__VariableSetter = newSpecification__VariableSetter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER, oldSpecification__VariableSetter, newSpecification__VariableSetter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification__VariableSetter(PCMRandomVariable newSpecification__VariableSetter) {
		if (newSpecification__VariableSetter != specification__VariableSetter) {
			NotificationChain msgs = null;
			if (specification__VariableSetter != null)
				msgs = ((InternalEObject)specification__VariableSetter).eInverseRemove(this, CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_SETTER_PCM_RANDOM_VARIABLE, PCMRandomVariable.class, msgs);
			if (newSpecification__VariableSetter != null)
				msgs = ((InternalEObject)newSpecification__VariableSetter).eInverseAdd(this, CorePackage.PCM_RANDOM_VARIABLE__VARIABLE_SETTER_PCM_RANDOM_VARIABLE, PCMRandomVariable.class, msgs);
			msgs = basicSetSpecification__VariableSetter(newSpecification__VariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER, newSpecification__VariableSetter, newSpecification__VariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserData getUserData__VariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER) return null;
		return (UserData)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUserData__VariableSetter(UserData newUserData__VariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUserData__VariableSetter, ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserData__VariableSetter(UserData newUserData__VariableSetter) {
		if (newUserData__VariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER && newUserData__VariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newUserData__VariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUserData__VariableSetter != null)
				msgs = ((InternalEObject)newUserData__VariableSetter).eInverseAdd(this, UsagemodelPackage.USER_DATA__USER_DATA_VARIABLE_SETTERS_USER_DATA, UserData.class, msgs);
			msgs = basicSetUserData__VariableSetter(newUserData__VariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER, newUserData__VariableSetter, newUserData__VariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext__VariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER) return null;
		return (AssemblyContext)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssemblyContext__VariableSetter(AssemblyContext newAssemblyContext__VariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAssemblyContext__VariableSetter, ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext__VariableSetter(AssemblyContext newAssemblyContext__VariableSetter) {
		if (newAssemblyContext__VariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER && newAssemblyContext__VariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newAssemblyContext__VariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAssemblyContext__VariableSetter != null)
				msgs = ((InternalEObject)newAssemblyContext__VariableSetter).eInverseAdd(this, CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT, AssemblyContext.class, msgs);
			msgs = basicSetAssemblyContext__VariableSetter(newAssemblyContext__VariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER, newAssemblyContext__VariableSetter, newAssemblyContext__VariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall getEntryLevelSystemCall__InputVariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER) return null;
		return (EntryLevelSystemCall)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntryLevelSystemCall__InputVariableSetter(EntryLevelSystemCall newEntryLevelSystemCall__InputVariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEntryLevelSystemCall__InputVariableSetter, ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryLevelSystemCall__InputVariableSetter(EntryLevelSystemCall newEntryLevelSystemCall__InputVariableSetter) {
		if (newEntryLevelSystemCall__InputVariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER && newEntryLevelSystemCall__InputVariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newEntryLevelSystemCall__InputVariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEntryLevelSystemCall__InputVariableSetter != null)
				msgs = ((InternalEObject)newEntryLevelSystemCall__InputVariableSetter).eInverseAdd(this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL, EntryLevelSystemCall.class, msgs);
			msgs = basicSetEntryLevelSystemCall__InputVariableSetter(newEntryLevelSystemCall__InputVariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER, newEntryLevelSystemCall__InputVariableSetter, newEntryLevelSystemCall__InputVariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCall getEntryLevelSystemCall__OutputVariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER) return null;
		return (EntryLevelSystemCall)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntryLevelSystemCall__OutputVariableSetter(EntryLevelSystemCall newEntryLevelSystemCall__OutputVariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEntryLevelSystemCall__OutputVariableSetter, ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryLevelSystemCall__OutputVariableSetter(EntryLevelSystemCall newEntryLevelSystemCall__OutputVariableSetter) {
		if (newEntryLevelSystemCall__OutputVariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER && newEntryLevelSystemCall__OutputVariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newEntryLevelSystemCall__OutputVariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEntryLevelSystemCall__OutputVariableSetter != null)
				msgs = ((InternalEObject)newEntryLevelSystemCall__OutputVariableSetter).eInverseAdd(this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL, EntryLevelSystemCall.class, msgs);
			msgs = basicSetEntryLevelSystemCall__OutputVariableSetter(newEntryLevelSystemCall__OutputVariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER, newEntryLevelSystemCall__OutputVariableSetter, newEntryLevelSystemCall__OutputVariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallAction getCallAction__VariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER) return null;
		return (CallAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallAction__VariableSetter(CallAction newCallAction__VariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCallAction__VariableSetter, ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallAction__VariableSetter(CallAction newCallAction__VariableSetter) {
		if (newCallAction__VariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER && newCallAction__VariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newCallAction__VariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCallAction__VariableSetter != null)
				msgs = ((InternalEObject)newCallAction__VariableSetter).eInverseAdd(this, SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION, CallAction.class, msgs);
			msgs = basicSetCallAction__VariableSetter(newCallAction__VariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER, newCallAction__VariableSetter, newCallAction__VariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronisationPoint getSynchronisationPoint__VariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER) return null;
		return (SynchronisationPoint)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSynchronisationPoint__VariableSetter(SynchronisationPoint newSynchronisationPoint__VariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSynchronisationPoint__VariableSetter, ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronisationPoint__VariableSetter(SynchronisationPoint newSynchronisationPoint__VariableSetter) {
		if (newSynchronisationPoint__VariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER && newSynchronisationPoint__VariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newSynchronisationPoint__VariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSynchronisationPoint__VariableSetter != null)
				msgs = ((InternalEObject)newSynchronisationPoint__VariableSetter).eInverseAdd(this, SeffPackage.SYNCHRONISATION_POINT__OUTPUT_VARIABLE_SETTERS_SYNCHRONISATION_POINT, SynchronisationPoint.class, msgs);
			msgs = basicSetSynchronisationPoint__VariableSetter(newSynchronisationPoint__VariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER, newSynchronisationPoint__VariableSetter, newSynchronisationPoint__VariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallReturnAction getCallReturnAction__VariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER) return null;
		return (CallReturnAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallReturnAction__VariableSetter(CallReturnAction newCallReturnAction__VariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCallReturnAction__VariableSetter, ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallReturnAction__VariableSetter(CallReturnAction newCallReturnAction__VariableSetter) {
		if (newCallReturnAction__VariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER && newCallReturnAction__VariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newCallReturnAction__VariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCallReturnAction__VariableSetter != null)
				msgs = ((InternalEObject)newCallReturnAction__VariableSetter).eInverseAdd(this, SeffPackage.CALL_RETURN_ACTION__VARIABLE_SETTER_RETURNS_CALL_RETURN_ACTION, CallReturnAction.class, msgs);
			msgs = basicSetCallReturnAction__VariableSetter(newCallReturnAction__VariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER, newCallReturnAction__VariableSetter, newCallReturnAction__VariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetVariableAction getSetVariableAction__VariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER) return null;
		return (SetVariableAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSetVariableAction__VariableSetter(SetVariableAction newSetVariableAction__VariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSetVariableAction__VariableSetter, ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetVariableAction__VariableSetter(SetVariableAction newSetVariableAction__VariableSetter) {
		if (newSetVariableAction__VariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER && newSetVariableAction__VariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newSetVariableAction__VariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSetVariableAction__VariableSetter != null)
				msgs = ((InternalEObject)newSetVariableAction__VariableSetter).eInverseAdd(this, SeffPackage.SET_VARIABLE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION, SetVariableAction.class, msgs);
			msgs = basicSetSetVariableAction__VariableSetter(newSetVariableAction__VariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER, newSetVariableAction__VariableSetter, newSetVariableAction__VariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecifiedOutputParameterAbstraction getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter() {
		if (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER) return null;
		return (SpecifiedOutputParameterAbstraction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter(SpecifiedOutputParameterAbstraction newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter, ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter(SpecifiedOutputParameterAbstraction newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter) {
		if (newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter != eInternalContainer() || (eContainerFeatureID() != ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER && newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter != null)) {
			if (EcoreUtil.isAncestor(this, newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter != null)
				msgs = ((InternalEObject)newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter).eInverseAdd(this, QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION, SpecifiedOutputParameterAbstraction.class, msgs);
			msgs = basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter(newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER, newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter, newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCharacteristic getVariableCharacteristic__VariableSetter() {
		if (variableCharacteristic__VariableSetter != null && variableCharacteristic__VariableSetter.eIsProxy()) {
			InternalEObject oldVariableCharacteristic__VariableSetter = (InternalEObject)variableCharacteristic__VariableSetter;
			variableCharacteristic__VariableSetter = (VariableCharacteristic)eResolveProxy(oldVariableCharacteristic__VariableSetter);
			if (variableCharacteristic__VariableSetter != oldVariableCharacteristic__VariableSetter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParameterPackage.VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER, oldVariableCharacteristic__VariableSetter, variableCharacteristic__VariableSetter));
			}
		}
		return variableCharacteristic__VariableSetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCharacteristic basicGetVariableCharacteristic__VariableSetter() {
		return variableCharacteristic__VariableSetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableCharacteristic__VariableSetter(VariableCharacteristic newVariableCharacteristic__VariableSetter) {
		VariableCharacteristic oldVariableCharacteristic__VariableSetter = variableCharacteristic__VariableSetter;
		variableCharacteristic__VariableSetter = newVariableCharacteristic__VariableSetter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER, oldVariableCharacteristic__VariableSetter, variableCharacteristic__VariableSetter));
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
			case ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER:
				if (specification__VariableSetter != null)
					msgs = ((InternalEObject)specification__VariableSetter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER, null, msgs);
				return basicSetSpecification__VariableSetter((PCMRandomVariable)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUserData__VariableSetter((UserData)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAssemblyContext__VariableSetter((AssemblyContext)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEntryLevelSystemCall__InputVariableSetter((EntryLevelSystemCall)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEntryLevelSystemCall__OutputVariableSetter((EntryLevelSystemCall)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCallAction__VariableSetter((CallAction)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSynchronisationPoint__VariableSetter((SynchronisationPoint)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCallReturnAction__VariableSetter((CallReturnAction)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSetVariableAction__VariableSetter((SetVariableAction)otherEnd, msgs);
			case ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter((SpecifiedOutputParameterAbstraction)otherEnd, msgs);
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
			case ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER:
				return basicSetSpecification__VariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER:
				return basicSetUserData__VariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER:
				return basicSetAssemblyContext__VariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER:
				return basicSetEntryLevelSystemCall__InputVariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER:
				return basicSetEntryLevelSystemCall__OutputVariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER:
				return basicSetCallAction__VariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER:
				return basicSetSynchronisationPoint__VariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER:
				return basicSetCallReturnAction__VariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER:
				return basicSetSetVariableAction__VariableSetter(null, msgs);
			case ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER:
				return basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter(null, msgs);
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
			case ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER:
				return eInternalContainer().eInverseRemove(this, UsagemodelPackage.USER_DATA__USER_DATA_VARIABLE_SETTERS_USER_DATA, UserData.class, msgs);
			case ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_VARIABLE_SETTERS_ASSEMBLY_CONTEXT, AssemblyContext.class, msgs);
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER:
				return eInternalContainer().eInverseRemove(this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL, EntryLevelSystemCall.class, msgs);
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER:
				return eInternalContainer().eInverseRemove(this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_VARIABLE_SETTERS_ENTRY_LEVEL_SYSTEM_CALL, EntryLevelSystemCall.class, msgs);
			case ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER:
				return eInternalContainer().eInverseRemove(this, SeffPackage.CALL_ACTION__VARIABLE_SETTER_INPUTS_CALL_ACTION, CallAction.class, msgs);
			case ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER:
				return eInternalContainer().eInverseRemove(this, SeffPackage.SYNCHRONISATION_POINT__OUTPUT_VARIABLE_SETTERS_SYNCHRONISATION_POINT, SynchronisationPoint.class, msgs);
			case ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER:
				return eInternalContainer().eInverseRemove(this, SeffPackage.CALL_RETURN_ACTION__VARIABLE_SETTER_RETURNS_CALL_RETURN_ACTION, CallReturnAction.class, msgs);
			case ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER:
				return eInternalContainer().eInverseRemove(this, SeffPackage.SET_VARIABLE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION, SetVariableAction.class, msgs);
			case ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER:
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
			case ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER:
				return getSpecification__VariableSetter();
			case ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER:
				return getUserData__VariableSetter();
			case ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER:
				return getAssemblyContext__VariableSetter();
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER:
				return getEntryLevelSystemCall__InputVariableSetter();
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER:
				return getEntryLevelSystemCall__OutputVariableSetter();
			case ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER:
				return getCallAction__VariableSetter();
			case ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER:
				return getSynchronisationPoint__VariableSetter();
			case ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER:
				return getCallReturnAction__VariableSetter();
			case ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER:
				return getSetVariableAction__VariableSetter();
			case ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER:
				return getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter();
			case ParameterPackage.VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER:
				if (resolve) return getVariableCharacteristic__VariableSetter();
				return basicGetVariableCharacteristic__VariableSetter();
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
			case ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER:
				setSpecification__VariableSetter((PCMRandomVariable)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER:
				setUserData__VariableSetter((UserData)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER:
				setAssemblyContext__VariableSetter((AssemblyContext)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER:
				setEntryLevelSystemCall__InputVariableSetter((EntryLevelSystemCall)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER:
				setEntryLevelSystemCall__OutputVariableSetter((EntryLevelSystemCall)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER:
				setCallAction__VariableSetter((CallAction)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER:
				setSynchronisationPoint__VariableSetter((SynchronisationPoint)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER:
				setCallReturnAction__VariableSetter((CallReturnAction)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER:
				setSetVariableAction__VariableSetter((SetVariableAction)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER:
				setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter((SpecifiedOutputParameterAbstraction)newValue);
				return;
			case ParameterPackage.VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER:
				setVariableCharacteristic__VariableSetter((VariableCharacteristic)newValue);
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
			case ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER:
				setSpecification__VariableSetter((PCMRandomVariable)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER:
				setUserData__VariableSetter((UserData)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER:
				setAssemblyContext__VariableSetter((AssemblyContext)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER:
				setEntryLevelSystemCall__InputVariableSetter((EntryLevelSystemCall)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER:
				setEntryLevelSystemCall__OutputVariableSetter((EntryLevelSystemCall)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER:
				setCallAction__VariableSetter((CallAction)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER:
				setSynchronisationPoint__VariableSetter((SynchronisationPoint)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER:
				setCallReturnAction__VariableSetter((CallReturnAction)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER:
				setSetVariableAction__VariableSetter((SetVariableAction)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER:
				setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter((SpecifiedOutputParameterAbstraction)null);
				return;
			case ParameterPackage.VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER:
				setVariableCharacteristic__VariableSetter((VariableCharacteristic)null);
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
			case ParameterPackage.VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER:
				return specification__VariableSetter != null;
			case ParameterPackage.VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER:
				return getUserData__VariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER:
				return getAssemblyContext__VariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER:
				return getEntryLevelSystemCall__InputVariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER:
				return getEntryLevelSystemCall__OutputVariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER:
				return getCallAction__VariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER:
				return getSynchronisationPoint__VariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER:
				return getCallReturnAction__VariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER:
				return getSetVariableAction__VariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER:
				return getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter() != null;
			case ParameterPackage.VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER:
				return variableCharacteristic__VariableSetter != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableSetterImpl
