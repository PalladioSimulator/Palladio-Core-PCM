/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsage;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Computed Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageImpl#getUsageContexts_ComputedUsage
 * <em>Usage Contexts Computed Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputedUsageImpl extends EObjectImpl implements ComputedUsage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The cached value of the '{@link #getUsageContexts_ComputedUsage()
     * <em>Usage Contexts Computed Usage</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getUsageContexts_ComputedUsage()
     * @generated
     * @ordered
     */
    protected EList<ComputedUsageContext> usageContexts_ComputedUsage;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComputedUsageImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ComputedUsagePackage.Literals.COMPUTED_USAGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<ComputedUsageContext> getUsageContexts_ComputedUsage() {
        if (usageContexts_ComputedUsage == null) {
            usageContexts_ComputedUsage = new EObjectContainmentEList<ComputedUsageContext>(ComputedUsageContext.class,
                    this, ComputedUsagePackage.COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE);
        }
        return usageContexts_ComputedUsage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ComputedUsagePackage.COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE:
            return ((InternalEList<?>) getUsageContexts_ComputedUsage()).basicRemove(otherEnd, msgs);
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
        case ComputedUsagePackage.COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE:
            return getUsageContexts_ComputedUsage();
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
        case ComputedUsagePackage.COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE:
            getUsageContexts_ComputedUsage().clear();
            getUsageContexts_ComputedUsage().addAll((Collection<? extends ComputedUsageContext>) newValue);
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
        case ComputedUsagePackage.COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE:
            getUsageContexts_ComputedUsage().clear();
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
        case ComputedUsagePackage.COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE:
            return usageContexts_ComputedUsage != null && !usageContexts_ComputedUsage.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ComputedUsageImpl
