/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.VariableUsageParameter;
import de.uka.ipd.sdq.sensitivity.VariableUsageType;
import de.uka.ipd.sdq.sensitivity.util.SensitivityValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Variable Usage Parameter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl#getVariableName <em>
 * Variable Name</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl#getEntryLevelSystemCall__VariableUsageParameter
 * <em>Entry Level System Call Variable Usage Parameter</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl#getVariableCharacterisationType__VariableUsageParameter
 * <em>Variable Characterisation Type Variable Usage Parameter</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl#getVariableUsageType__VariableUsageParameter
 * <em>Variable Usage Type Variable Usage Parameter</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.sensitivity.impl.VariableUsageParameterImpl#getBasicComponent__VariableUsageParameter
 * <em>Basic Component Variable Usage Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableUsageParameterImpl extends SingleSensitivityParameterImpl implements VariableUsageParameter {
    /**
     * The default value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVariableName()
     * @generated
     * @ordered
     */
    protected static final String VARIABLE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVariableName()
     * @generated
     * @ordered
     */
    protected String variableName = VARIABLE_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getEntryLevelSystemCall__VariableUsageParameter()
     * <em>Entry Level System Call Variable Usage Parameter</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getEntryLevelSystemCall__VariableUsageParameter()
     * @generated
     * @ordered
     */
    protected EntryLevelSystemCall entryLevelSystemCall__VariableUsageParameter;

    /**
     * The default value of the '{@link #getVariableCharacterisationType__VariableUsageParameter()
     * <em>Variable Characterisation Type Variable Usage Parameter</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVariableCharacterisationType__VariableUsageParameter()
     * @generated
     * @ordered
     */
    protected static final VariableCharacterisationType VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT = VariableCharacterisationType.STRUCTURE;

    /**
     * The cached value of the '{@link #getVariableCharacterisationType__VariableUsageParameter()
     * <em>Variable Characterisation Type Variable Usage Parameter</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVariableCharacterisationType__VariableUsageParameter()
     * @generated
     * @ordered
     */
    protected VariableCharacterisationType variableCharacterisationType__VariableUsageParameter = VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT;

    /**
     * The default value of the '{@link #getVariableUsageType__VariableUsageParameter()
     * <em>Variable Usage Type Variable Usage Parameter</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getVariableUsageType__VariableUsageParameter()
     * @generated
     * @ordered
     */
    protected static final VariableUsageType VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT = VariableUsageType.SYSTEM_CALL_INPUT;

    /**
     * The cached value of the '{@link #getVariableUsageType__VariableUsageParameter()
     * <em>Variable Usage Type Variable Usage Parameter</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getVariableUsageType__VariableUsageParameter()
     * @generated
     * @ordered
     */
    protected VariableUsageType variableUsageType__VariableUsageParameter = VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT;

    /**
     * The cached value of the '{@link #getBasicComponent__VariableUsageParameter()
     * <em>Basic Component Variable Usage Parameter</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getBasicComponent__VariableUsageParameter()
     * @generated
     * @ordered
     */
    protected BasicComponent basicComponent__VariableUsageParameter;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected VariableUsageParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SensitivityPackage.Literals.VARIABLE_USAGE_PARAMETER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setVariableName(String newVariableName) {
        String oldVariableName = variableName;
        variableName = newVariableName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_NAME, oldVariableName, variableName));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EntryLevelSystemCall getEntryLevelSystemCall__VariableUsageParameter() {
        if (entryLevelSystemCall__VariableUsageParameter != null
                && entryLevelSystemCall__VariableUsageParameter.eIsProxy()) {
            InternalEObject oldEntryLevelSystemCall__VariableUsageParameter = (InternalEObject) entryLevelSystemCall__VariableUsageParameter;
            entryLevelSystemCall__VariableUsageParameter = (EntryLevelSystemCall) eResolveProxy(oldEntryLevelSystemCall__VariableUsageParameter);
            if (entryLevelSystemCall__VariableUsageParameter != oldEntryLevelSystemCall__VariableUsageParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            SensitivityPackage.VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER,
                            oldEntryLevelSystemCall__VariableUsageParameter,
                            entryLevelSystemCall__VariableUsageParameter));
            }
        }
        return entryLevelSystemCall__VariableUsageParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EntryLevelSystemCall basicGetEntryLevelSystemCall__VariableUsageParameter() {
        return entryLevelSystemCall__VariableUsageParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setEntryLevelSystemCall__VariableUsageParameter(
            EntryLevelSystemCall newEntryLevelSystemCall__VariableUsageParameter) {
        EntryLevelSystemCall oldEntryLevelSystemCall__VariableUsageParameter = entryLevelSystemCall__VariableUsageParameter;
        entryLevelSystemCall__VariableUsageParameter = newEntryLevelSystemCall__VariableUsageParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SensitivityPackage.VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER,
                    oldEntryLevelSystemCall__VariableUsageParameter, entryLevelSystemCall__VariableUsageParameter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public VariableCharacterisationType getVariableCharacterisationType__VariableUsageParameter() {
        return variableCharacterisationType__VariableUsageParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setVariableCharacterisationType__VariableUsageParameter(
            VariableCharacterisationType newVariableCharacterisationType__VariableUsageParameter) {
        VariableCharacterisationType oldVariableCharacterisationType__VariableUsageParameter = variableCharacterisationType__VariableUsageParameter;
        variableCharacterisationType__VariableUsageParameter = newVariableCharacterisationType__VariableUsageParameter == null ? VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT
                : newVariableCharacterisationType__VariableUsageParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER,
                    oldVariableCharacterisationType__VariableUsageParameter,
                    variableCharacterisationType__VariableUsageParameter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public VariableUsageType getVariableUsageType__VariableUsageParameter() {
        return variableUsageType__VariableUsageParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setVariableUsageType__VariableUsageParameter(
            VariableUsageType newVariableUsageType__VariableUsageParameter) {
        VariableUsageType oldVariableUsageType__VariableUsageParameter = variableUsageType__VariableUsageParameter;
        variableUsageType__VariableUsageParameter = newVariableUsageType__VariableUsageParameter == null ? VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT
                : newVariableUsageType__VariableUsageParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER,
                    oldVariableUsageType__VariableUsageParameter, variableUsageType__VariableUsageParameter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BasicComponent getBasicComponent__VariableUsageParameter() {
        if (basicComponent__VariableUsageParameter != null && basicComponent__VariableUsageParameter.eIsProxy()) {
            InternalEObject oldBasicComponent__VariableUsageParameter = (InternalEObject) basicComponent__VariableUsageParameter;
            basicComponent__VariableUsageParameter = (BasicComponent) eResolveProxy(oldBasicComponent__VariableUsageParameter);
            if (basicComponent__VariableUsageParameter != oldBasicComponent__VariableUsageParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SensitivityPackage.VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER,
                            oldBasicComponent__VariableUsageParameter, basicComponent__VariableUsageParameter));
            }
        }
        return basicComponent__VariableUsageParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BasicComponent basicGetBasicComponent__VariableUsageParameter() {
        return basicComponent__VariableUsageParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setBasicComponent__VariableUsageParameter(BasicComponent newBasicComponent__VariableUsageParameter) {
        BasicComponent oldBasicComponent__VariableUsageParameter = basicComponent__VariableUsageParameter;
        basicComponent__VariableUsageParameter = newBasicComponent__VariableUsageParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SensitivityPackage.VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER,
                    oldBasicComponent__VariableUsageParameter, basicComponent__VariableUsageParameter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean SystemCallParameterMustHaveStringSequence(DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SensitivityValidator.DIAGNOSTIC_SOURCE,
                        SensitivityValidator.VARIABLE_USAGE_PARAMETER__SYSTEM_CALL_PARAMETER_MUST_HAVE_STRING_SEQUENCE,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] {
                                        "SystemCallParameterMustHaveStringSequence",
                                        EObjectValidator.getObjectLabel(this, context)
                                }), new Object[] {
                            this
                        }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_NAME:
            return getVariableName();
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER:
            if (resolve)
                return getEntryLevelSystemCall__VariableUsageParameter();
            return basicGetEntryLevelSystemCall__VariableUsageParameter();
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER:
            return getVariableCharacterisationType__VariableUsageParameter();
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER:
            return getVariableUsageType__VariableUsageParameter();
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER:
            if (resolve)
                return getBasicComponent__VariableUsageParameter();
            return basicGetBasicComponent__VariableUsageParameter();
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
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_NAME:
            setVariableName((String) newValue);
            return;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER:
            setEntryLevelSystemCall__VariableUsageParameter((EntryLevelSystemCall) newValue);
            return;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER:
            setVariableCharacterisationType__VariableUsageParameter((VariableCharacterisationType) newValue);
            return;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER:
            setVariableUsageType__VariableUsageParameter((VariableUsageType) newValue);
            return;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER:
            setBasicComponent__VariableUsageParameter((BasicComponent) newValue);
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
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_NAME:
            setVariableName(VARIABLE_NAME_EDEFAULT);
            return;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER:
            setEntryLevelSystemCall__VariableUsageParameter((EntryLevelSystemCall) null);
            return;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER:
            setVariableCharacterisationType__VariableUsageParameter(VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT);
            return;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER:
            setVariableUsageType__VariableUsageParameter(VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT);
            return;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER:
            setBasicComponent__VariableUsageParameter((BasicComponent) null);
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
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_NAME:
            return VARIABLE_NAME_EDEFAULT == null ? variableName != null : !VARIABLE_NAME_EDEFAULT.equals(variableName);
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__ENTRY_LEVEL_SYSTEM_CALL_VARIABLE_USAGE_PARAMETER:
            return entryLevelSystemCall__VariableUsageParameter != null;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER:
            return variableCharacterisationType__VariableUsageParameter != VARIABLE_CHARACTERISATION_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER:
            return variableUsageType__VariableUsageParameter != VARIABLE_USAGE_TYPE_VARIABLE_USAGE_PARAMETER_EDEFAULT;
        case SensitivityPackage.VARIABLE_USAGE_PARAMETER__BASIC_COMPONENT_VARIABLE_USAGE_PARAMETER:
            return basicComponent__VariableUsageParameter != null;
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
        result.append(" (VariableName: ");
        result.append(variableName);
        result.append(", variableCharacterisationType__VariableUsageParameter: ");
        result.append(variableCharacterisationType__VariableUsageParameter);
        result.append(", variableUsageType__VariableUsageParameter: ");
        result.append(variableUsageType__VariableUsageParameter);
        result.append(')');
        return result.toString();
    }

} // VariableUsageParameterImpl
