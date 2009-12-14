/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package copyException.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import copyException.CopyExceptionFactory;
import copyException.CopyExceptionPackage;
import copyException.Deletion;
import copyException.Import;
import copyException.Model;
import copyException.Reference;
import copyException.Replacement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CopyExceptionFactoryImpl extends EFactoryImpl implements CopyExceptionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CopyExceptionFactory init() {
		try {
			CopyExceptionFactory theCopyExceptionFactory = (CopyExceptionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.xtext.org/example/CopyException"); 
			if (theCopyExceptionFactory != null) {
				return theCopyExceptionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CopyExceptionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopyExceptionFactoryImpl() {
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
			case CopyExceptionPackage.MODEL: return createModel();
			case CopyExceptionPackage.IMPORT: return createImport();
			case CopyExceptionPackage.EXCEPTION: return createException();
			case CopyExceptionPackage.DELETION: return createDeletion();
			case CopyExceptionPackage.REPLACEMENT: return createReplacement();
			case CopyExceptionPackage.REFERENCE: return createReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public copyException.Exception createException() {
		ExceptionImpl exception = new ExceptionImpl();
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deletion createDeletion() {
		DeletionImpl deletion = new DeletionImpl();
		return deletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Replacement createReplacement() {
		ReplacementImpl replacement = new ReplacementImpl();
		return replacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopyExceptionPackage getCopyExceptionPackage() {
		return (CopyExceptionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CopyExceptionPackage getPackage() {
		return CopyExceptionPackage.eINSTANCE;
	}

} //CopyExceptionFactoryImpl
