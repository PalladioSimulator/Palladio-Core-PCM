/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.PCMLink.impl;

import SourceCodeDecorator.PCMLink.*;

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
public class PCMLinkFactoryImpl extends EFactoryImpl implements PCMLinkFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PCMLinkFactory init() {
		try {
			PCMLinkFactory thePCMLinkFactory = (PCMLinkFactory)EPackage.Registry.INSTANCE.getEFactory("http:///SourceCodeDecorator/PCMLink.ecore"); 
			if (thePCMLinkFactory != null) {
				return thePCMLinkFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PCMLinkFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMLinkFactoryImpl() {
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
			case PCMLinkPackage.COMPONENT_FILE_LINK: return createComponentFileLink();
			case PCMLinkPackage.SEFF_METHOD_LINK: return createSEFFMethodLink();
			case PCMLinkPackage.ACTION_CONTROL_FLOW_LINK: return createActionControlFlowLink();
			case PCMLinkPackage.PCM_LINK_REPOSITORY: return createPCMLinkRepository();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentFileLink createComponentFileLink() {
		ComponentFileLinkImpl componentFileLink = new ComponentFileLinkImpl();
		return componentFileLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SEFFMethodLink createSEFFMethodLink() {
		SEFFMethodLinkImpl seffMethodLink = new SEFFMethodLinkImpl();
		return seffMethodLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionControlFlowLink createActionControlFlowLink() {
		ActionControlFlowLinkImpl actionControlFlowLink = new ActionControlFlowLinkImpl();
		return actionControlFlowLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMLinkRepository createPCMLinkRepository() {
		PCMLinkRepositoryImpl pcmLinkRepository = new PCMLinkRepositoryImpl();
		return pcmLinkRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMLinkPackage getPCMLinkPackage() {
		return (PCMLinkPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PCMLinkPackage getPackage() {
		return PCMLinkPackage.eINSTANCE;
	}

} //PCMLinkFactoryImpl
