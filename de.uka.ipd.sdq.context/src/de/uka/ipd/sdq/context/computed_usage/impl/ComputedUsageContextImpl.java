/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallInput;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;
import de.uka.ipd.sdq.context.computed_usage.Output;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Context</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getBranchProbabilities_ComputedUsageContext
 * <em>Branch Probabilities Computed Usage Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getLoopiterations_ComputedUsageContext
 * <em>Loopiterations Computed Usage Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getAssemblyContext_ComputedUsageContext
 * <em>Assembly Context Computed Usage Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getInput_ComputedUsageContext
 * <em>Input Computed Usage Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getExternalCallOutput_ComputedUsageContext
 * <em>External Call Output Computed Usage Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getExternalCallInput_ComputedUsageContext
 * <em>External Call Input Computed Usage Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getOutput_ComputedUsageContext
 * <em>Output Computed Usage Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputedUsageContextImpl extends EntityImpl implements ComputedUsageContext {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The cached value of the '{@link #getBranchProbabilities_ComputedUsageContext()
     * <em>Branch Probabilities Computed Usage Context</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBranchProbabilities_ComputedUsageContext()
     * @generated
     * @ordered
     */
    protected EList<BranchProbability> branchProbabilities_ComputedUsageContext;

    /**
     * The cached value of the '{@link #getLoopiterations_ComputedUsageContext()
     * <em>Loopiterations Computed Usage Context</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLoopiterations_ComputedUsageContext()
     * @generated
     * @ordered
     */
    protected EList<LoopIteration> loopiterations_ComputedUsageContext;

    /**
     * The cached value of the '{@link #getAssemblyContext_ComputedUsageContext()
     * <em>Assembly Context Computed Usage Context</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getAssemblyContext_ComputedUsageContext()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext_ComputedUsageContext;

    /**
     * The cached value of the '{@link #getInput_ComputedUsageContext()
     * <em>Input Computed Usage Context</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getInput_ComputedUsageContext()
     * @generated
     * @ordered
     */
    protected Input input_ComputedUsageContext;

    /**
     * The cached value of the '{@link #getExternalCallOutput_ComputedUsageContext()
     * <em>External Call Output Computed Usage Context</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExternalCallOutput_ComputedUsageContext()
     * @generated
     * @ordered
     */
    protected EList<ExternalCallOutput> externalCallOutput_ComputedUsageContext;

    /**
     * The cached value of the '{@link #getExternalCallInput_ComputedUsageContext()
     * <em>External Call Input Computed Usage Context</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExternalCallInput_ComputedUsageContext()
     * @generated
     * @ordered
     */
    protected EList<ExternalCallInput> externalCallInput_ComputedUsageContext;

    /**
     * The cached value of the '{@link #getOutput_ComputedUsageContext()
     * <em>Output Computed Usage Context</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getOutput_ComputedUsageContext()
     * @generated
     * @ordered
     */
    protected Output output_ComputedUsageContext;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComputedUsageContextImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ComputedUsagePackage.Literals.COMPUTED_USAGE_CONTEXT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<BranchProbability> getBranchProbabilities_ComputedUsageContext() {
        if (branchProbabilities_ComputedUsageContext == null) {
            branchProbabilities_ComputedUsageContext = new EObjectContainmentEList<BranchProbability>(
                    BranchProbability.class, this,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT);
        }
        return branchProbabilities_ComputedUsageContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<LoopIteration> getLoopiterations_ComputedUsageContext() {
        if (loopiterations_ComputedUsageContext == null) {
            loopiterations_ComputedUsageContext = new EObjectContainmentEList<LoopIteration>(LoopIteration.class, this,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT);
        }
        return loopiterations_ComputedUsageContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext getAssemblyContext_ComputedUsageContext() {
        if (assemblyContext_ComputedUsageContext != null && assemblyContext_ComputedUsageContext.eIsProxy()) {
            InternalEObject oldAssemblyContext_ComputedUsageContext = (InternalEObject) assemblyContext_ComputedUsageContext;
            assemblyContext_ComputedUsageContext = (AssemblyContext) eResolveProxy(oldAssemblyContext_ComputedUsageContext);
            if (assemblyContext_ComputedUsageContext != oldAssemblyContext_ComputedUsageContext) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT,
                            oldAssemblyContext_ComputedUsageContext, assemblyContext_ComputedUsageContext));
            }
        }
        return assemblyContext_ComputedUsageContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_ComputedUsageContext() {
        return assemblyContext_ComputedUsageContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAssemblyContext_ComputedUsageContext(AssemblyContext newAssemblyContext_ComputedUsageContext) {
        AssemblyContext oldAssemblyContext_ComputedUsageContext = assemblyContext_ComputedUsageContext;
        assemblyContext_ComputedUsageContext = newAssemblyContext_ComputedUsageContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT,
                    oldAssemblyContext_ComputedUsageContext, assemblyContext_ComputedUsageContext));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Input getInput_ComputedUsageContext() {
        return input_ComputedUsageContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetInput_ComputedUsageContext(Input newInput_ComputedUsageContext,
            NotificationChain msgs) {
        Input oldInput_ComputedUsageContext = input_ComputedUsageContext;
        input_ComputedUsageContext = newInput_ComputedUsageContext;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT,
                    oldInput_ComputedUsageContext, newInput_ComputedUsageContext);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setInput_ComputedUsageContext(Input newInput_ComputedUsageContext) {
        if (newInput_ComputedUsageContext != input_ComputedUsageContext) {
            NotificationChain msgs = null;
            if (input_ComputedUsageContext != null)
                msgs = ((InternalEObject) input_ComputedUsageContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT, null, msgs);
            if (newInput_ComputedUsageContext != null)
                msgs = ((InternalEObject) newInput_ComputedUsageContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT, null, msgs);
            msgs = basicSetInput_ComputedUsageContext(newInput_ComputedUsageContext, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT,
                    newInput_ComputedUsageContext, newInput_ComputedUsageContext));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<ExternalCallOutput> getExternalCallOutput_ComputedUsageContext() {
        if (externalCallOutput_ComputedUsageContext == null) {
            externalCallOutput_ComputedUsageContext = new EObjectContainmentEList<ExternalCallOutput>(
                    ExternalCallOutput.class, this,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT);
        }
        return externalCallOutput_ComputedUsageContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<ExternalCallInput> getExternalCallInput_ComputedUsageContext() {
        if (externalCallInput_ComputedUsageContext == null) {
            externalCallInput_ComputedUsageContext = new EObjectContainmentWithInverseEList<ExternalCallInput>(
                    ExternalCallInput.class, this,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT,
                    ComputedUsagePackage.EXTERNAL_CALL_INPUT__COMPUTED_USAGE_CONTEXT_EXTERNAL_CALL_INPUT);
        }
        return externalCallInput_ComputedUsageContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Output getOutput_ComputedUsageContext() {
        return output_ComputedUsageContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetOutput_ComputedUsageContext(Output newOutput_ComputedUsageContext,
            NotificationChain msgs) {
        Output oldOutput_ComputedUsageContext = output_ComputedUsageContext;
        output_ComputedUsageContext = newOutput_ComputedUsageContext;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT,
                    oldOutput_ComputedUsageContext, newOutput_ComputedUsageContext);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setOutput_ComputedUsageContext(Output newOutput_ComputedUsageContext) {
        if (newOutput_ComputedUsageContext != output_ComputedUsageContext) {
            NotificationChain msgs = null;
            if (output_ComputedUsageContext != null)
                msgs = ((InternalEObject) output_ComputedUsageContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT, null, msgs);
            if (newOutput_ComputedUsageContext != null)
                msgs = ((InternalEObject) newOutput_ComputedUsageContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT, null, msgs);
            msgs = basicSetOutput_ComputedUsageContext(newOutput_ComputedUsageContext, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT,
                    newOutput_ComputedUsageContext, newOutput_ComputedUsageContext));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getExternalCallInput_ComputedUsageContext())
                    .basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
            return ((InternalEList<?>) getBranchProbabilities_ComputedUsageContext()).basicRemove(otherEnd, msgs);
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
            return ((InternalEList<?>) getLoopiterations_ComputedUsageContext()).basicRemove(otherEnd, msgs);
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT:
            return basicSetInput_ComputedUsageContext(null, msgs);
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT:
            return ((InternalEList<?>) getExternalCallOutput_ComputedUsageContext()).basicRemove(otherEnd, msgs);
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT:
            return ((InternalEList<?>) getExternalCallInput_ComputedUsageContext()).basicRemove(otherEnd, msgs);
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT:
            return basicSetOutput_ComputedUsageContext(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
            return getBranchProbabilities_ComputedUsageContext();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
            return getLoopiterations_ComputedUsageContext();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT:
            if (resolve)
                return getAssemblyContext_ComputedUsageContext();
            return basicGetAssemblyContext_ComputedUsageContext();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT:
            return getInput_ComputedUsageContext();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT:
            return getExternalCallOutput_ComputedUsageContext();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT:
            return getExternalCallInput_ComputedUsageContext();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT:
            return getOutput_ComputedUsageContext();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
            getBranchProbabilities_ComputedUsageContext().clear();
            getBranchProbabilities_ComputedUsageContext().addAll((Collection<? extends BranchProbability>) newValue);
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
            getLoopiterations_ComputedUsageContext().clear();
            getLoopiterations_ComputedUsageContext().addAll((Collection<? extends LoopIteration>) newValue);
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT:
            setAssemblyContext_ComputedUsageContext((AssemblyContext) newValue);
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT:
            setInput_ComputedUsageContext((Input) newValue);
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT:
            getExternalCallOutput_ComputedUsageContext().clear();
            getExternalCallOutput_ComputedUsageContext().addAll((Collection<? extends ExternalCallOutput>) newValue);
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT:
            getExternalCallInput_ComputedUsageContext().clear();
            getExternalCallInput_ComputedUsageContext().addAll((Collection<? extends ExternalCallInput>) newValue);
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT:
            setOutput_ComputedUsageContext((Output) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
            getBranchProbabilities_ComputedUsageContext().clear();
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
            getLoopiterations_ComputedUsageContext().clear();
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT:
            setAssemblyContext_ComputedUsageContext((AssemblyContext) null);
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT:
            setInput_ComputedUsageContext((Input) null);
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT:
            getExternalCallOutput_ComputedUsageContext().clear();
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT:
            getExternalCallInput_ComputedUsageContext().clear();
            return;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT:
            setOutput_ComputedUsageContext((Output) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
            return branchProbabilities_ComputedUsageContext != null
                    && !branchProbabilities_ComputedUsageContext.isEmpty();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
            return loopiterations_ComputedUsageContext != null && !loopiterations_ComputedUsageContext.isEmpty();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT:
            return assemblyContext_ComputedUsageContext != null;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT:
            return input_ComputedUsageContext != null;
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT:
            return externalCallOutput_ComputedUsageContext != null
                    && !externalCallOutput_ComputedUsageContext.isEmpty();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT:
            return externalCallInput_ComputedUsageContext != null && !externalCallInput_ComputedUsageContext.isEmpty();
        case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT:
            return output_ComputedUsageContext != null;
        }
        return super.eIsSet(featureID);
    }

} // ComputedUsageContextImpl
