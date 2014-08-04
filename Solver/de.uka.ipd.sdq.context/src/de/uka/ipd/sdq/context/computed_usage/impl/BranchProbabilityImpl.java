/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Branch Probability</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.context.computed_usage.impl.BranchProbabilityImpl#getProbability <em>
 * Probability</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.BranchProbabilityImpl#getBranchtransition_BranchProbability
 * <em>Branchtransition Branch Probability</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchProbabilityImpl extends EObjectImpl implements BranchProbability {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProbability()
     * @generated
     * @ordered
     */
    protected static final double PROBABILITY_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProbability()
     * @generated
     * @ordered
     */
    protected double probability = PROBABILITY_EDEFAULT;

    /**
     * The cached value of the '{@link #getBranchtransition_BranchProbability()
     * <em>Branchtransition Branch Probability</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getBranchtransition_BranchProbability()
     * @generated
     * @ordered
     */
    protected AbstractBranchTransition branchtransition_BranchProbability;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BranchProbabilityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ComputedUsagePackage.Literals.BRANCH_PROBABILITY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public double getProbability() {
        return probability;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProbability(double newProbability) {
        double oldProbability = probability;
        probability = newProbability;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ComputedUsagePackage.BRANCH_PROBABILITY__PROBABILITY,
                    oldProbability, probability));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractBranchTransition getBranchtransition_BranchProbability() {
        if (branchtransition_BranchProbability != null && branchtransition_BranchProbability.eIsProxy()) {
            InternalEObject oldBranchtransition_BranchProbability = (InternalEObject) branchtransition_BranchProbability;
            branchtransition_BranchProbability = (AbstractBranchTransition) eResolveProxy(oldBranchtransition_BranchProbability);
            if (branchtransition_BranchProbability != oldBranchtransition_BranchProbability) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ComputedUsagePackage.BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY,
                            oldBranchtransition_BranchProbability, branchtransition_BranchProbability));
            }
        }
        return branchtransition_BranchProbability;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractBranchTransition basicGetBranchtransition_BranchProbability() {
        return branchtransition_BranchProbability;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setBranchtransition_BranchProbability(AbstractBranchTransition newBranchtransition_BranchProbability) {
        AbstractBranchTransition oldBranchtransition_BranchProbability = branchtransition_BranchProbability;
        branchtransition_BranchProbability = newBranchtransition_BranchProbability;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY,
                    oldBranchtransition_BranchProbability, branchtransition_BranchProbability));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ComputedUsagePackage.BRANCH_PROBABILITY__PROBABILITY:
            return getProbability();
        case ComputedUsagePackage.BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY:
            if (resolve)
                return getBranchtransition_BranchProbability();
            return basicGetBranchtransition_BranchProbability();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ComputedUsagePackage.BRANCH_PROBABILITY__PROBABILITY:
            setProbability((Double) newValue);
            return;
        case ComputedUsagePackage.BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY:
            setBranchtransition_BranchProbability((AbstractBranchTransition) newValue);
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
        case ComputedUsagePackage.BRANCH_PROBABILITY__PROBABILITY:
            setProbability(PROBABILITY_EDEFAULT);
            return;
        case ComputedUsagePackage.BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY:
            setBranchtransition_BranchProbability((AbstractBranchTransition) null);
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
        case ComputedUsagePackage.BRANCH_PROBABILITY__PROBABILITY:
            return probability != PROBABILITY_EDEFAULT;
        case ComputedUsagePackage.BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY:
            return branchtransition_BranchProbability != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (probability: ");
        result.append(probability);
        result.append(')');
        return result.toString();
    }

} // BranchProbabilityImpl
