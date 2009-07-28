/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator.impl;

import SourceCodeDecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink;
import SourceCodeDecorator.sourcecodedecorator.FileLevelSourceCodeLink;
import SourceCodeDecorator.sourcecodedecorator.MethodLevelSourceCodeLink;
import SourceCodeDecorator.sourcecodedecorator.SourceCodeDecoratorRepository;
import SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Code Decorator Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl#getFilelevelsourcecodelink <em>Filelevelsourcecodelink</em>}</li>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl#getMethodlevelsourcecodelink <em>Methodlevelsourcecodelink</em>}</li>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl#getControlflowlevelsourcecodelink <em>Controlflowlevelsourcecodelink</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceCodeDecoratorRepositoryImpl extends IdentifierImpl implements SourceCodeDecoratorRepository {
	/**
	 * The cached value of the '{@link #getFilelevelsourcecodelink() <em>Filelevelsourcecodelink</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilelevelsourcecodelink()
	 * @generated
	 * @ordered
	 */
	protected EList<FileLevelSourceCodeLink> filelevelsourcecodelink;

	/**
	 * The cached value of the '{@link #getMethodlevelsourcecodelink() <em>Methodlevelsourcecodelink</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodlevelsourcecodelink()
	 * @generated
	 * @ordered
	 */
	protected EList<MethodLevelSourceCodeLink> methodlevelsourcecodelink;

	/**
	 * The cached value of the '{@link #getControlflowlevelsourcecodelink() <em>Controlflowlevelsourcecodelink</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlflowlevelsourcecodelink()
	 * @generated
	 * @ordered
	 */
	protected EList<ControlFlowLevelSourceCodeLink> controlflowlevelsourcecodelink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceCodeDecoratorRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcecodedecoratorPackage.Literals.SOURCE_CODE_DECORATOR_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FileLevelSourceCodeLink> getFilelevelsourcecodelink() {
		if (filelevelsourcecodelink == null) {
			filelevelsourcecodelink = new EObjectContainmentEList<FileLevelSourceCodeLink>(FileLevelSourceCodeLink.class, this, SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK);
		}
		return filelevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MethodLevelSourceCodeLink> getMethodlevelsourcecodelink() {
		if (methodlevelsourcecodelink == null) {
			methodlevelsourcecodelink = new EObjectContainmentEList<MethodLevelSourceCodeLink>(MethodLevelSourceCodeLink.class, this, SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK);
		}
		return methodlevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControlFlowLevelSourceCodeLink> getControlflowlevelsourcecodelink() {
		if (controlflowlevelsourcecodelink == null) {
			controlflowlevelsourcecodelink = new EObjectContainmentEList<ControlFlowLevelSourceCodeLink>(ControlFlowLevelSourceCodeLink.class, this, SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK);
		}
		return controlflowlevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK:
				return ((InternalEList<?>)getFilelevelsourcecodelink()).basicRemove(otherEnd, msgs);
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK:
				return ((InternalEList<?>)getMethodlevelsourcecodelink()).basicRemove(otherEnd, msgs);
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK:
				return ((InternalEList<?>)getControlflowlevelsourcecodelink()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK:
				return getFilelevelsourcecodelink();
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK:
				return getMethodlevelsourcecodelink();
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK:
				return getControlflowlevelsourcecodelink();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK:
				getFilelevelsourcecodelink().clear();
				getFilelevelsourcecodelink().addAll((Collection<? extends FileLevelSourceCodeLink>)newValue);
				return;
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK:
				getMethodlevelsourcecodelink().clear();
				getMethodlevelsourcecodelink().addAll((Collection<? extends MethodLevelSourceCodeLink>)newValue);
				return;
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK:
				getControlflowlevelsourcecodelink().clear();
				getControlflowlevelsourcecodelink().addAll((Collection<? extends ControlFlowLevelSourceCodeLink>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK:
				getFilelevelsourcecodelink().clear();
				return;
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK:
				getMethodlevelsourcecodelink().clear();
				return;
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK:
				getControlflowlevelsourcecodelink().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK:
				return filelevelsourcecodelink != null && !filelevelsourcecodelink.isEmpty();
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK:
				return methodlevelsourcecodelink != null && !methodlevelsourcecodelink.isEmpty();
			case SourcecodedecoratorPackage.SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK:
				return controlflowlevelsourcecodelink != null && !controlflowlevelsourcecodelink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SourceCodeDecoratorRepositoryImpl
