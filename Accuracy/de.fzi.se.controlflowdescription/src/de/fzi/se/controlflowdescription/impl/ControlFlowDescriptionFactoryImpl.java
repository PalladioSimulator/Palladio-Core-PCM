/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.impl;

import de.fzi.se.controlflowdescription.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ControlFlowDescriptionFactoryImpl extends EFactoryImpl implements ControlFlowDescriptionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ControlFlowDescriptionFactory init() {
		try {
			ControlFlowDescriptionFactory theControlFlowDescriptionFactory = (ControlFlowDescriptionFactory)EPackage.Registry.INSTANCE.getEFactory("http://se.fzi.de/ControlFlowDescription/0.6"); 
			if (theControlFlowDescriptionFactory != null) {
				return theControlFlowDescriptionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ControlFlowDescriptionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescriptionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION: return createControlFlowDescription();
			case ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTIONS: return createControlFlowDescriptions();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescription createControlFlowDescription() {
		ControlFlowDescriptionImpl controlFlowDescription = new ControlFlowDescriptionImpl();
		return controlFlowDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescriptions createControlFlowDescriptions() {
		ControlFlowDescriptionsImpl controlFlowDescriptions = new ControlFlowDescriptionsImpl();
		return controlFlowDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescriptionPackage getControlFlowDescriptionPackage() {
		return (ControlFlowDescriptionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ControlFlowDescriptionPackage getPackage() {
		return ControlFlowDescriptionPackage.eINSTANCE;
	}

} //ControlFlowDescriptionFactoryImpl
