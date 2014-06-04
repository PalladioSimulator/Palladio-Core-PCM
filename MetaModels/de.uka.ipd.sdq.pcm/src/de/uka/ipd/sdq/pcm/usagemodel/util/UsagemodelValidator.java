/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UserData;
import de.uka.ipd.sdq.pcm.usagemodel.Workload;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage
 * @generated
 */
public class UsagemodelValidator extends EObjectValidator {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final UsagemodelValidator INSTANCE = new UsagemodelValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "de.uka.ipd.sdq.pcm.usagemodel";

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Entry Level
     * System Call Must Reference Provided Role Of ASystem' of 'Entry Level System Call'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int ENTRY_LEVEL_SYSTEM_CALL__ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM = 1;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Entry Level
     * System Call Signature Must Match Its Provided Role' of 'Entry Level System Call'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final int ENTRY_LEVEL_SYSTEM_CALL__ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE = 2;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Exactlyonestart' of 'Scenario Behaviour'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final int SCENARIO_BEHAVIOUR__EXACTLYONESTART = 3;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Exactlyonestop' of 'Scenario Behaviour'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final int SCENARIO_BEHAVIOUR__EXACTLYONESTOP = 4;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Eachuseractionexcept Startand Stopmusthaveapredecessorandsuccessor' of 'Scenario Behaviour'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final int SCENARIO_BEHAVIOUR__EACHUSERACTIONEXCEPT_STARTAND_STOPMUSTHAVEAPREDECESSORANDSUCCESSOR = 5;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'All Branch Probabilities Must Sum Up To1' of 'Branch'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final int BRANCH__ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1 = 6;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Stop Has No Successor' of 'Stop'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final int STOP__STOP_HAS_NO_SUCCESSOR = 7;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Start Has No Predecessor' of 'Start'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final int START__START_HAS_NO_PREDECESSOR = 8;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inter Arrival Time In Open Workload Needs To Be Specified' of 'Open Workload'.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public static final int OPEN_WORKLOAD__INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED = 9;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Population In Closed Workload Needs To Be Specified' of 'Closed Workload'.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static final int CLOSED_WORKLOAD__POPULATION_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED = 10;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Think Time In Closed Workload Needs To Be Specified' of 'Closed Workload'.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static final int CLOSED_WORKLOAD__THINK_TIME_IN_CLOSED_WORKLOAD_NEEDS_TO_BE_SPECIFIED = 11;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 11;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public UsagemodelValidator() {
        super();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
      return UsagemodelPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case UsagemodelPackage.WORKLOAD:
                return validateWorkload((Workload)value, diagnostics, context);
            case UsagemodelPackage.USAGE_SCENARIO:
                return validateUsageScenario((UsageScenario)value, diagnostics, context);
            case UsagemodelPackage.USER_DATA:
                return validateUserData((UserData)value, diagnostics, context);
            case UsagemodelPackage.USAGE_MODEL:
                return validateUsageModel((UsageModel)value, diagnostics, context);
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL:
                return validateEntryLevelSystemCall((EntryLevelSystemCall)value, diagnostics, context);
            case UsagemodelPackage.ABSTRACT_USER_ACTION:
                return validateAbstractUserAction((AbstractUserAction)value, diagnostics, context);
            case UsagemodelPackage.SCENARIO_BEHAVIOUR:
                return validateScenarioBehaviour((ScenarioBehaviour)value, diagnostics, context);
            case UsagemodelPackage.BRANCH_TRANSITION:
                return validateBranchTransition((BranchTransition)value, diagnostics, context);
            case UsagemodelPackage.BRANCH:
                return validateBranch((Branch)value, diagnostics, context);
            case UsagemodelPackage.LOOP:
                return validateLoop((Loop)value, diagnostics, context);
            case UsagemodelPackage.STOP:
                return validateStop((Stop)value, diagnostics, context);
            case UsagemodelPackage.START:
                return validateStart((Start)value, diagnostics, context);
            case UsagemodelPackage.OPEN_WORKLOAD:
                return validateOpenWorkload((OpenWorkload)value, diagnostics, context);
            case UsagemodelPackage.DELAY:
                return validateDelay((Delay)value, diagnostics, context);
            case UsagemodelPackage.CLOSED_WORKLOAD:
                return validateClosedWorkload((ClosedWorkload)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateWorkload(Workload workload, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject)workload, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUsageScenario(UsageScenario usageScenario, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject)usageScenario, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateScenarioBehaviour(ScenarioBehaviour scenarioBehaviour, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject)scenarioBehaviour, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms((EObject)scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID((EObject)scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validateScenarioBehaviour_Exactlyonestart(scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validateScenarioBehaviour_Exactlyonestop(scenarioBehaviour, diagnostics, context);
        if (result || diagnostics != null) result &= validateScenarioBehaviour_EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(scenarioBehaviour, diagnostics, context);
        return result;
    }

    /**
     * Validates the Exactlyonestart constraint of '<em>Scenario Behaviour</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateScenarioBehaviour_Exactlyonestart(ScenarioBehaviour scenarioBehaviour,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return scenarioBehaviour.Exactlyonestart(diagnostics, context);
    }

    /**
     * Validates the Exactlyonestop constraint of '<em>Scenario Behaviour</em>'.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateScenarioBehaviour_Exactlyonestop(ScenarioBehaviour scenarioBehaviour,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return scenarioBehaviour.Exactlyonestop(diagnostics, context);
    }

    /**
     * Validates the EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor constraint of '<em>Scenario Behaviour</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateScenarioBehaviour_EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(
            ScenarioBehaviour scenarioBehaviour, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return scenarioBehaviour.EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAbstractUserAction(AbstractUserAction abstractUserAction, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject)abstractUserAction, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateBranchTransition(BranchTransition branchTransition, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject)branchTransition, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateBranch(Branch branch, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject)branch, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms((EObject)branch, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)branch, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)branch, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)branch, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID((EObject)branch, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)branch, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)branch, diagnostics, context);
        if (result || diagnostics != null) result &= validateBranch_AllBranchProbabilitiesMustSumUpTo1(branch, diagnostics, context);
        return result;
    }

    /**
     * Validates the AllBranchProbabilitiesMustSumUpTo1 constraint of '<em>Branch</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean validateBranch_AllBranchProbabilitiesMustSumUpTo1(Branch branch, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return branch.AllBranchProbabilitiesMustSumUpTo1(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLoop(Loop loop, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject)loop, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUsageModel(UsageModel usageModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject)usageModel, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStop(Stop stop, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject)stop, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms((EObject)stop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)stop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)stop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)stop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID((EObject)stop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)stop, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)stop, diagnostics, context);
        if (result || diagnostics != null) result &= validateStop_StopHasNoSuccessor(stop, diagnostics, context);
        return result;
    }

    /**
     * Validates the StopHasNoSuccessor constraint of '<em>Stop</em>'.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public boolean validateStop_StopHasNoSuccessor(Stop stop, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return stop.StopHasNoSuccessor(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStart(Start start, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject)start, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms((EObject)start, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)start, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)start, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)start, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID((EObject)start, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)start, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)start, diagnostics, context);
        if (result || diagnostics != null) result &= validateStart_StartHasNoPredecessor(start, diagnostics, context);
        return result;
    }

    /**
     * Validates the StartHasNoPredecessor constraint of '<em>Start</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStart_StartHasNoPredecessor(Start start, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return start.StartHasNoPredecessor(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOpenWorkload(OpenWorkload openWorkload, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject)openWorkload, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms((EObject)openWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)openWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)openWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)openWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID((EObject)openWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)openWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)openWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validateOpenWorkload_InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(openWorkload, diagnostics, context);
        return result;
    }

    /**
     * Validates the InterArrivalTimeInOpenWorkloadNeedsToBeSpecified constraint of '<em>Open Workload</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOpenWorkload_InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(OpenWorkload openWorkload,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return openWorkload.InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEntryLevelSystemCall(EntryLevelSystemCall entryLevelSystemCall, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject)entryLevelSystemCall, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms((EObject)entryLevelSystemCall, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)entryLevelSystemCall, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)entryLevelSystemCall, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)entryLevelSystemCall, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID((EObject)entryLevelSystemCall, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)entryLevelSystemCall, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)entryLevelSystemCall, diagnostics, context);
        if (result || diagnostics != null) result &= validateEntryLevelSystemCall_EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(entryLevelSystemCall, diagnostics, context);
        if (result || diagnostics != null) result &= validateEntryLevelSystemCall_EntryLevelSystemCallSignatureMustMatchItsProvidedRole(entryLevelSystemCall, diagnostics, context);
        return result;
    }

    /**
     * Validates the EntryLevelSystemCallMustReferenceProvidedRoleOfASystem constraint of '<em>Entry Level System Call</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEntryLevelSystemCall_EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(
            EntryLevelSystemCall entryLevelSystemCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return entryLevelSystemCall.EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(diagnostics, context);
    }

    /**
     * Validates the EntryLevelSystemCallSignatureMustMatchItsProvidedRole constraint of '<em>Entry Level System Call</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEntryLevelSystemCall_EntryLevelSystemCallSignatureMustMatchItsProvidedRole(
            EntryLevelSystemCall entryLevelSystemCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return entryLevelSystemCall.EntryLevelSystemCallSignatureMustMatchItsProvidedRole(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClosedWorkload(ClosedWorkload closedWorkload, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (!validate_NoCircularContainment((EObject)closedWorkload, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms((EObject)closedWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)closedWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)closedWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)closedWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID((EObject)closedWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)closedWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)closedWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validateClosedWorkload_PopulationInClosedWorkloadNeedsToBeSpecified(closedWorkload, diagnostics, context);
        if (result || diagnostics != null) result &= validateClosedWorkload_ThinkTimeInClosedWorkloadNeedsToBeSpecified(closedWorkload, diagnostics, context);
        return result;
    }

    /**
     * Validates the PopulationInClosedWorkloadNeedsToBeSpecified constraint of '<em>Closed Workload</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClosedWorkload_PopulationInClosedWorkloadNeedsToBeSpecified(ClosedWorkload closedWorkload,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return closedWorkload.PopulationInClosedWorkloadNeedsToBeSpecified(diagnostics, context);
    }

    /**
     * Validates the ThinkTimeInClosedWorkloadNeedsToBeSpecified constraint of '<em>Closed Workload</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClosedWorkload_ThinkTimeInClosedWorkloadNeedsToBeSpecified(ClosedWorkload closedWorkload,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return closedWorkload.ThinkTimeInClosedWorkloadNeedsToBeSpecified(diagnostics, context);
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDelay(Delay delay, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject)delay, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUserData(UserData userData, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject)userData, diagnostics, context);
    }

} // UsagemodelValidator
