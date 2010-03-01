/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package copyException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see copyException.CopyExceptionFactory
 * @model kind="package"
 * @generated
 */
public interface CopyExceptionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "copyException";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.xtext.org/example/CopyException";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "copyException";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CopyExceptionPackage eINSTANCE = copyException.impl.CopyExceptionPackageImpl.init();

	/**
	 * The meta object id for the '{@link copyException.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see copyException.impl.ModelImpl
	 * @see copyException.impl.CopyExceptionPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__EXCEPTIONS = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link copyException.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see copyException.impl.ImportImpl
	 * @see copyException.impl.CopyExceptionPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORT_URI = 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link copyException.impl.ExceptionImpl <em>Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see copyException.impl.ExceptionImpl
	 * @see copyException.impl.CopyExceptionPackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 2;

	/**
	 * The number of structural features of the '<em>Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link copyException.impl.DeletionExceptionImpl <em>Deletion Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see copyException.impl.DeletionExceptionImpl
	 * @see copyException.impl.CopyExceptionPackageImpl#getDeletionException()
	 * @generated
	 */
	int DELETION_EXCEPTION = 3;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETION_EXCEPTION__OBJECT = EXCEPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ocle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETION_EXCEPTION__OCLE = EXCEPTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Deletion Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETION_EXCEPTION_FEATURE_COUNT = EXCEPTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link copyException.impl.ReplacementExceptionImpl <em>Replacement Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see copyException.impl.ReplacementExceptionImpl
	 * @see copyException.impl.CopyExceptionPackageImpl#getReplacementException()
	 * @generated
	 */
	int REPLACEMENT_EXCEPTION = 4;

	/**
	 * The feature id for the '<em><b>Obj</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_EXCEPTION__OBJ = EXCEPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Replacement Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACEMENT_EXCEPTION_FEATURE_COUNT = EXCEPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link copyException.impl.ReferenceExceptionImpl <em>Reference Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see copyException.impl.ReferenceExceptionImpl
	 * @see copyException.impl.CopyExceptionPackageImpl#getReferenceException()
	 * @generated
	 */
	int REFERENCE_EXCEPTION = 5;

	/**
	 * The feature id for the '<em><b>O</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EXCEPTION__O = EXCEPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EXCEPTION_FEATURE_COUNT = EXCEPTION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link copyException.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see copyException.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link copyException.Model#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see copyException.Model#getImports()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link copyException.Model#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exceptions</em>'.
	 * @see copyException.Model#getExceptions()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Exceptions();

	/**
	 * Returns the meta object for class '{@link copyException.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see copyException.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link copyException.Import#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see copyException.Import#getImportURI()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportURI();

	/**
	 * Returns the meta object for class '{@link copyException.Exception <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception</em>'.
	 * @see copyException.Exception
	 * @generated
	 */
	EClass getException();

	/**
	 * Returns the meta object for class '{@link copyException.DeletionException <em>Deletion Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deletion Exception</em>'.
	 * @see copyException.DeletionException
	 * @generated
	 */
	EClass getDeletionException();

	/**
	 * Returns the meta object for the reference '{@link copyException.DeletionException#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see copyException.DeletionException#getObject()
	 * @see #getDeletionException()
	 * @generated
	 */
	EReference getDeletionException_Object();

	/**
	 * Returns the meta object for the attribute '{@link copyException.DeletionException#getOcle <em>Ocle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ocle</em>'.
	 * @see copyException.DeletionException#getOcle()
	 * @see #getDeletionException()
	 * @generated
	 */
	EAttribute getDeletionException_Ocle();

	/**
	 * Returns the meta object for class '{@link copyException.ReplacementException <em>Replacement Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replacement Exception</em>'.
	 * @see copyException.ReplacementException
	 * @generated
	 */
	EClass getReplacementException();

	/**
	 * Returns the meta object for the reference '{@link copyException.ReplacementException#getObj <em>Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj</em>'.
	 * @see copyException.ReplacementException#getObj()
	 * @see #getReplacementException()
	 * @generated
	 */
	EReference getReplacementException_Obj();

	/**
	 * Returns the meta object for class '{@link copyException.ReferenceException <em>Reference Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Exception</em>'.
	 * @see copyException.ReferenceException
	 * @generated
	 */
	EClass getReferenceException();

	/**
	 * Returns the meta object for the reference '{@link copyException.ReferenceException#getO <em>O</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>O</em>'.
	 * @see copyException.ReferenceException#getO()
	 * @see #getReferenceException()
	 * @generated
	 */
	EReference getReferenceException_O();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CopyExceptionFactory getCopyExceptionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link copyException.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see copyException.impl.ModelImpl
		 * @see copyException.impl.CopyExceptionPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__EXCEPTIONS = eINSTANCE.getModel_Exceptions();

		/**
		 * The meta object literal for the '{@link copyException.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see copyException.impl.ImportImpl
		 * @see copyException.impl.CopyExceptionPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

		/**
		 * The meta object literal for the '{@link copyException.impl.ExceptionImpl <em>Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see copyException.impl.ExceptionImpl
		 * @see copyException.impl.CopyExceptionPackageImpl#getException()
		 * @generated
		 */
		EClass EXCEPTION = eINSTANCE.getException();

		/**
		 * The meta object literal for the '{@link copyException.impl.DeletionExceptionImpl <em>Deletion Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see copyException.impl.DeletionExceptionImpl
		 * @see copyException.impl.CopyExceptionPackageImpl#getDeletionException()
		 * @generated
		 */
		EClass DELETION_EXCEPTION = eINSTANCE.getDeletionException();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETION_EXCEPTION__OBJECT = eINSTANCE.getDeletionException_Object();

		/**
		 * The meta object literal for the '<em><b>Ocle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELETION_EXCEPTION__OCLE = eINSTANCE.getDeletionException_Ocle();

		/**
		 * The meta object literal for the '{@link copyException.impl.ReplacementExceptionImpl <em>Replacement Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see copyException.impl.ReplacementExceptionImpl
		 * @see copyException.impl.CopyExceptionPackageImpl#getReplacementException()
		 * @generated
		 */
		EClass REPLACEMENT_EXCEPTION = eINSTANCE.getReplacementException();

		/**
		 * The meta object literal for the '<em><b>Obj</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLACEMENT_EXCEPTION__OBJ = eINSTANCE.getReplacementException_Obj();

		/**
		 * The meta object literal for the '{@link copyException.impl.ReferenceExceptionImpl <em>Reference Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see copyException.impl.ReferenceExceptionImpl
		 * @see copyException.impl.CopyExceptionPackageImpl#getReferenceException()
		 * @generated
		 */
		EClass REFERENCE_EXCEPTION = eINSTANCE.getReferenceException();

		/**
		 * The meta object literal for the '<em><b>O</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_EXCEPTION__O = eINSTANCE.getReferenceException_O();

	}

} //CopyExceptionPackage
