/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.*;

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
public class PCMLinkRepositoryFactoryImpl extends EFactoryImpl implements PCMLinkRepositoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PCMLinkRepositoryFactory init() {
		try {
			PCMLinkRepositoryFactory thePCMLinkRepositoryFactory = (PCMLinkRepositoryFactory)EPackage.Registry.INSTANCE.getEFactory("http:///SourceCodeDecorator/PCMLinkRepository.ecore"); 
			if (thePCMLinkRepositoryFactory != null) {
				return thePCMLinkRepositoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PCMLinkRepositoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMLinkRepositoryFactoryImpl() {
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
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY: return createPCMLinkRepository();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public PCMLinkRepositoryPackage getPCMLinkRepositoryPackage() {
		return (PCMLinkRepositoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PCMLinkRepositoryPackage getPackage() {
		return PCMLinkRepositoryPackage.eINSTANCE;
	}

} //PCMLinkRepositoryFactoryImpl
