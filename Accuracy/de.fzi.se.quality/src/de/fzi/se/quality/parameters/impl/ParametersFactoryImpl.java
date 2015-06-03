/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParametersFactory;
import de.fzi.se.quality.parameters.ParametersPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ParametersFactoryImpl extends EFactoryImpl implements ParametersFactory {

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static ParametersFactory init() {
        try {
            final ParametersFactory theParametersFactory = (ParametersFactory) EPackage.Registry.INSTANCE
                    .getEFactory(ParametersPackage.eNS_URI);
            if (theParametersFactory != null) {
                return theParametersFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ParametersFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ParametersFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case ParametersPackage.PARAMETER_INSTANCE:
            return this.createParameterInstance();
        case ParametersPackage.CALL_INSTANCE:
            return this.createCallInstance();
        case ParametersPackage.COMPONENT_INSTANCE:
            return this.createComponentInstance();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ParameterInstance createParameterInstance() {
        final ParameterInstanceImpl parameterInstance = new ParameterInstanceImpl();
        return parameterInstance;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CallInstance createCallInstance() {
        final CallInstanceImpl callInstance = new CallInstanceImpl();
        return callInstance;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComponentInstance createComponentInstance() {
        final ComponentInstanceImpl componentInstance = new ComponentInstanceImpl();
        return componentInstance;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ParametersPackage getParametersPackage() {
        return (ParametersPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ParametersPackage getPackage() {
        return ParametersPackage.eINSTANCE;
    }

} // ParametersFactoryImpl
