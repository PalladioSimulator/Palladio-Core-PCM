/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.*;

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
public class GastPcmLinkFactoryImpl extends EFactoryImpl implements GastPcmLinkFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GastPcmLinkFactory init() {
		try {
			GastPcmLinkFactory theGastPcmLinkFactory = (GastPcmLinkFactory)EPackage.Registry.INSTANCE.getEFactory("http:///SourceCodeDecorator/GastPcmLink.ecore"); 
			if (theGastPcmLinkFactory != null) {
				return theGastPcmLinkFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GastPcmLinkFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GastPcmLinkFactoryImpl() {
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
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK: return createInternalActionLink();
			case GastPcmLinkPackage.PARAMETER_LINK: return createParameterLink();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalActionLink createInternalActionLink() {
		InternalActionLinkImpl internalActionLink = new InternalActionLinkImpl();
		return internalActionLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterLink createParameterLink() {
		ParameterLinkImpl parameterLink = new ParameterLinkImpl();
		return parameterLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GastPcmLinkPackage getGastPcmLinkPackage() {
		return (GastPcmLinkPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GastPcmLinkPackage getPackage() {
		return GastPcmLinkPackage.eINSTANCE;
	}

} //GastPcmLinkFactoryImpl
