/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.Workload;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Usage Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl#getUsageModel_UsageScenario <em>
 * Usage Model Usage Scenario</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl#getScenarioBehaviour_UsageScenario
 * <em>Scenario Behaviour Usage Scenario</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.UsageScenarioImpl#getWorkload_UsageScenario <em>
 * Workload Usage Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageScenarioImpl extends EntityImpl implements UsageScenario {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getScenarioBehaviour_UsageScenario()
     * <em>Scenario Behaviour Usage Scenario</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getScenarioBehaviour_UsageScenario()
     * @generated
     * @ordered
     */
    protected ScenarioBehaviour scenarioBehaviour_UsageScenario;
    /**
     * The cached value of the '{@link #getWorkload_UsageScenario()
     * <em>Workload Usage Scenario</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getWorkload_UsageScenario()
     * @generated
     * @ordered
     */
    protected Workload workload_UsageScenario;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UsageScenarioImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.USAGE_SCENARIO;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ScenarioBehaviour getScenarioBehaviour_UsageScenario() {
        return this.scenarioBehaviour_UsageScenario;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetScenarioBehaviour_UsageScenario(
            final ScenarioBehaviour newScenarioBehaviour_UsageScenario, NotificationChain msgs) {
        final ScenarioBehaviour oldScenarioBehaviour_UsageScenario = this.scenarioBehaviour_UsageScenario;
        this.scenarioBehaviour_UsageScenario = newScenarioBehaviour_UsageScenario;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO,
                    oldScenarioBehaviour_UsageScenario, newScenarioBehaviour_UsageScenario);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setScenarioBehaviour_UsageScenario(final ScenarioBehaviour newScenarioBehaviour_UsageScenario) {
        if (newScenarioBehaviour_UsageScenario != this.scenarioBehaviour_UsageScenario) {
            NotificationChain msgs = null;
            if (this.scenarioBehaviour_UsageScenario != null) {
                msgs = ((InternalEObject) this.scenarioBehaviour_UsageScenario).eInverseRemove(this,
                        UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR,
                        ScenarioBehaviour.class, msgs);
            }
            if (newScenarioBehaviour_UsageScenario != null) {
                msgs = ((InternalEObject) newScenarioBehaviour_UsageScenario).eInverseAdd(this,
                        UsagemodelPackage.SCENARIO_BEHAVIOUR__USAGE_SCENARIO_SENARIO_BEHAVIOUR,
                        ScenarioBehaviour.class, msgs);
            }
            msgs = this.basicSetScenarioBehaviour_UsageScenario(newScenarioBehaviour_UsageScenario, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO,
                    newScenarioBehaviour_UsageScenario, newScenarioBehaviour_UsageScenario));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UsageModel getUsageModel_UsageScenario() {
        if (this.eContainerFeatureID() != UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO) {
            return null;
        }
        return (UsageModel) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetUsageModel_UsageScenario(final UsageModel newUsageModel_UsageScenario,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newUsageModel_UsageScenario,
                UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setUsageModel_UsageScenario(final UsageModel newUsageModel_UsageScenario) {
        if (newUsageModel_UsageScenario != this.eInternalContainer()
                || (this.eContainerFeatureID() != UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO && newUsageModel_UsageScenario != null)) {
            if (EcoreUtil.isAncestor(this, newUsageModel_UsageScenario)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newUsageModel_UsageScenario != null) {
                msgs = ((InternalEObject) newUsageModel_UsageScenario).eInverseAdd(this,
                        UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL, UsageModel.class, msgs);
            }
            msgs = this.basicSetUsageModel_UsageScenario(newUsageModel_UsageScenario, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO, newUsageModel_UsageScenario,
                    newUsageModel_UsageScenario));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Workload getWorkload_UsageScenario() {
        return this.workload_UsageScenario;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetWorkload_UsageScenario(final Workload newWorkload_UsageScenario,
            NotificationChain msgs) {
        final Workload oldWorkload_UsageScenario = this.workload_UsageScenario;
        this.workload_UsageScenario = newWorkload_UsageScenario;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, oldWorkload_UsageScenario,
                    newWorkload_UsageScenario);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWorkload_UsageScenario(final Workload newWorkload_UsageScenario) {
        if (newWorkload_UsageScenario != this.workload_UsageScenario) {
            NotificationChain msgs = null;
            if (this.workload_UsageScenario != null) {
                msgs = ((InternalEObject) this.workload_UsageScenario).eInverseRemove(this,
                        UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD, Workload.class, msgs);
            }
            if (newWorkload_UsageScenario != null) {
                msgs = ((InternalEObject) newWorkload_UsageScenario).eInverseAdd(this,
                        UsagemodelPackage.WORKLOAD__USAGE_SCENARIO_WORKLOAD, Workload.class, msgs);
            }
            msgs = this.basicSetWorkload_UsageScenario(newWorkload_UsageScenario, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, newWorkload_UsageScenario,
                    newWorkload_UsageScenario));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetUsageModel_UsageScenario((UsageModel) otherEnd, msgs);
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            if (this.scenarioBehaviour_UsageScenario != null) {
                msgs = ((InternalEObject) this.scenarioBehaviour_UsageScenario).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO,
                        null, msgs);
            }
            return this.basicSetScenarioBehaviour_UsageScenario((ScenarioBehaviour) otherEnd, msgs);
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            if (this.workload_UsageScenario != null) {
                msgs = ((InternalEObject) this.workload_UsageScenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO, null, msgs);
            }
            return this.basicSetWorkload_UsageScenario((Workload) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            return this.basicSetUsageModel_UsageScenario(null, msgs);
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            return this.basicSetScenarioBehaviour_UsageScenario(null, msgs);
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            return this.basicSetWorkload_UsageScenario(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            return this.eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.USAGE_MODEL__USAGE_SCENARIO_USAGE_MODEL, UsageModel.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            return this.getUsageModel_UsageScenario();
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            return this.getScenarioBehaviour_UsageScenario();
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            return this.getWorkload_UsageScenario();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            this.setUsageModel_UsageScenario((UsageModel) newValue);
            return;
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            this.setScenarioBehaviour_UsageScenario((ScenarioBehaviour) newValue);
            return;
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            this.setWorkload_UsageScenario((Workload) newValue);
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
    public void eUnset(final int featureID) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            this.setUsageModel_UsageScenario((UsageModel) null);
            return;
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            this.setScenarioBehaviour_UsageScenario((ScenarioBehaviour) null);
            return;
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            this.setWorkload_UsageScenario((Workload) null);
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
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case UsagemodelPackage.USAGE_SCENARIO__USAGE_MODEL_USAGE_SCENARIO:
            return this.getUsageModel_UsageScenario() != null;
        case UsagemodelPackage.USAGE_SCENARIO__SCENARIO_BEHAVIOUR_USAGE_SCENARIO:
            return this.scenarioBehaviour_UsageScenario != null;
        case UsagemodelPackage.USAGE_SCENARIO__WORKLOAD_USAGE_SCENARIO:
            return this.workload_UsageScenario != null;
        }
        return super.eIsSet(featureID);
    }

} // UsageScenarioImpl
