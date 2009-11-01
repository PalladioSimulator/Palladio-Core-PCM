/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.*;

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
public class SourcecodedecoratorFactoryImpl extends EFactoryImpl implements SourcecodedecoratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SourcecodedecoratorFactory init() {
		try {
			SourcecodedecoratorFactory theSourcecodedecoratorFactory = (SourcecodedecoratorFactory)EPackage.Registry.INSTANCE.getEFactory("http:///SourceCodeDecorator/sourcecodedecorator.ecore"); 
			if (theSourcecodedecoratorFactory != null) {
				return theSourcecodedecoratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SourcecodedecoratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcecodedecoratorFactoryImpl() {
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
			case SourcecodedecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK: return createFileLevelSourceCodeLink();
			case SourcecodedecoratorPackage.SOURCE_FILE: return createSourceFile();
			case SourcecodedecoratorPackage.METHODS: return createMethods();
			case SourcecodedecoratorPackage.METHOD_LEVEL_SOURCE_CODE_LINK: return createMethodLevelSourceCodeLink();
			case SourcecodedecoratorPackage.CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK: return createControlFlowLevelSourceCodeLink();
			case SourcecodedecoratorPackage.CONTROL_FLOW: return createControlFlow();
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY: return createSourceCodeDecoratorRepository();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileLevelSourceCodeLink createFileLevelSourceCodeLink() {
		FileLevelSourceCodeLinkImpl fileLevelSourceCodeLink = new FileLevelSourceCodeLinkImpl();
		return fileLevelSourceCodeLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFile createSourceFile() {
		SourceFileImpl sourceFile = new SourceFileImpl();
		return sourceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Methods createMethods() {
		MethodsImpl methods = new MethodsImpl();
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodLevelSourceCodeLink createMethodLevelSourceCodeLink() {
		MethodLevelSourceCodeLinkImpl methodLevelSourceCodeLink = new MethodLevelSourceCodeLinkImpl();
		return methodLevelSourceCodeLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowLevelSourceCodeLink createControlFlowLevelSourceCodeLink() {
		ControlFlowLevelSourceCodeLinkImpl controlFlowLevelSourceCodeLink = new ControlFlowLevelSourceCodeLinkImpl();
		return controlFlowLevelSourceCodeLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow createControlFlow() {
		ControlFlowImpl controlFlow = new ControlFlowImpl();
		return controlFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceCodeDecoratorRepository createSourceCodeDecoratorRepository() {
		SourceCodeDecoratorRepositoryImpl sourceCodeDecoratorRepository = new SourceCodeDecoratorRepositoryImpl();
		return sourceCodeDecoratorRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcecodedecoratorPackage getSourcecodedecoratorPackage() {
		return (SourcecodedecoratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SourcecodedecoratorPackage getPackage() {
		return SourcecodedecoratorPackage.eINSTANCE;
	}

} //SourcecodedecoratorFactoryImpl
