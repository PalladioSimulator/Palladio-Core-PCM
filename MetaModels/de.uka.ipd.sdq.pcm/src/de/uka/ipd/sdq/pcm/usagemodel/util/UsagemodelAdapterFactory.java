/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage
 * @generated
 */
public class UsagemodelAdapterFactory extends AdapterFactoryImpl {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static UsagemodelPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public UsagemodelAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = UsagemodelPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected UsagemodelSwitch<Adapter> modelSwitch = new UsagemodelSwitch<Adapter>() {
        @Override
        public Adapter caseWorkload(Workload object) {
            return createWorkloadAdapter();
        }

        @Override
        public Adapter caseUsageScenario(UsageScenario object) {
            return createUsageScenarioAdapter();
        }

        @Override
        public Adapter caseUserData(UserData object) {
            return createUserDataAdapter();
        }

        @Override
        public Adapter caseUsageModel(UsageModel object) {
            return createUsageModelAdapter();
        }

        @Override
        public Adapter caseEntryLevelSystemCall(EntryLevelSystemCall object) {
            return createEntryLevelSystemCallAdapter();
        }

        @Override
        public Adapter caseAbstractUserAction(AbstractUserAction object) {
            return createAbstractUserActionAdapter();
        }

        @Override
        public Adapter caseScenarioBehaviour(ScenarioBehaviour object) {
            return createScenarioBehaviourAdapter();
        }

        @Override
        public Adapter caseBranchTransition(BranchTransition object) {
            return createBranchTransitionAdapter();
        }

        @Override
        public Adapter caseBranch(Branch object) {
            return createBranchAdapter();
        }

        @Override
        public Adapter caseLoop(Loop object) {
            return createLoopAdapter();
        }

        @Override
        public Adapter caseStop(Stop object) {
            return createStopAdapter();
        }

        @Override
        public Adapter caseStart(Start object) {
            return createStartAdapter();
        }

        @Override
        public Adapter caseOpenWorkload(OpenWorkload object) {
            return createOpenWorkloadAdapter();
        }

        @Override
        public Adapter caseDelay(Delay object) {
            return createDelayAdapter();
        }

        @Override
        public Adapter caseClosedWorkload(ClosedWorkload object) {
            return createClosedWorkloadAdapter();
        }

        @Override
        public Adapter caseIdentifier(Identifier object) {
            return createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(NamedElement object) {
            return createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(Entity object) {
            return createEntityAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.usagemodel.Workload
     * <em>Workload</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.Workload
     * @generated
     */
    public Adapter createWorkloadAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.UsageScenario <em>Usage Scenario</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
     * @generated
     */
    public Adapter createUsageScenarioAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour <em>Scenario Behaviour</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour
     * @generated
     */
    public Adapter createScenarioBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction <em>Abstract User Action</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
     * @generated
     */
    public Adapter createAbstractUserActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.BranchTransition <em>Branch Transition</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.BranchTransition
     * @generated
     */
    public Adapter createBranchTransitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.usagemodel.Branch
     * <em>Branch</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.Branch
     * @generated
     */
    public Adapter createBranchAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.usagemodel.Loop
     * <em>Loop</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.Loop
     * @generated
     */
    public Adapter createLoopAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.UsageModel <em>Usage Model</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.UsageModel
     * @generated
     */
    public Adapter createUsageModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.usagemodel.Stop
     * <em>Stop</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.Stop
     * @generated
     */
    public Adapter createStopAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.usagemodel.Start
     * <em>Start</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.Start
     * @generated
     */
    public Adapter createStartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload <em>Open Workload</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload
     * @generated
     */
    public Adapter createOpenWorkloadAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall <em>Entry Level System Call</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
     * @generated
     */
    public Adapter createEntryLevelSystemCallAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload <em>Closed Workload</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload
     * @generated
     */
    public Adapter createClosedWorkloadAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.usagemodel.Delay
     * <em>Delay</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.Delay
     * @generated
     */
    public Adapter createDelayAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.usagemodel.UserData
     * <em>User Data</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.usagemodel.UserData
     * @generated
     */
    public Adapter createUserDataAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier
     * <em>Identifier</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.core.entity.NamedElement <em>Named Element</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.core.entity.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.core.entity.Entity
     * <em>Entity</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.core.entity.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // UsagemodelAdapterFactory
