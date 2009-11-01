/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage
 * @generated
 */
public class SourcecodedecoratorAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SourcecodedecoratorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcecodedecoratorAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SourcecodedecoratorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourcecodedecoratorSwitch<Adapter> modelSwitch =
		new SourcecodedecoratorSwitch<Adapter>() {
			@Override
			public Adapter caseSourceCodeID(SourceCodeID object) {
				return createSourceCodeIDAdapter();
			}
			@Override
			public Adapter caseFileLevelSourceCodeLink(FileLevelSourceCodeLink object) {
				return createFileLevelSourceCodeLinkAdapter();
			}
			@Override
			public Adapter caseSourceFile(SourceFile object) {
				return createSourceFileAdapter();
			}
			@Override
			public Adapter caseMethods(Methods object) {
				return createMethodsAdapter();
			}
			@Override
			public Adapter caseMethodLevelSourceCodeLink(MethodLevelSourceCodeLink object) {
				return createMethodLevelSourceCodeLinkAdapter();
			}
			@Override
			public Adapter caseControlFlowLevelSourceCodeLink(ControlFlowLevelSourceCodeLink object) {
				return createControlFlowLevelSourceCodeLinkAdapter();
			}
			@Override
			public Adapter caseControlFlow(ControlFlow object) {
				return createControlFlowAdapter();
			}
			@Override
			public Adapter caseSourceCodeDecoratorRepository(SourceCodeDecoratorRepository object) {
				return createSourceCodeDecoratorRepositoryAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID <em>Source Code ID</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID
	 * @generated
	 */
	public Adapter createSourceCodeIDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink <em>File Level Source Code Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink
	 * @generated
	 */
	public Adapter createFileLevelSourceCodeLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile <em>Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile
	 * @generated
	 */
	public Adapter createSourceFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods
	 * @generated
	 */
	public Adapter createMethodsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink <em>Method Level Source Code Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink
	 * @generated
	 */
	public Adapter createMethodLevelSourceCodeLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink <em>Control Flow Level Source Code Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink
	 * @generated
	 */
	public Adapter createControlFlowLevelSourceCodeLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlow <em>Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlow
	 * @generated
	 */
	public Adapter createControlFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository <em>Source Code Decorator Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository
	 * @generated
	 */
	public Adapter createSourceCodeDecoratorRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SourcecodedecoratorAdapterFactory
