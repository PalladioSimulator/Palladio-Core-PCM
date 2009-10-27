/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator.impl;

import SourceCodeDecorator.sourcecodedecorator.FileLevelSourceCodeLink;
import SourceCodeDecorator.sourcecodedecorator.SourceFile;
import SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Level Source Code Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.impl.FileLevelSourceCodeLinkImpl#getSourcefiles <em>Sourcefiles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileLevelSourceCodeLinkImpl extends SourceCodeIDImpl implements FileLevelSourceCodeLink {
	/**
	 * The cached value of the '{@link #getSourcefiles() <em>Sourcefiles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcefiles()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceFile> sourcefiles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileLevelSourceCodeLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcecodedecoratorPackage.Literals.FILE_LEVEL_SOURCE_CODE_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceFile> getSourcefiles() {
		if (sourcefiles == null) {
			sourcefiles = new EObjectResolvingEList<SourceFile>(SourceFile.class, this, SourcecodedecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES);
		}
		return sourcefiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcecodedecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES:
				return getSourcefiles();
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
			case SourcecodedecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES:
				getSourcefiles().clear();
				getSourcefiles().addAll((Collection<? extends SourceFile>)newValue);
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
			case SourcecodedecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES:
				getSourcefiles().clear();
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
			case SourcecodedecoratorPackage.FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES:
				return sourcefiles != null && !sourcefiles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FileLevelSourceCodeLinkImpl
