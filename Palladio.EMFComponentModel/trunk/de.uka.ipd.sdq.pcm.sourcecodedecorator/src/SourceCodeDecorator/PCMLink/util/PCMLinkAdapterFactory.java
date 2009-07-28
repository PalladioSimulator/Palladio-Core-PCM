/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.PCMLink.util;

import SourceCodeDecorator.PCMLink.*;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see SourceCodeDecorator.PCMLink.PCMLinkPackage
 * @generated
 */
public class PCMLinkAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PCMLinkPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMLinkAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PCMLinkPackage.eINSTANCE;
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
	protected PCMLinkSwitch<Adapter> modelSwitch =
		new PCMLinkSwitch<Adapter>() {
			@Override
			public Adapter caseComponentFileLink(ComponentFileLink object) {
				return createComponentFileLinkAdapter();
			}
			@Override
			public Adapter caseSEFFMethodLink(SEFFMethodLink object) {
				return createSEFFMethodLinkAdapter();
			}
			@Override
			public Adapter caseActionControlFlowLink(ActionControlFlowLink object) {
				return createActionControlFlowLinkAdapter();
			}
			@Override
			public Adapter casePCMLinkRepository(PCMLinkRepository object) {
				return createPCMLinkRepositoryAdapter();
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
	 * Creates a new adapter for an object of class '{@link SourceCodeDecorator.PCMLink.ComponentFileLink <em>Component File Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SourceCodeDecorator.PCMLink.ComponentFileLink
	 * @generated
	 */
	public Adapter createComponentFileLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SourceCodeDecorator.PCMLink.SEFFMethodLink <em>SEFF Method Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SourceCodeDecorator.PCMLink.SEFFMethodLink
	 * @generated
	 */
	public Adapter createSEFFMethodLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SourceCodeDecorator.PCMLink.ActionControlFlowLink <em>Action Control Flow Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SourceCodeDecorator.PCMLink.ActionControlFlowLink
	 * @generated
	 */
	public Adapter createActionControlFlowLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SourceCodeDecorator.PCMLink.PCMLinkRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SourceCodeDecorator.PCMLink.PCMLinkRepository
	 * @generated
	 */
	public Adapter createPCMLinkRepositoryAdapter() {
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

} //PCMLinkAdapterFactory
