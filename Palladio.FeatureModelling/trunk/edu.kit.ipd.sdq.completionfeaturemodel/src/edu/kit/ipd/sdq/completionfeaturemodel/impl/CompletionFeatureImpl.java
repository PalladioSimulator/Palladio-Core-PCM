/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel.impl;

import QVTRelation.Relation;

import de.uka.ipd.sdq.featuremodel.impl.FeatureImpl;

import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature;
import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram;
import edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule;
import edu.kit.ipd.sdq.completionfeaturemodel.FeatureState;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl#getCopyException <em>Copy Exception</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl#getDisambiguationRule <em>Disambiguation Rule</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl#getTransformationFragment <em>Transformation Fragment</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl#getFeatureState <em>Feature State</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl#getCompletionFeatureDiagram <em>Completion Feature Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletionFeatureImpl extends FeatureImpl implements CompletionFeature {
	/**
	 * The cached value of the '{@link #getCopyException() <em>Copy Exception</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyException()
	 * @generated
	 * @ordered
	 */
	protected EList<copyException.Exception> copyException;

	/**
	 * The cached value of the '{@link #getDisambiguationRule() <em>Disambiguation Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisambiguationRule()
	 * @generated
	 * @ordered
	 */
	protected EList<DisambiguationRule> disambiguationRule;

	/**
	 * The cached value of the '{@link #getTransformationFragment() <em>Transformation Fragment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationFragment()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> transformationFragment;

	/**
	 * The default value of the '{@link #getFeatureState() <em>Feature State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureState()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureState FEATURE_STATE_EDEFAULT = FeatureState.NOT_SET;

	/**
	 * The cached value of the '{@link #getCompletionFeatureDiagram() <em>Completion Feature Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionFeatureDiagram()
	 * @generated
	 * @ordered
	 */
	protected CompletionFeatureDiagram completionFeatureDiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompletionFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return completionfeaturemodelPackage.Literals.COMPLETION_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<copyException.Exception> getCopyException() {
		if (copyException == null) {
			copyException = new EObjectContainmentEList<copyException.Exception>(copyException.Exception.class, this, completionfeaturemodelPackage.COMPLETION_FEATURE__COPY_EXCEPTION);
		}
		return copyException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DisambiguationRule> getDisambiguationRule() {
		if (disambiguationRule == null) {
			disambiguationRule = new EObjectContainmentEList<DisambiguationRule>(DisambiguationRule.class, this, completionfeaturemodelPackage.COMPLETION_FEATURE__DISAMBIGUATION_RULE);
		}
		return disambiguationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getTransformationFragment() {
		if (transformationFragment == null) {
			transformationFragment = new EObjectContainmentEList<Relation>(Relation.class, this, completionfeaturemodelPackage.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT);
		}
		return transformationFragment;
	}


	/**
	 * <!-- begin-user-doc -->
	 * returns the result of showFeatureState()
	 * showFeatureState is defined by an OCL expression.
	 * The FeatureState of a CompletionFeature is MANDATORY, if the CompletionFeature is included in its simpleMandatory.mandatoryChildren.
	 * It is OPTIONAL, if it is included in its simpleOptional.optionalChildren.
	 * If neither of these conditions applies, the FeatureState is NOT_SET.
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FeatureState getFeatureState() {
		return showFeatureState();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionFeatureDiagram getCompletionFeatureDiagram() {
		if (completionFeatureDiagram != null && completionFeatureDiagram.eIsProxy()) {
			InternalEObject oldCompletionFeatureDiagram = (InternalEObject)completionFeatureDiagram;
			completionFeatureDiagram = (CompletionFeatureDiagram)eResolveProxy(oldCompletionFeatureDiagram);
			if (completionFeatureDiagram != oldCompletionFeatureDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, completionfeaturemodelPackage.COMPLETION_FEATURE__COMPLETION_FEATURE_DIAGRAM, oldCompletionFeatureDiagram, completionFeatureDiagram));
			}
		}
		return completionFeatureDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionFeatureDiagram basicGetCompletionFeatureDiagram() {
		return completionFeatureDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionFeatureDiagram(CompletionFeatureDiagram newCompletionFeatureDiagram) {
		CompletionFeatureDiagram oldCompletionFeatureDiagram = completionFeatureDiagram;
		completionFeatureDiagram = newCompletionFeatureDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, completionfeaturemodelPackage.COMPLETION_FEATURE__COMPLETION_FEATURE_DIAGRAM, oldCompletionFeatureDiagram, completionFeatureDiagram));
	}

	/**
	 * The cached OCL expression body for the '{@link #showFeatureState() <em>Show Feature State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #showFeatureState()
	 * @generated
	 * @ordered
	 */
	protected static final String SHOW_FEATURE_STATE__EOCL_EXP = "if (simpleMandatory->size() = 1 and simpleMandatory.mandatoryChildren->size() > 0 and simpleMandatory.mandatoryChildren->includes(self)) then FeatureState::MANDATORY"+
" else ("+
" if (simpleOptional->size() = 1 and simpleOptional.optionalChildren->size() > 0 and simpleOptional.optionalChildren->includes(self)) then FeatureState::OPTIONAL"+
" else FeatureState::NOT_SET"+
" endif"+
" ) endif";

	/**
	 * The cached OCL query for the '{@link #showFeatureState() <em>Show Feature State</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #showFeatureState()
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> SHOW_FEATURE_STATE__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureState showFeatureState() {
		if (SHOW_FEATURE_STATE__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(completionfeaturemodelPackage.Literals.COMPLETION_FEATURE, completionfeaturemodelPackage.Literals.COMPLETION_FEATURE.getEAllOperations().get(2));
			try {
				SHOW_FEATURE_STATE__EOCL_QRY = helper.createQuery(SHOW_FEATURE_STATE__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(SHOW_FEATURE_STATE__EOCL_QRY);
		return (FeatureState) query.evaluate(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COPY_EXCEPTION:
				return ((InternalEList<?>)getCopyException()).basicRemove(otherEnd, msgs);
			case completionfeaturemodelPackage.COMPLETION_FEATURE__DISAMBIGUATION_RULE:
				return ((InternalEList<?>)getDisambiguationRule()).basicRemove(otherEnd, msgs);
			case completionfeaturemodelPackage.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT:
				return ((InternalEList<?>)getTransformationFragment()).basicRemove(otherEnd, msgs);
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COPY_EXCEPTION:
				return getCopyException();
			case completionfeaturemodelPackage.COMPLETION_FEATURE__DISAMBIGUATION_RULE:
				return getDisambiguationRule();
			case completionfeaturemodelPackage.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT:
				return getTransformationFragment();
			case completionfeaturemodelPackage.COMPLETION_FEATURE__FEATURE_STATE:
				return getFeatureState();
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COMPLETION_FEATURE_DIAGRAM:
				if (resolve) return getCompletionFeatureDiagram();
				return basicGetCompletionFeatureDiagram();
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COPY_EXCEPTION:
				getCopyException().clear();
				getCopyException().addAll((Collection<? extends copyException.Exception>)newValue);
				return;
			case completionfeaturemodelPackage.COMPLETION_FEATURE__DISAMBIGUATION_RULE:
				getDisambiguationRule().clear();
				getDisambiguationRule().addAll((Collection<? extends DisambiguationRule>)newValue);
				return;
			case completionfeaturemodelPackage.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT:
				getTransformationFragment().clear();
				getTransformationFragment().addAll((Collection<? extends Relation>)newValue);
				return;
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COMPLETION_FEATURE_DIAGRAM:
				setCompletionFeatureDiagram((CompletionFeatureDiagram)newValue);
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COPY_EXCEPTION:
				getCopyException().clear();
				return;
			case completionfeaturemodelPackage.COMPLETION_FEATURE__DISAMBIGUATION_RULE:
				getDisambiguationRule().clear();
				return;
			case completionfeaturemodelPackage.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT:
				getTransformationFragment().clear();
				return;
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COMPLETION_FEATURE_DIAGRAM:
				setCompletionFeatureDiagram((CompletionFeatureDiagram)null);
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COPY_EXCEPTION:
				return copyException != null && !copyException.isEmpty();
			case completionfeaturemodelPackage.COMPLETION_FEATURE__DISAMBIGUATION_RULE:
				return disambiguationRule != null && !disambiguationRule.isEmpty();
			case completionfeaturemodelPackage.COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT:
				return transformationFragment != null && !transformationFragment.isEmpty();
			case completionfeaturemodelPackage.COMPLETION_FEATURE__FEATURE_STATE:
				return getFeatureState() != FEATURE_STATE_EDEFAULT;
			case completionfeaturemodelPackage.COMPLETION_FEATURE__COMPLETION_FEATURE_DIAGRAM:
				return completionFeatureDiagram != null;
		}
		return super.eIsSet(featureID);
	}

} //CompletionFeatureImpl
